package com.bawei.s1dirsir.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.s1dirsir.MyBtnEntity;
import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.FragmentAdapter;
import com.bawei.s1dirsir.fragment.DetailsFragment;
import com.bawei.s1dirsir.fragment.ShopFragment;
import com.bw.mvp.view.BaseMVPActivity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class DetailsActivity extends BaseMVPActivity {
    private ImageView back;
    private CommonTabLayout tab;
    private ViewPager vp;
    private ArrayList<CustomTabEntity> tabEntitys = new ArrayList<>();
    private ArrayList<Fragment>list = new ArrayList<>();


    @Override
    protected void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabEntitys.add(new MyBtnEntity("商品",0,0));
        tabEntitys.add(new MyBtnEntity("详情",0,0));
        tab.setTabData(tabEntitys);
        list.add(new ShopFragment());
        list.add(new DetailsFragment());
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list);
        vp.setAdapter(fragmentAdapter);
        tab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tab.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {
        back = (ImageView) findViewById(R.id.back);
        tab = (CommonTabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void injectComponent() {

    }
}