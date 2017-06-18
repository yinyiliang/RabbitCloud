package yyl.rabbitcloud;

import android.app.Application;

import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerAppComponent;
import yyl.rabbitcloud.di.module.AppModule;
import yyl.rabbitcloud.di.module.RabbitApiModule;

/**
 * Created by yyl on 2017/6/2.
 */

public class App extends Application {

    private static App sInstance;

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        initComponent();
    }

    private void initComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .rabbitApiModule(new RabbitApiModule())
                .build();
    }

    public static App getAppInstance() {
        return sInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
