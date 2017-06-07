package yyl.rabbitcloud;

import android.app.Application;

import yyl.rabbitcloud.di.component.DaggerRetrofitComponent;
import yyl.rabbitcloud.di.component.RetrofitComponent;
import yyl.rabbitcloud.di.module.RetrofitHelperModule;

/**
 * Created by yyl on 2017/6/2.
 */

public class App extends Application {

    private RetrofitComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerRetrofitComponent.builder().retrofitHelperModule(new RetrofitHelperModule(this, RabbitPublicValue.BASE_URL)).build();
    }

    public RetrofitComponent getAppComponent() {
        return mAppComponent;
    }
}
