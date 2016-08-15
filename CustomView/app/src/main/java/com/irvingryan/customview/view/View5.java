package com.irvingryan.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * 区域的绘制
 * Created by wentao on 2016/8/15.
 */
public class View5 extends View {

    private Paint paint;

    public View5(Context context) {
        super(context);
        init();
    }

    public View5(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View5(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View5(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.构造Region
//        Region region = new Region(10,10,100,100);
////        region.set(100,100,200,200);

        //2.使用SetPath（）构造不规则区域
//        Path path = new Path();
//        RectF oval=new RectF(100,100,400,500);
//        path.addOval(oval, Path.Direction.CCW);
//        Region region = new Region(100,100,400,500);
//        region.setPath(path,region);
        //3.区域的合并、交叉等操作
        //构造两个矩形
        Rect rect1=new Rect(200,100,300,400);
        Rect rect2=new Rect(100,200,400,300);
        canvas.drawRect(rect1,paint);
        canvas.drawRect(rect2,paint);
        //构造两个Region
        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);
        /**
            - Op.INTERSECT  交集
            - Op.DIFFERENCE 补集
            - Op.REPLACE    替换
            - Op.REVERSE_DIFFERENCE 反转补集
            - Op.UNION      并集
            - Op.XOR        异并集
         */
        region1.op(region2, Region.Op.XOR);//根据不同的Op，取不同的集合
        Paint paint1 = new Paint();
        paint1.setColor(Color.GREEN);
        paint1.setStyle(Paint.Style.FILL);

        //通用参数
        RegionIterator iterator=new RegionIterator(region1);
        Rect rect =new Rect();
        while (iterator.next(rect)){
            canvas.drawRect(rect, paint1);
        }
    }
}
