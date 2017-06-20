package yyl.rabbitcloud.http;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import yyl.rabbitcloud.main.gametype.module.CategoryGameListBean;
import yyl.rabbitcloud.bean.FindRoomInfoByIdBean;
import yyl.rabbitcloud.bean.RecommendInfoBean;
import yyl.rabbitcloud.bean.RoomBean;
import yyl.rabbitcloud.bean.SearchRoomBean;
import yyl.rabbitcloud.bean.SplashScreenBean;
import yyl.rabbitcloud.main.gametype.module.GameCategoryBean;

/**
 * Created by yyl on 2017/6/1.
 */

public interface ServiceAPI {

    //闪屏界面图片显示
    /**
     *     http://static.api.m.panda.tv/index.php?
     *     method=clientconf.firstscreen&__version=3.1.4.36223&__plat=android&__channel=guanwang
     */
    @GET("index.php?method=clientconf.firstscreen&__version=3.1.4.36223&__plat=android&__channel=guanwang")
    Observable<SplashScreenBean> getSplashScreen();

    //推荐界面
    /*
    http://static.api.m.panda.tv/android_hd/androidhdindex.json
    包括 广告栏  和热门数据
     */
    @GET("android_hd/androidhdindex.json")
    Observable<RecommendInfoBean> getRecommendData();

    //所有类别 返回其中10个频道  全部
    /**
     * pageno=1 返回10条、 pageno=2 返回另外10条
     *
     * http://static.api.m.panda.tv/android_hd/alllist_.json?pageno=1
     */
    @GET("android_hd/alllist_.json?")
    Observable<RoomBean> getAllCategoriesData(@Query("pageno") int pageno);

    //返回某个类别的10条数据
    /**
     * http://static.api.m.panda.tv/android_hd/catelist_.json?cate=yzdr&pageno=1
     * 或者
     * http://api.m.panda.tv/ajax_get_live_list_by_cate?
     * cate=yzdr&pageno=1&pagenum=4&__version=3.1.4.36223&__plat=android_hd
     *
     * http://api.m.panda.tv/ajax_get_live_list_by_cate?
     * cate=lol&pageno=1&pagenum=20&sproom=1&banner=1&slider=1
     * &__version=3.1.7.3811&__plat=android  //最新
     */
    @GET("android_hd/catelist_.json?")
    Observable<RoomBean> getRoomInfoByCate(@Query("cate") String cate, @Query("pageno") int pageno);

    //返回游戏类型
    /**
     * http://static.api.m.panda.tv/android_hd/cate.json //不给力
     *
     * http://api.m.panda.tv/index.php?method=category.gamelist&__version=3.1.7.3811
     * &__plat=android&__channel=huawei
     */
    @GET("http://api.m.panda.tv/index.php?method=category.gamelist&__version=3.1.7.3811&__plat=android&__channel=huawei")
    Observable<GameCategoryBean> getCategoryData();

    //根据房间号获取房间信息
    /**
     * http://room.api.m.panda.tv/index.php?
     * method=room.getinfo&roomid=821392&__plat=android_hd&&__version=3.1.4.36223
     */
    @GET("http://room.api.m.panda.tv/index.php?method=room.getinfo&__plat=android_hd&&__version=3.1.4.36223")
    Observable<FindRoomInfoByIdBean> findRoomInfoById(@Query("roomid") String roomid);

    //搜索房间信息
    /**
     * http://api.m.panda.tv/ajax_search?roomid=821392
     */
    @GET("http://api.m.panda.tv/ajax_search?")
    Observable<SearchRoomBean> searchRoomById(@Query("roomid") String roomid);

    //视频播放链接
    /**
     * "plflag": "4_8", 取8 例如
     * http://pl-hls8.live.panda.tv/live_panda/b22aaba9221c50db7e4015bb445650a2.m3u8
     * http://pl-hls[plflag].live.panda.tv/live_panda/[room_key].m3u8
     */

    /**
     *  主页 banner 和 下面一个
     *
     *  http://api.m.panda.tv/?method=slider.cate&cate=index
     *  &__version=3.1.7.3811&__plat=android&__channel=huawei
     *  &pt_sign=f359bba023a99e7376401efb316f9db5&pt_time=1497880899
     */

    /**
     * 热门
     *
     * http://api.m.panda.tv/?method=card.list&cate=index&exclude_likeinfo=1
     * &__version=3.1.7.3811&__plat=android&__channel=huawei
     * &pt_sign=f359bba023a99e7376401efb316f9db5&pt_time=1497880899
     */

    /**
     * 熊猫星颜
     * http://m.api.xingyan.panda.tv/room/index?__version=3.1.7.3811
     * &__plat=android&__channel=huawei&pt_sign=f359bba023a99e7376401efb316f9db5
     * &pt_time=1497880899
     */

}
