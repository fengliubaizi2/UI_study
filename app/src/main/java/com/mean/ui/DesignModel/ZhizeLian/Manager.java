package com.mean.ui.DesignModel.ZhizeLian;

import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/30.
 */

public class Manager extends ZhizeHandler{
    @Override
    public void setChuli(int request) {
        if (request>0&&request<100){
            Log.d("RZH","经理处理了");
//            处理
        }else if (handler!=null){
            handler.setChuli(request);
        }
    }
}
