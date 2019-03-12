package com.likeit.aqe365.fragment.main;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.login_register.LoginActivity;
import com.likeit.aqe365.adapter.div_provider.member.MemberAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.ApiService;
import com.likeit.aqe365.network.model.home.HomeMessage;
import com.likeit.aqe365.network.model.home.MainHomeBannerModel;
import com.likeit.aqe365.network.model.home.MainHomeBlankModel;
import com.likeit.aqe365.network.model.home.MainHomeListmenuModel;
import com.likeit.aqe365.network.model.home.MainHomeMenuModel;
import com.likeit.aqe365.network.model.home.MainHomePictureModel;
import com.likeit.aqe365.network.model.home.MainHomePicturewModel;
import com.likeit.aqe365.network.model.home.MainHomeTitleModel;
import com.likeit.aqe365.network.model.home.MainHomekitchenwindowModel;
import com.likeit.aqe365.network.model.member.MemberIconGroupItemModel;
import com.likeit.aqe365.network.model.member.MemberItemModel;
import com.likeit.aqe365.network.model.member.MemberLogoutItemModel;
import com.likeit.aqe365.utils.HttpUtil;
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
                    XLog.e("code:" + code);
                    if (code == 10020 || code == 10026 || code == 10022) {
                        Bundle bundle = new Bundle();
                        bundle.putString("linkurl", "member");
                        toActivity(LoginActivity.class, bundle);
                        getActivity().finish();
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
            } else if ("listmenu".equals(id)) {//
                MainHomeListmenuModel mainHomeListmenuModel = JSON.parseObject(items.optString(i).toString(), MainHomeListmenuModel.class);
                mMessages.add(mainHomeListmenuModel);
            } else if ("logout".equals(id)) {//
                MemberLogoutItemModel memberLogoutItemModel = JSON.parseObject(items.optString(i).toString(), MemberLogoutItemModel.class);
                mMessages.add(memberLogoutItemModel);
            } else if ("icongroup".equals(id)) {//
                MemberIconGroupItemModel memberIconGroupItemModel = JSON.parseObject(items.optString(i).toString(), MemberIconGroupItemModel.class);
                mMessages.add(memberIconGroupItemModel);
            } else if ("title".equals(id)) {//标题
                MainHomeTitleModel mainHomeTitleModel = JSON.parseObject(items.optString(i), MainHomeTitleModel.class);
                mMessages.add(mainHomeTitleModel);
            } else if ("kitchenwindow".equals(id)) {//橱窗
                MainHomekitchenwindowModel mainHomekitchenwindowModel = JSON.parseObject(items.optString(i), MainHomekitchenwindowModel.class);
                mMessages.add(mainHomekitchenwindowModel);
            }
            if ("menu".equals(id)) {//菜单
                MainHomeMenuModel mainHomeMenuModel = JSON.parseObject(items.optString(i).toString(), MainHomeMenuModel.class);
                mMessages.add(mainHomeMenuModel);
            } else if ("blank".equals(id)) {//空白区域
                MainHomeBlankModel mainHomeBlankModel = JSON.parseObject(items.optString(i).toString(), MainHomeBlankModel.class);
                mMessages.add(mainHomeBlankModel);
            } else if ("picture".equals(id)) {//图片
                MainHomePictureModel mainHomePictureModel = JSON.parseObject(items.optString(i).toString(), MainHomePictureModel.class);
                mMessages.add(mainHomePictureModel);
            } else if ("picturew".equals(id)) {//图片组
                MainHomePicturewModel mainHomePicturewModel = JSON.parseObject(items.optString(i).toString(), MainHomePicturewModel.class);
                mMessages.add(mainHomePicturewModel);
            } else if ("banner".equals(id)) {//轮播
                MainHomeBannerModel mainHomeBannerModel = JSON.parseObject(items.optString(i), MainHomeBannerModel.class);
                mMessages.add(mainHomeBannerModel);
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
        if (mMessages != null) {
            mMessages.clear();
        } else {
            return;
        }
        initData();
    }
}
