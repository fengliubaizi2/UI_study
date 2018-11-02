package com.mean.ui.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.mean.ui.Constants;
import com.mean.ui.R;
import com.mean.ui.http.AdvBean;
import com.mean.ui.http.Api;
import com.mean.ui.http.BaseBean;
import com.mean.ui.http.BaseListBody;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 二级页面
 * Created by renzhenhua on 2017/4/14.
 */
public class HttpActivity extends AppCompatActivity {

    private String title = "新的标题";
    private TextView title_tv_name;
    private View title_iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }
    void initData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);

        api.adv_list2(mapToRequestBody()).enqueue(new Callback<BaseBean<BaseListBody<AdvBean>>>() {
            @Override
            public void onResponse(Call<BaseBean<BaseListBody<AdvBean>>> call, Response<BaseBean<BaseListBody<AdvBean>>> response) {
                Log.i("request",response.body().getBody().getDescription());
            }

            @Override
            public void onFailure(Call<BaseBean<BaseListBody<AdvBean>>> call, Throwable t) {

            }
        });
    }

    public RequestBody mapToRequestBody() {
        Map<String, Object> result = new HashMap();
        Map<String, Object> head = new HashMap();
        Map<String, Object> body = new HashMap();
        result.put("head", head);
        result.put("body", body);
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new Gson().toJson(result).toString());
    }
}