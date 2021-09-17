package com.bawei.s1dirsir.injection.module;



import com.bawei.s1dirsir.contract.FoodContract;

import dagger.Module;
import dagger.Provides;


@Module
public class FoodModule {

    private FoodContract foodContract;

    public FoodModule(FoodContract _foodContract) {
        foodContract = _foodContract;
    }

    @Provides
    public FoodContract provideFoodView(){
        return foodContract;
    }
}
