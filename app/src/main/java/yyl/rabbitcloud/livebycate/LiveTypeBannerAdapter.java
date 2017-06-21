package yyl.rabbitcloud.livebycate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.List;

import yyl.rabbitcloud.livebycate.module.LiveRoomListBean;
import yyl.rabbitcloud.util.LoaderImage;

/**
 * Created by yyl on 2017/6/21.
 */

public class LiveTypeBannerAdapter extends LoopPagerAdapter {

    private List<LiveRoomListBean.DataBean.BannersBean> bannersData;
    private Context mContext;
    private OnBannerClickListener mBannerClickListener;

    public LiveTypeBannerAdapter(RollPagerView viewPager, Context context) {
        super(viewPager);
        this.mContext = context;
    }

    public interface OnBannerClickListener {
        void onClick(int position);
    }

    public void setBannerClickListener(OnBannerClickListener bannerClickListener) {
        mBannerClickListener = bannerClickListener;
    }

    public void setBannersData(List<LiveRoomListBean.DataBean.BannersBean> bannersData) {
        this.bannersData = bannersData;
        notifyDataSetChanged();
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        LiveRoomListBean.DataBean.BannersBean bannersBean = bannersData.get(position);
        ImageView view = new ImageView(container.getContext());
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mBannerClickListener.onClick(position);
            }
        });
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        LoaderImage.load(mContext, bannersBean.getBigimg(), view);
        return view;
    }

    @Override
    public int getRealCount() {
        return bannersData == null ? 0 : bannersData.size();
    }
}
