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
import com.wang.neteasenews.model.bean.ChosenBean;
import com.wang.neteasenews.ui.adapter.ChosenAdapter;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 精选界面
 */
public class ChosenFragment extends AbsBaseFragment {
    private String url = "http://c.m.163.com/nc/article/list/T1467284926140/0-20.html";
    private ListView listView;
    private ChosenAdapter chosenAdapter;

    private RequestQueue queue;

    public static ChosenFragment newInstance() {

        Bundle args = new Bundle();

        ChosenFragment fragment = new ChosenFragment();
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

    }

    @Override
    protected void initDatas() {
        queue = Volley.newRequestQueue(getContext());
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
//                Log.d("ChosenFragment", response);
                Gson gson = new Gson();
                ChosenBean chosenBean = gson.fromJson(response, ChosenBean.class);
                List<ChosenBean.T1467284926140Bean> datas = chosenBean.getT1467284926140();
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
