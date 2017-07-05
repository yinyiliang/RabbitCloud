package yyl.rabbitcloud.main.home.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.main.home.bean.RecommendCardListBean;
import yyl.rabbitcloud.util.LoaderImage;
import yyl.rabbitcloud.widget.RoundRectImageView;

/**
 * Created by yyl on 2017/7/4.
 */

public class CardGridItemAdapter extends BaseAdapter {

    private List<RecommendCardListBean.DataBean.ItemsBean> mBeanList;
    private Context mContext;
    private boolean isHotList;

    public CardGridItemAdapter(Context context) {
        mContext = context;
    }

    public void setBeanList(List<RecommendCardListBean.DataBean.ItemsBean> beanList,
                            boolean isHotList) {
        this.mBeanList = beanList;
        this.isHotList = isHotList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mBeanList == null ? 0 : mBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RecommendCardListBean.DataBean.ItemsBean bean = mBeanList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_livetype_item, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        LoaderImage.loadLiveItemImg(mContext, bean.getImg(),holder.mRoomImg);
        holder.mRoomName.setText(bean.getTitle());
        holder.mAuthorName.setText(bean.getUserinfo().getNickName());
        int person_num = Integer.parseInt(bean.getPerson_num());
        String persons;
        if (bean.getPerson_num().length() > 4) {
            persons = String.format("%.1f", person_num / 10000.0);
            persons = persons + "万";
        } else {
            persons = String.valueOf(person_num);
        }
        holder.mOnLookers.setText(persons);

        //TODO 如果是热门数据 则添加标示
        if (isHotList) {
            holder.ll_item_label.setVisibility(View.VISIBLE);
            holder.mHotItemTitle.setText(bean.getClassification().getCname());
        } else {
            holder.ll_item_label.setVisibility(View.GONE);
        }

        return convertView;
    }

    class ViewHolder {

        @BindView(R.id.ll_hot_live_label)
        LinearLayout ll_item_label;
        @BindView(R.id.tv_hot_live_title)
        TextView mHotItemTitle;
        @BindView(R.id.item_lt_item_img)
        RoundRectImageView mRoomImg;
        @BindView(R.id.item_lt_item_roomname)
        TextView mRoomName;
        @BindView(R.id.item_lt_item_author)
        TextView mAuthorName;
        @BindView(R.id.item_lt_item_rn)
        TextView mOnLookers;

        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }

    }
}
