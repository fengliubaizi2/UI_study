package com.mean.ui.DesignModel.SingleInstance;

import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/30.
 */

public class SingleInstance {

    /**
     * 懒汉模式
     * 线程不安全
     * private static SingleInstance mSingleInstance;
     * private SingleInstance(){
     * }
     * public static SingleInstance getInstance(){
     * if (mSingleInstance==null){
     * mSingleInstance=new SingleInstance();
     * }
     * return mSingleInstance;
     * }
     */
//    加同步锁
    /**
    private static SingleInstance mSingleInstance;

    private SingleInstance() {

    }

    public static synchronized SingleInstance getInstance() {
        if (mSingleInstance == null) {
            synchronized (SingleInstance.class) {
                mSingleInstance = new SingleInstance();
            }
        }
        return mSingleInstance;
    }
    */
    /**
    private static class LazyHolder {
        private static final SingleInstance INSTANCE = new SingleInstance();
    }
    private SingleInstance (){}
    public static final SingleInstance getInstance() {
        return LazyHolder.INSTANCE;
    }
    */

//    public class Singleton1 {
//        private Singleton1() {}
//        private static final Singleton1 single = new Singleton1();
//        //静态工厂方法
//        public static Singleton1 getInstance() {
//            return single;
//        }
//    }

    private String name;
//    volatile 调用数据是不备份
    private static volatile SingleInstance singleInstance=null;
    public static SingleInstance getInstance(){
        if (singleInstance==null){
            synchronized (SingleInstance.class){
                if (singleInstance==null){
                    singleInstance=new SingleInstance();
                }
            }
        }
        return singleInstance;
    }
    public void printInfo() {
        Log.d("RZH","the name is " + name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}