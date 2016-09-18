package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsChosenBean;
import com.wang.neteasenews.ui.adapter.ChosenAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 新闻界面精选部分
 */
public class NewsChosenFragment extends AbsBaseFragment {
//    private String url = "http://c.m.163.com/nc/article/list/T1467284926140/0-20.html";
//
    private String url = "http://c.3g.163.com/nc/article/list/T1467284926140/0-20.html";
//    private String url = "http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html";
    private ListView listView;
    private ChosenAdapter chosenAdapter;

    private RequestQueue queue;

    public static NewsChosenFragment newInstance() {

        Bundle args = new Bundle();

        NewsChosenFragment fragment = new NewsChosenFragment();
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
        chosenAdapter = new ChosenAdapter(context);
        listView.setAdapter(chosenAdapter);
//        View headView = LayoutInflater.from(context).inflate(R.layout.head_list,null);
//
//        // 在此处添加对头布局或者布局内的组件的设置
//
//        ImageView headImg = (ImageView) headView.findViewById(R.id.head_list_img);
//
//        listView.addHeaderView(headView);

    }

    @Override
    protected void initDatas() {
        queue = Volley.newRequestQueue(context);
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                NewsChosenBean newsChosenBean = gson.fromJson(response, NewsChosenBean.class);
                List<NewsChosenBean.T1467284926140Bean> datas = newsChosenBean.getT1467284926140();
                chosenAdapter.setDatas(datas);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(sr);
    }
}
