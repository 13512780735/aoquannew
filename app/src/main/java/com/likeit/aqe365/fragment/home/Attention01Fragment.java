package com.likeit.aqe365.fragment.home;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.find.MoodDetailActivity;
import com.likeit.aqe365.activity.find.MoodVideoDetailsActivity;
import com.likeit.aqe365.activity.find.PostDetailsActivity;
import com.likeit.aqe365.activity.find.TopicListActivity;
import com.likeit.aqe365.activity.find.VideoDetailsActivity;
import com.likeit.aqe365.adapter.find.MoodListAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.find.FoolowMoodListModel;
import com.likeit.aqe365.network.model.find.MoodListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.PopupWindowUtil;
import com.likeit.aqe365.view.IconfontTextView;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayout;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutAdapter;
import com.likeit.aqe365.view.searchview.EditText_Clear;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class Attention01Fragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.et_search)
    EditText_Clear et_search;
    @BindView(R.id.flsv)
    FlowLayout flsv;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private MoodListAdapter mAdapter;

    private int pageNum = 1;
    private static final int PAGE_SIZE = 6;//为什么是6呢？
    private boolean isErr = true;
    private boolean mLoadMoreEndGone = false; //是否加载更多完毕
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;
    private MoodListModel moodListModel;
    private List<MoodListModel.ListBean> data = new ArrayList<>();
    private String keyword;
    private String type;
    private FlowLayoutAdapter<FoolowMoodListModel.ListBean> flowLayoutAdapter;
    private List<FoolowMoodListModel.ListBean> list;


    @Override
    protected int setContentView() {
        return R.layout.fragment_attention;
    }

    @Override
    protected void lazyLoad() {
        initTab();
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        type = "推荐";
        initAdapter();
        initUI();
    }

    private void initTab() {
        RetrofitUtil.getInstance().follow(openid, new Subscriber<BaseResponse<FoolowMoodListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<FoolowMoodListModel> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    list = baseResponse.getData().getList();
                    initTabUi();
                }
            }
        });
    }

    private void initTabUi() {
        flowLayoutAdapter = new FlowLayoutAdapter<FoolowMoodListModel.ListBean>(list) {
            @Override
            public void bindDataToView(ViewHolder holder, int position, FoolowMoodListModel.ListBean bean) {
                holder.setText(R.id.tv, bean.getTitle());
                holder.getView(R.id.iv).setVisibility(View.GONE);
            }

            @Override
            public void onItemClick(int position, FoolowMoodListModel.ListBean bean) {
                Bundle bundle = new Bundle();
                bundle.putString("bid", bean.getId());
                bundle.putString("title", bean.getTitle());
                bundle.putString("isattention", "1");
                toActivity(TopicListActivity.class, bundle);
            }

            @Override
            public int getItemLayoutID(int position, FoolowMoodListModel.ListBean bean) {
                return R.layout.item_layout;
            }
        };
        flsv.setAdapter(flowLayoutAdapter);
    }

    private void initUI() {
        /**
         * 监听输入键盘更换后的搜索按键
         * 调用时刻：点击键盘上的搜索键时
         */
        et_search.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {

                    String inputSearch = et_search.getText().toString().trim();
                    if (TextUtils.isEmpty(inputSearch)) {
                        showToast("请输入搜索的商品");
                        return true;
                    }
                    keyword = inputSearch;
                    initData(1, false);
                }
                return false;
            }
        });
    }

    private void initAdapter() {

        mAdapter = new MoodListAdapter(R.layout.moodlist_item, data);
        mAdapter.setEnableLoadMore(false);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.disableLoadMoreIfNotFullPage();
        initData(pageNum, false);
        LoaddingShow();
        mCurrentCounter = mAdapter.getData().size();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                String id = data.get(position).getId();
                String types = data.get(position).getType();
                if ("1".equals(types)) {
                    bundle.putString("id", id);
                    toActivity(MoodVideoDetailsActivity.class, bundle);
                } else {
                    bundle.putString("id", id);
                    toActivity(MoodDetailActivity.class, bundle);
                }
            }
        });
    }


    public void initData(int pageNum, final boolean isloadmore) {
        RetrofitUtil.getInstance().moodlist(openid, type, keyword, String.valueOf(pageNum), new Subscriber<BaseResponse<MoodListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<MoodListModel> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.code == 200) {
                    moodListModel = baseResponse.getData();
                    List<MoodListModel.ListBean> list = moodListModel.getList();
                    TOTAL_COUNTER = Integer.valueOf(moodListModel.getTotal());
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
}
