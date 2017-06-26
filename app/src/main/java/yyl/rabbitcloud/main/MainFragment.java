package yyl.rabbitcloud.main;

import android.content.Context;

import yyl.rabbitcloud.base.BaseFragment;

/**
 * Created by yyl on 2017/6/25.
 */

public abstract class MainFragment extends BaseFragment {

    protected MainActivity mMainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mMainActivity = (MainActivity) context;
    }

}
