package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.irvingryan.customview.R;

/**
 * SRC_IN实现橡皮擦功能
 * Created by wentao on 2016/8/24.
 */
public class EraserView extends View {

    private Paint paint;
    private Path path;
    private float preX;
    private float preY;
    private float endX;
    private float endY;
    private Bitmap srcBitmap;
    private Bitmap dstBitmap;

    public EraserView(Context context) {
        super(context);
        init();
    }

    public EraserView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(50);
        path = new Path();
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        dstBitmap = Bitmap.createBitmap(srcBitmap.getWidth(),srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //画dst
        Canvas c = new Canvas(dstBitmap);
        c.drawPath(path,paint);
        //将dst画到桌布上
        canvas.drawBitmap(dstBitmap,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //画src
        canvas.drawBitmap(srcBitmap,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                preX=event.getX();
                preY=event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                path.quadTo(preX,preY,(event.getX()+preX)/2,(event.getY()+preY)/2);
                invalidate();
                preX=(event.getX()+preX)/2;
                preY=(event.getY()+preY)/2;
                break;

        }
        return super.onTouchEvent(event);
    }
}
