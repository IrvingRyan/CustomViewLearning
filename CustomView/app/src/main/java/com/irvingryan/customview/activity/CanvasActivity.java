package com.irvingryan.customview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.irvingryan.customview.R;
import com.irvingryan.customview.view.FlagView;
import com.irvingryan.customview.view.QQView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CanvasActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.qq)
    Button qq;
    @Bind(R.id.qqView)
    QQView qqView;
    @Bind(R.id.flag)
    Button flag;
    @Bind(R.id.flagView)
    FlagView flagView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        qq.setOnClickListener(this);
        flag.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        qqView.setVisibility(View.GONE);
        flagView.setVisibility(View.GONE);
        switch (v.getId()){
            case R.id.qq:
                qqView.setVisibility(View.VISIBLE);
                break;
            case R.id.flag:
                flagView.setVisibility(View.VISIBLE);
                break;

        }
    }
}
