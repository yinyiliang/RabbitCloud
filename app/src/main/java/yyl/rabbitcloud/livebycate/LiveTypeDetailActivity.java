package yyl.rabbitcloud.livebycate;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseActivity;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerActivityComponent;
import yyl.rabbitcloud.livebycate.module.LiveRoomListBean;

/**
 * Created by yyl on 2017/6/19.
 */

public class LiveTypeDetailActivity extends BaseActivity implements LiveTypeDetailContract.View {

    @BindView(R.id.livetype_banner)
    RollPagerView mBannerView;
    @BindView(R.id.livetype_recyclerview)
    RecyclerView mRecyclerView;

    @Inject
    LiveTypeDetailPresenter mDetailPresenter;

    private String mTypeString;
    private int pagerNow = 1;
    private int pagerNum = 20;

    private List<LiveRoomListBean.DataBean.BannersBean> mBannersBeen;
    private LiveTypeBannerAdapter mBannerAdapter;

    @Override
    protected void requestLayout() {
        setContentView(R.layout.activity_livetype_detail);
    }

    @Override
    protected void initToolBar() {
        String typeName = getIntent().getStringExtra("typeName");
        mToolbar.setTitle(typeName);
    }

    public static void toLiveTypeDetailActivity(BaseActivity activity,String typeName, String type) {
        Intent intent = new Intent(activity, LiveTypeDetailActivity.class);
        intent.putExtra("typeName", typeName);
        intent.putExtra("typeString",type);
        activity.startActivity(intent);
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initData() {
        mTypeString = getIntent().getStringExtra("typeString");

        mBannersBeen = new ArrayList<>();
        mBannerAdapter = new LiveTypeBannerAdapter(mBannerView,this);
        mBannerView.setAdapter(mBannerAdapter);
        mBannerView.setPlayDelay(2000);

        mDetailPresenter.attachView(this);
        mDetailPresenter.getLiveTypeData(mTypeString,pagerNow,pagerNum);
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
                Toast.makeText(LiveTypeDetailActivity.this,"点击了" + position+"个Banner",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showLiveTypeBannerData(List<LiveRoomListBean.DataBean.BannersBean> data) {
        mBannerAdapter.setBannersData(data);
    }

    @Override
    public void showLiveTypeItemsData(List<LiveRoomListBean.DataBean.ItemsBean> data) {

    }

    @Override
    public void showError() {
        Logger.d("数据出错！");
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
