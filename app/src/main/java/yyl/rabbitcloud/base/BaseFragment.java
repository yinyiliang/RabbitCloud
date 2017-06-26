package yyl.rabbitcloud.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import yyl.rabbitcloud.App;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.main.MainActivity;

/**
 * Created by yyl on 2017/6/18.
 */

public abstract class BaseFragment extends Fragment {

    protected View mContainerView;

    public abstract
    @LayoutRes
    int getLayoutResId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mContainerView = inflater.inflate(getLayoutResId(), container, false);
        return mContainerView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,mContainerView);
        setupActivityComponent(App.getAppInstance().getAppComponent());
        initUi();
        initData();
        initListener();
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    protected abstract void initUi();

    protected abstract void initData();

    protected abstract void initListener();
}
