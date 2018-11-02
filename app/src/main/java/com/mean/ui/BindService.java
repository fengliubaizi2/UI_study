package com.mean.ui;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/28.
 */

public class BindService extends Service {
    private Thread thread;
    private boolean quit;
    private final static String TAG="RZH";
    private LocalBinder binder=new LocalBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service","onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    public  class LocalBinder extends Binder{
        public BindService getService(){
            return BindService.this;
        }
    }

    @Override
    public void onDestroy() {
        // 当调用者退出(即使没有调用unbindService)或者主动停止服务时会调用
        Log.d("service","onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        // 当调用者退出(即使没有调用unbindService)或者主动停止服务时会调用
        Log.d("service","调用者退出了");
        return super.onUnbind(intent);
    }

    public void excute() {
        Log.d("service","通过Binder得到Service的引用来调用Service内部的方法");
    }
}
