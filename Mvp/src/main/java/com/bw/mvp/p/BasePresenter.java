package com.bw.mvp.p;


import com.bw.mvp.m.IModel;
import com.bw.mvp.v.IView;

import javax.inject.Inject;

public class BasePresenter<M extends IModel,V extends IView> implements IPresenter {
    protected M model;
    protected V view;

    @Inject
    public BasePresenter(M model, V view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void Destory() {
        if (model != null){
            model.Destory();
            model = null;
        }
        if (view != null){
            view = null;
        }
    }
}
