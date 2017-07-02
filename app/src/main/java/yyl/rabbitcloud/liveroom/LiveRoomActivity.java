package yyl.rabbitcloud.liveroom;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
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
import butterknife.ButterKnife;
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
import yyl.rabbitcloud.liveroom.bean.DanMuDataBean;
import yyl.rabbitcloud.liveroom.bean.LiveChatInfoBean;
import yyl.rabbitcloud.liveroom.bean.LiveRoomBean;
import yyl.rabbitcloud.util.LoaderImage;
import yyl.rabbitcloud.util.ScreenHelper;
import yyl.rabbitcloud.util.SmallToolsHelper;

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

    //弹幕消息列表
    private RecyclerView mChatInfoView;
    private Button mRetryGetDanmuBtn;
    private List<DanMuDataBean> mMuDataBeen;
    private ChatListAdapter mChatListAdapter;

    //房主房间信息
    private ImageView mAnchorHead;
    private TextView mAnchorName;
    private TextView mAnchorRoomId;
    private TextView mAnchorHeight;
    private TextView mAnchorFans;
    private TextView mAnchorLiveRoomDetail;

    @Inject
    LiveRoomPresenter mRoomPresenter;

    private static final int HANDLER_HIDE_CONTROL = 100;    //自动隐藏mControlLayout
    private static final int HANDLER_HIDE_TIME = 5 * 1000; //mControlLayout的自动隐藏时间

    private Handler mControlHandler;
    private boolean isControlLayoutVisible = true;

    private String roomId;

    private String[] mTitles;
    private LiveRoomViewPagerAdapter mPagerAdapter;
    private List<View> mViewList;

    private boolean isShowDanmu = false;
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
        mViewList = new ArrayList<>();
        mPagerAdapter = new LiveRoomViewPagerAdapter(mTitles);
        initPagerView();
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        //初始化handler 刚进来mControlLayout是显示的，发送个延时消息 5秒后自动隐藏
        mControlHandler = new Handler(this);
        mControlHandler.removeMessages(HANDLER_HIDE_CONTROL);
        mControlHandler.sendEmptyMessageDelayed(HANDLER_HIDE_CONTROL, HANDLER_HIDE_TIME);

        mRoomPresenter.attachView(this);
        mRoomPresenter.getRoomInfo(roomId);
        mRoomPresenter.getChatListInfo(roomId);

    }

    private void initPagerView() {
        //弹幕列表view
        View chatContentView = getLayoutInflater().inflate(R.layout.fragment_chatlist,null);
        mViewList.add(chatContentView);
        mChatInfoView = ButterKnife.findById(chatContentView,R.id.chat_recycler_view);
        mRetryGetDanmuBtn = ButterKnife.findById(chatContentView,R.id.re_load_chat);

        mMuDataBeen = new ArrayList<>();
        mChatListAdapter = new ChatListAdapter(this,mMuDataBeen);
        mChatInfoView.setLayoutManager(new LinearLayoutManager(this));
        mChatInfoView.setAdapter(mChatListAdapter);

        //房间信息view
        View roomInfoView = getLayoutInflater().inflate(R.layout.fragment_anchor_info,null);
        mViewList.add(roomInfoView);
        mAnchorHead = ButterKnife.findById(roomInfoView,R.id.img_anchor_head);
        mAnchorName = ButterKnife.findById(roomInfoView,R.id.tv_anchor_name);
        mAnchorRoomId = ButterKnife.findById(roomInfoView,R.id.tv_live_room_room_id);
        mAnchorHeight = ButterKnife.findById(roomInfoView,R.id.tv_anchor_height);
        mAnchorFans = ButterKnife.findById(roomInfoView,R.id.tv_anchor_fans);
        mAnchorLiveRoomDetail = ButterKnife.findById(roomInfoView,R.id.tv_live_room_livedetail);

        mPagerAdapter.setViewList(mViewList);
    }

    @Override
    protected void initUi() {
        updateVideoLayoutParams();
        mVideoPlayView.setBufferingIndicator(mProgressBar);
        mDanmakuView.enableDanmakuDrawingCache(true);
        mDanmakuContext = DanmakuContext.create();
        mDanmakuContext.setDuplicateMergingEnabled(true);
        mDanmakuView.prepare(parser, mDanmakuContext);
        if (!isLandscape()) {
            mDanmakuView.hideAndPauseDrawTask();
            isShowDanmu = false;
        }
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

        mRetryGetDanmuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRoomPresenter.getChatListInfo(roomId);
            }
        });
    }

    @OnClick({R.id.img_liveroom_back, R.id.img_fullscreen, R.id.fl_video_content})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_liveroom_back:
                //返回按钮
                clickBack();
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

    /**
     * 直播地址拼接
     * @param flag
     * @param room_key
     * @return
     */
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

    @Override
    public void showChatListInfo(LiveChatInfoBean bean) {
        mRoomPresenter.connectToChatRoom(roomId, bean);
    }

    @Override
    public void showDanMuData(DanMuDataBean bean) {
        if (!bean.getFrom().getRid().equals("-1")) {
            if (!bean.getFrom().getNickName().equals("")) {
                mMuDataBeen.add(bean);
                mChatListAdapter.notifyDataSetChanged();
                mChatInfoView.scrollToPosition(mMuDataBeen.size()-1);
            }
        }

        if (isShowDanmu) { //当弹幕显示时才填装
            BaseDanmaku danmaku = mDanmakuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL);
            danmaku.text = bean.getContent();
            danmaku.textSize = ScreenHelper.sp2px(this, 14);
            danmaku.textColor = Color.WHITE;
            danmaku.setTime(mDanmakuView.getCurrentTime());
            mDanmakuView.addDanmaku(danmaku);
        }
    }

    /**
     * 设置房间信息显示
     *
     * @param data
     */
    private void setRoomInfo(LiveRoomBean.DataBean.InfoBean data) {
        mRoomName.setText(data.getRoominfo().getName());
        mRoomNum.setText(String.format(getString(R.string.room_num), roomId));
        mRoomPersonNum.setText(String.format(getString(R.string.room_person_num),
                data.getRoominfo().getPerson_num()));
        mRoomLiveType.setText(String.format(getString(R.string.room_type),
                data.getRoominfo().getClassification()));
        setAnchorInfo(data);
    }

    /**
     * 设置房主房间信息
     * @param data
     */
    private void setAnchorInfo(LiveRoomBean.DataBean.InfoBean data) {
        LoaderImage.loadCircleImg(this,data.getHostinfo().getAvatar(),mAnchorHead);
        mAnchorName.setText(data.getHostinfo().getName());
        mAnchorRoomId.setText(String.format(getString(R.string.room_id),
                data.getRoominfo().getId()));
        String banboos = data.getHostinfo().getBamboos();
        mAnchorHeight.setText(String.format(getString(R.string.anchor_height), SmallToolsHelper.unitConversion(banboos)));
        int person_num = Integer.parseInt(data.getRoominfo().getFans());
        String persons;
        if (person_num > 10000) {
            persons = String.format("%.1f", (person_num / 10000.0));
            persons = persons + "万";
        } else {
            persons = String.valueOf(person_num);
        }
        mAnchorFans.setText(String.format(getString(R.string.anchor_fans), persons));
        mAnchorLiveRoomDetail.setText(data.getRoominfo().getBulletin());
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
            //设置为全屏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            mControlLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            mRoomInfoLayout.setVisibility(View.GONE);
            mFullScreen.setVisibility(View.GONE);
            mDanmakuView.show();
            isShowDanmu = true;
        } else {
            //退出全屏
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            mRoomInfoLayout.setVisibility(View.VISIBLE);
            mFullScreen.setVisibility(View.VISIBLE);
            mDanmakuView.hide();
            isShowDanmu = false;
        }

        updateVideoLayoutParams();
    }

    /**
     * 动态更新视频播放父view的高度
     */
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
            if (mDanmakuView != null) {
                mDanmakuView.release();
                mDanmakuView = null;
            }
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
            mRoomPresenter.closeConnection();
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
