package com.bawei.s1dirsir.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bw.mvp.view.BaseMVPFragment;
import com.bw.utils.ImgUtil;

import java.io.Serializable;

public class DetailsFragment extends BaseMVPFragment {
    private ImageView image1;
    private ImageView image2;





    @Override
    protected void injectCompoent() {

    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        BaseBean.DataBean data = (BaseBean.DataBean) intent.getSerializableExtra("data");
        String goodsDetailOne = data.getGoodsDetailOne();
        ImgUtil.imgLoad(goodsDetailOne,image1);
        ImgUtil.imgLoad(data.getGoodsDetailTwo(),image2);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_details;
    }
}