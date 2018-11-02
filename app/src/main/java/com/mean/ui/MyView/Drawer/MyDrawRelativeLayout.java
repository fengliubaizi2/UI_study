package com.mean.ui.MyView.Drawer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by renzhenhua on 2017/10/16.
 */

public class MyDrawRelativeLayout extends RelativeLayout {
    MyDrawLinearLayout myDrawLinearLayout;
    MyDrawerBgView myDrawerBgView;
    public MyDrawRelativeLayout(Context context, MyDrawLinearLayout myDrawLinearLayout) {
        super(context);
        init(myDrawLinearLayout);
    }

    private void init(MyDrawLinearLayout myDrawLinearLayout) {
        this.myDrawLinearLayout = myDrawLinearLayout;
        setLayoutParams(myDrawLinearLayout.getLayoutParams());
        myDrawerBgView = new MyDrawerBgView(getContext());
        myDrawerBgView.setPaintColor(( (ColorDrawable) myDrawLinearLayout.getBackground()) .getColor());
        this.myDrawLinearLayout.setBackgroundColor(Color.TRANSPARENT);
        addView(myDrawerBgView, 0, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(this.myDrawLinearLayout, 1, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void setTouchY(float y, float slideOffset) {
        myDrawerBgView.setTouchY(y, slideOffset);
        myDrawLinearLayout.setTouchY(y, slideOffset);
    }
}
