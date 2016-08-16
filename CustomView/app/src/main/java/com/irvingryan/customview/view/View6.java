package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * canvas 的变化与操作
 * Created by wentao on 2016/8/15.
 */
public class View6 extends View{

    private Paint paint;

    public View6(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.平移（translate） translate函数其实实现的相当于平移坐标系，即平移坐标系的原点的位置。
//        canvas.translate(100, 100);
//        Rect rect1 = new Rect(0,0,400,220);
//        canvas.drawRect(rect1, paint);
        //2.屏幕显示与Canvas的关系
//        Rect rect1 = new Rect(0,0,200,200);
//        canvas.drawRect(rect1, paint);
//        canvas.translate(100, 100);
//        paint.setColor(Color.RED);
//        canvas.drawRect(rect1,paint);
        //3.旋转（rotate）
//        Rect rect1 = new Rect(100,100,300,120);
//        canvas.drawRect(rect1, paint);
//        canvas.rotate(30);
//        paint.setColor(Color.RED);
//        canvas.drawRect(rect1,paint);
        //4.缩放（scale）
//        Rect rect1 = new Rect(100,100,300,120);
//        canvas.drawRect(rect1, paint);
//        canvas.scale(2,1); //画布的密度按x y 方向缩放
//        paint.setColor(Color.RED);
//        canvas.drawRect(rect1,paint);
        //5.扭曲（skew）
//        Rect rect1 = new Rect(10,10,200,100);
//        canvas.drawRect(rect1, paint);
//        /**
//         *  float sx:将画布在x方向上倾斜相应的角度，sx倾斜角度的tan值，
//            float sy:将画布在y轴方向上倾斜相应的角度，sy为倾斜角度的tan值，
//         */
//        canvas.skew((float) Math.tan(Math.PI/3.0),0); //X轴倾斜60度，Y轴不变
//        paint.setColor(Color.RED);
//        canvas.drawRect(rect1,paint);
        //6.裁剪画布（clip系列函数）
//        canvas.drawColor(Color.GRAY);
//        Path path=new Path();
//        path.addOval(new RectF(200,200,600,300), Path.Direction.CCW);
//        canvas.clipPath(path, Region.Op.DIFFERENCE);
//        canvas.drawColor(Color.RED);
        //7.画布的保存与恢复（save()、restore()）
        canvas.drawColor(Color.GRAY);
        canvas.save();//将当前画布放入栈顶
        canvas.clipRect(200,200,500,500);
        canvas.drawColor(Color.RED);
        canvas.save();
        canvas.clipRect(250,250,450,450);
        canvas.drawColor(Color.BLUE);
        canvas.save();
        canvas.clipRect(300,300,400,400);
        canvas.drawColor(Color.GREEN);
        canvas.restore();//使用restore（），会怎样呢，会把栈顶的画布取出来，当做当前画布的画图
        canvas.drawColor(Color.WHITE);

    }
}
