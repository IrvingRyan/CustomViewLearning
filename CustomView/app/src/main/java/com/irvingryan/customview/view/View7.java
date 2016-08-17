package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * 贝塞尔曲线的应用(完成简单的手绘)
 * 参考文章地址  http://blog.csdn.net/harvic880925/article/details/50995587
 * Created by wentao on 2016/8/17.
 */
public class View7 extends View {

    private Paint paint;
    private Path mPath;
    private String TAG="View7";
    private float mPreX;
    private float mPreY;
    private float mEndX;
    private float mEndY;

    public View7(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.quadTo()的基本使用方法
//        Path path = new Path();
//        path.moveTo(200,200);
//        /**
//            -整条线的起始点是通过Path.moveTo(x,y)来指定的，如果初始没有调用Path.moveTo(x,y)来指定起始点，则默认以控件左上角(0,0)为起始点；
//            -而如果我们连续调用quadTo()，前一个quadTo()的终点，就是下一个quadTo()函数的起点；
//         */
//        path.quadTo(300,100,400,200);//第一个点为控制点 第二个点为终点
//        path.quadTo(500,300,600,200);
//        canvas.drawPath(path,paint);
        //2.绘制轨迹
        canvas.drawPath(mPath,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPreX=event.getX();
                mPreY=event.getY();
                mPath.moveTo(mPreX,mPreY);
                return true;//必须按下的时候返回 否则无法绘制
            case MotionEvent.ACTION_MOVE:
                //直接用lineTo绘制轨迹 线条过渡是的光滑度过低
//                mPath.lineTo(event.getX(),event.getY());
//                postInvalidate();//调用重绘 与invalidate()的区别在于线程问题 如果确定是在主线程 用invalidate()更快;
                //使用quadTo()贝塞尔曲线过度绘制轨迹
                mEndX=(event.getX()-mPreX)/2+mPreX;
                mEndY=(event.getY()- mPreY)/2+mPreY;
                mPath.quadTo(mPreX,mPreY,mEndX,mEndY);
                mPreX=event.getX();
                mPreY=event.getY();
                invalidate();
                break;
            default:
                break;
        }

        return super.onTouchEvent(event);
    }

    /**
     * 重置绘图
     */
    public void reset(){
        mPath.reset();
        invalidate();
    }
}
