package com.irvingryan.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.irvingryan.customview.activity.CanvasActivity;
import com.irvingryan.customview.activity.SaturationActivity;
import com.irvingryan.customview.activity.ShadowActivity;
import com.irvingryan.customview.activity.XfermodeActivity;
import com.irvingryan.customview.view.BlurMaskFilterView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @Bind(R.id.root)
    FrameLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
//        View1 view=new View1(this);
//        View2 view=new View2(this);
//        View3 view=new View3(this);
//        View4 view=new View4(this);
//        View5 view=new View5(this);
//        View6 view=new View6(this);
//        View7 view=new View7(this);
//        View8 view=new View8(this);
//        View9 view=new View9(this);
//        View10 view = new View10(this);
//        BlurMaskFilterView view=new BlurMaskFilterView(this);
        BlurMaskFilterView view=new BlurMaskFilterView(this);
        root.addView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @OnClick(R.id.saturationBtn)
    public void startSaturationActivity(){
        Intent intent = new Intent(this, SaturationActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.xfermodeBtn)
    public void startXfermodeActivity(){
        Intent intent = new Intent(this, XfermodeActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.canvasBtn)
    public void startCanvasActivity(){
        Intent intent = new Intent(this, CanvasActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.layerlistBtn)
    public void startLayerlistActivity(){
        Intent intent = new Intent(this, ShadowActivity.class);
        startActivity(intent);
    }
}
