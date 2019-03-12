package com.likeit.aqe365.activity.user;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.fragment.coupon.CouponFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.member.CouponCenterModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class CouponActivity extends BaseActivity {


    private int pageNum = 1;

    private List<String> datas = new ArrayList<>();
    private List<String> status = new ArrayList<>();
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    List<CouponCenterModel.CategpryBean> categpryBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon);
        initData();
    }

    private void initUI() {
        setBackView();
        setTitle("优惠劵领取中心" + "");
        mTabLayout = findViewById(R.id.indent_TabLayout);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor(theme_bg_tex));
        mTabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor(theme_bg_tex));
        if (categpryBean.size() >= 4) {
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        } else {
            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        }
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public void initData() {
       // LoaddingShow();
        RetrofitUtil.getInstance().GetCouponCenterList(openid, "", String.valueOf(pageNum), new Subscriber<BaseResponse<CouponCenterModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<CouponCenterModel> baseResponse1) {
               // LoaddingDismiss();
                if (baseResponse1.getCode() == 200) {
                    categpryBean = baseResponse1.getData().getCategpry();
                    for (int i = 0; i < categpryBean.size(); i++) {
                        datas.add(categpryBean.get(i).getName());
                        status.add(categpryBean.get(i).getId());
                        initUI();
                    }

                }
            }
        });

    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //带参的构造方法
        @Override
        public int getCount() {
            return datas.size();
        }

        //返回选项卡的文本 ，，，添加选项卡
        @Override
        public CharSequence getPageTitle(int position) {
            return datas.get(position);
        }

        @Override
        public int getItemPosition(Object object) {//最主要就是加了这个方法。
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position) {
            //创建fragment对象并返回
            Bundle bundle = new Bundle();
            bundle.putString("id", status.get(position));
            //实例化Fragment
            CouponFragment allFragment = new CouponFragment();
            allFragment.setArguments(bundle);
            return allFragment;
        }
    }
}