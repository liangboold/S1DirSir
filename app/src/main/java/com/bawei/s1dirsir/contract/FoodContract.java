package com.bawei.s1dirsir.contract;



import com.bw.mvp.model.IModel;
import com.bw.mvp.view.IView;
import com.bawei.s1dirsir.bean.JsonBean;

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
}
