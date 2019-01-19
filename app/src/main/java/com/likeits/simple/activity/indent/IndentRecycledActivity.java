package com.likeits.simple.activity.indent;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.likeits.simple.R;
import com.likeits.simple.adapter.indent.GoodIndent01Adapter;
import com.likeits.simple.adapter.indent.IndentRecyckedAdapter;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.EmptyEntity;
import com.likeits.simple.network.model.Indent.IndentListModel;
import com.likeits.simple.network.util.RetrofitUtil;
import com.likeits.simple.wxapi.PayActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

public class IndentRecycledActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private IndentRecyckedAdapter mAdapter;

    private int pageNum = 1;
    private static final int PAGE_SIZE = 1;//为什么是6呢？
    private boolean isErr = true;
    private boolean mLoadMoreEndGone = false; //是否加载更多完毕
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;
    private Bundle bundle;
    private IndentListModel indentListModel;
    private String id;
    private String userdeleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_recycled);
        initUI();
    }

    private void initUI() {
        setBackView();
        setTitle("回收站");
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.rl_indent_details://订单详情
                        id = data.get(position).getId();
                        bundle = new Bundle();
                        bundle.putInt("status", 9999);
                        bundle.putString("flag", "1");
                        bundle.putString("id", id);
                        toActivity(IndentDetailsActivity.class, bundle);
                        break;
                    case R.id.tv_del_indent://删除订单
                        id = data.get(position).getId();
                        userdeleted = "2";
                        deleteIndent(id, userdeleted);
                        break;
                    case R.id.tv_recover_goods://恢复订单
                        id = data.get(position).getId();
                        userdeleted = "0";
                        deleteIndent(id, userdeleted);
                        break;
                    case R.id.tv_check_wuLiu://查看无聊
                        break;
                    case R.id.tv_confirm_goods://确认售后
                        break;
                }
            }
        });
    }

    private void deleteIndent(String id, String userdeleted) {
        RetrofitUtil.getInstance().orderDelete(openid, id, userdeleted, new Subscriber<BaseResponse<EmptyEntity>>() {
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
                    onRefresh();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    private void initAdapter() {

        mAdapter = new IndentRecyckedAdapter(R.layout.goods_indent_items, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();
    }

    private List<IndentListModel.ListBean> data = new ArrayList<>();

    public void initData(int pageNum, final boolean isloadmore) {
        LoaddingShow();
        RetrofitUtil.getInstance().Orderform(openid, "7", String.valueOf(pageNum), new Subscriber<BaseResponse<IndentListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<IndentListModel> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.code == 200) {
                    indentListModel = baseResponse.getData();
                    List<IndentListModel.ListBean> list = indentListModel.getList();

                    if (list != null && list.size() > 0) {
                        if (!isloadmore) {
                            data = list;
                        } else {
                            data.addAll(list);
                        }
                        mAdapter.setNewData(data);
                        mAdapter.notifyDataSetChanged();
                    } else {

                        mAdapter.setEmptyView(R.layout.notdata_view);
                    }

                } else {
                    showProgress(baseResponse.getMsg());
                }
            }
        });
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        TOTAL_COUNTER = Integer.valueOf(indentListModel.getTotal());
        if (mAdapter.getData().size() < PAGE_SIZE) {
            mAdapter.loadMoreEnd(true);
        } else {
            if (mCurrentCounter >= TOTAL_COUNTER) {
                mAdapter.loadMoreEnd(mLoadMoreEndGone);
            } else {
                if (isErr) {
                    pageNum += 1;
                    initData(pageNum, true);
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
                isErr = true;
                mCurrentCounter = PAGE_SIZE;
                pageNum = 1;//页数置为1 才能继续重新加载
                initData(pageNum, false);
                mSwipeRefreshLayout.setRefreshing(false);
                mAdapter.setEnableLoadMore(true);//启用加载
            }
        }, 2000);
    }

}
