package yyl.rabbitcloud.http;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.Observable;

/**
 *
 * 将一些重复的操作提出来，放到父类以免Loader 里每个接口都有重复代码
 *
 */

class ObjectLoader {
    /**
     *
     * @param observable
     * @param <T>
     * @return
     */
    <T> Observable<T> observe(Observable<T> observable){
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
