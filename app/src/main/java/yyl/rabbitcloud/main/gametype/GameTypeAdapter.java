package yyl.rabbitcloud.main.gametype;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.main.gametype.bean.CategoryGameListBean;
import yyl.rabbitcloud.widget.MyGridView;

/**
 * 游戏类型适配器
 * 此类中的动态计算gridview高度还需使用自定义的MyGridView配合使用。以及GridView中的图片需要固定高度值
 * Created by yyl on 2017/6/19.
 */

public class GameTypeAdapter extends RecyclerView.Adapter<GameTypeAdapter.ViewHolder> {

    private List<CategoryGameListBean> mGameTypeList;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnGameTypeClickListener mListener;

    public GameTypeAdapter(Context context) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setGameTypeList(List<CategoryGameListBean> gameTypeList) {
        mGameTypeList = gameTypeList;
        notifyDataSetChanged();
    }

    public interface OnGameTypeClickListener {
        void onClick(int categoryPosition ,int position);
    }

    public void setGameTypeClickListener(OnGameTypeClickListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_game_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CategoryGameListBean bean = mGameTypeList.get(position);

        GameGridAdapter mGameGridAdapter;
        if (holder.mGameGridView.getAdapter() != null) {
            mGameGridAdapter = (GameGridAdapter) holder.mGameGridView.getAdapter();
            mGameGridAdapter.setChildDataBeen(bean.getChild_data());
        } else {
            mGameGridAdapter = new GameGridAdapter(mContext);
            holder.mGameGridView.setAdapter(mGameGridAdapter);
            mGameGridAdapter.setChildDataBeen(bean.getChild_data());
        }
        //动态测量GridView的高度
        setGridViewHeightByChildren(holder.mGameGridView);
        holder.gameName.setText(bean.getCname());

        holder.mGameGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.onClick(position,i);
            }
        });
    }

    /**
     * 根据子item的高度 动态测量GridView的实际高度
     * @param gridView
     */
    private void setGridViewHeightByChildren(GridView gridView) {
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        //总高度
        int totalHeight = 0;
        int lineNum = gridView.getNumColumns(); //得到布局文件中设置的一行显示几个
        View item = listAdapter.getView(0,null,gridView);
        item.measure(0,0); //计算子item的高度
        //得到总高度
        totalHeight = item.getMeasuredHeight()*lineNum;

        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.height = totalHeight;
        gridView.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return mGameTypeList == null? 0:mGameTypeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_game_name)
        TextView gameName;
        @BindView(R.id.item_game_gridview)
        MyGridView mGameGridView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
