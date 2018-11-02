package com.mean.ui.DesignModel.Decorator;

import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class TShirts extends Finery {
    @Override
    public void show() {
        Log.i(TAG,"T恤");
        component.show();
    }
}
