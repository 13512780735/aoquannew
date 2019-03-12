package com.likeit.aqe365.fragment.find;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.find.AllFind01Adapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.find.PostListModel;
import com.likeit.aqe365.network.model.member.CouponCenterModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFindFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    private int pageNum = 1;
    private static final int PAGE_SIZE = 1;//为什么是6呢？
    private boolean isErr;
    private boolean mLoadMoreEndGone = false; //是否加载更多完毕
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private String id;
    private AllFind01Adapter mAdapter;
    /**
     * 推荐
     */
    private List<PostListModel.ListBean> data;
    private PostListModel postListModel;


    @Override
    protected int setContentView() {
        return R.layout.fragment_all_find;
    }

    @Override
    protected void lazyLoad() {



        Log.d("TAG989", SharedPreferencesUtils.getString(getActivity(),"city") + SharedPreferencesUtils.getString(getActivity(),"lat") + SharedPreferencesUtils.getString(getActivity(),"lng"));

        Bundle bundle = getArguments();
        id = bundle.getString("id");
        XLog.e("id:" + id);
        // initUI();
        if ("推荐".equals(id)) {
             initUI1();
        } else if ("关注".equals(id)) {
        } else if ("话题".equals(id)) {
            initUI1();
        } else if ("附近".equals(id)) {
        } else if ("用户".equals(id)) {
        } else if ("医院".equals(id)) {
        }
    }

    private void initUI1() {
        data = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager( 2,StaggeredGridLayoutManager.VERTICAL));
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new AllFind01Adapter(R.layout.layout_recomment_items, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();
    }

    private void initData(int pageNum, final boolean isloadmore) {
        String lat = SharedPreferencesUtils.getString(getContext(), "lat");
        String lng = SharedPreferencesUtils.getString(getContext(), "lng");
        RetrofitUtil.getInstance().Postlist(openid, String.valueOf(pageNum), "", lat, lng,"isrecommend","", new Subscriber<BaseResponse<PostListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<PostListModel> baseResponse) {
                if (baseResponse.code == 200) {
                    postListModel = baseResponse.getData();
                    List<PostListModel.ListBean> list = postListModel.getList();
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

    private void initUI() {
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMoreRequested() {

    }
}
