package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsChosenBean;
import com.wang.neteasenews.model.bean.NewsFinanceBean;
import com.wang.neteasenews.ui.fragment.NewsFinanceFragment;

import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * 新闻界面财经适配器
 */
public class NewsFinanceAdapter extends BaseAdapter{
    private Context context;
    private List<NewsFinanceBean.T1348648756099Bean> datas;

    public NewsFinanceAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsFinanceBean.T1348648756099Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsFinanceViewHolder holder = null;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_topline, parent, false);
            holder = new NewsFinanceViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (NewsFinanceViewHolder) convertView.getTag();
        }
        NewsFinanceBean.T1348648756099Bean bean = datas.get(position);
        if (bean != null) {
            holder.titleTv.setText(bean.getTitle());
            Picasso.with(context).load(bean.getImgsrc()).into(holder.imgIv);
            holder.sourceTv.setText(bean.getSource());

        }
        return convertView;
    }



    private class NewsFinanceViewHolder {
        TextView titleTv;
        ImageView imgIv;
        TextView sourceTv;

        public NewsFinanceViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.topline_title);
            imgIv = (ImageView) view.findViewById(R.id.topline_img);
            sourceTv = (TextView) view.findViewById(R.id.topline_source);
        }
    }
}
