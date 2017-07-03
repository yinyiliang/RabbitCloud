package yyl.rabbitcloud.livebycate;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import yyl.rabbitcloud.base.RxPresenter;
import yyl.rabbitcloud.http.RabbitApi;
import yyl.rabbitcloud.livebycate.bean.LiveRoomListBean;

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
        Disposable disposable = mRabbitApi.getRoomInfoByCate(cate, pageno, pagenum)
                .map(new Function<LiveRoomListBean, LiveRoomListBean.DataBean>() {
                    @Override
                    public LiveRoomListBean.DataBean apply(LiveRoomListBean liveRoomListBean) {
                        return liveRoomListBean.getData();
                    }
                })
                .subscribe(new Consumer<LiveRoomListBean.DataBean>() {
                    @Override
                    public void accept(@NonNull LiveRoomListBean.DataBean dataBean) throws Exception {
                        if (dataBean != null && mView != null) {
                            if (dataBean.getBanners() != null) {
                                List<LiveRoomListBean.DataBean.BannersBean> bannersData =
                                        dataBean.getBanners();
                                mView.showLiveTypeBannerData(bannersData);
                            }

                            List<LiveRoomListBean.DataBean.ItemsBean> itemsData =
                                    dataBean.getItems();
                            mView.showLiveTypeItemsData(itemsData);
                        }
                    }
                });
        addDisposable(disposable);
    }
}
