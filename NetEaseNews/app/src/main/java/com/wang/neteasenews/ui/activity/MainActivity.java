package com.wang.neteasenews.ui.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wang.neteasenews.R;
import com.wang.neteasenews.ui.adapter.NewsAdapter;
import com.wang.neteasenews.ui.fragment.LiveFragment;
import com.wang.neteasenews.ui.fragment.NewsFragment;
import com.wang.neteasenews.ui.fragment.TopicFragment;
import com.wang.neteasenews.ui.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RadioGroup mainRg;
    private List<Fragment> datas;
    private NewsAdapter newsAdapter;
    private RadioButton newsRb, liveRb, topicRb, userRb;
    private TextView mainTv;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        datas = new ArrayList<>();
        datas.add(NewsFragment.newInstance());
        ft.replace(R.id.main_fl, NewsFragment.newInstance());
        ft.commit();
        initViews();


    }

    private void initViews() {

        newsRb = (RadioButton) findViewById(R.id.news_rb);
        liveRb = (RadioButton) findViewById(R.id.live_rb);
        topicRb = (RadioButton) findViewById(R.id.topic_rb);
        userRb = (RadioButton) findViewById(R.id.user_rb);
        mainTv = (TextView) findViewById(R.id.main_tv);
        mainRg = (RadioGroup) findViewById(R.id.main_rg);


        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                datas = new ArrayList<>();
                datas.add(NewsFragment.newInstance());
                datas.add(LiveFragment.newInstance());
                datas.add(TopicFragment.newInstance());
                datas.add(UserFragment.newInstance());
                switch (checkedId) {
                    case R.id.news_rb:
                        ft.replace(R.id.main_fl, NewsFragment.newInstance());
                        break;
                    case R.id.live_rb:
                        ft.replace(R.id.main_fl, LiveFragment.newInstance());
                        break;
                    case R.id.topic_rb:
                        ft.replace(R.id.main_fl, TopicFragment.newInstance());
                        break;
                    case R.id.user_rb:
                        ft.replace(R.id.main_fl, UserFragment.newInstance());
                        break;
                    default:
                        break;
                }
                ft.commit();
            }

        });


    }


}


//        viewPager = (ViewPager) findViewById(R.id.vp);
//        tabLayout = (TabLayout) findViewById(R.id.tab);
//        datas = new ArrayList<>();
//        datas.add(new NewsFragment());
//        datas.add(new NewsFragment());
//        datas.add(new NewsFragment());
//        datas.add(new NewsFragment());
//
//        newsAdapter = new NewsAdapter(getSupportFragmentManager(),datas);
//        viewPager.setAdapter(newsAdapter);
//        tabLayout.setupWithViewPager(viewPager);
//
//        // ======================================================================
//        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
//        tabLayout.getTabAt(0).setText("新闻");
//        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
//        tabLayout.getTabAt(1).setText("直播");
//        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
//        tabLayout.getTabAt(2).setText("话题");
//        tabLayout.getTabAt(3).setIcon(R.mipmap.ic_launcher);
//        tabLayout.getTabAt(3).setText("我");