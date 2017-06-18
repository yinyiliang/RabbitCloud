package yyl.rabbitcloud.slash;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.lang.ref.WeakReference;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseActivity;
import yyl.rabbitcloud.bean.SplashScreenBean;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerSplashComponent;
import yyl.rabbitcloud.mvp.activity.LoginActivity;
import yyl.rabbitcloud.util.LoaderImage;

/**
 * Created by yyl on 2017/6/9.
 */

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @BindView(R.id.img_splash)
    ImageView splashImg;
    @BindView(R.id.tv_splash_slogan)
    TextView splashSlogan;
    @BindView(R.id.tv_splash_source)
    TextView splashSource;

    @Inject
    SplashPresenter splashPresenter;

    private static final int[] SPLASH_IMG = {
            R.drawable.splash_img,
            R.drawable.splash_img1,
            R.drawable.splash_img2
    };

    private MyHandler mMyHandler = new MyHandler(this);

    private static class MyHandler extends Handler {
        private final WeakReference<SplashActivity> mWeakReference;

        private MyHandler(SplashActivity weakReference) {
            mWeakReference = new WeakReference<SplashActivity>(weakReference);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity splashActivity = mWeakReference.get();
            if (splashActivity != null) {
                Intent intent = new Intent(splashActivity, LoginActivity.class);
                splashActivity.startActivity(intent);
                splashActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim
                        .fade_out);
                splashActivity.finish();
            }
        }
    }

    @Override
    protected void requestLayout() {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        Random r = new Random(SystemClock.elapsedRealtime());
        LoaderImage.loadSplash(this, SPLASH_IMG[r.nextInt(SPLASH_IMG.length)], splashImg);

        mMyHandler.sendEmptyMessageDelayed(1,2000);
    }

    @Override
    protected void initUi() {
        splashPresenter.attachView(this);
        splashPresenter.getSplashData();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerSplashComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showSplashData(SplashScreenBean.DataBean.RmddataBean bean) {
        splashSlogan.setText(bean.getText().getTitle());
        splashSource.setText(bean.getText().getFrom() + " | " + bean.getText().getRole());
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (splashPresenter != null) {
            splashPresenter.detachView();
        }
    }
}
