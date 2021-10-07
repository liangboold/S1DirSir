package com.bawei.s1dirsir.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.AddressBean;
import com.bw.mvp.view.BaseMVPActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends BaseMVPActivity {
    private int id = 1;
    ArrayList<AddressBean> data = new ArrayList<>();
    private ImageView back;
    private RecyclerView addressrv;
    private MyRv myRv;
    private Intent intent;

    @Override
    protected void initData() {
        AddressBean address = getIntent().getParcelableExtra("address");
        if (address != null){
            data.add(address);
        }
        myRv = new MyRv(data);
        addressrv.setAdapter(myRv);
    }

    @Override
    protected void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void init() {
        back = (ImageView) findViewById(R.id.back);
        addressrv = (RecyclerView) findViewById(R.id.addressrv);
        addressrv.setLayoutManager(new LinearLayoutManager(this));
        data.add(new AddressBean(id++,"哈哈","秀儿市","秀儿大街256号",true));
        intent = new Intent(this, NewAddressActivity.class);
        intent.putExtra("id",id);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_address;
    }

    private class MyRv extends BaseQuickAdapter<AddressBean, BaseViewHolder>{

        public MyRv(@Nullable List<AddressBean> data) {
            super(R.layout.addressitem, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, AddressBean item) {
            helper.setText(R.id.name,item.getName()+"\t\t"+item.getCity());
            helper.setText(R.id.sdetails,item.getSdetails());
            CheckBox view = helper.getView(R.id.cb_default);
            view.setChecked(item.isChoice());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (AddressBean datum : data) {
                        datum.setChoice(false);
                    }
                    item.setChoice(true);
                    myRv.notifyDataSetChanged();
                    Toast.makeText(mContext, "设置成功", Toast.LENGTH_SHORT).show();
                }
            });

            helper.getView(R.id.del).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.remove(item);
                    myRv.notifyDataSetChanged();
                    Toast.makeText(mContext, "删除成功", Toast.LENGTH_SHORT).show();
                }
            });

            helper.getView(R.id.edit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("address",item);
                    startActivity(intent);
                    finish();
                }
            });

        }
    }

    public void add(View view) {
        startActivity(intent);
        finish();
    }

    @Override
    protected void injectComponent() {

    }
}