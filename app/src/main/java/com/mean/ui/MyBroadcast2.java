package com.mean.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/28.
 */

public class MyBroadcast2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("mean:动态注册",intent.getStringExtra("msg"));

    }
}
