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
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.irvingryan.customview.R;

/**
 * SRC_OUT实现刮刮奖效果
 * Created by wentao on 2016/8/24.
 */
public class GuaguakaView extends View {

    private String TAG="GuaguakaView";
    private Bitmap srcBitmap;
    private Bitmap dstBitmap;
    private Paint paint;
    private Path path;
    private float preX;
    private float preY;
    private Bitmap textBitmap;
    private Canvas c;
    private PorterDuffXfermode porterDuffXfermode;

    public GuaguakaView(Context context) {
        super(context);
        init();
    }

    public GuaguakaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(50);
        path = new Path();
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.guaguaka_pic,null);
        dstBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        textBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        //1.绘制底部文字
        Canvas c = new Canvas(textBitmap);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.GREEN);
        p.setTextSize(80);
        p.setTextAlign(Paint.Align.CENTER);
        c.drawText("再买一瓶",srcBitmap.getWidth()/2f,srcBitmap.getHeight()/2f, p);
        this.c = new Canvas(dstBitmap);
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画出底部文字
        canvas.drawBitmap(textBitmap,0,0,paint);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //2.绘制手指滑动路径 用做目标图片
        c.drawPath(path,paint);
        //3.绘制目标图片
        canvas.drawBitmap(dstBitmap,0,0,paint);
        paint.setXfermode(porterDuffXfermode);
        //4.绘制源图片
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
                preX=(event.getX()+preX)/2;
                preY=(event.getY()+preY)/2;
                break;
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.i(TAG,"onDetachedFromWindow");
        super.onDetachedFromWindow();
        if (srcBitmap!=null){
            srcBitmap.recycle();
            srcBitmap=null;
        }
        if (dstBitmap!=null){
            dstBitmap.recycle();
            dstBitmap=null;
        }
        if (textBitmap!=null){
            textBitmap.recycle();
            textBitmap=null;
        }
    }
}
