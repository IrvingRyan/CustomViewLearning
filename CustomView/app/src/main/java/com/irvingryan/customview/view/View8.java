package com.irvingryan.customview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * 贝塞尔曲线的应用(波浪动画效果)
 * 参考文章地址  http://blog.csdn.net/harvic880925/article/details/50995587
 * Created by wentao on 2016/8/17.
 */
public class View8 extends View {
    private String TAG="View8";

    private Paint paint;
    private float px =0;

    public View8(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.使用rQuadTo()绘制波浪线
//        Path path = new Path();
//        path.moveTo(200,200);
//        path.rQuadTo(100,-100,200,0);//quadTo()为绝对坐标 rQuadTo()是相对坐标
//        path.rQuadTo(100,100,200,0);
//        canvas.drawPath(path,paint);
        //2.水波浪效果的实现
        Path path = new Path();
        //先构造一个闭环的图形
        //根据改变px的值来移动初始位置达到波纹移动的效果
        path.moveTo(-1200+px,500);
        path.rQuadTo(300,-100,600,0);
        path.rQuadTo(300,100,600,0);
        path.rQuadTo(300,-100,600,0);
        path.rQuadTo(300,100,600,0);
        path.lineTo(getWidth(),getHeight());
        path.lineTo(0,getHeight());
        path.close();
        canvas.drawPath(path,paint);
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
