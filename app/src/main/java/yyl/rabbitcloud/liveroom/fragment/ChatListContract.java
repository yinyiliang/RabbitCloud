package yyl.rabbitcloud.liveroom.fragment;

import yyl.rabbitcloud.base.BaseContract;

/**
 * Created by yyl on 2017/6/27.
 */

public interface ChatListContract {

    interface View extends BaseContract.BaseView {
        void showChatListInfo(LiveChatInfoBean bean);

        void showDanMuData(DanMuDataBean bean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getChatListInfo(String roomId);

        void connectToChatRoom(String roomId, LiveChatInfoBean pandaBean);//连接弹幕聊天室

        void closeConnection();//断开连接
    }

}
