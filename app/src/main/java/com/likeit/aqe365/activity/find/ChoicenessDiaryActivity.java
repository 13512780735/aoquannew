package com.likeit.aqe365.activity.find;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.user.CouponActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.fragment.coupon.CouponFragment;
import com.likeit.aqe365.fragment.find.ChoicenessDiaryFragment;
import com.likeit.aqe365.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 精选日记
 */
public class ChoicenessDiaryActivity extends BaseActivity {

    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    private ArrayList<String> mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choiceness_diary);
        mTitles = new ArrayList<>(Arrays.asList("推荐", "人气", "最热", "最新"));//, "医院"
        initUI();
    }

    private void initUI() {
        setBackView();
        setTitle("精选日记");
        mTabLayout = findViewById(R.id.indent_TabLayout);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor(theme_bg_tex));
        mTabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor(theme_bg_tex));
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
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
            bundle.putString("name", mTitles.get(position));
            //实例化Fragment
            ChoicenessDiaryFragment allFragment = new ChoicenessDiaryFragment();
            allFragment.setArguments(bundle);
            return allFragment;
        }
    }
}
