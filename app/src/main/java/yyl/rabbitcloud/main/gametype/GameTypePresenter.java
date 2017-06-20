package yyl.rabbitcloud.main.gametype;

import com.orhanobut.logger.Logger;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import yyl.rabbitcloud.base.RxPresenter;
import yyl.rabbitcloud.main.gametype.module.CategoryGameListBean;
import yyl.rabbitcloud.http.RabbitApi;
import yyl.rabbitcloud.main.gametype.module.GameCategoryBean;

/**
 * Created by yyl on 2017/6/19.
 */

public class GameTypePresenter extends RxPresenter<GameContract.View> implements
        GameContract.Presenter<GameContract.View> {

    private RabbitApi mRabbitApi;
    private List<CategoryGameListBean> mGameListData;

    @Inject
    GameTypePresenter(RabbitApi rabbitApi) {
        this.mRabbitApi = rabbitApi;
    }

    @Override
    public void getGameTypeData() {
        Subscription subscription = mRabbitApi.getGameTypeData()
                .map(new Func1<GameCategoryBean, List<CategoryGameListBean>>() {
                    @Override
                    public List<CategoryGameListBean> call(GameCategoryBean gameCategoryBean) {
                        return gameCategoryBean.data;
                    }
                })
                .subscribe(new Subscriber<List<CategoryGameListBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<CategoryGameListBean> data) {
                        if (data != null && mView != null) {
                            mView.showGameTypeData(data);
                        }
                    }
                });

        addSubscrebe(subscription);
    }
}
