package yyl.rabbitcloud.di.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import yyl.rabbitcloud.App;
import yyl.rabbitcloud.http.ServiceAPI;


/**
 * Created by yyl on 2017/6/2.
 */

@Module
public class RetrofitHelperModule {

    /**
     * 默认超时时间 单位/秒
     */
    private static final int DEFAULT_TIME_OUT = 10;

    private Context context;

    private String baseUrl;

    public RetrofitHelperModule(App context, String baseUrl) {
        this.context = context;
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory
                .create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client
                (provideOkHttpClient()).build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {

        return new OkHttpClient.Builder().connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS).writeTimeout(DEFAULT_TIME_OUT,
                        TimeUnit.SECONDS).build();
    }

    @Provides
    @Singleton
    ServiceAPI provideAPIService() {
        return provideRetrofit().create(ServiceAPI.class);
    }
}
