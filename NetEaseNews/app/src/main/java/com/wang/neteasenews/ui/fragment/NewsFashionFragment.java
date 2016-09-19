package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsFashionBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.adapter.NewsFashionAdapter;
import com.wang.neteasenews.utils.AllConstantValues;

import java.util.List;

/**
 * Created by dllo on 16/9/16.
 * 新闻界面时尚部分
 */
public class NewsFashionFragment extends AbsBaseFragment{
    private ListView listView;
    private NewsFashionAdapter newsFashionAdapter;

    public static NewsFashionFragment newInstance() {

        Bundle args = new Bundle();

        NewsFashionFragment fragment = new NewsFashionFragment();
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
        newsFashionAdapter = new NewsFashionAdapter(context);
        listView.setAdapter(newsFashionAdapter);

    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().setRequset(AllConstantValues.FASHIONURL, new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsFashionBean bean = gson.fromJson(resultStr,NewsFashionBean.class);
                List<NewsFashionBean.T1348650593803Bean>datas = bean.getT1348650593803();
                newsFashionAdapter.setDatas(datas);
            }

            @Override
            public void failure() {

            }
        });

    }
}
