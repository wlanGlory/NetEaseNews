package com.wang.neteasenews.interfaces;

/**
 * Created by dllo on 16/8/23.
 * RecyclerView 点击回调接口
 */
public interface OnRvItemClick {
    /**
     *
     * @param position 点击的行布局位置
     * @param str 行布局上的数据实体类
     *            如果适配器实体是xxBean
     *            这里的String就换为xxBean
     */
    void onRvItemClickListener(int position, String str);

}
