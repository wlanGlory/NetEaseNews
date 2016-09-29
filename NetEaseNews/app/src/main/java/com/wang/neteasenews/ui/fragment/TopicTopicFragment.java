package com.wang.neteasenews.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.TopicTopicBean;
import com.wang.neteasenews.model.bean.TopicTopicHeaderBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.activity.AbsBaseActivity;
import com.wang.neteasenews.ui.activity.NewsChosenInfoActivity;
import com.wang.neteasenews.ui.adapter.TopicTopicAdapter;
import com.wang.neteasenews.ui.adapter.TopicTopicHeaderAdapter;
import com.wang.neteasenews.utils.AllConstantValues;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 话题界面话题部分
 */
public class TopicTopicFragment extends AbsBaseFragment {
    private ListView listView;
    private TopicTopicAdapter adapter;
    private RecyclerView recyclerView;


    private List<TopicTopicBean.DataBean.SubjectListBean> datas;



    //===========================头布局===============================
    private TopicTopicHeaderAdapter headerAdapter;
    //================
//    private static final int TIME = 3000;
//    private ViewPager viewPager;
//    private LinearLayout pointTl;
//    private NewsEntertainmentRotateVpAdapter vpAdapter;
//    private TextView titleTv;
//    private ImageView Iv;

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

        //===========================================
//        headerAdapter = new TopicTopicHeaderAdapter(context);


        //======================================================
        View headView = LayoutInflater.from(context).inflate(R.layout.fragment_topicdouble_header, null);
        headerAdapter = new TopicTopicHeaderAdapter(context);
        recyclerView = (RecyclerView) headView.findViewById(R.id.topic_header_rl);
        recyclerView.setAdapter(headerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        VolleyInstance.getInstance().setRequset(AllConstantValues.TOPICTOPICVIEWPAGERURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                TopicTopicHeaderBean bean = gson.fromJson(resultStr,TopicTopicHeaderBean.class);
                List<TopicTopicHeaderBean.话题Bean> beanList = bean.get话题();
                headerAdapter.setDatas(beanList);

            }

            @Override
            public void failure() {

            }
        });
//        viewPager = (ViewPager) headView.findViewById(R.id.rotate_vp);
//        pointTl = (LinearLayout) headView.findViewById(R.id.rotate_point_container);
//        titleTv = (TextView) headView.findViewById(R.id.head_list_title);
//        Iv = (ImageView) headView.findViewById(R.id.head_list_img);

//        headerAdapter.setDatas(beanList);
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
