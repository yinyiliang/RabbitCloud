package yyl.rabbitcloud.main.home.fragment;

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
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerFragmentComponent;
import yyl.rabbitcloud.livebycate.LiveTypeBannerAdapter;
import yyl.rabbitcloud.livebycate.LiveTypeDetailActivity;
import yyl.rabbitcloud.livebycate.LiveTypeDetailContract;
import yyl.rabbitcloud.livebycate.LiveTypeDetailPresenter;
import yyl.rabbitcloud.livebycate.LiveTypeItemAdapter;
import yyl.rabbitcloud.livebycate.bean.LiveRoomListBean;
import yyl.rabbitcloud.liveroom.LiveRoomActivity;
import yyl.rabbitcloud.main.MainFragment;
import yyl.rabbitcloud.recyclerview.EndlessRecyclerOnScrollListener;
import yyl.rabbitcloud.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import yyl.rabbitcloud.recyclerview.HeaderSpanSizeLookup;
import yyl.rabbitcloud.recyclerview.LoadingFooter;
import yyl.rabbitcloud.recyclerview.RecyclerViewStateUtils;
import yyl.rabbitcloud.util.ScreenHelper;
import yyl.rabbitcloud.widget.SpaceItemDecoration;

/**
 * Created by yyl on 2017/7/4.
 */

public class ChijiFragment extends MainFragment implements LiveTypeDetailContract.View {


    @BindView(R.id.chiji_refresh)
    SwipeRefreshLayout mChijiRefreshLayout;
    @BindView(R.id.chiji_recyclerview)
    RecyclerView mChijiRecyclerView;

    @Inject
    LiveTypeDetailPresenter mDetailPresenter;

    //更新
    private final int REFRESH_STATE_UPDATE = 0;
    //加载更多
    private final int REFRESH_STATE_MORE = 1;
    //当前状态
    private int mRefreshState = 0;

    private String mTypeString = "pubg";
    private int pagerNow = 1;
    private int pagerNum = 20;

    private int loadedItemDataNum;

    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter;

    //item数据
    private List<LiveRoomListBean.DataBean.ItemsBean> mItemsBeen;
    private LiveTypeItemAdapter mTypeItemAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_chiji;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    /**
     * 刷新数据
     */
    public void refreshData() {
        mRefreshState = REFRESH_STATE_UPDATE;
        pagerNow = 1;
        mDetailPresenter.getLiveTypeData(mTypeString, pagerNow, pagerNum);
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initData() {
        mItemsBeen = new ArrayList<>();
        mTypeItemAdapter = new LiveTypeItemAdapter(mMainActivity, LiveTypeItemAdapter.TYPE_CATE);

        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter
                (mTypeItemAdapter);
        mChijiRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);

        GridLayoutManager manager = new GridLayoutManager(mMainActivity, 2);
        manager.setSpanSizeLookup(new HeaderSpanSizeLookup((HeaderAndFooterRecyclerViewAdapter)
                mChijiRecyclerView.getAdapter(), manager.getSpanCount()));
        mChijiRecyclerView.setLayoutManager(manager);

        int spacing = ScreenHelper.dp2px(mMainActivity, 15);
        mChijiRecyclerView.addItemDecoration(new SpaceItemDecoration(2, spacing, spacing, false));

        mDetailPresenter.attachView(this);
        mDetailPresenter.getLiveTypeData(mTypeString, pagerNow, pagerNum);
    }

    @Override
    protected void initListener() {

        mChijiRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

        mTypeItemAdapter.setItemClickListener(new LiveTypeItemAdapter.
                OnLiveTypeItemClickListener() {

            @Override
            public void onClick(int position) {
                //添加了header后，RecyclerView 子item的点击位置往后偏移header的数量个位置
                LiveRoomListBean.DataBean.ItemsBean bean;
                if (mHeaderAndFooterRecyclerViewAdapter.getHeaderViewsCount() != 0) {
                    bean = mItemsBeen.get(position - mHeaderAndFooterRecyclerViewAdapter
                            .getHeaderViewsCount());
                } else {
                    bean = mItemsBeen.get(position);
                }
                LiveRoomActivity.toLiveRoomActivity(mMainActivity, bean.getId());
            }
        });

        mChijiRecyclerView.addOnScrollListener(mOnScrollListener);
    }

    private EndlessRecyclerOnScrollListener mOnScrollListener = new
            EndlessRecyclerOnScrollListener() {

                @Override
                public void onLoadNextPage(View view) {
                    super.onLoadNextPage(view);

                    LoadingFooter.State state = RecyclerViewStateUtils.getFooterViewState
                            (mChijiRecyclerView);
                    if (state == LoadingFooter.State.Loading) {
                        return;
                    }

                    if (loadedItemDataNum < pagerNum) {
                        //the end
                        RecyclerViewStateUtils.setFooterViewState(App.getAppInstance(),
                                mChijiRecyclerView, pagerNum, LoadingFooter.State.TheEnd, null);
                    } else {
                        // loading more
                        mRefreshState = REFRESH_STATE_MORE;
                        pagerNow = pagerNow + 1;
                        mDetailPresenter.getLiveTypeData(mTypeString, pagerNow, pagerNum);
                        RecyclerViewStateUtils.setFooterViewState(App.getAppInstance(),
                                mChijiRecyclerView, pagerNum, LoadingFooter.State.Loading, null);
                    }
                }
            };

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mDetailPresenter != null) {
            mDetailPresenter.detachView();
        }
    }

    @Override
    public void showLiveTypeBannerData(List<LiveRoomListBean.DataBean.BannersBean> data) {

    }

    @Override
    public void showLiveTypeItemsData(List<LiveRoomListBean.DataBean.ItemsBean> data) {
        loadedItemDataNum = data.size();
        mChijiRefreshLayout.setRefreshing(false);
        RecyclerViewStateUtils.setFooterViewState(mChijiRecyclerView, LoadingFooter.State.Normal);
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
}
