package com.mean.ui.DesignModel.Proxy;

import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class Pursuit implements GiveGift {
    SchoolGirl girl;
    public Pursuit(SchoolGirl girl) {
        this.girl=girl;
    }

    @Override
    public void giveFlower() {
        Log.i(TAG,girl.name+"Pursuit--送你Flower");
    }

    @Override
    public void giveApple() {
        Log.i(TAG,girl.name+"Pursuit送你Apple");
    }
}
