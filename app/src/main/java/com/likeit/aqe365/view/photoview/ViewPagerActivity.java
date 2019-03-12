package com.likeit.aqe365.view.photoview;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;

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
