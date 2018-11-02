package com.mean.ui.http;

import android.content.Context;
import com.google.gson.Gson;
import com.mean.ui.App;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;
import rx.functions.Func1;

public class ApiLoader extends ObjectLoader {
    private Context mContext;
    private Api mApi;

    public ApiLoader() {
        this.mContext = App.getContext();
        mApi = RetrofitServiceManager.getInstance().create(Api.class);
    }

    public RequestBody mapToRequestBody() {
        Map<String, Object> result = new HashMap();
        Map<String, Object> head = new HashMap();
        head.put("udid", "dsfasd");
        head.put("token", "dsfasd");
        result.put("head", head);
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(result).toString());
    }

    /**
     * @param head
     * @param body
     * @return
     */
    public RequestBody mapToRequestBody
    (Map<String, Object> head, Map<String, Object> body) {
        Map<String, Object> result = new HashMap();
        head.put("udid", "00000000-2352-d09f-ffff-fffff4d3cffe");
        head.put("token", "E6DCDF339A4C4D75B7F695B73E33BD");
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(result).toString());
    }

    public RequestBody mapToRequestBody(Map<String, Object> head, Map<String, Object> query, Map<String, Object> body) {
        Map<String, Object> result = new HashMap();
        result.put("head", head);
        result.put("query", query);
        result.put("body", body);
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(result).toString());
    }

    public RequestBody mapToRequestBody(Map<String, Object> body) {
        Map<String, Object> head = new HashMap();
        head.put("udid", "00000000-2352-d09f-ffff-fffff4d3cffe");
        head.put("token", "E6DCDF339A4C4D75B7F695B73E33BD");
        Map<String, Object> result = new HashMap();
        result.put("head", head);
        result.put("body", body);
        String bodyStr = new Gson().toJson(result).toString();
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), bodyStr);
    }

    public static final String ABOUT_US = "https://www.baidu.com/";
}
