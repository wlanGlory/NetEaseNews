package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsFashionBean;
import com.wang.neteasenews.model.bean.NewsFinanceBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.adapter.NewsFinanceAdapter;
import com.wang.neteasenews.utils.AllConstantValues;

import java.util.List;

/**
 * Created by dllo on 16/9/16.
 * 新闻界面财经部分
 */
public class NewsFinanceFragment extends AbsBaseFragment{
    private ListView listview;
    private NewsFinanceAdapter adapter;
    public static NewsFinanceFragment newInstance() {

        Bundle args = new Bundle();

        NewsFinanceFragment fragment = new NewsFinanceFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {

        return R.layout.fragment_chosen;
    }

    @Override
    protected void initViews() {
        listview = byView(R.id.chosen_listview);
        adapter = new NewsFinanceAdapter(context);
        listview.setAdapter(adapter);

    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().setRequset(AllConstantValues.FINANCEURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsFinanceBean bean = gson.fromJson(resultStr, NewsFinanceBean.class);
                List<NewsFinanceBean.T1348648756099Bean> datas = bean.getT1348648756099();
                adapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });
    }
}
