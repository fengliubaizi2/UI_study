package com.mean.ui.Activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.Toast;
import com.mean.ui.BindService;
import com.mean.ui.DesignModel.Decorator.Finery;
import com.mean.ui.DesignModel.Decorator.Person;
import com.mean.ui.DesignModel.Decorator.TShirts;
import com.mean.ui.DesignModel.DownloadIntentService;
import com.mean.ui.DesignModel.LocalIntentService;
import com.mean.ui.DesignModel.Test;
import com.mean.ui.FirstService;
import com.mean.ui.R;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ConstantConditions")
public class DesignModelActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private Button stop_service;
    private Button start_service;
    private Button bind_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_model);
        Vector<String> vector=new Vector<>();
        Stack<String> stack=new Stack<>();
        HashMap<Integer,String> map=new HashMap<>();
//        Man person=new Finery();
//        person.show();
//        TShirts tShirts=new TShirts();
//        tShirts.decorate(person);
//        tShirts.show();
//        Test.testService(this);
        btn = (Button) findViewById(R.id.btn);
        start_service = (Button) findViewById(R.id.start_service);
        stop_service = (Button) findViewById(R.id.stop_service);
        bind_service = (Button) findViewById(R.id.bind_service);
        Log.d("service","Mian Thread id="+Thread.currentThread().getId());

        bind_service.setOnClickListener(this);
        start_service.setOnClickListener(this);
        stop_service.setOnClickListener(this);
        Test.testInstance(this);
        Test.testZhize(this);
        try {
//            方式1
            Man man=new Man();
            Class<?> class1=man.getClass();

//           方式2
            Class<?> class2=Class.forName("com.mean.ui.Activity.Man");
            Man man1=null;
            man1 = (Man) class2.newInstance();//只能调用无参构造方法
            man1.setName("00001");
            Log.i("9999", man1.getName());
//            Method method2=class2.getMethod("com.mean.ui.Activity.Man.printName",class2,Void.TYPE);
            Method method2=class2.getMethod("com.mean.ui.Activity.Man.printName");
            method2.invoke(class2);
//            Log.i("9999", man1.getName());
//           方式3
            Class<?> class3=Person.class;
        } catch (Exception e) {
            e.printStackTrace();
        }

        Executors.newFixedThreadPool(3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DesignModelActivity.this, "0000", Toast.LENGTH_SHORT).show();
                List<String> list = new ArrayList<>();
                list.add("Android通过startService播放背景音乐;http://www.jb51.net/article/76479.htm");
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    String str = (String) iterator.next();
                    String[] splits = str.split(";");
                    String name = splits[0];
                    String url = splits[1];
                    Intent intent = new Intent(DesignModelActivity.this, DownloadIntentService.class);
                    intent.putExtra("name", name);
                    intent.putExtra("url", url);
                    //启动IntentService
                    startService(intent);
                }
            }
        });
        Runnable command = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
                String date = sDateFormat.format(new java.util.Date());

                Log.i("9999", date);
                SystemClock.sleep(2000);
            }
        };
        ExecutorService fix = Executors.newFixedThreadPool(4);
        fix.execute(command);
        ExecutorService cached = Executors.newCachedThreadPool();
        cached.execute(command);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.schedule(command, 2000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(command, 10, 1000, TimeUnit.MILLISECONDS);
        ExecutorService single = Executors.newSingleThreadExecutor();
        single.execute(command);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), FirstService.class);
        switch (v.getId()) {
            case R.id.start_service:
                startService(intent);
                break;
            case R.id.stop_service:
                stopService(intent);
                break;
            case R.id.bind_service:
                Intent intent2=new Intent(getApplicationContext(),BindService.class);
                bindService(intent2,connection, Context.BIND_AUTO_CREATE);
                break;
            default:
                break;
        }
    }
    BindService bindService;
    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bindService = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bindService = ((BindService.LocalBinder)service).getService();
            Log.d("service","Service连接成功");
            // 执行Service内部自己的方法
            bindService.excute();
        }
    };

    protected void onDestroy() {
        super.onDestroy();
        Log.d("service","onDestroy");
        unbindService(connection);
    }
}
