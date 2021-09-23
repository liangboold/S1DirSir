package com.bawei.s1dirsir.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.contract.HomeContract;
import com.bawei.s1dirsir.injection.component.DaggerHomeComponent;
import com.bawei.s1dirsir.injection.module.HomeModule;
import com.bawei.s1dirsir.presenter.HomePresenter;
import com.bw.mvp.view.BaseMVPActivity;

import java.util.List;

import javax.inject.Inject;

public class ShopListActivity extends BaseMVPActivity implements HomeContract {
    private ImageView back;

    @Inject
    HomePresenter presenter;
    @Override
    public void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {
        back = (ImageView) findViewById(R.id.back);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_list;
    }


    @Override
    protected void injectComponent() {


    }

    @Override
    public void foodSuccess(BaseBean baseBean) {

    }

    @Override
    public void foodFailed(Throwable throwable) {

    }
}