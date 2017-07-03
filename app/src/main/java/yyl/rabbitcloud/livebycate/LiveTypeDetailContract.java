package yyl.rabbitcloud.livebycate;

import java.util.List;

import yyl.rabbitcloud.base.BaseContract;
import yyl.rabbitcloud.livebycate.bean.LiveRoomListBean;

/**
 * Created by yyl on 2017/6/21.
 */

public interface LiveTypeDetailContract {

    interface View extends BaseContract.BaseView {

        void showLiveTypeBannerData(List<LiveRoomListBean.DataBean.BannersBean> data);

        void showLiveTypeItemsData(List<LiveRoomListBean.DataBean.ItemsBean> data);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getLiveTypeData(String cate,int pageno,int pagenum);

    }

}
