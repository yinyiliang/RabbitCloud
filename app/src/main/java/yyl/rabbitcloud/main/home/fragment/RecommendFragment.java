package yyl.rabbitcloud.main.home.fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.jude.rollviewpager.RollPagerView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerFragmentComponent;
import yyl.rabbitcloud.livebycate.LiveTypeBannerAdapter;
import yyl.rabbitcloud.livebycate.LiveTypeDetailActivity;
import yyl.rabbitcloud.liveroom.LiveRoomActivity;
import yyl.rabbitcloud.main.MainFragment;
import yyl.rabbitcloud.main.home.RecommendContract;
import yyl.rabbitcloud.main.home.RecommendPresenter;
import yyl.rabbitcloud.main.home.bean.RecommendCardListBean;
import yyl.rabbitcloud.main.home.bean.RecommendHeaderBean;
import yyl.rabbitcloud.recyclerview.HeaderAndFooterRecyclerViewAdapter;

/**
 * Created by yyl on 2017/6/18.
 */

public class RecommendFragment extends MainFragment implements RecommendContract.View {

    @BindView(R.id.recommend_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recommend_recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    RecommendPresenter mRecommendPresenter;

    private RollPagerView mRecommendBanner;
    private GridView mNavsGridView;

    private List<RecommendHeaderBean.DataBean.BannersBean> mBannersBeanList;
    private LiveTypeBannerAdapter mBannerAdapter;
    private List<RecommendHeaderBean.DataBean.NavsBean> mNavsBeanList;
    private NavsGridAdapter mNavsAdapter;


    private HeaderAndFooterRecyclerViewAdapter mHeaderAndFooterRecyclerViewAdapter;
    private List<RecommendCardListBean.DataBean> mCardList;
    private RecommendRecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }


    @Override
    protected void initUi() {

    }

    @Override
    protected void initData() {
        mCardList = new ArrayList<>();
        mRecyclerViewAdapter = new RecommendRecyclerViewAdapter(mMainActivity);
        mHeaderAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter
                (mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mMainActivity));
        mRecyclerView.setAdapter(mHeaderAndFooterRecyclerViewAdapter);

        View headerView = mMainActivity.getLayoutInflater().inflate(R.layout.recommend_header,
                mRecyclerView, false);
        mRecommendBanner = ButterKnife.findById(headerView, R.id.recommend_banner);
        mRecommendBanner.setPlayDelay(3000);
        mNavsGridView = ButterKnife.findById(headerView, R.id.recommend_navs_grid);
        mBannersBeanList = new ArrayList<>();
        mNavsBeanList = new ArrayList<>();
        mBannerAdapter = new LiveTypeBannerAdapter(mRecommendBanner, mMainActivity,
                LiveTypeBannerAdapter.TYPE_RECOMMEND);
        mRecommendBanner.setAdapter(mBannerAdapter);
        mNavsAdapter = new NavsGridAdapter(mMainActivity);
        mNavsGridView.setAdapter(mNavsAdapter);

        mHeaderAndFooterRecyclerViewAdapter.addHeaderView(headerView);

        mRecommendPresenter.attachView(this);
        mRecommendPresenter.getHeaderData();
        mRecommendPresenter.getCardListData();
    }

    @Override
    protected void initListener() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRecommendPresenter.getHeaderData();
                mRecommendPresenter.getCardListData();
            }
        });

        mBannerAdapter.setBannerClickListener(new LiveTypeBannerAdapter.OnBannerClickListener() {
            @Override
            public void onClick(int position) {
                RecommendHeaderBean.DataBean.BannersBean bean = mBannersBeanList.get(position);
                if (bean.getType().equals("3")) { //跳转手机自带浏览器
                    Uri uri = Uri.parse(bean.getUrl());
                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                } else if (bean.getType().equals("0")) {
                    LiveRoomActivity.toLiveRoomActivity(mMainActivity, bean.getRoomid());
                }
            }
        });

        mNavsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                RecommendHeaderBean.DataBean.NavsBean bean = mNavsBeanList.get(i);
                Uri uri = Uri.parse(bean.getUrl());
                String host = uri.getHost();
                switch (host) {
                    case "cate":
                    case "mixcate":
                        Intent intent1 = new Intent(mMainActivity, LiveTypeDetailActivity.class);
                        intent1.setAction("com.yyl.rabbit_opentype");
                        intent1.setData(uri);
                        startActivity(intent1);
                        break;
                    case "openroom":
                        Intent intent2 = new Intent(mMainActivity, LiveRoomActivity.class);
                        intent2.setAction("com.yyl.rabbit_openroom");
                        intent2.setData(uri);
                        startActivity(intent2);
                        break;
                }

            }
        });

        mRecyclerViewAdapter.setCardItemClickListener(new RecommendRecyclerViewAdapter
                .OnRecommendCardItemClickListener() {

            @Override
            public void onCardItemClick(int position, int i) {
                RecommendCardListBean.DataBean.ItemsBean bean;
                //添加了header后，RecyclerView 子item的点击位置往后偏移header的数量个位置
                if (mHeaderAndFooterRecyclerViewAdapter.getHeaderViewsCount() != 0) {
                    bean = mCardList.get(position - mHeaderAndFooterRecyclerViewAdapter
                            .getHeaderViewsCount()).getItems().get(i);
                } else {
                    bean = mCardList.get(position).getItems().get(i);
                }
                LiveRoomActivity.toLiveRoomActivity(mMainActivity,bean.getRoomid());
            }
        });

        mRecyclerViewAdapter.setTypeCountClickListener(new RecommendRecyclerViewAdapter
                .OnCardTypeCountClickListener() {

            @Override
            public void onClick(int position) {
                RecommendCardListBean.DataBean bean;
                //添加了header后，RecyclerView 子item的点击位置往后偏移header的数量个位置
                if (mHeaderAndFooterRecyclerViewAdapter.getHeaderViewsCount() != 0) {
                    bean = mCardList.get(position - mHeaderAndFooterRecyclerViewAdapter
                            .getHeaderViewsCount());
                } else {
                    bean = mCardList.get(position);
                }
                LiveTypeDetailActivity.toLiveTypeDetailActivity(mMainActivity,
                        bean.getCard_title(),bean.getRoom_cate());
            }
        });
    }

    @Override
    public void showHeaderData(RecommendHeaderBean data) {
        mBannersBeanList.clear();
        mBannersBeanList.addAll(data.getData().getBanners());
        mNavsBeanList.clear();
        mNavsBeanList.addAll(data.getData().getNavs());
        mBannerAdapter.setRecommendBanners(mBannersBeanList);
        mNavsAdapter.setNavsBeanList(mNavsBeanList);
    }

    @Override
    public void showCardListData(List<RecommendCardListBean.DataBean> dataBeanList) {
        mSwipeRefreshLayout.setRefreshing(false);
        mCardList.clear();
        for (int i = 0; i < dataBeanList.size(); i++) {
            if (dataBeanList.get(i).getRoom_cate().equals("") &&
                    dataBeanList.get(i).getCard_type().equals("hotlist")) {
                //当数据为热门时
                mCardList.add(dataBeanList.get(i));
            } else if (!dataBeanList.get(i).getRoom_cate().equals("")){
                //当数据不为热门、猜你喜欢、熊猫星颜时
                mCardList.add(dataBeanList.get(i));
            }
        }
        mRecyclerViewAdapter.setCardBeanList(mCardList);
    }

    @Override
    public void showError() {
        Logger.e("CARDDATA" + "数据请求出错!");
    }

    @Override
    public void complete() {

    }

    @Override
    public void onResume() {
        super.onResume();
        mRecommendBanner.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mRecommendBanner.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRecommendPresenter != null) {
            mRecommendPresenter.detachView();
        }
    }
}
