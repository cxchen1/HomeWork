package com.example.homework;

import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private List<View> mViews;

    public MyPagerAdapter(List<View> mViews) {
        this.mViews = mViews;
    }

    /**
     * 重写四个方法 boolean isViewFromObject(View arg0, Object arg1) int getCount()
     * void destroyItem(ViewGroup container, int position,Object object) Object
     * instantiateItem(ViewGroup container, int position)
     */

    // 从当前container中删除指定位置的view
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }

    // 添加界面，一般会添加当前页和左右两边的页面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViews.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    // 返回要滑动的view个数
    @Override
    public int getCount() {
        return mViews.size();
    }
}
