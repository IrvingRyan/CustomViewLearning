package com.irvingryan.customview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * 实现可口可乐商标的波浪摆动 DST_IN
 * Created by wentao on 2016/8/25.
 */
public class CocaColaView extends View {
    private String TAG="CocaColaView";

    private Paint paint;
    private Bitmap textBitmap;
    private Canvas c;
    private Path path;
    private int px;
    private Paint wavePaint;
    private Paint p;

    public CocaColaView(Context context) {
        super(context);
        init();
    }

    public CocaColaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setTextSize(200);
        paint.setTextAlign(Paint.Align.CENTER);
        wavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        wavePaint.setStyle(Paint.Style.FILL);
        wavePaint.setColor(Color.CYAN);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "CocaCola.ttf");
        this.paint.setTypeface(typeface);
        p = new Paint();
        startAnimation();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(TAG,"onMeasure width ==" + getWidth()+" height == "+getHeight());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i(TAG,"onSizeChanged width ==" + getWidth()+" height == "+getHeight());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG,"onLayout width ==" + getWidth()+" height == "+getHeight());
        textBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        c = new Canvas(textBitmap);
        c.drawText("Coca Cala",getWidth()/2,getHeight()/2,paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //2.水波浪效果的实现
        path = new Path();
        //先构造一个闭环的图形
        //根据改变px的值来移动初始位置达到波纹移动的效果
        path.moveTo(-1200+px,550);
        path.rQuadTo(300,-100,600,0);
        path.rQuadTo(300,100,600,0);
        path.rQuadTo(300,-100,600,0);
        path.rQuadTo(300,100,600,0);
        path.lineTo(getWidth(),getHeight());
        path.lineTo(0,getHeight());
        path.close();
        Bitmap waveBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c=new Canvas(waveBitmap);
        c.drawPath(path,wavePaint);
        canvas.drawBitmap(textBitmap,0,0,p);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(waveBitmap,0,0,p);
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(textBitmap,0,0,p);
        p.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
    public void startAnimation(){
        ValueAnimator animator=ValueAnimator.ofInt(1200);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(2000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                px =(int)animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}
