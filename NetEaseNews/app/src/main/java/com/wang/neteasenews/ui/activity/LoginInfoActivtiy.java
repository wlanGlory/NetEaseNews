package com.wang.neteasenews.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.wang.neteasenews.R;
import com.wang.neteasenews.ui.fragment.UserFragment;

/**
 * Created by dllo on 16/9/29.
 * 用户登录界面详情界面
 */
public class LoginInfoActivtiy extends AbsBaseActivity implements View.OnClickListener {
    private ImageView backImg;
    @Override
    protected int setLayout() {
        return R.layout.login_layout;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.login_back);
        backImg.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_back:
                finish();
                break;
        }
    }
}
