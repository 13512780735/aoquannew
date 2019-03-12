package com.likeit.aqe365.fragment.goods;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.comment.GoodCommentAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.fragment.goodComment.Comment01Fragment;
import com.likeit.aqe365.fragment.goodComment.Comment02Fragment;
import com.likeit.aqe365.fragment.goodComment.Comment03Fragment;
import com.likeit.aqe365.fragment.goodComment.Comment04Fragment;
import com.likeit.aqe365.fragment.goodComment.Comment05Fragment;
import com.likeit.aqe365.network.model.GoodCommentmodel;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.view.NoScrollViewPager;
import com.likeit.aqe365.view.tablayout.bean.CustomTabEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodDetail04Fragment extends BaseFragment {
    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    NoScrollViewPager mViewpager;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();//存放自定义tab 实体集合
    private ArrayList<Fragment> mFragments = null;//Fragment 集合
    private String id;
    private String[] mTitles = {"全部", "好评", "中评", "差评", "晒图"};
    private GoodCommentAdapter mAdapter;
    String[] mNumber = new String[5];

    @Override
    protected int setContentView() {
        return R.layout.fragment_good_detail04;
    }

    @Override
    protected void lazyLoad() {
        id = getArguments().getString("id");
        id = "716";
        initData();

    }

    private void initUI() {
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        //  mTabLayout.setupWithViewPager(mViewpager);
        List<Fragment> mfragments = new ArrayList<>();
        Comment01Fragment comment01Fragment = new Comment01Fragment();
        Comment02Fragment comment02Fragment = new Comment02Fragment();
        Comment03Fragment comment03Fragment = new Comment03Fragment();
        Comment04Fragment comment04Fragment = new Comment04Fragment();
        Comment05Fragment comment05Fragment = new Comment05Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        comment01Fragment.setArguments(bundle);
        comment02Fragment.setArguments(bundle);
        comment03Fragment.setArguments(bundle);
        comment04Fragment.setArguments(bundle);
        comment05Fragment.setArguments(bundle);
        mfragments.add(comment01Fragment);
        mfragments.add(comment02Fragment);
        mfragments.add(comment03Fragment);
        mfragments.add(comment04Fragment);
        mfragments.add(comment05Fragment);
        // mViewpager.setAdapter(new GoodDetailTabAdapter(getChildFragmentManager(), mfragments, mTitles));
        mAdapter = new GoodCommentAdapter(getChildFragmentManager(), mfragments);
        mViewpager.setAdapter(mAdapter);
        //   mViewpager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewpager);
        for (int i = 0; i < mAdapter.getCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);//获得每一个tab
            tab.setCustomView(R.layout.comment_tab_tex);//给每一个tab设置view
            if (i == 0) {
                // 设置第一个tab的TextView是被选择的样式
                tab.getCustomView().findViewById(R.id.tab_text).setSelected(true);//第一个tab被选中
                tab.getCustomView().findViewById(R.id.tab_number).setSelected(true);//第一个tab被选中
            }
            TextView tab_name = (TextView) tab.getCustomView().findViewById(R.id.tab_text);
            TextView tab_number = (TextView) tab.getCustomView().findViewById(R.id.tab_number);
            tab_name.setText(mTitles[i]);//设置tab上的文字
            tab_number.setText(mNumber[i]);
        }
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.tab_text).setSelected(true);
                tab.getCustomView().findViewById(R.id.tab_number).setSelected(true);
                mViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().findViewById(R.id.tab_text).setSelected(false);
                tab.getCustomView().findViewById(R.id.tab_number).setSelected(false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initData() {
        LoaddingShow();
        RetrofitUtil.getInstance().GetCommentList(id, "all", new Subscriber<BaseResponse<GoodCommentmodel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<GoodCommentmodel> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.getCode() == 200) {
                    mNumber[0] = baseResponse.getData().getCount().getAll();
                    mNumber[1] = baseResponse.getData().getCount().getGood();
                    mNumber[2] = baseResponse.getData().getCount().getNormal();
                    mNumber[3] = baseResponse.getData().getCount().getBad();
                    mNumber[4] = baseResponse.getData().getCount().getPic();
                    XLog.e("mNumber-->" + mNumber);
                    initUI();
                }

            }
        });
    }

}
