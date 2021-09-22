package com.bawei.s1dirsir.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.ClassAdapter;
import com.bawei.s1dirsir.adapter.GoodAdapter;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bawei.s1dirsir.injection.component.DaggerFoodComponent;
import com.bawei.s1dirsir.injection.component.DaggerHomeComponent;
import com.bawei.s1dirsir.injection.module.FoodModule;
import com.bawei.s1dirsir.injection.module.HomeModule;
import com.bawei.s1dirsir.presenter.FoodPersenter;
import com.bw.di.component.DaggerFragmentComponent;
import com.bw.mvp.view.BaseMVPFragment;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ClassFragment extends BaseMVPFragment implements FoodContract {
    private RecyclerView rvLeft;
    private RecyclerView rvRight;
    ClassAdapter classAdapter;
    ArrayList<JsonBean.DataBean> data;

    @Inject
    FoodPersenter presenter;

    @Override
    public void onResume() {
        Intent intent = getActivity().getIntent();

        data = intent.getParcelableArrayListExtra("data");
        System.out.println(data);
        classAdapter = new ClassAdapter(R.layout.item_left, data);
        rvLeft.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        rvLeft.setAdapter(classAdapter);
        rvLeft.setLayoutManager(new LinearLayoutManager(getContext()));
        classAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {


                for (int i = 0; i < data.size(); i++) {
                data.get(i).setmIsFromClick(false);
                }
                data.get(position).setmIsFromClick(true);
                classAdapter.notifyDataSetChanged();
                if (position==0){
                    GoodAdapter classAdapter = new GoodAdapter(R.layout.item_right, data);
                    rvRight.setAdapter(classAdapter);
                    rvRight.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                }
                else if (position==1){
                    GoodAdapter classAdapter = new GoodAdapter(R.layout.item_right, data);
                    rvRight.setAdapter(classAdapter);
                    rvRight.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                }
                else {
                    GoodAdapter classAdapter = new GoodAdapter(R.layout.item_right, data);
                    rvRight.setAdapter(classAdapter);
                    rvRight.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                }
            }
        });

        super.onResume();
    }

    @Override
    protected void injectCompoent() {
//        DaggerHomeComponent.builder().fragmentComponent(fragmentComponent)
//                .homeModule(new HomeModule()).build()
//                .injectFragment(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

        rvLeft = (RecyclerView) findViewById(R.id.rv_left);
        rvRight = (RecyclerView) findViewById(R.id.rv_right);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_class;
    }

    @Override
    public void foodSuccess(JsonBean jsonBean) {



    }

    @Override
    public void foodFailed(Throwable throwable) {
        Log.e("TAG", "foodFailed: "+throwable.getMessage() );
    }
}