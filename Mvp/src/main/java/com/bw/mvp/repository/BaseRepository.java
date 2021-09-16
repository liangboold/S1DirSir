package com.bw.mvp.repository;


import com.bw.mvp.model.IModel;

import javax.inject.Inject;

/*
 * @ClassName ImgUtil
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/16 19:21
 * @Version 1.0
 */
public abstract class BaseRepository<M extends IModel> {
    @Inject
    protected M model;

}
