package com.irvingryan.customview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * onMeasure 与 onLayout 的使用 http://blog.csdn.net/harvic880925/article/details/47029169
 * Created by wentao on 2016/9/2.
 */
public class MyLayout extends ViewGroup {
    private String TAG="FlowLayout";

    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMeasureSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int measuredWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measuredHeight = MeasureSpec.getSize(heightMeasureSpec);
        int width=0;
        int height=0;
        int count = getChildCount();
        for (int i=0;i<count;i++){
            View view = getChildAt(i);
            MarginLayoutParams params = (MarginLayoutParams)view.getLayoutParams();
            measureChild(view,widthMeasureSpec,heightMeasureSpec);
            int childWidth = view.getMeasuredWidth()+params.leftMargin+params.rightMargin;
            int childHeight = view.getMeasuredHeight()+params.topMargin+params.bottomMargin;
            height+=childHeight;
            width=childWidth;
        }
        setMeasuredDimension(widthMeasureSpecMode==MeasureSpec.EXACTLY?measuredWidth:width,heightMeasureSpecMode==MeasureSpec.EXACTLY?measuredHeight:height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.i(TAG,"l = "+l+" t = "+t+" r = "+r+" b = "+b);
        int top=0;
        int count = getChildCount();
        for (int i=0;i<count;i++){
            View child = getChildAt(i);
            MarginLayoutParams params = (MarginLayoutParams)child.getLayoutParams();
            int childHeight = child.getMeasuredHeight()+params.topMargin+params.bottomMargin;
            int childWidth = child.getMeasuredWidth()+params.leftMargin+params.rightMargin;
            child.layout(params.leftMargin,top+params.topMargin,childWidth,top+childHeight);
            top+=childHeight;
        }
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(),attrs);
    }
}
