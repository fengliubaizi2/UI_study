package com.mean.ui.http;

import java.util.List;

public class BaseListBody <Serializable> extends BaseBody {

    protected int count;
    protected List<Serializable> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Serializable> getList() {
        return list;
    }

    public void setList(List<Serializable> list) {
        this.list = list;
    }
}
