package com.wang.neteasenews.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.wang.neteasenews.R;
import com.wang.neteasenews.ui.activity.LoginInfoActivtiy;
import com.wang.neteasenews.ui.adapter.TopicAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 话题界面
 */
public class TopicFragment extends AbsBaseFragment implements View.OnClickListener {
    private TabLayout topicTl;
    private ViewPager topicVp;
    private List<Fragment> datas;
    private TopicAdapter topicAdapter;
    private ImageView loginImg;

    public static TopicFragment newInstance() {

        Bundle args = new Bundle();

        TopicFragment fragment = new TopicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void initViews() {
        topicTl = byView(R.id.topic_tl);
        topicVp = byView(R.id.topic_vp);
        loginImg = byView(R.id.topic_login);
        loginImg.setOnClickListener(this);

        datas = new ArrayList<>();
        datas.add(TopicQuestionFragment.newInstance());
        datas.add(TopicTopicFragment.newInstance());
        datas.add(TopicFocusFragment.newInstance());


    }

    @Override
    protected void initDatas() {
        FragmentManager fm = getChildFragmentManager();
        topicAdapter = new TopicAdapter(fm, datas);
        topicVp.setAdapter(topicAdapter);
        topicTl.setupWithViewPager(topicVp);
        topicTl.getTabAt(0).setText("问吧");
        topicTl.getTabAt(1).setText("话题");
        topicTl.getTabAt(2).setText("关注");

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(),LoginInfoActivtiy.class));
    }
}
