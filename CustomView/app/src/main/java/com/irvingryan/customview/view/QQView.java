package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.irvingryan.customview.R;

/**
 * Created by wentao on 2016/8/29.
 */
public class QQView extends FrameLayout {

    private int DEFAULT_RADIUS ;
    private Paint paint;
    private Path path;
    private int x0;//初始圆圈位置
    private int y0;
    private int radius;//圆圈半径
    private float Px0;//贝塞尔曲线第一个起点坐标
    private float Py0;
    private float Cx0;//贝塞尔曲线控制点坐标
    private float Cy0;
    private String TAG="QQView";
    private float Px1;//贝塞尔曲线第一个终点坐标
    private float Py1;
    private double a;//
    private float x1;//第二个圆圈中心
    private float y1;
    private float Px2;//第二个贝塞尔曲线起点
    private float Py2;
    private float Px3;//第二个贝塞尔曲线终点
    private float py3;
    private boolean mTouch;
    private TextView mTextView;
    private double distance=1;
    private ImageView explosionView;

    public QQView(Context context) {
        super(context);
        init();
    }

    public QQView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        path = new Path();
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTextView = new TextView(getContext());
        mTextView.setLayoutParams(layoutParams);
        mTextView.setText("99+");
        mTextView.setTextColor(Color.CYAN);
        mTextView.setBackgroundResource(R.drawable.qq_dot);
        explosionView = new ImageView(getContext());
        explosionView.setLayoutParams(layoutParams);
        explosionView.setImageResource(R.drawable.explosion_anim);
        explosionView.setVisibility(GONE);
        addView(mTextView);
        addView(explosionView);
        //圆圈半径
        radius = 25;
        DEFAULT_RADIUS=radius;
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {

        x0 = getWidth()/2;
        y0 = getHeight()/2;
        canvas.saveLayer(0,0,getWidth(),getHeight(),paint,Canvas.ALL_SAVE_FLAG);
        if (mTouch){
            calculatePath();
            Log.i(TAG,"radius == "+radius);
            canvas.drawCircle(x0,y0, radius,paint);
            mTextView.setX(x1-mTextView.getWidth()/2);
            mTextView.setY(y1-mTextView.getHeight()/2);
//            canvas.drawCircle(x1,y1,radius,paint);
            canvas.drawPath(path,paint);
        }else {
            mTextView.setX(x0-mTextView.getWidth()/2);
            mTextView.setY(y0-mTextView.getHeight()/2);
        }
        canvas.restore();
        super.dispatchDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                RectF rect = new RectF();
                int location[]=new int[2];
                mTextView.getLocationOnScreen(location);
                rect.left=location[0];
                rect.top=location[1];
                rect.right=mTextView.getWidth()+location[0];
                rect.bottom=mTextView.getHeight()+location[1];
                if (rect.contains(event.getRawX(),event.getRawY())){//判断是否点击了textview
                    Log.i(TAG,"clicked the area");
                    mTouch = true;
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                x1=event.getX();
                y1=event.getY();
                distance=Math.sqrt(Math.pow(x1-x0,2)+Math.pow(y1-y0,2));
                radius= (int) (DEFAULT_RADIUS-distance/15);
                if (radius<=9){
                    radius=9;
                }
                break;
            case MotionEvent.ACTION_UP:
                mTouch=false;
                if (radius<=9){
                    explosionView.setX(x1-explosionView.getWidth()/2);
                    explosionView.setY(y1-explosionView.getHeight()/2);
                    explosionView.setVisibility(VISIBLE);
                    mTextView.setVisibility(GONE);
                    ((AnimationDrawable)explosionView.getDrawable()).start();
                }
                radius=DEFAULT_RADIUS;
                break;

        }
        invalidate();
        return super.onTouchEvent(event);
    }

    private void calculatePath() {
        Cx0=(x1+x0)/2;
        Cy0=(y1+y0)/2;
        a = Math.atan((Cx0-x0)/(Cy0-y0));
        Px0= (float) (x0+radius*Math.cos(a));
        Py0= (float) (y0-radius*Math.sin(a));
        Px1= (float) (x1+radius*Math.cos(a));
        Py1= (float) (y1-radius*Math.sin(a));
        Px2= (float) (x1-radius*Math.cos(a));
        Py2=  (float) (y1+radius*Math.sin(a));
        Px3=  (float) (x0-radius*Math.cos(a));
        py3 = (float) (y0 + radius * Math.sin(a));
        path.reset();
        path.moveTo( Px0, Py0);
        path.quadTo(Cx0,Cy0,Px1, Py1);
        path.lineTo(Px2,Py2);
        path.quadTo(Cx0,Cy0,Px3,py3);
        path.close();
    }


}
