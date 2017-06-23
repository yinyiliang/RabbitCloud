package yyl.rabbitcloud.liveroom;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.pili.pldroid.player.widget.PLVideoTextureView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseActivity;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerActivityComponent;
import yyl.rabbitcloud.util.ScreenHelper;

/**
 * Created by yyl on 2017/6/23.
 */

public class LiveRoomActivity extends BaseActivity implements LiveRoomContract.View {

    @BindView(R.id.video_view)
    PLVideoTextureView mVideoPlayView;
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

    @Inject
    LiveRoomPresenter mRoomPresenter;

    private String roomId;
    private boolean roomInfoStatus = true; //默认为显示状态

    @Override
    protected void initToolBar() {
        mToolbar.setVisibility(View.GONE);
    }

    @Override
    protected void requestLayout() {
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
        mRoomPresenter.attachView(this);
        mRoomPresenter.getRoomInfo(roomId);

    }

    @Override
    protected void initUi() {
        mVideoPlayView.setBufferingIndicator(mProgressBar);
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

    }

    @OnClick({R.id.img_liveroom_back,R.id.rl_room_info,R.id.img_fullscreen,R.id.fl_video_content})
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
                setFullScreen();
                break;
            case R.id.fl_video_content:
                //点击播放器
                if (roomInfoStatus) {
                    mControlLayout.setVisibility(View.GONE);
                    roomInfoStatus = false;
                } else {
                    mControlLayout.setVisibility(View.VISIBLE);
                    roomInfoStatus = true;
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
     * @param data
     */
    private void setRoomInfo(LiveRoomBean.DataBean.InfoBean data) {
        mRoomName.setText(data.getRoominfo().getName());
        mRoomNum.setText(String.format(getString(R.string.room_num),roomId));
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
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mVideoContent.getLayoutParams();
            layoutParams.width = ScreenHelper.getScreenX(this);
            layoutParams.height = ScreenHelper.getScreenY(this);
            layoutParams.setMargins(0,0,0,0);
            mVideoContent.setLayoutParams(layoutParams);
            mRoomInfoLayout.setVisibility(View.GONE);
            mFullScreen.setVisibility(View.GONE);

        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mVideoContent.getLayoutParams();
            layoutParams.width = ScreenHelper.getScreenX(this);
            layoutParams.height = ScreenHelper.dp2px(this,240);
            mVideoContent.setLayoutParams(layoutParams);
            mRoomInfoLayout.setVisibility(View.VISIBLE);
            mFullScreen.setVisibility(View.VISIBLE);
        }

    }

    /**
     * 判断是否是横屏
     * @return
     */
    public boolean isLandscape(){
        return getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
    }

    public void setFullScreen(){
        if(isLandscape()){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    public void clickBack(){
        if(isLandscape()){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mVideoPlayView != null) {
            mVideoPlayView.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mVideoPlayView != null) {
            mVideoPlayView.pause();
        }
    }

    @Override
    public void onBackPressed() {
        clickBack();
    }
}
