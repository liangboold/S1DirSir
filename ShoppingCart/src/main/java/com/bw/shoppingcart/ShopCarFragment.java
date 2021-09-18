package com.bw.shoppingcart;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.mvp.view.BaseMVPFragment;

public class ShopCarFragment extends BaseMVPFragment {

    private TextView shopTextUpdata;
    private CheckBox shopBtnAll;
    private Button shopBtnPay;
    private TextView shopTextPrice;


    @Override
    protected void initData() {
        shopTextUpdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shopTextUpdata.getText().toString().equals("编辑")) {
                    shopBtnPay.setText("删除");
                    shopTextPrice.setVisibility(View.GONE);
                    shopTextUpdata.setText("完成");
                } else if (shopTextUpdata.getText().toString().equals("完成")) {
                    shopBtnPay.setText("去结算");
                    shopTextPrice.setVisibility(View.VISIBLE);
                    shopTextUpdata.setText("编辑");
                }
            }
        });
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {
        shopTextUpdata = (TextView) findViewById(R.id.shop_text_updata);
        shopBtnAll = (CheckBox) findViewById(R.id.shop_btn_all);
        shopBtnPay = (Button) findViewById(R.id.shop_btn_pay);
        shopTextPrice = (TextView) findViewById(R.id.shop_text_price);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop_car;
    }

    @Override
    protected void injectCompoent() {

    }
}