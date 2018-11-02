package com.mean.ui.MyView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.mean.ui.R;

/**
 * Created by renzhenhua on 2017/10/14.
 */

public class SplashView extends View {

    float radius = 20f;
    float circle_r = 100f;
    float height = 1280;
    float width = 720;
    public static float PI = (float) Math.PI;
    public static float PI_3 = (float) Math.PI/3;

    float startA = 0;

    public SplashView(Activity context) {
        super(context);
        width = context.getWindow().getWindowManager().getDefaultDisplay().getWidth();
        height = context.getWindow().getWindowManager().getDefaultDisplay().getHeight();
    }

    public SplashView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public SplashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//    @Override
//    public void setBackgroundColor(@ColorInt int color) {
//        super.setBackgroundColor(Color.WHITE);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint_1 = new Paint();
        Paint paint_2 = new Paint();
        Paint paint_3 = new Paint();
        Paint paint_4 = new Paint();
        Paint paint_5 = new Paint();
        Paint paint_6 = new Paint();
        paint_1.setColor(getResources().getColor(R.color.blue));
        paint_2.setColor(getResources().getColor(R.color.orange));
        paint_3.setColor(getResources().getColor(R.color.aqua));
        paint_4.setColor(getResources().getColor(R.color.yellow));
        paint_5.setColor(getResources().getColor(R.color.blue));
        paint_6.setColor(getResources().getColor(R.color.pink));
        if(circle_r>radius) {
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 0 * 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 0 / 3), radius, paint_1);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 1 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 1 / 3), radius, paint_2);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 2 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 2 / 3), radius, paint_3);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 3 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 3 / 3), radius, paint_4);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 4 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 4 / 3), radius, paint_5);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 5 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 5 / 3), radius, paint_6);
        }else {

            radius=circle_r;
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 0 * 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 0 / 3), radius, paint_1);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 1 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 1 / 3), radius, paint_2);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 2 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 2 / 3), radius, paint_3);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 3 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 3 / 3), radius, paint_4);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 4 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 4 / 3), radius, paint_5);
            canvas.drawCircle(width / 2 + circle_r * (float) Math.cos(startA + PI * 5 / 3), height / 2 + circle_r * (float) Math.sin(startA + PI * 5 / 3), radius, paint_6);

        }
    }

    public void setStartA(float startA) {
        this.startA = startA;
        postInvalidate();
    }

    public void setCircle_r(float circle_r) {
        this.circle_r = circle_r;
        postInvalidate();
    }
}
