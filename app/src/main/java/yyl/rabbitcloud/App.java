package yyl.rabbitcloud;

import android.app.Application;

import com.bumptech.glide.request.target.ViewTarget;
import com.squareup.leakcanary.LeakCanary;

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

//        LeakCanary.install(this);

        //为防止出现
        // "You must not call setTag() on a view Glide is targeting" on non-root ImageView
        //这个问题导致的软件崩溃
        ViewTarget.setTagId(R.id.glide_tag);


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
