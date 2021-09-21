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
import com.bw.mvp.view.BaseActivity;
import com.bw.mvp.view.BaseMVPActivity;
import com.bw.utils.MyToast;

import java.util.ArrayList;

public class SearchActivity extends BaseMVPActivity {
    private ImageView back;
    private EditText search;
    private TextView scan;
    private ArrayList<String>list = new ArrayList<>();

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
//                Intent intent = new Intent(SearchActivity.this, ShopListActivity.class);
//                startActivity(intent);
                MyToast.showLong(SearchActivity.this,s);
            }
        });


//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
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
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void injectComponent() {

    }
}