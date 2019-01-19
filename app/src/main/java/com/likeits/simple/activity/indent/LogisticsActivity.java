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
import com.likeits.simple.network.model.Indent.Trace;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LogisticsActivity extends BaseActivity {
    private RecyclerView traceRv; //物流追踪列表
    private List<Trace> mTraceList; //物流追踪列表的数据源
    private LogisticsAdapter mAdapter;

    @BindView(R.id.main_pic_iv)
    ImageView ivShop;
    @BindView(R.id.express_status_tv)
    TextView expressStatus;
    @BindView(R.id.express_company_tv)
    TextView expressCompany;
    @BindView(R.id.express_number_tv)
    TextView expressNumber;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics);
        id=getIntent().getExtras().getString("id");
        setBackView();
        setTitle("物流信息");
        initData();
        initRecyclerView();
        initUI();
    }

    private void initUI() {
        expressStatus.setTextColor(Color.parseColor(theme_bg_tex));
    }

    //加载物流信息的数据，这里是模拟一些假数据
    private void initData() {
        mTraceList = new ArrayList<>();
        mTraceList.add(new Trace(0, "2017年6月18日 上午12:04:01", "在湖北武汉洪山区光谷公司长江社区便民服务站进行签收扫描，快件已被 已签收 签收"));
        mTraceList.add(new Trace(1, "2017年6月18日 上午11:57:25", "在湖北武汉洪山区光谷公司长江社区便民服务站进行派件扫描；派送业务员：老王；联系电话：17786550311在湖北武汉洪山区光谷公司长江社区便民服务站进行派件扫描；派送业务员：老王；联系电话：17786550311"));
        mTraceList.add(new Trace(1, "2017年6月17日 下午4:43:29", "在湖北武汉洪山区光谷公司进行快件扫描，将发往：湖北武汉洪山区光谷公司长江社区便民服务站"));
        mTraceList.add(new Trace(1, "2017年6月17日 上午9:11:21", "从湖北武汉分拨中心发出，本次转运目的地：湖北武汉洪山区光谷公司"));
        mTraceList.add(new Trace(1, "2017年6月17日 上午1:53:14", "在湖南长沙分拨中心进行装车扫描，即将发往：湖北武汉分拨中心"));
        mTraceList.add(new Trace(1, "2017年6月17日 上午1:50:18", "在分拨中心湖南长沙分拨中心进行称重扫描"));
        mTraceList.add(new Trace(1, "2017年6月16日 上午11:27:58", "在湖南隆回县公司进行到件扫描"));
    }

    //初始化显示物流追踪的RecyclerView
    private void initRecyclerView() {
        traceRv = (RecyclerView) findViewById(R.id.traceRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        mAdapter = new LogisticsAdapter(this, mTraceList);
        traceRv.setLayoutManager(layoutManager);
        traceRv.setAdapter(mAdapter);
    }
}
