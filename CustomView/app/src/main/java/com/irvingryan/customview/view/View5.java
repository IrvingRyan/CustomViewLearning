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
import android.util.Log;
import android.view.View;

/**
 * 区域的绘制
 * Created by wentao on 2016/8/15.
 */
public class View5 extends View {
    private String TAG="View5";

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


        /**
         *
            //几个判断方法
            public native boolean isEmpty();//判断该区域是否为空
            public native boolean isRect(); //是否是一个矩阵
            public native boolean isComplex();//是否是多个矩阵组合


            //一系列的getBound方法，返回一个Region的边界
            public Rect getBounds()
            public boolean getBounds(Rect r)
            public Path getBoundaryPath()
            public boolean getBoundaryPath(Path path)

            //一系列的判断是否包含某点 和是否相交
            public native boolean contains(int x, int y);//是否包含某点
            public boolean quickContains(Rect r)   //是否包含某矩形
            public native boolean quickContains(int left, int top, int right,
            int bottom) //是否没有包含某矩阵形
            public boolean quickReject(Rect r) //是否没和该矩形相交
            public native boolean quickReject(int left, int top, int right, int bottom); //是否没和该矩形相交
            public native boolean quickReject(Region rgn);  //是否没和该矩形相交

            //几个平移变换的方法
            public void translate(int dx, int dy)
            public native void translate(int dx, int dy, Region dst);
            public void scale(float scale) //hide
            public native void scale(float scale, Region dst);//hide
         *
         */
        Log.i(TAG,"region1 =="+region1.isEmpty() + " region2 ==" + region2.isEmpty());
    }
}
