package com.bawei.s1dirsir;

import com.bawei.s1dirsir.bean.JsonBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/*
 * @ClassName Api
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/3 15:19
 * @Version 1.0
 */
public interface Api {
    @POST("category/getCategory")
    Observable<JsonBean> getJson(@Body Bodys bodys);
}
