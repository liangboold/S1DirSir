package com.bawei.s1dirsir.presenter;

import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.contract.HomeContract;
import com.bawei.s1dirsir.repository.HomeRepository;
import com.bw.mvp.presenter.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 * @ClassName HomePresenter
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/21 19:46
 * @Version 1.0
 */
public class HomePresenter extends BasePresenter<HomeRepository, HomeContract> {
    @Inject
    public HomePresenter() {
    }

    public void initHome(){
        repository.getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BaseBean baseBean) {
                        view.foodSuccess(baseBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.foodFailed(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
