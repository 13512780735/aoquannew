package com.likeit.aqe365.fragment.find;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.find.UserInfoActivity;
import com.likeit.aqe365.adapter.find.AllFind01Adapter;
import com.likeit.aqe365.adapter.find.AllFind05Adapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.find.PostListModel;
import com.likeit.aqe365.network.model.find.UserListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/** 用户
 * A simple {@link Fragment} subclass.
 */
public class AllFind05Fragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    private int pageNum = 1;
    private static final int PAGE_SIZE = 6;//为什么是6呢？
    private boolean isErr = true;
    private boolean mLoadMoreEndGone = false; //是否加载更多完毕
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;


    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private String id;
    private List<UserListModel.ListBean> data;
    private AllFind05Adapter mAdapter;
    private UserListModel userListModel;

    @Override
    protected int setContentView() {
        return R.layout.fragment_all_find05;
    }

    @Override
    protected void lazyLoad() {
        initUI();
    }

    private void initUI() {
        // data = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new AllFind05Adapter(R.layout.find_user_listitem, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("id", data.get(position).getId());
//                bundle.putString("isuser", data.get(position).getIsuser());
//                bundle.putString("avatar", data.get(position).getAvatar());
//                bundle.putString("name", data.get(position).getNickname());
//
//                SharedPreferencesUtils.put(getActivity(), "avatar", data.get(position).getAvatar());
//                SharedPreferencesUtils.put(getActivity(), "name", data.get(position).getNickname());
                toActivity(UserInfoActivity.class, bundle);
            }
        });
    }

    private void initData(int pageNum, final boolean isloadmore) {
        XLog.e("lat:"+lat);
        XLog.e("lng:"+lng);
        RetrofitUtil.getInstance().GetUser(openid, "", lat, lng, String.valueOf(pageNum), new Subscriber<BaseResponse<UserListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<UserListModel> baseResponse) {
                XLog.e("total:" + baseResponse.getData().getTotal());
                if (baseResponse.code == 200) {
                    userListModel = baseResponse.getData();
                    List<UserListModel.ListBean> list = userListModel.getList();
                    TOTAL_COUNTER = Integer.valueOf(userListModel.getTotal());
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
    public void onRefresh() {
        mAdapter.setEnableLoadMore(false);//禁止加载
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mAdapter.setNewData(data);
                isErr = false;
                mCurrentCounter = PAGE_SIZE;
                pageNum = 1;//页数置为1 才能继续重新加载
                initData(pageNum, false);
                mSwipeRefreshLayout.setRefreshing(false);
                mAdapter.setEnableLoadMore(true);//启用加载
            }
        }, 2000);
    }

    @Override
    public void onLoadMoreRequested() {

        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mCurrentCounter >= TOTAL_COUNTER) {
                    //数据全部加载完毕
                    mAdapter.loadMoreEnd();
                } else {
                    if (isErr) {
                        //成功获取更多数据
                        //  mQuickAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
                        pageNum += 1;
                        initData(pageNum, true);
                        mCurrentCounter = mAdapter.getData().size();
                        mAdapter.loadMoreComplete();
                    } else {
                        //获取更多数据失败
                        isErr = true;
                        mAdapter.loadMoreFail();

                    }
                }
            }

        }, 3000);
    }
}
