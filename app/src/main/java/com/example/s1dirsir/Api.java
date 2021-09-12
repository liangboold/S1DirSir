package com.example.s1dirsir;

import io.reactivex.Observable;
import retrofit2.http.GET;

/*
 * @ClassName Api
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/3 15:19
 * @Version 1.0
 */
public interface Api {
    @GET("ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<JsonBean> getJson();
}
