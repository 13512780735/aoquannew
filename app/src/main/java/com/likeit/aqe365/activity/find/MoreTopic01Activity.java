package com.likeit.aqe365.activity.find;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.view.BorderRelativeLayout;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.CustomTagLayout;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutAdapter;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutScrollView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class MoreTopic01Activity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    private int pageNum = 1;
    private static final int PAGE_SIZE = 6;//为什么是6呢？
    private boolean isErr = true;
    private boolean mLoadMoreEndGone = false; //是否加载更多完毕
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;

    private FlowLayoutAdapter<BoardListModel.ListBean> flowLayoutAdapter;
    private ArrayList<BoardListModel.ListBean> list1;
    @BindView(R.id.tagLayout)
    CustomTagLayout mTagLayout;
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
    private String content;

    List<BoardListModel.ListBean> data = new ArrayList<>();
    ArrayList<BoardListModel.ListBean> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_topic01);
        //  mFlowLayoutScrollView = findView(R.id.flsv);
        list1 = (ArrayList<BoardListModel.ListBean>) getIntent().getExtras().getSerializable("data");
        XLog.e("list1:" + list1);
        mList = list1;

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
                bundle.putSerializable("data", (Serializable) mList);
                intent.putExtras(bundle);
                setResult(101, intent);
                finish();
            }
        });
        edContent.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    // keyword = search_content_et.getText().toString().trim();
                    initData(1, false);
                    hideinfo();

                }
                return false;
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        initAdapter();

        initLayout(mList);


    }

    private void hideinfo() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    private void initLayout(ArrayList<BoardListModel.ListBean> list) {
        //移除所有自布局
        mTagLayout.removeAllViewsInLayout();


        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(MoreTopic01Activity.this).inflate(R.layout.item_layout01, mTagLayout, false);
            view.setTag(i);
            BorderTextView text = (BorderTextView) view.findViewById(R.id.tv_name);
            text.setText(mList.get(i).getTitle() + "  X");
            //点击移除标签
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = (int) view.getTag();
                    mTagLayout.removeView(view);
                    mList.remove(i);
                    initLayout(mList);
                }
            });
            mTagLayout.addView(view);
        }
        //   mTagLayout.addView(mEtInput);
        //mTagLayout.addView(mLlAdd);
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
                XLog.e("position" + position);
                if (mList != null) {
                    for (int i = 0; i < mList.size(); i++) {
                        if (data.get(position).getId().equals(mList.get(i).getId())) {
                            return;
                        }
                    }
                    //将新加入的数据加到集合的最后一个位置,而原来的添加图标会到 +1 的位置
                    mList.add(data.get(position));
                    initLayout(mList);
                } else {
                    mList.add(data.get(position));
                    initLayout(mList);
                }

            }
        });
    }

    @OnClick({R.id.tv_search})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_search:
                initData(1, false);
                hideinfo();
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
