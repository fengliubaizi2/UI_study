package com.mean.ui.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mean.ui.R;
import java.util.List;

/**
 * Created by renzhenhua on 2017/9/28.
 */

public class TebleAdapter extends BaseAdapter {
    List<String> list;
    Activity context;
    public TebleAdapter(Activity context, List<String> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    Holder holder;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        final AgentMyLiveResult.MyLive entity = list.get(position);
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            holder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv.setText(list.get(position));
        return convertView;
    }
    class Holder{
        TextView tv;
    }
}
