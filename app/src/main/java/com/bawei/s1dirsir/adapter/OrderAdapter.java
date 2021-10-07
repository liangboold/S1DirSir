package com.bawei.s1dirsir.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/*
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在，只有上帝知道
 * @ClassName OrderAdapter
 * @Description TODO
 * @Author 海
 * @Date 2021/10/7 8:39
 * @Version 1.0
 */
public class OrderAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    List<String> list1;

    public OrderAdapter(@NonNull @NotNull FragmentManager fm, List<Fragment> list, List<String> list1) {
        super(fm);
        this.list = list;
        this.list1 = list1;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list1.get(position);
    }
}