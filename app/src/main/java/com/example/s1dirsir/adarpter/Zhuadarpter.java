package com.example.s1dirsir.adarpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.s1dirsir.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @ClassName Zhuadarpter
 * @Description TODO
 * @Author 梁波
 * @Date 2021/9/14 9:16
 * @Version 1.0
 */
public class Zhuadarpter extends PagerAdapter {
    List<Integer> integers;
    private Context context;

    public Zhuadarpter(Context context,List<Integer> integers) {
        this.context = context;
        this.integers = integers;
    }

    @Override
    public int getCount() {
        return integers.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        View inflate = View.inflate(context, R.layout.zhuitem, null);
        ImageView imageView = inflate.findViewById(R.id.zhu_im);
        imageView.setImageResource(integers.get(position));
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((View) object);
    }
}
