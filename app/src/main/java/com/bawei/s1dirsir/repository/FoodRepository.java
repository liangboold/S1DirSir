package com.bawei.s1dirsir.repository;

import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bawei.s1dirsir.model.FoodModel;
import com.bw.mvp.repository.BaseRepository;

import javax.inject.Inject;

import io.reactivex.Observer;

/*
 * @ClassName FoodRepository
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/16 19:38
 * @Version 1.0
 */
public class FoodRepository extends BaseRepository<FoodModel> {
    @Inject
    public FoodRepository(){}

     public void getFood(Observer<JsonBean> observer){
        model.getFood(observer);
    }
}
