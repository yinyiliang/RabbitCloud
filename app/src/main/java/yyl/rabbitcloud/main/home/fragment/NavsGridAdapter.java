package yyl.rabbitcloud.main.home.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.main.home.bean.RecommendHeaderBean;
import yyl.rabbitcloud.util.LoaderImage;

/**
 * Created by yyl on 2017/7/4.
 */

public class NavsGridAdapter extends BaseAdapter {

    private List<RecommendHeaderBean.DataBean.NavsBean> mNavsBeanList;
    private Context mContext;

    public NavsGridAdapter(Context context) {
        mContext = context;
    }

    public void setNavsBeanList(List<RecommendHeaderBean.DataBean.NavsBean> navsBeanList) {
        mNavsBeanList = navsBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mNavsBeanList == null ? 0 : mNavsBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mNavsBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        RecommendHeaderBean.DataBean.NavsBean bean = mNavsBeanList.get(position);
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_navs_grid, viewGroup, false);
            holder = new ViewHolder(view);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        LoaderImage.loadGridImg(mContext, bean.getImg(), holder.mNavsImg);
        holder.mNavsTitle.setText(bean.getTitle());
        return view;
    }

    class ViewHolder {

        @BindView(R.id.img_navs_)
        ImageView mNavsImg;
        @BindView(R.id.tv_navs_title)
        TextView mNavsTitle;

        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
