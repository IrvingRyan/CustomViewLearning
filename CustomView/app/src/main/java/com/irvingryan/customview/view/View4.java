package com.irvingryan.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * 文字的绘制
 * Created by wentao on 2016/8/12.
 */
public class View4 extends View {

    private Typeface typeface;
    private Paint paint;

    public View4(Context context) {
        super(context);
        init();
    }

    public View4(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View4(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View4(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        /**
         * //普通设置
         paint.setStrokeWidth (5);//设置画笔宽度
         paint.setAntiAlias(true); //指定是否使用抗锯齿功能，如果使用，会使绘图速度变慢
         paint.setStyle(Paint.Style.FILL);//绘图样式，对于设文字和几何图形都有效
         paint.setTextAlign(Align.CENTER);//设置文字对齐方式，取值：align.CENTER、align.LEFT或align.RIGHT
         paint.setTextSize(12);//设置文字大小

         //样式设置
         paint.setFakeBoldText(true);//设置是否为粗体文字
         paint.setUnderlineText(true);//设置下划线
         paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25
         paint.setStrikeThruText(true);//设置带有删除线效果

         //其它设置
         paint.setTextScaleX(2);//只会将水平方向拉伸，高度不会变
         */
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setTextSize(60);//设置文字大小
        paint.setStyle(Paint.Style.STROKE);
        //5.更改文字字体
        typeface=Typeface.createFromAsset(getContext().getApplicationContext().getAssets(),"jian_luobo.ttf");
        paint.setTypeface(typeface);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String text="都说钱是王八蛋，可长得真好看";
        //1.绘图样式区别
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(text,50,100,paint); //填充样式
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawText(text,50,200,paint); //描边
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText(text,50,300,paint); //填充且描边
        //2.绘图样式及倾斜度
        //样式设置
//        paint.setFakeBoldText(true);//设置是否为粗体文字
//        paint.setUnderlineText(true);//设置下划线
//        paint.setStrikeThruText(true);//设置带有删除线效果
//        paint.setStyle(Paint.Style.FILL);
//        paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25，可见往右斜
//        canvas.drawText(text,50,100,paint); //填充样式
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setTextSkewX((float) 0.25);//水平倾斜度设置为：0.25，往左斜
//        canvas.drawText(text,50,200,paint); //描边
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setTextScaleX(2);//设置拉伸效果
//        canvas.drawText(text,50,300,paint); //填充且描边
        //3.指定单个文字位置绘制
//        canvas.drawPosText(text,new float[]{50,50,150,150,250,250,350,350},paint);//点的个数必须与字数相同
        //4.按路径绘制文字(参照View3)
//        Path path=new Path();
//        path.addCircle(500,500,500, Path.Direction.CW);//顺时针
//        canvas.drawPath(path,paint);
//        canvas.drawTextOnPath(text,path,100,100,paint);
    }
}
