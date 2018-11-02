package com.mean.ui.Activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mean.ui.Adapter.TebleAdapter;
import com.mean.ui.R;

import java.util.ArrayList;
import java.util.Arrays;


public class TableViewActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    ArrayList <String> list=new ArrayList<>(Arrays.asList("xxx","yyy","zzz"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_view);
        myRecyclerView =(RecyclerView)findViewById(R.id.myRecyclerView);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,
                LinearLayoutCompat.VERTICAL);
        myRecyclerView.setLayoutManager(layoutManager);
//        TebleAdapter mTableAdapter =new TebleAdapter(this,list);
        myRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        });
    }
}
