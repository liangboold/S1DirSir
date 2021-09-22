package com.bawei.s1dirsir.adapter;

import androidx.annotation.Nullable;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bw.utils.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/*
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在，只有上帝知道
 * @ClassName GoodAdapter
 * @Description TODO
 * @Author 海
 * @Date 2021/9/22 9:17
 * @Version 1.0
 */
public class GoodAdapter extends BaseQuickAdapter<JsonBean.DataBean, BaseViewHolder> {
    public GoodAdapter(int layoutResId,  List<JsonBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JsonBean.DataBean item) {
        helper.setText(R.id.tv_right,item.getCategoryName());
        ImgUtil.imgLoad(item.getCategoryIcon(),helper.getView(R.id.img_right));
    }
}