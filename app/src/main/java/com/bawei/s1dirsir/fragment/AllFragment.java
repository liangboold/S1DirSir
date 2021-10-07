package com.bawei.s1dirsir.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.db.DaoMaster;
import com.bawei.s1dirsir.db.DaoSession;
import com.bawei.s1dirsir.db.User;
import com.bawei.s1dirsir.db.UserDao;
import com.bw.mvp.view.BaseMVPFragment;

import java.util.List;

public class AllFragment extends BaseMVPFragment {


    private RecyclerView allRv;

    @Override
    protected void injectCompoent() {

    }

    @Override
    protected void initData() {
        SQLiteDatabase order = new DaoMaster.DevOpenHelper(getActivity(), "order").getWritableDatabase();
        DaoSession daoSession = new DaoMaster(order).newSession();
        UserDao userDao = daoSession.getUserDao();
        List<User> users = userDao.loadAll();

        OrdersAdapter ordersAdapter = new OrdersAdapter(R.layout.order_item, users);
        allRv.setAdapter(ordersAdapter);
        allRv.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

        allRv = (RecyclerView) findViewById(R.id.all_rv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all;
    }
}