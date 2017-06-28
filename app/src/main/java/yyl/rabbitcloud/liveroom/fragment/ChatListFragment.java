package yyl.rabbitcloud.liveroom.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.orhanobut.logger.Logger;

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

    @Inject
    ChatInfoPresenter mChatInfoPresenter;

    private String roomId;

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

        mChatInfoPresenter.attachView(this);
        mChatInfoPresenter.getChatListInfo(roomId);
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void showChatListInfo(LiveChatInfoBean bean) {
        mChatInfoPresenter.connectToChatRoom(roomId, bean);
    }

    @Override
    public void showDanmuData(DanmuBean bean) {
        Logger.e(bean.getData().getFrom().getNickName() + ":" + bean.getData().getContent());
    }

    @Override
    public void showError() {

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
