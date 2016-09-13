package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.widget.ListView;

import com.wang.neteasenews.R;

/**
 * Created by dllo on 16/9/8.
 */
public class LiveFragment extends AbsBaseFragment {
    private String url = "http://c.m.163.com/nc/live/list/5YWo5Zu9/0-20.html";
    private ListView listview;


    public static LiveFragment newInstance() {
        
        Bundle args = new Bundle();
        
        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {

        return R.layout.fragment_live;
    }

    @Override
    protected void initViews() {
        listview = byView(R.id.live_lv);

    }

    @Override
    protected void initDatas() {

    }
}
