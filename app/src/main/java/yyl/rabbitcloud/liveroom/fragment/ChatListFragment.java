package yyl.rabbitcloud.liveroom.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseFragment;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerFragmentComponent;

/**
 * Created by yyl on 2017/6/25.
 */

public class ChatListFragment extends BaseFragment implements ChatListContract.View {

    @BindView(R.id.chat_recycler_view)
    RecyclerView mChatInfoView;

    @BindView(R.id.re_load_chat)
    Button mButton;

    @Inject
    ChatInfoPresenter mChatInfoPresenter;

    private String roomId;
    private List<DanmuBean> mDanmuBeanList;
    private List<DanMuDataBean> mMuDataBeen;
    private ChatListAdapter mChatListAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_chatlist;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    public static ChatListFragment getInstance(String roomId) {
        ChatListFragment fragment = new ChatListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("roomId", roomId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initUi() {

    }

    @Override
    protected void initData() {
        roomId = getArguments().getString("roomId");

        mDanmuBeanList = new ArrayList<>();
        mMuDataBeen = new ArrayList<>();
        mChatListAdapter = new ChatListAdapter(getContext(),mMuDataBeen);
        mChatInfoView.setLayoutManager(new LinearLayoutManager(getContext()));
        mChatInfoView.setAdapter(mChatListAdapter);

        mChatInfoPresenter.attachView(this);
        mChatInfoPresenter.getChatListInfo(roomId);
    }

    @Override
    protected void initListener() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChatInfoPresenter.getChatListInfo(roomId);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mChatInfoPresenter.getChatListInfo(roomId);
    }

    @Override
    public void showChatListInfo(LiveChatInfoBean bean) {
        mChatInfoPresenter.connectToChatRoom(roomId, bean);
    }

    @Override
    public void showDanMuData(DanMuDataBean bean) {
        if (!bean.getFrom().getRid().equals("-1")) {
            if (!bean.getFrom().getNickName().equals("")) {
                mMuDataBeen.add(bean);
                mChatListAdapter.notifyDataSetChanged();
                mChatInfoView.scrollToPosition(mMuDataBeen.size()-1);
            }
        }
    }

    @Override
    public void showError() {
        Logger.e("无法连接至弹幕！");
    }

    @Override
    public void complete() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mChatInfoPresenter != null) {
            mChatInfoPresenter.detachView();
            //断开弹幕服务器连接
            mChatInfoPresenter.closeConnection();
        }

    }
}
