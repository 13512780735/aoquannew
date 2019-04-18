package com.likeit.aqe365.activity.indent;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.indent.GoodAllIndentAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.Indent.IndentListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.view.CustomPopWindow;
import com.likeit.aqe365.wxapi.PayActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllIndentFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.popu)
    View view;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private GoodAllIndentAdapter mAdapter;
    private CustomPopWindow mCustomPopWindow;


    private int pageNum = 1;
    private static final int PAGE_SIZE = 1;//为什么是6呢？
    private boolean isErr = true;
    private boolean mLoadMoreEndGone = false; //是否加载更多完毕
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;
    private Bundle bundle;
    private IndentListModel indentListModel;
    private String id;
    private String closereason;

    public void initUI() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        initAdapter();
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
//                    case R.id.rl_indent_details://订单详情
//
//                        break;
                    case R.id.tv_cancel_indent://取消订单
                        id = data.get(position).getId();
                        // cancelIndent(id);
                        showPopMenu(id);

                        break;
                    case R.id.tv_del_indent://删除订单
                        id = data.get(position).getId();
                        deleteIndent(id);
                        break;
                    case R.id.tv_pay://支付订单
                        String IndentId = data.get(position).getOrdersn();
                        id = data.get(position).getId();
                        String money = data.get(position).getPrice();
                        bundle = new Bundle();
                        bundle.putString("tid", IndentId);
                        bundle.putString("id", id);
                        bundle.putString("money", money);
                        toActivity(PayActivity.class, bundle);
                        break;
                    case R.id.tv_check_wuLiu://查看无聊
                        id = data.get(position).getId();
                        bundle = new Bundle();
                        bundle.putString("id", id);
                        bundle.putString("express", "");
                        bundle.putString("expresssn", "");
                        bundle.putString("expresscom", "");

                        toActivity(LogisticsActivity.class,bundle);
                        break;
                    case R.id.tv_confirm_goods://确认收货
                        id = data.get(position).getId();
                        confirmOrder(id);
                        break;
                }
            }
        });
    }

    private void confirmOrder(String id) {
        RetrofitUtil.getInstance().orderFinish(openid, id, new Subscriber<BaseResponse<EmptyEntity>>() {
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

    private void showPopMenu(String id) {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.pop_menu2, null);
        //处理popWindow 显示内容
        handleLogic(contentView, id);
        //创建并显示popWindow
        mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(getActivity()).size(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
                .setView(contentView)
                .create()
                .showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    private void handleLogic(View contentView, final String id) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomPopWindow != null) {
                    mCustomPopWindow.dissmiss();
                }
                switch (v.getId()) {
                    case R.id.menu1:
                        closereason = "我不想买了";
                        cancelIndent(id, closereason);
                        break;
                    case R.id.menu2:
                        closereason = "信息填写错误，重新拍";
                        cancelIndent(id, closereason);
                        break;
                    case R.id.menu3:
                        closereason = "卖家缺货";
                        cancelIndent(id, closereason);
                        break;
                    case R.id.menu4:
                        closereason = "同城见面交易";
                        cancelIndent(id, closereason);
                        break;
                    case R.id.menu5:
                        closereason = "其他原因";
                        cancelIndent(id, closereason);
                        break;
                }
            }
        };
        contentView.findViewById(R.id.menu1).setOnClickListener(listener);
        contentView.findViewById(R.id.menu2).setOnClickListener(listener);
        contentView.findViewById(R.id.menu3).setOnClickListener(listener);
        contentView.findViewById(R.id.menu4).setOnClickListener(listener);
        contentView.findViewById(R.id.menu5).setOnClickListener(listener);
    }

    private void cancelIndent(String id, String closereason) {
        RetrofitUtil.getInstance().orderCancel(openid, id, closereason, new Subscriber<BaseResponse<EmptyEntity>>() {
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

    private void deleteIndent(String id) {
        RetrofitUtil.getInstance().orderDelete(openid, id, "1", new Subscriber<BaseResponse<EmptyEntity>>() {
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

        mAdapter = new GoodAllIndentAdapter(R.layout.goods_indent_items, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        // mSwipeRefreshLayout.setOnRefreshListener(this);
        initData(pageNum, false);
        LoaddingShow();
        mCurrentCounter = mAdapter.getData().size();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                id = data.get(position).getId();
                SharedPreferencesUtils.put(getActivity(),"ordId",id);
                bundle = new Bundle();
                bundle.putInt("status", 0);
                bundle.putString("id", id);
                toActivity(IndentDetailsActivity.class, bundle);
            }
        });
    }

    private List<IndentListModel.ListBean> data = new ArrayList<>();

    public void initData(int pageNum, final boolean isloadmore) {

        RetrofitUtil.getInstance().Orderform(openid, "0", String.valueOf(pageNum), new Subscriber<BaseResponse<IndentListModel>>() {
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
    protected int setContentView() {
        return R.layout.fragment_all_indent;
    }

    @Override
    protected void lazyLoad() {
        initUI();
        // addListeners();
    }


    @Override
    public void onLoadMoreRequested() {
//        mSwipeRefreshLayout.setEnabled(false);
//        TOTAL_COUNTER = Integer.valueOf(indentListModel.getTotal());
//        if (mAdapter.getData().size() < PAGE_SIZE) {
//            mAdapter.loadMoreEnd(true);
//        } else {
//            if (mCurrentCounter >= TOTAL_COUNTER) {
//                mAdapter.loadMoreEnd(mLoadMoreEndGone);
//            } else {
//                if (isErr) {
//                    pageNum += 1;
//                    initData(pageNum, true);
//                    //    mAdapter.addData(data);
//                    mCurrentCounter = mAdapter.getData().size();
//                    mAdapter.loadMoreComplete();
//                } else {
//                    isErr = true;
//                    // Toast.makeText(getContext(), "错误", Toast.LENGTH_LONG).show();
//                    mAdapter.loadMoreFail();
//                }
//            }
//            mSwipeRefreshLayout.setEnabled(true);
//        }
        TOTAL_COUNTER = Integer.valueOf(indentListModel.getTotal());
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
                isErr = true;
                mCurrentCounter = PAGE_SIZE;
                pageNum = 1;//页数置为1 才能继续重新加载
                initData(pageNum, false);
                LoaddingShow();
                mSwipeRefreshLayout.setRefreshing(false);
                mAdapter.setEnableLoadMore(true);//启用加载
            }
        }, 2000);
    }
}
