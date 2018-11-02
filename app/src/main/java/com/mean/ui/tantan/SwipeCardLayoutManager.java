package com.mean.ui.tantan;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LK on 2017/6/28.
 * 动脑学院 版权所有
 */

public class SwipeCardLayoutManager extends RecyclerView.LayoutManager {

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
//        super.onLayoutChildren(recycler, state);
        //h缓存的核心机制之一
         detachAndScrapAttachedViews(recycler);

        int itemCount = getItemCount();
        int initPosition;
//        if (itemCount < CardConfig.MAX_SHOW_COUNT) {
//            initPosition = 0;
//        } else {
//            initPosition = itemCount - CardConfig.MAX_SHOW_COUNT;
//        }
        initPosition=Math.max(0,itemCount - CardConfig.MAX_SHOW_COUNT);
//  itemCount=10  MAX_SHOW_COUNT=4   initPosition=6

        for (int position = initPosition; position < itemCount; position++) {
            //从缓存获取view
            View view = recycler.getViewForPosition(position);
            addView(view);
            measureChild(view, 0, 0);

            int widthSpace = getWidth() - getDecoratedMeasuredWidth(view);
            int heightSpace = getHeight() - getDecoratedMeasuredHeight(view);

            layoutDecorated(view,
                    widthSpace/2,
                    heightSpace/2,
                    widthSpace/2 + getDecoratedMeasuredWidth(view),
                    heightSpace/2 + getDecoratedMeasuredHeight(view));
            // 均匀的缩放和位移
//            level=10-6-1=3
//            3 2 1 0
            int level = itemCount - position - 1;
            if (level > 0) {
                view.setScaleX(1 - CardConfig.SCALE_GAP * level);
                view.setScaleY(1- CardConfig.SCALE_GAP * level);
                if (level < CardConfig.MAX_SHOW_COUNT -1) {

                    view.setTranslationY(CardConfig.TRANS_Y_GAP* level);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        view.setTranslationZ(CardConfig.TRANS_Z_GAP * (CardConfig.MAX_SHOW_COUNT-level-1));  //Z轴方向的平移
                    }
                } else {
// 最底下一层和倒数第二层相同
                    view.setTranslationY(CardConfig.TRANS_Y_GAP* (level - 1));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                        view.setTranslationZ(CardConfig.TRANS_Z_GAP * (CardConfig.MAX_SHOW_COUNT-level));  //Z轴方向的平移
                    }
                }
            }else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    view.setTranslationZ(CardConfig.TRANS_Z_GAP * (CardConfig.MAX_SHOW_COUNT-1));  //Z轴方向的平移
                }
            }
        }

    }
}
