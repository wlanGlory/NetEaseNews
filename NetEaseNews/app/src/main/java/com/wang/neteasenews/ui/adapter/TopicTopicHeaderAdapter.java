package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.TopicTopicHeaderBean;
import com.wang.neteasenews.utils.ScreenSizeUtil;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 * 话题界面话题部分Header适配器
 */
public class TopicTopicHeaderAdapter extends RecyclerView.Adapter<TopicTopicHeaderAdapter.HeadViewHolder> {
    private List<TopicTopicHeaderBean.话题Bean> datas;
    private Context context;

    public TopicTopicHeaderAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<TopicTopicHeaderBean.话题Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }


    @Override
    public HeadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_topic_header,parent,false);
        HeadViewHolder holder = new HeadViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HeadViewHolder holder, int position) {
        int width = ScreenSizeUtil.getScreenWidth(context);
        int height = ScreenSizeUtil.getScreenHeight(context);

        holder.titleTv.setText("#"+datas.get(position).getTopicName()+"#");
        Picasso.with(context).load(datas.get(position).getPicUrl()).into(holder.img);
    }


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class HeadViewHolder extends RecyclerView.ViewHolder {
        TextView titleTv;
        ImageView img;

        public HeadViewHolder(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.topic_topic_header_title);
            img = (ImageView) itemView.findViewById(R.id.topic_topic_header_img);
        }
    }
}