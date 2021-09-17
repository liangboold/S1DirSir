package com.bawei.s1dirsir.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bawei.s1dirsir.R;

public class ShopCarFragment extends Fragment {

    private View inflate;
    private TextView shopTextUpdata;
    private CheckBox shopBtnAll;
    private Button shopBtnPay;
    private TextView shopTextPrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_shop_car, container, false);
        initView();
        initData();
        return inflate;
    }

    private void initData() {
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

    private void initView() {
        shopTextUpdata = (TextView) inflate.findViewById(R.id.shop_text_updata);
        shopBtnAll = (CheckBox) inflate.findViewById(R.id.shop_btn_all);
        shopBtnPay = (Button) inflate.findViewById(R.id.shop_btn_pay);
        shopTextPrice = (TextView) inflate.findViewById(R.id.shop_text_price);
    }
}