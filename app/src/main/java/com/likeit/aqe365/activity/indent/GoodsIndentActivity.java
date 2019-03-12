package com.likeit.aqe365.activity.indent;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.MainActivity;
import com.likeit.aqe365.adapter.indent.GoodsIndentTabAdapter;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.main.MainNavigationModel;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.view.NoScrollViewPager;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodsIndentActivity extends BaseActivity {
    private List<String> mTitles;
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;
    private int status;
    private String flag;

    private String[] mIconSelectIds;//标题
    private String[] mTitles01;//未选中

    private String[] mLinkurl;


    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayList<String> stringArrayList1 = new ArrayList<String>();
    ArrayList<String> stringArrayList2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_indent);
        mTitles = new ArrayList<>(Arrays.asList("全部", "待付款", "待发货", "待收货", "已完成"));
        status = getIntent().getExtras().getInt("status");
        flag = getIntent().getStringExtra("flag"); //1从收银台过来，0从个人中心
        Log.e("TAG", status + "");
        initTab();
        initView();
        initData();
    }

    private void initView() {
        //   setBackView();
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
        findView(R.id.back_view).setVisibility(View.VISIBLE);
        findView(R.id.back_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
        setRightText("回收站", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toActivity(IndentRecycledActivity.class);
            }
        });
    }

    private void startMainActivity() {
        Bundle bundle = new Bundle();
        //  bundle.putString("flag", "0");
        bundle.putStringArray("mTitles", mTitles01);
        bundle.putStringArray("mLinkurl", mLinkurl);
        bundle.putStringArray("mIconSelectIds", mIconSelectIds);
        bundle.putString("flag", "1");
        bundle.putInt("index", 4);
        Intent intent = new Intent(GoodsIndentActivity.this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startMainActivity();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void initTab() {
        String navtab = SharedPreferencesUtils.getString(mContext, "navtab");
        Type type = new TypeToken<List<MainNavigationModel.ItemsBean>>() {
        }.getType();
        List<MainNavigationModel.ItemsBean> items = new Gson().fromJson(navtab, type);
        for (int i = 0; i < items.size(); i++) {
            stringArrayList.add(items.get(i).getText());
            stringArrayList1.add(StringUtil.decode("\\u" + items.get(i).getIconclasscode()));
            stringArrayList2.add(items.get(i).getLinkurl());
        }
        mTitles01 = stringArrayList.toArray(new String[stringArrayList.size()]);
        mLinkurl = stringArrayList2.toArray(new String[stringArrayList2.size()]);
        mIconSelectIds = stringArrayList1.toArray(new String[stringArrayList1.size()]);

    }

    public void initData() {
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }


//        mViewPager.setCurrentItem(status);
}
