package com.irvingryan.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.irvingryan.customview.R;

/**
 * 封装一个完整的View 属性值参考 http://blog.csdn.net/harvic880925/article/details/46537767
 * Created by wentao on 2016/8/31.
 */
public class BitmapShadowView extends View {
    private static final int DEFAULT_COLOR = Color.GRAY;

    private Paint paint;
    private Bitmap extractBitmap;
    private Bitmap srcBitmap;
    private Rect rect;
    private RectF sRect;
    private float radius;
    private BlurMaskFilter blurMaskFilter;
    private float dx;
    private float dy;
    private int color;
    private int src;
    private String TAG="BitmapShadowView";

    public BitmapShadowView(Context context) throws Exception {
        super(context);
        init(context, null);
    }

    public BitmapShadowView(Context context, AttributeSet attrs) throws Exception {
        super(context, attrs);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) throws Exception {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.BitmapShadowView);
        radius=typedArray.getInteger(R.styleable.BitmapShadowView_shadowRadius,0);
        dx=typedArray.getDimension(R.styleable.BitmapShadowView_shadowDx,0);
        dy=typedArray.getDimension(R.styleable.BitmapShadowView_shadowDy,0);
        color=typedArray.getColor(R.styleable.BitmapShadowView_shadowColor, DEFAULT_COLOR);
        src=typedArray.getResourceId(R.styleable.BitmapShadowView_src, -1);
        typedArray.recycle();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        if (src==-1){
            throw new Exception("you should add a picture!!!");
        }
        srcBitmap = BitmapFactory.decodeResource(getResources(),src);
        //提取bitmap的透明度
        extractBitmap= srcBitmap.extractAlpha();
        blurMaskFilter = new BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMeasureSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        Log.i(TAG, "onMeasure widthMeasureSpec mode== " + (widthMeasureSpecMode == MeasureSpec.AT_MOST));
        Log.i(TAG,"onMeasure heightMeasureSpec== "+measureWidth);
        Log.i(TAG,"onMeasure widthMeasureSpec mode== "+(heightMeasureSpecMode==MeasureSpec.EXACTLY));
        Log.i(TAG,"onMeasure heightMeasureSpec== "+measureHeight);
        int width=srcBitmap.getWidth();
        int height=srcBitmap.getHeight();
        //通过设置MeasureDimension后 getWidth 和getHeight的值就为设置的值
        setMeasuredDimension(widthMeasureSpecMode==MeasureSpec.EXACTLY?measureWidth:width,heightMeasureSpecMode==MeasureSpec.EXACTLY?measureHeight:height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        paint.setShadowLayer(20,20,20,Color.GRAY);
        int width=getWidth();
        int height=getHeight();
        rect = new Rect(0, 0, width, height);
        sRect = new RectF(0+dx, 0+dy, width +dx, height +dy);
        paint.setMaskFilter(blurMaskFilter);
        canvas.drawBitmap(extractBitmap,null,sRect,paint);
        paint.setMaskFilter(null);
        canvas.drawBitmap(srcBitmap,null,rect,paint);
    }
}
