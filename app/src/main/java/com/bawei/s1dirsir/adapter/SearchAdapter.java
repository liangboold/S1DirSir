package com.bawei.s1dirsir.adapter;

import androidx.annotation.Nullable;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.bean.SearchBean;
import com.bw.database.user.User;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @package:com.bawei.s1dirsir.adapter
 * @fileName:SearchAdapter
 * @date on:2021/9/22 16:14
 * @another:HG
 * @email:1572651596@qq.com
 */
public class SearchAdapter extends BaseQuickAdapter<SearchBean, BaseViewHolder> {
//    public SearchAdapter(int layoutResId, @Nullable @org.jetbrains.annotations.Nullable List<User> data) {
//        super(layoutResId, data);
//    }
//
//    @Override
//    protected void convert(BaseViewHolder helper, User item) {
//        helper.setText(R.id.text_search,item.getMsg());
//    }
    public SearchAdapter(int layoutResId, @Nullable @org.jetbrains.annotations.Nullable List<SearchBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean item) {
        helper.setText(R.id.text_search,item.getMsg());
    }
}
