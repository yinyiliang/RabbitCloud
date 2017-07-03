package yyl.rabbitcloud.main.gametype;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.main.MainFragment;
import yyl.rabbitcloud.main.gametype.bean.CategoryGameListBean;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.di.component.DaggerFragmentComponent;
import yyl.rabbitcloud.livebycate.LiveTypeDetailActivity;
import yyl.rabbitcloud.widget.SearchBar;

/**
 * Created by yyl on 2017/6/18.
 */

public class GameTypeFragment extends MainFragment implements GameContract.View {

    @BindView(R.id.game_searchbar)
    SearchBar mSearchBar;
    @BindView(R.id.game_refresh)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.game_recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    GameTypePresenter mTypePresenter;

    private List<CategoryGameListBean> mGameTypeList;
    private GameTypeAdapter mTypeAdapter;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_game;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected void initUi() {
        mSearchBar.setInterceptChild(true);
        mRefreshLayout.setColorSchemeColors(Color.BLUE, Color.GREEN, Color.YELLOW, Color.RED);
    }

    @Override
    protected void initData() {
        mGameTypeList = new ArrayList<>();
        mTypeAdapter = new GameTypeAdapter(mMainActivity);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mMainActivity));
        mRecyclerView.setAdapter(mTypeAdapter);

        mRefreshLayout.setRefreshing(true);
        mTypePresenter.attachView(this);
        mTypePresenter.getGameTypeData();
    }

    @OnClick({R.id.game_searchbar})
    void onclick(View view) {
        switch (view.getId()) {
            case R.id.game_searchbar:
                Snackbar.make(view, "跳转到搜索界面..", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void initListener() {
        mTypeAdapter.setGameTypeClickListener(new GameTypeAdapter.OnGameTypeClickListener() {
            @Override
            public void onClick(int categoryPosition, int position) {
                String typeName = mGameTypeList.get(categoryPosition).getChild_data().get(position).getCname();
                String typeString = mGameTypeList.get(categoryPosition).getChild_data().get(position).getEname();
                LiveTypeDetailActivity.toLiveTypeDetailActivity(mMainActivity,typeName,typeString);
            }
        });

        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTypePresenter.getGameTypeData();
            }
        });
    }

    @Override
    public void showGameTypeData(List<CategoryGameListBean> dataBeans) {
        mRefreshLayout.setRefreshing(false);
        mGameTypeList.clear();
        mGameTypeList.addAll(dataBeans);
        mTypeAdapter.setGameTypeList(dataBeans);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mTypePresenter != null) {
            mTypePresenter.detachView();
        }
    }
}
