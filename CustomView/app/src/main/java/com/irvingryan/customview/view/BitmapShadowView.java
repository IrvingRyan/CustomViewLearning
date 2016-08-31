package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.irvingryan.customview.R;

/**
 * Created by wentao on 2016/8/31.
 */
public class BitmapShadowView extends View {

    private Paint paint;
    private Bitmap extractBitmap;

    public BitmapShadowView(Context context) {
        super(context);
        init();
    }

    public BitmapShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blog12);
        //提取bitmap的透明度
        extractBitmap=srcBitmap.extractAlpha();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(extractBitmap,null,new Rect(0,0,400,400*extractBitmap.getWidth()/extractBitmap.getHeight()),paint);
        canvas.translate(getWidth()/2,0);
        paint.setColor(Color.RED);
        canvas.drawBitmap(extractBitmap,null,new Rect(0,0,400,400*extractBitmap.getWidth()/extractBitmap.getHeight()),paint);
    }
}
