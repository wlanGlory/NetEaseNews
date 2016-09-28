package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.TopicTopicBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.adapter.NewsEntertainmentRotateVpAdapter;
import com.wang.neteasenews.ui.adapter.TopicTopicAdapter;
import com.wang.neteasenews.utils.AllConstantValues;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 话题界面话题部分
 */
public class TopicTopicFragment extends AbsBaseFragment {
    private ListView listView;
    private TopicTopicAdapter adapter;
    private List<TopicTopicBean.DataBean.SubjectListBean> datas;
    //===========================头布局===============================

    private static final int TIME = 3000;
    private ViewPager viewPager;
    private LinearLayout pointTl;
    private NewsEntertainmentRotateVpAdapter vpAdapter;
    private TextView titleTv;
    private ImageView Iv;

    //==========================================================


    public static TopicTopicFragment newInstance() {

        Bundle args = new Bundle();

        TopicTopicFragment fragment = new TopicTopicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_chosen;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.chosen_listview);
        adapter = new TopicTopicAdapter(context);
        listView.setAdapter(adapter);
        //======================================================
        View headView = LayoutInflater.from(context).inflate(R.layout.activity_topic_topic_loopview, null);

        viewPager = (ViewPager) headView.findViewById(R.id.rotate_vp);
        pointTl = (LinearLayout) headView.findViewById(R.id.rotate_point_container);
        titleTv = (TextView) headView.findViewById(R.id.head_list_title);
        Iv = (ImageView) headView.findViewById(R.id.head_list_img);


        // 在此处添加对头布局或者布局内的组件的设置
        listView.addHeaderView(headView);




        //======================================================

    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().setRequset(AllConstantValues.TOPICTOPICURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                TopicTopicBean bean = gson.fromJson(resultStr,TopicTopicBean.class);
                TopicTopicBean.DataBean beanList = bean.getData();
                datas = beanList.getSubjectList();
                adapter.setDatas(datas);


            }

            @Override
            public void failure() {

            }
        });

    }
}
