package com.bawei.s1dirsir.injection.component;

import com.bawei.s1dirsir.activity.MainActivity;
import com.bawei.s1dirsir.injection.module.FoodModule;
import com.bw.di.component.ActivityComponent;
import com.bw.di.scope.PerComponentScope;

import dagger.Component;


@PerComponentScope
@Component(dependencies = {ActivityComponent.class},modules = {FoodModule.class})
public interface FoodComponent {
    void injectMainActivity(MainActivity mainActivity);
}
