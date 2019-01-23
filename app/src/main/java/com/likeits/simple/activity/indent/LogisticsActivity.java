package com.likeits.simple.activity.indent;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.likeits.simple.R;
import com.likeits.simple.adapter.indent.LogisticsAdapter;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.Indent.ExpressModel;
import com.likeits.simple.network.model.Indent.Trace;
import com.likeits.simple.network.util.RetrofitUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

public class LogisticsActivity extends BaseActivity {
    private RecyclerView traceRv; //物流追踪列表
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
    @BindView(R.id.tv_shop_num)
    TextView tv_shop_num;
    private String id;
    private ExpressModel expressModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics);
        id = getIntent().getExtras().getString("id");
        setBackView();
        setTitle("物流信息");
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
        RetrofitUtil.getInstance().expressInfo(openid, id, "", "", "", new Subscriber<BaseResponse<ExpressModel>>() {
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
                    mTraceList = expressModel.getExpresslist();
                    initRecyclerView();
                    initUI();

                }
            }
        });
    }

    //初始化显示物流追踪的RecyclerView
    private void initRecyclerView() {
        traceRv = findViewById(R.id.traceRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        mAdapter = new LogisticsAdapter(this, mTraceList);
        traceRv.setLayoutManager(layoutManager);
        traceRv.setAdapter(mAdapter);
    }
}
