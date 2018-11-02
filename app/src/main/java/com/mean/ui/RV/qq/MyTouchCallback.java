package com.mean.ui.RV.qq;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.Log;

import java.util.Collections;
import java.util.List;

public class MyTouchCallback extends Callback {

    private static final String TAG = "ItemTouchCallback";
    RecyclerView.Adapter adapter;
    List datas;
    private Context context;

    public MyTouchCallback(RecyclerView.Adapter adapter, List datas, Context context) {
        this.adapter = adapter;
        this.datas = datas;
        this.context = context;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN|ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder target) {

        Collections.swap(datas, viewHolder.getLayoutPosition(), target.getLayoutPosition());
        adapter.notifyItemMoved(viewHolder.getLayoutPosition(),target.getLayoutPosition());
        return false;
    }

    //滑动消失的距离，当滑动大于这个值的时候会删除这个item，否则不会视为删除
    @Override
    public float getSwipeThreshold(ViewHolder viewHolder) {
        return 0.1f;
    }

    @Override
    public void onSwiped(ViewHolder viewHolder, int direction) {
        datas.remove(viewHolder.getLayoutPosition());
        adapter.notifyItemRemoved(viewHolder.getLayoutPosition());
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }
}
