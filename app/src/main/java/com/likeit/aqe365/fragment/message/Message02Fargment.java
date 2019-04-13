package com.likeit.aqe365.fragment.message;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.find.DiaryDetailsActivity;
import com.likeit.aqe365.activity.find.JournalDetailsActivity;
import com.likeit.aqe365.activity.find.MoodDetailActivity;
import com.likeit.aqe365.activity.find.MoodVideoDetailsActivity;
import com.likeit.aqe365.activity.find.PostDetailsActivity;
import com.likeit.aqe365.activity.find.TopicListActivity;
import com.likeit.aqe365.activity.find.VideoDetailsActivity;
import com.likeit.aqe365.adapter.find.AllFind03Adapter;
import com.likeit.aqe365.adapter.message.MessageListAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.network.model.member.MessageListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.StringUtil;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/**
 * 评论
 */
public class Message02Fargment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

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
    private MessageListAdapter mAdapter;
    /**
     * 话题
     */
    private List<MessageListModel.ListBean> data;
    private MessageListModel messageListModel;
    private String type;

    @Override
    protected int setContentView() {
        return R.layout.layout_message_list;
    }

    @Override
    protected void lazyLoad() {
        type = "comment";
        initUI();
    }

    private void initUI() {
        //data = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new MessageListAdapter(R.layout.message_list_items, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String type = data.get(position).getType();
                String postid = data.get(position).getPostid();
                String journalid = data.get(position).getJournalid();
                String diaryid = data.get(position).getDiaryid();
                String moodid = data.get(position).getMoodid();
                String pid = data.get(position).getPid();
                String memberid = data.get(position).getMemberid();
                Bundle bundle = new Bundle();
                if ("0".equals(type)) {
                    if (!StringUtil.isBlank(postid)) {
                        bundle.putString("id", pid);
                        toActivity(PostDetailsActivity.class, bundle);
                    } else if (!StringUtil.isBlank(journalid)) {
                        bundle.putString("id", pid);
                        toActivity(JournalDetailsActivity.class, bundle);
                    } else if (!StringUtil.isBlank(diaryid)) {
                        bundle.putString("diaryid", pid);
                        bundle.putString("memberid", memberid);
                        toActivity(DiaryDetailsActivity.class, bundle);
                    } else if (!StringUtil.isBlank(moodid)) {
                        bundle.putString("id", pid);
                        toActivity(MoodDetailActivity.class, bundle);
                        String types = data.get(position).getType();
                    }
                } else if ("1".equals(type)) {
                    if (!StringUtil.isBlank(postid)) {
                        bundle.putString("id", pid);
                        toActivity(VideoDetailsActivity.class, bundle);
                    } else if (!StringUtil.isBlank(moodid)) {
                        bundle.putString("id", pid);
                        toActivity(MoodVideoDetailsActivity.class, bundle);
                    }
                }
            }
        });
    }

    private void initData(int pageNum, final boolean isloadmore) {
        RetrofitUtil.getInstance().myMessageList(openid, type, String.valueOf(pageNum), new Subscriber<BaseResponse<MessageListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<MessageListModel> baseResponse) {
                if (baseResponse.code == 200) {
                    messageListModel = baseResponse.getData();
                    List<MessageListModel.ListBean> list = messageListModel.getList();
                    TOTAL_COUNTER = Integer.valueOf(messageListModel.getTotal());
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
