package yyl.rabbitcloud.livebycate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.List;

import yyl.rabbitcloud.livebycate.bean.LiveRoomListBean;
import yyl.rabbitcloud.main.home.bean.RecommendHeaderBean;
import yyl.rabbitcloud.util.LoaderImage;

/**
 * Created by yyl on 2017/6/21.
 */

public class LiveTypeBannerAdapter extends LoopPagerAdapter {

    public static final String TYPE_RECOMMEND = "recommend";
    public static final String TYPE_CATE = "cate";

    private List<LiveRoomListBean.DataBean.BannersBean> bannersData;
    private List<RecommendHeaderBean.DataBean.BannersBean> mRecommendBanners;
    private Context mContext;
    private OnBannerClickListener mBannerClickListener;
    private String dataType;

    public LiveTypeBannerAdapter(RollPagerView viewPager, Context context, String type) {
        super(viewPager);
        this.mContext = context;
        this.dataType = type;
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

    public void setRecommendBanners(List<RecommendHeaderBean.DataBean.BannersBean>
                                            recommendBanners) {
        mRecommendBanners = recommendBanners;
        notifyDataSetChanged();
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        String imgUrl;
        if (dataType.equals(TYPE_RECOMMEND)) {
            RecommendHeaderBean.DataBean.BannersBean bannersBean = mRecommendBanners.get(position);
            imgUrl = bannersBean.getImg();
        } else {
            LiveRoomListBean.DataBean.BannersBean bannersBean = bannersData.get(position);
            imgUrl = bannersBean.getBigimg();
        }
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

        LoaderImage.loadBannerImg(mContext, imgUrl, view);
        return view;
    }

    @Override
    public int getRealCount() {
        if (dataType.equals(TYPE_RECOMMEND)) {
            return mRecommendBanners == null ? 0 : mRecommendBanners.size();
        }
        return bannersData == null ? 0 : bannersData.size();
    }
}
