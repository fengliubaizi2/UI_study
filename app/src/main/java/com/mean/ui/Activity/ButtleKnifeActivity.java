package com.mean.ui.Activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mean.ui.MyBroadcast2;
import com.mean.ui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ButtleKnifeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        ButterKnife.bind(this);

//        btn.setOnClickListener(this);
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
