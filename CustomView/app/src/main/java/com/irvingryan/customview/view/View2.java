package com.irvingryan.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * 基本图形的绘制
 * Created by wentao on 2016/8/12.
 */
public class View2 extends View {
    private Paint paint;

    public View2(Context context) {
        super(context);
        init();
    }

    public View2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.画直线
//        canvas.drawLine(100,100,200,200,paint);
        //2.画多条直线（两两点组成一条直线，下面例子有两条直线）
//        float []pts={10,10,100,100,200,200,400,500};
//        canvas.drawLines(pts, paint);
        //3.画点
//        canvas.drawPoint(100,100,paint);
        //4.画多个点
//        float []pts={10,10,100,100,200,200,400,500};
//        canvas.drawPoints(pts,paint); //不指定位置的方式
//        canvas.drawPoints(pts,2,8,paint); //指定位置的方式(offset 指定pts忽略几个值 count 计算画出多少个 保证为偶数)
        //5.画矩形
//        canvas.drawRect(100,100,200,200,paint);//直接绘制
//        Rect rect=new Rect(100,300,500,600);//使用Rect绘制
//        RectF rect=new RectF(50,500,600,700);//使用RectF绘制
//        canvas.drawRect(rect,paint);
        //6.绘制带圆角的矩形
//        RectF rect=new RectF(50,500,600,700);//使用RectF绘制
//        canvas.drawRoundRect(rect,50,50,paint);
        //7.绘制圆形
//        canvas.drawCircle(500,500,200,paint);
        //8.绘制椭圆
//        RectF rect=new RectF(50,500,600,700);//使用RectF绘制
//        canvas.drawRect(rect,paint);
//        paint.setColor(Color.BLUE);
//        canvas.drawOval(rect,paint);//椭圆是以矩形的大小来绘制的
        //9.绘制弧
        /**
         * 弧是椭圆的一部分，而椭圆是根据矩形来生成的，所以弧当然也是根据矩形来生成的；

         void drawArc (RectF oval, float startAngle, float sweepAngle, boolean useCenter, Paint paint)

         参数：
         RectF oval:生成椭圆的矩形
         float startAngle：弧开始的角度，以X轴正方向为0度
         float sweepAngle：弧持续的角度
         boolean useCenter:是否有弧的两边，True，补齐两边，False，只有一条弧
         */
        RectF oval=new RectF(50,500,600,700);//使用RectF绘制
        canvas.drawArc(oval,0,90,true,paint);
        canvas.drawRect(175,600,325,640,paint);
    }
}
