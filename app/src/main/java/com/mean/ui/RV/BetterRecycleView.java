package com.mean.ui.RV;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by renzhenhua on 2018/10/12.
 */

public class BetterRecycleView extends RecyclerView {

    private int touchSlop;
    private Context mContext;
    private int INVALID_POINTER = -1;
    private int scrollPointerId = INVALID_POINTER;
    private int initialTouchX;
    private int initialTouchY;

    public BetterRecycleView(Context context) {
        super(context);
    }

    public BetterRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BetterRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {

        if (e==null){
            return false;
        }


        if (e == null) {
            return false;
        }
        int action = MotionEventCompat.getActionMasked(e);
        int actionIndex = MotionEventCompat.getActionIndex(e);
        switch (action) {
            case MotionEvent.ACTION_DOWN :
                scrollPointerId = MotionEventCompat.getPointerId(e, 0);
                initialTouchX = Math.round(e.getX() + 0.5f);
                initialTouchY = Math.round(e.getY() + 0.5f);
                return super.onInterceptTouchEvent(e);
            case MotionEvent.ACTION_POINTER_DOWN:
                scrollPointerId = MotionEventCompat.getPointerId(e, actionIndex);
                initialTouchX = Math.round(MotionEventCompat.getX(e, actionIndex) + 0.5f);
                initialTouchY = Math.round(MotionEventCompat.getY(e, actionIndex) + 0.5f);
                return super.onInterceptTouchEvent(e);
            case MotionEvent.ACTION_MOVE:
                int index = MotionEventCompat.findPointerIndex(e, scrollPointerId);
                if (index < 0) {
                    return false;
                }
                int x = Math.round(MotionEventCompat.getX(e, index) + 0.5f);
                int y = Math.round(MotionEventCompat.getY(e, index) + 0.5f);
                if (getScrollState() != SCROLL_STATE_DRAGGING ) {
                    int dx = x - initialTouchX;
                    int dy = y - initialTouchY;
                    boolean startScroll = false;
                    //将斜率添加进来，这样可以减少 startScroll 为true 的机会。这个机会就会给需要这个返回值
                    if (getLayoutManager().canScrollHorizontally() && Math.abs(dx) > touchSlop &&
                            (getLayoutManager().canScrollVertically() || Math.abs(dx) > Math.abs(dy))) {
                        startScroll = true;
                    }
                    if(getLayoutManager().canScrollVertically() && Math.abs(dy) > touchSlop &&
                            (getLayoutManager().canScrollHorizontally() || Math.abs(dy) > Math.abs(dx))) {
                        startScroll = true;
                    }
                    return startScroll && super.onInterceptTouchEvent(e);
                }
                return super.onInterceptTouchEvent(e);
            default:
                return super.onInterceptTouchEvent(e);
        }
    }
}
