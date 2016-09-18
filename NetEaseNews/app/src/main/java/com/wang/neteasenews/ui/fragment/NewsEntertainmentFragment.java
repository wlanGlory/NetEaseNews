package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsEntertainmentBean;
import com.wang.neteasenews.ui.adapter.NewsEntertainmentAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/16.
 */
public class NewsEntertainmentFragment extends AbsBaseFragment{
    private String url = "http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html";
    private ListView listView;
    private NewsEntertainmentAdapter newsEntertainmentAdapter;
    private RequestQueue queue;

    public static NewsEntertainmentFragment newInstance() {
        
        Bundle args = new Bundle();
        
        NewsEntertainmentFragment fragment = new NewsEntertainmentFragment();
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
        newsEntertainmentAdapter = new NewsEntertainmentAdapter(context);
        listView.setAdapter(newsEntertainmentAdapter);

    }

    @Override
    protected void initDatas() {
        queue = Volley.newRequestQueue(context);
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
                NewsEntertainmentBean bean = gson.fromJson(response,NewsEntertainmentBean.class);
                List<NewsEntertainmentBean.T1348648517839Bean> datas = bean.getT1348648517839();
                newsEntertainmentAdapter.setDatas(datas);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(sr);

    }
}
