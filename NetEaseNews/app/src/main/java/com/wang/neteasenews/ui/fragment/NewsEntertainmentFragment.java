package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.os.Handler;

import com.google.gson.Gson;
import com.wang.neteasenews.R;

import com.wang.neteasenews.model.bean.NewsEntertainmentBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.adapter.NewsEntertainmentAdapter;
import com.wang.neteasenews.utils.AllConstantValues;
import com.wang.neteasenews.view.ReFlashListView;

import java.util.List;

/**
 * Created by dllo on 16/9/16.
 */
public class NewsEntertainmentFragment extends AbsBaseFragment implements ReFlashListView.IReflashListener {

    private ReFlashListView reFlashListView;
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

        reFlashListView = byView(R.id.entertainment_listview);
        newsEntertainmentAdapter = new NewsEntertainmentAdapter(context);
        reFlashListView.setAdapter(newsEntertainmentAdapter);

    }

    @Override
    protected void initDatas() {

        VolleyInstance.getInstance().setRequset(AllConstantValues.ENTERTAINMENTURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsEntertainmentBean bean = gson.fromJson(resultStr, NewsEntertainmentBean.class);
                datas = bean.getT1348648517839();
                newsEntertainmentAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });
        //==========================接口调用===================================
        reFlashListView.setInterface(this);

    }

    //===========================数据刷新=======================================================
    public void onReflash() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // 通知界面显示
                reFlashListView = (ReFlashListView) reFlashListView.findViewById(R.id.entertainment_listview);

                newsEntertainmentAdapter.setDatas(datas);
                reFlashListView.setAdapter(newsEntertainmentAdapter);
                // 通知ListView刷新数据完毕
                reFlashListView.reflshComplete();
            }

        },2000);
        // 获取最新数据


    }
    //=================================================================================================
}
