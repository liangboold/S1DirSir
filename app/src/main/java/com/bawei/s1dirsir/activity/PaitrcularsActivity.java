package com.bawei.s1dirsir.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.ClassAdapter;
import com.bawei.s1dirsir.adapter.ShopAdapter;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bawei.s1dirsir.presenter.FoodPersenter;
import com.bw.mvp.view.BaseMVPActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaitrcularsActivity extends BaseMVPActivity<FoodPersenter>implements FoodContract {
    private RecyclerView rvPaitrculars;

    @Override
    protected void onResume() {
//        Intent intent = getIntent();
//        List<BaseBean.DataBean> datapaitrcu = (List<BaseBean.DataBean>) getIntent().getSerializableExtra("datapaitrcu");
//
////        List<BaseBean.DataBean> datapaitrcu = (List<BaseBean.DataBean>) intent.getSerializableExtra("");
//        Log.i("TAG", "onResume: ----------------"+datapaitrcu);
        List<BaseBean.DataBean> data = MainActivity.data;
        ShopAdapter shopAdapter = new ShopAdapter(R.layout.item_shop, data);
        rvPaitrculars.setAdapter(shopAdapter);
        rvPaitrculars.setLayoutManager(new GridLayoutManager(this,2));
        shopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                BaseBean.DataBean dataBean = data.get(position);
                Intent intent = new Intent(PaitrcularsActivity.this, DetailsActivity.class);
                intent.putExtra("data",dataBean);
                startActivity(intent);
            }
        });
        super.onResume();
    }

    @Override
    public void foodSuccess(JsonBean jsonBean) {

    }

    @Override
    public void classSuccess(JsonBean jsonBean) {

    }

    @Override
    public void thereSuccess(JsonBean jsonBean) {

    }

    @Override
    public void paitrcularsSuccess(BaseBean baseBean) {

    }

    @Override
    public void foodFailed(Throwable throwable) {

    }

    @Override
    protected void injectComponent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {


        rvPaitrculars = (RecyclerView) findViewById(R.id.rv_paitrculars);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_paitrculars;
    }
}