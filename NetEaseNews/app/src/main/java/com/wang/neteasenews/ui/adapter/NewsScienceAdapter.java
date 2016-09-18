//package com.wang.neteasenews.ui.adapter;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.squareup.picasso.Picasso;
//import com.wang.neteasenews.R;
//import com.wang.neteasenews.model.bean.NewsChosenBean;
//import com.wang.neteasenews.model.bean.NewsScienceBean;
//
//import java.util.List;
//
///**
// * Created by dllo on 16/9/14.
// * 科技适配器类
// */
public class NewsScienceAdapter{
//    private Context context;
//    private List<NewsScienceBean.AdsBean> datas;
//
//    private static final int TYPE_ONE_IMG_LEFT = 0;
//    private static final int TYPE_ONE_IMG = 1;
//    private static final int TYPE_THREE_IMG = 2;
//    private static final int TYPE_HEAD_IMG = 3;
//
//    public NewsScienceAdapter(Context context) {
//        this.context = context;
//    }
//
//    public void setDatas(List<NewsScienceBean.AdsBean> datas) {
//        this.datas = datas;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public int getCount() {
//        return datas == null ? 0 : datas.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return datas == null ? null : datas.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if(datas.get(position).getOrder() == 1){
//            return TYPE_HEAD_IMG;
//        }
//       else if (null != datas.get(position).getSkipType() && "photoset".equals(datas.get(position).getSkipType())) {
//            Log.d("zzz", "三张图片");
//            return TYPE_THREE_IMG;
//        }
////        if (datas.get(position).getImgextra()!=null) {
////            return TYPE_THREE_IMG;
////        }
//        else if (datas.get(position).getImgType() == 1) {
//
//            return TYPE_ONE_IMG;
//
//        } else {
//            Log.d("zzz", "左侧图片");
//            return TYPE_ONE_IMG_LEFT;
//        }
//
//    }
//
//
//    @Override
//    public int getViewTypeCount() {
//        return 4;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ChosenViewHolder holder = null;
//        ChosenOneViewHolder oneHolder = null;
//        ChosenThreeViewHolder threeHolder = null;
//        ChosenHeadViewHolder headViewHolder = null;
//        int type = getItemViewType(position);
//        if (convertView == null) {
//            switch (type) {
//                case TYPE_ONE_IMG_LEFT:
//                    convertView = LayoutInflater.from(context).inflate(R.layout.item_topline, parent, false);
//                    holder = new ChosenViewHolder(convertView);
//                    convertView.setTag(holder);
//                    break;
//                case TYPE_ONE_IMG:
//                    convertView = LayoutInflater.from(context).inflate(R.layout.item_topline_two, parent, false);
//                    oneHolder = new ChosenOneViewHolder(convertView);
//                    convertView.setTag(oneHolder);
//                    break;
//                case TYPE_THREE_IMG:
//                    convertView = LayoutInflater.from(context).inflate(R.layout.item_topline_three, parent, false);
//                    threeHolder = new ChosenThreeViewHolder(convertView);
//                    convertView.setTag(threeHolder);
//                    break;
//                case TYPE_HEAD_IMG:
//                    convertView = LayoutInflater.from(context).inflate(R.layout.head_list,parent,false);
//                    headViewHolder = new ChosenHeadViewHolder(convertView);
//                    convertView.setTag(headViewHolder);
//                    break;
//
//            }
//        } else {
//            switch (type) {
//                case TYPE_ONE_IMG_LEFT:
//                    holder = (ChosenViewHolder) convertView.getTag();
//                    break;
//                case TYPE_ONE_IMG:
//                    oneHolder = (ChosenOneViewHolder) convertView.getTag();
//                    break;
//                case TYPE_THREE_IMG:
//                    threeHolder = (ChosenThreeViewHolder) convertView.getTag();
//                    break;
//                case TYPE_HEAD_IMG:
//                    headViewHolder = (ChosenHeadViewHolder) convertView.getTag();
//            }
//
//        }
//        NewsScienceBean.AdsBean bean = datas.get(position);
//        switch (type) {
//            case TYPE_ONE_IMG_LEFT:
//                holder.titleTv.setText(bean.getTitle());
//                Picasso.with(context).load(bean.getImgsrc()).into(holder.imgIv);
////                holder.sourceTv.setText(bean.getSource());
//                break;
//            case TYPE_ONE_IMG:
//                oneHolder.titleTv.setText(bean.getTitle());
//                Picasso.with(context).load(bean.getImgsrc()).into(oneHolder.imgIv);
////                oneHolder.sourceTv.setText(bean.getSource());
//                break;
//            case TYPE_THREE_IMG:
//                threeHolder.titleTv.setText(bean.getTitle());
//                Picasso.with(context).load(bean.getImgsrc()).into(threeHolder.imgIv);
//                if (!bean.getImgextra().get(0).getImgsrc().isEmpty()) {
//                    Picasso.with(context).load(bean.getImgextra().get(0).getImgsrc()).into(threeHolder.iv1);
//                }
//                if (!bean.getImgextra().get(1).getImgsrc().isEmpty()) {
//
//                    Picasso.with(context).load(bean.getImgextra().get(1).getImgsrc()).into(threeHolder.iv2);
//                }
////                threeHolder.sourceTv.setText(bean.getSource());
//                break;
//            case TYPE_HEAD_IMG:
//                Picasso.with(context).load(bean.getImgsrc()).into(headViewHolder.headImg);
//        }
//
////        if (convertView == null) {
////
////            convertView = LayoutInflater.from(context).inflate(R.layout.item_topline, parent, false);
////            holder = new ChosenViewHolder(convertView);
////            convertView.setTag(holder);
////        } else {
////            holder = (ChosenViewHolder) convertView.getTag();
////        }
////        NewsChosenBean.T1467284926140Bean bean = datas.get(position);
////        if (bean != null) {
////            holder.titleTv.setText(bean.getTitle());
////            Picasso.with(context).load(bean.getImgsrc()).into(holder.imgIv);
////            holder.sourceTv.setText(bean.getSource());
////
////        }
//        return convertView;
//    }
//
//    /**
//     * 左侧一小图行布局缓存类
//     */
//
//    private class ChosenViewHolder {
//        TextView titleTv;
//        ImageView imgIv;
//        TextView sourceTv;
//
//        public ChosenViewHolder(View view) {
//            titleTv = (TextView) view.findViewById(R.id.topline_title);
//            imgIv = (ImageView) view.findViewById(R.id.topline_img);
//            sourceTv = (TextView) view.findViewById(R.id.topline_source);
//        }
//    }
//
//    /**
//     * 中间一大图行布局缓存类
//     */
//    private class ChosenOneViewHolder {
//        TextView titleTv;
//        TextView sourceTv;
//        ImageView imgIv;
//
//        public ChosenOneViewHolder(View view) {
//            titleTv = (TextView) view.findViewById(R.id.topline_two_title);
//            sourceTv = (TextView) view.findViewById(R.id.topline_source);
//            imgIv = (ImageView) view.findViewById(R.id.topline_two_img);
//        }
//    }
//
//    /**
//     * 中间三小图行布局缓存类
//     */
//    private class ChosenThreeViewHolder {
//        TextView titleTv;
//        TextView sourceTv;
//        ImageView imgIv, iv1, iv2;
//
//        public ChosenThreeViewHolder(View view) {
//            titleTv = (TextView) view.findViewById(R.id.topline_three_title);
//            sourceTv = (TextView) view.findViewById(R.id.topline_source);
//            imgIv = (ImageView) view.findViewById(R.id.topline_three_img);
//            iv1 = (ImageView) view.findViewById(R.id.topline_three_img1);
//            iv2 = (ImageView) view.findViewById(R.id.topline_three_img2);
//        }
//    }
//
//    /**
//     * 头布局
//     */
//    private class ChosenHeadViewHolder{
//        ImageView headImg;
//        public ChosenHeadViewHolder(View view) {
//            headImg = (ImageView) view.findViewById(R.id.head_list_img);
//        }
//    }
//
}
