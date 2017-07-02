package yyl.rabbitcloud.liveroom;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.liveroom.bean.DanMuDataBean;

/**
 * Created by yyl on 2017/6/28.
 */

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<DanMuDataBean> mDanmuBeans;

    public ChatListAdapter(Context context, List<DanMuDataBean> danmuBeans) {
        mContext = context;
        this.mDanmuBeans = danmuBeans;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_chat_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DanMuDataBean danmuBean = mDanmuBeans.get(position);
        String name = danmuBean.getFrom().getNickName()+ ":";
        String content = danmuBean.getContent();
        String s = "<font color='#2196f3'>"+ name +"</font> <font color='#DE000000'>"+ content + "</font>";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.chatContent.setText(Html.fromHtml(s,
                    Html.FROM_HTML_MODE_COMPACT));
        } else {
            holder.chatContent.setText(Html.fromHtml(s));
        }
    }

    @Override
    public int getItemCount() {
        return mDanmuBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_chat_content)
        TextView chatContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
