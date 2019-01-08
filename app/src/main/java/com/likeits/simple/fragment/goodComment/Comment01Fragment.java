package com.likeits.simple.fragment.goodComment;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.adapter.comment.GoodCommentListAdapter;
import com.likeits.simple.base.BaseFragment;
import com.likeits.simple.fragment.goods.GoodDetail03Fragment;
import com.likeits.simple.network.GoodCommentmodel;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.util.RetrofitUtil;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class Comment01Fragment extends BaseFragment {
//    @BindView(R.id.mSwipeRefreshLayout)
//    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    private GoodCommentListAdapter mAdapter;
    private String id;
    private List<GoodCommentmodel.ListBean> data;

    @Override
    protected int setContentView() {
        return R.layout.fragment_comment01;
    }

    @Override
    protected void lazyLoad() {
        //id = getArguments().getString("id");
        id = "526";
        initData();

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
                    data = baseResponse.getData().getList();
                    initAdapter();
                }

            }
        });
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new GoodCommentListAdapter(R.layout.comment_list01, data);
        // mAdapter.setOnLoadMoreListener(getActivity(), mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

}
