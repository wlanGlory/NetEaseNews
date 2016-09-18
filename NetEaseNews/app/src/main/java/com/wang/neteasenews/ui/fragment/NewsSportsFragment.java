package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsSportsBean;
import com.wang.neteasenews.ui.adapter.ChosenAdapter;
import com.wang.neteasenews.ui.adapter.NewsSportsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/16.
 * 新闻界面体育部分
 */
public class NewsSportsFragment extends AbsBaseFragment {
    private String url = "http://c.3g.163.com/nc/article/list/T1348649079062/0-20.html";
    private ListView listView;
    private NewsSportsAdapter newsSportAdapter;
    private RequestQueue queue;

    public static NewsSportsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        NewsSportsFragment fragment = new NewsSportsFragment();
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
        newsSportAdapter = new NewsSportsAdapter(context);
        listView.setAdapter(newsSportAdapter);

    }

    @Override
    protected void initDatas() {
        queue = Volley.newRequestQueue(context);
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                NewsSportsBean newsSportsBean = gson.fromJson(response,NewsSportsBean.class);
                List<NewsSportsBean.T1348649079062Bean> datas = newsSportsBean.getT1348649079062();
               newsSportAdapter.setDatas(datas);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(sr);

    }

}
