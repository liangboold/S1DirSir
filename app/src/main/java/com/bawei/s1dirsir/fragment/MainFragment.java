package com.bawei.s1dirsir.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.activity.MainActivity;
import com.bawei.s1dirsir.activity.SearchActivity;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bawei.s1dirsir.inject.DaggerActivityComment;
import com.bawei.s1dirsir.inject.FoodModule;
import com.bawei.s1dirsir.presenter.FoodPersenter;
import com.bw.mvp.view.BaseFragment;
import com.bw.utils.ImgUtil;
import com.bw.utils.MyToast;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFragment extends BaseFragment<FoodPersenter> implements FoodContract.FoodView {
    private EditText search;
    private TextView scan;
    private Banner banner;
    private ArrayList list = new ArrayList();
    private GridView gridview;
    private List<Map<String,Object>>datalist = new ArrayList<>();;
    private SimpleAdapter simpleAdapter;


    @Override
    public int bindLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView() {
        search = (EditText) findViewById(R.id.search);
        scan = (TextView) findViewById(R.id.scan);
        banner = (Banner) findViewById(R.id.banner);
        gridview = (GridView) findViewById(R.id.gridview);
    }

    @Override
    public void initData() {
        bannerView();
        gridviewView();
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
    }

    private void gridviewView() {
        //图标
        int icno[] = {R.drawable.live,R.drawable.notebook,R.drawable.tel,R.drawable.pad,
                R.drawable.house,R.drawable.home,R.drawable.sport,R.drawable.relaxation};
        //图标下的文字
        String name[] = {"直播","电脑","手机","Pad","家居","家电","运动","休闲"};

        for (int i = 0; i <icno.length; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("image_gridview", icno[i]);
            map.put("text_gridview",name[i]);
            datalist.add(map);
        }
        String [] from = {"image_gridview","text_gridview"};
        int [] to = {R.id.image_gridview,R.id.text_gridview};
        simpleAdapter=new SimpleAdapter(getContext(), datalist, R.layout.gridview_item, from, to);
        gridview.setAdapter(simpleAdapter);
    }

    private void bannerView() {
        list.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=259364631,2307942273&fm=26&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3765821666,4235344830&fm=26&gp=0.jpg");
        list.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3336810809,2729597475&fm=26&gp=0.jpg");
        banner.setImages(list);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ImgUtil.imgLoad(path,imageView);
            }
        });
        banner.start();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void immersive() {

    }

    @Override
    public void showFood(JsonBean jsonBean) {

    }
}