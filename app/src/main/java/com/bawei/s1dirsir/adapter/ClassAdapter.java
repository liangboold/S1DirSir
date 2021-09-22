package com.bawei.s1dirsir.adapter;

import androidx.annotation.Nullable;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.JsonBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/*
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在，只有上帝知道
 * @ClassName ClassAdapter
 * @Description TODO
 * @Author 海
 * @Date 2021/9/21 20:01
 * @Version 1.0
 */
public class ClassAdapter extends BaseQuickAdapter<JsonBean.DataBean, BaseViewHolder> {
    public ClassAdapter(int layoutResId, @Nullable @org.jetbrains.annotations.Nullable List<JsonBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JsonBean.DataBean item) {
        helper.setText(R.id.text_left,item.getCategoryName());
    }
}