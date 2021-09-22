package com.bawei.s1dirsir.fragment;

import android.content.Intent;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.View;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.ClassAdapter;
import com.bawei.s1dirsir.adapter.GoodAdapter;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bw.mvp.view.BaseMVPFragment;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bawei.s1dirsir.presenter.FoodPersenter;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import javax.inject.Inject;



public class ClassFragment extends BaseMVPFragment implements FoodContract {
    private RecyclerView rvLeft;
    private RecyclerView rvRight;
    ClassAdapter classAdapter;
    List<JsonBean.DataBean> data;
    List<JsonBean.DataBean> datatwo;
    List<JsonBean.DataBean> datathere;
    @Inject
    FoodPersenter presenter;


    @Override
    public void onResume() {
        Intent intent = getActivity().getIntent();
        data = intent.getParcelableArrayListExtra("data");
        datatwo = intent.getParcelableArrayListExtra("datas");
        datathere = intent.getParcelableArrayListExtra("datathere");
        List<JsonBean.DataBean> data = intent.getParcelableArrayListExtra("data");
        List<JsonBean.DataBean> datatwo = intent.getParcelableArrayListExtra("datatwo");
        List<JsonBean.DataBean> datathere = intent.getParcelableArrayListExtra("datathere");
        classAdapter = new ClassAdapter(R.layout.item_left, data);
        rvLeft.addItemDecoration(new DividerItemDecoration(getActivity(), 1));
        rvLeft.setAdapter(classAdapter);
        rvLeft.setLayoutManager(new LinearLayoutManager(getContext()));
        classAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {


                for (int i = 0; i < data.size(); i++) {
                    data.get(i).setCheck(false);
                }
                data.get(position).setCheck(true);
                classAdapter.notifyDataSetChanged();
                if (position==0){
                    GoodAdapter classAdapter = new GoodAdapter(R.layout.item_right, datatwo);
                    rvRight.setAdapter(classAdapter);
                    rvRight.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                }
                else if (position==1){
                    GoodAdapter classAdapter = new GoodAdapter(R.layout.item_right, datathere);
                    rvRight.setAdapter(classAdapter);
                    rvRight.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                }
                else {

                }
            }
        });

        super.onResume();
    }

    @Override
    protected void injectCompoent() {

    }

    @Override
    protected void initData() {
//        presenter.initFood(0);
//        presenter.initClass(1);
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

//        data = jsonBean.getData();
    }

    @Override
    public void classSuccess(JsonBean jsonBean) {

//        data = jsonBean.getData();
    }

    @Override
    public void thereSuccess(JsonBean jsonBean) {

    }

    @Override
    public void foodFailed(Throwable throwable) {
        Log.e("TAG", "foodFailed: "+throwable.getMessage() );
    }

}