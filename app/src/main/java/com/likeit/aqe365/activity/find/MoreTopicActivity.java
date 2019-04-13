package com.likeit.aqe365.activity.find;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.find.AllFind03Adapter;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutAdapter;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutScrollView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class MoreTopicActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    private int pageNum = 1;
    private static final int PAGE_SIZE = 6;//为什么是6呢？
    private boolean isErr = true;
    private boolean mLoadMoreEndGone = false; //是否加载更多完毕
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;

    private List<BoardListModel.ListBean> list;
    private FlowLayoutAdapter<BoardListModel.ListBean> flowLayoutAdapter;
    private List<BoardListModel.ListBean> list1;
    @BindView(R.id.ed_content)
    EditText edContent;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private BoardListModel boardListModel;
    private MoreTopicAdapter mAdapter;
    List<BoardListModel.ListBean> data = new ArrayList<>();
    private String content;
    private FlowLayoutScrollView mFlowLayoutScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_topic);
        mFlowLayoutScrollView = findView(R.id.flsv);
        list = new ArrayList<>();
        list1 = (List<BoardListModel.ListBean>) getIntent().getExtras().getSerializable("data");
        XLog.e("list1:" + list1);
        list = list1;

        XLog.e("list:" + list);
        initUI();
    }

    private void initUI() {
        setBackView();
        setTitle("话题");
        setRightText("确认", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", (Serializable) list);
                intent.putExtras(bundle);
                setResult(101, intent);
                finish();
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        initAdapter();

        initflowLayout();


    }

    private void initflowLayout() {
        /**
         * 话题数据
         */
        flowLayoutAdapter = new FlowLayoutAdapter<BoardListModel.ListBean>(list) {
            @Override
            public void bindDataToView(ViewHolder holder, int position, BoardListModel.ListBean bean) {
                if (position == 0) {
                    holder.setViewGone(R.id.tv);
                } else {
                    holder.setViewVisible(R.id.tv);
                    holder.setText(R.id.tv, bean.getTitle());
                }


            }

            @Override
            public void onItemClick(int position, BoardListModel.ListBean bean) {
                if (position == 0) {
                    return;
                } else {
                    remove(position);
                }
            }

            @Override
            public int getItemLayoutID(int position, BoardListModel.ListBean bean) {
                if (position == 0) {
                    return R.layout.item_layout_01;
                }
                return R.layout.item_layout;
            }
        };
        mFlowLayoutScrollView.setAdapter(flowLayoutAdapter);

    }

    private void initAdapter() {
        mAdapter = new MoreTopicAdapter(R.layout.moretopic_listview_items, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        mCurrentCounter = mAdapter.getData().size();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //   mFlowLayoutScrollView.setVisibility(View.VISIBLE);
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (data.get(position).getId().equals(list.get(i).getId())) {
                            return;
                        }
                    }
                    list.add(data.get(position));
                    flowLayoutAdapter.notifyDataSetChanged();
                } else {
                    list.add(data.get(position));
                    flowLayoutAdapter.notifyDataSetChanged();
                }

            }
        });
    }

    @OnClick({R.id.tv_search})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_search:
                mAdapter.setEnableLoadMore(false);
                isErr = false;
                mCurrentCounter = PAGE_SIZE;
                initData(1, false);
                mSwipeRefreshLayout.setRefreshing(false);
                mAdapter.setEnableLoadMore(true);//启用加载
                break;
        }
    }

    private void initData(int page, final boolean isloadmore) {
        content = edContent.getText().toString();
        RetrofitUtil.getInstance().postTopiclist(openid, content, String.valueOf(page), new Subscriber<BaseResponse<BoardListModel>>() {
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

    public class MoreTopicAdapter extends BaseQuickAdapter<BoardListModel.ListBean, BaseViewHolder> {

        public MoreTopicAdapter(int layoutResId, List<BoardListModel.ListBean> data) {
            super(R.layout.moretopic_listview_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, BoardListModel.ListBean item) {
            helper.setText(R.id.tv_name, "#" + item.getTitle());
        }
    }
}
