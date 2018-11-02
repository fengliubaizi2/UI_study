package com.mean.ui.http;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author cauchy
 * @date 2018/8/6 9:31
 * @since 5.1.0
 */
public interface Api {

    @GET("top250")
    Call<Object> getTop250RXjava(@Query("start") int start, @Query("count") int count);
//    @FormUrlEncoded
//    @POST("top250")
//    Observable<MovieSubject> getTop250RXjavaPost(@Field("start") int start, @Field("count") int count);

    /***********        17 广告              **********/
    @POST("adv/list")
    Observable<BaseBean<BaseListBody<AdvBean>>> adv_list();

    @POST("adv/list")
    Observable<BaseBean<BaseListBody<AdvBean>>> adv_list(@Body RequestBody body);
    @POST("adv/list")
    Call<BaseBean<BaseListBody<AdvBean>>> adv_list2(@Body RequestBody body);
    //获取access_token和 unionId
    //  https://api.weixin.qq.com/sns/oauth2/access_token
//    https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx8d02646f9e1327a9&secret=9d4ac328e2f97054bdceb31cd81eb686&code=sdfasdfafd&grant_type=authorization_code
//    @GET("oauth2/access_token")
//    Observable<WXLogin> wxAccess_token(@Url String url);
//    @GET("oauth2/access_token")
//    Observable<WXLogin> wxAccess_token(@Url String url,@Query("appid") String appid, @Query("secret") String secret, @Query("code") String code, @Query("grant_type") String grant_type);
    //获取access_token和 unionId
    //    https://api.weixin.qq.com/sns/userinfo
//    @GET("oauth2/access_token")
//    Observable<WXUserinfo> wxLogin(@Url String url,@Query("access_token") String access_token, @Query("openid") String openid, @Query("lang") String lang);
}
