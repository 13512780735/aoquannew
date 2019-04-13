package com.likeit.aqe365.fragment.main;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.find.PostActivity;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.fragment.find.AllFind02Fragment;
import com.likeit.aqe365.fragment.find.AllFind03Fragment;
import com.likeit.aqe365.fragment.find.AllFind04Fragment;
import com.likeit.aqe365.fragment.find.AllFind05Fragment;
import com.likeit.aqe365.fragment.find.AllFindFragment;
import com.likeit.aqe365.fragment.message.Message02Fargment;
import com.likeit.aqe365.fragment.message.Message03Fargment;
import com.likeit.aqe365.fragment.message.Message04Fargment;
import com.likeit.aqe365.fragment.message.Message05Fargment;
import com.likeit.aqe365.view.BorderRelativeLayout;
import com.likeit.aqe365.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeFragment extends BaseFragment {

    private ArrayList<String> mTitles;
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;

    @Override
    protected int setContentView() {
        return R.layout.fragment_notice;
    }

    @Override
    protected void lazyLoad() {
        mTitles = new ArrayList<>(Arrays.asList("评论", "@我的", "赞", "通知"));
        initUI();
    }

    private void initUI() {
        setTitle("我的消息");
//        setRightImage(R.mipmap.icon_nav_search, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


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
//        rl_post.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                toActivity(PostActivity.class);
//            }
//        });
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
                    Message02Fargment tab1 = new Message02Fargment();
                    return tab1;
                case 1:
                    Message03Fargment tab2 = new Message03Fargment();
                    return tab2;
                case 2:
                    Message04Fargment tab3 = new Message04Fargment();
                    return tab3;
                case 3:
                    Message05Fargment tab4 = new Message05Fargment();
                    return tab4;
//                case 4:
//                    AllFind05Fragment tab5 = new AllFind05Fragment();
//                    return tab5;
            }

            return null;
        }

//        @Override
//        public void restoreState(Parcelable state, ClassLoader loader) {
//          //  super.restoreState(state, loader);
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        XLog.e("Fragment03");
    }

}
