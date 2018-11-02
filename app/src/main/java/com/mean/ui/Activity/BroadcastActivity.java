package com.mean.ui.Activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mean.ui.MyBroadcast2;
import com.mean.ui.R;

import butterknife.BindView;

public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("mean.msg2");
        registerReceiver(new MyBroadcast2(),intentFilter);
    }
    @BindView(R.id.btn)Button btn;


    public void onClick(View view) {
        Intent intent=new Intent();
        intent.putExtra("msg","BroadcastActivity");
        intent.setAction("mean.msg");
        sendBroadcast(intent);
    }

    public void onClick2(View view) {

        Intent intent=new Intent();
        intent.putExtra("msg","BroadcastActivity动态注册的广播");
        intent.setAction("mean.msg2");
        sendBroadcast(intent);
    }
}
