package com.bawei.s1dirsir.activity;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import com.bawei.s1dirsir.adapter.FragmentAdapter;
import com.bawei.s1dirsir.fragment.MainFragment;
import com.bawei.s1dirsir.fragment.MessageFragment;
import com.bawei.s1dirsir.fragment.MyFragment;
import com.bawei.s1dirsir.fragment.ShopCarFragment;
import com.bawei.s1dirsir.presenter.FoodPersenter;
import com.bw.mvp.view.BaseActivty;
import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bawei.s1dirsir.fragment.ClassFragment;
import com.bawei.s1dirsir.inject.FoodModule;

import java.util.ArrayList;

public class MainActivity extends BaseActivty<FoodPersenter> implements FoodContract.FoodView,BottomNavigationBar.OnTabSelectedListener{
    private ViewPager vp;
    private BottomNavigationBar bar;
    private final ArrayList<Fragment>list = new ArrayList<>();






    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        bar = (BottomNavigationBar) findViewById(R.id.bar);
    }

    @Override
    public void initData() {//DaggerActivityComment
        DaggerActivityComment.builder().foodModule(new FoodModule(this)).build().inject(this);
        p.initFood();

        list.add(new MainFragment());
        list.add(new ClassFragment());
        list.add(new ShopCarFragment());
        list.add(new MessageFragment());
        list.add(new MyFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(fragmentAdapter);

        bar.setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setActiveColor("#ff6600")
                .setInActiveColor("#cccccc")
                .setBarBackgroundColor("#ffffff");
        bar.addItem(new BottomNavigationItem(R.drawable.image_main,"主页"))
                .addItem(new BottomNavigationItem(R.drawable.image_class,"分类"))
                .addItem(new BottomNavigationItem(R.drawable.image_shopcar,"购物车"))
                .addItem(new BottomNavigationItem(R.drawable.image_message,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.image_my,"我的"))
                .initialise();
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bar.selectTab(0);
                        break;
                    case 1:
                        bar.selectTab(1);
                        break;
                    case 2:
                        bar.selectTab(2);
                        break;
                    case 3:
                        bar.selectTab(3);
                        break;
                    case 4:
                        bar.selectTab(4);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFood(JsonBean jsonBean) {
//        Toast.makeText(this, jsonBean.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabSelected(int position) {
        vp.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}