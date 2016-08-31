package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 模糊（发散）效果展示
 * Created by wentao on 2016/8/31.
 */
public class BlurMaskFilterView extends View {

    private Paint paint;

    public BlurMaskFilterView(Context context) {
        super(context);
        init();
    }

    public BlurMaskFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER));
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setTextAlign(Paint.Align.CENTER);
        p.setTextSize(50);
        p.setColor(Color.GREEN);
        canvas.drawText("Outer",200,80,p);
        canvas.drawCircle(200,200,100, this.paint);
        canvas.translate(getWidth()/2,0);
        this.paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));
        canvas.drawText("Inner",200,80, p);
        canvas.drawCircle(200,200,100, this.paint);
        canvas.translate(-getWidth()/2,getHeight()/2);
        this.paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));
        canvas.drawText("Solid",200,80,p);
        canvas.drawCircle(200,200,100, this.paint);
        canvas.translate(getWidth()/2,0);
        this.paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        canvas.drawText("Normal",200,80,p);
        canvas.drawCircle(200,200,100, this.paint);

    }
}
