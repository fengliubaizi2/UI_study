package com.mean.ui.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mean.ui.MyView.CircleProgressBar;
import com.mean.ui.MyView.FlowLayout;
import com.mean.ui.MyView.MinionView;
import com.mean.ui.R;


/**
 * Created by renzhenhua on 2017/9/28.
 */

public class FlowLayoutActivity extends AppCompatActivity {

    private CircleProgressBar mProgressbar;

    private int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        FlowLayout flowLayout= (FlowLayout) findViewById(R.id.flowLayout);
        flowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int index, View view) {
                Toast.makeText(getApplicationContext(),"点击"+index,Toast.LENGTH_SHORT).show();
            }
        });
        MinionView minion=(MinionView)findViewById(R.id.minion);

        mProgressbar = (CircleProgressBar) findViewById(R.id.progressbar);

        mProgressbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progress <= 100){
                            progress += 2;
                            mProgressbar.setProgress(progress);

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();

            }
        });

    }
}
