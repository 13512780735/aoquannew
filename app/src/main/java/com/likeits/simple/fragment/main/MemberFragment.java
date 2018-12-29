package com.likeits.simple.fragment.main;


import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.activity.login_register.LoginActivity;
import com.likeits.simple.adapter.div_provider.member.MemberAdapter;
import com.likeits.simple.base.BaseFragment;
import com.likeits.simple.network.ApiService;
import com.likeits.simple.network.model.home.HomeMessage;
import com.likeits.simple.network.model.home.MainHomeListmenuModel;
import com.likeits.simple.network.model.member.MemberItemModel;
import com.likeits.simple.utils.HttpUtil;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemberFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.SwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private JSONArray items;
    private JSONObject page;
    private List<HomeMessage> mMessages;
    private MemberAdapter adapter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_member;
    }

    @Override
    protected void lazyLoad() {
        initData();
    }

    private void initData() {
        loaddingDialog.show();
        String url = ApiService.Main_member;
        RequestParams params = new RequestParams();
        params.put("openid", openid);
        HttpUtil.post(url, params, new HttpUtil.RequestListener() {
            @Override
            public void success(String response) {

                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.optInt("code");
                    if (code == 10020) {
                        toActivityFinish(LoginActivity.class);
                    } else if (code == 200) {
                        JSONObject object1 = object.optJSONObject("data");
                        page = object1.optJSONObject("page");//page数据
                        items = object1.optJSONArray("items"); //items数据
                        initUI();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failed(Throwable e) {
                loaddingDialog.dismiss();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                loaddingDialog.dismiss();
            }
        });

    }

    private void initUI() {
        //  String name = page.optString("title");
        // setTitle(name);
        XLog.e(items);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMessages = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            String id = items.optJSONObject(i).optString("id");
            if ("member".equals(id)) {
                MemberItemModel memberItemModel = JSON.parseObject(items.optString(i).toString(), MemberItemModel.class);
                mMessages.add(memberItemModel);
            }
//
            if ("listmenu".equals(id)) {//轮播
                MainHomeListmenuModel mainHomeListmenuModel = JSON.parseObject(items.optString(i).toString(), MainHomeListmenuModel.class);
                mMessages.add(mainHomeListmenuModel);
            }
        }
        mSwipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mAdapter.setNewData(data);
                //    mCurrentCounter = PAGE_SIZE;
                // pageNum = 1;//页数置为1 才能继续重新加载
                mSwipeRefreshLayout.setRefreshing(false);
                adapter = new MemberAdapter(mMessages);
                mRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                adapter.setEnableLoadMore(true);//启用加载
            }
        }, 2000);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        initData();
    }
}
