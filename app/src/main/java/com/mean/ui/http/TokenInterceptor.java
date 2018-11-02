package com.mean.ui.http;


import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class TokenInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Log.i("request",chain.request().url().toString());
        Response response=chain.proceed(builder.build());
        MediaType mediaType = response.body().contentType();
        String content= response.body().string();
        Log.i("response", content);
        Log.i("request-response", content);
        return response.newBuilder()
                .body(ResponseBody.create(mediaType, content))
                .build();
    }
}