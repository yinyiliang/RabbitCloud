package yyl.rabbitcloud.liveroom.fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseFragment;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.liveroom.LiveRoomBean;
import yyl.rabbitcloud.util.LoaderImage;

/**
 * Created by yyl on 2017/6/25.
 */

public class AnchorInfoFragment extends BaseFragment {

    @BindView(R.id.img_anchor_head)
    ImageView mAnchorHead;
    @BindView(R.id.tv_anchor_name)
    TextView mAnchorName;
    @BindView(R.id.tv_live_room_room_id)
    TextView mAnchorRoomId;
    @BindView(R.id.tv_anchor_height)
    TextView mAnchorHeight;
    @BindView(R.id.tv_anchor_fans)
    TextView mAnchorFans;
    @BindView(R.id.tv_live_room_livedetail)
    TextView mAnchorLiveRoomDetail;

    private LiveRoomBean.DataBean.InfoBean mLiveRoomBeanData;

    public static AnchorInfoFragment getInstance(LiveRoomBean.DataBean.InfoBean data) {
        AnchorInfoFragment fragment = new AnchorInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("LiveRoomBean", data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_anchor_info;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initData() {
        mLiveRoomBeanData = (LiveRoomBean.DataBean.InfoBean) getArguments().getSerializable("LiveRoomBean");

        LoaderImage.loadCircleImg(getContext(),mLiveRoomBeanData.getHostinfo().getAvatar(),mAnchorHead);
        mAnchorName.setText(mLiveRoomBeanData.getHostinfo().getName());
        mAnchorRoomId.setText(String.format(getString(R.string.room_id),
                mLiveRoomBeanData.getRoominfo().getId()));
        String banboos = mLiveRoomBeanData.getHostinfo().getBamboos();
        mAnchorHeight.setText(String.format(getString(R.string.anchor_height), unitConversion(banboos)));
        int person_num = Integer.parseInt(mLiveRoomBeanData.getRoominfo().getFans());
        String persons;
        if (person_num > 10000) {
            persons = String.format("%.1f", (person_num / 10000.0));
            persons = persons + "万";
        } else {
            persons = String.valueOf(person_num);
        }
        mAnchorFans.setText(String.format(getString(R.string.anchor_fans), persons));
        mAnchorLiveRoomDetail.setText(mLiveRoomBeanData.getRoominfo().getBulletin());
    }

    /**
     * 身高单位转换
     * @param banboos
     * @return
     */
    private String unitConversion(String banboos) {
        double value = Double.parseDouble(banboos);
        if (banboos.length() <= 4) {
            return value + "μm";
        } else if (banboos.length() > 4 & banboos.length() < 7) {
            return String.format("%.2f", value / 1000) + "mm";
        } else if (banboos.length() >= 7) {
            return String.format("%.2f", value / 1000000) + "m";
        }
        return "0";
    }

    @Override
    protected void initListener() {

    }
}
