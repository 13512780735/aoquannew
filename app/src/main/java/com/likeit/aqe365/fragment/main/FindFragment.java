package com.likeit.aqe365.fragment.main;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.find.PostActivity;
import com.likeit.aqe365.activity.user.CouponActivity;
import com.likeit.aqe365.adapter.indent.GoodsIndentTabAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.fragment.coupon.CouponFragment;
import com.likeit.aqe365.fragment.find.AllFind02Fragment;
import com.likeit.aqe365.fragment.find.AllFind03Fragment;
import com.likeit.aqe365.fragment.find.AllFind04Fragment;
import com.likeit.aqe365.fragment.find.AllFind05Fragment;
import com.likeit.aqe365.fragment.find.AllFind06Fragment;
import com.likeit.aqe365.fragment.find.AllFindFragment;
import com.likeit.aqe365.fragment.mycoupon.Coupon01Fragment;
import com.likeit.aqe365.fragment.mycoupon.Coupon02Fragment;
import com.likeit.aqe365.fragment.mycoupon.Coupon03Fragment;
import com.likeit.aqe365.view.BorderRelativeLayout;
import com.likeit.aqe365.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.support.v4.view.PagerAdapter.POSITION_NONE;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends BaseFragment {

    private ArrayList<String> mTitles;
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    private BorderRelativeLayout rl_post;

    @Override
    protected int setContentView() {
        return R.layout.fragment_find;
    }

    @Override
    protected void lazyLoad() {
        mTitles = new ArrayList<>(Arrays.asList("推荐", "关注", "话题", "附近", "用户","医院"));//, "医院"
        initUI();
    }

    private void initUI() {
        setTitle("发现");
//        setRightImage(R.mipmap.icon_nav_search, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        mTabLayout = findViewById(R.id.indent_TabLayout);
        rl_post = findViewById(R.id.rl_post);
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
        rl_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(PostActivity.class);
            }
        });
    }

    class MyAdapter extends FragmentStatePagerAdapter {
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
            switch (position) {
                case 0:
                    AllFindFragment tab1 = new AllFindFragment();
                    return tab1;
                case 1:
                    AllFind02Fragment tab2 = new AllFind02Fragment();
                    return tab2;
                case 2:
                    AllFind03Fragment tab3 = new AllFind03Fragment();
                    return tab3;
                case 3:
                    AllFind04Fragment tab4 = new AllFind04Fragment();
                    return tab4;
                case 4:
                    AllFind05Fragment tab5 = new AllFind05Fragment();
                    return tab5;
                case 5:
                    AllFind06Fragment tab6 = new AllFind06Fragment();
                    return tab6;
            }

            return null;
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        XLog.e("Fragment03");
    }
}
