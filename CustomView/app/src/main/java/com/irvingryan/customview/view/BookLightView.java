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
 * Created by wentao on 2016/8/23.
 */
public class BookLightView extends  View{

    private Bitmap dstBitmap;
    private Bitmap srcBitmap;
    private Paint paint;

    public BookLightView(Context context) {
        super(context);
        init();
    }

    public BookLightView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        dstBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dst_pic,null);
        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.src_pic,null);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        canvas.drawBitmap(srcBitmap,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);

    }
}
