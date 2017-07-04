package yyl.rabbitcloud.main.home;

import java.util.List;

import yyl.rabbitcloud.base.BaseContract;
import yyl.rabbitcloud.main.home.bean.RecommendCardListBean;
import yyl.rabbitcloud.main.home.bean.RecommendHeaderBean;

/**
 * Created by yyl on 2017/7/4.
 */

public interface RecommendContract {

    interface View extends BaseContract.BaseView {

        void showHeaderData(RecommendHeaderBean data);

        void showCardListData(List<RecommendCardListBean.DataBean> dataBeanList);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getHeaderData();

        void getCardListData();
    }

}
