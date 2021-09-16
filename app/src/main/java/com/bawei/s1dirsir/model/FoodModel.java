package com.bawei.s1dirsir.model;



import com.bawei.s1dirsir.Api;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bw.mvp.model.BaseModel;
import com.bw.net.RetrofitFactory;

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
public class FoodModel extends BaseModel implements FoodContract.FoodModel {
    @Override
    public void getFood(Observer<JsonBean> observer) {
        RetrofitFactory.getRetrofitFactory().createRetrofit().create(Api.class)
                .getJson()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
