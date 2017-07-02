package yyl.rabbitcloud.liveroom;

import yyl.rabbitcloud.base.BaseContract;
import yyl.rabbitcloud.liveroom.bean.DanMuDataBean;
import yyl.rabbitcloud.liveroom.bean.LiveChatInfoBean;
import yyl.rabbitcloud.liveroom.bean.LiveRoomBean;

/**
 * Created by yyl on 2017/6/23.
 */

public interface LiveRoomContract {

    interface View extends BaseContract.BaseView {
        void showRoomInfo(LiveRoomBean.DataBean.InfoBean data);

        void showChatListInfo(LiveChatInfoBean bean);

        void showDanMuData(DanMuDataBean bean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getRoomInfo(String roomId);

        void getChatListInfo(String roomId);

        void connectToChatRoom(String roomId, LiveChatInfoBean pandaBean);//连接弹幕聊天室

        void closeConnection();//断开连接
    }

}
