package com.mean.ui.http;

import java.io.Serializable;

public class BaseBean<T extends BaseBody>  implements Serializable {

    /**
     * body : {"result":"0","description":"登录成功","token":"6E15BE9E243343D090496CCB66848C","level":"0"}
     */
    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
