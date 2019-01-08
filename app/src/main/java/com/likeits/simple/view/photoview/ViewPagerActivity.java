package com.likeits.simple.view.photoview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.likeits.simple.R;
import com.likeits.simple.base.BaseActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ViewPagerActivity extends BaseActivity {
   @BindView(R.id.mViewPager)
    PhotoViewPager mViewPager;
  @BindView(R.id.title)
    TextView mTvTitle;

    private List<String> items;
    public static final String TAG = ViewPagerActivity.class.getSimpleName();
    private int currentPosition;
    private MyImageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        //initUI();
        initData();
    }

    private void initData() {
        items = getIntent().getStringArrayListExtra("items");
        currentPosition = getIntent().getIntExtra("currentPosition", 0);
        adapter = new MyImageAdapter(items, this);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(currentPosition, false);
        mTvTitle.setText(currentPosition + 1 + "/" + items.size());
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPosition = position;
                mTvTitle.setText(currentPosition + 1 + "/" + items.size());
            }
        });
    }


    @OnClick(R.id.toolbar_left_iv)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_iv:
                finish();
                break;
        }
    }
}
