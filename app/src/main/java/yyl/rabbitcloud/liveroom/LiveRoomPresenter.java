package yyl.rabbitcloud.liveroom;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;
import yyl.rabbitcloud.base.RxPresenter;
import yyl.rabbitcloud.http.RabbitApi;
import yyl.rabbitcloud.liveroom.bean.DanMuDataBean;
import yyl.rabbitcloud.liveroom.bean.LiveChatInfoBean;
import yyl.rabbitcloud.liveroom.bean.LiveRoomBean;
import yyl.rabbitcloud.util.DanmuUtil;

/**
 * Created by yyl on 2017/6/23.
 */

public class LiveRoomPresenter extends RxPresenter<LiveRoomContract.View>
        implements LiveRoomContract.Presenter<LiveRoomContract.View> {

    /**********************
     * 以下是弹幕Socket连接相关
     *****************/
    private List<String> chatRoomList = new ArrayList<>();
    private String socketIP;
    private int socketPort;
    private boolean isConnectSuccess = false;
    //弹幕接收相关
    private boolean isReceiveStop = false;     //用于外部控制接收线程结束
    private Socket socket = null;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;

    private Gson gson = new Gson();

    private RabbitApi mRabbitApi;

    @Inject
    LiveRoomPresenter(RabbitApi rabbitApi) {
        mRabbitApi = rabbitApi;
    }


    @Override
    public void getRoomInfo(String roomId) {
        Disposable disposable = mRabbitApi.getLiveRoomInfo(roomId)
                .map(new Function<LiveRoomBean, LiveRoomBean.DataBean.InfoBean>() {
                    @Override
                    public LiveRoomBean.DataBean.InfoBean apply(LiveRoomBean liveRoomBean) {
                        return liveRoomBean.getData().getInfo();
                    }
                })
                .subscribe(new Consumer<LiveRoomBean.DataBean.InfoBean>() {
                    @Override
                    public void accept(@NonNull LiveRoomBean.DataBean.InfoBean infoBean)
                            throws Exception {
                        if (infoBean != null && mView != null) {
                            mView.showRoomInfo(infoBean);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.showError();
                    }
                });
        addDisposable(disposable);
    }

    @Override
    public void getChatListInfo(String roomId) {
        Disposable disposable = mRabbitApi.getChatListInfo(roomId)
                .subscribe(new Consumer<LiveChatInfoBean>() {
                    @Override
                    public void accept(@NonNull LiveChatInfoBean bean) throws Exception {
                        if (bean != null && mView != null) {
                            mView.showChatListInfo(bean);
                        }
                    }
                });
        addDisposable(disposable);
    }

    @Override
    public void connectToChatRoom(String roomId, final LiveChatInfoBean chatInfo) {
        chatRoomList = chatInfo.getData().getChat_addr_list();
        if (chatRoomList == null || chatRoomList.size() == 0) {
            mView.showError();
            return;
        }

        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                //接收响应数据
                byte[] readData = new byte[6];

                socketIP = chatRoomList.get(0).split(":")[0];
                socketPort = Integer.parseInt(chatRoomList.get(0).split(":")[1]);
                socket = new Socket(socketIP, socketPort);

                bis = new BufferedInputStream(socket.getInputStream());//得到Socket输入流
                bos = new BufferedOutputStream(socket.getOutputStream());//得到Socket输出流
                //发送建立连接请求
                bos.write(DanmuUtil.getConnectData(chatInfo.getData()));
                bos.flush();
                bis.read(readData);
                int isLength = bis.read();
                if (isLength >= 6) {
                    if (!(readData[0] == DanmuUtil.RESPONSE[0] &&
                            readData[1] == DanmuUtil.RESPONSE[1] &&
                            readData[2] == DanmuUtil.RESPONSE[2] &&
                            readData[3] == DanmuUtil.RESPONSE[3]))
                        isConnectSuccess = false;
                    else {
                        isConnectSuccess = true;
                        e.onNext("connect success!");
                    }
                } else {
                    isConnectSuccess = false;
                }

            }
        }, BackpressureStrategy.DROP)
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultSubscriber<String>() {
                    @Override
                    public void onNext(String result) {
                        //连接成功
                        if (isConnectSuccess) {
                            runHeartDanmuOnRxJava();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e("Socket连接：" + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private byte[] readStream(InputStream inStream) throws Exception {
        int count = 0;
        while (count == 0) {
            count = inStream.available();
        }
        byte[] b = new byte[count];
        inStream.read(b);
        return b;
    }

    private void runHeartDanmuOnRxJava() {
        //接收弹幕
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {

                while (!isReceiveStop) {
                    //读取服务器返回信息，并获取返回信息的整体字节长度
                    byte[] message = readStream(bis);
                    int recvLen = message.length;

                    //根据实际获取的字节数初始化返回信息内容长度
                    byte[] realBuf = new byte[recvLen];
                    //按照实际获取的字节长度读取返回信息
                    System.arraycopy(message, 0, realBuf, 0, recvLen);
                    if (recvLen >= 4) {//成功接收到数据
                        //分析帧头
                        if (realBuf[0] == DanmuUtil.RECEIVE_MSG[0] &&//1.弹幕
                                realBuf[1] == DanmuUtil.RECEIVE_MSG[1] &&
                                realBuf[2] == DanmuUtil.RECEIVE_MSG[2] &&
                                realBuf[3] == DanmuUtil.RECEIVE_MSG[3]) {

                            //{"type":"1","time":1477356608,"data":{"from":{"__plat":"android","identity":"30","level":"4","msgcolor":"","nickName":"看了还说了","rid":"45560306","sp_identity":"0","userName":""},"to":{"toroom":"15161"},"content":"我去"}}
                            String content = new String(realBuf, "UTF-8");
                            //第一条弹幕
                            int danmuFromIndex = content.indexOf("{\"type");

                            String json = content.substring(danmuFromIndex, content.length());
//                            Logger.e("弹幕消息：" + json);
                            if (json.contains("ack:")) {
                                int jsonFromIndex = json.indexOf("ack:");
                                int jsonToIndex = json.indexOf("{\"type");
                                if (jsonToIndex != 0) {
                                    String splits = json.substring(jsonFromIndex,jsonToIndex-1);
                                    String[] jsons = json.split(splits);

                                    for (int i = 0; i < jsons.length; i++) {
//                                        Logger.e("多条数据" + i + "："+ jsons[i]);
                                        e.onNext(jsons[i]);
                                    }
                                }
                            } else {
                                JSONObject jsonObject = new JSONObject(json);
                                String jsonData = jsonObject.optString("data");

//                                Logger.e("单条数据;" + jsonData);
                                e.onNext(jsonData);
                            }

                        } else if (message[0] == DanmuUtil.HEART_BEAT_RESPONSE[0] &&//2.心跳包
                                message[1] == DanmuUtil.HEART_BEAT_RESPONSE[1] &&
                                message[2] == DanmuUtil.HEART_BEAT_RESPONSE[2] &&
                                message[3] == DanmuUtil.HEART_BEAT_RESPONSE[3]) {
                        }
                    }
                }
            }
        }, BackpressureStrategy.DROP)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<String>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {
//                        Logger.e("接收弹幕：" + e.toString());
                    }

                    @Override
                    public void onNext(String result) {
                        if (isReceiveStop) {
                            if (!isDisposed()) {
                                dispose();
                                return;
                            }
                        }
                        parseDanMu(result);
                    }
                });
    }

    private Object parseJson(String jsonStr, Class clazz) throws Exception {
        if (!jsonStr.endsWith("}")) {
            return null;
        }
        return gson.fromJson(jsonStr, clazz);
    }

    private void parseDanMu(final String result) {
        Flowable.create(new FlowableOnSubscribe<DanMuDataBean>() {
            @Override
            public void subscribe(FlowableEmitter<DanMuDataBean> e) throws Exception {
                //解析弹幕Json
                DanMuDataBean danmu = (DanMuDataBean) parseJson(result, DanMuDataBean.class);
                if (danmu != null) {
                    e.onNext(danmu);
                } else {
                    e.onComplete();
                }
            }
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultSubscriber<DanMuDataBean>() {
                    @Override
                    public void onComplete() {
                    }

                    @Override
                    public void onError(Throwable e) {
//                        Logger.e("解析弹幕：" + e.toString());
                    }

                    @Override
                    public void onNext(DanMuDataBean bean) {
                        if (bean != null && mView != null) {
                            mView.showDanMuData(bean);
                        }
                    }
                });
    }

    @Override
    public void closeConnection() {
        if (socket != null &&
                bis != null &&
                bos != null &&
                socket.isConnected()) {
            try {
                isReceiveStop = true;//停止弹幕消息接收
                bis.close();
                bos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
