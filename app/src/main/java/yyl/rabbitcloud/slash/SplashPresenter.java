package yyl.rabbitcloud.slash;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import yyl.rabbitcloud.App;
import yyl.rabbitcloud.base.RxPresenter;
import yyl.rabbitcloud.bean.SplashScreenBean;
import yyl.rabbitcloud.http.RabbitApi;

/**
 * Created by yyl on 2017/6/15.
 */

public class SplashPresenter extends RxPresenter<SplashContract.View>
        implements SplashContract.Presenter<SplashContract.View> {

    private RabbitApi mRabbitApi;

    @Inject
    SplashPresenter(RabbitApi rabbitApi) {
        this.mRabbitApi = rabbitApi;
    }


    @Override
    public void getSplashData() {
        Disposable disposable = mRabbitApi.getSplashData()
                .map(new Function<SplashScreenBean, SplashScreenBean.DataBean.RmddataBean>() {
                    @Override
                    public SplashScreenBean.DataBean.RmddataBean apply(
                            @NonNull SplashScreenBean
                                    splashScreenBean) throws Exception {
                        return splashScreenBean.getData().getRmddata();
                    }

                })
                .subscribe(new Consumer<SplashScreenBean.DataBean.RmddataBean>() {
                    @Override
                    public void accept(
                            @NonNull SplashScreenBean.DataBean.RmddataBean
                                    data) throws Exception {
                        if (data != null && mView != null) {
                            mView.showSplashData(data);
                        }
                    }
                });
        addDisposable(disposable);
    }
}
