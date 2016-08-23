package com.irvingryan.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;


/**
 * PorterDuffXfermode 各个模式的详解
 * Created by wentao on 2016/8/23.
 */
public class View12 extends View {

    private Paint mPaint;
    private Bitmap srcBitmap;
    private Bitmap dstBitmap;
    private int H=200;
    private int W=200;

    public View12(Context context) {
        super(context);
        init();
    }

    public View12(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View12(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View12(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }
    private void init() {
        //禁用硬件加速 很重要
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        srcBitmap=makeSrc();
        dstBitmap=makeDst();
    }

    private Bitmap makeDst() {
        Bitmap bitmap = Bitmap.createBitmap(H,W, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFFFFCC44);
        canvas.drawRect(0,0,H,W,paint);
        return bitmap;
    }

    private Bitmap makeSrc() {
        Bitmap bitmap = Bitmap.createBitmap(H,W, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFF66AAFF);
        canvas.drawOval(new RectF(0,0,H,W),paint);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.BLACK);
        int layerId = canvas.saveLayer(0, 0, H*2, W*2, mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap,0,0, mPaint);
        /**
            -Mode.ADD（饱和度相加）
            -Mode.LIGHTEN（变亮）
            -Mode.DARKEN（变暗）
            -Mode.MULTIPLY(正片叠底)
            -Mode.OVERLAY（叠加）
            -Mode.Mode.SCREEN（滤色）
         */
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        canvas.drawBitmap(srcBitmap,H/3f,W/3f, mPaint);
        canvas.restoreToCount(layerId);
    }
}
