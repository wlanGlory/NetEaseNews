package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsEntertainmentBean;
import com.wang.neteasenews.model.bean.NewsSportsBean;

import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 新闻界面娱乐部分轮播适配器
 */
public class NewsEntertainmentRotateVpAdapter extends PagerAdapter {
    private List<NewsEntertainmentBean.T1348648517839Bean> datas;
    private Context context;
    private LayoutInflater inflater;

    public NewsEntertainmentRotateVpAdapter(List<NewsEntertainmentBean.T1348648517839Bean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public NewsEntertainmentRotateVpAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<NewsEntertainmentBean.T1348648517839Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        // 为了让ViewPager到最后一页不会像翻书一样回到第一页
        // 设置页数为int最大值,这样向下滑动永远都是下一页
        return datas == null ? 0 : Integer.MAX_VALUE;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // position是int最大值所以这里可能是几百甚至上千,因此取余避免数组越界
        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_loopview_vp, container, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_iv);
        TextView textView = (TextView) convertView.findViewById(R.id.item_tv);
        if (position%2 == 0) {
            Picasso.with(context).load(datas.get(0).getImgsrc()).into(imageView);
            textView.setText(datas.get(0).getTitle());
        } else {
            Picasso.with(context).load(datas.get(0).getAds().get(0).getImgsrc()).into(imageView);
            textView.setText(datas.get(0).getAds().get(0).getTitle());
        }
        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
