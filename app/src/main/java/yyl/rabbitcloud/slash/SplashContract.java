package yyl.rabbitcloud.slash;

import yyl.rabbitcloud.base.BaseContract;
import yyl.rabbitcloud.bean.SplashScreenBean;

/**
 * Created by yyl on 2017/6/9.
 */

public interface SplashContract {

    interface View extends BaseContract.BaseView{

        void showSplashData(SplashScreenBean.DataBean.RmddataBean data);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getSplashData();

    }

}
