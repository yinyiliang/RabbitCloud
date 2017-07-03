package yyl.rabbitcloud.main.gametype;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import yyl.rabbitcloud.base.RxPresenter;
import yyl.rabbitcloud.main.gametype.bean.CategoryGameListBean;
import yyl.rabbitcloud.http.RabbitApi;
import yyl.rabbitcloud.main.gametype.bean.GameCategoryBean;

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
        Disposable disposable = mRabbitApi.getGameTypeData()
                .map(new Function<GameCategoryBean, List<CategoryGameListBean>>() {
                    @Override
                    public List<CategoryGameListBean> apply(GameCategoryBean gameCategoryBean) {
                        return gameCategoryBean.data;
                    }
                })
                .subscribe(new Consumer<List<CategoryGameListBean>>() {
                    @Override
                    public void accept(@NonNull List<CategoryGameListBean> data)
                            throws Exception {
                        if (data != null && mView != null) {
                            mView.showGameTypeData(data);
                        }
                    }
                });

        addDisposable(disposable);
    }
}
