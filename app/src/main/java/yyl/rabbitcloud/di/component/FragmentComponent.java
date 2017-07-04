package yyl.rabbitcloud.di.component;

import dagger.Component;
import yyl.rabbitcloud.main.gametype.GameTypeFragment;
import yyl.rabbitcloud.main.home.fragment.AllListFragment;
import yyl.rabbitcloud.main.home.fragment.ChijiFragment;
import yyl.rabbitcloud.main.home.fragment.RecommendFragment;

/**
 * Created by yyl on 2017/6/19.
 */

@Component(dependencies = AppComponent.class)
public interface FragmentComponent {

    GameTypeFragment inject(GameTypeFragment typeFragment);

    AllListFragment inject(AllListFragment allListFragment);

    ChijiFragment inject(ChijiFragment allListFragment);

    RecommendFragment inject(RecommendFragment recommendFragment);
}
