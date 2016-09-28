package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;

import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.UserBean;
import com.wang.neteasenews.ui.adapter.UserAdapter;
import com.wang.neteasenews.ui.app.NetEaseNewsApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 用户中心(我)界面
 */
public class UserFragment extends AbsBaseFragment {
    private List<UserBean> datas;
//    private UserAdapter userAdpter;
//    private ListView listView;

    public static UserFragment newInstance() {

        Bundle args = new Bundle();

        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_person;

    }

    @Override
    protected void initViews() {
//        listView = byView(R.id.user_listview);
//        buildDatas();
    }

    private void buildDatas() {
        datas = new ArrayList<>();
        datas.add(new UserBean(R.mipmap.user_msg, "我的消息"));
        datas.add(new UserBean(R.mipmap.user_goldstore, "金币商城"));
        datas.add(new UserBean(R.mipmap.user_goldtask, "金币任务"));
        datas.add(new UserBean(R.mipmap.user_mypurse, "我的钱包"));
        datas.add(new UserBean(R.mipmap.user_night, "夜间模式"));
        datas.add(new UserBean(R.mipmap.user_offline_read, "离线阅读"));
        datas.add(new UserBean(R.mipmap.user_squre, "活动广场"));
        datas.add(new UserBean(R.mipmap.user_opinion, "意见反馈"));
    }

    @Override
    protected void initDatas() {
//        userAdpter = new UserAdapter(NetEaseNewsApp.getContext());
//        userAdpter.setDatas(datas);
//        listView.setAdapter(userAdpter);


    }
}
