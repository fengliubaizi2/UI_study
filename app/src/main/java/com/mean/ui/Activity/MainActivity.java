package com.mean.ui.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.mean.ui.Adapter.ListAdapter;
import com.mean.ui.Adapter.MainAdapter;
import com.mean.ui.Adapter.RvAdapter;
import com.mean.ui.DbProject.bean.User;
import com.mean.ui.DbProject.db.BaseDaoFactory;
import com.mean.ui.MyView.Art_list.MyListActivity;
import com.mean.ui.R;
import com.mean.ui.RV.qq.QQActivity;
import com.mean.ui.tantan.TantanActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list = new ArrayList<String>() {{
        add("FlowLayout流式布局/小黄人");
        add("表格布局");
        add("MD");
        add("事件传递");
        add("3D效果");
        add("属性动画");
        add("splash动画");
        add("艺术探讨Listview");
        add("抽屉导航");
        add("设计模式");
        add("数据结构");
        add("数据库框架");
        add("动画框架");
        add("广播");
        add("http");
        add("recycleview");
        add("自定义viewpager");
        add("喜马拉雅/渐变切换头部");
        add("探探");
        add("qq");
        add("云信");
    }};
    List<Class<?>> listActivity = new ArrayList<Class<?>>() {{
        add(FlowLayoutActivity.class);
        add(TableViewActivity.class);
        add(MDActivity.class);
        add(EventActivity.class);
        add(VPActivity.class);
        add(AnimitionActivity.class);
        add(SplashActivity.class);
        add(MyListActivity.class);
        add(NavigationActivity.class);
        add(DesignModelActivity.class);
        add(DataStructActivity.class);
        add(DbTestActivity.class);
        add(Animition2Activity.class);
        add(BroadcastActivity.class);
        add(HttpActivity.class);
        add(RecycleviewActivity.class);
        add(MyVPActivity.class);
        add(VPActivity2.class);
        add(TantanActivity.class);
        add(QQActivity.class);
        add(LoginActivity.class);
    }};
    private int statusHeight = -1;
    private Toolbar toolbar;
    private RecyclerView rv;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getStatusHeight();
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        View nav = findViewById(R.id.nav);
//        setToolBarStyle(toolbar,listview,Color.GREEN);

        initData();
//        setToolBarStyle(toolbar, listview, R.color.colorAccent);
    }

    private void initData() {
        adapter = new MainAdapter(this, list,listActivity);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
        toolbar.setTitle("动脑学院");
    }


    public void setToolBarStyle(Toolbar toolbar, View topView, int styleColor) {

        Window window = getWindow();
        getStatusHeight();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.orange));
            window.setNavigationBarColor(Color.WHITE);
            if (toolbar != null) {
                getStatusHeight();
                toolbar.setPadding(0, toolbar.getPaddingTop() + statusHeight, 0, 0);
//                ViewGroup.LayoutParams params = topView.getLayoutParams();
//                params.height=
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            statusHeight = getStatusHeight();

        } else {

        }


    }

    int getStatusHeight() {

        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            String heightStr = clazz.getField("status_bar_height").get(object).toString();
            int height2 = 0;
            height2 = Integer.parseInt(heightStr);
            statusHeight = getResources().getIdentifier("status_bar_height", "dimen", "android");

            //dp--px
            height2 = getResources().getDimensionPixelSize(height2);
            statusHeight = getResources().getDimensionPixelSize(statusHeight);
            Toast.makeText(this, statusHeight + "---" + height2, Toast.LENGTH_SHORT).show();

            Log.e("error", px2dip(this, statusHeight) + "---" + height2);

        } catch (Exception e) {
            Log.e("error", e.toString());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();

        }
        return statusHeight;
    }

    public static int dip2px(Context ctx, float dpValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * pxתdp
     */
    public static int px2dip(Context ctx, float pxValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
