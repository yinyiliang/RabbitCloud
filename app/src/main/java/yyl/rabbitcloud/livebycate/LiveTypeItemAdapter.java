package yyl.rabbitcloud.livebycate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.livebycate.bean.LiveRoomListBean;
import yyl.rabbitcloud.util.LoaderImage;
import yyl.rabbitcloud.widget.RoundRectImageView;

/**
 * Created by yyl on 2017/6/22.
 */

public class LiveTypeItemAdapter extends RecyclerView.Adapter<LiveTypeItemAdapter.ViewHolder> {

    private List<LiveRoomListBean.DataBean.ItemsBean> mList;
    private Context mContext;
    private OnLiveTypeItemClickListener mItemClickListener;

    public LiveTypeItemAdapter(Context context) {
        mContext = context;
    }

    public void setItemList(List<LiveRoomListBean.DataBean.ItemsBean> list) {
        mList = list;
        notifyDataSetChanged();
    }

    public interface OnLiveTypeItemClickListener {
        void onClick(int position);
    }

    public void setItemClickListener(OnLiveTypeItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_livetype_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LiveRoomListBean.DataBean.ItemsBean bean = mList.get(position);
        LoaderImage.loadLiveItemImg(mContext, bean.getPictures().getImg(),holder.mRoomImg);
        holder.mRoomName.setText(bean.getName());
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
    }

    @Override
    public int getItemCount() {
        return mList == null? 0:mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.item_lt_content)
        LinearLayout itemContent;
        @BindView(R.id.item_lt_item_img)
        RoundRectImageView mRoomImg;
        @BindView(R.id.item_lt_item_roomname)
        TextView mRoomName;
        @BindView(R.id.item_lt_item_author)
        TextView mAuthorName;
        @BindView(R.id.item_lt_item_rn)
        TextView mOnLookers;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemContent.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onClick(getAdapterPosition());
            }
        }
    }
}
