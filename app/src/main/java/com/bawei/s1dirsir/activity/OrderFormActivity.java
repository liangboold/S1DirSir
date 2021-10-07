package com.bawei.s1dirsir.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.FragmentAdapter;
import com.bawei.s1dirsir.adapter.OrderAdapter;
import com.bawei.s1dirsir.fragment.AllFragment;
import com.bawei.s1dirsir.fragment.CanceledFragment;
import com.bawei.s1dirsir.fragment.OkFragment;
import com.bawei.s1dirsir.fragment.PaymentFragment;
import com.bawei.s1dirsir.fragment.ReceivingFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class OrderFormActivity extends AppCompatActivity {

    private ImageView back;
    private TabLayout orderTb;
    private ViewPager orderVp;
    List<Fragment> list;
    List<String> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);
        initView();
        list =new ArrayList<>();
        list1=new ArrayList<>();
        list.add(new AllFragment());
        list.add(new PaymentFragment());
        list.add(new ReceivingFragment());
        list.add(new OkFragment());
        list.add(new CanceledFragment());

        list1.add("全部");
        list1.add("代付款");
        list1.add("待收货");
        list1.add("已完成");
        list1.add("已取消");

        OrderAdapter orderAdapter = new OrderAdapter(getSupportFragmentManager(),list,list1);

        orderVp.setAdapter(orderAdapter);

        orderTb.setupWithViewPager(orderVp);


    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        orderTb = (TabLayout) findViewById(R.id.order_tb);
        orderVp = (ViewPager) findViewById(R.id.order_vp);
    }
}