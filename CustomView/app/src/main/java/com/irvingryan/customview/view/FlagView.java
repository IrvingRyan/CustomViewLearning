package com.irvingryan.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wentao on 2016/8/29.
 */
public class FlagView extends View {

    private Paint paint;

    public FlagView(Context context) {
        super(context);
        init();
    }

    public FlagView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.CYAN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.FLAG之MATRIX_SAVE_FLAG(只保存了位置矩阵)
        /**
         1、当save\saveLayer调用Canvas.MATRIX_SAVE_FLAG标识时只会保存画布的位置矩阵信息，在canvas.restore()时也只会恢复位置信息，而改变过的画布大小是不会被恢复的。
         2、当使用canvas.saveLayer(Canvas.MATRIX_SAVE_FLAG)时，需要与Canvas.HAS_ALPHA_LAYER_SAVE_FLAG一起使用，不然新建画布所在区域原来的图像将被清空。
         */
        //使用save
//        canvas.drawRect(100,0,200,200,paint);
//        canvas.drawColor(Color.BLACK);
//        canvas.save(Canvas.MATRIX_SAVE_FLAG);
//        paint.setColor(Color.YELLOW);
//        canvas.rotate(50);
//        canvas.drawRect(100,0,200,200,paint);
//        canvas.clipRect(100,0,200,100);
//        canvas.drawColor(Color.GRAY);
//        canvas.restore();//恢复时不会恢复画布的大小
//        canvas.drawColor(Color.GREEN);
        //使用saveLayer
//        canvas.drawColor(Color.GREEN);
//
//        canvas.saveLayer(0,0,getWidth(),getHeight(),paint,Canvas.MATRIX_SAVE_FLAG|Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);
//        canvas.clipRect(100,0,200,100);
//        canvas.restore();
//
//        canvas.drawColor(Color.YELLOW);
        /**
         1、当save/saveLayer调用 Canvas.CLIP_SAVE_FLAG时只会保存画布的裁剪信息，在canvas.restore()时也只会恢复裁剪信息，而改变过的画布位置信息是不会被恢复的。
         2、当使用canvas.saveLayer(Canvas.CLIP_SAVE_FLAG)时，需要与Canvas.HAS_ALPHA_LAYER_SAVE_FLAG一起使用，不然新建画布所在区域原来的图像将被清空。
         */
        //2.FLAG之CLIP_SAVE_FLAG（仅保存Canvas的裁剪信息，不影响位置信息）
        /**
         1、HAS_ALPHA_LAYER_SAVE_FLAG表示新建的bitmap画布在与上一个画布合成时，不会将上一层画布内容清空，直接盖在上一个画布内容上面。
         2、FULL_COLOR_LAYER_SAVE_FLAG则表示新建的bimap画布在与上一个画布合成时，先将上一层画布对应区域清空，然后再盖在上面。
         3、当HAS_ALPHA_LAYER_SAVE_FLAG与FULL_COLOR_LAYER_SAVE_FLAG两个标识同时指定时，以HAS_ALPHA_LAYER_SAVE_FLAG为主
         4、当即没有指定HAS_ALPHA_LAYER_SAVE_FLAG也没有指定FULL_COLOR_LAYER_SAVE_FLAG时，系统默认使用FULL_COLOR_LAYER_SAVE_FLAG；
         */
        //3.FLAG之HAS_ALPHA_LAYER_SAVE_FLAG和FULL_COLOR_LAYER_SAVE_FLAG
        canvas.drawColor(Color.RED);

//        canvas.saveLayer(0,0,500,500,paint,Canvas.FULL_COLOR_LAYER_SAVE_FLAG);
        canvas.saveLayer(0,0,500,500,paint,Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);//当这两个标识同时使用时，以Canvas.HAS_ALPHA_LAYER_SAVE_FLAG为主
        canvas.drawRect(100,100,300,300,paint);
        canvas.restore();
        /**
         1、CLIP_TO_LAYER_SAVE_FLAG意义是在新建bitmap前，先把canvas给裁剪，一旦画板被裁剪，那么其中的各个画布都会被受到影响。而且由于它是在新建bitmap前做的裁剪，所以是无法恢复的；
         2、当CLIP_TO_LAYER_SAVE_FLAG与CLIP_SAVE_FLAG标识共用时，在调用restore()后，画布将被恢复
         */
        //4.FLAG之CLIP_TO_LAYER_SAVE_FLAG

    }
}
