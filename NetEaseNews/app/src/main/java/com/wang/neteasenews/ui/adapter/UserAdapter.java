package com.wang.neteasenews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.UserBean;

import java.util.List;

/**
 * Created by dllo on 16/9/13.
 * 用户中心(我)适配器
 */
public class UserAdapter extends BaseAdapter {
    private List<UserBean> datas;
    private Context context;

    public UserAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<UserBean> datas) {
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
        UserViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
            holder = new UserViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (UserViewHolder) convertView.getTag();
        }
        UserBean userBean = (UserBean) getItem(position);
        holder.userTv.setText(userBean.getContent());
        holder.userImg.setImageResource(userBean.getImgId());
        return convertView;
    }


    class UserViewHolder {
        TextView userTv;
        ImageView userImg;

        public UserViewHolder(View view) {
            userImg = (ImageView) view.findViewById(R.id.item_user_iv);
            userTv = (TextView) view.findViewById(R.id.item_user_tv);
        }
    }
}
