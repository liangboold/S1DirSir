package com.bawei.s1dirsir.adapter;

import androidx.annotation.Nullable;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bw.utils.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @package:com.bawei.s1dirsir.adapter
 * @fileName:ShopAdapter
 * @date on:2021/9/22 8:48
 * @another:HG
 * @email:1572651596@qq.com
 */
public class ShopAdapter extends BaseQuickAdapter<BaseBean.DataBean, BaseViewHolder> {

    public ShopAdapter(int layoutResId, @Nullable @org.jetbrains.annotations.Nullable List<BaseBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BaseBean.DataBean item) {
        ImgUtil.imgLoad(item.getGoodsDefaultIcon(),helper.getView(R.id.image_shop));
        helper.setText(R.id.text_desc,item.getGoodsDesc());
        helper.setText(R.id.text_num,item.getGoodsDefaultPrice());
        helper.setText(R.id.text_money,item.getGoodsSalesCount()+"");
    }
}
