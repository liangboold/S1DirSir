package com.bawei.s1dirsir.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.ShopAdapter;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.contract.HomeContract;
import com.bawei.s1dirsir.fragment.MainFragment;
import com.bawei.s1dirsir.injection.component.DaggerHomeComponent;
import com.bawei.s1dirsir.injection.module.HomeModule;
import com.bawei.s1dirsir.presenter.HomePresenter;
import com.bw.mvp.view.BaseMVPActivity;

import java.util.List;

import javax.inject.Inject;

public class ShopListActivity extends BaseMVPActivity {
    private ImageView back;
    private RecyclerView rvShop;


    @Override
    public void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        List<BaseBean.DataBean> data = MainActivity.data;
        ShopAdapter shopAdapter = new ShopAdapter(R.layout.item_shop, data);
        rvShop.setAdapter(shopAdapter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {
        back = (ImageView) findViewById(R.id.back);
        rvShop = (RecyclerView) findViewById(R.id.rv_shop);
        rvShop.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_list;
    }


    @Override
    protected void injectComponent() {


    }

}