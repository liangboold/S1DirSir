package com.bw.net.api;

import com.bw.net.protocol.TokenRespEntry;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @package:com.bw.net.api
 * @fileName:TokenApi
 * @date on:2021/9/9 8:31
 * @another:HG
 * @email:1572651596@qq.com
 */
public interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    Call<TokenRespEntry>getToken(@Field("grant_type")String grant_type,@Field("username")String username,@Field("password")String password);
}
