package com.mean.ui.Activity;

import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/29.
 */

public class Man {
    private String name;
    public Man() {
    }
    public Man(String name) {
        this.name = name;
    }

    public String getName() {
        Log.i("9999--",name);
        return name;
    }

    public void printName() {
        Log.i("9999--printName",name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
