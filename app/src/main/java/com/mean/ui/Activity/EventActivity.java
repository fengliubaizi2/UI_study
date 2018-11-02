package com.mean.ui.Activity;

import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mean.ui.MyView.MyButton;
import com.mean.ui.R;

public class EventActivity extends AppCompatActivity {

    public static String TAG = "RZH";
    private MyButton myButton;
    private Button btn;
    private TextInputLayout input_layout;
    private TextInputEditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
        myButton = (MyButton) findViewById(R.id.myButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "点击");
            }
        });
        btn = (Button) findViewById(R.id.btn);
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "触摸");
                Snackbar.make(btn, "你好", Snackbar.LENGTH_SHORT)
                        .setActionTextColor(getResources().getColor(R.color.yellow))
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                            @Override
                            public void onDismissed(Snackbar transientBottomBar, int event) {
                                super.onDismissed(transientBottomBar, event);
                            }

                            @Override
                            public void onShown(Snackbar transientBottomBar) {
                                super.onShown(transientBottomBar);
                            }
                        }).show();
                return true;
            }
        });
//        AccessibilityService 辅助功能 针对残障人士  抢红包插件就是用它


        input_layout = (TextInputLayout) findViewById(R.id.input_layout);
        edit = (TextInputEditText) findViewById(R.id.edit);
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()<5){
                    input_layout.setError("长度不得小于5");
                }else {
                    input_layout.setError(null);
                }
            }
        });
    }
}
