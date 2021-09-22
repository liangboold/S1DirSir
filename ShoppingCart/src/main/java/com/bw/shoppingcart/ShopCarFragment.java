package com.bw.shoppingcart;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bw.mvp.view.BaseMVPFragment;
import com.bw.utils.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import java.util.List;

import ren.qinc.numberbutton.NumberButton;

public class ShopCarFragment extends BaseMVPFragment {

    private TextView shopTextUpdata;
    private CheckBox shopBtnAll;
    private Button shopBtnPay;
    private TextView shopTextPrice;
    private RecyclerView shopRv;


    @Override
    protected void initData() {
        OkGo.<String>get("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        List<JsonBean.DataBean> data = new Gson().fromJson(response.body(), JsonBean.class).getData();
                        shopRv.setAdapter(new GoodRv(data));

                    }
                });

    }

    private class GoodRv extends BaseQuickAdapter<JsonBean.DataBean, BaseViewHolder> {

        public GoodRv(@Nullable List<JsonBean.DataBean> data) {
            super(R.layout.item, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, JsonBean.DataBean item) {
            helper.setText(R.id.good_title, item.getTitle());
            helper.setText(R.id.good_src, item.getFood_str());
            helper.setText(R.id.good_price, "￥"+item.getNum()+".00");
            ImgUtil.imgLoadRounded(item.getPic(),helper.getView(R.id.good_img),20);
            NumberButton view = helper.getView(R.id.number_button);
            view.setBuyMax(5)//最大购买数量
                .setCurrentNumber(1)//当前数量
                .setInventory(item.getNum())//库存
                .setOnWarnListener(new NumberButton.OnWarnListener() {
                    @Override
                    public void onWarningForInventory(int inventory) {
                        Toast.makeText(getActivity(), "当前库存:" + inventory, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onWarningForBuyMax(int max) {
                        Toast.makeText(getActivity(), "超过最大购买数:" + max, Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }

    @Override
    protected void initEvent() {
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
    protected void initView() {
        shopTextUpdata = (TextView) findViewById(R.id.shop_text_updata);
        shopBtnAll = (CheckBox) findViewById(R.id.shop_btn_all);
        shopBtnPay = (Button) findViewById(R.id.shop_btn_pay);
        shopTextPrice = (TextView) findViewById(R.id.shop_text_price);
        shopRv = (RecyclerView) findViewById(R.id.shop_rv);
        shopRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.shopingcar;
    }

    @Override
    protected void injectCompoent() {

    }
}