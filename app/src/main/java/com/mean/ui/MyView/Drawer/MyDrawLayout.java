package com.mean.ui.MyView.Drawer;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by renzhenhua on 2017/10/16.
 */

public class MyDrawLayout extends DrawerLayout implements DrawerLayout.DrawerListener {
    private float y;
    private float slideOffset;

    public MyDrawLayout(Context context) {
        this(context, null);
    }

    public MyDrawLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {

        super.onFinishInflate();
        init();
    }

    MyDrawLinearLayout myDrawLinearLayout;
    MyDrawRelativeLayout myDrawRelativeLayout;
    View contentView;

    private void init() {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof MyDrawLinearLayout) {
                myDrawLinearLayout = (MyDrawLinearLayout) view;
                removeView(myDrawLinearLayout);
            } else {
                contentView = view;
            }

        }
        myDrawRelativeLayout = new MyDrawRelativeLayout(getContext(), myDrawLinearLayout);
        addView(myDrawRelativeLayout);
        addDrawerListener(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        y = ev.getY();
        if (ev.getAction()==MotionEvent.ACTION_UP){
            myDrawLinearLayout.onMotionUp();
            return super.dispatchTouchEvent(ev);
        }
        if (slideOffset<1){
            return super.dispatchTouchEvent(ev);
        }else {
            myDrawRelativeLayout.setTouchY(y, slideOffset);
        }

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        y = ev.getY();
        return super.onTouchEvent(ev);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        this.slideOffset = slideOffset;
        myDrawRelativeLayout.setTouchY(y, slideOffset);
        if (contentView != null) {
            float contentSet=drawerView.getWidth() * slideOffset / 3;
            contentView.setTranslationX(contentSet);
        }
    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
