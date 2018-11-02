package com.mean.ui;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/27.
 */

public class FirstService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 首次创建服务时，系统将调用此方法来执行一次性设置程序（在调用 onStartCommand() 或 onBind() 之前）。
     * 如果服务已在运行，则不会调用此方法。该方法只被调用一次
     */
    @Override
    public void onCreate() {
        Log.d("service","id="+Thread.currentThread().getId());
        super.onCreate();
    }

    /**
     * 每次通过startService()方法启动Service时都会被回调。
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service","onStartCommand"+Thread.currentThread().getId());
        return super.onStartCommand(intent, flags, startId);
    }
//    START_STICKY 如果返回START_STICKY  当服务被因为内存不足被杀死后，过一段时间，内存充足时会再次尝试启动service

//    public @StartResult int onStartCommand(Intent intent, @StartArgFlags int flags, int startId) {
//        onStart(intent, startId);
//        return mStartCompatibility ? START_STICKY_COMPATIBILITY : START_STICKY;
//    }
    /**
     * 服务销毁时的回调
     */
    @Override
    public void onDestroy() {
        Log.d("service","onDestroy"+Thread.currentThread().getId());
        super.onDestroy();
    }
}
