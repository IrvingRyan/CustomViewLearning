package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.irvingryan.customview.R;

/**
 * Created by wentao on 2016/8/23.
 */
public class TwitterView extends View {

    private Bitmap dstBitmap;
    private Bitmap srcBitmap;
    private Paint paint;

    public TwitterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        dstBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.twiter_bg,null);
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.twiter_light,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(srcBitmap,0,0,paint);
        canvas.restoreToCount(layerId);
    }
}
