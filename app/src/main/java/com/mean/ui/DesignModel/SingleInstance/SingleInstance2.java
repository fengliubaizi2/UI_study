package com.mean.ui.DesignModel.SingleInstance;

/**
 * 饿汉式单例类.在类初始化时，已经自行实例化
 * Created by renzhenhua on 2017/10/30.
 */

public class SingleInstance2 {

    private SingleInstance2() {}
    private static final SingleInstance2 single = new SingleInstance2();
    //静态工厂方法
    public static SingleInstance2 getInstance() {
        return single;
    }
}
