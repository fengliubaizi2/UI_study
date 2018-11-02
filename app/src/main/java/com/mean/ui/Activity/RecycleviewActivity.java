package com.mean.ui.Activity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mean.ui.Adapter.RvAdapter;
import com.mean.ui.Constants;
import com.mean.ui.R;
import com.mean.ui.RV.HeadAndFootAdapter;
import com.mean.ui.RV.HeadFootAdapter;
import com.mean.ui.RV.MyLIne2;
import com.mean.ui.RV.MyLine;
import com.mean.ui.http.AdvBean;
import com.mean.ui.http.Api;
import com.mean.ui.http.BaseBean;
import com.mean.ui.http.BaseListBody;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 二级页面
 * Created by renzhenhua on 2017/4/14.
 */
public class RecycleviewActivity extends AppCompatActivity {

    private String title = "新的标题";
    private ArrayList<String> list = new ArrayList<String>() {{
        add("商品");
        add("线路");
        add("风雪学院");
        add("社区");
        add("商品");
        add("线路");
        add("风雪学院");
        add("社区");
        add("商品");
        add("线路");
        add("风雪学院");
        add("社区");
        add("商品");
        add("线路");
        add("风雪学院");
        add("社区");
    }};
    private List<View> headList = new ArrayList<>();
    private View head;
    private View foot;
    private HeadAndFootAdapter headFootAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        head = LinearLayout.inflate(this, R.layout.head, null);
        foot = LinearLayout.inflate(this, R.layout.foot, null);

        setContentView(R.layout.activity_rv);
        ButterKnife.bind(this);
        initData();
    }

    @OnClick(R.id.rv_bt)
    public void click(View view) {
        Toast.makeText(this, "eee", Toast.LENGTH_SHORT).show();
    }

    @BindView(R.id.rv)
    RecyclerView rv;
    public RvAdapter adapter;

    void initData() {
        adapter = new RvAdapter(this, list);
//        LayoutInflater
        headList.add(head);
        headFootAdapter = new HeadAndFootAdapter(adapter);
        headFootAdapter.addHeaderView(head);
        headFootAdapter.addFootView(foot);
//        rv.setAdapter(new HeadFootAdapter(adapter, headList, headList));
        rv.setAdapter(headFootAdapter);
        rv.setLayoutManager(new GridLayoutManager(this, 3));
        rv.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.addItemDecoration(new MyLine(getResources().getDrawable(R.drawable.bg_red)));
//        rv.addItemDecoration(new MyLIne2(this,DividerItemDecoration.VERTICAL));
//        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}