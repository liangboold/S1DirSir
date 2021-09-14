package com.example.s1dirsir.inject;

import com.example.s1dirsir.activity.MainActivity;

import dagger.Component;

/*
 * @ClassName ActivityComment
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/12 19:58
 * @Version 1.0
 */
@Component(modules = FoodModule.class)
public interface ActivityComment {
    void inject(MainActivity mainActivity);
}
