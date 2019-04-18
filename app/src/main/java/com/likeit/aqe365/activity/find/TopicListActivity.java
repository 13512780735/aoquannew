package com.likeit.aqe365.activity.find;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.fragment.find.TopicListFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.view.BorderRelativeLayout;
import com.likeit.aqe365.view.IconfontTextView;
import com.likeit.aqe365.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import onekeyshare.OnekeyShare;
import rx.Subscriber;

public class TopicListActivity extends BaseActivity {

    private String bid, isattention, title;
    private ArrayList<String> mTitles;
    @BindView(R.id.indent_TabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.rl_attention)
    BorderRelativeLayout rl_attention;
    @BindView(R.id.tv_attention)
    IconfontTextView tv_attention;
    @BindView(R.id.tv_share)
    IconfontTextView tv_share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);
        bid = getIntent().getExtras().getString("bid");
        title = getIntent().getExtras().getString("title");
        isattention = getIntent().getExtras().getString("isattention");  //0是未关注 1是关注
        mTitles = new ArrayList<>(Arrays.asList("推荐", "最新"));//, "医院"
        initUI();

    }

    private void initUI() {
        setBackView();
        setTitle(title);
        setRightText02(getResources().getString(R.string.ic_publish), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(PostActivity.class);
            }
        });
        mTabLayout = findViewById(R.id.indent_TabLayout);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor(theme_bg_tex));
        mTabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor(theme_bg_tex));
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);

        if ("0".equals(isattention)) {
            rl_attention.setContentColorResource01(Color.parseColor("#FF727A"));
            rl_attention.setStrokeColor01(Color.parseColor("#FF727A"));
            tv_attention.setText("关注");
        } else {
            rl_attention.setContentColorResource01(Color.parseColor("#DBDBDB"));
            rl_attention.setStrokeColor01(Color.parseColor("#DBDBDB"));
            tv_attention.setText("已关注");
        }

//        tv_share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showShare();
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
            //创建fragment对象并返回
            Bundle bundle = new Bundle();
            bundle.putString("id", mTitles.get(position));
            bundle.putString("bid", bid);
            //实例化Fragment
            TopicListFragment topicListFragment = new TopicListFragment();
            topicListFragment.setArguments(bundle);
            return topicListFragment;
        }

    }

    @OnClick({R.id.tv_share, R.id.rl_attention})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_share:
                showShare("");
                break;
            case R.id.rl_attention:
                if ("0".equals(isattention)) {
                    isattention = "1";
                    rl_attention.setContentColorResource01(Color.parseColor("#DBDBDB"));
                    rl_attention.setStrokeColor01(Color.parseColor("#DBDBDB"));
                    tv_attention.setText("已关注");
                } else {
                    isattention = "0";
                    rl_attention.setContentColorResource01(Color.parseColor("#FF727A"));
                    rl_attention.setStrokeColor01(Color.parseColor("#FF727A"));
                    tv_attention.setText("关注");
                }
                attention();
                break;
        }
    }

    private void attention() {
        RetrofitUtil.getInstance().GetFollow(openid, bid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    showToast(baseResponse.getMsg());
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

}
