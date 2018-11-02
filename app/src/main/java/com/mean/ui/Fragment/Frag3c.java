package com.mean.ui.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mean.ui.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by renzhenhua on 2017/4/14.
 */
@SuppressLint("ValidFragment")
public class Frag3c extends BaseFragment {
    private RecyclerView public_rv;
    private List listData = new ArrayList<>();
    private CommonAdapter moreAdapter;
    private LinearLayoutManager linearLayoutManager;
    private SwipeRefreshLayout refreshView;
    private int num=1;
    private int color=R.color.pink;
    private ImageView banner_iv;

    public Frag3c(int color) {
        this.color = color;
    }

    @Override
    public View setContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.frag_publish_refresh, container, false);
        getScreenWidthAndHeight();
        return view;
    }

    @Override
    public void initViews(View view) {
        public_rv = (RecyclerView) view.findViewById(R.id.public_rv);
        refreshView = (SwipeRefreshLayout) view.findViewById(R.id.public_refresh);
        banner_iv =(ImageView) view.findViewById(R.id.banner_iv);
        refreshView.setColorSchemeResources(R.color.red);
        banner_iv.setBackgroundColor(getResources().getColor(color));
    }

    @Override
    public void initListeners() {
        refreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshView.setRefreshing(false);
                search = "";
                num = 1;
            }
        });
    }


    private int imageNum = 3;
    private String search = "";

    @Override
    public void initData() {
    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//        }
    }

}

