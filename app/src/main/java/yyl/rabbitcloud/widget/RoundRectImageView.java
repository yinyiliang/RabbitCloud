package yyl.rabbitcloud.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * 自定义的圆角矩形ImageView，可以直接当组件在布局中使用。
 *
 */
public class RoundRectImageView extends android.support.v7.widget.AppCompatImageView{

    private Paint paint;
    private int radius = 15;

    // 定义 Bitmap 的默认配置
    private static final Config BITMAP_CONFIG = Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 1;

    public RoundRectImageView(Context context) {
        this(context,null);
    }

    public RoundRectImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RoundRectImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle); 
        paint  = new Paint();
    }  
  
    /**
     * 绘制圆角矩形图片
     * @author caizhiming
     */
    @Override  
    protected void onDraw(Canvas canvas) {  
  
        Drawable drawable = getDrawable();  
        if (null != drawable) {  
//            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            // 这里参考赵鹏的获取 bitmap 方式，因为上边的获取会导致 Glide 加载的drawable
            // 强转为 BitmapDrawable 出错
            Bitmap bitmap = getBitmapFromDrawable(drawable);
            Bitmap b = getRoundBitmap(bitmap, radius);
            final Rect rectSrc = new Rect(0, 0, b.getWidth(), b.getHeight());  
            final Rect rectDest = new Rect(0,0,getWidth(),getHeight());
            paint.reset();  
            canvas.drawBitmap(b, rectSrc, rectDest, paint);  
  
        } else {  
            super.onDraw(canvas);  
        }  
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        try {
            Bitmap bitmap;
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            } else if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(COLORDRAWABLE_DIMENSION, COLORDRAWABLE_DIMENSION, BITMAP_CONFIG);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                        BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }
  
    /**
     * 获取圆角矩形图片方法
     */
    private Bitmap getRoundBitmap(Bitmap bitmap, int roundPx) {  
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),  
                bitmap.getHeight(), Config.ARGB_8888);  
        Canvas canvas = new Canvas(output);  
          
        final int color = 0xff424242;
       
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());  
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);  
        canvas.drawARGB(0, 0, 0, 0);  
        paint.setColor(color);  
        int x = bitmap.getWidth(); 
        
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));  
        canvas.drawBitmap(bitmap, rect, rect, paint);  
        return output;  
        
        
    }  
}