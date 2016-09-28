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
import com.wang.neteasenews.model.bean.TopicTopicBean;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 * 话题界面话题部分ViewPager适配器
 */
public class TopicTopicVpAdapter extends PagerAdapter{
    private List<TopicTopicBean.DataBean.SubjectListBean>datas;
    private Context context;
    private LayoutInflater inflater;

    public TopicTopicVpAdapter(List<TopicTopicBean.DataBean.SubjectListBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    public TopicTopicVpAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setDatas(List<TopicTopicBean.DataBean.SubjectListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        int newPosition = position % datas.size();
//        View convertView = inflater.inflate(R.layout.item_loopview_vp, container, false);
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_iv);
//        TextView textView = (TextView) convertView.findViewById(R.id.item_tv);
//        if (position%5 == 0) {
//            Picasso.with(context).load(datas.get(position).ge).into(imageView);
//            textView.setText(datas.get(0).getTitle());
//        } else {
//            Picasso.with(context).load(datas.get(0).getAds().get(0).getImgsrc()).into(imageView);
//            textView.setText(datas.get(0).getAds().get(0).getTitle());
//        }
//        container.addView(convertView);
//        return convertView;



        return super.instantiateItem(container, position);

    }

}
