package com.likeits.simple.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.adapter.sort.adapter.LeftAdapter;
import com.likeits.simple.adapter.sort.adapter.RightAdapter;
import com.likeits.simple.base.BaseFragment;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.GoodCategory.GoodsCategoryModel;
import com.likeits.simple.network.util.RetrofitUtil;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends BaseFragment {

    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;
    private RecyclerView mLeftRvRecyclerView;
    private RecyclerView mRightRvRecyclerView;
    private GoodsCategoryModel goodsCategoryModel;
    private List<GoodsCategoryModel.ListBean.TwotierBean> listBeanList;
    List<GoodsCategoryModel.ListBean> goodsCategoryBeanList;
    private ArrayList<GoodsCategoryModel.ListBean.TwotierBean.GoodsBean> goodsBeans;

    @Override
    protected int setContentView() {
        return R.layout.fragment_category;
    }

    @Override
    protected void lazyLoad() {
        goodsCategoryBeanList = new ArrayList<>();
        listBeanList = new ArrayList<>();
        goodsBeans = new ArrayList<>();
        mLeftRvRecyclerView = (RecyclerView) findViewById(R.id.main_left_rv);
        mRightRvRecyclerView = (RecyclerView) findViewById(R.id.main_right_rv);
        //initData();
        initData();
        loaddingDialog.show();
        initUI();
    }

    private void initUI() {
        leftAdapter = new LeftAdapter(R.layout.item_main_left, goodsCategoryBeanList);
        rightAdapter = new RightAdapter(R.layout.item_main_right, listBeanList);
        mLeftRvRecyclerView.setAdapter(leftAdapter);
        mRightRvRecyclerView.setAdapter(rightAdapter);

        mLeftRvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRightRvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLeftRvRecyclerView.addOnItemTouchListener(new SimpleClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GoodsCategoryModel.ListBean shopSortBean = goodsCategoryBeanList.get(i);
                listBeanList.clear();
                listBeanList.addAll(shopSortBean.getTwotier());
                leftAdapter.setSelectPos(i);
                leftAdapter.notifyDataSetChanged();
                rightAdapter.notifyDataSetChanged();
            }

            @Override
            public void onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }

            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }

            @Override
            public void onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }
        });
    }

    private void initData() {
//        String sign = SignUtils.getSign(getActivity());
//        String signs[] = sign.split("##");
//        String signature = signs[0];
//        String newtime = signs[1];
//        String random = signs[2];

        RetrofitUtil.getInstance().GoodsCategory("0", new Subscriber<BaseResponse<GoodsCategoryModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                loaddingDialog.dismiss();
            }

            @Override
            public void onNext(BaseResponse<GoodsCategoryModel> baseResponse) {
                loaddingDialog.dismiss();
                if (baseResponse.code == 200) {
                    //LogUtils.d("MainSortFragment-->" + baseResponse.getData());

                    goodsCategoryModel = baseResponse.getData();
                    goodsCategoryBeanList = goodsCategoryModel.getList();
                    for (int i = 0; i < goodsCategoryBeanList.size(); i++) {
                        listBeanList.addAll(goodsCategoryBeanList.get(i).getTwotier());
                    }
                    leftAdapter.setNewData(goodsCategoryBeanList);
                    rightAdapter.setNewData(listBeanList);
                    leftAdapter.notifyDataSetChanged();
                    rightAdapter.notifyDataSetChanged();
                    // LogUtils.d("goodsCategoryBeanList--》" + listBeanList.get(1).getName());

                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        XLog.e("Fragment02");
    }
}
