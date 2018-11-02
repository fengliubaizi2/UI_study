package com.mean.ui.RV;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renzhenhua on 2018/10/11.
 */

public class HeadFootAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private RecyclerView.Adapter mAdapter;
    private List<View> mHeadViewList = new ArrayList<>();
    private List<View> mFootViewList = new ArrayList<>();

    public HeadFootAdapter(RecyclerView.Adapter mAdapter, List<View> headViewList, List<View> footViewList) {

        this.mAdapter = mAdapter;
        if (mHeadViewList == null) {
            mHeadViewList = new ArrayList<>();
        } else {
            mHeadViewList = headViewList;
        }
        if (mFootViewList == null) {
            mFootViewList = new ArrayList<>();
        } else {
            mFootViewList = footViewList;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == RecyclerView.INVALID_TYPE) {
            return ViewHolder.createViewHolder(parent.getContext(), mHeadViewList.get(0));
        } else if (viewType == RecyclerView.INVALID_TYPE - 1) {
            return ViewHolder.createViewHolder(parent.getContext(), mFootViewList.get(0));
        }
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == RecyclerView.INVALID_TYPE) {
            return;
        } else if (viewType == RecyclerView.INVALID_TYPE - 1) {
            return;
        } else {
            mAdapter.onBindViewHolder(holder, position - mHeadViewList.size());
        }
    }

    @Override
    public int getItemViewType(int position) {
        int numHeaders = mHeadViewList.size();
        if (numHeaders > position) {
            return RecyclerView.INVALID_TYPE;
        }
        int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getItemCount();
            if (adapterCount > adjPosition) {
                return mAdapter.getItemViewType(adjPosition);
            }
        }
        return RecyclerView.INVALID_TYPE - 1;

    }

    @Override
    public int getItemCount() {
        return mAdapter!=null?mAdapter.getItemCount()+mHeadViewList.size()+mFootViewList.size():mHeadViewList.size()+mFootViewList.size();
    }
}
