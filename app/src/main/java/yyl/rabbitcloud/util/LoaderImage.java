package yyl.rabbitcloud.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import yyl.rabbitcloud.R;

/**
 * Created by YinYiLiang on 2016/10/12 0012.
 */

public class LoaderImage {

    private static RequestOptions getRequestOptions() {
        return new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
    }

    //普通加载
    public static void load(Context context, String url, ImageView view) {
        Glide.with(context).load(url)
                .into(view);
    }

    public static void loadGuide(Context context, String url, ImageView view) {
        Glide.with(context).load(url)
                .thumbnail(0.1f)
                .into(view);
    }

    public static void loadImgById(Context context, int id, ImageView view) {
        String resource = "android.resource://" + context.getPackageName() + "/drawable/" + id;
        Glide.with(context).load(resource).thumbnail(0.4f).into(view);
    }

    public static void loadImgByFile(Context context, File file, ImageView view) {
        Glide.with(context).load(file).into(view);
    }

    public static void loadSplash(Context context, int id, ImageView view) {
        String resource = "android.resource://" + context.getPackageName() + "/drawable/" + id;
        Glide.with(context).load(id).apply(getRequestOptions()).into(view);
    }

    //图片居中显示加载
    public static void loadCenter(Context context, String url, ImageView view) {
        Glide.with(context).load(url)
                .into(view);
    }

    //图片居中显示加载 自定义加载失败图片
    public static void loadCenterCustomErro(Context context, String url,int img, ImageView view) {
        Glide.with(context).load(url)
                .into(view);
    }

    //加载显示为圆形或者圆角图片 头像
    public static void loadRoundRect(Context context, String url,
                                     BitmapTransformation transformation, ImageView view) {
        Glide.with(context).load(url)
                .into(view);
    }

    //普通加载头像
    public static void loadHead(Context context, String url, ImageView view) {
        Glide.with(context).load(url)
                .into(view);
    }

    //普通加载头像
    public static void loadHead(Context context, File url, ImageView view) {
        Glide.with(context).load(url)
                .into(view);
    }
}
