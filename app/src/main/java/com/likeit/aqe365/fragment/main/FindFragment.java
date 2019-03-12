package com.likeit.aqe365.fragment.main;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.user.CouponActivity;
import com.likeit.aqe365.adapter.indent.GoodsIndentTabAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.fragment.coupon.CouponFragment;
import com.likeit.aqe365.fragment.find.AllFindFragment;
import com.likeit.aqe365.fragment.mycoupon.Coupon01Fragment;
import com.likeit.aqe365.fragment.mycoupon.Coupon02Fragment;
import com.likeit.aqe365.fragment.mycoupon.Coupon03Fragment;
import com.likeit.aqe365.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment {

    private ArrayList<String> mTitles;
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;

    @Override
    protected int setContentView() {
        return R.layout.fragment_find;
    }

    @Override
    protected void lazyLoad() {
        mTitles = new ArrayList<>(Arrays.asList("推荐", "关注", "话题", "附近", "用户", "医院"));
        initUI();
    }

    private void initUI() {
        setTitle("发现");
        setRightImage(R.mipmap.icon_nav_search, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        mTabLayout = findViewById(R.id.indent_TabLayout);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor(theme_bg_tex));
        mTabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor(theme_bg_tex));
//        if (categpryBean.size() >= 4) {
//            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        } else {
//            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        }
        mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //带参的构造方法
        @Override
        public int getCount() {
            return mTitles.size();
        }

        //返回选项卡的文本 ，，，添加选项卡
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        @Override
        public int getItemPosition(Object object) {//最主要就是加了这个方法。
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position) {
            //创建fragment对象并返回
            Bundle bundle = new Bundle();
            bundle.putString("id", mTitles.get(position));
            //实例化Fragment
            AllFindFragment allFragment = new AllFindFragment();
            allFragment.setArguments(bundle);
            return allFragment;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        XLog.e("Fragment03");
    }
}
