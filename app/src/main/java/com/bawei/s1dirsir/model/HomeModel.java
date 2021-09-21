package com.bawei.s1dirsir.model;

import com.bawei.s1dirsir.Api;
import com.bawei.s1dirsir.Bodys;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bw.mvp.model.IModel;
import com.bw.net.RetrofitFactory;

import javax.inject.Inject;

import io.reactivex.Observable;

/*
 * @ClassName HomeModel
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/21 19:43
 * @Version 1.0
 */
public class HomeModel implements IModel {
    @Inject
    public HomeModel() {
    }

    public Observable<BaseBean> getHome(){
        return  RetrofitFactory.getRetrofitFactory().createRetrofit().create(Api.class).getHome(new Bodys(0));
    }
}
