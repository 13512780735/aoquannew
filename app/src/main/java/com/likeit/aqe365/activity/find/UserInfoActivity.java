package com.likeit.aqe365.activity.find;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.fragment.find.AllFind02Fragment;
import com.likeit.aqe365.fragment.find.AllFind03Fragment;
import com.likeit.aqe365.fragment.find.AllFind04Fragment;
import com.likeit.aqe365.fragment.find.AllFind05Fragment;
import com.likeit.aqe365.fragment.find.AllFindFragment;
import com.likeit.aqe365.fragment.find.TopicListFragment;
import com.likeit.aqe365.fragment.find.user.UserInfo01Fragment;
import com.likeit.aqe365.fragment.find.user.UserInfo02Fragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtil;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.NoScrollViewPager;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import rx.Subscriber;

public class UserInfoActivity extends BaseActivity {
    private ArrayList<String> mTitles;
    private String memberid;
    private String isuser, avatar, name;
    @BindView(R.id.indent_TabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    NoScrollViewPager mViewPager;

    @BindView(R.id.iv_avatar)
    CircleImageView iv_avatar;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_attention)
    BorderTextView tv_attention;
    @BindView(R.id.tv_chat)
    TextView tv_chat;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info2);
        memberid = getIntent().getExtras().getString("id");
        isuser = getIntent().getExtras().getString("isuser");
        avatar = getIntent().getExtras().getString("avatar");
        name = getIntent().getExtras().getString("name");
        mTitles = new ArrayList<>(Arrays.asList("日记", "帖子"));
        initUI();
    }

    private void initUI() {
        setBackView();
        setTitle("用户主页");
        ImageLoader.getInstance().displayImage(avatar, iv_avatar);
        tv_name.setText(name);
        mTabLayout = findViewById(R.id.indent_TabLayout);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor(theme_bg_tex));
        mTabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor(theme_bg_tex));
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
        if ("0".equals(isuser)) {
            tv_attention.setContentColorResource01(Color.parseColor(theme_bg_tex));
            tv_attention.setStrokeColor01(Color.parseColor(theme_bg_tex));
            tv_attention.setTextColor(Color.parseColor("#ffffff"));
            tv_attention.setText("+ 关注");
        } else {
            tv_attention.setContentColorResource01(Color.parseColor("#FFFFFF"));
            tv_attention.setStrokeColor01(Color.parseColor("#DBDBDB"));
            tv_attention.setTextColor(Color.parseColor("#DBDBDB"));
            tv_attention.setText("已关注");
        }
        tv_attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("0".equals(isuser)) {
                    isuser = "1";
                    tv_attention.setContentColorResource01(Color.parseColor("#FFFFFF"));
                    tv_attention.setStrokeColor01(Color.parseColor("#DBDBDB"));
                    tv_attention.setTextColor(Color.parseColor("#DBDBDB"));
                    tv_attention.setText("已关注");
                } else {
                    isuser = "0";
                    tv_attention.setContentColorResource01(Color.parseColor(theme_bg_tex));
                    tv_attention.setStrokeColor01(Color.parseColor(theme_bg_tex));
                    tv_attention.setTextColor(Color.parseColor("#ffffff"));
                    tv_attention.setText("+ 关注");
                }
                attention();
            }
        });
    }

    private void attention() {
        RetrofitUtil.getInstance().Followmember(openid, memberid, new Subscriber<BaseResponse<EmptyEntity>>() {
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
                    bundle = new Bundle();
                    bundle.putString("id", mTitles.get(position));
                    bundle.putString("memberid", memberid);
                    UserInfo01Fragment tab1 = new UserInfo01Fragment();
                    tab1.setArguments(bundle);
                    return tab1;
                case 1:
                    bundle = new Bundle();
                    bundle.putString("id", mTitles.get(position));
                    bundle.putString("memberid", memberid);
                    UserInfo02Fragment tab2 = new UserInfo02Fragment();
                    tab2.setArguments(bundle);
                    return tab2;
            }

            return null;
        }

    }
}
