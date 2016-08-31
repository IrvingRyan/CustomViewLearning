package com.irvingryan.customview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.irvingryan.customview.R;
import com.irvingryan.customview.view.ShadowView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShadowActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.radius)
    Button radius;
    @Bind(R.id.dx)
    Button dx;
    @Bind(R.id.dy)
    Button dy;
    @Bind(R.id.shadowView)
    ShadowView shadowView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layerlist);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        radius.setOnClickListener(this);
        dx.setOnClickListener(this);
        dy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.radius:
                shadowView.addRadius();
                break;
            case R.id.dx:
                shadowView.addDx();
                break;
            case R.id.dy:
                shadowView.addDy();
                break;
        }
    }
}
