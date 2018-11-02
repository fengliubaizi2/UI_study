package com.mean.ui.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mean.ui.Activity.MainActivity;
import com.mean.ui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renzhenhua on 2018/10/10.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RvHolder> {
    List<String> list;
    List<Class<?>> listActivity;
    Activity mContext;
    public MainAdapter(Activity mContext, List<String> list, List<Class<?>> listActivity) {
        this.list = list;
        this.listActivity = listActivity;
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
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, listActivity.get(position));
                mContext.startActivity(intent);
            }
        });
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
