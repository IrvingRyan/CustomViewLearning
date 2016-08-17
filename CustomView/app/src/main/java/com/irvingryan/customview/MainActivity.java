package com.irvingryan.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.irvingryan.customview.view.View8;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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
        View8 view=new View8(this);
        root.addView(view,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.startAnimation();
    }
}
