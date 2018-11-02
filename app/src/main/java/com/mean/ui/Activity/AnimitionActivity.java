package com.mean.ui.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.mean.ui.R;

import static java.security.AccessController.getContext;

public class AnimitionActivity extends AppCompatActivity {

    private ImageView iv;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv0;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animition);
        iv = (ImageView) findViewById(R.id.iv);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);
        iv0 = (ImageView) findViewById(R.id.iv0);
        layout = findViewById(R.id.layout);
        WindowManager wm = getWindow().getWindowManager();
        final int width = wm.getDefaultDisplay().getWidth();
        final float height = wm.getDefaultDisplay().getHeight();

        iv4.setY(height);
        final float iv_height=iv4.getHeight();
        Log.i("height",height+"");
        Log.i("height",iv_height+"");

        try {
            iv4.getClass().getMethod("setTranslationY");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        iv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator oa= ObjectAnimator.ofFloat(iv4,"translationY",900,0);
                oa.setDuration(500);
                oa.start();
                final ValueAnimator va= new ValueAnimator();
                va.setFloatValues(1f,0f);
                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float)animation.getAnimatedValue();
                        iv4.setTranslationY(value*iv4.getHeight());


                        if (value>0.5f) {
                            layout.setPivotY(height/2);
                            layout.setRotationX(15 * (1 - value));
                        }else {
                            layout.setScaleX(0.8f+value*0.4f);
                            layout.setScaleY(0.8f+value*0.4f);
                            layout.setTranslationY(height*0.1f*value);
                            layout.setPivotY(0);
                            layout.setRotationX(15 * (value));
                        }
                        layout.setAlpha(0.6f+0.4f*value);
                    }
                });
                va.setDuration(1000);
//                回弹效果
//                va.setInterpolator(new AnticipateOvershootInterpolator(0.5f));
//                va.setInterpolator(new AccelerateDecelerateInterpolator());
//                va.setInterpolator(new BounceInterpolator());
                va.start();
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                PropertyValuesHolder holder1= PropertyValuesHolder.ofFloat("alpha",0,0.5f);
                PropertyValuesHolder holder2= PropertyValuesHolder.ofFloat("scaleX",0,0.5f);
                PropertyValuesHolder holder3= PropertyValuesHolder.ofFloat("scaleY",0,0.5f);
                ObjectAnimator oa = ObjectAnimator.ofPropertyValuesHolder(iv,holder1,holder2,holder3);
                AnimatorSet as=new AnimatorSet();
                final ValueAnimator va= new ValueAnimator();
                va.setFloatValues(0f,1f);


                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float)animation.getAnimatedValue();


                        iv4.setTranslationY(value*iv4.getHeight());
                        if (value>0.5f) {
//                            layout.setPivotY(height/2);
//                            layout.setRotationX(15 * (1 - value));
//                            layout.setTranslationY(height*0.1f*(1-value));

                        }else {
//                            layout.setTranslationY(height*0.1f*(1-value));
//                            layout.setScaleX(0.8f+value*0.4f);
//                            layout.setScaleY(0.8f+value*0.4f);
//                            layout.setPivotY(0);
//                            layout.setRotationX(15 * (value));
                        }
//                        layout.setTranslationY(height*0.1f*(value));
                        layout.setPivotY(0);
                        layout.setScaleX(0.9f+value*0.1f);
                        layout.setScaleY(0.9f+value*0.1f);
                        layout.setAlpha(0.6f+0.4f*value);
                    }
                });
                va.setDuration(1000);
                va.start();
            }
        });


        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                ObjectAnimator oa = ObjectAnimator.ofFloat(iv,"translationX",0f,1000f,-1000f,0f);
                oa.setDuration(3500);
                oa.start();
                ObjectAnimator oa2 = ObjectAnimator.ofInt(iv,"backgroundColor", R.color.gray,R.color.red);
                oa2.setDuration(3500);
                oa2.start();
                */
                /*
                ObjectAnimator oa3 = ObjectAnimator.ofFloat(iv,"hehe", 0f,100f);
                oa3.setDuration(3500);
                oa3.setRepeatCount(ValueAnimator.RESTART);
                oa3.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                });
                oa3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        iv.setScaleX(value/100);
                        iv.setScaleY(value/100);
                        iv.setTranslationX(value);
                    }
                });
                oa3.start();
                */
                /*
                ValueAnimator va = ValueAnimator.ofFloat(0f,100f);
                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        iv.setScaleX(value/100);
                        iv.setScaleY(value/100);
                        iv.setTranslationX(value);
                    }
                });
                va.start();
                */
                //-------------------------
                /*
                PropertyValuesHolder holder1= PropertyValuesHolder.ofFloat("alpha",0,0.5f);
                PropertyValuesHolder holder2= PropertyValuesHolder.ofFloat("scaleX",0,0.5f);
                PropertyValuesHolder holder3= PropertyValuesHolder.ofFloat("scaleY",0,0.5f);
                ObjectAnimator oa = ObjectAnimator.ofPropertyValuesHolder(iv,holder1,holder2,holder3);

                oa.setDuration(300);
                oa.start();
                */

                ValueAnimator va = new ValueAnimator();
                va.setObjectValues(new PointF(0f, 0f));
                final PointF pointF = new PointF();
                va.setInterpolator(new AccelerateInterpolator(2f));
//                va.setInterpolator(new LinearInterpolator());
//                估值器  ----改变值
                va.setEvaluator(new TypeEvaluator<PointF>() {
                    @Override
                    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                        pointF.x = 100f * fraction * 5;
//                        pointF.y = 100f * fraction * 5;
                        pointF.y = 0.5f * 9.8f * fraction * 5 * fraction * 5 * 9;
                        return pointF;
                    }
                });
                va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        PointF point = (PointF) animation.getAnimatedValue();
                        iv.setX(point.x);
                        iv.setY(point.y);
                        iv2.setX(width-point.x-iv2.getWidth());
                        iv2.setY(point.y);

                    }
                });
                va.setDuration(2000);
                iv.setX(10);
                iv.setY(10);
                va.start();
//                va.setInterpolator();
            }
        });
    }
}
