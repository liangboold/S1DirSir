package com.bawei.s1dirsir.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.s1dirsir.ImageUrl;
import com.bawei.s1dirsir.R;
import com.bawei.s1dirsir.VerticalTextview;
import com.bawei.s1dirsir.activity.DetailsActivity;
import com.bawei.s1dirsir.activity.MainActivity;
import com.bawei.s1dirsir.activity.SearchActivity;
import com.bawei.s1dirsir.adapter.DiscountAdapter;
import com.bawei.s1dirsir.adapter.ShopAdapter;
import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bawei.s1dirsir.contract.FoodContract;
import com.bawei.s1dirsir.contract.HomeContract;
import com.bawei.s1dirsir.injection.component.DaggerHomeComponent;
import com.bawei.s1dirsir.injection.module.HomeModule;
import com.bawei.s1dirsir.presenter.FoodPersenter;
import com.bawei.s1dirsir.presenter.HomePresenter;
import com.bw.mvp.view.BaseMVPFragment;
import com.bw.utils.ImgUtil;
import com.bw.utils.MyToast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PageItemClickListener;

public class MainFragment extends BaseMVPFragment implements HomeContract {
    private EditText search;
    private TextView scan;
    private Banner banner;
    private ArrayList list = new ArrayList();
    private GridView gridview;
    private List<Map<String,Object>>datalist = new ArrayList<>();
    private SimpleAdapter simpleAdapter;
    private View inflate;
    private ArrayList titleList = new ArrayList<>();
    private VerticalTextview mTextview;
    private RecyclerView rv;
    private MZBannerView fgHomeMzBanner;
    private ArrayList list_b = new ArrayList();
    private static int[] b = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};
    private RecyclerView recyclerView;
    private ShopAdapter shopAdapter;

    @Inject
    HomePresenter presenter;
    @Override
    protected void initData() {
        bannerView();
        gridviewView();
        pagerView();
        gonggaoView();
        recyView();
        //公告开始
        mTextview.startAutoScroll();
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

    @Override
    protected void initEvent() {
        presenter.initHome();
    }

    @Override
    protected void initView() {
        search = (EditText) findViewById(R.id.search);
        scan = (TextView) findViewById(R.id.scan);
        banner = (Banner) findViewById(R.id.banner);
        gridview = (GridView) findViewById(R.id.gridview);
        mTextview = (VerticalTextview) findViewById(R.id.textview);
        rv = (RecyclerView) findViewById(R.id.rv);
        fgHomeMzBanner = (MZBannerView) findViewById(R.id.fg_home_mzBanner);
        recyclerView = findViewById(R.id.rv1);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void foodSuccess(BaseBean baseBean) {
        List<BaseBean.DataBean> data = baseBean.getData();
        shopAdapter = new ShopAdapter(R.layout.item_shop, data);
        recyclerView.setAdapter(shopAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        shopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void foodFailed(Throwable throwable) {

    }

    @Override
    protected void injectCompoent() {
        DaggerHomeComponent.builder().fragmentComponent(fragmentComponent)
                .homeModule(new HomeModule(this))
                .build().injectFragment(this);
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        inflate = inflater.inflate(R.layout.fragment_main, container, false);
//        initView();
//        initData();

//        return inflate;
//    }

    private void recyView() {
        DiscountAdapter discountAdapter = new DiscountAdapter(R.layout.discount_item, ImageUrl.arrayList);
        rv.setAdapter(discountAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
    }

    private void pagerView() {
        for (int i = 0; i < b.length; i++) {
            list_b.add(b[i]);
        }
        fgHomeMzBanner.setPages(list_b, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
        fgHomeMzBanner.setIndicatorVisible(false);
    }

    public static class BannerViewHolder implements MZViewHolder<Integer>{
        ImageView imageView;
        @Override
        public View createView(Context context) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.mzview_item, null);
            imageView = inflate.findViewById(R.id.image_mzview);
            return inflate;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            imageView.setImageResource(data);
        }
    }

    private void gonggaoView() {
        titleList.add("新用户立减1000元优惠券");
        titleList.add("夏日炎炎，第一波福利还有30秒到达战场");
        titleList.add("平平淡淡，有你就好");
        mTextview.setTextList(titleList);
        mTextview.setText(15, 5, Color.GRAY);//设置属性
        mTextview.setTextStillTime(3000);//设置停留时长间隔
        mTextview.setAnimTime(200);//设置进入和退出的时间间隔
//        mTextview.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Toast.makeText(getContext(), "点击了 : " + titleList.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
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
    public void onResume() {
        super.onResume();
        if (mTextview != null) {
            mTextview.startAutoScroll();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mTextview.stopAutoScroll();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        datalist.clear();
        list.clear();
        list_b.clear();
    }
}