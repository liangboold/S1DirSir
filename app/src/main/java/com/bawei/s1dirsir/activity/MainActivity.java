package com.bawei.s1dirsir.activity;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import com.bawei.s1dirsir.adapter.FragmentAdapter;
import com.bawei.s1dirsir.fragment.MainFragment;
import com.bawei.s1dirsir.fragment.MessageFragment;
import com.bawei.s1dirsir.fragment.MyFragment;
import com.bawei.s1dirsir.fragment.ShopCarFragment;
import com.bawei.s1dirsir.injection.component.DaggerFoodComponent;
import com.bawei.s1dirsir.injection.module.FoodModule;
import com.bawei.s1dirsir.presenter.FoodPersenter;
import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bawei.s1dirsir.fragment.ClassFragment;
import com.bw.mvp.view.BaseMVPActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends BaseMVPActivity<FoodPersenter> implements FoodContract,BottomNavigationBar.OnTabSelectedListener{
    private ViewPager vp;
    private BottomNavigationBar bar;
    private final ArrayList<Fragment>list = new ArrayList<>();
    @Inject
    FoodPersenter presenter;



//    @Override
//    public int bindLayout() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    public void initView() {
//        vp = (ViewPager) findViewById(R.id.vp);
//        bar = (BottomNavigationBar) findViewById(R.id.bar);
//    }



    @Override
    public void initData() {

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
    protected void initEvent() {

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                presenter.initFood();
//            }
//        });

    }

    @Override
    protected void init() {
        vp = (ViewPager) findViewById(R.id.vp);
        bar = (BottomNavigationBar) findViewById(R.id.bar);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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

    @Override
    protected void injectComponent() {
        DaggerFoodComponent.builder().activityComponent(activityComponent)
                .foodModule(new FoodModule(this))
                .build().injectMainActivity(this);
    }

    @Override
    public void foodSuccess(JsonBean jsonBean) {
        Toast.makeText(this, jsonBean.toString(), Toast.LENGTH_SHORT).show();
        Log.i("123456", "foodSuccess: "+jsonBean.getData().size());
    }

    @Override
    public void foodFailed(Throwable throwable) {
        Log.e("TAG", "foodFailed: "+throwable.getMessage() );
    }

}