package com.mean.ui.Activity;

import android.animation.ArgbEvaluator;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mean.ui.Fragment.MyFragment;
import com.mean.ui.MyView.MyVPTransformer;
import com.mean.ui.R;

import butterknife.ButterKnife;

public class VPActivity extends AppCompatActivity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    ViewPager vp;
    int[] layoutIds = {
            R.layout.frag_1,
            R.layout.frag_2,
            R.layout.frag_3,
//            R.layout.frag_4,
//            R.layout.frag_1,
//            R.layout.frag_2,
//            R.layout.frag_3,
            R.layout.frag_4

    };
    private Toolbar toolbar;
    private TabLayout mTabLayout;
    private MyVPAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setPageTransformer(true, new MyVPTransformer());
        mAdapter = new MyVPAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViewPager();
        InitTabLayout();


    }

    private void initViewPager() {
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                ArgbEvaluator evaluator = new ArgbEvaluator();
                if (position == 0) {
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.tab_blue));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.tab_blue));
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_green), getResources().getColor(R.color.tab_blue));
                    mTabLayout.setBackgroundColor(evaluate);
                    toolbar.setBackgroundColor(evaluate);
                }
                if (0 < position && position < 1) {
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.tab_blue));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.tab_blue));
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_blue), getResources().getColor(R.color.tab_green));
                    mTabLayout.setBackgroundColor(evaluate);
                    toolbar.setBackgroundColor(evaluate);
                }

                if (position == 1) {
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.tab_purple));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.tab_purple));
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_blue), getResources().getColor(R.color.tab_purple));
                    mTabLayout.setBackgroundColor(evaluate);
                    toolbar.setBackgroundColor(evaluate);
                }

                if (1 < position && position < 2) {
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.tab_purple));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.tab_purple));
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_purple), getResources().getColor(R.color.tab_blue));
                    mTabLayout.setBackgroundColor(evaluate);
                    toolbar.setBackgroundColor(evaluate);
                }


                if (position == 2) {
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.tab_pink));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.tab_pink));
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_purple), getResources().getColor(R.color.tab_pink));
                    mTabLayout.setBackgroundColor(evaluate);
                    toolbar.setBackgroundColor(evaluate);
                }

                if (2 < position && position < 3) {
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.tab_pink));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.tab_pink));
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_pink), getResources().getColor(R.color.tab_purple));
                    mTabLayout.setBackgroundColor(evaluate);
                    toolbar.setBackgroundColor(evaluate);
                }

                if (position == 3) {
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.tab_brown));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.tab_brown));
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_pink), getResources().getColor(R.color.tab_brown));
                    mTabLayout.setBackgroundColor(evaluate);
                    toolbar.setBackgroundColor(evaluate);
                }

                if (3 < position && position < 4) {
                    mTabLayout.setBackgroundColor(getResources().getColor(R.color.tab_brown));
                    toolbar.setBackgroundColor(getResources().getColor(R.color.tab_brown));
                    int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_brown), getResources().getColor(R.color.tab_pink));
                    mTabLayout.setBackgroundColor(evaluate);
                    toolbar.setBackgroundColor(evaluate);
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

    private void InitTabLayout() {
        mTabLayout = (TabLayout) findViewById(R.id.tl);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mTabLayout.setupWithViewPager(vp);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
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


        @Override
        public MyFragment getItem(int position) {
            MyFragment f = new MyFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("layoutId", layoutIds[position]);
            f.setArguments(bundle);
            return f;
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
