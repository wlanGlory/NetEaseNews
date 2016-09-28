package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wang.neteasenews.R;

import com.wang.neteasenews.model.bean.NewsEntertainmentBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.adapter.NewsEntertainmentAdapter;
//import com.wang.neteasenews.ui.adapter.NewsEntertainmentRotateVpAdapter;
import com.wang.neteasenews.ui.adapter.NewsEntertainmentRotateVpAdapter;
import com.wang.neteasenews.utils.AllConstantValues;
import com.wang.neteasenews.utils.ScreenSizeUtil;
import com.wang.neteasenews.view.ReFlashListView;

import java.util.List;

/**
 * Created by dllo on 16/9/16.
 */
public class NewsEntertainmentFragment extends AbsBaseFragment implements ReFlashListView.IReflashListener {

    private ReFlashListView reFlashListView;


    //================轮播图=============================


    private static final int TIME = 3000;
    private ViewPager viewPager;
    private LinearLayout pointTl;
    private NewsEntertainmentRotateVpAdapter vpAdapter;
    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;
    private TextView titleTv;
    private ImageView Iv;


    //=============================================
    private NewsEntertainmentAdapter newsEntertainmentAdapter;
    private List<NewsEntertainmentBean.T1348648517839Bean> datas;

    public static NewsEntertainmentFragment newInstance() {
        Bundle args = new Bundle();
        NewsEntertainmentFragment fragment = new NewsEntertainmentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_entertainment;
    }

    @Override
    protected void initViews() {


        //========================================
        reFlashListView = byView(R.id.entertainment_listview);
        newsEntertainmentAdapter = new NewsEntertainmentAdapter(context);
        reFlashListView.setAdapter(newsEntertainmentAdapter);

    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().setRequset(AllConstantValues.ENTERTAINMENTURL_LEFT + "0-20" + ".html", new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsEntertainmentBean bean = gson.fromJson(resultStr, NewsEntertainmentBean.class);
                datas = bean.getT1348648517839();
                // ================轮播图头布局===================
                View headView = LayoutInflater.from(context).inflate(R.layout.activity_loopview, null);

                viewPager = (ViewPager) headView.findViewById(R.id.rotate_vp);
                pointTl = (LinearLayout) headView.findViewById(R.id.rotate_point_container);
                titleTv = (TextView) headView.findViewById(R.id.head_list_title);
                Iv = (ImageView) headView.findViewById(R.id.head_list_img);

                vpAdapter = new NewsEntertainmentRotateVpAdapter(datas, context);
                viewPager.setAdapter(vpAdapter);

                vpAdapter.setDatas(datas);
                viewPager.setCurrentItem(datas.size()*100);
                handler = new Handler();
                startRotate();
//                addPoints();
//                changePoints();
                //===================================================
                // 在此处添加对头布局或者布局内的组件的设置
                reFlashListView.addHeaderView(headView);


            }

            @Override
            public void failure() {

            }
        });

        //=============================================================

        String range = "0-20";
        VolleyInstance.getInstance().setRequset(AllConstantValues.ENTERTAINMENTURL_LEFT + range + AllConstantValues.RIGHT, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsEntertainmentBean bean = gson.fromJson(resultStr, NewsEntertainmentBean.class);
                //============================================

                //============================================

                datas = bean.getT1348648517839();
                // 删除第一条数据
                datas.remove(0);
                newsEntertainmentAdapter.setDatas(datas);

            }

            @Override
            public void failure() {

            }
        });
        //==========================接口调用===================================
        reFlashListView.setInterface(this);
    }

    //===========================上拉数据加载=======================================================
    public void onReflash(int start, int end) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // 通知界面显示
                reFlashListView = (ReFlashListView) reFlashListView.findViewById(R.id.entertainment_listview);
                // 通知ListView刷新数据完毕
                reFlashListView.reflshComplete();
            }

        }, 2000);
        // 获取最新数据
        String range = start + "-" + end;
        VolleyInstance.getInstance().setRequset(AllConstantValues.ENTERTAINMENTURL_LEFT + range + AllConstantValues.RIGHT, new VolleyResult() {
            @Override
            public void success(String resultStr) {
//                Log.d("xxx", resultStr);
                Gson gson = new Gson();
                NewsEntertainmentBean bean = gson.fromJson(resultStr, NewsEntertainmentBean.class);
                datas = newsEntertainmentAdapter.getDatas();
                List<NewsEntertainmentBean.T1348648517839Bean> newDatas = bean.getT1348648517839();
                datas.addAll(newDatas);
                // 上拉
                newsEntertainmentAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });


    }

    @Override
    public void onReflash() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // 通知界面显示
                reFlashListView = (ReFlashListView) reFlashListView.findViewById(R.id.entertainment_listview);

                // 通知ListView刷新数据完毕
                reFlashListView.reflshComplete();
            }

        }, 2000);
        // 获取最新数据
        String range = "0-20";
        VolleyInstance.getInstance().setRequset(AllConstantValues.ENTERTAINMENTURL_LEFT + range + AllConstantValues.RIGHT, new VolleyResult() {
            @Override
            public void success(String resultStr) {
//                Log.d("xxx", resultStr);
                Gson gson = new Gson();
                NewsEntertainmentBean bean = gson.fromJson(resultStr, NewsEntertainmentBean.class);
                datas = bean.getT1348648517839();
                datas.remove(0);
                newsEntertainmentAdapter.setDatas(datas);

            }

            @Override
            public void failure() {

            }
        });

    }
    //==================================轮播图方法===========

    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;

    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
        handler.removeCallbacks(rotateRunnable);
    }

    private void changePoints() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    // 把所有小点设置为白色
                    for (int i = 0; i < 2; i++) {
                        ImageView pointIv = (ImageView) pointTl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.point_white);
                    }
                    // 设置当前位置小点为灰色
                    ImageView iv = (ImageView) pointTl.getChildAt(position%2);
                    iv.setImageResource(R.mipmap.point_grey);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addPoints() {
        // 有多少张图加载多少个小点
        for (int i = 0; i < 2; i++) {
            ImageView pointIv = new ImageView(context);
            pointIv.setPadding(5,5,5,5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25,25);
            pointIv.setLayoutParams(params);

            // 设置第0页小点的为灰色
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.point_grey);
            } else {
                pointIv.setImageResource(R.mipmap.point_white);
            }
            pointTl.addView(pointIv);
        }
    }

    private void startRotate() {
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++nowIndex);
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, TIME);
                }
            }
        };
        handler.postDelayed(rotateRunnable, TIME);
    }








}
