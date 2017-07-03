package yyl.rabbitcloud.main.gametype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.main.gametype.bean.CategoryGameListBean;
import yyl.rabbitcloud.util.LoaderImage;

/**
 * Created by yyl on 2017/6/20.
 */

public class GameGridAdapter extends BaseAdapter {

    private List<CategoryGameListBean.ChildDataBean> mChildDataBeen;
    private Context mContext;

    public GameGridAdapter(Context context) {
        mContext = context;
    }

    public void setChildDataBeen(List<CategoryGameListBean.ChildDataBean> childDataBeen) {
        mChildDataBeen = childDataBeen;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mChildDataBeen == null? 0:mChildDataBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return mChildDataBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryGameListBean.ChildDataBean bean = mChildDataBeen.get(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_game_grid_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mGameName.setText(bean.getCname());
        LoaderImage.loadGridImg(mContext,bean.getImg(),holder.mGameImg);

        return convertView;
    }

    class ViewHolder {

        @BindView(R.id.item_game_grid_img)
        ImageView mGameImg;
        @BindView(R.id.item_game_grid_name)
        TextView mGameName;

        public ViewHolder(View itemView) {
            ButterKnife.bind(this,itemView);
        }
    }
}
