package com.mean.ui.Activity;

import android.animation.ArgbEvaluator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mean.ui.Fragment.Frag3c;
import com.mean.ui.Fragment.MyFragment;
import com.mean.ui.MyView.MyVPTransformer;
import com.mean.ui.R;

import butterknife.ButterKnife;

public class VPActivity2 extends AppCompatActivity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    ViewPager vp;
    int[] layoutIds = {
            R.layout.frag_0,
            R.layout.frag_2,
            R.layout.frag_3,
            R.layout.frag_4
    };
    int[] colors = {
            R.color.tab_green,
            R.color.tab_blue,
            R.color.tab_purple,
            R.color.tab_pink,
            R.color.red,
    };
    private TabLayout mTabLayout;
    private MyVPAdapter mAdapter;
    private ImageView vp_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp2);
        ButterKnife.bind(this);
        vp = (ViewPager) findViewById(R.id.vp_vp);
        vp_iv = (ImageView) findViewById(R.id.vp_iv);
//        vp.setPageTransformer(true, new MyVPTransformer());
        mAdapter = new MyVPAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tl);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mTabLayout.setupWithViewPager(vp);
        initViewPager();
    }

    private void initViewPager() {
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                ArgbEvaluator evaluator = new ArgbEvaluator();
                if (position == 0) {
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_green), getResources().getColor(R.color.tab_blue));
                    vp_iv.setBackgroundColor(evaluate);
//                    mTabLayout.setBackgroundColor(evaluate);
                }
                if (0 < position && position < 1) {
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_blue), getResources().getColor(R.color.tab_green));
                    vp_iv.setBackgroundColor(evaluate);
//                    mTabLayout.setBackgroundColor(evaluate);
                }

                if (position == 1) {
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_blue), getResources().getColor(R.color.tab_purple));
                    vp_iv.setBackgroundColor(evaluate);
//                    mTabLayout.setBackgroundColor(evaluate);
                }

                if (1 < position && position < 2) {
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_purple), getResources().getColor(R.color.tab_blue));
                    vp_iv.setBackgroundColor(evaluate);
//                    mTabLayout.setBackgroundColor(evaluate);
                }


                if (position == 2) {
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_purple), getResources().getColor(R.color.tab_pink));
                    vp_iv.setBackgroundColor(evaluate);
//                    mTabLayout.setBackgroundColor(evaluate);
                }

                if (2 < position && position < 3) {
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_pink), getResources().getColor(R.color.tab_purple));
                    vp_iv.setBackgroundColor(evaluate);
//                    mTabLayout.setBackgroundColor(evaluate);
                }

                if (position == 3) {
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_pink), getResources().getColor(R.color.tab_brown));
                    vp_iv.setBackgroundColor(evaluate);
//                    mTabLayout.setBackgroundColor(evaluate);
                }

                if (3 < position && position < 4) {
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_brown), getResources().getColor(R.color.tab_pink));
                    vp_iv.setBackgroundColor(evaluate);
//                    mTabLayout.setBackgroundColor(evaluate);
                }
            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class MyState extends FragmentStatePagerAdapter {
        public MyState(FragmentManager fm) {
            super(fm);
        }

        @Override
        public MyFragment getItem(int position) {
            MyFragment f = new MyFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("layoutId", layoutIds[position]);
            f.setArguments(bundle);
            return f;
        }

        @Override
        public int getCount() {
            return layoutIds.length;
        }
    }

    class MyVPAdapter extends FragmentPagerAdapter {

        public MyVPAdapter(FragmentManager fm) {
            super(fm);
        }


//        @Override
//        public MyFragment getItem(int position) {
//
//            if (position==0){
//                return new Frag3c();
//            }
//            MyFragment f = new MyFragment();
//            Bundle bundle = new Bundle();
//            bundle.putInt("layoutId", layoutIds[position]);
//            f.setArguments(bundle);
//            return f;
//        }

        @Override
        public Fragment getItem(int position) {
            return new Frag3c(colors[position]);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) return "标题1";
            else if (position == 1) return "标题2";
            else if (position == 2) return "标题3";
            else if (position == 3) return "标题4";
            else return "其它";
        }

        @Override
        public int getCount() {
            return layoutIds.length;
        }
    }
}
