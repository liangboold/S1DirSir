package com.bawei.s1dirsir.adapter;

import androidx.annotation.Nullable;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.DiscountBean;
import com.bw.utils.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * @package:com.bawei.s1dirsir.adapter
 * @fileName:DiscountAdapter
 * @date on:2021/9/17 18:41
 * @another:HG
 * @email:1572651596@qq.com
 */
public class DiscountAdapter extends BaseQuickAdapter<DiscountBean, BaseViewHolder> {
    public DiscountAdapter(int layoutResId, @Nullable @org.jetbrains.annotations.Nullable List<DiscountBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiscountBean item) {
        ImgUtil.imgLoad(item.getUrl(),helper.getView(R.id.image_discount));
    }
}
