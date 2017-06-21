package yyl.rabbitcloud.livebycate;

import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import yyl.rabbitcloud.base.RxPresenter;
import yyl.rabbitcloud.http.RabbitApi;
import yyl.rabbitcloud.livebycate.module.LiveRoomListBean;

/**
 * Created by yyl on 2017/6/21.
 */

public class LiveTypeDetailPresenter extends RxPresenter<LiveTypeDetailContract.View> implements
        LiveTypeDetailContract.Presenter<LiveTypeDetailContract.View> {

    private RabbitApi mRabbitApi;

    @Inject
    LiveTypeDetailPresenter(RabbitApi rabbitApi) {
        mRabbitApi = rabbitApi;
    }

    @Override
    public void getLiveTypeData(String cate, int pageno, final int pagenum) {
        Subscription subscription = mRabbitApi.getRoomInfoByCate(cate, pageno, pagenum)
                .map(new Func1<LiveRoomListBean, LiveRoomListBean.DataBean>() {
                    @Override
                    public LiveRoomListBean.DataBean call(LiveRoomListBean liveRoomListBean) {
                        return liveRoomListBean.getData();
                    }
                })
                .subscribe(new Subscriber<LiveRoomListBean.DataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(LiveRoomListBean.DataBean dataBean) {
                        if (dataBean != null && mView != null) {
                            List<LiveRoomListBean.DataBean.BannersBean> bannersData =
                                    dataBean.getBanners();
                            mView.showLiveTypeBannerData(bannersData);

                            List<LiveRoomListBean.DataBean.ItemsBean> itemsData =
                                    dataBean.getItems();
                            mView.showLiveTypeItemsData(itemsData);
                        }

                    }
                });
        addSubscrebe(subscription);
    }
}
