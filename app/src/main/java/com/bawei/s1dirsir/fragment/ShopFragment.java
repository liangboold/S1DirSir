package com.bawei.s1dirsir.fragment;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bw.mvp.view.BaseMVPFragment;
import com.bw.utils.ImgUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;


public class ShopFragment extends BaseMVPFragment {
    private Banner banner;
    private TextView textDesc1;
    private TextView textMoney1;
    private TextView textStyle;

    @Override
    protected void injectCompoent() {

    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        BaseBean.DataBean data = (BaseBean.DataBean) intent.getSerializableExtra("data");
        textDesc1.setText(data.getGoodsDesc());
        textMoney1.setText("￥"+data.getGoodsDefaultPrice());
        textStyle.setText(data.getGoodsDefaultSku());
        String goodsDefaultIcon = data.getGoodsDefaultIcon();
        String goodsDetailOne = data.getGoodsDetailOne();
        String goodsDetailTwo = data.getGoodsDetailTwo();
        ArrayList<String> list= new ArrayList<>();
        list.add(goodsDefaultIcon);
        list.add(goodsDetailOne);
        list.add(goodsDetailTwo);
        banner.setImages(list);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ImgUtil.imgLoad(path,imageView);
            }
        });
        banner.start();


    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {
        banner = (Banner) findViewById(R.id.banner);
        textDesc1 = (TextView) findViewById(R.id.text_desc1);
        textMoney1 = (TextView) findViewById(R.id.text_money1);
        textStyle = (TextView) findViewById(R.id.text_style);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop;
    }
}