package com.bawei.s1dirsir.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.s1dirsir.R;
import com.bw.mvp.view.BaseActivty;
import com.bw.utils.MyToast;

public class SearchActivity extends BaseActivty  {
    private ImageView back;
    private EditText search;
    private TextView scan;

    @Override
    public int bindLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        back = (ImageView) findViewById(R.id.back);
        search = (EditText) findViewById(R.id.search);
        scan = (TextView) findViewById(R.id.scan);
    }

    @Override
    public void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String s = search.getText().toString();
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ShopListActivity.class);
                startActivity(intent);
                MyToast.showLong(SearchActivity.this,s+"");
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void showLoading() {

    }
}