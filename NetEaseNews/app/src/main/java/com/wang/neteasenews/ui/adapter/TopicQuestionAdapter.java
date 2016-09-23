package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.TopicQuestionBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/22.
 * 话题界面问吧适配器
 */
public class TopicQuestionAdapter extends BaseAdapter{
    private List<TopicQuestionBean.DataBean.ExpertListBean> datas;
    private Context context;
    private LayoutInflater inflater;
    private static final int TYPEZERO = 0;
    private static final int TYPEONE = 1;

    public TopicQuestionAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<TopicQuestionBean.DataBean.ExpertListBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas ==null ? 0 : datas.size();
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
        int state = datas.get(position).getState();
        if(state == 1){
            return TYPEONE;
        }else {
            return TYPEZERO;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OneViewHolder holder = null;
        int state = getItemViewType(position);

        if(convertView == null){
            switch (state){
                case TYPEONE:
                    convertView = inflater.inflate(R.layout.item_topic_question,parent,false);
                    holder =new OneViewHolder(convertView);
                    convertView.setTag(holder);
                    break;
            }

        }else {
            switch (state){
                case TYPEONE:
                    holder = (OneViewHolder) convertView.getTag();
                    break;
            }
        }
        TopicQuestionBean.DataBean.ExpertListBean bean = datas.get(position);
        switch (state){
            case TYPEONE:
                holder.titleTv.setText(bean.getName());
                holder.sourceTv.setText(bean.getClassification());
                holder.askTv.setText(bean.getAnswerCount()+"提问");
                holder.commentTv.setText(bean.getConcernCount()+"关注");
                holder.authorTv.setText(bean.getTitle());
                holder.contentTv.setText(bean.getAlias());
                Glide.with(context).load(bean.getPicurl()).into(holder.middleImg);
                Glide.with(context).load(bean.getHeadpicurl()).into(holder.circleImg);

                break;
        }

        return convertView;
    }

    class OneViewHolder{
        TextView titleTv,commentTv,askTv,sourceTv,contentTv,authorTv;
        ImageView circleImg,middleImg;
        public OneViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.topic_ques_title);
            commentTv = (TextView) view.findViewById(R.id.topic_ques_comment);
            askTv = (TextView) view.findViewById(R.id.topic_ques_ask);
            sourceTv = (TextView) view.findViewById(R.id.topic_ques_source);
            circleImg = (CircleImageView) view.findViewById(R.id.topic_ques_circle);
            middleImg = (ImageView) view.findViewById(R.id.topic_ques_middle);
            contentTv = (TextView) view.findViewById(R.id.topic_ques_content);
            authorTv = (TextView) view.findViewById(R.id.topic_ques_author);
        }
    }


}
