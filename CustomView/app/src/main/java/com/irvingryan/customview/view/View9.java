package com.irvingryan.customview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Paint 的函数用法汇总
 * Created by wentao on 2016/8/18.
 */
public class View9 extends View {

    private Paint paint;
    private Path path;
    private int px;

    public View9(Context context) {
        super(context);
        init();
        startAnim();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        path = new Path();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(getWidth()/2,0,getWidth()/2,getHeight(),paint);
        canvas.drawLine(100,50,100,350,paint);
        //1.设置线冒
        paint.setStrokeWidth(50);
        paint.setColor(Color.CYAN);
        paint.setStrokeCap(Paint.Cap.SQUARE);//方形线冒
        canvas.drawLine(100,100,500,100,paint);

        paint.setStrokeCap(Paint.Cap.ROUND);//圆形线冒
        canvas.drawLine(100,200,500,200,paint);

        paint.setStrokeCap(Paint.Cap.BUTT);//无线冒 默认
        canvas.drawLine(100,300,500,300,paint);
        //2.线条结合处效果
        paint.setColor(Color.RED);
        path.moveTo(100,400);
        path.lineTo(500,400);
        path.rLineTo(-100,200);
        paint.setStrokeJoin(Paint.Join.ROUND);//结合处为圆角
        canvas.drawPath(path,paint);
        path.reset();
        path.moveTo(100,650);
        path.rLineTo(400,0);
        path.rLineTo(-100,200);
        paint.setStrokeJoin(Paint.Join.BEVEL);//结合处为直线
        canvas.drawPath(path,paint);
        path.reset();
        path.moveTo(100,900);
        path.rLineTo(400,0);
        path.rLineTo(-100,200);
        paint.setStrokeJoin(Paint.Join.MITER);//结合处为锐角
        canvas.drawPath(path,paint);
        paint.setStrokeWidth(5);
        path.reset();
        path.moveTo(100,1150);
        path.rLineTo(400,0);
        path.rLineTo(-100,100);
        canvas.drawPath(path,paint);
        //3.路径效果 PathEffect
        canvas.translate(0,120);
        Paint effectPaint = getPaint();
        //虚线效果
        effectPaint.setPathEffect(new DashPathEffect(new float[]{50f,50f,20f,20f,10f},10+px));//intervals[]：表示组成虚线的各个线段的长度；整条虚线就是由intervals[]中这些基本线段循环组成的。
                                                                        // 比如，我们定义new float[] {20,10}；那这个虚线段就是由两段线段组成的，第一个可见的线段长为20，每二个线段不可见，长度为10
                                                                        //new float[]{}最好为双数 只能识别双数个的线条，phase为起始位置的偏移量
        effectPaint.setStrokeWidth(5);
//        paint.setPathEffect(new CornerPathEffect(10f));//圆角效果
        path.reset();
        path.moveTo(100,1150);
        path.rLineTo(400,0);
        path.rLineTo(-100,100);
        canvas.drawPath(path,effectPaint);
        canvas.translate(0,120);
        paint.setPathEffect(new DashPathEffect(new float[]{50f,50f,20f,20f,10f},0));
        path.reset();
        path.moveTo(100,1150);
        path.rLineTo(400,0);
        path.rLineTo(-100,100);
        canvas.drawPath(path,paint);
        canvas.restore();
        canvas.translate(getWidth()/2,0);
        //离散效果（锈迹）
        Paint discretePaint = getPaint();
        path.reset();
        path.moveTo(100,100);
        path.rLineTo(400,0);
        path.rLineTo(-100,100);
        discretePaint.setPathEffect(new DiscretePathEffect(1,15));//第一个参数 x方向的偏移 第二个参数 y方向的偏离 xy为大概方向
        canvas.drawPath(path,discretePaint);
        //4.自定义路径效果（实现箭头延路径移动动画）
        canvas.translate(0,200);
        Path shapePath = new Path();
        shapePath.moveTo(10,0);
        shapePath.lineTo(0,-10);
        shapePath.lineTo(40,0);
        shapePath.lineTo(0,10);
        shapePath.close();
        Paint shapePaint = getPaint();
        shapePaint.setColor(Color.GRAY);
        PathDashPathEffect pathDashPathEffect = new PathDashPathEffect(shapePath, 50, 0 - px, PathDashPathEffect.Style.ROTATE);
        shapePaint.setPathEffect(pathDashPathEffect);
        canvas.drawPath(path,shapePaint);
        //5.合并路径效果
        PathEffect effect=new ComposePathEffect(pathDashPathEffect,new CornerPathEffect(50));//注意先后顺序 顺序不同 效果不一样
        canvas.translate(0,200);
        Paint composePaint = getPaint();
        composePaint.setPathEffect(effect);
        canvas.drawPath(path,composePaint);
    }
    public void startAnim(){
        ValueAnimator animator=ValueAnimator.ofInt(140);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                px= (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }

    public Paint getPaint() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.CYAN);
        return paint;
    }
}
