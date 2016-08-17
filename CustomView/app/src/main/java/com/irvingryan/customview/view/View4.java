package com.irvingryan.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 文字的绘制
 * Created by wentao on 2016/8/12.
 */
public class View4 extends View {
    private float baseLineY =200f;

    private Typeface typeface;
    private Paint paint;
    private float baseLineX=0f;
    private String TAG="View4";

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
        paint.setTextSize(80);//设置文字大小 已px为单位
        paint.setStyle(Paint.Style.FILL);
        //5.更改文字字体
//        typeface=Typeface.createFromAsset(getContext().getApplicationContext().getAssets(),"jian_luobo.ttf");
//        paint.setTypeface(typeface);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(TAG,"widthMeasureSpec="+widthMeasureSpec+" heightMeasureSpec="+heightMeasureSpec);
        Log.i(TAG,"onMeasure");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG,"onDraw");
        String text="Irving Ryan is the best ! ! !";
        //1.绘图样式区别
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawText(text,50,100,paint); //填充样式
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawText(text,50,200,paint); //描边
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawText(text,50,300,paint); //填充且描边
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
        //6.基线与绘制位置（paint.setTextAlign(Paint.Align.XXX)）
        //画基线
//        paint.setColor(Color.RED);
//        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, paint);
        //画文字
//        paint.setColor(Color.GREEN);
//        paint.setTextAlign(Paint.Align.LEFT); // -Align.LEFT 以文字整体的方块左边缘X为基点绘制
//                                                // -Align.CENTER 以文字整体的方块中间部位X为基点绘制
//                                                // -Align.RIGHT 以文字整体的方块右边缘X为基点绘制
//        canvas.drawText(text,baseLineX, baseLineY,paint);
        //7.drawText的四线格与FontMetrics
//        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
//        Log.i(TAG,"ascent="+fontMetrics.ascent+" descent="+fontMetrics.descent+" bottom="+fontMetrics.bottom+" top="+fontMetrics.top);
//        paint.setColor(Color.GRAY);
//        canvas.drawLine(baseLineX,baseLineY+fontMetrics.top,3000,baseLineY+fontMetrics.top,paint);
//        paint.setColor(Color.BLUE);
//        canvas.drawLine(baseLineX,baseLineY+fontMetrics.ascent,3000,baseLineY+fontMetrics.ascent,paint);
//        paint.setColor(Color.BLACK);
//        canvas.drawLine(baseLineX,baseLineY+fontMetrics.descent,3000,baseLineY+fontMetrics.descent,paint);
//        paint.setColor(Color.CYAN);
//        canvas.drawLine(baseLineX,baseLineY+fontMetrics.bottom,3000,baseLineY+fontMetrics.bottom,paint);
        //8.所绘文字宽度、高度和最小矩形获取
        //画文字所占区域
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        Rect rect=new Rect((int) baseLineX,(int) (baseLineY+fontMetrics.top),(int) paint.measureText(text),(int) baseLineY+fontMetrics.bottom);
        paint.setColor(Color.RED);
        canvas.drawRect(rect,paint);
        //最小矩形
        Rect minRect = new Rect();
        paint.getTextBounds(text,0,text.length(),minRect);
        paint.setColor(Color.GREEN);
        minRect.top= (int) (baseLineY+minRect.top);
        minRect.bottom= (int) (baseLineY+minRect.bottom);
        canvas.drawRect(minRect,paint);
        //绘出文字
        paint.setColor(Color.BLACK);
        canvas.drawText(text,baseLineX, baseLineY,paint);
    }
}
