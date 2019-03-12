package com.likeit.aqe365.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.fragment.main.CartFragment;
import com.likeit.aqe365.fragment.main.CategoryFragment;
import com.likeit.aqe365.fragment.main.CommissionFragment;
import com.likeit.aqe365.fragment.main.FindFragment;
import com.likeit.aqe365.fragment.main.GoodsFragment;
import com.likeit.aqe365.fragment.main.HomeFragment;
import com.likeit.aqe365.fragment.main.MemberFragment;
import com.likeit.aqe365.fragment.main.NoticeFragment;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.view.tablayout.widget.AbstractCommonTabLayout;

import java.util.ArrayList;

public class MainActivity extends AbstractCommonTabLayout {
    private String[] mIconSelectIds;//标题

    private String[] mTitles;//未选中

    private String[] mLinkurl;
    private ArrayList<Fragment> mFragments = new ArrayList<>();//Fragment 集合
    private String flag;
    private String linkurl;
    private int index;
    private String TAG;

    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationOption;

    /**
     * 设置布局文件
     */
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
        // initData1();//获取导航数据
    }


    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        super.initData();
        //setSelectDefaultIndex(0);//设置默认的选项
        flag = getIntent().getExtras().getString("flag");
        index = getIntent().getExtras().getInt("index");
        if ("0".equals(flag)) {
            setSelectDefaultIndex(index);
        } else if ("1".equals(flag)) {
            setSelectDefaultIndex(index);
        }
        // setShowDot(3);
        setUnReadMsg(2, 5, Color.parseColor("#FF0000"));
        //   setDivisionLine(Color.parseColor("#6D8FB0"),0.5F,20);
    }



    /**
     * 标题数组
     **/
    @Override
    protected String[] getTitles() {
        return mTitles;
    }

    /**
     * 选择图标数组
     **/
    @Override
    protected String[] getIconSelectIds() {
        return mIconSelectIds;
    }


    /**
     * Fragment 集合
     **/
    @Override
    protected ArrayList<Fragment> getFragmentList() {
        mTitles = getIntent().getStringArrayExtra("mTitles");
        mLinkurl = getIntent().getStringArrayExtra("mLinkurl");
        mIconSelectIds = getIntent().getStringArrayExtra("mIconSelectIds");

        for (String linkurl : mLinkurl) {
            if ("home".equals(linkurl)) {
                mFragments.add(new HomeFragment());
            } else if ("goods".equals(linkurl)) {
                mFragments.add(new GoodsFragment());
            } else if ("commission".equals(linkurl)) {
                mFragments.add(new CommissionFragment());
            } else if ("cart".equals(linkurl)) {
                mFragments.add(new CartFragment());
            } else if ("member".equals(linkurl)) {
                mFragments.add(new MemberFragment());
            } else if ("notice".equals(linkurl)) {
                mFragments.add(new NoticeFragment());
            } else if ("category".equals(linkurl)) {
                mFragments.add(new CategoryFragment());
            } else if ("discover".equals(linkurl)) {
                mFragments.add(new FindFragment());
            }
        }
        return mFragments;
    }

    /**
     * CommonTabLayout 资源id
     **/
    @Override
    protected int getCommonTabLayout() {
        return R.id.tl_2;
    }

    /**
     * ViewPager 资源id
     **/
    @Override
    protected int getCommonViewPager() {
        return R.id.vp_2;
    }
}
