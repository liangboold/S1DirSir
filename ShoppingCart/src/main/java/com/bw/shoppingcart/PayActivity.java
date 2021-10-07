package com.bw.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class PayActivity extends AppCompatActivity {
    private Button btnFu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        btnFu = (Button) findViewById(R.id.btn_fu);
        btnFu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PayActivity.this, "11111", Toast.LENGTH_SHORT).show();
            }
        });
    }
}