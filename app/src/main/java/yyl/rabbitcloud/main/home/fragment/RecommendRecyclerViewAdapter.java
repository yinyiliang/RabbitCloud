package yyl.rabbitcloud.main.home.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.main.home.bean.RecommendCardListBean;
import yyl.rabbitcloud.util.SmallToolsHelper;
import yyl.rabbitcloud.widget.MyGridView;

/**
 * 推荐界面 RecyclerView适配器
 * Created by yyl on 2017/7/4.
 */

public class RecommendRecyclerViewAdapter extends RecyclerView
        .Adapter<RecommendRecyclerViewAdapter.ViewHolder> {

    private List<RecommendCardListBean.DataBean> mCardBeanList;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnRecommendCardItemClickListener mCardItemClickListener;
    private OnCardTypeCountClickListener mTypeCountClickListener;

    public RecommendRecyclerViewAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public interface OnRecommendCardItemClickListener {
        void onCardItemClick(int position, int i);
    }

    public interface OnCardTypeCountClickListener {
        void onClick(int position);
    }

    public void setTypeCountClickListener(OnCardTypeCountClickListener typeCountClickListener) {
        mTypeCountClickListener = typeCountClickListener;
    }

    public void setCardItemClickListener(OnRecommendCardItemClickListener clickListener) {
        mCardItemClickListener = clickListener;
    }

    public void setCardBeanList(List<RecommendCardListBean.DataBean> cardBeanList) {
        mCardBeanList = cardBeanList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recommend_card_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RecommendCardListBean.DataBean bean = mCardBeanList.get(position);

        CardGridItemAdapter gridItemAdapter;
        if (holder.mTypeGridView.getAdapter() != null) {
            gridItemAdapter = (CardGridItemAdapter) holder.mTypeGridView.getAdapter();
            gridItemAdapter.setBeanList(bean.getItems());
        } else {
            gridItemAdapter = new CardGridItemAdapter(mContext);
            holder.mTypeGridView.setAdapter(gridItemAdapter);
            gridItemAdapter.setBeanList(bean.getItems());
        }

        //动态测量GridView的高度
        SmallToolsHelper.setGridViewHeightByChildren(holder.mTypeGridView);
        holder.typeName.setText(bean.getCard_title());
        //当关于直播总数的参数不为空，则显示出计数
        if (bean.getTotal() != null) {
            holder.ll_liveRoomCount.setVisibility(View.VISIBLE);
            holder.mLiveRoomCount.setText(String.format(mContext.getString(
                    R.string.live_room_count), bean.getTotal()));
        } else {
            holder.ll_liveRoomCount.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mCardBeanList == null ? 0 : mCardBeanList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener,
            View.OnClickListener{

        @BindView(R.id.item_card_name)
        TextView typeName;
        @BindView(R.id.item_card_gridview)
        MyGridView mTypeGridView;
        @BindView(R.id.ll_live_total)
        LinearLayout ll_liveRoomCount;
        @BindView(R.id.tv_live_count)
        TextView mLiveRoomCount;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mTypeGridView.setNumColumns(2);
            mTypeGridView.setOnItemClickListener(this);
            ll_liveRoomCount.setOnClickListener(this);
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            mCardItemClickListener.onCardItemClick(getAdapterPosition(), i);
        }

        @Override
        public void onClick(View view) {
            mTypeCountClickListener.onClick(getAdapterPosition());
        }
    }
}
