package com.mean.ui.http;

/**
 * Created by renzhenhua on 2018/9/26.
 */

public class Configor {
    private static class Holder{
        private static final Configor INSTANCE=new Configor();
    }
    public static Configor getInstance(){
        return Holder.INSTANCE;
    }
    private Configor(){

    }
}
