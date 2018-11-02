package com.mean.ui.MyView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.mean.ui.R;

/**
 * Created by renzhenhua on 2017/10/14.
 */

public class ContentView extends android.support.v7.widget.AppCompatImageView {

    float height=1280f;
    float width=720f;
    private float radius=0;

    public ContentView(Activity context) {
        super(context);
        height=context.getWindow().getWindowManager().getDefaultDisplay().getHeight();
        width=context.getWindow().getWindowManager().getDefaultDisplay().getWidth();
        setImageResource(R.drawable.icon_2);
        setScaleType(ScaleType.FIT_XY);
    }

    public ContentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ContentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public void setBackgroundResource(@DrawableRes int resId) {
//        super.setBackgroundResource(R.drawable.icon_2);
//    }

//    @Override
//    public void setBackgroundColor(@ColorInt int color) {
//        super.setBackgroundColor(Color.RED);
//    }

//    setBackgroundColor(Color.RED);
//    public DrawImageView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        // TODO Auto-generated constructor stub
//        this.context = context;
//        this.paint = new Paint();
//        this.paint.setAntiAlias(true); //消除锯齿
//        this.paint.setStyle(Style.STROKE);  //绘制空心圆或 空心矩形
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画背景圆环
        float centerX = width / 2;
        float centerY = height / 2;
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2000); // 圆环的宽度
        paint.setAntiAlias(true);
        canvas.drawCircle(centerX,centerY, radius,paint);
    }
    public void setRadius(float radius) {
        this.radius = radius;
        postInvalidate();
    }
}
