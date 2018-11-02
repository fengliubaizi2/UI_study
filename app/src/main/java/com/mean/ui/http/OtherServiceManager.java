package com.mean.ui.http;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author cauchy
 * @date 2018/8/6 11:02
 * @since 5.1.0
 */
public class OtherServiceManager extends ObjectLoader {
    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private Retrofit mRetrofit;
    private Api mApi;

    public OtherServiceManager(String url) {
//                    String url = "https://api.weixin.qq.com/sns/";
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间
        TokenInterceptor tokenInterceptor = new TokenInterceptor();
        builder.addInterceptor(tokenInterceptor);
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(url)
                .build();
        mApi = mRetrofit.create(Api.class);

    }

    //  String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + Constants.WX_APP_ID+ "&secret="
    // + Constants.SECRET + "&code=" + code + "&grant_type=authorization_code";

//    public Observable<WXLogin> wxAccess_token( String code) {
//        return observe(mApi.wxAccess_token(Constants.WX_APP_ID, Constants.SECRET, code, "authorization_code")).map(new Func1<WXLogin, WXLogin>() {
//            @Override
//            public WXLogin call(WXLogin wxLogin) {
//                return wxLogin;
//            }
//        });
//    }
//    public Observable<WXUserinfo> wxLogin(String access_token, String openid) {
//        return observe(mApi.wxLogin( access_token,  openid, "zh_CN")).map(new Func1<WXUserinfo, WXUserinfo>() {
//            @Override
//            public WXUserinfo call(WXUserinfo wxUserinfo) {
//                return wxUserinfo;
//            }
//        });
//    }



//    OtherServiceManager otherServiceManager = new OtherServiceManager(Constants.BASE_WX_URL);
//        otherServiceManager.wxAccess_token("dsfasdf")
//                .subscribe(new Action1<WXLogin>() {
//        @Override
//        public void call(WXLogin wxLogin) {
//            Log.i(TAG + "333", wxLogin.getErrmsg());
//        }
//    }, new Action1<Throwable>() {
//        @Override
//        public void call(Throwable throwable) {
//            Log.i(TAG + "333", throwable.toString());
//        }
//    });
}
