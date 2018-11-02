package com.mean.ui.DesignModel;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class LocalIntentService extends IntentService {
    private static final String TAG="LocalIntentService";
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action=intent.getStringExtra("task action");
        Log.d(TAG,"receive action :"+action);
        SystemClock.sleep(3000);
        if ("com.mean.ui.Activity.TASK1".equals(action)){
            Log.d(TAG,"handle action :"+action);
        }
    }

//    public LocalIntentService() {
//        super(TAG);
//    }

    public LocalIntentService(String name) {
        super(TAG);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"destroy");
        super.onDestroy();

    }
}
