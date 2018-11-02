package com.mean.ui.RV;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewUtils;
import android.view.View;

import static android.view.View.GONE;

/**
 * Created by renzhenhua on 2018/10/10.
 */

public class MyLine extends RecyclerView.ItemDecoration {


    @Override
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {

        final int count = parent.getChildCount();
        final boolean isLayoutRtl = true;
        for (int i = 0; i < count; i++) {
            final View child = parent.getChildAt(i);
            int mDividerWidth = child.getWidth();
            if (child != null && child.getVisibility() != GONE) {
                final LinearLayoutCompat.LayoutParams lp = (LinearLayoutCompat.LayoutParams) child.getLayoutParams();
                final int position;
                if (isLayoutRtl) {
                    position = child.getRight() + lp.rightMargin;
                } else {
                    position = child.getLeft() - lp.leftMargin - mDividerWidth;
                }
                mDivider.setBounds(0, 0, 1000, 2);
                mDivider.draw(canvas);
            }
        }
    }

    Drawable mDivider;

    public MyLine(Drawable mDivider) {
        this.mDivider = mDivider;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        onDrawOver(c, parent);
    }


    /**
     * Retrieve any offsets for the given item. Each field of <code>outRect</code> specifies
     * the number of pixels that the item view should be inset by, similar to padding or margin.
     * The default implementation sets the bounds of outRect to 0 and returns.
     * <p>
     * <p>
     * If this ItemDecoration does not affect the positioning of item views, it should set
     * all four fields of <code>outRect</code> (left, top, right, bottom) to zero
     * before returning.
     * <p>
     * <p>
     * If you need to access Adapter for additional data, you can call
     * {@link RecyclerView#getChildAdapterPosition(View)} to get the adapter position of the
     * View.
     *
     * @param outRect Rect to receive the output.
     * @param view    The child view to decorate
     * @param parent  RecyclerView this ItemDecoration is decorating
     * @param state   The current state of RecyclerView.
     */
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        getItemOffsets(outRect, ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition(),
                parent);
    }
}
