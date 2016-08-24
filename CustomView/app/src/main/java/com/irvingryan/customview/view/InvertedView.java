package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.irvingryan.customview.R;

/**
 * SRC_IN实现倒影
 * Created by wentao on 2016/8/24.
 */
public class InvertedView extends View {
    private Paint paint;
    private Bitmap dstBitmap;
    private Bitmap srcBitmap;
    private Bitmap invertBitmap;

    public InvertedView(Context context) {
        super(context);
        init();
    }

    public InvertedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dstBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_invert_shade, null);
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog, null);
        Matrix matrix=new Matrix();
        matrix.setScale(1f,-1f);
        invertBitmap = Bitmap.createBitmap(srcBitmap, 0, 0, srcBitmap.getWidth(), srcBitmap.getHeight(), matrix, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(srcBitmap,0,0,paint);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.translate(0,srcBitmap.getHeight());
        canvas.drawBitmap(dstBitmap,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(invertBitmap,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
