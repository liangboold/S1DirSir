package com.bw.shoppingcart;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bw.database.user.GoodsBean;
import com.bw.database.user.GreenDaoManager;
import com.bw.mvp.view.BaseMVPFragment;
import com.bw.utils.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import ren.qinc.numberbutton.NumberButton;

public class ShopCarFragment extends BaseMVPFragment {

    private TextView shopTextUpdata;
    private CheckBox shopBtnAll;
    private Button shopBtnPay;
    private TextView shopTextPrice;
    private RecyclerView shopRv;
    GreenDaoManager greenDaoManager = GreenDaoManager.getInstance();
    private List<GoodsBean> goodsList;
    private GoodRvAdapte goodRvAdapte;


    @Override
    protected void initData() {
        //编辑和完成的状态切换事件
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

    private class GoodRvAdapte extends BaseQuickAdapter<GoodsBean, BaseViewHolder> {

        public GoodRvAdapte(@Nullable List<GoodsBean> data) {
            super(R.layout.item, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, GoodsBean item) {
            TextView good_title = helper.getView(R.id.good_title);
            good_title.setMaxLines(1);
            CheckBox checkBox = helper.getView(R.id.good_cb);
            checkBox.setChecked(item.getIscheck());
            helper.setText(R.id.good_title, item.getGoodsDesc());
            helper.setText(R.id.good_src, item.getGoodsDefaultSku());
            helper.setText(R.id.good_price, "￥"+item.getGoodsDefaultPrice()+".00");
            ImgUtil.imgLoadRounded(item.getGoodsDefaultIcon(),helper.getView(R.id.good_img),20);
            NumberButton view = helper.getView(R.id.number_button);
            view.setBuyMax(5)//最大购买数量
                .setCurrentNumber(item.getGoodsCount())//当前数量
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

            //item点击状态切换
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    item.setIscheck(checkBox.isChecked());
                    greenDaoManager.goodsUpdata(item);
                    initIscheckAndPrice();
                }
            });
        }
    }

    //初始化全选状态和总价
    private void initIscheckAndPrice() {
            int price = 0;
            int count = 0;
            for (GoodsBean goodsBean : goodsList) {
                if (goodsBean.getIscheck()){
                    count++;
                    price += Integer.parseInt(goodsBean.getGoodsDefaultPrice()) * goodsBean.getGoodsCount();
                }
            }
            if (count == goodsList.size() && count != 0){
                shopBtnAll.setChecked(true);
            }else {
                shopBtnAll.setChecked(false);
            }
            shopTextPrice.setText("合计:￥"+price+".00");
    }


    @Override
    public void onResume() {
        super.onResume();
        initIscheckAndPrice();
        goodRvAdapte.notifyDataSetChanged();
    }

    //初始化适配器
    private void initAdpter() {
        goodRvAdapte = new GoodRvAdapte(goodsList);
        shopRv.setAdapter(goodRvAdapte);
    }

    @Override
    protected void initEvent() {
        //全选事件处理
        shopBtnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (GoodsBean goodsBean : goodsList) {
                    goodsBean.setIscheck(shopBtnAll.isChecked());
                    greenDaoManager.goodsUpdata(goodsBean);
                }
                goodRvAdapte.notifyDataSetChanged();
                initIscheckAndPrice();
            }
        });

        //删除或支付事件
        shopBtnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shopBtnPay.getText().equals("删除")){
                    ArrayList<GoodsBean> goodsBeans = new ArrayList<>();
                    for (GoodsBean goodsBean : goodsList) {
                        if (goodsBean.getIscheck()){
                            goodsBeans.add(goodsBean);
                        }
                    }
                    for (GoodsBean goodsBean : goodsBeans) {
                        goodsList.remove(goodsBean);
                        greenDaoManager.goodsDel(goodsBean);
                    }
                    initIscheckAndPrice();
                    goodRvAdapte.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    protected void initView() {
        goodsList = greenDaoManager.getGoodsList();
        shopTextUpdata = (TextView) findViewById(R.id.shop_text_updata);
        shopBtnAll = (CheckBox) findViewById(R.id.shop_btn_all);
        shopBtnPay = (Button) findViewById(R.id.shop_btn_pay);
        shopTextPrice = (TextView) findViewById(R.id.shop_text_price);
        shopRv = (RecyclerView) findViewById(R.id.shop_rv);
        shopRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        initAdpter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.shopingcar;
    }

    @Override
    protected void injectCompoent() {

    }
}