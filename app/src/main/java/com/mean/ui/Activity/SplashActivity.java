package com.mean.ui.Activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.mean.ui.MyView.ContentView;
import com.mean.ui.MyView.SplashView;
import com.mean.ui.R;

public class SplashActivity extends AppCompatActivity {

    private FrameLayout mainView;
    private SplashView splashView;
    private ContentView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
        mainView =new FrameLayout(this);
        splashView =new SplashView(this);
        contentView =new ContentView(this);
        getWindow().getWindowManager().getDefaultDisplay().getWidth();
        mainView.addView(splashView);
        mainView.addView(contentView);
        splashView.setBackgroundColor(Color.WHITE);
        contentView.setVisibility(View.INVISIBLE);
        splashView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator oa=ObjectAnimator.ofFloat(splashView,"startA",0,(float) Math.PI*2f);
                oa.setDuration(1500);
                ObjectAnimator oa2 =ObjectAnimator.ofFloat(splashView,"circle_r",100f,150f,0f);
                oa2.setStartDelay(1500);
                oa2.setDuration(1500);
                oa2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        if((float)animation.getAnimatedValue()==0){
                            contentView.setVisibility(View.VISIBLE);
//                            splashView.setVisibility(View.GONE);
                        }
                    }
                });
                final float height=getWindow().getWindowManager().getDefaultDisplay().getHeight();
                ObjectAnimator oa3 =ObjectAnimator.ofFloat(contentView,"Radius",0,500,2000);
                oa3.setStartDelay(2990);
                oa3.setDuration(1500);
//                oa3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        if((float)animation.getAnimatedValue()==height-1){
//                            contentView.setVisibility(View.VISIBLE);
////                            contentView.setBackgroundColor(Color.RED);
//                        }
//                    }
//                });
                AnimatorSet set = new AnimatorSet();
                set.playTogether(oa,oa2,oa3);
                set.start();
            }
        });
        setContentView(mainView);
    }
}
