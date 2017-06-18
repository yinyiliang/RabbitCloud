package yyl.rabbitcloud.mvp.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.home.MainActivity;
import yyl.rabbitcloud.util.RenderScriptHelper;
import yyl.rabbitcloud.widget.LoginButton;


/**
 * 登录界面
 * Created by yyl on 2017/3/20.
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_login)
    LoginButton btn_login;
    @BindView(R.id.login_content)
    RelativeLayout login_content;
    @BindView(R.id.img_login_bg)
    ImageView img_login_bg;

    @BindView(R.id.color_view)
    View color_view;

    private static final int[] SPLASH_ARRAY = {
            R.drawable.splash0,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4,
            R.drawable.splash6,
            R.drawable.splash7,
            R.drawable.splash8,
            R.drawable.splash9,
            R.drawable.splash10,
            R.drawable.splash11,
            R.drawable.splash13,
            R.drawable.splash14,
            R.drawable.splash15,
            R.drawable.splash16,
            R.drawable.meinv
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initData();
    }


    private void initData() {
        Random r = new Random(SystemClock.elapsedRealtime());
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(),
                SPLASH_ARRAY[r.nextInt(SPLASH_ARRAY.length)]);
        img_login_bg.setImageBitmap(RenderScriptHelper.rsBlur(this, myBitmap, 14));

    }

    @OnClick({R.id.btn_login})
    void click(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (btn_login.isRuning()) {
                    btn_login.setState(LoginButton.STATUS_ERROR);
                } else {
                    btn_login.startOk();
                    new Handler().postDelayed(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        public void run() {
                            startAnimate();

                        }

                    }, 1000);
                }
                break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void startAnimate() {
        int[] location = new int[2];
        btn_login.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        Animator mAnimator = ViewAnimationUtils.createCircularReveal(color_view,
                x + btn_login.getMeasuredWidth() / 2,
                y + btn_login.getMeasuredHeight() / 2,
                btn_login.getWidth() / 2, login_content.getHeight());
        mAnimator.setDuration(400);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                color_view.setVisibility(View.VISIBLE);
            }
        });
        mAnimator.start();
    }

}
