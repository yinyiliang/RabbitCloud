package yyl.rabbitcloud.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import io.reactivex.Observable;
import yyl.rabbitcloud.RabbitPublicValue;
import yyl.rabbitcloud.livebycate.module.LiveRoomListBean;
import yyl.rabbitcloud.liveroom.bean.LiveChatInfoBean;
import yyl.rabbitcloud.liveroom.bean.LiveRoomBean;
import yyl.rabbitcloud.bean.SplashScreenBean;
import yyl.rabbitcloud.main.gametype.module.GameCategoryBean;

/**
 * Created by yyl on 2017/6/17.
 */

public class RabbitApi extends ObjectLoader {

    public static RabbitApi instance;

    private ServiceAPI service;

    public RabbitApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RabbitPublicValue.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(ServiceAPI.class);
    }

    public static RabbitApi getInstance(OkHttpClient okHttpClient) {
        if (instance == null)
            instance = new RabbitApi(okHttpClient);
        return instance;
    }

    /**
     * 闪屏页
     * @return
     */
    public Observable<SplashScreenBean> getSplashData() {
        return observe(service.getSplashScreen());
    }

    /**
     * 游戏类型
     * @return
     */
    public Observable<GameCategoryBean> getGameTypeData() {
        return observe(service.getCategoryData());
    }

    /**
     * 根据游戏类型获取数据
     * @return
     */
    public Observable<LiveRoomListBean> getRoomInfoByCate(String cate, int pageno, int pagenum) {
        return observe(service.getRoomInfoByCate(cate, pageno, pagenum));
    }

    /**
     * 根据房间号获取房间信息
     */
    public Observable<LiveRoomBean> getLiveRoomInfo(String roomId) {
        return observe(service.getLiveRoomInfo(roomId));
    }

    /**
     * 根据房间号获取可请求弹幕数据的数据
     */
    public Observable<LiveChatInfoBean> getChatListInfo(String roomId) {
        return observe(service.getChatListInfo(roomId));
    }

}
