package com.bawei.s1dirsir.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.activity.SearchActivity;
import com.bw.utils.MyToast;

public class MainFragment extends Fragment {
    private EditText search;
    private TextView scan;

   private View inflate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inflate = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToast.showLong(getContext(),"敬请期待~~~");
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
        return inflate;
    }

    private void initView() {
        search = (EditText) inflate.findViewById(R.id.search);
        scan = (TextView) inflate.findViewById(R.id.scan);
    }
}