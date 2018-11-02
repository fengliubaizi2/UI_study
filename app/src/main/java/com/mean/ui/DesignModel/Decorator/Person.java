package com.mean.ui.DesignModel.Decorator;

import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public  abstract class Person {
    private String name;
    public String TAG ="RZH";
    public Person(){

    }

    public Person(String name) {
        this.name = name;
    }
    public abstract void show();
}
