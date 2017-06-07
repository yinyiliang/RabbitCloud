package yyl.rabbitcloud.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import yyl.rabbitcloud.App;
import yyl.rabbitcloud.di.module.RetrofitHelperModule;
import yyl.rabbitcloud.http.ServiceAPI;

/**
 * Created by yyl on 2017/6/2.
 */

@Singleton
@Component(modules = RetrofitHelperModule.class)
public interface RetrofitComponent {

    void inject(App app);

    Context getContext();

    ServiceAPI getServiceAPI();
}
