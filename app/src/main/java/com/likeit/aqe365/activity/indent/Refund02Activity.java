package com.likeit.aqe365.activity.indent;

import android.content.Intent;
import android.os.Parcelable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.indent.RefundGoodAdapter01;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.DescModel;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.Indent.GoodsRefundmodel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.custom_scrollview.HorizontalPageLayoutManager;
import com.likeit.aqe365.view.custom_scrollview.MyRecyclerView;
import com.likeit.aqe365.view.custom_scrollview.PagingScrollHelper;
import com.likeit.aqe365.view.photoview.ViewPagerActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class Refund02Activity extends BaseActivity {
    @BindView(R.id.tv_apply)
    BorderTextView tv_apply;
    @BindView(R.id.tv_cancel)
    TextView tv_cancel;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.ll_button)
    LinearLayout ll_button;
    @BindView(R.id.ll_reason)
    LinearLayout ll_reason;
    @BindView(R.id.mRecyclerView01)
    RecyclerView mRecyclerView01;
    @BindView(R.id.tv_reason)
    TextView tv_reason;
    @BindView(R.id.ll_express)//快递数据
            LinearLayout ll_express;
    @BindView(R.id.tv_status)//快递数据
            TextView tv_status;
    @BindView(R.id.tv_expressCom)//快递数据
            TextView tv_expressCom;
    @BindView(R.id.tv_expressNum)//快递数据
            TextView tv_expressNum;

    @BindView(R.id.mRecyclerView)
    MyRecyclerView mRecyclerView;
    @BindView(R.id.tv_after_sale_mode)//处理方式
            TextView tv_after_sale_mode;
    @BindView(R.id.tv_after_sale_cause01)//退款原因标题
            TextView tv_after_sale_cause01;
    @BindView(R.id.tv_after_sale_cause)//退款原因
            TextView tv_after_sale_cause;
    @BindView(R.id.tv_after_sale_price01)//金额标题
            TextView tv_after_sale_price01;
    @BindView(R.id.tv_after_sale_price)//金额
            TextView tv_after_sale_price;
    @BindView(R.id.ed_after_sale_explain01)//说明标题
            TextView ed_after_sale_explain01;
    @BindView(R.id.ed_after_sale_explain)//说明
            EditText ed_after_sale_explain;
    @BindView(R.id.ll_after_sale_price)//
            LinearLayout ll_after_sale_price;

    String type, goodsid, optionid, grefundid, ordId;
    private GoodsRefundmodel goodsRefundmodel;
    private List<Map<String, Object>> datas;

    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private List<String> data;
    private RefundGoodAdapter01 mAdapter;
    private String goods_status;
    private String payrefundtext;
    private String afterrefundtext;
    private boolean afterrefund;
    private boolean payrefund;
    private String imageUrl;
    private DescAdater mAdapter01;
    private List<DescModel> data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund02);
        goodsid = getIntent().getExtras().getString("goodsid");
        optionid = getIntent().getExtras().getString("optionid");
        grefundid = getIntent().getExtras().getString("grefundid");
        ordId = getIntent().getExtras().getString("orderid");
        type = getIntent().getExtras().getString("type");
        payrefundtext = getIntent().getExtras().getString("payrefundtext");
        afterrefundtext = getIntent().getExtras().getString("afterrefundtext");
        afterrefund = getIntent().getExtras().getBoolean("afterrefund");
        payrefund = getIntent().getExtras().getBoolean("payrefund");
        setBackView();
        setTitle("售后申请");
        datas = new ArrayList<>();//图片
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }


    private void initData() {
        LoaddingShow();
//        XLog.e("openid-->"+openid);
//        XLog.e("goodsid-->"+goodsid);
//        XLog.e("ordId-->"+ordId);
//        XLog.e("optionid-->"+optionid);
//        XLog.e("type-->"+type);
//        XLog.e("grefundid-->"+grefundid);
        RetrofitUtil.getInstance().goodsRefund(openid, goodsid, ordId, optionid, type, grefundid, new Subscriber<BaseResponse<GoodsRefundmodel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<GoodsRefundmodel> baseResponse) {
                LoaddingDismiss();
                XLog.e("code-->" + baseResponse.getCode());
                if (baseResponse.getCode() == 200) {
                    goodsRefundmodel = baseResponse.getData();
                    initUI();
                }
            }
        });
    }

    String imgId = "";

    private void initUI() {
        XLog.e("Step:" + goodsRefundmodel.getStep());
        XLog.e("Status:" + goodsRefundmodel.getGoods_refund().getStatus());

        data1 = new ArrayList<>();
        if (goodsRefundmodel.getStep() == 5 && "-1".equals(goodsRefundmodel.getGoods_refund().getStatus())) {
            ll_button.setVisibility(View.GONE);
        } else {
            ll_button.setVisibility(View.VISIBLE);
        }
//        if (goodsRefundmodel.getStep() == 5) {
//            mRecyclerView01.setVisibility(View.GONE);
//            ll_reason.setVisibility(View.VISIBLE);
//            tv_reason.setText(goodsRefundmodel.getGoods_refund().getReply());
//        }
        if (goodsRefundmodel.getGoods_refund().getDesc() != null) {
            for (int i = 0; i < goodsRefundmodel.getGoods_refund().getDesc().size(); i++) {
                DescModel descModel = new DescModel();
                descModel.setName(goodsRefundmodel.getGoods_refund().getDesc().get(i));
                data1.add(descModel);
            }
        }
        tv_title.setText(goodsRefundmodel.getGoods_refund().getStatustext());


        XLog.e("data1:" + data1);


        tv_after_sale_mode.setText(goodsRefundmodel.getHandletype());
        tv_after_sale_cause.setText(goodsRefundmodel.getGoods_refund().getReason());
        tv_after_sale_price.setText(goodsRefundmodel.getGoods_refund().getGoods_status());
        ed_after_sale_explain.setText(goodsRefundmodel.getGoods_refund().getContent());

        XLog.e("type-->" + type);
        XLog.e("goodsRefundmodel-->" + goodsRefundmodel.getHandletype());
        /**
         * 商品显示
         */
        data = goodsRefundmodel.getGoods_refund().getImages();
        mAdapter = new RefundGoodAdapter01(R.layout.refund_good_view01, data);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, data.size()));
        //   horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 5);
        LinearLayout.LayoutParams Params = (LinearLayout.LayoutParams) view.getLayoutParams();
        Params.width = 150 * (5 - data.size());
        view.setLayoutParams(Params);
//
        //滚动adapter
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setHasFixedSize(true);
        final ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            items.add(data.get(i));
        }
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, ViewPagerActivity.class);
                intent.putStringArrayListExtra("items", items);
                intent.putExtra("currentPosition", position);
                mContext.startActivity(intent);
            }
        });
        if (goodsRefundmodel.getStep() == 2) {
            tv_apply.setText("修改申请");
            tv_cancel.setText("取消申请");
            // toApply();
        } else if (goodsRefundmodel.getStep() == 3) {
            tv_apply.setText("填写快递单号");
            tv_cancel.setText("取消申请");
        } else if (goodsRefundmodel.getStep() == 4) {
            if (StringUtil.isBlank(goodsRefundmodel.getGoods_refund().getRexpresssn())) {
                tv_apply.setText("修改快递单号");
                tv_cancel.setVisibility(View.GONE);
            } else {
                tv_apply.setText("确认收到售后物品");
                tv_cancel.setText("查看售后物流");
            }
        } else if (goodsRefundmodel.getStep() == 5) {
            if ("1".equals(goodsRefundmodel.getGoods_refund().getStatus())) {
                tv_apply.setVisibility(View.INVISIBLE);
                ll_express.setVisibility(View.VISIBLE);
                tv_status.setText(goodsRefundmodel.getGoods_refund().getGoods_refund_statustext());
                tv_expressCom.setText(goodsRefundmodel.getGoods_refund().getExpresscom());
                tv_expressNum.setText(goodsRefundmodel.getGoods_refund().getExpresssn());
                tv_cancel.setText("查看售后物流");
                mRecyclerView01.setVisibility(View.GONE);
                ll_reason.setVisibility(View.GONE);
            } else if ("-1".equals(goodsRefundmodel.getGoods_refund().getStatus())) {
                tv_apply.setVisibility(View.INVISIBLE);
                ll_express.setVisibility(View.GONE);
                ll_button.setVisibility(View.GONE);
                mRecyclerView01.setVisibility(View.GONE);
                ll_reason.setVisibility(View.VISIBLE);
                tv_reason.setText(goodsRefundmodel.getGoods_refund().getReply());
            }

        }
        mRecyclerView01.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView01.setHasFixedSize(true);
        mAdapter01 = new DescAdater(R.layout.refund_good_desc, data1);
        mRecyclerView01.setAdapter(mAdapter01);
        mAdapter01.notifyDataSetChanged();

        tv_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XLog.e("dianji");
                if (goodsRefundmodel.getStep() == 2) {
                    toApply();
                } else if (goodsRefundmodel.getStep() == 3) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("goodsRefundmodel", (ArrayList<? extends Parcelable>) goodsRefundmodel.getExpress_list());
                    bundle.putString("grefundid", grefundid);
                    bundle.putString("rtype", type);
                    bundle.putString("goodsid", goodsid);
                    bundle.putString("optionid", optionid);
                    bundle.putString("ordId", ordId);
                    toActivity(EditExpressActivity.class, bundle);
                } else if (goodsRefundmodel.getStep() == 4) {
                    if (StringUtil.isBlank(goodsRefundmodel.getGoods_refund().getRexpresssn())) {
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("goodsRefundmodel", (ArrayList<? extends Parcelable>) goodsRefundmodel.getExpress_list());
                        bundle.putString("grefundid", grefundid);
                        bundle.putString("rtype", type);
                        bundle.putString("goodsid", goodsid);
                        bundle.putString("optionid", optionid);
                        bundle.putString("ordId", ordId);
                        toActivity(EditExpressActivity.class, bundle);
                    } else {
                        toConfirm();
                    }



                }
            }
        });
    }

    private void toConfirm() {
        LoaddingShow();
        RetrofitUtil.getInstance().goodsRefundReceive(openid, goodsid, ordId, optionid, type, grefundid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.getCode() == 200) {
                    tv_apply.setVisibility(View.GONE);
                    initData();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }


    @OnClick({R.id.ll_after_sale_causes, R.id.ll_after_sale_price, R.id.tv_cancel})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_after_sale_causes:
                break;
            case R.id.ll_after_sale_price:
                break;
            case R.id.tv_cancel:
                if (goodsRefundmodel.getStep() == 5 || goodsRefundmodel.getStep() == 4) {
                    Bundle bundle = new Bundle();
                    bundle.putString("id", ordId);
                    bundle.putString("express", goodsRefundmodel.getGoods_refund().getExpress());
                    bundle.putString("expresssn", goodsRefundmodel.getGoods_refund().getExpresssn());
                    bundle.putString("expresscom", goodsRefundmodel.getGoods_refund().getExpresscom());
                    toActivity(LogisticsActivity.class, bundle);
                } else if (goodsRefundmodel.getStep() == 3 || goodsRefundmodel.getStep() == 2) {
                    toCancle();
                } else {
                    finish();
                }
                break;
        }

    }

    private void toCancle() {
        RetrofitUtil.getInstance().goodsRefundCancel(openid, goodsid, ordId, grefundid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    finish();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    //提交申请
    private void toApply() {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        bundle.putString("goodsid", goodsid);
        bundle.putString("optionid", optionid);
        bundle.putString("grefundid", grefundid);
        bundle.putString("orderid", ordId);
        bundle.putString("payrefundtext", payrefundtext);
        bundle.putString("afterrefundtext", afterrefundtext);
        bundle.putBoolean("afterrefund", afterrefund);
        bundle.putBoolean("payrefund", payrefund);
        bundle.putString("flag", "2");

        toActivity(RefundActivity.class, bundle);
        finish();
    }

    public class DescAdater extends BaseQuickAdapter<DescModel, BaseViewHolder> {
        public DescAdater(int layoutResId, List<DescModel> data) {
            super(R.layout.refund_good_desc, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, DescModel item) {
            TextView tv_shop_num = helper.getView(R.id.tv_desc);
            tv_shop_num.setText(item.getName());
            // helper.setText(R.id.tv_shop_num, "¥ " + item.getRealprice());
        }
    }
}
