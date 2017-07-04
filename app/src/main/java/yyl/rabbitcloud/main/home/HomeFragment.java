package yyl.rabbitcloud.main.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseFragment;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.main.home.fragment.AllListFragment;
import yyl.rabbitcloud.main.home.fragment.ChijiFragment;
import yyl.rabbitcloud.main.home.fragment.RecommendFragment;

/**
 * Created by yyl on 2017/6/18.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.home_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.home_viewpager)
    ViewPager mViewPager;

    private HomePagerAdapter mPagerAdapter;
    private List<Fragment> mFragmentList;
    private String[] titles;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initData() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new RecommendFragment());
        mFragmentList.add(new AllListFragment());
        mFragmentList.add(new ChijiFragment());
        titles = new String[]{"推荐", "全部", "吃鸡"};
        mPagerAdapter = HomePagerAdapter.getInstance(getChildFragmentManager(),
                mFragmentList, titles);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initListener() {

    }
}
