package yyl.rabbitcloud.liveroom;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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

}
