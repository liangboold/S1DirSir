package com.bawei.s1dirsir.fragment;

import android.database.sqlite.SQLiteDatabase;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.OrdersAdapter;
import com.bawei.s1dirsir.db.DaoMaster;
import com.bawei.s1dirsir.db.DaoSession;
import com.bawei.s1dirsir.db.User;
import com.bawei.s1dirsir.db.UserDao;
import com.bw.mvp.view.BaseMVPFragment;

import java.util.List;

public class PaymentFragment extends BaseMVPFragment {


    private RecyclerView payRv;

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
        payRv.setAdapter(ordersAdapter);
        payRv.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

        payRv = (RecyclerView) findViewById(R.id.pay_rv);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_payment;
    }
}