package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.TopicTopicBean;
import com.wang.neteasenews.utils.ScreenSizeUtil;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 话题界面话题适配器
 */
public class TopicTopicAdapter extends BaseAdapter {
    private List<TopicTopicBean.DataBean.SubjectListBean> datas;
    private Context context;
    private LayoutInflater inflater;
    private static final int TYPE_ZERO=0;
    private static final int TYPE_ONE=1;

    public TopicTopicAdapter(Context context) {
        this.context =context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<TopicTopicBean.DataBean.SubjectListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null?0:datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null?null:datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {

        int type  = datas.get(position).getType();
        if(type == 0){
            return TYPE_ZERO;
        }else {
            return TYPE_ONE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int width = ScreenSizeUtil.getScreenWidth(context);
        int height = ScreenSizeUtil.getScreenHeight(context);
        ZeroViewHolder zeroViewHolder = null;
        OneViewHolder oneViewHolder = null;
        int type = getItemViewType(position);
        if(convertView == null){
            switch (type){
                case TYPE_ZERO:
                    convertView = inflater.inflate(R.layout.item_topic_technology,parent,false);
                    zeroViewHolder = new ZeroViewHolder(convertView);
                    convertView.setTag(zeroViewHolder);
                    break;
                case TYPE_ONE:
                    convertView = inflater.inflate(R.layout.item_topic_live,parent,false);
                    oneViewHolder = new OneViewHolder(convertView);
                    convertView.setTag(oneViewHolder);
                    break;
            }
        }else {
            switch (type){
                case TYPE_ZERO:
                    zeroViewHolder = (ZeroViewHolder) convertView.getTag();
                    break;
                case TYPE_ONE:
                    oneViewHolder = (OneViewHolder) convertView.getTag();
                    break;
            }
        }
        // 设置行布局内容
        TopicTopicBean.DataBean.SubjectListBean bean = datas.get(position);
//        List<TopicTopicBean.DataBean.SubjectListBean> listBeen = bean.getTalkPicture();

        switch (type){
            case TYPE_ZERO:
                zeroViewHolder.titleTv.setText("#"+bean.getName()+"#");
                zeroViewHolder.sourceTv.setText(bean.getClassification());
                zeroViewHolder.commentTv.setText(bean.getConcernCount()+"关注");
                zeroViewHolder.focusTv.setText(bean.getTalkCount()+"讨论");
                zeroViewHolder.topicTv1.setText("\"\t"+bean.getTalkContent().get(0).getContent());
                zeroViewHolder.topicTv2.setText("\"\t"+bean.getTalkContent().get(1).getContent());
                Glide.with(context).load(bean.getTalkContent().get(0).getUserHeadPicUrl()).into(zeroViewHolder.img1);
                Glide.with(context).load(bean.getTalkContent().get(1).getUserHeadPicUrl()).into(zeroViewHolder.img2);

                break;
            case TYPE_ONE:
                oneViewHolder.titleTv.setText("#"+bean.getName()+"#");
                oneViewHolder.sourceTv.setText(bean.getClassification());
//                Picasso.with(context).load(bean.getTalkPicture().get(0).toString()).resize(width/3,height/4).into(oneViewHolder.img1);
//                Picasso.with(context).load(bean.getTalkPicture().get(1).toString()).resize(width/3,height/4).into(oneViewHolder.img1);
//                Picasso.with(context).load(bean.getTalkPicture().get(2).toString()).resize(width/3,height/4).into(oneViewHolder.img1);
                Glide.with(context).load(bean.getTalkPicture().get(0)).override(width/6,height/8).into(oneViewHolder.img2);
                Glide.with(context).load(bean.getTalkPicture().get(1)).override(width/6,height/8).into(oneViewHolder.img2);
                Glide.with(context).load(bean.getTalkPicture().get(2)).override(width/6,height/8).into(oneViewHolder.img3);
                oneViewHolder.focusTv.setText(bean.getConcernCount()+"关注");
                oneViewHolder.commentTv.setText(bean.getTalkCount()+"讨论");

                break;
        }

        return convertView;
    }




    class ZeroViewHolder{

        TextView titleTv,sourceTv;
        TextView topicTv1,topicTv2;
        ImageView img1,img2;
        TextView commentTv,focusTv;
        public ZeroViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.topic_tech_title);
            sourceTv = (TextView) view.findViewById(R.id.topic_tech_source);
            img1 = (ImageView) view.findViewById(R.id.topic_tech_img1);
            img2 = (ImageView) view.findViewById(R.id.topic_tech_img2);
            commentTv = (TextView) view.findViewById(R.id.topic_tech_comment);
            focusTv = (TextView) view.findViewById(R.id.topic_tech_focus);
            topicTv1 = (TextView) view.findViewById(R.id.topic_tech_img1_tv);
            topicTv2 = (TextView) view.findViewById(R.id.topic_tech_img2_tv);
        }
    }
    class OneViewHolder{
        TextView titleTv,sourceTv;
        ImageView img1,img2,img3;
        TextView focusTv,commentTv;
        public OneViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.topic_live_title);
            sourceTv = (TextView) view.findViewById(R.id.topic_live_source);
            img1 = (ImageView) view.findViewById(R.id.topic_live_img1);
            img2 = (ImageView) view.findViewById(R.id.topic_live_img2);
            img3 = (ImageView) view.findViewById(R.id.topic_live_img3);
            focusTv = (TextView) view.findViewById(R.id.topic_live_focus);
            commentTv = (TextView) view.findViewById(R.id.topic_live_comment);
        }

    }


}
