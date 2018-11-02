package com.mean.ui.MyView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by renzhenhua on 2017/10/10.
 */

public class MyGroup extends RelativeLayout {
    public MyGroup(Context context) {
        super(context);
    }

    public static String TAG="RZH";
    public MyGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG,"touch");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TAG,"onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }
}
