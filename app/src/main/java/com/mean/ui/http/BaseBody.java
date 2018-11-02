package com.mean.ui.http;

import java.io.Serializable;

public class BaseBody implements Serializable {

    protected String result;
    protected String description;

    public String getResult() {
        return result;
    }
    public boolean getSuccess(){
        return "0".equals(result);
    }
    public boolean getChangePhone(){
        return "3".equals(result);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
