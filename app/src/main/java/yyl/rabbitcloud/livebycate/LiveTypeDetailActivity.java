package yyl.rabbitcloud.livebycate;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.App;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseActivity;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerActivityComponent;
import yyl.rabbitcloud.livebycate.module.LiveRoomListBean;
import yyl.rabbitcloud.liveroom.LiveRoomActivity;
import yyl.rabbitcloud.recyclerview.EndlessRecyclerOnScrollListener;
import yyl.rabbitcloud.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import yyl.rabbitcloud.recyclerview.HeaderSpanSizeLookup;
import yyl.rabbitcloud.recyclerview.LoadingFooter;
import yyl.rabbitcloud.recyclerview.RecyclerViewStateUtils;

/**
 * Created by yyl on 2017/6/19.
 */

public class LiveTypeDetailActivity extends BaseActivity implements LiveTypeDetailContract.View {

    @BindView(R.id.livetype_refresh)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.livetype_recyclerview)
    RecyclerView mRecyclerView;

    private RollPagerView mBannerView;

    @Inject
    LiveTypeDetailPresenter mDetailPresenter;

    //更新
    private final int REFRESH_STATE_UPDATE = 0;
    //加载更多
    private final int REFRESH_STATE_MORE = 1;
    //当前状态
    private int mRefreshState = 0;

    private String mTypeString;
    private int pagerNow = 1;
    private int pagerNum = 20;

    private int loadedItemDataNum;

    //Banner数据
    private List<LiveRoomListBean.DataBean.BannersBean> mBannersBeen;
    private LiveTypeBannerAdapter mBannerAdapter;

    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter;

    //item数据
    private List<LiveRoomListBean.DataBean.ItemsBean> mItemsBeen;
    private LiveTypeItemAdapter mTypeItemAdapter;

    @Override
    protected void requestLayout() {
        setContentView(R.layout.activity_livetype_detail);
    }

    @Override
    protected void initToolBar() {
        String typeName = getIntent().getStringExtra("typeName");
        setToolbarTitle(typeName);
    }

    public static void toLiveTypeDetailActivity(
            BaseActivity activity, String typeName, String
            type) {
        Intent intent = new Intent(activity, LiveTypeDetailActivity.class);
        intent.putExtra("typeName", typeName);
        intent.putExtra("typeString", type);
        activity.startActivity(intent);
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initData() {
        mTypeString = getIntent().getStringExtra("typeString");

        mBannersBeen = new ArrayList<>();
        mItemsBeen = new ArrayList<>();
        mTypeItemAdapter = new LiveTypeItemAdapter(this);

        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter
                (mTypeItemAdapter);
        mRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter)
                mRecyclerView.getAdapter(), manager.getSpanCount()));
        mRecyclerView.setLayoutManager(manager);

        View headerView = getLayoutInflater().inflate(R.layout.viewpager_layout, mRecyclerView,
                false);
        mBannerView = ButterKnife.findById(headerView, R.id.livetype_banner);
        mBannerAdapter = new LiveTypeBannerAdapter(mBannerView, this);
        mBannerView.setAdapter(mBannerAdapter);
        mHeaderAndFooterRecyclerViewAdapter.addHeaderView(headerView);
        mDetailPresenter.attachView(this);
        mDetailPresenter.getLiveTypeData(mTypeString, pagerNow, pagerNum);

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
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mBannerAdapter.setBannerClickListener(new LiveTypeBannerAdapter.OnBannerClickListener() {
            @Override
            public void onClick(int position) {
                LiveRoomListBean.DataBean.BannersBean bean = mBannersBeen.get(position);
                LiveRoomActivity.toLiveRoomActivity(LiveTypeDetailActivity.this, bean.getRoomid());
            }
        });

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRefreshState = REFRESH_STATE_UPDATE;
                pagerNow = 1;
                mDetailPresenter.getLiveTypeData(mTypeString, pagerNow, pagerNum);
            }
        });

        mTypeItemAdapter.setItemClickListener(new LiveTypeItemAdapter.
                OnLiveTypeItemClickListener() {

            @Override
            public void onClick(int position) {
                //添加了header后，RecyclerView 子item的点击位置往后偏移header的数量个位置
                LiveRoomListBean.DataBean.ItemsBean bean;
                if (mHeaderAndFooterRecyclerViewAdapter.getHeaderViewsCount() != 0) {
                    bean = mItemsBeen.get(position - mHeaderAndFooterRecyclerViewAdapter.getHeaderViewsCount());
                } else {
                    bean = mItemsBeen.get(position);
                }
                LiveRoomActivity.toLiveRoomActivity(LiveTypeDetailActivity.this, bean.getId());
            }
        });

        mRecyclerView.addOnScrollListener(mOnScrollListener);

    }

    private EndlessRecyclerOnScrollListener mOnScrollListener = new
            EndlessRecyclerOnScrollListener() {

        @Override
        public void onLoadNextPage(View view) {
            super.onLoadNextPage(view);

            LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState(mRecyclerView);
            if (state == LoadingFooter.State.Loading) {
                return;
            }

            if (loadedItemDataNum < pagerNum) {
                //the end
                RecyclerViewStateUtils.setFooterViewState(App.getAppInstance(),
                        mRecyclerView, pagerNum, LoadingFooter.State.TheEnd, null);
            } else {
                // loading more
                mRefreshState = REFRESH_STATE_MORE;
                pagerNow = pagerNow + 1;
                mDetailPresenter.getLiveTypeData(mTypeString, pagerNow, pagerNum);
                RecyclerViewStateUtils.setFooterViewState(App.getAppInstance(),
                        mRecyclerView, pagerNum, LoadingFooter.State.Loading, null);
            }
        }
    };

    @Override
    public void showLiveTypeBannerData(List<LiveRoomListBean.DataBean.BannersBean> data) {
        if (mRefreshState == REFRESH_STATE_UPDATE) {
            mBannersBeen.clear();
            mBannersBeen.addAll(data);
        } else {
            mBannersBeen.addAll(data);
        }
        if (data.size() == 0) {
            mBannerView.setVisibility(View.GONE);
        } else {
            mBannerView.setVisibility(View.VISIBLE);

            if (data.size() == 1) {
                mBannerView.setHintView(null);
            } else {
                //banner数据大于1时才开启轮播
                mBannerView.setPlayDelay(2000);
                mBannerView.setHintView(new ColorPointHintView
                        (this, ContextCompat.getColor(this, R
                                .color.md_green_A200), Color.WHITE));
            }
            mBannerAdapter.setBannersData(mBannersBeen);
        }
    }

    @Override
    public void showLiveTypeItemsData(List<LiveRoomListBean.DataBean.ItemsBean> data) {
        loadedItemDataNum = data.size();
        mRefreshLayout.setRefreshing(false);
        RecyclerViewStateUtils.setFooterViewState(mRecyclerView, LoadingFooter.State.Normal);
        switch (mRefreshState) {
            case REFRESH_STATE_UPDATE:
                mItemsBeen.clear();
                mItemsBeen.addAll(data);
                break;
            case REFRESH_STATE_MORE:
                mItemsBeen.addAll(data);
                break;
        }

        mTypeItemAdapter.setItemList(mItemsBeen);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onPause() {
        super.onPause();
        mBannerView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mBannerView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDetailPresenter != null) {
            mDetailPresenter.detachView();
        }
    }

}
