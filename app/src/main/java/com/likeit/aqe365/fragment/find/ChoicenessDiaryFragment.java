package com.likeit.aqe365.fragment.find;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.find.DiaryDetailsActivity;
import com.likeit.aqe365.adapter.ChoicenessDiaryAdapter;
import com.likeit.aqe365.adapter.div_provider.member.CouponCenterListAdapter;
import com.likeit.aqe365.adapter.find.DiaryListAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.find.DiaryListModel;
import com.likeit.aqe365.network.model.member.CouponCenterModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoicenessDiaryFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {


    private String name;


    private String id;
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
    private List<DiaryListModel.ListBean> data;
    private ChoicenessDiaryAdapter mAdapter;
    private DiaryListModel diaryListModel;
    private String type;
    private String diaryid;


    @Override
    protected int setContentView() {
        return R.layout.fragment_choiceness_diary;
    }

    @Override
    protected void lazyLoad() {
        Bundle bundle = getArguments();
        name = bundle.getString("name");
        if ("推荐".equals(name)) {
            type = "isrecommand";
        } else if ("人气".equals(name)) {
            type = "ispopularity";
        } else if ("最热".equals(name)) {
            type = "ishot";
        } else if ("最新".equals(name)) {
            type = "isnew";
        }

        initUI();
    }

    private void initUI() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initAdapter();


    }

    private void initData(int pageNum, final boolean isloadmore) {
        //  LoaddingShow();
        XLog.e("openid:" + openid);
        RetrofitUtil.getInstance().diarylist(openid, "", type, String.valueOf(pageNum), new Subscriber<BaseResponse<DiaryListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<DiaryListModel> baseResponse) {
                if (baseResponse.code == 200) {
                    diaryListModel = baseResponse.getData();
                    SharedPreferencesUtils.put(getActivity(), "isuser", baseResponse.getData().getIsuser());
                    List<DiaryListModel.ListBean> list = diaryListModel.getList();
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

    private void initAdapter() {
        mAdapter = new ChoicenessDiaryAdapter(R.layout.diary_list_item, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String title = data.get(position).getTitle();
                diaryid = data.get(position).getDiaryid();
                String memberid = data.get(position).getMemberid();
                Bundle bundle = new Bundle();
                bundle.putString("diaryid", diaryid);
                bundle.putString("memberid", memberid);
                toActivity(DiaryDetailsActivity.class, bundle);
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String memberid=data.get(position).getMemberid();
                attention(memberid);
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
        TOTAL_COUNTER = Integer.valueOf(diaryListModel.getTotal());
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

    /**
     * 关注
     * @param memberid
     */
    private void attention(String memberid) {
        RetrofitUtil.getInstance().Followmember(openid, memberid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    showToast( baseResponse.getMsg());
                    onRefresh();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }
}
