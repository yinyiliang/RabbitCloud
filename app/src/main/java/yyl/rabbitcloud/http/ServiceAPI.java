package yyl.rabbitcloud.http;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import yyl.rabbitcloud.bean.CategoryBean;
import yyl.rabbitcloud.bean.FindRoomInfoByIdBean;
import yyl.rabbitcloud.bean.RecommendInfoBean;
import yyl.rabbitcloud.bean.RoomBean;
import yyl.rabbitcloud.bean.SearchRoomBean;
import yyl.rabbitcloud.bean.SplashScreenBean;

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
     */
    @GET("android_hd/catelist_.json?")
    Observable<RoomBean> getRoomInfoByCate(@Query("cate") String cate, @Query("pageno") int pageno);

    //返回游戏类型
    /**
     * http://static.api.m.panda.tv/android_hd/cate.json
     */
    @GET("android_hd/cate.json")
    Observable<CategoryBean> getCategoryData();

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

}
