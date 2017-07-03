package yyl.rabbitcloud.main.gametype;

import java.util.List;

import yyl.rabbitcloud.base.BaseContract;
import yyl.rabbitcloud.main.gametype.bean.CategoryGameListBean;

/**
 * Created by yyl on 2017/6/19.
 */

public interface GameContract {

    interface View extends BaseContract.BaseView {
        void showGameTypeData(List<CategoryGameListBean> dataBeans);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getGameTypeData();
    }

}
