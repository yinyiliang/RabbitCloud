package yyl.rabbitcloud.liveroom;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yyl on 2017/7/2.
 */

public class LiveRoomViewPagerAdapter extends PagerAdapter {

    private List<View> mViewList;
    private String[] titles;

    public LiveRoomViewPagerAdapter(String[] titles) {
        this.titles = titles;
    }

    public void setViewList(List<View> viewList) {
        mViewList = viewList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mViewList == null? 0:mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null) {
            return titles[position];
        } else {
            return "";
        }
    }
}
