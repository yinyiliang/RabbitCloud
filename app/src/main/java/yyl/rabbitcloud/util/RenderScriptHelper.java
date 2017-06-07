package yyl.rabbitcloud.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/**
 * Created by yyl on 2017/3/23.
 */

public class RenderScriptHelper {

    //图片缩放比例
    private static final float BITMAP_SCALE = 1f;

    public static Bitmap rsBlur(Context context, Bitmap source, int radius) {

        // 计算图片缩小后的长宽
        int width = Math.round(source.getWidth() * BITMAP_SCALE);
        int height = Math.round(source.getHeight() * BITMAP_SCALE);

        // 将缩小后的图片做为预渲染的图片
        Bitmap inputBitmap = Bitmap.createScaledBitmap(source, width, height, false);

        RenderScript renderScript = RenderScript.create(context);
        final Allocation input = Allocation.createFromBitmap(renderScript, inputBitmap);
        final Allocation outPut = Allocation.createTyped(renderScript, input.getType());

        ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript,
                Element.U8_4(renderScript));
        scriptIntrinsicBlur.setInput(input);
        scriptIntrinsicBlur.setRadius(radius);
        scriptIntrinsicBlur.forEach(outPut);
        outPut.copyTo(inputBitmap);
        renderScript.destroy();

        return inputBitmap;
    }

}
