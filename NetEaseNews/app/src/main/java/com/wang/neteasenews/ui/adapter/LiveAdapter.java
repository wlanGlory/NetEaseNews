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
    private List<LiveBean> datas;
    private Context context;

    public LiveAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<LiveBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


}
