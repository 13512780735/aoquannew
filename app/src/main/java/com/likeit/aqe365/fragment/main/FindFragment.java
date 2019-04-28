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
import com.likeit.aqe365.activity.find.FindSearchActivity;
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
import com.likeit.aqe365.fragment.member.MoodFragment;
import com.likeit.aqe365.fragment.member.PostFragment;
import com.likeit.aqe365.fragment.mycoupon.Coupon01Fragment;
import com.likeit.aqe365.fragment.mycoupon.Coupon02Fragment;
import com.likeit.aqe365.fragment.mycoupon.Coupon03Fragment;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
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
    private GoodsIndentTabAdapter tabAdapter;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private String name;
    private String findFlag;

    @Override
    protected int setContentView() {
        return R.layout.fragment_find;
    }

    @Override
    protected void lazyLoad() {
        mTitles = new ArrayList<>(Arrays.asList("医院", "推荐", "关注", "话题", "附近", "用户"));//, "医院"
        name = "推荐";

        initUI();
    }

    private void initUI() {
        setTitle("附近");
        setRightImage(R.mipmap.icon_nav_search, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("推荐".equals(name)) {
                    findFlag = "1";
                } else if ("关注".equals(name)) {
                    findFlag = "2";
                } else if ("话题".equals(name)) {
                    findFlag = "3";
                } else if ("附近".equals(name)) {
                    findFlag = "4";
                } else if ("用户".equals(name)) {
                    findFlag = "5";
                } else if ("医院".equals(name)) {
                    findFlag = "6";
                }
                Bundle bundle = new Bundle();
                bundle.putString("findFlag", findFlag);
                toActivity(FindSearchActivity.class, bundle);
            }
        });


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
        // mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(1);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                name = tab.getText().toString();
                XLog.e("name:" + name);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                String name = tab.getText().toString();
                XLog.e("name111:" + name);
            }
        });


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
                    AllFind06Fragment tab6 = new AllFind06Fragment();
                    return tab6;
                case 1:
                    AllFindFragment tab1 = new AllFindFragment();
                    return tab1;
                case 2:
                    AllFind02Fragment tab2 = new AllFind02Fragment();
                    return tab2;
                case 3:
                    AllFind03Fragment tab3 = new AllFind03Fragment();
                    return tab3;
                case 4:
                    AllFind04Fragment tab4 = new AllFind04Fragment();
                    return tab4;
                case 5:
                    AllFind05Fragment tab5 = new AllFind05Fragment();
                    return tab5;

            }

            return null;
        }

    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private String[] mTitles = new String[]{"医院","推荐", "关注", "话题", "附近", "用户"};
        List<Fragment> mList;

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> mList) {
            super(fm);
            this.mList = mList;
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            if (mList.size() <= 0) {
                return 0;
            }
            return mList.size();
        }

        //设置tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        XLog.e("Fragment03");
    }
}
