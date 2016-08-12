package com.irvingryan.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * 路径及文字的绘制
 * Created by wentao on 2016/8/12.
 */
public class View3 extends View{
    private Paint paint;

    public View3(Context context) {
        super(context);
        init();
    }

    public View3(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View3(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        //1.绘制直线路径
//        Path path = new Path();
//        path.moveTo(50,50);//设定起点
//        path.lineTo(500,500);//移动到下一点
//        path.lineTo(500,100);
//        path.close();//关闭环
//        canvas.drawPath(path,paint);
        //2.绘制矩形路径
        Path ccwPath=new Path();//逆时针路径
        RectF rect1=new RectF(100,100,500,500);
        ccwPath.addRect(rect1, Path.Direction.CCW);

        Path cwPath=new Path();//顺时针路径
        RectF rect2=new RectF(600,100,1000,500);
        cwPath.addRect(rect2, Path.Direction.CW);
        canvas.drawPath(ccwPath,paint);
        canvas.drawPath(cwPath,paint);
        //依据路径绘制文字
        String text="穷者独善其身，达者兼济天下";
        paint.setTextSize(35);
        paint.setColor(Color.GREEN);
        canvas.drawTextOnPath(text,ccwPath,500,40,paint);
        canvas.drawTextOnPath(text,cwPath,20,-10,paint);
    }
}
