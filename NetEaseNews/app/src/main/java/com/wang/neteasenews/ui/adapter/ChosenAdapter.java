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
import com.wang.neteasenews.model.bean.ChosenBean;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 精选适配器类
 */
public class ChosenAdapter extends BaseAdapter {
    private Context context;
    private List<ChosenBean.T1467284926140Bean> datas;

    public ChosenAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ChosenBean.T1467284926140Bean> datas) {
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
        ChosenViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_topline, parent, false);
            holder = new ChosenViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChosenViewHolder) convertView.getTag();
        }
        ChosenBean.T1467284926140Bean bean = datas.get(position);
        if (bean != null) {
            holder.titleTv.setText(bean.getTitle());
            Picasso.with(context).load(bean.getImgsrc()).into(holder.imgIv);

        }
        return convertView;
    }

    private class ChosenViewHolder {
        TextView titleTv;
        ImageView imgIv;

        public ChosenViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.topline_title);
            imgIv = (ImageView) view.findViewById(R.id.topline_img);
        }
    }
}
