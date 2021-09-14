package com.example.s1dirsir;

import com.example.s1dirsir.contract.FoodContract;
import com.example.s1dirsir.model.FoodModel;

import dagger.Module;
import dagger.Provides;

/*
 * @ClassName FoodModule
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/12 19:54
 * @Version 1.0
 */
@Module
public class FoodModule {
    private FoodContract.FoodView foodView;

    public FoodModule(FoodContract.FoodView foodView) {
        this.foodView = foodView;
    }

    @Provides
    public FoodContract.FoodModel getFoodModel() {
        return new FoodModel();
    }

    @Provides
    public FoodContract.FoodView getFoodView() {
        return foodView;
    }
}
