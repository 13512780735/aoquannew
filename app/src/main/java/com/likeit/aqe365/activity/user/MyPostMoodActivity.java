package com.likeit.aqe365.activity.user;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.fragment.find.AllFind02Fragment;
import com.likeit.aqe365.fragment.find.AllFind03Fragment;
import com.likeit.aqe365.fragment.find.AllFind04Fragment;
import com.likeit.aqe365.fragment.find.AllFind05Fragment;
import com.likeit.aqe365.fragment.find.AllFind06Fragment;
import com.likeit.aqe365.fragment.find.AllFindFragment;
import com.likeit.aqe365.fragment.find.TopicListFragment;
import com.likeit.aqe365.fragment.main.FindFragment;
import com.likeit.aqe365.fragment.member.MoodFragment;
import com.likeit.aqe365.fragment.member.PostFragment;
import com.likeit.aqe365.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;

public class MyPostMoodActivity extends BaseActivity {
    private ArrayList<String> mTitles;
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    private LinearLayout back_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post_mood);
        mTitles = new ArrayList<>(Arrays.asList("帖子", "心情"));
        initUI();
    }

    private void initUI() {
        back_view = findView(R.id.back_view);
        back_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTabLayout = findViewById(R.id.indent_TabLayout);
        mViewPager = findViewById(R.id.viewpager1);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor(theme_bg_tex));
        mTabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor(theme_bg_tex));
//        if (categpryBean.size() >= 4) {
//            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        } else {
//            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
//        }
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
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
                    PostFragment tab1 = new PostFragment();
                    return tab1;
                case 1:
                    MoodFragment tab2 = new MoodFragment();
                    return tab2;


            }
            return null;
//            Bundle bundle = new Bundle();
//            bundle.putString("id", mTitles.get(position));
//            //实例化Fragment
//            MoodFragment moodFragment = new MoodFragment();
//            moodFragment.setArguments(bundle);
//            return moodFragment;


        }

    }
}
