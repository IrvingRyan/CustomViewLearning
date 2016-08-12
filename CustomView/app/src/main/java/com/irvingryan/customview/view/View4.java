package com.irvingryan.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * 文字的绘制
 * Created by wentao on 2016/8/12.
 */
public class View4 extends View {

    private Paint paint;

    public View4(Context context) {
        super(context);
        initView();
    }

    public View4(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public View4(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View4(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String text="都说钱是王八蛋，可长得真好看";
        //1.绘图样式区别
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawText(text,50,100,paint); //填充样式
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawText(text,50,200,paint); //描边
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawText(text,50,300,paint); //填充且描边
        //2.绘图样式及倾斜度
        //样式设置
        paint.setFakeBoldText(true);//设置是否为粗体文字
        paint.setUnderlineText(true);//设置下划线
        paint.setStrikeThruText(true);//设置带有删除线效果
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSkewX((float) -0.25);//设置字体水平倾斜度，普通斜体字是-0.25，可见往右斜
        canvas.drawText(text,50,100,paint); //填充样式
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSkewX((float) 0.25);//水平倾斜度设置为：0.25，往左斜
        canvas.drawText(text,50,200,paint); //描边
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextScaleX(2);//设置拉伸效果
        canvas.drawText(text,50,300,paint); //填充且描边
    }
}
