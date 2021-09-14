package com.example.s1dirsir.contract;



import com.bw.mvp.m.IModel;
import com.bw.mvp.v.IView;
import com.example.s1dirsir.bean.JsonBean;

import io.reactivex.Observer;


/*
 * @ClassName FoodContract
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/3 15:11
 * @Version 1.0
 */
public interface FoodContract {
    interface FoodView extends IView {
        void showFood(JsonBean jsonBean);
    }
    interface FoodModel extends IModel {
        void getFood(Observer<JsonBean> observer);
    }
}
