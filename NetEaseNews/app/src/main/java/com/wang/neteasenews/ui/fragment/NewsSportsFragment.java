package com.wang.neteasenews.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.wang.neteasenews.R;
import com.wang.neteasenews.model.bean.NewsSportsBean;
import com.wang.neteasenews.model.net.VolleyInstance;
import com.wang.neteasenews.model.net.VolleyResult;
import com.wang.neteasenews.ui.adapter.NewsSportsAdapter;
import com.wang.neteasenews.ui.adapter.NewsSportsRotateVpAdapter;
import com.wang.neteasenews.utils.AllConstantValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by dllo on 16/9/16.
 * 新闻界面体育部分
 */
public class NewsSportsFragment extends AbsBaseFragment {
    private static final int TIME = 3000;
    private ViewPager viewPager;
    private LinearLayout pointTl;
    private NewsSportsRotateVpAdapter vpAdapter;
    private Handler handler;
    private boolean isRotate = false;
    private Runnable rotateRunnable;


    //===========================================================
    private ListView listView;
    private NewsSportsAdapter newsSportAdapter;
    private List<NewsSportsBean.T1348649079062Bean> sportDatas;

    //=========================
    private TextView titleTv;
    private ImageView Iv;


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
        View headView = LayoutInflater.from(context).inflate(R.layout.activity_loopview,null);
        //===================================================
        viewPager = (ViewPager) headView.findViewById(R.id.rotate_vp);
        pointTl = (LinearLayout) headView.findViewById(R.id.rotate_point_container);
//        titleTv = (TextView) headView.findViewById(R.id.head_list_title);
//        Iv = (ImageView) headView.findViewById(R.id.head_list_img);

        vpAdapter = new NewsSportsRotateVpAdapter(sportDatas,context);
//        Picasso.with(context).load(sportDatas.get(0).getAds().get(0).getTitle()).into(titleTv);
        viewPager.setAdapter(vpAdapter);
        //===================================================
        // 在此处添加对头布局或者布局内的组件的设置
        listView.addHeaderView(headView);

    }

    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;

    }

    @Override
    public void onPause() {
        super.onPause();
        isRotate = false;
        handler.removeCallbacks(rotateRunnable);
    }

    private void changePoints() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isRotate) {
                    // 把所有小点设置为白色
                    for (int i = 0; i < sportDatas.size(); i++) {
                        ImageView pointIv = (ImageView) pointTl.getChildAt(i);
                        pointIv.setImageResource(R.mipmap.point_white);
                    }
                    // 设置当前位置小点为灰色
                    ImageView iv = (ImageView) pointTl.getChildAt(position%sportDatas.size());
                    iv.setImageResource(R.mipmap.point_grey);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addPoints() {
        // 有多少张图加载多少个小点
        for (int i = 0; i < sportDatas.size(); i++) {
            ImageView pointIv = new ImageView(context);
            pointIv.setPadding(5,5,5,5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
            pointIv.setLayoutParams(params);

            // 设置第0页小点的为灰色
            if (i == 0) {
                pointIv.setImageResource(R.mipmap.point_grey);
            } else {
                pointIv.setImageResource(R.mipmap.point_white);
            }
            pointTl.addView(pointIv);
        }
    }

    private void startRotate() {
        rotateRunnable = new Runnable() {
            @Override
            public void run() {
                int nowIndex = viewPager.getCurrentItem();
                viewPager.setCurrentItem(++nowIndex);
                if (isRotate) {
                    handler.postDelayed(rotateRunnable, TIME);
                }
            }
        };
        handler.postDelayed(rotateRunnable, TIME);
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().setRequset(AllConstantValues.SPORTSURL,  new VolleyResult() {
            @Override
            public void success(String resultStr) {
                Gson gson = new Gson();
                NewsSportsBean newsSportsBean = gson.fromJson(resultStr,NewsSportsBean.class);
                //=====================================================



                //=====================================================
                sportDatas = newsSportsBean.getT1348649079062();

                newsSportAdapter.setDatas(sportDatas);
                // 获取到轮播图数据后再初始化轮播图
                vpAdapter.setDatas(sportDatas);
                viewPager.setCurrentItem(sportDatas.size()*100);
                handler = new Handler();
                startRotate();
                addPoints();
                changePoints();
            }

            @Override
            public void failure() {

            }
        });

    }






}
