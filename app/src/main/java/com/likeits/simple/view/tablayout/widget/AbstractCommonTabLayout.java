package com.likeits.simple.view.tablayout.widget;

import android.Manifest;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


import com.likeits.simple.R;
import com.likeits.simple.utils.AppManager;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.utils.StatusBarUtil;
import com.likeits.simple.view.tablayout.bean.CustomTabEntity;
import com.likeits.simple.view.tablayout.bean.TabEntity;
import com.likeits.simple.view.tablayout.listener.OnTabSelectListener;
import com.likeits.simple.view.tablayout.utils.SoundPlayUtils;
import com.likeits.simple.view.tablayout.utils.UnreadMsgUtils;
import com.likeits.simple.view.tablayout.utils.ViewFindUtils;

import java.util.ArrayList;

import permissions.dispatcher.PermissionUtils;

/**
 * 描述：通用的Tab框架
 * 作者：zhuangzeqin
 * 时间: 2016/12/30 16:30
 * 邮箱：zhuangzeqin@szxys.cn
 */
public abstract class AbstractCommonTabLayout extends AppCompatActivity {
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();//存放自定义tab 实体集合
    private ArrayList<Fragment> mFragments = null;//Fragment 集合
    private CommonTabLayout mTabLayout;//自定义Tablout 控件
    private View mDecorView;
    private ViewPager mViewPager;//viewpager 对象
    protected Context mContext;//上下文对象
    /**
     * 默认选中的索引
     **/
    private static final int SELECT_DEFAULT_INDEX = 0;
    private String iconcolor;//默认颜色
    private String iconcoloron;//选中颜色
    final String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        int color = getResources().getColor(R.color.white);
        StatusBarUtil.setColor(this,color,0);
        StatusBarUtil.setLightMode(this);
        //StatusBarUtil.setColor(this, color, 0);
        AppManager.getAppManager().addActivity(this);
        mContext = this;
        setContentView();
        initViews();
        initTabEntities();
        initData();
        /** add by zhuangzeqin 2017年9月12日10:17:39 初始化默认的声音加载 **/
        SoundPlayUtils.getInstance().initDefaultSoundPool(mContext);
        boolean hadPermission = PermissionUtils.hasSelfPermissions(this, permissions);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !hadPermission) {
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
            requestPermissions(permissions, 1110);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean sdPermissionResult = PermissionUtils.verifyPermissions(grantResults);
        if (!sdPermissionResult) {
            Toast.makeText(this, "没获取到sd卡权限，无法播放本地视频哦", Toast.LENGTH_LONG).show();
        }
    }
    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 初始化组件
     */
    private void initViews() {
        mDecorView = getWindow().getDecorView();
        mTabLayout = ViewFindUtils.find(mDecorView, getCommonTabLayout());

        mViewPager = ViewFindUtils.find(mDecorView, getCommonViewPager());
    }

    /**
     * 初始化 tab 选项实体信息
     * 标题，选中图标，未选中的图标
     */
    private void initTabEntities() {
        iconcolor= SharedPreferencesUtils.getString(this,"iconcolor");
        iconcoloron= SharedPreferencesUtils.getString(this,"iconcoloron");
        mFragments = getFragmentList();//要显示的Fragment集合
        String[] arrayTitles = getTitles();//标题
        String[] arrayIconSelectIds = getIconSelectIds();//选中图标
        final int size = arrayTitles.length;
        for (int i = 0; i < size; i++) {
            mTabEntities.add(new TabEntity(arrayTitles[i], arrayIconSelectIds[i]));
        }
        mTabLayout.setTabData(mTabEntities);//填充数据
        mViewPager.setAdapter(new CommonPagerAdapter(getSupportFragmentManager()));
        //设置监听事件
        mTabLayout.setOnTabSelectListener(mOnTabSelectListener);
        //设置viewpage滑动监听事件
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        //默认选择第一个
        setSelectDefaultIndex(SELECT_DEFAULT_INDEX);
        mTabLayout.setTextSelectColor(Color.parseColor(iconcoloron));
        mTabLayout.setUnderlineColor(Color.parseColor(iconcolor));
    }

    /**
     * 设置默认选择第几个
     *
     * @param index 索引值
     */
    protected void setSelectDefaultIndex(int index) {
        //默认选择第一个
        if (mViewPager != null)
            mViewPager.setCurrentItem(index, false);
    }

    /**
     * 设置分割线
     *
     * @param dividerColor   颜色
     * @param dividerWidth   宽度
     * @param dividerPadding 间隔
     */
    protected void setDivisionLine(int dividerColor, float dividerWidth, float dividerPadding) {
        if (mTabLayout == null) return;
        mTabLayout.setDividerColor(dividerColor);
        mTabLayout.setDividerWidth(dividerWidth);
        mTabLayout.setDividerPadding(dividerPadding);
    }

    /**
     * 设置未读消息红点
     *
     * @param index 索引
     */
    protected void setShowDot(int index) {
        if (mTabLayout != null) {
            mTabLayout.showDot(index);
            MsgView msgView = mTabLayout.getMsgView(index);
            if (msgView != null) {
                UnreadMsgUtils.setSize(msgView, dp2px(7.5f));
            }
        }
    }

    /**
     * 设置未读条数
     *
     * @param index 索引
     * @param count 条数
     */
    protected void setUnReadMsg(int index, int count) {
        setUnReadMsg(index, count, 0);
    }

    /**
     * 设置未读条数
     *
     * @param index           索引
     * @param count           条数
     * @param backgroundColor 设置未读消息背景
     */
    protected void setUnReadMsg(int index, int count, int backgroundColor) {
        if (mTabLayout == null) return;
        //两位数
        if (count > 0 && count <= 99) {
            mTabLayout.showMsg(index, count);
            mTabLayout.setMsgMargin(0, -5, 5);
        } else if (count > 99) //三位数
        {
            mTabLayout.showMsg(index, count);
            mTabLayout.setMsgMargin(1, -5, 5);
        }
        if (backgroundColor != 0) {
            MsgView msgView = mTabLayout.getMsgView(index);
            if (msgView != null) {
                //msgView.setBackgroundColor(Color.parseColor("#6D8FB0"));
                msgView.setBackgroundColor(backgroundColor);
            }
        }
    }

    //设置监听
    private OnTabSelectListener mOnTabSelectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelect(int position) {
            SoundPlayUtils.getInstance().play();//播放声音
            //选中
            mViewPager.setCurrentItem(position, false);
        }

        @Override
        public void onTabReselect(int position) {
            //重复选中
            SoundPlayUtils.getInstance().play();//播放声音
        }
    };
    /**
     * 设置viewpage滑动监听事件
     */
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mTabLayout.setCurrentTab(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**
     * viewpage 适配器
     */
    private class CommonPagerAdapter extends FragmentPagerAdapter {
        public CommonPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getTitles()[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    /**
     * db 转换 px
     *
     * @param dp
     * @return
     */
    protected int dp2px(float dp) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * 设置布局文件
     */
    protected abstract void setContentView();

    /**
     * 标题数组
     **/
    protected abstract String[] getTitles();

    /**
     * 选择图标数组
     **/
    protected abstract String[] getIconSelectIds();



    /**
     * Fragment 集合
     **/
    protected abstract ArrayList<Fragment> getFragmentList();

    /**
     * CommonTabLayout 资源id
     **/
    protected abstract int getCommonTabLayout();

    /**
     * ViewPager 资源id
     **/
    protected abstract int getCommonViewPager();
}
