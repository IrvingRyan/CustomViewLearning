package com.irvingryan.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.irvingryan.customview.view.View4;

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
        View4 view=new View4(this);
        root.addView(view);
    }
}
