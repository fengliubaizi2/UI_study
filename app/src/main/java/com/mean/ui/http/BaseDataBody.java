package com.mean.ui.http;

public class BaseDataBody <Serializable> extends BaseBody {
    private Serializable data;
    public Serializable getData() {
        return data;
    }
    public void setData(Serializable data) {
        this.data = data;
    }
}
