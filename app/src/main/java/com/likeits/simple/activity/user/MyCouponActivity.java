package com.likeits.simple.activity.user;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.likeits.simple.R;
import com.likeits.simple.adapter.indent.GoodsIndentTabAdapter;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.fragment.mycoupon.Coupon01Fragment;
import com.likeits.simple.fragment.mycoupon.Coupon02Fragment;
import com.likeits.simple.fragment.mycoupon.Coupon03Fragment;
import com.likeits.simple.view.BorderTextView;
import com.likeits.simple.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyCouponActivity extends BaseActivity {

    private ArrayList<String> mTitles;
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    @BindView(R.id.tv_more)
    BorderTextView tv_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_coupon);
        mTitles = new ArrayList<>(Arrays.asList("未使用", "已使用", "已过期"));
        initUI();
    }

    public void initUI() {
        setBackView();
        setTitle("我的优惠券");
        tv_more.setStrokeColor01(Color.parseColor(theme_bg_tex));
        tv_more.setTextColor(Color.parseColor(theme_bg_tex));
        mTabLayout = findViewById(R.id.indent_TabLayout);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor(theme_bg_tex));
        mTabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor(theme_bg_tex));
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setupWithViewPager(mViewPager);
        List<Fragment> mfragments = new ArrayList<Fragment>();
        mfragments.add(new Coupon01Fragment());
        mfragments.add(new Coupon02Fragment());
        mfragments.add(new Coupon03Fragment());
        mViewPager.setAdapter(new GoodsIndentTabAdapter(getSupportFragmentManager(), mfragments, mTitles));
        mViewPager.setCurrentItem(0);
    }

    @OnClick({R.id.tv_more})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_more:
                toActivity(CouponActivity.class);
                break;
        }
    }

}
