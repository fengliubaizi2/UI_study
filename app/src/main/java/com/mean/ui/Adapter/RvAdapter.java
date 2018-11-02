package com.mean.ui.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mean.ui.R;

import java.util.List;

/**
 * Created by renzhenhua on 2018/10/10.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvHolder> {
    List<String> list;
    Context mContext;
    private onItemOnclick onItemOnclick;

    public onItemOnclick getOnItemOnclick() {
        return onItemOnclick;
    }

    public void setOnItemOnclick(RvAdapter.onItemOnclick onItemOnclick) {
        this.onItemOnclick = onItemOnclick;
    }

    public interface onItemOnclick{
        void onClick(View v,int position);
    }
    public RvAdapter(Context mContext, List<String> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RvHolder(view);
    }

    @Override
    public void onBindViewHolder(RvHolder holder, final int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RvHolder extends RecyclerView.ViewHolder {
        private TextView tv;

        public RvHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
