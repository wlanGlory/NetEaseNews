package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;

import com.wang.neteasenews.R;

/**
 * Created by dllo on 16/9/10.
 */
public class VideoFragment extends AbsBaseFragment {
    
    
    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }

    public static VideoFragment newInstance() {
        
        Bundle args = new Bundle();
        
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
