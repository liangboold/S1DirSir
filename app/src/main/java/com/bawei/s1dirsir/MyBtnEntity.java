package com.bawei.s1dirsir;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * @package:com.bawei.s1dirsir
 * @fileName:MyBtnEntity
 * @date on:2021/9/22 10:10
 * @another:HG
 * @email:1572651596@qq.com
 */
public class MyBtnEntity implements CustomTabEntity {
    private String titles;
    private int selectIcon;
    private int unselectIcon;

    public MyBtnEntity(String titles, int selectIcon, int unselectIcon) {
        this.titles = titles;
        this.selectIcon = selectIcon;
        this.unselectIcon = unselectIcon;
    }

    @Override
    public String getTabTitle() {
        return titles;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselectIcon;
    }
}
