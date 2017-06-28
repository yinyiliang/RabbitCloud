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
                .subscribe(new Consumer<SplashScreenBean>() {
                    @Override
                    public void accept(@NonNull SplashScreenBean splashScreenBean) throws Exception {
                        if (splashScreenBean != null && mView != null) {
                            mView.showSplashData(splashScreenBean);
                        }
                    }
                });
        addDisposable(disposable);
    }
}
