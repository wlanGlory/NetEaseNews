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
import com.wang.neteasenews.model.bean.NewsSportsBean;
import com.wang.neteasenews.ui.fragment.NewsChosenFragment;
import com.wang.neteasenews.utils.ScreenSizeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 精选适配器类
 */
public class ChosenAdapter extends BaseAdapter {
    private Context context;
    private List<NewsChosenBean.T1467284926140Bean> datas;


    private static final int TYPE_ONE_IMG_LEFT = 0;
    private static final int TYPE_ONE_IMG = 1;
    private static final int TYPE_THREE_IMG = 2;
    private static final int TYPE_HEAD_IMG = 3;

    public ChosenAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<NewsChosenBean.T1467284926140Bean> datas) {
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
    public int getItemViewType(int position) {
        if (datas.get(position).getOrder() == 1) {
            return TYPE_HEAD_IMG;
        } else if (null != datas.get(position).getSkipType() && "photoset".equals(datas.get(position).getSkipType())) {

            return TYPE_THREE_IMG;
        }
//        if (datas.get(position).getImgextra()!=null) {
//            return TYPE_THREE_IMG;
//        }
        else if (datas.get(position).getImgType() == 1) {

            return TYPE_ONE_IMG;

        } else {

            return TYPE_ONE_IMG_LEFT;
        }

    }


    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int width = ScreenSizeUtil.getScreenWidth(context);
        int height = ScreenSizeUtil.getScreenHeight(context);
        ChosenViewHolder holder = null;
        ChosenOneViewHolder oneHolder = null;
        ChosenThreeViewHolder threeHolder = null;
        ChosenHeadViewHolder headViewHolder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_ONE_IMG_LEFT:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_topline, parent, false);
                    holder = new ChosenViewHolder(convertView);
                    convertView.setTag(holder);
                    break;
                case TYPE_ONE_IMG:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_topline_two, parent, false);
                    oneHolder = new ChosenOneViewHolder(convertView);
                    convertView.setTag(oneHolder);
                    break;
                case TYPE_THREE_IMG:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_topline_three, parent, false);
                    threeHolder = new ChosenThreeViewHolder(convertView);
                    convertView.setTag(threeHolder);
                    break;
                case TYPE_HEAD_IMG:
                    convertView = LayoutInflater.from(context).inflate(R.layout.head_list, parent, false);
                    headViewHolder = new ChosenHeadViewHolder(convertView);
                    convertView.setTag(headViewHolder);
                    break;

            }
        } else {
            switch (type) {
                case TYPE_ONE_IMG_LEFT:
                    holder = (ChosenViewHolder) convertView.getTag();
                    break;
                case TYPE_ONE_IMG:
                    oneHolder = (ChosenOneViewHolder) convertView.getTag();
                    break;
                case TYPE_THREE_IMG:
                    threeHolder = (ChosenThreeViewHolder) convertView.getTag();
                    break;
                case TYPE_HEAD_IMG:
                    headViewHolder = (ChosenHeadViewHolder) convertView.getTag();
            }

        }
        NewsChosenBean.T1467284926140Bean bean = datas.get(position);
//        Log.d("ChosenAdapter", ""+bean.getReplyCount());


        switch (type) {
            case TYPE_ONE_IMG_LEFT:
                holder.titleTv.setText(bean.getTitle());
                holder.commentTv.setText(bean.getReplyCount() + "跟帖");
                Picasso.with(context).load(bean.getImgsrc()).resize(width / 4, height / 8).into(holder.imgIv);
                holder.sourceTv.setText(bean.getSource());

                break;
            case TYPE_ONE_IMG:
                oneHolder.titleTv.setText(bean.getTitle());
                Picasso.with(context).load(bean.getImgsrc()).into(oneHolder.imgIv);
                oneHolder.sourceTv.setText(bean.getSource());
                oneHolder.commentTv.setText(bean.getReplyCount()+"跟帖");
                break;
            case TYPE_THREE_IMG:
                threeHolder.titleTv.setText(bean.getTitle());
                Picasso.with(context).load(bean.getImgsrc()).resize(width / 3, height / 6).into(threeHolder.imgIv);
                if (!bean.getImgextra().get(0).getImgsrc().isEmpty()) {
                    Picasso.with(context).load(bean.getImgextra().get(0).getImgsrc()).resize(width / 3, height / 6).into(threeHolder.iv1);
                }
                if (!bean.getImgextra().get(1).getImgsrc().isEmpty()) {

                    Picasso.with(context).load(bean.getImgextra().get(1).getImgsrc()).resize(width / 3, height / 6).into(threeHolder.iv2);
                }
                threeHolder.sourceTv.setText(bean.getSource());
                threeHolder.commentTv.setText(bean.getReplyCount()+"跟帖");
                break;
            case TYPE_HEAD_IMG:
                Picasso.with(context).load(bean.getImgsrc()).resize(width, height / 3).into(headViewHolder.headImg);
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

    /**
     * 中间一大图行布局缓存类
     */
    private class ChosenOneViewHolder {
        TextView titleTv;
        TextView sourceTv;
        ImageView imgIv;
        TextView commentTv;

        public ChosenOneViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.topline_two_title);
            sourceTv = (TextView) view.findViewById(R.id.topline_two_source);
            imgIv = (ImageView) view.findViewById(R.id.topline_two_img);
            commentTv = (TextView) view.findViewById(R.id.topline_two_comment);
        }
    }

    /**
     * 中间三小图行布局缓存类
     */
    private class ChosenThreeViewHolder {
        TextView titleTv;
        TextView sourceTv;
        ImageView imgIv, iv1, iv2;
        TextView commentTv;

        public ChosenThreeViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.topline_three_title);
            sourceTv = (TextView) view.findViewById(R.id.topline_three_source);
            imgIv = (ImageView) view.findViewById(R.id.topline_three_img);
            iv1 = (ImageView) view.findViewById(R.id.topline_three_img1);
            iv2 = (ImageView) view.findViewById(R.id.topline_three_img2);
            commentTv = (TextView) view.findViewById(R.id.topline_three_comment);
        }
    }

    /**
     * 头布局
     */
    private class ChosenHeadViewHolder {
        ImageView headImg;

        public ChosenHeadViewHolder(View view) {
            headImg = (ImageView) view.findViewById(R.id.head_list_img);
        }
    }

}
