package yyl.rabbitcloud.main.home;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import yyl.rabbitcloud.base.RxPresenter;
import yyl.rabbitcloud.http.RabbitApi;
import yyl.rabbitcloud.main.home.bean.RecommendCardListBean;
import yyl.rabbitcloud.main.home.bean.RecommendHeaderBean;

/**
 * Created by yyl on 2017/7/4.
 */

public class RecommendPresenter extends RxPresenter<RecommendContract.View> implements
        RecommendContract.Presenter<RecommendContract.View> {

    private RabbitApi mRabbitApi;

    @Inject
    RecommendPresenter(RabbitApi rabbitApi) {
        this.mRabbitApi = rabbitApi;
    }

    @Override
    public void getHeaderData() {
        Disposable disposable = mRabbitApi.getRecommendHeaderData()
                .subscribe(new Consumer<RecommendHeaderBean>() {
                    @Override
                    public void accept(@NonNull RecommendHeaderBean data) throws Exception {
                        if (data != null && mView != null) {
                            mView.showHeaderData(data);
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
    public void getCardListData() {
        Disposable disposable = mRabbitApi.getRecommendCardList()
                .map(new Function<RecommendCardListBean, List<RecommendCardListBean.DataBean>>() {
                    @Override
                    public List<RecommendCardListBean.DataBean> apply(@NonNull RecommendCardListBean
                                                                        recommendCardListBean) throws Exception {
                        return recommendCardListBean.getData();
                    }
                })
                .subscribe(new Consumer<List<RecommendCardListBean.DataBean>>() {
                    @Override
                    public void accept(@NonNull List<RecommendCardListBean.DataBean> dataBeen) throws Exception {
                        if (dataBeen != null && mView != null) {
                            mView.showCardListData(dataBeen);
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
