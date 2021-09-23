package com.bawei.s1dirsir.presenter;


import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.repository.FoodRepository;
import com.bw.mvp.presenter.BasePresenter;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/*
 * @ClassName FoodPersenter
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/3 15:21
 * @Version 1.0
 */
public class FoodPersenter extends BasePresenter<FoodRepository, FoodContract> {

    @Inject
    public FoodPersenter() {
    }

    public void initFood(int parentid){
        repository.getFood(parentid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull JsonBean jsonBean) {
                        view.foodSuccess(jsonBean);
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

    public void initClass(int parentid){
        repository.getClass(parentid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull JsonBean jsonBean) {
                        view.classSuccess(jsonBean);
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

    public void initClassThere(int parentid){
        repository.getThere(parentid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull JsonBean jsonBean) {
                        view.thereSuccess(jsonBean);
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

    public void initPaitrculars(){
        repository.getPaitrculars()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BaseBean baseBean) {
                        view.paitrcularsSuccess(baseBean);
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
