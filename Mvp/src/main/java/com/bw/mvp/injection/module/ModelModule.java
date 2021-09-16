package com.bw.mvp.injection.module;


import com.bw.mvp.model.IModel;

import dagger.Module;
import dagger.Provides;

/*
 * @ClassName ImgUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/16 19:09
 * @Version 1.0
 */
@Module
public class ModelModule {
    private IModel modle;
    public ModelModule(IModel _model){
        this.modle=_model;
    }

    @Provides
    public IModel provideModel(){
        return this.modle;
    }
}
