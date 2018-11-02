package com.mean.ui.MyView.Drawer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mean.ui.R;

/**
 * Created by renzhenhua on 2017/10/16.
 */

public class MyDrawLinearLayout extends LinearLayout {
    float slideOffset;
    boolean opened;
    float maxTranslationX;

    public MyDrawLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.DrawerBar);
        maxTranslationX = a.getDimension(R.styleable.DrawerBar_maxTranslationX, 0);
        a.recycle();
    }

    public void setTouchY(float y, float slideOffset) {
        opened = slideOffset == 1;
        for (int i = 0; i < getChildCount(); i++) {

            View child = getChildAt(i);
            child.setPressed(false);
            boolean isHover = opened && child.getTop() < y && child.getBottom() > y;
            if (isHover) {
                child.setPressed(true);
                if (child instanceof TextView) {
                    ((TextView) child).setTextColor(Color.WHITE);
                }
            } else {
                if (child instanceof TextView) {
                    ((TextView) child).setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }
            apply(getParent(), child, y, slideOffset);
        }
    }

    float translationX = 0;

    private void apply(ViewParent parent, View child, float y, float slideOffset) {
        int centerY = child.getTop() + child.getHeight() / 2;
        float distance = Math.abs(y - centerY);
        float scale = distance / getHeight() * 3;
        translationX = (1 - scale) * maxTranslationX;
//        translationX = (1 - scale) * 120;
        Log.i("Rzh", centerY + "---" + distance + "---" + scale + "---" + translationX + "---");
        child.setTranslationX(translationX);

    }

    public void onMotionUp() {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.isPressed()) {
                child.performClick();

                if (child instanceof TextView) {
                    ((TextView) child).setTextColor(Color.WHITE);
                }
//                回调
                Log.i("Rzh", "-回调--");

            }
        }
    }
}