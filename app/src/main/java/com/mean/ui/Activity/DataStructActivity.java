package com.mean.ui.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.mean.ui.DataStruct.LinkList;
import com.mean.ui.R;

public class DataStructActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_struct);
        LinkList<Integer> linkList = new LinkList<>();
//        linkList.add(0,77);
        linkList.add(1);
        linkList.add(23);
        linkList.add(3);
        linkList.add(31);
        linkList.add(5);
//        linkList.add(0,99);
        Log.i("99", "--" + linkList.size);
        linkList.remove(0);
        for (int i = 0; i < linkList.size; i++) {
            Log.i("99", i + "--" + linkList.get(i));
        }
        linkList.remove(3);
        Log.i("99", "--" + linkList.size);

        for (int i = 0; i < linkList.size; i++) {
            Log.i("99", i + "--" + linkList.get(i));
        }
        linkList.remove(2);
        Log.i("99", "--" + linkList.size);

        for (int i = 0; i < linkList.size; i++) {
            Log.i("99", i + "--" + linkList.get(i));
        }
    }

}
