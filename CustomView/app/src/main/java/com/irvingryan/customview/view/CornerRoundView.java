package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.irvingryan.customview.R;

/**
 * SRC_IN的应用
 * Created by wentao on 2016/8/24.
 */
public class CornerRoundView extends View {

    private Paint paint;
    private Bitmap srcBitmap;
    private Bitmap dstBitmap;

    public CornerRoundView(Context context) {
        super(context);
        init();
    }

    public CornerRoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dstBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_shade, null);
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(srcBitmap,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
