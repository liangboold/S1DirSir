package com.bw.mvp.presenter;


import com.bw.mvp.model.IModel;
import com.bw.mvp.view.IView;

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
