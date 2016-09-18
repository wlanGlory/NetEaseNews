package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;

import com.wang.neteasenews.R;

/**
 * Created by dllo on 16/9/12.
 *
 */
public class TopicQuestionFragment extends AbsBaseFragment {
    public static TopicQuestionFragment newInstance() {

        Bundle args = new Bundle();

        TopicQuestionFragment fragment = new TopicQuestionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_question;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
