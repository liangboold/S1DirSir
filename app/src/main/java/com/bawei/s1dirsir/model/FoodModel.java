package com.bawei.s1dirsir.model;



import com.bawei.s1dirsir.Api;
import com.bawei.s1dirsir.Bodys;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bw.mvp.model.IModel;
import com.bw.net.RetrofitFactory;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/*
 * @ClassName FoodModel
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/3 15:15
 * @Version 1.0
 */
public class FoodModel implements IModel {
    @Inject
    public FoodModel() {}

    public Observable<JsonBean> getFood() {

        return RetrofitFactory.getRetrofitFactory().createRetrofit().create(Api.class).getJson(new Bodys(0));

    }
}
