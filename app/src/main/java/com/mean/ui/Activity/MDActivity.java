package com.mean.ui.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import com.mean.ui.MyView.Drawer.MyDrawLayout;
import com.mean.ui.MyView.Drawer.MyDrawerBgView;
import com.mean.ui.R;

public class MDActivity extends AppCompatActivity{
    MyDrawLayout drawer;
    ActionBarDrawerToggle toggle;
//    FloatingActionButton fab;
//    private Toolbar toolbar;
    public static String TAG = "RZh";
//    private MyDrawerBgView mDrawerBgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md);
        drawer = (MyDrawLayout) findViewById(R.id.drawer_layout);
//        drawer.addDrawerListener(drawer);
//        mDrawerBgView = (MyDrawerBgView) findViewById(R.id.mDrawerBgView);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN, Gravity.START);
//            }
//        });

    }
    void getStrusHeight(){
        try {
            Class<?> clazz=Class.forName("com.android.internal.R$dimen");
        }catch (Exception e){

        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
