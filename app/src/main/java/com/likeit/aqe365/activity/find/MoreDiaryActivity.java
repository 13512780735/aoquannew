package com.likeit.aqe365.activity.find;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.find.JournalModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.ToastUtils;
import com.likeit.aqe365.view.IconfontTextView;
import com.likeit.aqe365.view.NineGridTestLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

public class MoreDiaryActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    private int pageNum = 1;
    private static final int PAGE_SIZE = 1;//为什么是6呢？
    private boolean isErr = true;
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private List<JournalModel.ListBean> data;
    private JournalAdapter mAdapter;
    private JournalModel journalBean;
    private String memberid, diaryid;
    private IconfontTextView tv_isgood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_diary);
        setTitle("更多日记");
        setBackView();
        setRightText02(getResources().getString(R.string.ic_share), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare("");
            }
        });
        memberid = getIntent().getExtras().getString("memberid");
        diaryid = getIntent().getExtras().getString("diaryid");
        initUI();
    }

    private void initUI() {
        data = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
    }

    private void initAdapter() {
        mAdapter = new JournalAdapter(R.layout.diary_deatils_items, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();
//        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                String id = data.get(position).getId();
//                Bundle bundle = new Bundle();
//                bundle.putString("id", id);
//                toActivity(PostDetailsActivity.class, bundle);
//            }
//        });
//        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                switch (view.getId()) {
//                    case R.id.tv_isgood:
//                        XLog.e("dianjile");
//                        tv_isgood.setText(mContext.getResources().getString(R.string.ic_good) + "  " + (Integer.valueOf(data.get(position).getLikenum()) + 1));
//                        tv_isgood.setTextColor(Color.parseColor("#ff424d"));
//                        /**
//                         * 点赞
//                         */
//                        String diaryid = data.get(position).getId();//帖子id
//                        String cid = "";//
//                        toLike(diaryid, cid);
//
//                        break;
//                }
//            }
//
//        });
    }


    private void initData(int pageNum, final boolean isloadmore) {
        RetrofitUtil.getInstance().detailjournallist(openid, memberid, diaryid, String.valueOf(pageNum), new Subscriber<BaseResponse<JournalModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<JournalModel> baseResponse) {
                if (baseResponse.code == 200) {
                    journalBean = baseResponse.getData();
                    TOTAL_COUNTER = Integer.valueOf(journalBean.getTotal());
                    List<JournalModel.ListBean> list = journalBean.getJournal();
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

    public class JournalAdapter extends BaseQuickAdapter<JournalModel.ListBean, BaseViewHolder> {
        private NineGridTestLayout layout;

        public JournalAdapter(int layoutResId, List<JournalModel.ListBean> data) {
            super(R.layout.diary_deatils_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final JournalModel.ListBean item) {
            tv_isgood = helper.getView(R.id.iv_isgood);
            helper.setText(R.id.tv_time, item.getDay());
            helper.setText(R.id.tv_num, item.getNum());
            if ("1".equals(item.getIslike())) {
                tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                tv_isgood.setClickable(false);

            } else {
                tv_isgood.setText(getResources().getString(R.string.ic_isgood) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#cccccc"));
                tv_isgood.setClickable(true);
            }
            helper.setText(R.id.tv_content, item.getContent());
            layout = helper.getView(R.id.layout_nine_grid);
            layout.setIsShowAll(item.isShowAll);
            layout.setUrlList(item.images);
            helper.setOnClickListener(R.id.iv_isgood, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    XLog.e("id" + item.getId());

                    /**
                     * 点赞
                     */
                    String diaryid = item.getId();//帖子id
                    String cid = "";//
                    int num = item.getLikenum();
                    toLike(diaryid, cid, num);
                }
            });


        }

        public void toLike(String diaryid, String cid, final int num) {
            // String openid = SharedPreferencesUtils.getString(mContext, "openid");
            RetrofitUtil.getInstance().journallike(openid, diaryid, cid, new Subscriber<BaseResponse<EmptyEntity>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                    if (baseResponse.getCode() == 200) {
//                        tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + (num + 1));
//                        tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                        showToast(baseResponse.getMsg());
                        onRefresh();
                    } else showToast(baseResponse.getMsg());
                }
            });
        }
    }


}
