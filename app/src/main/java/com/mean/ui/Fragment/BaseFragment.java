package com.mean.ui.Fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by renzhenhua on 2016/6/29.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener  {
    public boolean isVisible = false;
    public Activity mContext;
    public boolean isPrepared = true;
    public boolean isFirst = true;
    /**屏幕的宽高*/
    protected int mScreenWidth;
    protected int mScreenHeight;
    BaseFragment that;
    View rootView;
    public void getScreenWidthAndHeight(){
        DisplayMetrics metric = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
        mScreenWidth = metric.widthPixels;
        mScreenHeight = metric.heightPixels;
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
// TODO Auto-generated method stub
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    public boolean isLogin = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(rootView == null){
//            rootView = inflater.inflate(provideContentViewId(), container, false);
//            ButterKnife.bind(this, rootView);
//            initView(rootView);
            rootView = setContentView(inflater, container);
            that=this;
            mContext = getActivity();
            isPrepared = true;
            initViews(rootView);
            initData();
            initListeners();
        }
        return rootView;

    }

    /**
     * 可见时执行
     */
    public void onVisible() {
        if (isFirst && isPrepared) {
            isFirst = false;
        }
    }

    /**
     * 不可见时执行
     */
    public void onInvisible() {

    }

    /**
     * 设置布局文件
     */
    public abstract View setContentView(LayoutInflater inflater, ViewGroup container);

//    public abstract int getViewId();

    /**
     * 初始化布局文件中的控件
     */
    public abstract void initViews(View view);

    /**
     * 初始化控件的监听
     */
    public abstract void initListeners();

    /**
     * 进行数据初始化
     */
    public abstract void initData();


    public void myStartIntent(Activity context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }


    public void myStartIntent(Activity context, Class<?> cls, int ANHAO) {
        Intent intent = new Intent(context, cls);
        context.startActivityForResult(intent, ANHAO);
    }

    public void myStartIntent(Activity context, Class<?> cls, int ANHAO, String msg) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("result", msg);
        context.startActivityForResult(intent, ANHAO);
    }

    public void myStartIntent(Activity context, Class<?> cls, int ANHAO, Serializable result) {
        Intent intent = new Intent(context, cls);
        Bundle bundle = new Bundle();
        bundle.putSerializable("result", result);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, ANHAO);
    }

    public void myStartIntent(Activity context, Class<?> cls, int ANHAO, Serializable result, ArrayList list) {
        Intent intent = new Intent(context, cls);
        Bundle bundle = new Bundle();
        bundle.putSerializable("result", result);
        bundle.putParcelableArrayList("list", list);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, ANHAO);
    }

    public void myStartIntent(Activity context, Class<?> cls, int ANHAO, Serializable result, String parentActivity) {
        Intent intent = new Intent(context, cls);
        Bundle bundle = new Bundle();
        bundle.putSerializable("result", result);
        bundle.putString("Activity", parentActivity);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, ANHAO);
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
