package com.likeits.simple.activity.indent;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.likeits.simple.R;
import com.likeits.simple.adapter.indent.GoodsIndentTabAdapter;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodsIndentActivity extends BaseActivity {
    private List<String> mTitles;
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_indent);
        mTitles = new ArrayList<>(Arrays.asList("全部", "待付款", "待发货", "待收货", "已完成"));
        status = getIntent().getExtras().getInt("status");
        Log.e("TAG", status + "");
        initView();
        initData();
    }

    private void initView() {
        setBackView();
        setTitle("我的订单");
        mTabLayout = findViewById(R.id.indent_TabLayout);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setupWithViewPager(mViewPager);
        List<Fragment> mfragments = new ArrayList<Fragment>();
        mfragments.add(new AllIndentFragment());
        mfragments.add(new Indent01Fragment());
        mfragments.add(new Indent02Fragment());
        mfragments.add(new Indent03Fragment());
        mfragments.add(new Indent04Fragment());
        mViewPager.setAdapter(new GoodsIndentTabAdapter(getSupportFragmentManager(), mfragments, mTitles));
        mViewPager.setCurrentItem(status);
    }


    public void initData() {
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }


//        mViewPager.setCurrentItem(status);
}
