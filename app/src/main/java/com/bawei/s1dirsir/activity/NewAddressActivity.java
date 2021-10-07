package com.bawei.s1dirsir.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.AddressBean;
import com.bw.mvp.view.BaseMVPActivity;

import java.util.ArrayList;

public class NewAddressActivity extends BaseMVPActivity {

    private ImageView back;
    private EditText name;
    private EditText phone;
    private EditText sdetails;
    private Intent intent;
    private AddressBean address;
    private int id;

    @Override
    protected void initData() {
        if (address != null){
            name.setText(address.getName());
            phone.setText(address.getCity());
            sdetails.setText(address.getSdetails());
        }

    }

    @Override
    protected void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void init() {
        back = (ImageView) findViewById(R.id.back);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        sdetails = (EditText) findViewById(R.id.sdetails);
        intent = new Intent(this, AddressActivity.class);
        address = getIntent().getParcelableExtra("address");
        id = getIntent().getIntExtra("id", 0);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_address;
    }



    public void save(View view) {
            AddressBean addressBean = new AddressBean(id++,name.getText().toString().trim(), phone.getText().toString().trim(), sdetails.getText().toString().trim(), false);
            intent.putExtra("address",addressBean);
            startActivity(intent);
            finish();
    }

    @Override
    protected void injectComponent() {

    }
}