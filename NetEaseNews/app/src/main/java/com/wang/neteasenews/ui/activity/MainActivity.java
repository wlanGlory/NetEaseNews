package com.wang.neteasenews.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.wang.neteasenews.R;
import com.wang.neteasenews.ui.adapter.NewsAdapter;
import com.wang.neteasenews.ui.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> datas;
    private NewsAdapter newsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        viewPager = (ViewPager) findViewById(R.id.vp);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        datas = new ArrayList<>();
        datas.add(new NewsFragment());
        datas.add(new NewsFragment());
        datas.add(new NewsFragment());
        datas.add(new NewsFragment());

        newsAdapter = new NewsAdapter(getSupportFragmentManager(),datas);
        viewPager.setAdapter(newsAdapter);
        tabLayout.setupWithViewPager(viewPager);

        // ======================================================================
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(0).setText("新闻");
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(1).setText("直播");
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(2).setText("话题");
        tabLayout.getTabAt(3).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(3).setText("我");


    }
}
