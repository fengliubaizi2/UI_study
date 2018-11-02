package com.mean.ui.MyView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by renzhenhua on 2017/10/10.
 */

public class MyButton extends View {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
