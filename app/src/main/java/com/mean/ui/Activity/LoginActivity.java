package com.mean.ui.Activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mean.ui.MyView.Drawer.MyDrawLayout;
import com.mean.ui.R;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;

public class LoginActivity extends AppCompatActivity{
    MyDrawLayout drawer;
    ActionBarDrawerToggle toggle;
//    FloatingActionButton fab;
//    private Toolbar toolbar;
    public static String TAG = "RZh";
//    private MyDrawerBgView mDrawerBgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        doLogin();

    }
    public void doLogin() {
        LoginInfo info = new LoginInfo("1112","fc84d75d7f208aaf5fdab96e9c79abe6"); // config...
        RequestCallback<LoginInfo> callback =
                new RequestCallback<LoginInfo>() {
                    @Override
                    public void onSuccess(LoginInfo param) {
                        Log.i(TAG,param.getToken());
                        Log.i(TAG,"ok");
                    }

                    @Override
                    public void onFailed(int code) {
                        Log.i(TAG,code+"");

                    }

                    @Override
                    public void onException(Throwable exception) {
                        Log.i(TAG,exception.getMessage());

                    }
                    // 可以在此保存LoginInfo到本地，下次启动APP做自动登录用
                };
        NIMClient.getService(AuthService.class).login(info).setCallback(callback);
    }
}
