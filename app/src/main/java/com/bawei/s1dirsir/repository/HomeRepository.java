package com.bawei.s1dirsir.repository;

import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.model.HomeModel;
import com.bw.mvp.repository.BaseRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/*
 * @ClassName HomeRepository
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/21 19:47
 * @Version 1.0
 */
public class HomeRepository extends BaseRepository<HomeModel> {
    @Inject
    public HomeRepository() {
    }

    public Observable<BaseBean> getHome(){
        return model.getHome();
    }
}
