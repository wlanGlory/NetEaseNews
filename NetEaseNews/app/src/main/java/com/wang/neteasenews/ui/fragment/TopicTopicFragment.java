package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.TopicTopicBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.adapter.TopicTopicAdapter;
import com.wang.neteasenews.utils.AllConstantValues;

import java.util.List;

/**
 * Created by dllo on 16/9/12.
 * 话题界面话题部分
 */
public class TopicTopicFragment extends AbsBaseFragment {
    private ListView listView;
    private TopicTopicAdapter adapter;
    private List<TopicTopicBean.DataBean.SubjectListBean> datas;


    public static TopicTopicFragment newInstance() {

        Bundle args = new Bundle();

        TopicTopicFragment fragment = new TopicTopicFragment();
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
        adapter = new TopicTopicAdapter(context);
        listView.setAdapter(adapter);

    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().setRequset(AllConstantValues.TOPICTOPICURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
//                Log.d("TopicTopicFragment", resultStr);
                Gson gson = new Gson();
                TopicTopicBean bean = gson.fromJson(resultStr,TopicTopicBean.class);
                TopicTopicBean.DataBean beanList = bean.getData();
                datas = beanList.getSubjectList();
                adapter.setDatas(datas);


            }

            @Override
            public void failure() {

            }
        });

    }
}
