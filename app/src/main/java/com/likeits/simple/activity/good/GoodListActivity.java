package com.likeits.simple.activity.good;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.activity.detail.GoodDetailActivity;
import com.likeits.simple.adapter.sort.adapter.GoodListAdapter;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.GoodCategory.CategoryListItemsModel;
import com.likeits.simple.network.util.RetrofitUtil;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class GoodListActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.search_content_et)
    TextView mSearchContentEt;
    @BindView(R.id.search_layout)
    LinearLayout mSearchLayout;
    @BindView(R.id.ll_filter)
    LinearLayout mFilter;
    @BindView(R.id.message_img)
    TextView mMessageImg;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.tv_synthesis_sort)
    TextView mTvSynthesisSort;
    @BindView(R.id.layout_synthesis_sort)
    RelativeLayout mLayoutSynthesisSort;
    @BindView(R.id.tv_sales_sort)
    TextView mTvSalesSort;
    @BindView(R.id.layout_sales_sort)
    RelativeLayout mLayoutSalesSort;
    @BindView(R.id.tv_sort_price)
    TextView mTvSortPrice;
    @BindView(R.id.iv_price)
    ImageView iv_price;
    @BindView(R.id.layout_expert_service)
    RelativeLayout mLayoutExpertService;
    @BindView(R.id.tv_filter_sort)
    TextView mTvFilterSort;
    @BindView(R.id.layout_filter_sort)
    RelativeLayout mLayoutFilterSort;

    private TextView tvCancel, tvConfirm;


    private boolean synthesisFalg = false;
    private boolean salesFalg = false;
    private boolean priceFalg = false;
    private int priceFalg01 = 0; //判断升序降序
    private boolean filterFalg = false;


    //private ArrayList<CaseEntity> data;
    private int pageNum = 1;
    private static final int PAGE_SIZE = 6;//为什么是6呢？
    private int mNextRequestPage = 1;
    private boolean isErr = true;
    private boolean mLoadMoreEndGone = false; //是否加载更多完毕
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;
    private GoodListAdapter mAdapter;
    private String cid;
    private CategoryListItemsModel categoryListItemsModel;
    private String keyword;
    private Typeface iconTypeface;

    int flag01 = 0;//商品列表拍列样式  0 网格，1列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_list);
        cid = getIntent().getStringExtra("cid");
        keyword = getIntent().getExtras().getString("keyword");
        iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        mMessageImg.setTypeface(iconTypeface);
        SharedPreferencesUtils.put(this, "flag01", flag01);
        // LogUtils.d("GoodListActivity--cid-->" + cid);
        XLog.e("cid-->" + cid + keyword);
        initUI();
    }


    private void initUI() {
        mMessageImg.setText(StringUtil.decode("\\u" + "e67c"));
        mMessageImg.setTextColor(Color.parseColor("#656565"));
        iv_price.setBackgroundResource(R.mipmap.icon_sort_up_down);
        mTvSynthesisSort.setTextColor(Color.parseColor(theme_bg_tex));
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        //set layoutManager
        initAdapter();
        //onRefresh();
        //  mAdapter.setEnableLoadMore(true);
    }

    @OnClick({R.id.iv_back, R.id.message_img, R.id.tv_synthesis_sort, R.id.layout_synthesis_sort, R.id.tv_sales_sort, R.id.layout_sales_sort, R.id.tv_sort_price, R.id.layout_expert_service})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_back:
                onBackPressed();
                break;

            case R.id.tv_synthesis_sort:
            case R.id.layout_synthesis_sort:
                mTvSalesSort.setTextColor(Color.parseColor("#333333"));
                mTvSortPrice.setTextColor(Color.parseColor("#333333"));
                mTvFilterSort.setTextColor(Color.parseColor("#333333"));
                iv_price.setBackgroundResource(R.mipmap.icon_sort_up_down);
                salesFalg = false;
                priceFalg = false;
                filterFalg = false;
                if (!synthesisFalg) {
                    mTvSynthesisSort.setTextColor(Color.parseColor(theme_bg_tex));
                } else {
                    mTvSynthesisSort.setTextColor(Color.parseColor("#333333"));
                }
                break;
            case R.id.tv_sales_sort:
            case R.id.layout_sales_sort:
                mTvSynthesisSort.setTextColor(Color.parseColor("#333333"));
                mTvSortPrice.setTextColor(Color.parseColor("#333333"));
                mTvFilterSort.setTextColor(Color.parseColor("#333333"));
                iv_price.setBackgroundResource(R.mipmap.icon_sort_up_down);
                synthesisFalg = false;
                priceFalg = false;
                filterFalg = false;
                if (!salesFalg) {
                    mTvSalesSort.setTextColor(Color.parseColor(theme_bg_tex));
                } else {
                    mTvSalesSort.setTextColor(Color.parseColor("#333333"));
                }
                break;
            case R.id.tv_sort_price:
            case R.id.layout_expert_service:
                mTvSynthesisSort.setTextColor(Color.parseColor("#333333"));
                mTvSalesSort.setTextColor(Color.parseColor("#333333"));
                mTvFilterSort.setTextColor(Color.parseColor("#333333"));
                synthesisFalg = false;
                salesFalg = false;
                filterFalg = false;
                if (!priceFalg) {
                    switch (priceFalg01) {
                        case 0:
                            mTvSortPrice.setTextColor(Color.parseColor(theme_bg_tex));
                            iv_price.setBackgroundResource(R.mipmap.icon_sort_up);
                            priceFalg01 = 1;
                            break;
                        case 1:
                            iv_price.setBackgroundResource(R.mipmap.icon_sort_down);
                            priceFalg01 = 0;
                            break;
                    }
                }
                break;
            case R.id.message_img:

                switch (flag01) {
                    case 0:
                        mMessageImg.setText(StringUtil.decode("\\u" + "e67c"));
                        flag01 = 1;
                        SharedPreferencesUtils.put(this, "flag01", flag01);
                        initAdapter();
                        break;
                    case 1:
                        mMessageImg.setText(StringUtil.decode("\\u" + "e682"));
                        flag01 = 0;
                        SharedPreferencesUtils.put(this, "flag01", flag01);
                        initAdapter();
                        break;
                }
                break;

        }
    }

    private void initAdapter() {
        if (flag01 == 0) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else if (flag01 == 1) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        mAdapter = new GoodListAdapter(R.layout.good_listview_items, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        // mSwipeRefreshLayout.setOnRefreshListener(this);
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();


        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener()

        {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //LogUtils.d(data.get(position).getId());
                Bundle bundle = new Bundle();
                bundle.putString("id", data.get(position).getId());
                toActivity(GoodDetailActivity.class, bundle);
            }
        });
    }

    private List<CategoryListItemsModel.ListBean> data = new ArrayList<>();

    public void initData(int pageNum, final boolean isloadmore) {
        LoaddingShow();
        RetrofitUtil.getInstance().CategoryList(openid, keyword, cid, "", "", "", "", "", "", String.valueOf(pageNum), new Subscriber<BaseResponse<CategoryListItemsModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<CategoryListItemsModel> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.code == 200) {
                    categoryListItemsModel = baseResponse.getData();
                    List<CategoryListItemsModel.ListBean> list = categoryListItemsModel.getList();
                    XLog.json(baseResponse.data.getList().toString());
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
                        pageNum+=1;
                        initData(pageNum,true);
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
        mNextRequestPage = 1;
        mAdapter.setEnableLoadMore(false);//禁止加载
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mAdapter.setNewData(data);
                data.clear();
                isErr = true;
                mCurrentCounter = PAGE_SIZE;
                pageNum = 1;//页数置为1 才能继续重新加载
                initData(pageNum, false);
                mAdapter.setEnableLoadMore(true);//启用加载
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }
}