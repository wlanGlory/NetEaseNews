package com.wang.neteasenews.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.activity.NewsChosenInfoActivity;
import com.wang.neteasenews.ui.adapter.ChosenAdapter;
import com.wang.neteasenews.utils.AllConstantValues;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 新闻界面精选部分
 */
public class NewsChosenFragment extends AbsBaseFragment {
//    private String url = "http://c.m.163.com/nc/article/list/T1467284926140/0-20.html";
//
//    private String url = "http://c.3g.163.com/nc/article/list/T1467284926140/0-20.html";
//    private String url = "http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html";
    private ListView listView;
    private ChosenAdapter chosenAdapter;
    private List<NewsChosenBean.T1467284926140Bean> datas;


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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                NewsChosenBean.T1467284926140Bean newsChosenBean = datas.get(position);
                NewsChosenBean.T1467284926140Bean news = (NewsChosenBean.T1467284926140Bean) parent.getItemAtPosition(position);
                String str = news.getPostid();
                Intent intent = new Intent(context, NewsChosenInfoActivity.class);
                intent.putExtra("postid",str);
                context.startActivity(intent);

            }
        });


        VolleyInstance.getInstance().setRequset(AllConstantValues.CHOSENURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {

                Gson gson = new Gson();
                NewsChosenBean newsChosenBean = gson.fromJson(resultStr, NewsChosenBean.class);
                datas = newsChosenBean.getT1467284926140();
                chosenAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });

    }
}
