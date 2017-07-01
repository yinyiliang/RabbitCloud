package yyl.rabbitcloud.liveroom;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.pili.pldroid.player.widget.PLVideoTextureView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import master.flame.danmaku.ui.widget.DanmakuView;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseActivity;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerActivityComponent;
import yyl.rabbitcloud.liveroom.fragment.AnchorInfoFragment;
import yyl.rabbitcloud.liveroom.fragment.ChatListFragment;
import yyl.rabbitcloud.util.ScreenHelper;

/**
 * Created by yyl on 2017/6/23.
 */

public class LiveRoomActivity extends BaseActivity implements LiveRoomContract.View,
        Handler.Callback {

    @BindView(R.id.video_view)
    PLVideoTextureView mVideoPlayView;
    @BindView(R.id.danmu_view)
    DanmakuView mDanmakuView;
    @BindView(R.id.fl_video_content)
    FrameLayout mVideoContent;
    //动态隐藏的控制布局
    @BindView(R.id.rl_room_live_control)
    RelativeLayout mControlLayout;
    //返回按钮
    @BindView(R.id.img_liveroom_back)
    ImageView mRoomBack;
    //显示的房间信息布局
    @BindView(R.id.rl_room_info)
    RelativeLayout mRoomInfoLayout;
    @BindView(R.id.tv_room_name)
    TextView mRoomName;
    @BindView(R.id.tv_room_num)
    TextView mRoomNum;
    @BindView(R.id.tv_room_person_num)
    TextView mRoomPersonNum;
    @BindView(R.id.tv_room_live_type)
    TextView mRoomLiveType;

    @BindView(R.id.progress_live_room)
    ProgressBar mProgressBar;
    //全屏控制按钮
    @BindView(R.id.img_fullscreen)
    ImageView mFullScreen;

    @BindView(R.id.live_room_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.live_room_viewpager)
    ViewPager mViewPager;

    @Inject
    LiveRoomPresenter mRoomPresenter;

    private static final int HANDLER_HIDE_CONTROL = 100;    //自动隐藏mControlLayout
    private static final int HANDLER_HIDE_TIME = 5 * 1000; //mControlLayout的自动隐藏时间

    private Handler mControlHandler;
    private boolean isControlLayoutVisible = true;

    private String roomId;

    private LiveRoomPagerAdapter mRoomPagerAdapter;
    private String[] mTitles;
    private List<Fragment> mFragmentList;

    private DanmakuContext mDanmakuContext;
    private final BaseDanmakuParser parser = new BaseDanmakuParser() {
        @Override
        protected IDanmakus parse() {
            return new Danmakus();
        }
    };

    @Override
    protected void initToolBar() {
        mToolbar.setVisibility(View.GONE);
    }

    @Override
    protected void requestLayout() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_live_room);
    }


    public static void toLiveRoomActivity(BaseActivity activity, String roomId) {
        Intent intent = new Intent(activity, LiveRoomActivity.class);
        intent.putExtra("roomId", roomId);
        activity.startActivity(intent);
    }

    @Override
    protected void initData() {
        roomId = getIntent().getStringExtra("roomId");

        mTitles = new String[]{"聊天", "主播"};
        mFragmentList = new ArrayList<>();
        mRoomPagerAdapter = LiveRoomPagerAdapter.getInstance(getSupportFragmentManager(),
                mFragmentList, mTitles);
        mViewPager.setAdapter(mRoomPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        //初始化handler 刚进来mControlLayout是显示的，发送个延时消息 5秒后自动隐藏
        mControlHandler = new Handler(this);
        mControlHandler.removeMessages(HANDLER_HIDE_CONTROL);
        mControlHandler.sendEmptyMessageDelayed(HANDLER_HIDE_CONTROL, HANDLER_HIDE_TIME);

        mRoomPresenter.attachView(this);
        mRoomPresenter.getRoomInfo(roomId);

    }

    @Override
    protected void initUi() {
        updateVideoLayoutParams();
        mVideoPlayView.setBufferingIndicator(mProgressBar);
        mDanmakuView.enableDanmakuDrawingCache(true);
        mDanmakuContext = DanmakuContext.create();
        mDanmakuContext.setDuplicateMergingEnabled(true);
        mDanmakuView.prepare(parser, mDanmakuContext);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected void initListener() {
        mDanmakuView.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                mDanmakuView.start();
            }

            @Override
            public void updateTimer(DanmakuTimer timer) {

            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {

            }

            @Override
            public void drawingFinished() {

            }
        });
    }

    @OnClick({R.id.img_liveroom_back, R.id.rl_room_info, R.id.img_fullscreen, R.id
            .fl_video_content})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_liveroom_back:
                //返回按钮
                clickBack();
                break;
            case R.id.rl_room_info:
                //房间信息显示

                break;
            case R.id.img_fullscreen:
                //全屏控制 横屏
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                //点击后重新倒计时
                mControlHandler.removeMessages(HANDLER_HIDE_CONTROL);
                mControlHandler.sendEmptyMessageDelayed(HANDLER_HIDE_CONTROL, HANDLER_HIDE_TIME);
                break;
            case R.id.fl_video_content:
                //点击播放器
                if (isControlLayoutVisible) { //显示状态
                    mControlHandler.removeMessages(HANDLER_HIDE_CONTROL);
                    mControlHandler.sendEmptyMessage(HANDLER_HIDE_CONTROL);
                } else { //隐藏状态 点击变为显示，倒计时5秒再隐藏
                    mControlLayout.setVisibility(View.VISIBLE);
                    isControlLayoutVisible = true;
                    mControlHandler.removeMessages(HANDLER_HIDE_CONTROL);
                    mControlHandler.sendEmptyMessageDelayed(HANDLER_HIDE_CONTROL,
                            HANDLER_HIDE_TIME);
                }

                break;
        }
    }

    private String stitchingAddress(String flag, String room_key) {
        String url = "";
        String[] flags = flag.split("_");
        url = String.format(getString(R.string.video_url), flags[1], room_key);
        return url;
    }

    @Override
    public void showRoomInfo(LiveRoomBean.DataBean.InfoBean data) {
        setRoomInfo(data);
        String url = stitchingAddress(data.getVideoinfo().getPlflag(),
                data.getVideoinfo().getRoom_key());
        mVideoPlayView.setVideoPath(url);
    }

    /**
     * 设置房间信息显示
     *
     * @param data
     */
    private void setRoomInfo(LiveRoomBean.DataBean.InfoBean data) {
        mFragmentList.add(ChatListFragment.getInstance(roomId));
        mFragmentList.add(AnchorInfoFragment.getInstance(data));
        mRoomPagerAdapter.notifyDataSetChanged();

        mRoomName.setText(data.getRoominfo().getName());
        mRoomNum.setText(String.format(getString(R.string.room_num), roomId));
        mRoomPersonNum.setText(String.format(getString(R.string.room_person_num),
                data.getRoominfo().getPerson_num()));
        mRoomLiveType.setText(String.format(getString(R.string.room_type),
                data.getRoominfo().getClassification()));
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //当屏幕变为横屏时
        if (isLandscape()) {
            mRoomInfoLayout.setVisibility(View.GONE);
            mFullScreen.setVisibility(View.GONE);
        } else {
            mRoomInfoLayout.setVisibility(View.VISIBLE);
            mFullScreen.setVisibility(View.VISIBLE);
        }

        updateVideoLayoutParams();
    }

    private void updateVideoLayoutParams() {
        ViewGroup.LayoutParams lp = mVideoContent.getLayoutParams();
        if (isLandscape()) {
            lp.height = ScreenHelper.getScreenY(this);
        } else {
            lp.height = ScreenHelper.dp2px(this, 200);
        }
        mVideoContent.setLayoutParams(lp);
    }

    /**
     * 判断是否是横屏
     *
     * @return
     */
    public boolean isLandscape() {
        return getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
    }

    /**
     * 返回键方法
     */
    public void clickBack() {
        if (isLandscape()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            //重新倒计时
            mControlHandler.removeMessages(HANDLER_HIDE_CONTROL);
            mControlHandler.sendEmptyMessageDelayed(HANDLER_HIDE_CONTROL, HANDLER_HIDE_TIME);
        } else {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVideoPlayView != null) {
            mVideoPlayView.stopPlayback();
        }
        if (mRoomPresenter != null) {
            mRoomPresenter.detachView();
        }
        if (mDanmakuView != null) {
            mDanmakuView.release();
            mDanmakuView = null;
        }
        mControlHandler.removeMessages(HANDLER_HIDE_CONTROL);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mVideoPlayView != null) {
            mVideoPlayView.start();
        }
        if (mDanmakuView != null && mDanmakuView.isPrepared() && mDanmakuView.isPaused()) {
            mDanmakuView.resume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideoPlayView != null) {
            mVideoPlayView.pause();
        }
        if (mDanmakuView != null && mDanmakuView.isPrepared()) {
            mDanmakuView.pause();
        }
    }

    @Override
    public void onBackPressed() {
        if (mDanmakuView != null) {
            mDanmakuView.release();
            mDanmakuView = null;
        }
        clickBack();
    }

    @Override
    public boolean handleMessage(Message message) {
        if (message.what == HANDLER_HIDE_CONTROL) {
            mControlLayout.setVisibility(View.GONE);
            isControlLayoutVisible = false;
        }
        return true;
    }
}
