package com.irvingryan.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.AvoidXfermode;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.irvingryan.customview.R;

/**
 * paint setXfermode方法的使用
 * 参考地址 http://blog.csdn.net/harvic880925/article/details/51264653
 * Created by wentao on 2016/8/22.
 */
public class View11 extends View {

    private Paint paint;
    private Bitmap bitmap;
    private Bitmap fBitmap;

    public View11(Context context) {
        super(context);
        init();
    }

    public View11(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public View11(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public View11(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);//禁用硬件加速
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dog);
        fBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.flower);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=500;
        int height=500*bitmap.getHeight()/bitmap.getWidth();

        int layerID = canvas.saveLayer(0,0,width*2,height*2,paint,Canvas.ALL_SAVE_FLAG);
        //1.AvoidXfermode的用法
        //先画出原图
        canvas.drawBitmap(bitmap,null,new RectF(0,0,width,height),paint);
        paint.setXfermode(new AvoidXfermode(Color.WHITE,100, AvoidXfermode.Mode.TARGET));
        //在原图的基础上 将白色部分替换为下面的小花儿 白色的容差效果为100
//        canvas.drawBitmap(fBitmap,null,new RectF(0,0,width,height),paint);
        paint.setARGB(0x00,0xff,0xff,0xff);//透明
        /**
         其实Android在绘图时会先检查该画笔Paint对象有没有设置Xfermode，如果没有设置Xfermode，那么直接将绘制的图形覆盖Canvas对应位置原有的像素；如果设置了Xfermode，那么会按照Xfermode具体的规则来更新Canvas中对应位置的像素颜色。
         所以对于AvoidXfermode而言，这个规则就是先把把目标区域（选区）中的颜色值先清空，然后再把目标颜色给替换上；
         */
        canvas.drawRect(0,0,width,height,paint);
        bitmap.recycle();
        fBitmap.recycle();
        //2.PorterDuffXfermode的使用请查看ApiDemos Graphics/Xfermodes
        canvas.restoreToCount(layerID);
    }
}
