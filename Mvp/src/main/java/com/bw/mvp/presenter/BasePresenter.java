package com.bw.mvp.presenter;


import com.bw.mvp.repository.BaseRepository;
import com.bw.mvp.view.IView;

import javax.inject.Inject;

/*
 * @ClassName ImgUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/16 18:39
 * @Version 1.0
 */
public abstract class BasePresenter<Repo extends BaseRepository,V extends IView> {
    @Inject
    protected Repo repository;

    @Inject
    protected V view;
}
