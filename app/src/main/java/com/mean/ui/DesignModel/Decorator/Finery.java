package com.mean.ui.DesignModel.Decorator;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class Finery extends Person {
    protected Person component;
    public void decorate(Person component){
        this.component=component;
    }

    @Override
    public void show() {
        if(component!=null){
            component.show();
        }
    }
}
