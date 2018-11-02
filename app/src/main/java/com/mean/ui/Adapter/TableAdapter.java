package com.mean.ui.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by renzhenhua on 2018/2/24.
 */

public class TableAdapter extends RecyclerView.Adapter{
    Context mContext;
    List<String> list;
    public TableAdapter() {
    }

    public TableAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
//    class MyHolder extends
}
