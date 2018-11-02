package com.mean.ui.DesignModel.Decorator;

import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class BigTrouser extends Finery {
    @Override
    public void show() {
        Log.i(TAG,"垮裤");
        component.show();
    }
}
