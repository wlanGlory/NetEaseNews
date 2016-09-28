package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.TopicQuestionBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.adapter.TopicQuestionAdapter;
import com.wang.neteasenews.utils.AllConstantValues;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 话题界面问吧部分
 */
public class TopicQuestionFragment extends AbsBaseFragment {
    private List<TopicQuestionBean.DataBean.ExpertListBean> datas;
    private ListView listView;
    private TopicQuestionAdapter adapter;
    public static TopicQuestionFragment newInstance() {

        Bundle args = new Bundle();

        TopicQuestionFragment fragment = new TopicQuestionFragment();
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
        adapter = new TopicQuestionAdapter(context);
        listView.setAdapter(adapter);

    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().setRequset(AllConstantValues.TOPICQUESTIONURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                TopicQuestionBean bean =gson.fromJson(resultStr,TopicQuestionBean.class);
                TopicQuestionBean.DataBean listBean = bean.getData();
                datas = listBean.getExpertList();
                adapter.setDatas(datas);
            }
            @Override
            public void failure() {

            }
        });

    }
}
