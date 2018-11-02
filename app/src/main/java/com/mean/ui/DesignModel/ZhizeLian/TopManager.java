package com.mean.ui.DesignModel.ZhizeLian;

import android.util.Log;

/**
 * Created by renzhenhua on 2017/10/30.
 */

public class TopManager extends ZhizeHandler{
    @Override
    public void setChuli(int request) {
        if (request>=100&&request<1000){

            Log.d("RZH","总经理处理了");
//            处理
        }else if (handler!=null){
            handler.setChuli(request);
        }
    }
}
