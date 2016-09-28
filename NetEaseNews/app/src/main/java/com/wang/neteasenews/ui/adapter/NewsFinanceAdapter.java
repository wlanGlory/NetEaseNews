package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsChosenBean;
import com.wang.neteasenews.model.bean.NewsFinanceBean;
import com.wang.neteasenews.ui.fragment.NewsFinanceFragment;
import com.wang.neteasenews.utils.ScreenSizeUtil;

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
        int height = ScreenSizeUtil.getScreenHeight(context);
        int width = ScreenSizeUtil.getScreenWidth(context);
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
            int wan = 0;
            int qian = 0;
            int bai = 0;
            double replaycount = 0;
            holder.titleTv.setText(bean.getTitle());
            Glide.with(context).load(bean.getImgsrc()).override(width/4,height/8).into(holder.imgIv);
            holder.sourceTv.setText(bean.getSource());
            if(bean.getReplyCount() != 0){
                int count = bean.getReplyCount();
                if(count != 0 && count > 10000){
                    wan = count/10000;
                    qian = count%10000/1000;
                    bai = count%10000%1000/100;
                    if(bai >= 5){
                        int rqian = qian + 1;
                        if(rqian != 10){
                            replaycount = wan + rqian*0.1;
                            holder.commentTv.setText(replaycount+"万跟帖");
                        }else {
                            replaycount = wan+1;
                            holder.commentTv.setText(replaycount+"万跟帖");
                        }
                    }

                }else {
                    holder.commentTv.setText(count+"跟帖");
                }
//                holder.commentTv.setText(bean.getReplyCount()+"跟帖");
            }

        }
        return convertView;
    }



    private class NewsFinanceViewHolder {
        TextView titleTv;
        ImageView imgIv;
        TextView sourceTv;
        TextView commentTv;

        public NewsFinanceViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.topline_title);
            imgIv = (ImageView) view.findViewById(R.id.topline_img);
            sourceTv = (TextView) view.findViewById(R.id.topline_source);
            commentTv = (TextView) view.findViewById(R.id.topline_comment);
        }
    }
}
