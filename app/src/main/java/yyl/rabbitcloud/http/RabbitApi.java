package yyl.rabbitcloud.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import yyl.rabbitcloud.RabbitPublicValue;
import yyl.rabbitcloud.main.gametype.module.CategoryGameListBean;
import yyl.rabbitcloud.bean.SplashScreenBean;
import yyl.rabbitcloud.main.gametype.module.GameCategoryBean;

/**
 * Created by yyl on 2017/6/17.
 */

public class RabbitApi extends ObjectLoader {

    public static RabbitApi instance;

    private ServiceAPI service;

    public RabbitApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RabbitPublicValue.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(ServiceAPI.class);
    }

    public static RabbitApi getInstance(OkHttpClient okHttpClient) {
        if (instance == null)
            instance = new RabbitApi(okHttpClient);
        return instance;
    }

    public Observable<SplashScreenBean> getSplashData() {
        return observe(service.getSplashScreen());
    }

    public Observable<GameCategoryBean> getGameTypeData() {
        return observe(service.getCategoryData());
    }

}
