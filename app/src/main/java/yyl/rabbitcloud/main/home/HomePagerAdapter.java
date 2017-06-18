package yyl.rabbitcloud.main.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yyl on 2017/6/18.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private String[] titles;

    public static HomePagerAdapter getInstance(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        HomePagerAdapter mainPagerAdapter = new HomePagerAdapter(fm);
        mainPagerAdapter.mFragments = fragments;
        mainPagerAdapter.titles = titles;
        return mainPagerAdapter;
    }

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int arg0) {
        return mFragments.get(arg0);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null) {
            return titles[position];
        } else {
            return "";
        }
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
