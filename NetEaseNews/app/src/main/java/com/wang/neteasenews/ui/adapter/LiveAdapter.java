package com.wang.neteasenews.ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.LiveBean;
import com.wang.neteasenews.utils.ScreenSizeUtil;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 直播界面适配器
 */
public class LiveAdapter extends BaseAdapter {
    private List<LiveBean.T1462958418713Bean> datas;
//    private List<LiveBean.T1462958418713Bean.LiveInfoBean> datasInfo;
    private Context context;

    public LiveAdapter(Context context) {
        this.context = context;
    }

//    public void setDatasInfo(List<LiveBean.T1462958418713Bean.LiveInfoBean> datasInfo) {
//        this.datasInfo = datasInfo;
//        notifyDataSetChanged();
//    }

    public void setDatas(List<LiveBean.T1462958418713Bean> datas) {
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
        int width = ScreenSizeUtil.getScreenWidth(context);
        int height = ScreenSizeUtil.getScreenHeight(context);
        LiveViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_live, parent, false);
            holder = new LiveViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (LiveViewHolder) convertView.getTag();
        }

        LiveBean.T1462958418713Bean bean = datas.get(position);
//        LiveBean.T1462958418713Bean.LiveInfoBean infoBean = datasInfo.get(position);
        if (bean != null) {
//            holder.titleTv.setText(bean.getTitle());

            Picasso.with(context).load(bean.getImgsrc()).resize(width,height/4).into(holder.imgIv);
            holder.sourceTv.setText(bean.getSource());
            holder.tagTv.setText(bean.getTAGS());
//            holder.ptimeTv.setText(bean.getSkipType());
        }
        return convertView;
    }


    private class LiveViewHolder {
        TextView titleTv;
        ImageView imgIv;
        TextView sourceTv;
        TextView tagTv;
        TextView ptimeTv;

        public LiveViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.live_title);
            imgIv = (ImageView) view.findViewById(R.id.live_img);
            sourceTv = (TextView) view.findViewById(R.id.live_source_tv);
            tagTv = (TextView) view.findViewById(R.id.live_review_tv);
            ptimeTv = (TextView) view.findViewById(R.id.live_date_tv);
        }
    }
}
