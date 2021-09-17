package com.bawei.s1dirsir.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @package:com.example.s1dirsir.adapter
 * @fileName:FragmentAdapter
 * @date on:2021/9/13 20:18
 * @another:HG
 * @email:1572651596@qq.com
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior,ArrayList<Fragment>list) {
        super(fm, behavior);
        this.list = list;
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
}
