package com.irvingryan.customview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 色彩部分难点比较多
 * 需要使用的时候再重点研究
 */
public class SaturationActivity extends AppCompatActivity {

    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.seekBar)
    SeekBar seekBar;
    @Bind(R.id.seekBar2)
    SeekBar seekBar2;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;
    private Bitmap bitmap;
    private Bitmap mTempBmp;
    private String TAG = "SaturationActivity";
    private ColorMatrix colorMatrix;
    private Canvas canvas;
    private Paint paint;
    private int axis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturation);
        ButterKnife.bind(this);
        initParams();
        initView();
    }

    private void initParams() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test);
        mTempBmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        colorMatrix = new ColorMatrix();
        canvas = new Canvas(mTempBmp);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private void initView() {

        seekBar.setProgress(1);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(TAG, "progress == " + progress);
                handleSaturationChange(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar2.setMax(360);
        seekBar2.setProgress(180);
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                handleRotateColor(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio0:
                        axis=0;
                        break;
                    case R.id.radio1:
                        axis=1;
                        break;
                    case R.id.radio2:
                        axis=2;
                        break;
                }
            }
        });
    }

    /**
     * 2.色彩旋转
     *
     * @param progress
     */
    private void handleRotateColor(int progress) {
        /**
         * 以下的方法在调用的时候都会先重置矩阵
         * 想要叠加效果不能直接用两个set效果
         */
        colorMatrix.setRotate(axis, progress-180);//旋转色彩
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        imageView.setImageBitmap(mTempBmp);
    }

    /**
     * 1.更改饱和度
     *
     * @param progress 进度大小
     */
    private void handleSaturationChange(int progress) {
        /**
         * 以下的方法在调用的时候都会先重置矩阵
         * 想要叠加效果不能直接用两个set效果
         */
        colorMatrix.setSaturation(progress);//更改饱和度的方法
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        imageView.setImageBitmap(mTempBmp);
    }
}
