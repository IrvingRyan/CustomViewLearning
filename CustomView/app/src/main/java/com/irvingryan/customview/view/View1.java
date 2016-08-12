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
 * Created by wentao on 2016/8/12.
 */
public class View1 extends View {

    private Paint paint;

    public View1(Context context) {
        super(context);
        init();
    }

    public View1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init(){
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(190, 200, 150, paint);
    }
}
