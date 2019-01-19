package com.likeits.simple.fragment.coupon;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.likeits.simple.R;
import com.likeits.simple.activity.user.CouponActivity;
import com.likeits.simple.adapter.div_provider.member.CouponListAdapter;
import com.likeits.simple.base.BaseFragment;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.CaseEntity;
import com.likeits.simple.network.model.member.CouponListModel;
import com.likeits.simple.network.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class Coupon01Fragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.ll_more)
    LinearLayout ll_more;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private List<CouponListModel.ListBean> data;
    private CouponListAdapter mAdapter;

    private int pageNum = 1;
    private static final int PAGE_SIZE = 6;//为什么是6呢？
    private boolean isErr;
    private boolean mLoadMoreEndGone = false; //是否加载更多完毕
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;

    @Override
    protected int setContentView() {
        return R.layout.fragment_coupon01;
    }

    @Override
    protected void lazyLoad() {
        initUI();
    }

    private void initUI() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initData();

    }
    private void initAdapter() {

        mAdapter = new CouponListAdapter(R.layout.layout_coupon_listview_items, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mCurrentCounter = mAdapter.getData().size();
    }
    public void initData() {
        data = new ArrayList<>();
        LoaddingShow();
        RetrofitUtil.getInstance().GetCouponList(openid, "",String.valueOf(pageNum), new Subscriber<BaseResponse<CouponListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<CouponListModel> baseResponse) {
                LoaddingDismiss();
                if(baseResponse.getCode()==200){
                    data=baseResponse.getData().getList();
                    initAdapter();
                }
            }
        });


    }
    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        //  TOTAL_COUNTER = Integer.valueOf(myfollowModel.getTotal());
        if (mAdapter.getData().size() < PAGE_SIZE) {
            mAdapter.loadMoreEnd(true);
        } else {
            if (mCurrentCounter >= TOTAL_COUNTER) {
                mAdapter.loadMoreEnd(mLoadMoreEndGone);
            } else {
                if (isErr) {
                    pageNum += 1;
                    //  initDate(pageNum, true);
                    //    mAdapter.addData(data);
                    mCurrentCounter = mAdapter.getData().size();
                    mAdapter.loadMoreComplete();
                } else {
                    isErr = true;
                    // Toast.makeText(getContext(), "错误", Toast.LENGTH_LONG).show();
                    mAdapter.loadMoreFail();
                }
            }
            mSwipeRefreshLayout.setEnabled(true);
        }
    }

    @Override
    public void onRefresh() {
        mAdapter.setEnableLoadMore(false);//禁止加载
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mAdapter.setNewData(data);
                isErr = false;
                mCurrentCounter = PAGE_SIZE;
                pageNum = 1;//页数置为1 才能继续重新加载
                mSwipeRefreshLayout.setRefreshing(false);
                mAdapter.setEnableLoadMore(true);//启用加载
            }
        }, 2000);
    }

    @OnClick({R.id.ll_more})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ll_more:
                toActivity(CouponActivity.class);
                break;
        }
    }

}
