package com.likeit.aqe365.fragment.main;


import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.SearchLayoutActivity;
import com.likeit.aqe365.adapter.sort.adapter.LeftAdapter;
import com.likeit.aqe365.adapter.sort.adapter.RightAdapter;
import com.likeit.aqe365.adapter.sort.adapter.RightAdapter1;
import com.likeit.aqe365.adapter.sort.adapter.RightAdapter2;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.GoodCategory.GoodsCategoryModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
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
    private String catlevel;
    private RightAdapter1 rightAdapter1;
    private RightAdapter2 rightAdapter2;
    private RelativeLayout rl_nodata;
    private LinearLayout ll_category;
    private TextView tv_nodata;

    @Override
    protected int setContentView() {
        return R.layout.fragment_category;
    }

    @Override
    protected void lazyLoad() {
        goodsCategoryBeanList = new ArrayList<>();
        listBeanList = new ArrayList<>();
        goodsBeans = new ArrayList<>();
        mLeftRvRecyclerView = findViewById(R.id.main_left_rv);
        rl_nodata = findViewById(R.id.rl_nodata);
        tv_nodata = findViewById(R.id.tv_nodata);
        ll_category = findViewById(R.id.ll_category);
        mRightRvRecyclerView = findViewById(R.id.main_right_rv);
        //initData();
        initData();
        loaddingDialog.show();

    }

    private void initUI() {
        if ("1".equals(catlevel)) {
            mLeftRvRecyclerView.setVisibility(View.GONE);
            rightAdapter1 = new RightAdapter1(R.layout.item_medical_tv, goodsCategoryBeanList);
            mRightRvRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
            mRightRvRecyclerView.setAdapter(rightAdapter1);
        } else if ("2".equals(catlevel)) {
            mLeftRvRecyclerView.setVisibility(View.VISIBLE);
            leftAdapter = new LeftAdapter(R.layout.item_main_left, goodsCategoryBeanList);
            rightAdapter2 = new RightAdapter2(R.layout.item_medical_tv, listBeanList);
            mLeftRvRecyclerView.setAdapter(leftAdapter);
            mRightRvRecyclerView.setAdapter(rightAdapter2);
            mLeftRvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRightRvRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
            mLeftRvRecyclerView.addOnItemTouchListener(new SimpleClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    GoodsCategoryModel.ListBean shopSortBean = goodsCategoryBeanList.get(i);
                    listBeanList.clear();
                    listBeanList.addAll(shopSortBean.getTwotier());
                    leftAdapter.setSelectPos(i);
                    leftAdapter.notifyDataSetChanged();
                    rightAdapter2.notifyDataSetChanged();
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


        } else if ("3".equals(catlevel)) {
            mLeftRvRecyclerView.setVisibility(View.VISIBLE);
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
        }else {
            Typeface iconTypeface = Typeface.createFromAsset(getActivity().getAssets(), "iconfont.ttf");
            ll_category.setVisibility(View.GONE);
            rl_nodata.setVisibility(View.VISIBLE);
            tv_nodata.setTypeface(iconTypeface);
            tv_nodata.setText(StringUtil.decode("\\u" + "e682"));
        }


    }

    private void initData() {
        RetrofitUtil.getInstance().GoodsCategory(openid, new Subscriber<BaseResponse<GoodsCategoryModel>>() {
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
                    catlevel = baseResponse.getData().getCatlevel(); //0:无 1:分类1级 2:分类2级 3:分类3级
                    SharedPreferencesUtils.put(getActivity(), "catlevel", catlevel);
                    goodsCategoryModel = baseResponse.getData();
                    goodsCategoryBeanList = goodsCategoryModel.getList();
                    for (int i = 0; i < goodsCategoryBeanList.size(); i++) {
                        listBeanList.addAll(goodsCategoryBeanList.get(i).getTwotier());
                    }
                    initUI();
                    if ("1".equals(catlevel)) {
                        rightAdapter1.setNewData(goodsCategoryBeanList);
                        rightAdapter1.notifyDataSetChanged();
                    } else if ("2".equals(catlevel)) {
                        rightAdapter2.setNewData(listBeanList);
                        rightAdapter2.notifyDataSetChanged();
                    } else if ("3".equals(catlevel)) {
                        leftAdapter.setNewData(goodsCategoryBeanList);
                        rightAdapter.setNewData(listBeanList);
                        leftAdapter.notifyDataSetChanged();
                        rightAdapter.notifyDataSetChanged();
                    }
                    // LogUtils.d("goodsCategoryBeanList--》" + listBeanList.get(1).getName());

                }
            }
        });
    }

    @OnClick(R.id.search_layout)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_layout:
                toActivity(SearchLayoutActivity.class);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        XLog.e("Fragment02");
    }
}
