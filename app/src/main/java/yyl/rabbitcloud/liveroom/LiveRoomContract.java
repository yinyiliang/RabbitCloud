package yyl.rabbitcloud.liveroom;

import yyl.rabbitcloud.base.BaseContract;

/**
 * Created by yyl on 2017/6/23.
 */

public interface LiveRoomContract {

    interface View extends BaseContract.BaseView {
        void showRoomInfo(LiveRoomBean.DataBean.InfoBean data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getRoomInfo(String roomId);
    }

}
