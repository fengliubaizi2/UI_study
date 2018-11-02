package com.mean.ui.Activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mean.ui.MyView.ContentView;
import com.mean.ui.MyView.SplashView;
import com.mean.ui.R;

public class Animition2Activity extends AppCompatActivity {

    private FrameLayout mainView;
    private SplashView splashView;
    private ContentView contentView;
    private LottieAnimationView animator_view;
    private ImageView bg_gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        animator_view = (LottieAnimationView) findViewById(R.id.animator_view);
        animator_view.loop(true);

//        bg_gif = (ImageView) findViewById(R.id.bg_gif);次
//        Glide.with(Animition2Activity.this).load(R.drawable.bg_gif)
//                .diskCacheStrategy(DiskCacheStrategy.ALL).into(bg_gif);
    }
}