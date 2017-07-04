package yyl.rabbitcloud.livebycate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.livebycate.bean.LiveRoomListBean;
import yyl.rabbitcloud.main.home.bean.AllLiveListBean;
import yyl.rabbitcloud.util.LoaderImage;
import yyl.rabbitcloud.widget.RoundRectImageView;

/**
 * Created by yyl on 2017/6/22.
 */

public class LiveTypeItemAdapter extends RecyclerView.Adapter<LiveTypeItemAdapter.ViewHolder> {

    public static final String TYPE_ALL = "all";
    public static final String TYPE_CATE = "cate";

    private List<LiveRoomListBean.DataBean.ItemsBean> mCateList;
    private List<AllLiveListBean.DataBean.ItemsBean> mAllList;
    private Context mContext;
    private OnLiveTypeItemClickListener mItemClickListener;
    private String dataType;

    public LiveTypeItemAdapter(Context context, String dataType) {
        mContext = context;
        this.dataType = dataType;
    }

    public void setItemList(List<LiveRoomListBean.DataBean.ItemsBean> list) {
        mCateList = list;
        notifyDataSetChanged();
    }

    public void setAllList(List<AllLiveListBean.DataBean.ItemsBean> allList) {
        mAllList = allList;
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
        String imgUrl, roomName, authorName, personNum;
        if (dataType.equals(TYPE_ALL)) {
            AllLiveListBean.DataBean.ItemsBean bean = mAllList.get(position);
            imgUrl = bean.getPictures().getImg();
            roomName = bean.getName();
            authorName = bean.getUserinfo().getNickName();
            personNum = bean.getPerson_num();
        } else {
            LiveRoomListBean.DataBean.ItemsBean bean = mCateList.get(position);
            imgUrl = bean.getPictures().getImg();
            roomName = bean.getName();
            authorName = bean.getUserinfo().getNickName();
            personNum = bean.getPerson_num();
        }

        LoaderImage.loadLiveItemImg(mContext, imgUrl,holder.mRoomImg);
        holder.mRoomName.setText(roomName);
        holder.mAuthorName.setText(authorName);
        int person_num = Integer.parseInt(personNum);
        String persons;
        if (personNum.length() > 4) {
            persons = String.format("%.1f", person_num / 10000.0);
            persons = persons + "万";
        } else {
            persons = String.valueOf(person_num);
        }
        holder.mOnLookers.setText(persons);
    }

    @Override
    public int getItemCount() {

        if (dataType.equals(TYPE_ALL)) {
            return mAllList == null? 0:mAllList.size();
        }

        return mCateList == null? 0:mCateList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.item_lt_content)
        RelativeLayout itemContent;
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
