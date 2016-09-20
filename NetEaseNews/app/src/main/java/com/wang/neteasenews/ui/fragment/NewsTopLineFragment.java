package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsTopLineBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.adapter.NewsTopLineAdapter;
import com.wang.neteasenews.utils.AllConstantValues;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻界面头条部分
 */
public class NewsTopLineFragment extends AbsBaseFragment{
    private ListView listView;
    private NewsTopLineAdapter newsTopLineAdapter;


    public static NewsTopLineFragment newInstance() {

        Bundle args = new Bundle();

        NewsTopLineFragment fragment = new NewsTopLineFragment();
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
        newsTopLineAdapter = new NewsTopLineAdapter(context);
        listView.setAdapter(newsTopLineAdapter);


    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().setRequset(AllConstantValues.TOPLINEURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsTopLineBean bean = gson.fromJson(resultStr,NewsTopLineBean.class);
                List< NewsTopLineBean.T1348647909107Bean> datas = bean.getT1348647909107();
                newsTopLineAdapter.setDatas(datas);

            }

            @Override
            public void failure() {

            }
        });
    }
}
