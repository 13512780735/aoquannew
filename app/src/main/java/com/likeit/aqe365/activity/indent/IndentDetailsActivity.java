package com.likeit.aqe365.activity.indent;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.indent.IndentDatailsShopAdapter;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.Indent.IndentDetailModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.AppManager;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.CustomPopWindow;
import com.likeit.aqe365.wxapi.PayActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class IndentDetailsActivity extends BaseActivity {
    @BindView(R.id.popu)
    View view;
    //    @BindView(R.id.tv_after_sale)
//    BorderTextView mTvAfterSale;
    @BindView(R.id.ll_indent_status)
    LinearLayout mLlIndentStatus;
    @BindView(R.id.tv_indent_status)
    TextView mTvIndentStatus;
    @BindView(R.id.tv_indent_price)
    TextView mTvIndentPrice;
    @BindView(R.id.tv_indent_name)
    TextView mTvIndentName;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_shop_price)
    TextView mTvShopPrice;
    @BindView(R.id.tv_price_carriage)
    TextView mTvPriceCarriage;
    @BindView(R.id.tv_price_total)
    TextView mTvPriceTotal;
    @BindView(R.id.tv_indent_number)
    TextView mTvIndentNumber;
    @BindView(R.id.tv_create_time)
    TextView mTvCreateTime;
    @BindView(R.id.tv_pay_time)
    TextView mTvPayTime;
    @BindView(R.id.tv_delivery_time)
    TextView mTvDeliveryTime;
    @BindView(R.id.tv_finish_time)
    TextView mTvFinishTime;
    @BindView(R.id.tv_recipients_name)
    TextView mTvRecipientsName;
    @BindView(R.id.tv_recipients_phone)
    TextView mTvRecipientsPhone;
    @BindView(R.id.tv_recipients_address)
    TextView mTvRecipientsAddress;
    @BindView(R.id.iv)
    TextView iv;
    @BindView(R.id.iv01)
    TextView iv01;
    @BindView(R.id.tv_express_phone)
    TextView tv_express_phone;//快递单号
    @BindView(R.id.tv_express_name)
    TextView tv_express_name;//快递名称
    @BindView(R.id.ll_express)
    LinearLayout ll_express;//快递
    @BindView(R.id.tv_indent_cancel)
    BorderTextView tv_indent_cancel;//取消订单
    @BindView(R.id.tv_indent_del)
    BorderTextView tv_indent_del;//删除订单
    @BindView(R.id.tv_indent_pay)
    BorderTextView tv_indent_pay;//支付订单
    @BindView(R.id.tv_indent_confirm)
    BorderTextView tv_indent_confirm;//确认订单
    private int status;
    private List<IndentDetailModel.ShopBean.GoodsBean> data;
    private IndentDatailsShopAdapter mAdapter;
    private String flag;
    private String id;
    private IndentDetailModel indentDetailModel;
    private String closereason;
    private CustomPopWindow mCustomPopWindow;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_details);
        status = getIntent().getExtras().getInt("status");
        flag = getIntent().getExtras().getString("flag");//1从支付成功过来，0从订单页过来
        id = getIntent().getExtras().getString("id");
        setTitle("订单详情");
        findView(R.id.back_view).setVisibility(View.VISIBLE);
        findView(R.id.back_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status == 9999) {
                    finish();
                } else {
                    startIndentActivity();
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initUI() {
        // setBackView();

        Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        iv.setTypeface(iconTypeface);
        iv01.setTypeface(iconTypeface);
        iv.setText(StringUtil.decode("\\u" + "e651"));
        iv01.setText(StringUtil.decode("\\u" + "e671"));
        iv01.setTextColor(Color.parseColor(theme_bg_tex));
        mTvIndentStatus.setText(indentDetailModel.getOrder().getStatusstr());
        mTvIndentPrice.setText("订单金额：¥ " + indentDetailModel.getOrder().getGoodsprice());
        mTvRecipientsName.setText("联系人：" + indentDetailModel.getAddress().getRealname());
        mTvRecipientsPhone.setText("联系电话：" + indentDetailModel.getAddress().getMobile());
        mTvRecipientsAddress.setText(indentDetailModel.getAddress().getProvince() + indentDetailModel.getAddress().getCity() + indentDetailModel.getAddress().getArea());
        mTvShopPrice.setText("¥ " + indentDetailModel.getOrder().getGoodsprice());
        mTvPriceCarriage.setText("¥ " + indentDetailModel.getOrder().getDispatchprice());
        mTvPriceTotal.setText("¥ " + indentDetailModel.getOrder().getPrice());
        mTvPriceTotal.setTextColor(Color.parseColor(theme_bg_tex));
        mTvIndentName.setText(indentDetailModel.getShop().getName());

        mTvIndentNumber.setText("订单编号  " + indentDetailModel.getOrder().getOrdersn());
        mTvCreateTime.setText("创建时间  " + indentDetailModel.getOrder().getCreatetime());
        mTvPayTime.setText("支付时间  " + indentDetailModel.getOrder().getPaytime());
        mTvDeliveryTime.setText("发货时间  " + indentDetailModel.getOrder().getSendtime());
        mTvFinishTime.setText("完成时间  " + indentDetailModel.getOrder().getFinishtime());
        tv_express_name.setTextColor(Color.parseColor(theme_bg_tex));
        final String status01 = indentDetailModel.getOrder().getStatus();//0:代付款 1:待发货 2:待收货 3:交易完成 4:退款申请 -1:取消交易
        if ("0".equals(status01)) {
            ll_express.setVisibility(View.GONE);
            mTvPayTime.setVisibility(View.GONE);
            mTvDeliveryTime.setVisibility(View.GONE);
            mTvFinishTime.setVisibility(View.GONE);
            tv_indent_pay.setVisibility(View.VISIBLE);
            tv_indent_pay.setTextColor(Color.parseColor(theme_bg_tex));
            tv_indent_pay.setStrokeColor01(Color.parseColor(theme_bg_tex));
            tv_indent_cancel.setVisibility(View.VISIBLE);
        } else if ("1".equals(status01)) {
            ll_express.setVisibility(View.GONE);
            mTvDeliveryTime.setVisibility(View.GONE);
            mTvFinishTime.setVisibility(View.GONE);
        } else if ("2".equals(status01)) {
            ll_express.setVisibility(View.VISIBLE);
            mTvFinishTime.setVisibility(View.GONE);
            if(StringUtil.isBlank(indentDetailModel.getExpress().getStep())){
                tv_express_name.setVisibility(View.GONE);
            }else{
                tv_express_name.setText(indentDetailModel.getExpress().getStep());
            }
            tv_express_phone.setText("快递单号：" + indentDetailModel.getExpress().getExpresssn());
            tv_indent_confirm.setVisibility(View.VISIBLE);
        } else if ("3".equals(status01)) {
            ll_express.setVisibility(View.VISIBLE);
            tv_express_name.setText("快递公司：" + indentDetailModel.getExpress().getExpresscom());
            tv_express_phone.setText("快递单号：" + indentDetailModel.getExpress().getExpresssn());
        } else if ("4".equals(status01)) {
            ll_express.setVisibility(View.GONE);
        } else if ("-1".equals(status01)) {
            ll_express.setVisibility(View.GONE);
            mTvPayTime.setVisibility(View.GONE);
            mTvDeliveryTime.setVisibility(View.GONE);
            mTvFinishTime.setVisibility(View.GONE);
            tv_indent_del.setVisibility(View.VISIBLE);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (status == 999) {
                finish();
            } else {
                startIndentActivity();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void startIndentActivity() {
        Bundle bundle = new Bundle();
        //  bundle.putString("flag", "0");
        bundle.putString("flag", "1");
        bundle.putInt("status", status);
        Intent intent = new Intent(mContext, GoodsIndentActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
        AppManager.getAppManager().finishAllActivity();
    }

    private void initAdapter() {
        mAdapter = new IndentDatailsShopAdapter(R.layout.layout_indent_details_listview_items, data);
        //mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
       // initData();
    }

    public void initData() {
        // data = new ArrayList<>();

        RetrofitUtil.getInstance().orderDetail(openid, id, new Subscriber<BaseResponse<IndentDetailModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<IndentDetailModel> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    indentDetailModel = baseResponse.getData();
                    data = indentDetailModel.getShop().getGoods();
                    initUI();
                }
            }
        });
    }

    @OnClick({R.id.tv_indent_cancel, R.id.ll_indent_status, R.id.tv_indent_del, R.id.tv_indent_pay, R.id.tv_indent_confirm})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_indent_cancel:
                // cancelIndent(id);
                showPopMenu(id);
                break;
//            case R.id.tv_after_sale:
//                toActivity(AfterSaleActivity.class);
//                break;
            case R.id.ll_indent_status:
                break;
            case R.id.tv_indent_del:
                deleteIndent(id);
                break;
            case R.id.tv_indent_pay:
                String IndentId = indentDetailModel.getOrder().getOrdersn();
                String money =indentDetailModel.getOrder().getGoodsprice();
                bundle = new Bundle();
                bundle.putString("tid", IndentId);
                bundle.putString("id", id);
                bundle.putString("money", money);
                toActivity(PayActivity.class, bundle);
                break;
            case R.id.tv_indent_confirm:
                confirmOrder(id);
                break;
        }
    }


    private void showPopMenu(String id) {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.pop_menu2, null);
        //处理popWindow 显示内容
        handleLogic(contentView, id);
        //创建并显示popWindow
        mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(mContext).size(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
                .setView(contentView)
                .create()
                .showAtLocation(view, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    private void handleLogic(View contentView, final String id) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomPopWindow != null) {
                    mCustomPopWindow.dissmiss();
                }
                switch (v.getId()) {
                    case R.id.menu1:
                        closereason = "我不想买了";
                        cancelIndent(id, closereason);
                        break;
                    case R.id.menu2:
                        closereason = "信息填写错误，重新拍";
                        cancelIndent(id, closereason);
                        break;
                    case R.id.menu3:
                        closereason = "卖家缺货";
                        cancelIndent(id, closereason);
                        break;
                    case R.id.menu4:
                        closereason = "同城见面交易";
                        cancelIndent(id, closereason);
                        break;
                    case R.id.menu5:
                        closereason = "其他原因";
                        cancelIndent(id, closereason);
                        break;
                }
            }
        };
        contentView.findViewById(R.id.menu1).setOnClickListener(listener);
        contentView.findViewById(R.id.menu2).setOnClickListener(listener);
        contentView.findViewById(R.id.menu3).setOnClickListener(listener);
        contentView.findViewById(R.id.menu4).setOnClickListener(listener);
        contentView.findViewById(R.id.menu5).setOnClickListener(listener);
    }

    /**
     * 删除订单
     * @param id
     */
    private void deleteIndent(String id) {
        RetrofitUtil.getInstance().orderDelete(openid, id, "1", new Subscriber<BaseResponse<EmptyEntity>>() {
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
                    finish();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 取消订单
     * @param id
     * @param closereason
     */
    private void cancelIndent(String id, String closereason) {
        RetrofitUtil.getInstance().orderCancel(openid, id, closereason, new Subscriber<BaseResponse<EmptyEntity>>() {
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
                    finish();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 确认收货
     * @param id
     */
    private void confirmOrder(String id) {
        RetrofitUtil.getInstance().orderFinish(openid, id, new Subscriber<BaseResponse<EmptyEntity>>() {
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
                   finish();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }
}
