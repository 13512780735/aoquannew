package com.likeit.aqe365.activity.indent;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.indent.LogisticsAdapter;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.Indent.ExpressModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

public class LogisticsActivity extends BaseActivity {
    private List<ExpressModel.ExpresslistBean> mTraceList; //物流追踪列表的数据源
    private LogisticsAdapter mAdapter;
    @BindView(R.id.main_pic_iv)
    ImageView ivShop;
    @BindView(R.id.express_status_tv)
    TextView expressStatus;
    @BindView(R.id.express_company_tv)
    TextView expressCompany;
    @BindView(R.id.express_number_tv)
    TextView expressNumber;
    @BindView(R.id.traceRv)
    RecyclerView traceRv;
    @BindView(R.id.tv_shop_num)
    TextView tv_shop_num;
    @BindView(R.id.noData)
    RelativeLayout noData;
    private String id;
    private ExpressModel expressModel;
    private Typeface iconTypeface;
    private String express;
    private String expresssn;
    private String expresscom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics);
        id = getIntent().getExtras().getString("id");
        express = getIntent().getExtras().getString("express");
        expresssn = getIntent().getExtras().getString("expresssn");
        expresscom = getIntent().getExtras().getString("expresscom");
        setBackView();
        setTitle("物流信息");
        iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        initData();


    }

    private void initUI() {
        expressStatus.setTextColor(Color.parseColor(theme_bg_tex));
        ImageLoader.getInstance().displayImage(expressModel.getThumb(), ivShop);
        expressStatus.setText(expressModel.getStatus());
        expressCompany.setText("快递公司:" + expressModel.getCom());
        expressNumber.setText("快递单号:" + expressModel.getSn());
        tv_shop_num.setText(expressModel.getCount() + "件商品");
    }

    //加载物流信息的数据，这里是模拟一些假数据
    private void initData() {
        LoaddingShow();
        RetrofitUtil.getInstance().expressInfo(openid, id, "", "", "",express,expresssn,expresscom, new Subscriber<BaseResponse<ExpressModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<ExpressModel> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.getCode() == 200) {
                    expressModel = baseResponse.getData();
                    initUI();
                    mTraceList = expressModel.getExpresslist();
                    if (mTraceList == null) {
                        traceRv.setVisibility(View.GONE);
                        noData.setVisibility(View.VISIBLE);
                        // return;
                    } else {
                        initRecyclerView();
                    }

                }
            }
        });
    }

    //初始化显示物流追踪的RecyclerView
    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        mAdapter = new LogisticsAdapter(this, mTraceList);
        traceRv.setLayoutManager(layoutManager);
        traceRv.setAdapter(mAdapter);
    }
}
