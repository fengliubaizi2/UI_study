package com.mean.ui.DesignModel.ZhizeLian;

/**
 * 职责链模式
 * Created by renzhenhua on 2017/10/30.
 */

public abstract class ZhizeHandler {
    protected ZhizeHandler handler;

    public void setHandler(ZhizeHandler handler) {
        this.handler = handler;
    }
    public abstract void setChuli(int request);
}
