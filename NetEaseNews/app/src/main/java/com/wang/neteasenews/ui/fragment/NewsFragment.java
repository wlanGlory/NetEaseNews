package com.wang.neteasenews.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.wang.neteasenews.R;
import com.wang.neteasenews.interfaces.OnRvItemClick;
import com.wang.neteasenews.ui.adapter.NewsAdapter;
import com.wang.neteasenews.ui.adapter.NewsEntertainmentAdapter;
import com.wang.neteasenews.ui.adapter.PopWindowAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/9/8.
 * 新闻界面
 */
public class NewsFragment extends AbsBaseFragment implements View.OnClickListener, PopupWindow.OnDismissListener {
    private TabLayout newsTl;
    private ViewPager newsVp;
    private NewsAdapter newsAdapter;
    private List<Fragment> datas;
    private ImageView newsPopWindow;
    private RecyclerView recyclerView;
    private PopWindowAdapter popWindowAdapter;
    private List<String> list;
    private PopupWindow pw;

    public static NewsFragment newInstance() {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initViews() {
        newsTl = byView(R.id.news_tl);
        newsVp = byView(R.id.news_vp);
        newsPopWindow = byView(R.id.news_popwindow);
        newsPopWindow.setOnClickListener(this);
        datas = new ArrayList<>();

        datas.add(NewsTopLineFragment.newInstance());
        datas.add(NewsChosenFragment.newInstance());
        datas.add(NewsEntertainmentFragment.newInstance());
        datas.add(NewsSportsFragment.newInstance());
        datas.add(NewsChosenFragment.newInstance());
        datas.add(NewsFinanceFragment.newInstance());
        datas.add(NewsChosenFragment.newInstance());
        datas.add(NewsChosenFragment.newInstance());
        datas.add(NewsFashionFragment.newInstance());
        datas.add(NewsChosenFragment.newInstance());
        datas.add(NewsChosenFragment.newInstance());


    }

    @Override
    protected void initDatas() {
        FragmentManager fm = getChildFragmentManager();
        newsAdapter = new NewsAdapter(fm, datas);
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
        switch (v.getId()) {
            case R.id.news_popwindow:
                createWindow();
                newsPopWindow.setImageResource(R.mipmap.icon_up);
                newsPopWindow.setColorFilter(Color.RED);
                pw.setOnDismissListener(this);
                break;
        }
    }

    // 弹出窗口
    private void createWindow() {
        pw = new PopupWindow(getContext());
        pw.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        pw.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        View v = LayoutInflater.from(context).inflate(R.layout.popwindow_layout, null);
        pw.setContentView(v);
        // 去掉PopWindow弹出窗口的边框颜色
        pw.setBackgroundDrawable(null);
        pw.setFocusable(true);
        pw.isOutsideTouchable();
        pw.showAsDropDown(newsPopWindow);
        // 设置弹出窗口布局的点击事件来控制PopWindow点击其他地方消失
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pw.dismiss();
                return false;
            }
        });

        recyclerView = (RecyclerView) v.findViewById(R.id.popw_rv);
        popWindowAdapter = new PopWindowAdapter(context);
        recyclerView.setAdapter(popWindowAdapter);
        GridLayoutManager glm = new GridLayoutManager(context, 4);
        recyclerView.setLayoutManager(glm);

        list = new ArrayList<>();
        list.add("头条");
        list.add("精选");
        list.add("娱乐");
        list.add("体育");
        list.add("网易号");
        list.add("财经");
        list.add("科技");
        list.add("汽车");
        list.add("时尚");
        list.add("热点");
        list.add("军事");
        popWindowAdapter.setDatas(list);
        // ============recyclerview中行点击事件==================
        popWindowAdapter.setOnRvItemClick(new OnRvItemClick() {
            @Override
            public void onRvItemClickListener(int position, String str) {
                Log.d("NewsFragment", str);


                newsTl.getTabAt(position).select();
                pw.dismiss();


            }
        });


    }

    @Override
    public void onDismiss() {
        newsPopWindow.setImageResource(R.mipmap.icon_down);
        newsPopWindow.setColorFilter(Color.BLACK);
    }
}
