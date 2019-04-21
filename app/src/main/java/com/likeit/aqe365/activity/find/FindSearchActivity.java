package com.likeit.aqe365.activity.find;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.amap.api.maps.model.LatLng;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.find.AllFind01Adapter;
import com.likeit.aqe365.adapter.find.AllFind02Adapter;
import com.likeit.aqe365.adapter.find.AllFind03Adapter;
import com.likeit.aqe365.adapter.find.AllFind05Adapter;
import com.likeit.aqe365.adapter.find.AllFind06Adapter;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.network.model.find.FollowlistModel;
import com.likeit.aqe365.network.model.find.HospitalListModel;
import com.likeit.aqe365.network.model.find.PostListModel;
import com.likeit.aqe365.network.model.find.UserListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.IntentUtils;
import com.likeit.aqe365.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;


/**
 * A login screen that offers login via email/password.
 */
public class FindSearchActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.search_content_et)
    EditText search_content_et;
    @BindView(R.id.tv_search)
    TextView tv_search;

    private int pageNum = 1;
    private static final int PAGE_SIZE = 6;//为什么是6呢？
    private boolean isErr = true;
    private int mCurrentCounter = 0;
    int TOTAL_COUNTER = 0;

    private String keyword;
    private String findFlag;
    /**
     * 推荐
     */
    /**
     * 附近
     */
    private List<PostListModel.ListBean> data1;
    private AllFind01Adapter mAdapter1;
    private PostListModel postListModel;
    /**
     * 关注
     */
    private List<FollowlistModel.ListBean> data2;
    private AllFind02Adapter mAdapter2;
    private FollowlistModel followlistModel;
    /**
     * 话题
     */
    private AllFind03Adapter mAdapter3;
    private BoardListModel boardListModel;
    private List<BoardListModel.ListBean> data3;
    /**
     * 用户
     */
    private AllFind05Adapter mAdapter5;
    private List<UserListModel.ListBean> data5;
    private UserListModel userListModel;
    /**
     * 医院
     */
    private List<HospitalListModel.ListBean> data6;
    private AllFind06Adapter mAdapter6;
    private HospitalListModel hospitalListModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_search);
        findFlag = getIntent().getExtras().getString("findFlag");//1是推荐 ，2是关注 ，3是话题 ，4是附近 ，5是用户 ，6是医院
        XLog.e("findFlag:" + findFlag);
        setBackView();
        setTitle("搜索");
        search_content_et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    // keyword = search_content_et.getText().toString().trim();
                    if ("1".equals(findFlag)) {
                        if (data1 != null) {
                            data1.clear();
                        }
                        initData1(1, false);
                    } else if ("2".equals(findFlag)) {
                        if (data2 != null) {
                            data2.clear();
                        }
                        initData2(1, false);
                    } else if ("3".equals(findFlag)) {
                        if (data3 != null) {
                            data3.clear();
                        }
                        initData3(1, false);
                    } else if ("4".equals(findFlag)) {
                        if (data1 != null) {
                            data1.clear();
                        }
                        initData4(1, false);
                    } else if ("5".equals(findFlag)) {
                        if (data5 != null) {
                            data5.clear();
                        }
                        initData5(1, false);
                    } else if ("6".equals(findFlag)) {
                        if (data6 != null) {
                            data6.clear();
                        }
                        initData6(1, false);
                    }
                    hideinfo();

                }
                return false;
            }
        });
        if ("1".equals(findFlag)) {
            initUI1();
        } else if ("2".equals(findFlag)) {

            initUI2();
        } else if ("3".equals(findFlag)) {

            initUI3();
        } else if ("4".equals(findFlag)) {

            initUI4();
        } else if ("5".equals(findFlag)) {

            initUI5();
        } else if ("6".equals(findFlag)) {

            initUI6();
        }
    }

    private void hideinfo() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * 推荐
     */
    private void initUI1() {
        data1 = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        initAdapter1();
    }

    /**
     * 关注
     */
    private void initUI2() {
        data2 = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter2();
    }

    /**
     * 话题
     */
    private void initUI3() {
        data3 = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter3();
    }

    /**
     * 附近
     */
    private void initUI4() {
        data1 = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        initAdapter4();
    }

    /**
     * 用户
     */
    private void initUI5() {
        data5 = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter5();
    }

    /**
     * 医院
     */
    private void initUI6() {
        data6 = new ArrayList<>();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter6();
    }

    /**
     * 推荐
     */

    private void initAdapter1() {
        mAdapter1 = new AllFind01Adapter(R.layout.layout_recomment_items, data1);
        mAdapter1.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter1);
        mAdapter1.disableLoadMoreIfNotFullPage();
        initData1(pageNum, false);
        mCurrentCounter = mAdapter1.getData().size();
        mAdapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String types = data1.get(position).getTypes();
                String id = data1.get(position).getId();
                Bundle bundle = new Bundle();
                if ("1".equals(types)) {
                    bundle.putString("id", id);
                    toActivity(VideoDetailsActivity.class, bundle);
                } else {
                    bundle.putString("id", id);
                    toActivity(PostDetailsActivity.class, bundle);
                }
            }
        });
    }

    private void initData1(int pageNum, final boolean isloadmore) {
        keyword = search_content_et.getText().toString().trim();
        RetrofitUtil.getInstance().Postlist(openid, String.valueOf(pageNum), keyword, lat, lng, "isrecommend", "", "", new Subscriber<BaseResponse<PostListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<PostListModel> baseResponse) {
                XLog.e("code" + baseResponse.getCode());
                if (baseResponse.code == 200) {
                    postListModel = baseResponse.getData();
                    List<PostListModel.ListBean> list = postListModel.getList();
                    TOTAL_COUNTER = Integer.valueOf(postListModel.getTotal());
                    if (list != null && list.size() > 0) {
                        if (!isloadmore) {
                            data1 = list;
                        } else {
                            data1.addAll(list);
                        }
                        mAdapter1.setNewData(data1);
                        mAdapter1.notifyDataSetChanged();
                    } else {
                        mAdapter1.setEmptyView(R.layout.notdata_view);
                    }

                } else {
                    showProgress(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 关注
     */
    private void initAdapter2() {
        mAdapter2 = new AllFind02Adapter(R.layout.followlist_item, data2);
        mAdapter2.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter2);
        mAdapter2.disableLoadMoreIfNotFullPage();
        initData2(pageNum, false);
        mCurrentCounter = mAdapter2.getData().size();
        mAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String types = data2.get(position).getType();
                String id = data2.get(position).getId();
                Bundle bundle = new Bundle();
                if ("1".equals(types)) {
                    bundle.putString("id", id);
                    toActivity(VideoDetailsActivity.class, bundle);
                } else {
                    bundle.putString("id", id);
                    toActivity(PostDetailsActivity.class, bundle);
                }

            }
        });
        mAdapter2.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String id = data2.get(position).getId();
                collectpost(id);
            }
        });
    }

    private void initData2(int pageNum, final boolean isloadmore) {
        keyword = search_content_et.getText().toString().trim();
        RetrofitUtil.getInstance().GetFollowlist(openid, keyword, String.valueOf(pageNum), new Subscriber<BaseResponse<FollowlistModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<FollowlistModel> baseResponse) {
                if (baseResponse.code == 200) {
                    followlistModel = baseResponse.getData();
                    TOTAL_COUNTER = Integer.valueOf(followlistModel.getTotal());
                    List<FollowlistModel.ListBean> list = followlistModel.getList();
                    if (list != null && list.size() > 0) {
                        if (!isloadmore) {
                            data2 = list;
                        } else {
                            data2.addAll(list);
                        }
                        mAdapter2.setNewData(data2);
                        mAdapter2.notifyDataSetChanged();
                    } else {
                        mAdapter2.setEmptyView(R.layout.notdata_view);
                    }

                } else {
                    showProgress(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 话题
     */
    private void initAdapter3() {
        mAdapter3 = new AllFind03Adapter(R.layout.boradlist_item, data3);
        mAdapter3.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter3);
        mAdapter3.disableLoadMoreIfNotFullPage();
        initData3(pageNum, false);
        mCurrentCounter = mAdapter3.getData().size();
        mAdapter3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("bid", data3.get(position).getId());
                bundle.putString("title", data3.get(position).getTitle());
                bundle.putString("isattention", data3.get(position).getIsattention());
                toActivity(TopicListActivity.class, bundle);
            }
        });
    }

    private void initData3(int pageNum, final boolean isloadmore) {
        keyword = search_content_et.getText().toString().trim();
        RetrofitUtil.getInstance().GetBoardlist(openid, keyword, "", String.valueOf(pageNum), new Subscriber<BaseResponse<BoardListModel>>() {
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
                            data3 = list;
                        } else {
                            data3.addAll(list);
                        }
                        mAdapter3.setNewData(data3);
                        mAdapter3.notifyDataSetChanged();
                    } else {
                        mAdapter3.setEmptyView(R.layout.notdata_view);
                    }

                } else {
                    showProgress(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 附近
     */
    /**
     * 话题
     */
    private void initAdapter4() {
        mAdapter1 = new AllFind01Adapter(R.layout.boradlist_item, data1);
        mAdapter1.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter1);
        mAdapter1.disableLoadMoreIfNotFullPage();
        initData4(pageNum, false);
        mCurrentCounter = mAdapter1.getData().size();
        mAdapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String types = data1.get(position).getTypes();
                String id = data1.get(position).getId();
                Bundle bundle = new Bundle();
                if ("1".equals(types)) {
                    bundle.putString("id", id);
                    toActivity(VideoDetailsActivity.class, bundle);
                } else {
                    bundle.putString("id", id);
                    toActivity(PostDetailsActivity.class, bundle);
                }
            }
        });
    }

    private void initData4(int pageNum, final boolean isloadmore) {
        keyword = search_content_et.getText().toString().trim();
        RetrofitUtil.getInstance().Postlist(openid, String.valueOf(pageNum), keyword, lat, lng, "isdistance", "", "", new Subscriber<BaseResponse<PostListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<PostListModel> baseResponse) {
                XLog.e("code" + baseResponse.getCode());
                if (baseResponse.code == 200) {
                    postListModel = baseResponse.getData();
                    List<PostListModel.ListBean> list = postListModel.getList();
                    TOTAL_COUNTER = Integer.valueOf(postListModel.getTotal());
                    if (list != null && list.size() > 0) {
                        if (!isloadmore) {
                            data1 = list;
                        } else {
                            data1.addAll(list);
                        }
                        mAdapter1.setNewData(data1);
                        mAdapter1.notifyDataSetChanged();
                    } else {
                        mAdapter1.setEmptyView(R.layout.notdata_view);
                    }

                } else {
                    showProgress(baseResponse.getMsg());
                }
            }
        });
    }


    /**
     * 用户
     */
    private void initAdapter5() {
        mAdapter5 = new AllFind05Adapter(R.layout.find_user_listitem, data5);
        mAdapter5.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter5);
        mAdapter5.disableLoadMoreIfNotFullPage();
        initData5(pageNum, false);
        mCurrentCounter = mAdapter5.getData().size();
        mAdapter5.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("id", data5.get(position).getId());
                toActivity(UserInfoActivity.class, bundle);
            }
        });
    }

    private void initData5(int pageNum, final boolean isloadmore) {
        keyword = search_content_et.getText().toString().trim();
        XLog.e("keyword" + keyword);
        RetrofitUtil.getInstance().GetUser(openid, keyword, lat, lng, String.valueOf(pageNum), new Subscriber<BaseResponse<UserListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<UserListModel> baseResponse) {
                XLog.e("total:" + baseResponse.getData().getTotal());
                if (baseResponse.code == 200) {
                    userListModel = baseResponse.getData();
                    List<UserListModel.ListBean> list = userListModel.getList();
                    TOTAL_COUNTER = Integer.valueOf(userListModel.getTotal());
                    if (list != null && list.size() > 0) {
                        if (!isloadmore) {
                            data5 = list;
                        } else {
                            data5.addAll(list);
                        }
                        mAdapter5.setNewData(data5);
                        mAdapter5.notifyDataSetChanged();
                    } else {
                        mAdapter5.setEmptyView(R.layout.notdata_view);
                    }

                } else {
                    showProgress(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 医院
     */
    private void initAdapter6() {
        mAdapter6 = new AllFind06Adapter(R.layout.find_hospital_listitem, data6);
        mAdapter6.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter6);
        mAdapter6.disableLoadMoreIfNotFullPage();
        initData6(pageNum, false);
        mCurrentCounter = mAdapter6.getData().size();
        mAdapter6.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String id = data6.get(position).getId();
                String linkUrl = data6.get(position).getLinkurl();
                String weburl = data6.get(position).getWeburl();
                IntentUtils.intentTo(mContext, linkUrl, id, weburl);
            }
        });
        mAdapter6.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                double mLat = data6.get(position).getLat();
                double mLng = data6.get(position).getLon();
                String mAddressStr = data6.get(position).getAddress();
                goToGaodeMap(mLat, mLng, mAddressStr);
            }
        });
    }

    private void initData6(int pageNum, final boolean isloadmore) {
        keyword = search_content_et.getText().toString().trim();
        RetrofitUtil.getInstance().hospitalList(openid, keyword, String.valueOf(pageNum), new Subscriber<BaseResponse<HospitalListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<HospitalListModel> baseResponse) {
                XLog.e("total:" + baseResponse.getData().getTotal());
                if (baseResponse.code == 200) {
                    hospitalListModel = baseResponse.getData();
                    List<HospitalListModel.ListBean> list = hospitalListModel.getList();
                    TOTAL_COUNTER = Integer.valueOf(hospitalListModel.getTotal());
                    if (list != null && list.size() > 0) {
                        if (!isloadmore) {
                            data6 = list;
                        } else {
                            data6.addAll(list);
                        }
                        mAdapter6.setNewData(data6);
                        mAdapter6.notifyDataSetChanged();
                    } else {
                        mAdapter6.setEmptyView(R.layout.notdata_view);
                    }

                } else {
                    showProgress(baseResponse.getMsg());
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        if ("1".equals(findFlag)) {
            mAdapter1.setEnableLoadMore(false);//禁止加载
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // mAdapter.setNewData(data);
                    isErr = false;
                    mCurrentCounter = PAGE_SIZE;
                    pageNum = 1;//页数置为1 才能继续重新加载
                    initData1(pageNum, false);
                    mSwipeRefreshLayout.setRefreshing(false);
                    mAdapter1.setEnableLoadMore(true);//启用加载
                }
            }, 2000);
        } else if ("2".equals(findFlag)) {
            mAdapter2.setEnableLoadMore(false);//禁止加载
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // mAdapter.setNewData(data);
                    isErr = false;
                    mCurrentCounter = PAGE_SIZE;
                    pageNum = 1;//页数置为1 才能继续重新加载
                    initData2(pageNum, false);
                    mSwipeRefreshLayout.setRefreshing(false);
                    mAdapter2.setEnableLoadMore(true);//启用加载
                }
            }, 2000);
        } else if ("3".equals(findFlag)) {
            mAdapter3.setEnableLoadMore(false);//禁止加载
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // mAdapter.setNewData(data);
                    isErr = false;
                    mCurrentCounter = PAGE_SIZE;
                    pageNum = 1;//页数置为1 才能继续重新加载
                    initData3(pageNum, false);
                    mSwipeRefreshLayout.setRefreshing(false);
                    mAdapter3.setEnableLoadMore(true);//启用加载
                }
            }, 2000);
        } else if ("4".equals(findFlag)) {
            mAdapter1.setEnableLoadMore(false);//禁止加载
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // mAdapter.setNewData(data);
                    isErr = false;
                    mCurrentCounter = PAGE_SIZE;
                    pageNum = 1;//页数置为1 才能继续重新加载
                    initData4(pageNum, false);
                    mSwipeRefreshLayout.setRefreshing(false);
                    mAdapter1.setEnableLoadMore(true);//启用加载
                }
            }, 2000);
        } else if ("5".equals(findFlag)) {
            mAdapter5.setEnableLoadMore(false);//禁止加载
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // mAdapter.setNewData(data);
                    isErr = false;
                    mCurrentCounter = PAGE_SIZE;
                    pageNum = 1;//页数置为1 才能继续重新加载
                    initData5(pageNum, false);
                    mSwipeRefreshLayout.setRefreshing(false);
                    mAdapter5.setEnableLoadMore(true);//启用加载
                }
            }, 2000);
        } else if ("6".equals(findFlag)) {
            mAdapter6.setEnableLoadMore(false);//禁止加载
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // mAdapter.setNewData(data);
                    isErr = false;
                    mCurrentCounter = PAGE_SIZE;
                    pageNum = 1;//页数置为1 才能继续重新加载
                    initData6(pageNum, false);
                    mSwipeRefreshLayout.setRefreshing(false);
                    mAdapter6.setEnableLoadMore(true);//启用加载
                }
            }, 2000);
        }
    }

    @Override
    public void onLoadMoreRequested() {
        if ("1".equals(findFlag)) {
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mCurrentCounter >= TOTAL_COUNTER) {
                        //数据全部加载完毕
                        mAdapter1.loadMoreEnd();
                    } else {
                        if (isErr) {
                            //成功获取更多数据
                            //  mQuickAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
                            pageNum += 1;
                            initData1(pageNum, true);
                            mCurrentCounter = mAdapter1.getData().size();
                            mAdapter1.loadMoreComplete();
                        } else {
                            //获取更多数据失败
                            isErr = true;
                            mAdapter1.loadMoreFail();

                        }
                    }
                }

            }, 3000);
        } else if ("2".equals(findFlag)) {
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mCurrentCounter >= TOTAL_COUNTER) {
                        //数据全部加载完毕
                        mAdapter2.loadMoreEnd();
                    } else {
                        if (isErr) {
                            //成功获取更多数据
                            //  mQuickAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
                            pageNum += 1;
                            initData2(pageNum, true);
                            mCurrentCounter = mAdapter2.getData().size();
                            mAdapter2.loadMoreComplete();
                        } else {
                            //获取更多数据失败
                            isErr = true;
                            mAdapter2.loadMoreFail();

                        }
                    }
                }

            }, 3000);
        } else if ("3".equals(findFlag)) {
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mCurrentCounter >= TOTAL_COUNTER) {
                        //数据全部加载完毕
                        mAdapter3.loadMoreEnd();
                    } else {
                        if (isErr) {
                            //成功获取更多数据
                            //  mQuickAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
                            pageNum += 1;
                            initData3(pageNum, true);
                            mCurrentCounter = mAdapter3.getData().size();
                            mAdapter3.loadMoreComplete();
                        } else {
                            //获取更多数据失败
                            isErr = true;
                            mAdapter3.loadMoreFail();

                        }
                    }
                }

            }, 3000);
        } else if ("4".equals(findFlag)) {
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mCurrentCounter >= TOTAL_COUNTER) {
                        //数据全部加载完毕
                        mAdapter1.loadMoreEnd();
                    } else {
                        if (isErr) {
                            //成功获取更多数据
                            //  mQuickAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
                            pageNum += 1;
                            initData4(pageNum, true);
                            mCurrentCounter = mAdapter1.getData().size();
                            mAdapter1.loadMoreComplete();
                        } else {
                            //获取更多数据失败
                            isErr = true;
                            mAdapter1.loadMoreFail();

                        }
                    }
                }

            }, 3000);
        } else if ("5".equals(findFlag)) {
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mCurrentCounter >= TOTAL_COUNTER) {
                        //数据全部加载完毕
                        mAdapter5.loadMoreEnd();
                    } else {
                        if (isErr) {
                            //成功获取更多数据
                            //  mQuickAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
                            pageNum += 1;
                            initData5(pageNum, true);
                            mCurrentCounter = mAdapter5.getData().size();
                            mAdapter5.loadMoreComplete();
                        } else {
                            //获取更多数据失败
                            isErr = true;
                            mAdapter5.loadMoreFail();

                        }
                    }
                }

            }, 3000);
        } else if ("6".equals(findFlag)) {
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mCurrentCounter >= TOTAL_COUNTER) {
                        //数据全部加载完毕
                        mAdapter6.loadMoreEnd();
                    } else {
                        if (isErr) {
                            //成功获取更多数据
                            //  mQuickAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
                            pageNum += 1;
                            initData6(pageNum, true);
                            mCurrentCounter = mAdapter6.getData().size();
                            mAdapter6.loadMoreComplete();
                        } else {
                            //获取更多数据失败
                            isErr = true;
                            mAdapter6.loadMoreFail();

                        }
                    }
                }

            }, 3000);
        }
    }


    /**
     * 关注收藏
     *
     * @param id
     */
    private void collectpost(String id) {
        RetrofitUtil.getInstance().collectpost(openid, id, new Subscriber<BaseResponse<EmptyEntity>>() {
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

    /**
     * 跳转高德地图
     */
    private void goToGaodeMap(double mLat, double mLng, String mAddressStr) {
        if (!isInstalled("com.autonavi.minimap")) {
            showProgress("请先安装高德地图客户端");
            return;
        }
        LatLng endPoint = BD2GCJ(new LatLng(mLat, mLng));//坐标转换
        StringBuffer stringBuffer = new StringBuffer("androidamap://route?sourceApplication=").append("amap");
        stringBuffer.append("&dlat=").append(endPoint.latitude)
                .append("&dlon=").append(endPoint.longitude)
                .append("&dev=").append(0)
                // .append("&type=").append("drive")
                .append("&dname=" + mAddressStr)
                .append("&t=").append(0);
        //  .append("&style=").append(2);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
        intent.setPackage("com.autonavi.minimap");
        startActivity(intent);
    }

    /**
     * 检测程序是否安装
     *
     * @param packageName
     * @return
     */
    private boolean isInstalled(String packageName) {
        PackageManager manager = mContext.getPackageManager();
        //获取所有已安装程序的包信息()
        List<PackageInfo> installedPackages = manager.getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo info : installedPackages) {
                if (info.packageName.equals(packageName))
                    return true;
            }
        }
        return false;
    }

    /**
     * BD-09 坐标转换成 GCJ-02 坐标
     */
    public static LatLng BD2GCJ(LatLng bd) {
        double x = bd.longitude - 0.0065, y = bd.latitude - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * Math.PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * Math.PI);

        double lng = z * Math.cos(theta);//lng
        double lat = z * Math.sin(theta);//lat
        return new LatLng(lat, lng);
    }

    /**
     * GCJ-02 坐标转换成 BD-09 坐标
     */
    public static LatLng GCJ2BD(LatLng bd) {
        double x = bd.longitude, y = bd.latitude;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * Math.PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * Math.PI);
        double tempLon = z * Math.cos(theta) + 0.0065;
        double tempLat = z * Math.sin(theta) + 0.006;
        return new LatLng(tempLat, tempLon);
    }

    @OnClick({R.id.tv_search})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_search:
                if ("1".equals(findFlag)) {
                    if (data1 != null) {
                        data1.clear();
                    }
                    initData1(1, false);
                } else if ("2".equals(findFlag)) {
                    if (data2 != null) {
                        data2.clear();
                    }
                    initData2(1, false);
                } else if ("3".equals(findFlag)) {
                    if (data3 != null) {
                        data3.clear();
                    }
                    initData3(1, false);
                } else if ("4".equals(findFlag)) {
                    if (data1 != null) {
                        data1.clear();
                    }
                    initData4(1, false);
                } else if ("5".equals(findFlag)) {
                    if (data5 != null) {
                        data5.clear();
                    }
                    initData5(1, false);
                } else if ("6".equals(findFlag)) {
                    if (data6 != null) {
                        data6.clear();
                    }
                    initData6(1, false);
                }
                hideinfo();
                break;
        }
    }

}

