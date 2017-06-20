package yyl.rabbitcloud.di.component;

import dagger.Component;
import yyl.rabbitcloud.main.gametype.GameTypeFragment;

/**
 * Created by yyl on 2017/6/19.
 */

@Component(dependencies = AppComponent.class)
public interface FragmentComponent {

    GameTypeFragment inject(GameTypeFragment typeFragment);

}
