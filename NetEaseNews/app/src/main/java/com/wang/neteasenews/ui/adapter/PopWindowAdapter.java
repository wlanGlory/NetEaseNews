package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wang.neteasenews.R;
import com.wang.neteasenews.interfaces.OnRvItemLongClick;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻界面PopWindow 适配器
 */
public class PopWindowAdapter extends RecyclerView.Adapter<PopWindowAdapter.PopViewHolder>{
    private Context context;
    private List<String> datas;

    // 定义长按点击接口对象
    private OnRvItemLongClick onRvItemLongClick;
    // 提供set方法
    public void setOnRvItemLongClick(OnRvItemLongClick onRvItemLongClick) {
        this.onRvItemLongClick = onRvItemLongClick;
    }

    public PopWindowAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public PopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.item_popwindow,parent,false);
        PopViewHolder popViewHolder = new PopViewHolder(view);

        return popViewHolder;
    }

    @Override
    public void onBindViewHolder(final PopViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onRvItemLongClick != null){
                    int position = holder.getLayoutPosition();
                    String str = datas.get(position);
                    onRvItemLongClick.onItemLongClick(position,str);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class PopViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public PopViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.popwindow_tv);
        }
    }
}
