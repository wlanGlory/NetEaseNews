package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wang.neteasenews.R;
import com.wang.neteasenews.interfaces.OnRvItemClick;
import com.wang.neteasenews.interfaces.OnRvItemLongClick;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻界面PopWindow 适配器
 */
public class PopWindowAdapter extends RecyclerView.Adapter<PopWindowAdapter.PopViewHolder>{
    private Context context;
    private List<String> datas;

    //=================================================================
    // 定义长按点击接口对象
    private OnRvItemLongClick onRvItemLongClick;
    // 提供set方法
    public void setOnRvItemLongClick(OnRvItemLongClick onRvItemLongClick) {
        this.onRvItemLongClick = onRvItemLongClick;
    }
    //=================================================================


    //=================================================================
    // 定义点击接口对象
    OnRvItemClick onRvItemClick;
    // 提供set方法
    public void setOnRvItemClick(OnRvItemClick onRvItemClick) {
        this.onRvItemClick = onRvItemClick;

    }
    //=================================================================

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
    public void onBindViewHolder(final PopViewHolder holder, final int position) {
        holder.textView.setText(datas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  判断自定义点击接口不为空
                if(onRvItemClick != null){
                    // 获取当前行布局的position
                    int p = holder.getLayoutPosition();
                    // 获取当前行布局的数据
                    String str = datas.get(position);
                    // 将数据存储到接口对象中
                    // 回调接口方法-发出命令-执行OnItemClickListener
                    onRvItemClick.onRvItemClickListener(p,str);
//                    if(position ==0){
//                        newsTl.getTabAt(0).isSelected();
//                    }

                }
            }
        });


        //=============================长按点击事件===================================
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onRvItemLongClick != null){
                    int p =holder.getLayoutPosition();
                    String str = datas.get(position);
                    onRvItemLongClick.onItemLongClick(p,str);
                }
                // 是否消耗本次触摸屏幕事件
                // true-->到此结束,不会触发短按点击
                // false-->到此不结束,会触发短按点击
                return false;
            }
        });

        //=========================================================================
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
