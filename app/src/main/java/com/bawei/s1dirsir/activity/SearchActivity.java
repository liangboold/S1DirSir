package com.bawei.s1dirsir.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.adapter.SearchAdapter;
import com.bawei.s1dirsir.bean.SearchBean;
import com.bw.database.user.GreenDaoManager;
import com.bw.database.user.User;
import com.bw.mvp.view.BaseMVPActivity;
import com.bw.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseMVPActivity {
    private ImageView back;
    private EditText search;
    private TextView scan;
    private ArrayList<SearchBean>list = new ArrayList<>();
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private Button clear;

    @Override
    public void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = search.getText().toString();
                if(s.isEmpty()){
                    MyToast.showLong(SearchActivity.this,"搜索内容不能为空");
                }else{
                    Intent intent = new Intent(SearchActivity.this, ShopListActivity.class);
                    startActivity(intent);
                    list.add(new SearchBean(s));
                    searchAdapter = new SearchAdapter(R.layout.item_search,list);
                    recyclerView.setAdapter(searchAdapter);
                }


            }
        });
//        clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                GreenDaoManager.getUserDao().deleteAll();
//                List<User> users = GreenDaoManager.getUserDao().loadAll();
//                searchAdapter = new SearchAdapter(R.layout.item_search,users);
//                recyclerView.setAdapter(searchAdapter);
//            }
//        });

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void init() {
        back = (ImageView) findViewById(R.id.back);
        search = (EditText) findViewById(R.id.search);
        scan = (TextView) findViewById(R.id.scan);
        recyclerView = findViewById(R.id.rv3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        clear = (Button) findViewById(R.id.clear);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void injectComponent() {

    }
}