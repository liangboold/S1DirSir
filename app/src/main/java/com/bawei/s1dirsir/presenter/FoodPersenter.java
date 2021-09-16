package com.bawei.s1dirsir.presenter;


import com.bw.mvp.presenter.BasePresenter;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/*
 * @ClassName FoodPersenter
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/3 15:21
 * @Version 1.0
 */
public class FoodPersenter extends BasePresenter<FoodContract.FoodModel, FoodContract.FoodView> {
    private Disposable disposable;
    @Inject
    public FoodPersenter(FoodContract.FoodModel foodModel, FoodContract.FoodView foodView) {
        super(foodModel, foodView);
    }

    public void initFood(){
        model.getFood(new Observer<JsonBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(@NonNull JsonBean jsonBean) {
                view.showFood(jsonBean);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void Destory() {
        super.Destory();
        if (disposable != null){
            disposable.dispose();
            disposable = null;
        }
    }
}
