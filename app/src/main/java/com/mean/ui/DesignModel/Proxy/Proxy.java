package com.mean.ui.DesignModel.Proxy;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class Proxy implements GiveGift {
    Pursuit pursuit;
    public Proxy(SchoolGirl mm) {
        pursuit=new Pursuit(mm);
    }

    @Override
    public void giveFlower() {
        pursuit.giveFlower();
    }

    @Override
    public void giveApple() {
        pursuit.giveApple();
    }
}
