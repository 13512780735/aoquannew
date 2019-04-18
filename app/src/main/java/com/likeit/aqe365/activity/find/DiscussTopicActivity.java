package com.likeit.aqe365.activity.find;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.user.MyHuaTiActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.RoundImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/**
 * 话题讨论
 */
public class DiscussTopicActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

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
    private HuaTiAdapter mAdapter;
    /**
     * 话题
     */
    private List<BoardListModel.ListBean> data;
    private BoardListModel boardListModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discuss_topic);
        initUI();
    }

    private void initUI() {
        setBackView();
        setTitle("话题讨论");
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new HuaTiAdapter(R.layout.huati_items, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("bid", data.get(position).getId());
                bundle.putString("title", data.get(position).getTitle());
                bundle.putString("isattention", data.get(position).getIsattention());
                toActivity(TopicListActivity.class, bundle);
            }
        });
    }


    private void initData(int pageNum, final boolean isloadmore) {
        RetrofitUtil.getInstance().GetBoardlist(openid, "", "", String.valueOf(pageNum), new Subscriber<BaseResponse<BoardListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<BoardListModel> baseResponse) {
                if (baseResponse.code == 200) {
                    boardListModel = baseResponse.getData();
                    List<BoardListModel.ListBean> list = boardListModel.getList();
                    TOTAL_COUNTER = Integer.valueOf(boardListModel.getTotal());
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

    public class HuaTiAdapter extends BaseQuickAdapter<BoardListModel.ListBean, BaseViewHolder> {
        public HuaTiAdapter(int layoutResId, @Nullable List<BoardListModel.ListBean> data) {
            super(R.layout.huati_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, BoardListModel.ListBean item) {
            helper.setText(R.id.tv_title, "#" + item.getTitle());
            helper.setText(R.id.tv_num, item.getParticipant() + "人" + "     " + item.getPostcount() + "帖子");
            ImageLoader.getInstance().displayImage(item.getLogo(), (RoundImageView) helper.getView(R.id.iv_img));
            ImageView iv_more = helper.getView(R.id.iv_more);
            iv_more.setVisibility(View.VISIBLE);
        }
    }
}
