package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.wang.neteasenews.R;
import com.wang.neteasenews.ui.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/9/8.
 */
public class NewsFragment extends AbsBaseFragment implements View.OnClickListener {
    private TabLayout newsTl;
    private ViewPager newsVp;
    private NewsAdapter newsAdapter;
    private List<Fragment> datas;
    private ImageView newsPopWindow;



    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        newsTl = byView(R.id.news_tl);
        newsVp= byView(R.id.news_vp);
        newsPopWindow = byView(R.id.news_popwindow);
        newsPopWindow.setOnClickListener(this);
//        newsTl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                newsVp.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
        datas = new ArrayList<>();
        for (int i = 0; i <11 ; i++) {
            datas.add(new VideoFragment());
        }

    }

    @Override
    protected void initDatas() {
        FragmentManager fm = getChildFragmentManager();
        newsAdapter = new NewsAdapter(fm,datas);
        newsVp.setAdapter(newsAdapter);
        newsTl.setupWithViewPager(newsVp);


        newsTl.getTabAt(0).setText("头条");
        newsTl.getTabAt(1).setText("精选");
        newsTl.getTabAt(2).setText("娱乐");
        newsTl.getTabAt(3).setText("体育");
        newsTl.getTabAt(4).setText("网易号");
        newsTl.getTabAt(5).setText("财经");
        newsTl.getTabAt(6).setText("科技");
        newsTl.getTabAt(7).setText("汽车");
        newsTl.getTabAt(8).setText("时尚");
        newsTl.getTabAt(9).setText("热点");
        newsTl.getTabAt(10).setText("军事");






    }
    // PopWindow 点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.news_popwindow:
                //createWindow();
                break;
        }
    }
// 弹出窗口
//    private void createWindow() {
//        PopupWindow pw = new PopupWindow(getContext());
//        pw.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//
//
//
//    }
}
