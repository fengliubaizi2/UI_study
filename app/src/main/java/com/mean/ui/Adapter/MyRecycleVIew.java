package com.mean.ui.Adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by renzhenhua on 2018/10/10.
 */

public class MyRecycleVIew extends RecyclerView {
    public MyRecycleVIew(Context context) {
        super(context);
    }

    public MyRecycleVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecycleVIew(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        canvas.drawArc();
    }
}
