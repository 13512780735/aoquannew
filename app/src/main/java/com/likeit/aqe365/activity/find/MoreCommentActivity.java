package com.likeit.aqe365.activity.find;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.fragment.find.DiaryCommentFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.find.MoreDiaryModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.IconfontTextView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

public class MoreCommentActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, DiaryCommentFragment.MyDialogFragment_Listener {
    private int pageNum = 1;
    private static final int PAGE_SIZE = 1;//为什么是6呢？
    private boolean isErr = true;
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.tv_comment_num)
    TextView tv_comment_num;

    private String type, diaryid, id;
    private List<MoreDiaryModel.ListBean> data;
    private PostDeatilAdapter mAdapter;
    private MoreDiaryModel moreDiaryModel;
    DiaryCommentFragment dialog;
    private String commentid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_comment);
        setTitle("评论列表");
        setBackView();
        type = getIntent().getExtras().getString("type");//diary:日记本详情更多评论 journal:日记详情更多评论
        diaryid = getIntent().getExtras().getString("diaryid");
        id = getIntent().getExtras().getString("id");
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
        mAdapter = new PostDeatilAdapter(R.layout.followlist_item, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String id = data.get(position).getId();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                toActivity(PostDetailsActivity.class, bundle);
            }
        });
    }

    private void initData(int pageNum, final boolean isloadmore) {
        RetrofitUtil.getInstance().diaryComment(openid, type, diaryid, id, String.valueOf(pageNum), new Subscriber<BaseResponse<MoreDiaryModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<MoreDiaryModel> baseResponse) {
                if (baseResponse.code == 200) {
                    moreDiaryModel = baseResponse.getData();
                    TOTAL_COUNTER = Integer.valueOf(moreDiaryModel.getTotal());
                    tv_comment_num.setText(TOTAL_COUNTER + "条");
                    List<MoreDiaryModel.ListBean> list = moreDiaryModel.getList();
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


    @Override
    public void getDataFrom_DialogFragment(String Data01) {
        XLog.e("use:" + Data01);
        onRefresh();
    }

    public class PostDeatilAdapter extends BaseQuickAdapter<MoreDiaryModel.ListBean, BaseViewHolder> {

        public PostDeatilAdapter(int layoutResId, List<MoreDiaryModel.ListBean> data) {
            super(R.layout.postdetails_comment_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final MoreDiaryModel.ListBean item) {
            ImageLoader.getInstance().displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_avatar));
            final IconfontTextView tv_isgood = helper.getView(R.id.tv_isgood);
            helper.setText(R.id.tv_title, item.getNickname());
            helper.setText(R.id.tv_content, item.getReplycontent());
            helper.setText(R.id.tv_time, item.getReplytime());
            if ("1".equals(item.getIsgood())) {
                tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                tv_isgood.setClickable(false);
            } else {
                tv_isgood.setText(getResources().getString(R.string.ic_isgood) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#cccccc"));
                tv_isgood.setClickable(true);
            }
            IconfontTextView tv_views = helper.getView(R.id.tv_views);
            tv_views.setText("回复");

            RecyclerView mRecycleView = helper.getView(R.id.mRecyclerView);
            PostDetailCommentAdapter mAdapter = new PostDetailCommentAdapter(R.layout.postdetails_comment02_items, item.getParent());
            mRecycleView.setLayoutManager(new LinearLayoutManager(mContext));
            mRecycleView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            tv_isgood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + (Integer.valueOf(item.getLikenum()) + 1));
                    tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                    /**
                     * 点赞
                     */
                    commentid = item.getId();//帖子id
                    toLike(diaryid, commentid);
                }
            });
            tv_views.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String rdid = item.getId();
                    String mdid = "";
                    dialog = new DiaryCommentFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("diaryid", diaryid);
                    bundle.putString("rdid", rdid);
                    bundle.putString("mdid", mdid);
                    dialog.setArguments(bundle);
                    dialog.show(getSupportFragmentManager(), "");
                }
            });
        }
    }


    public class PostDetailCommentAdapter extends BaseQuickAdapter<MoreDiaryModel.ListBean.ParentBean, BaseViewHolder> {
        public PostDetailCommentAdapter(int layoutResId, List<MoreDiaryModel.ListBean.ParentBean> data) {
            super(R.layout.postdetails_comment02_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final MoreDiaryModel.ListBean.ParentBean item) {
            ImageLoader.getInstance().displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_avatar));
            final IconfontTextView tv_isgood = helper.getView(R.id.tv_isgood);
            helper.setText(R.id.tv_title, item.getNickname());
            helper.setText(R.id.tv_content, item.getReplycontent());
            helper.setText(R.id.tv_time, item.getReplytime());

            if ("1".equals(item.getIsgood())) {
                tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                tv_isgood.setClickable(false);
            } else {
                tv_isgood.setText(getResources().getString(R.string.ic_isgood) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#cccccc"));
                tv_isgood.setClickable(true);
            }
            IconfontTextView tv_views = helper.getView(R.id.tv_views);
            tv_views.setText("回复");
            tv_isgood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + (Integer.valueOf(item.getLikenum()) + 1));
                    tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                    /**
                     * 点赞
                     */
                    commentid = item.getId();//帖子id
                    toLike(diaryid, commentid);
                }
            });
            tv_views.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String rdid = item.getRcid();
                    String mdid = item.getId();
                    dialog = new DiaryCommentFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("diaryid", diaryid);
                    bundle.putString("rdid", rdid);
                    bundle.putString("mdid", mdid);
                    dialog.setArguments(bundle);
                    dialog.show(getSupportFragmentManager(), "tag");
                }
            });
        }
    }

    /**
     * 点赞
     *
     * @param diaryid
     * @param commentid
     */
    private void toLike(String diaryid, String commentid) {
        RetrofitUtil.getInstance().diarylike(openid, diaryid, commentid, new Subscriber<BaseResponse<EmptyEntity>>() {
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
                }
            }
        });
    }
}
