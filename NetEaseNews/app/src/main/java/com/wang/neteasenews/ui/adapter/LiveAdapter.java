package com.wang.neteasenews.ui.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.neteasenews.model.bean.LiveBean;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 */
public class LiveAdapter extends BaseAdapter{
    private List<LiveBean.T1462958418713Bean> datas;
    private Context context;

    public LiveAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<LiveBean.T1462958418713Bean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas==null?null:datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


    private class LiveViewHolder{

    }
}
