package com.mean.ui.http;

import java.io.Serializable;

/**
 * Created by renzhenhua on 2018/9/12.
 */

public class AdvBean implements Serializable {

    /**
     * advId : 2
     * image : http://fximages.oss-cn-shanghai.aliyuncs.com/timg1-11ecf53f1c719.jpg
     * type : 6
     * url : http://shengkai.xindongle.com/fengxue-app-api/articleDetail?articleId=66
     */

    private String advId;
    private String image;
    private int type;
    private String url;

    public String getAdvId() {
        return advId;
    }

    public void setAdvId(String advId) {
        this.advId = advId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
