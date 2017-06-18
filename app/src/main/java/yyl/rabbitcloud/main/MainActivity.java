package yyl.rabbitcloud.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.FrameLayout;

import butterknife.BindView;
import me.majiajie.pagerbottomtabstrip.ItemController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import yyl.rabbitcloud.R;
import yyl.rabbitcloud.base.BaseActivity;
import yyl.rabbitcloud.di.component.AppComponent;
import yyl.rabbitcloud.main.gametype.GameTypeFragment;
import yyl.rabbitcloud.main.home.HomeFragment;
import yyl.rabbitcloud.main.me.MeFragment;
import yyl.rabbitcloud.main.discovery.DiscoveryFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_content)
    FrameLayout mContentLayout;
    @BindView(R.id.main_bottom_view)
    PageBottomTabLayout mNavigationView;

    private ItemController mItemController;
    private HomeFragment mHomeFragment;
    private GameTypeFragment mGameTypeFragment;
    private DiscoveryFragment mSearchFragment;
    private MeFragment mMeFragment;

    @Override
    protected void requestLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initUi() {
        mItemController = mNavigationView.custom()
                .addItem(newItem(R.drawable.ic_home_grey_500_24dp,R.drawable.ic_home_grey_800_24dp,"首页"))
                .addItem(newItem(R.drawable.ic_games_grey_500_24dp,R.drawable.ic_games_grey_800_24dp,"游戏"))
                .addItem(newItem(R.drawable.ic_search_grey_500_24dp,R.drawable.ic_search_grey_800_24dp,"发现"))
                .addItem(newItem(R.drawable.ic_person_outline_grey_500_24dp,R.drawable.ic_person_grey_800_24dp,"我的"))
                .build();
    }

    @Override
    protected void initData() {
        showFragment(0);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (mHomeFragment == null && fragment instanceof HomeFragment) {
            mHomeFragment = (HomeFragment) fragment;
        } else if (mGameTypeFragment == null && fragment instanceof GameTypeFragment) {
            mGameTypeFragment = (GameTypeFragment) fragment;
        } else if (mSearchFragment == null && fragment instanceof DiscoveryFragment) {
            mSearchFragment = (DiscoveryFragment) fragment;
        } else if (mMeFragment == null && fragment instanceof MeFragment) {
            mMeFragment = (MeFragment) fragment;
        }
    }

    private void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        hideFragment(ft);
        switch (index) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    ft.add(R.id.main_content, mHomeFragment);
                } else {
                    ft.show(mHomeFragment);
                }
                break;
            case 1:
                if (mGameTypeFragment == null) {
                    mGameTypeFragment = new GameTypeFragment();
                    ft.add(R.id.main_content, mGameTypeFragment);
                } else {
                    ft.show(mGameTypeFragment);
                }
                break;
            case 2:
                if (mSearchFragment == null) {
                    mSearchFragment = new DiscoveryFragment();
                    ft.add(R.id.main_content, mSearchFragment);
                } else {
                    ft.show(mSearchFragment);
                }
                break;
            case 3:
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                    ft.add(R.id.main_content, mMeFragment);
                } else {
                    ft.show(mMeFragment);
                }
                break;
        }
        ft.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        if (mHomeFragment != null) ft.hide(mHomeFragment);
        if (mGameTypeFragment != null) ft.hide(mGameTypeFragment);
        if (mSearchFragment != null) ft.hide(mSearchFragment);
        if (mMeFragment != null) ft.hide(mMeFragment);
    }

    @Override
    protected void initListener() {
        mItemController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                showFragment(index);
            }

            @Override
            public void onRepeat(int index) {

            }
        });
    }

    //创建一个Item
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(ContextCompat.getColor(this, R.color.md_grey_500));
        normalItemView.setTextCheckedColor(ContextCompat.getColor(this, R.color.md_grey_800));
        return normalItemView;
    }
}
