package com.likeit.aqe365.adapter.comment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class GoodCommentAdapter extends FragmentPagerAdapter {

    // private String[] title = {"one", "two", "three", "four"};
    //String[] title = {"全部", "好评", "中评", "差评", "晒图"};
    private List<Fragment> fragmentList;

    public GoodCommentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return title[position];
//    }
}
