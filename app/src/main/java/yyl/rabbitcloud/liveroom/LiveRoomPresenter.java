package yyl.rabbitcloud.liveroom;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import yyl.rabbitcloud.base.RxPresenter;
import yyl.rabbitcloud.http.RabbitApi;

/**
 * Created by yyl on 2017/6/23.
 */

public class LiveRoomPresenter extends RxPresenter<LiveRoomContract.View>
        implements LiveRoomContract.Presenter<LiveRoomContract.View> {

    private RabbitApi mRabbitApi;

    @Inject
    LiveRoomPresenter(RabbitApi rabbitApi) {
        mRabbitApi = rabbitApi;
    }


    @Override
    public void getRoomInfo(String roomId) {
        Subscription subscription = mRabbitApi.getLiveRoomInfo(roomId)
                .map(new Func1<LiveRoomBean, LiveRoomBean.DataBean.InfoBean>() {
                    @Override
                    public LiveRoomBean.DataBean.InfoBean call(LiveRoomBean liveRoomBean) {
                        return liveRoomBean.getData().getInfo();
                    }
                })
                .subscribe(new Subscriber<LiveRoomBean.DataBean.InfoBean>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(LiveRoomBean.DataBean.InfoBean infoBean) {
                        if (infoBean != null && mView != null) {
                            mView.showRoomInfo(infoBean);
                        }
                    }
                });
        addSubscrebe(subscription);
    }

}
