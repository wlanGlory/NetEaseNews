package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsEntertainmentLoopViewBean;

import java.util.List;

/**
 * Created by dllo on 16/9/20.
 * 新闻界面娱乐部分轮播图适配器
 */
public class NewsEntertainmentLoopViewAdapter extends PagerAdapter{
    private List<NewsEntertainmentLoopViewBean> list;
    private Context context;

    public NewsEntertainmentLoopViewAdapter(List<NewsEntertainmentLoopViewBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_loopview,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.loop_image);
        Picasso.with(context).load(list.get(position).getImageUrl()).centerCrop().into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
