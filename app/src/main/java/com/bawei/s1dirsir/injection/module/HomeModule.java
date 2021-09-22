package com.bawei.s1dirsir.injection.module;


import com.bawei.s1dirsir.contract.HomeContract;

import dagger.Module;
import dagger.Provides;

/*
 * @ClassName HomeModule
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/21 19:40
 * @Version 1.0
 */
@Module
public class HomeModule {
    private HomeContract homeContract;

    public HomeModule(HomeContract _homeContract) {
        homeContract = _homeContract;
    }

    @Provides
    public HomeContract provideHomeView(){
        return homeContract;
    }
}
