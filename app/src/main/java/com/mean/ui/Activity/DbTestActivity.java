package com.mean.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mean.ui.Adapter.ListAdapter;
import com.mean.ui.DbProject.bean.User;
import com.mean.ui.DbProject.db.BaseDaoFactory;
import com.mean.ui.MyView.Art_list.MyListActivity;
import com.mean.ui.R;

import java.util.ArrayList;
import java.util.List;

public class DbTestActivity extends AppCompatActivity {
    List<String> list;
    private ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview =(ListView)findViewById(R.id.listview);
        list=new ArrayList<>();
        list.add("建表");
        listview.setAdapter(new ListAdapter(this,list));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        BaseDaoFactory.getOurInstance().getBaseDao(User.class);
                        break;
                }
            }
        });
    }
}
