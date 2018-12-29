package com.likeits.simple.activity;

import android.Manifest;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.fragment.main.CartFragment;
import com.likeits.simple.fragment.main.CategoryFragment;
import com.likeits.simple.fragment.main.CommissionFragment;
import com.likeits.simple.fragment.main.GoodsFragment;
import com.likeits.simple.fragment.main.HomeFragment;
import com.likeits.simple.fragment.main.MemberFragment;
import com.likeits.simple.fragment.main.NoticeFragment;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.utils.ToastUtils;
import com.likeits.simple.view.tablayout.widget.AbstractCommonTabLayout;

import java.util.ArrayList;

import permissions.dispatcher.PermissionUtils;

public class MainActivity extends AbstractCommonTabLayout {
    private String[] mIconSelectIds;//标题

    private String[] mTitles;//未选中

    private ArrayList<Fragment> mFragments = new ArrayList<>();//Fragment 集合
    private String[] mLinkurl;


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
        setSelectDefaultIndex(0);//设置默认的选项
        // setShowDot(3);
        //setUnReadMsg(2, 5, Color.parseColor("#FF0000"));
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
        String token = SharedPreferencesUtils.getString(mContext, "token");
        mTitles = getIntent().getStringArrayExtra("mTitles");
        mLinkurl = getIntent().getStringArrayExtra("mLinkurl");
        mIconSelectIds = getIntent().getStringArrayExtra("mIconSelectIds");
        XLog.e(mIconSelectIds);
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
