package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.irvingryan.customview.R;

/**
 * ColorMatrix与滤镜效果
 * Created by wentao on 2016/8/18.
 */
public class View10 extends View {

    private Paint paint;
    private Bitmap bitmap;
    private ColorMatrix colorMatrix;
    private Rect rect;
    private ColorMatrixColorFilter colorMatrixColorFilter;

    public View10(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setARGB(255,200,100,100);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        rect = new Rect(0, 0, 500, 500 * bitmap.getHeight() / bitmap.getWidth());
        // 生成色彩矩阵
        colorMatrix = new ColorMatrix(new float[]{
                1, 0, 0, 0, 0,//R
                0, 1, 0, 0, 0,//G
                0, 0, 1, 0, 0,//B
                0, 0, 0, 1, 0,//A 第五列矩阵代表增加的值
        });
        //黑白图片
        ColorMatrix blackMatrix = new ColorMatrix(new float[]{
                0.213f, 0.715f, 0.072f, 0, 0,
                0.213f, 0.715f, 0.072f, 0, 0,
                0.213f, 0.715f, 0.072f, 0, 0,
                0,       0,    0, 1, 0,
        });
        //设置饱和度
        colorMatrix.setSaturation(Float.MAX_VALUE);
        colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0,50);
        canvas.drawBitmap(bitmap, null,rect, paint);
//        canvas.drawRect(rect,paint);
        canvas.translate(550,0);

        paint.setColorFilter(colorMatrixColorFilter);
//        canvas.drawRect(rect,paint);
        canvas.drawBitmap(bitmap, null, rect, paint);
    }
}
