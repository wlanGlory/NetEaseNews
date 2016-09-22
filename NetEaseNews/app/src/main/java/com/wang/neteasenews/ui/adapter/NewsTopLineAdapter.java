package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsChosenBean;
import com.wang.neteasenews.model.bean.NewsTopLineBean;
import com.wang.neteasenews.utils.ScreenSizeUtil;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 头条适配器类
 */
public class NewsTopLineAdapter extends BaseAdapter {
    private Context context;
    private List<NewsTopLineBean.T1348647909107Bean> datas;


    public NewsTopLineAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsTopLineBean.T1348647909107Bean> datas) {
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

        ChosenViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_topline, parent, false);
            holder = new ChosenViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ChosenViewHolder) convertView.getTag();
        }
        NewsTopLineBean.T1348647909107Bean bean = datas.get(position);
        if (bean != null) {
            holder.titleTv.setText(bean.getTitle());
            Picasso.with(context).load(bean.getImgsrc()).resize(width/4,height/8).into(holder.imgIv);
            holder.sourceTv.setText(bean.getSource());
            if(bean.getReplyCount()!= 0){
                holder.commentTv.setText(bean.getReplyCount()+"跟帖");
            }

        }
        return convertView;
    }

    /**
     * 左侧一小图行布局缓存类
     */

    private class ChosenViewHolder {
        TextView titleTv;
        ImageView imgIv;
        TextView sourceTv;
        TextView commentTv;

        public ChosenViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.topline_title);
            imgIv = (ImageView) view.findViewById(R.id.topline_img);
            sourceTv = (TextView) view.findViewById(R.id.topline_source);
            commentTv = (TextView) view.findViewById(R.id.topline_comment);
        }
    }

}
