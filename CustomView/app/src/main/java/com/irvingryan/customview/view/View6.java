package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.平移（translate） translate函数其实实现的相当于平移坐标系，即平移坐标系的原点的位置。
        canvas.translate(100, 100);
        Rect rect1 = new Rect(0,0,400,220);
        canvas.drawRect(rect1, paint);
    }
}
