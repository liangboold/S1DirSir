package com.bawei.s1dirsir.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.db.User;
import com.bw.utils.ImgUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/*
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 * 写这段代码的时候，只有上帝和我知道它是干嘛的
 * 现在，只有上帝知道
 * @ClassName OrdersAdapter
 * @Description TODO
 * @Author 海
 * @Date 2021/10/7 10:56
 * @Version 1.0
 */
public class OrdersAdapter extends BaseQuickAdapter<User, BaseViewHolder> {
    public OrdersAdapter(int layoutResId, @Nullable @org.jetbrains.annotations.Nullable List<User> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {
    helper.setText(R.id.order_title,item.getTitle());
    helper.setText(R.id.order_price,item.getPrice());
    ImgUtil.imgLoad(item.getPic(),helper.getView(R.id.order_img));

    }


}