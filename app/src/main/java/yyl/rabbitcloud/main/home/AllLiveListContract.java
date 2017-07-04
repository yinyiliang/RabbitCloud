package yyl.rabbitcloud.main.home;

import java.util.List;

import yyl.rabbitcloud.base.BaseContract;
import yyl.rabbitcloud.livebycate.bean.LiveRoomListBean;
import yyl.rabbitcloud.main.home.bean.AllLiveListBean;

/**
 * Created by yyl on 2017/7/4.
 */

public interface AllLiveListContract {

    interface View extends BaseContract.BaseView {
        void showAllLiveListData(List<AllLiveListBean.DataBean.ItemsBean> data);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getAllLiveList(int pageno, int pagenum);
    }
}
