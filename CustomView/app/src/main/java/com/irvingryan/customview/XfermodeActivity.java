package com.irvingryan.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.irvingryan.customview.view.BookLightView;
import com.irvingryan.customview.view.CocaColaView;
import com.irvingryan.customview.view.CornerRoundView;
import com.irvingryan.customview.view.EraserView;
import com.irvingryan.customview.view.GuaguakaView;
import com.irvingryan.customview.view.InvertedView;
import com.irvingryan.customview.view.TwitterView;
import com.irvingryan.customview.view.View12;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * paint 函数之setXfermode的应用
 */
public class XfermodeActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.twitter)
    Button twitter;
    @Bind(R.id.booklight)
    Button booklight;
    @Bind(R.id.cornerround)
    Button cornerround;
    @Bind(R.id.twitterView)
    TwitterView twitterView;
    @Bind(R.id.bookLightView)
    BookLightView bookLightView;
    @Bind(R.id.cornerRoundView)
    CornerRoundView cornerRoundView;
    @Bind(R.id.invertedView)
    InvertedView invertedView;
    @Bind(R.id.inverted)
    Button inverted;
    @Bind(R.id.view12)
    Button view12;
    @Bind(R.id.view12View)
    View12 view12View;
    @Bind(R.id.eraser)
    Button eraser;
    @Bind(R.id.eraserView)
    EraserView eraserView;
    @Bind(R.id.guaguaka)
    Button guaguaka;
    @Bind(R.id.guaguakaView)
    GuaguakaView guaguakaView;
    @Bind(R.id.cocaCola)
    Button cocaCola;
    @Bind(R.id.cocaColaView)
    CocaColaView cocaColaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xfermode);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        twitter.setOnClickListener(this);
        booklight.setOnClickListener(this);
        cornerround.setOnClickListener(this);
        inverted.setOnClickListener(this);
        view12.setOnClickListener(this);
        eraser.setOnClickListener(this);
        guaguaka.setOnClickListener(this);
        cocaCola.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        twitterView.setVisibility(View.GONE);
        cornerRoundView.setVisibility(View.GONE);
        bookLightView.setVisibility(View.GONE);
        invertedView.setVisibility(View.GONE);
        view12View.setVisibility(View.GONE);
        eraserView.setVisibility(View.GONE);
        guaguakaView.setVisibility(View.GONE);
        cocaColaView.setVisibility(View.GONE);
        switch (v.getId()) {
            case R.id.twitter:
                twitterView.setVisibility(View.VISIBLE);
                break;
            case R.id.cornerround:
                cornerRoundView.setVisibility(View.VISIBLE);
                break;
            case R.id.booklight:
                bookLightView.setVisibility(View.VISIBLE);
                break;
            case R.id.inverted:
                invertedView.setVisibility(View.VISIBLE);
                break;
            case R.id.view12:
                view12View.setVisibility(View.VISIBLE);
                break;
            case R.id.eraser:
                eraserView.setVisibility(View.VISIBLE);
                break;
            case R.id.guaguaka:
                guaguakaView.setVisibility(View.VISIBLE);
                break;
            case R.id.cocaCola:
                cocaColaView.setVisibility(View.VISIBLE);
                break;
        }
    }
}
