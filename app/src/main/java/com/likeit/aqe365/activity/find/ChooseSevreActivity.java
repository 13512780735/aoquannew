package com.likeit.aqe365.activity.find;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.good.GoodListActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.find.HospitalandServeModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.view.BorderRelativeLayout;
import com.likeit.aqe365.view.RatioImageView;
import com.likeit.aqe365.view.city.CityPickerActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

public class ChooseSevreActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    private int pageNum = 1;
    private static final int PAGE_SIZE = 6;//为什么是6呢？
    private boolean isErr = true;
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private List<HospitalandServeModel.ListBean> data;
    private SevreAdapter mAdapter;
    private HospitalandServeModel hospitalandServeModel;
    private String type, flag;

    @BindView(R.id.ll_location)
    LinearLayout ll_location;
    @BindView(R.id.search_layout)
    BorderRelativeLayout search_layout;
    @BindView(R.id.search_address)
    TextView search_address;
    @BindView(R.id.search_content_et)
    EditText search_content_et;
    private static final int REQUEST_CODE_PICK_CITY = 233;
    private String city;
    private String keyword;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_serve);
        flag = getIntent().getStringExtra("flag");
        id = getIntent().getStringExtra("id");
        XLog.e("type:" + type);
        XLog.e("id:" + id);
        city = SharedPreferencesUtils.getString(mContext, "city");
        setBackView();
        initUI();
    }

    private void initUI() {
        if ("0".equals(flag)) {
            setTitle("选择医院");
            type = "hospital";
            ll_location.setVisibility(View.VISIBLE);
        } else if ("1".equals(flag)) {
            setTitle("选择科目");
            type = "category";
            ll_location.setVisibility(View.GONE);
        } else if ("2".equals(flag)) {
            setTitle("选择服务");
            type = "service";
            ll_location.setVisibility(View.GONE);
        } else if ("3".equals(flag)) {
            setTitle("关联医院服务");
            type = "tiezi";
            ll_location.setVisibility(View.GONE);
        }
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
        search_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CityPickerActivity.class);
                intent.putExtra("city", city);
                startActivityForResult(intent, REQUEST_CODE_PICK_CITY);
            }
        });
    }

    private void initAdapter() {
        mAdapter = new SevreAdapter(R.layout.hospital_sub_serve_item, data);
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.disableLoadMoreIfNotFullPage();
        initData(pageNum, false);
        mCurrentCounter = mAdapter.getData().size();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("id", data.get(position).getId());
                intent.putExtra("name", data.get(position).getName());
                if ("0".equals(flag)) {
                    setResult(110, intent);
                    finish();
                } else if ("1".equals(flag)) {
                    setResult(110, intent);
                    finish();
                } else if ("2".equals(flag)) {
                    setResult(110, intent);
                    finish();
                }else if ("3".equals(flag)) {
                    setResult(110, intent);
                    finish();
                }
            }
        });
        search_content_et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {

                    keyword = search_content_et.getText().toString().trim();
                    if (TextUtils.isEmpty(keyword)) {
                        showToast("请输入搜索的医院");
                        return true;
                    }
                    initData(1, false);
                }
                return false;
            }
        });


    }

    private void initData(int pageNum, final boolean isloadmore) {
        XLog.e("city:" + city);
        XLog.e("keyword:" + keyword);
        RetrofitUtil.getInstance().Editdiary(openid, type, keyword, city,id, String.valueOf(pageNum), new Subscriber<BaseResponse<HospitalandServeModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<HospitalandServeModel> baseResponse) {
                if (baseResponse.code == 200) {
                    hospitalandServeModel = baseResponse.getData();
                    TOTAL_COUNTER = Integer.valueOf(hospitalandServeModel.getTotal());
                    List<HospitalandServeModel.ListBean> list = hospitalandServeModel.getList();
                    if (list != null && list.size() > 0) {
                        if (!isloadmore) {
                            data = list;
                        } else {
                            data.addAll(list);
                        }
                        mAdapter.setNewData(data);
                        mAdapter.notifyDataSetChanged();
                        // mAdapter.loadMoreComplete();
                    } else {
                        mAdapter.setEmptyView(R.layout.notdata_view);
                    }

                } else {
                    mAdapter.loadMoreComplete();
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

    public class SevreAdapter extends BaseQuickAdapter<HospitalandServeModel.ListBean, BaseViewHolder> {
        public SevreAdapter(int layoutResId, List<HospitalandServeModel.ListBean> data) {
            super(R.layout.hospital_sub_serve_item, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, HospitalandServeModel.ListBean item) {
            RatioImageView iv_avatar = helper.getView(R.id.iv_avatar);
            if ("1".equals(flag)) {
                iv_avatar.setVisibility(View.GONE);
            } else {
                iv_avatar.setVisibility(View.VISIBLE);
            }
            ImageLoader.getInstance().displayImage(item.getProves(), iv_avatar);
            helper.setText(R.id.tv_title, item.getName());
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_CITY) {
            if (data != null) {
                city = data.getStringExtra("date");
                search_address.setText(city);
                initData(1, false);
            }
        }
    }
}
