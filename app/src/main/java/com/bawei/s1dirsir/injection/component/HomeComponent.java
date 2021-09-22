package com.bawei.s1dirsir.injection.component;


import com.bawei.s1dirsir.fragment.MainFragment;
import com.bawei.s1dirsir.fragment.MyFragment;
import com.bawei.s1dirsir.injection.module.HomeModule;
import com.bw.di.component.FragmentComponent;
import com.bw.di.scope.PerComponentScope;

import dagger.Component;

/*
 * @ClassName HomeComponent
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/21 19:40
 * @Version 1.0
 */
@PerComponentScope
@Component(dependencies = {FragmentComponent.class},modules = {HomeModule.class})
public interface HomeComponent {
    void injectFragment(MainFragment mainFragment);
}
