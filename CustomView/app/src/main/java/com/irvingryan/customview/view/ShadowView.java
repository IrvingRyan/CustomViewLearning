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
public class ShadowView extends View {

    private Paint paint;
    private float radius;
    private float dx;
    private float dy;
    private Bitmap bitmap;

    public ShadowView(Context context) {
        super(context);
        init();
    }

    public ShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setTextSize(50);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setShadowLayer(radius,dx,dy,Color.GRAY);
        canvas.drawText("Everything that kills me makes me fell alive.",20,100,paint);
        canvas.translate(0,200);
        canvas.drawRect(new Rect(20,20,100,100),paint);
        canvas.translate(0,200);
        canvas.drawBitmap(bitmap,null,new Rect(0,0,400,400*getWidth()/getHeight()),paint);
    }

    public void addRadius(){
        radius++;
        invalidate();
    }
    public void addDx(){
        dx++;
        invalidate();
    }
    public void addDy(){
        dy++;
        invalidate();
    }
}
