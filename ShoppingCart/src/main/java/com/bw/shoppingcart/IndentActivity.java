package com.bw.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class IndentActivity extends AppCompatActivity {
    private ImageView goodImg;
    private TextView goodTitle;
    private TextView goodSrc;
    private TextView goodPrice;
    private Button btnShop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent);
        inita();
        Glide.with(this).load("https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg").into(goodImg);
        goodTitle.setText("Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)");
        goodSrc.setText("1.6GHz i5处理器,GB内存/128GB SSD,1件");
        goodPrice.setText("￥：300.00");
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndentActivity.this, PayActivity.class));
            }
        });
    }

    private void inita() {
        goodImg = (ImageView) findViewById(R.id.good_img);
        goodTitle = (TextView) findViewById(R.id.good_title);
        goodSrc = (TextView) findViewById(R.id.good_src);
        goodPrice = (TextView) findViewById(R.id.good_price);
        btnShop = (Button) findViewById(R.id.btn_shop);
    }
}