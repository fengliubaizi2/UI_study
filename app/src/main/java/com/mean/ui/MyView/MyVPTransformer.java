package com.mean.ui.MyView;

import android.animation.ObjectAnimator;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.mean.ui.R;

/**
 * Created by renzhenhua on 2017/10/10.
 */

public class MyVPTransformer implements ViewPager.PageTransformer {
    private String TAG="RZH";

    @Override
    public void transformPage(View view, float pos) {
//        Log.i(TAG,pos+"");
//        view.setScaleX(Math.max(0.9f,1-Math.abs(pos)));
//        view.setScaleY(Math.max(0.9f,1-Math.abs(pos)));
////        效果
//        view.setScaleX(1-Math.abs(pos));
//        view.setScaleY(1-Math.abs(pos));

//        ViewGroup parent=(ViewGroup)view.findViewById(R.id.parent);
//        for (int i=0;i<parent.getChildCount();i++){
//            View child=parent.getChildAt(i);
//            float random=(float) Math.random()*3;
//            if(view.getTag()==null){
//                view.setTag(random);
//            }else {
//                random=(float)view.getTag();
//            }
//            child.setTranslationX(view.getWidth()*pos*random);
////            child.setTranslationX(view.getWidth()*pos);
//        }

//        3D翻转效果
        view.setPivotX(pos<0f?view.getWidth():0);
        view.setPivotY(view.getHeight()*0.5f);
        view.setRotationY(pos*90f);
//        view.setPivotX(view.getWidth()*0.5f);
//        view.setPivotY(view.getHeight()*0.5f);
//        view.setRotationY(-pos*30f);
    }
}
