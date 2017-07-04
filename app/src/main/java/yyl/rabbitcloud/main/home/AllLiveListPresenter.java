package yyl.rabbitcloud.main.home;

import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import yyl.rabbitcloud.base.RxPresenter;
import yyl.rabbitcloud.http.RabbitApi;
import yyl.rabbitcloud.livebycate.bean.LiveRoomListBean;
import yyl.rabbitcloud.main.home.bean.AllLiveListBean;

/**
 * Created by yyl on 2017/7/4.
 */

public class AllLiveListPresenter extends RxPresenter<AllLiveListContract.View> implements
        AllLiveListContract.Presenter<AllLiveListContract.View> {

    private RabbitApi mRabbitApi;

    @Inject
    AllLiveListPresenter(RabbitApi rabbitApi) {
        this.mRabbitApi = rabbitApi;
    }

    @Override
    public void getAllLiveList(int pageno, int pagenum) {
        Disposable disposable = mRabbitApi.getAllLiveList(pageno, pagenum)
                .map(new Function<AllLiveListBean, List<AllLiveListBean.DataBean.ItemsBean>>() {
                    @Override
                    public List<AllLiveListBean.DataBean.ItemsBean> apply(
                            @NonNull AllLiveListBean liveRoomListBean) throws Exception {
                        return liveRoomListBean.getData().getItems();
                    }
                })
                .subscribe(new Consumer<List<AllLiveListBean.DataBean.ItemsBean>>() {
                    @Override
                    public void accept(
                            @NonNull List<AllLiveListBean.DataBean.ItemsBean>
                                    itemsBeen) throws Exception {
                        if (itemsBeen != null && mView != null) {
                            mView.showAllLiveListData(itemsBeen);
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
