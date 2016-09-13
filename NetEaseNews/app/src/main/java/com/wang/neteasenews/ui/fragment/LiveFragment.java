package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.LiveBean;
import com.wang.neteasenews.ui.adapter.LiveAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/8.
 */
public class LiveFragment extends AbsBaseFragment {
    private String url = "http://c.m.163.com/nc/live/list/5YWo5Zu9/0-20.html";
    private ListView listview;
    private LiveAdapter liveAdapter;

   private RequestQueue queue;


    public static LiveFragment newInstance() {
        
        Bundle args = new Bundle();
        
        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {

        return R.layout.fragment_live;
    }

    @Override
    protected void initViews() {
        listview = byView(R.id.live_lv);
        liveAdapter = new LiveAdapter(getContext());
        listview.setAdapter(liveAdapter);



    }

    @Override
    protected void initDatas() {
        queue = Volley.newRequestQueue(getContext());
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                LiveBean liveBean = gson.fromJson(response,LiveBean.class);
                List<LiveBean.T1462958418713Bean> datas = liveBean.getT1462958418713();
                liveAdapter.setDatas(datas);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(sr);
    }
}
