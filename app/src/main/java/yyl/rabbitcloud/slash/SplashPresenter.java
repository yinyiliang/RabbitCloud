package yyl.rabbitcloud.slash;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
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
        Subscription rxSubscription =  mRabbitApi.getSplashData()
                .map(new Func1<SplashScreenBean, SplashScreenBean.DataBean.RmddataBean>() {
                    @Override
                    public SplashScreenBean.DataBean.RmddataBean call(SplashScreenBean splashScreenBean) {
                        return splashScreenBean.getData().getRmddata();
                    }
                })
                .subscribe(new Subscriber<SplashScreenBean.DataBean.RmddataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SplashScreenBean.DataBean.RmddataBean data) {
                        if (data != null && mView != null) {
                            mView.showSplashData(data);
                        }
                    }
                });
                addSubscrebe(rxSubscription);
    }
}
