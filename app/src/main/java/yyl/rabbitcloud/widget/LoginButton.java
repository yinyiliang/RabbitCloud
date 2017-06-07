package yyl.rabbitcloud.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import yyl.rabbitcloud.R;


public class LoginButton extends android.support.v7.widget.AppCompatTextView {
    private Paint mPaint;
    private int DEFAULT_VALUE = 150;
    public static final int STATUS_SUCCESS = 2;
    public static final int STATUS_ERROR = 3;
    //默认的动画时间
    private int DEFAULT_DELAY = 300;
    //结束滚动的值 也就是说滚动多少距离 这里是计算的 控件的宽度-两个半圆的宽度 因为矩形的两边是一起动的 所以再除以2 <---这个变量的值会变 这里默认200
    private int endValue = DEFAULT_VALUE;
    //开始滚动的值
    private int startValue = 0;
    //需要滚动的距离
    private int needScrollValue = 0;//<-这个变量的值不会变
    private int height = DEFAULT_VALUE;
    private ValueAnimator v;
    private Bitmap okBitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.ic_done_white_24dp);
    private Bitmap noBitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.ic_error_outline_white_24dp);
    private static final int NORMAL = 0;
    //圆状态
    private static final int CIRCLE = 1;
    //当控件是正常的状态
    private  int STATE = NORMAL;
    //动态改变的Value
    private int commonValue;
    //滚动距离只计算一次
    private boolean isFirstMeasure;
    private String text;
    public LoginButton(Context context) {
        super(context);
        init(context);
    }
    private boolean isCanDrawStateBitmap;

    public LoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoginButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //初始化画笔 设置抗锯齿 填充方式
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setStrokeWidth(3f);
        this.text = getText().toString();

    }
    //计算高度
    private int measureHeightView(int spec) {
        int size = MeasureSpec.getSize(spec);
        int mode = MeasureSpec.getMode(spec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                height = size;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                height = Math.min(size, height);
                break;
        }
        return height;
    }
    //计算宽度
    private int measureWidthView(int spec) {
        int width = 500;
        int size = MeasureSpec.getSize(spec);
        int mode = MeasureSpec.getMode(spec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                width = size;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                width = Math.min(size, width);
                break;
        }
        return width;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidthView(widthMeasureSpec), measureHeightView(heightMeasureSpec));

    }
    private int scale = 20;

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制主体
        drawPrimaryPart(canvas);

        //当是圆状态的时候
        if (STATE == CIRCLE) {
            //画弧
            drawArc(canvas);

        } else if(STATE == STATUS_ERROR||STATE == STATUS_SUCCESS){
            //如果颜色动画没有执行

            if(!isColorRuning){
                //执行颜色动画
                startColorAnim(STATE == STATUS_SUCCESS);
            }
            if(isCanDrawBitmap){
                isCanDrawBitmap = false;
                Rect rectf = new Rect(getMeasuredWidth()/2-getMeasuredHeight()/2+scale,scale,getMeasuredWidth()/2+getMeasuredHeight()/2-scale,getMeasuredHeight()-scale);
                Rect rect = new Rect((okBitmap.getWidth()/2-okBitmap.getHeight()/2),0,okBitmap.getWidth()/2+okBitmap.getHeight()/2,okBitmap.getHeight());

                if(STATE == STATUS_SUCCESS){
                    //第三个参数指定绘制位置
                    //第二个参数指定绘制大小
                    canvas.drawBitmap(okBitmap,rect,rectf,mPaint);
                }else{
                    canvas.drawBitmap(noBitmap,rect,rectf,mPaint);
                }

            }
        }
        super.onDraw(canvas);

    }


    @Override
    public void setBackground(Drawable background) {
//        super.setBackground(background);
    }

    @Override
    public void setBackgroundColor(int color) {
        //super.setBackgroundColor(color);
        colorValue = color;
    }

    private static final int DEFAULTCOLOR= Color.parseColor("#FF4081");
    private static final int DEFAULTENDCOLOR =Color.parseColor("#0FA644");
    private int colorValue = DEFAULTCOLOR;
    private boolean isColorRuning;
    //动画结束后是否可以画对号
    private boolean isCanDrawBitmap;

    private void initBackGroundAnimation(int startColor, int endColor){
        //FF0FA644
       ValueAnimator v = ValueAnimator.ofObject(new ArgbEvaluator(),startColor, endColor);
       v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
           @Override
           public void onAnimationUpdate(ValueAnimator animation) {
               colorValue = (int) animation.getAnimatedValue();
               invalidate();
           }
       });
        v.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                isColorRuning = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                isColorRuning = false;
                isCanDrawBitmap = true;
                invalidate();
                renew();
            }
        });
        v.setInterpolator(new LinearInterpolator());
        v.setDuration(1000);
        v.start();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        if(text.length() > 0) {
            this.text = text.toString();
        }
    }

    private void startColorAnim( boolean isSuccess) {
        if(isCanDrawStateBitmap){

            if(isSuccess){

                initBackGroundAnimation(colorValue,DEFAULTENDCOLOR);
            }else{
                initBackGroundAnimation(colorValue,Color.RED);
            }
           isCanDrawStateBitmap = false;
        }

    }
    private RectF leftRectF = new RectF();
    private RectF mid = new RectF();
    private RectF rightRectF = new RectF();
    private void drawPrimaryPart(Canvas canvas) {
        //绘制左边的圆弧
        mPaint.setColor(colorValue);
        leftRectF.set(  commonValue, 0, commonValue + height, height);
        canvas.drawArc(leftRectF, 90, 180, true, mPaint);
        //绘制中间的矩形 这里可以将commonValue当做是0 然后用默认值去看代码 自己拿纸画画就出来了
        mid.set(height / 2 + commonValue, 0, (getMeasuredWidth() - height / 2) - commonValue, height);
        canvas.drawRect(mid, mPaint);
        //绘制右边的圆弧
        rightRectF.set((getMeasuredWidth() - height) - commonValue, 0, (getMeasuredWidth()) - commonValue, height);
        canvas.drawArc(rightRectF, -90, 180, true, mPaint);
    }

    private void drawArc(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);

        RectF oval = new RectF(getMeasuredWidth()/2 - 40, height/2 - 40,
                getMeasuredWidth()/2 + 40, height/2 + 40);
        canvas.drawArc(oval, -90, 180, false, paint);
    }

    public void setState(int status){
        if(isColorRuning){
            return;
        }

        isCanDrawStateBitmap = true;
        cancelArcAnimation();
        STATE = status;
        invalidate();
    }

    //动画是否在滚动
    public boolean isRuning(){
        return isColorRuning||STATE ==CIRCLE||(v!=null&&v.isRunning());
    }


    public void startOk() {
        if ((v != null && v.isRunning())||isColorRuning||STATE ==CIRCLE) {
            return;
        }
        initAnimation();
    }
    private void cancelArcAnimation(){
        clearAnimation();
    }

    private void initArcAnimation(){
        RotateAnimation arcAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        arcAnimation.setRepeatCount(-1); //设置为无限重复
        arcAnimation.setInterpolator(new LinearInterpolator());//匀速
        arcAnimation.setFillAfter(true);

        arcAnimation.setDuration(600);
        startAnimation(arcAnimation);
    }
    public void renew(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startOk();
            }
        },1000);
    }
    private void initAnimation() {
        //只计算一次
        if (!isFirstMeasure) {
            needScrollValue = (getMeasuredWidth() - height) / 2;
            endValue = needScrollValue;
            isFirstMeasure = !isFirstMeasure;
        }
        v = ValueAnimator.ofInt(startValue, endValue);
        v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                commonValue = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        v.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                colorValue = DEFAULTCOLOR;
                if(STATE == CIRCLE){
                    STATE = NORMAL;
                    cancelArcAnimation();
                }else{
                    setText("");
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (commonValue == needScrollValue) {
                    startValue = needScrollValue;
                    endValue = 0;
                    STATE = CIRCLE;
                    initArcAnimation();
                } else {
                    setText(text);
                    STATE = NORMAL;
                    startValue = 0;
                    endValue = needScrollValue;
                }
            }
        });
        v.setDuration(DEFAULT_DELAY);
        v.start();
    }
}
