package com.mean.ui.MyView;

import android.view.View;

import java.util.Stack;

/**
 * Created by renzhenhua on 2017/10/2.
 */

public class Recycler {
    private Stack<View>[] views;

    public Recycler(int type) {
        views = new Stack[type];
        for (int i = 0; i < type; i++) {
            views[i] = new Stack<>();
        }
    }
    public void addRecycledView(View view,int type){
        views[type].push(view);
    }

    public View getRecyclerdView(int type) {
        try {
            return views[type].pop();
        } catch (Exception e) {
            return null;
        }
    }
}
