package com.mean.ui.Adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by renzhenhua on 2017/10/2.
 */

public interface BaseTableAdapter {
    public int getRowCount();
    public int getColmnCount();
    public View getView(int rowPos,int colmn, View convertView, ViewGroup parent);
    public int getWidth(int column);

    public int getHeight(int row);

    public int getItemViewType(int row, int column);

    public int getViewTypeCount();
}
