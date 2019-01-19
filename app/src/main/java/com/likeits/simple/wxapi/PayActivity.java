package com.likeits.simple.wxapi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.likeits.simple.R;
import com.likeits.simple.activity.indent.GoodsIndentActivity;
import com.likeits.simple.activity.indent.IndentSuccessActivity;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.pay.BalacePayModel;
import com.likeits.simple.network.model.pay.PayModel;
import com.likeits.simple.network.util.RetrofitUtil;
import com.likeits.simple.utils.AppManager;
import com.likeits.simple.utils.CustomDialog;
import com.likeits.simple.wxapi.alipay.PayResult;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class PayActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_pay_weixin)
    RelativeLayout rlweixin;
    @BindView(R.id.rl_pay_zhifubao)
    RelativeLayout rlZfb;
    @BindView(R.id.rl_pay_balance)
    RelativeLayout rlBalance;//余额
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_indent_number)
    TextView tv_indent_number;
    @BindView(R.id.tv_balance)
    TextView tv_balance;
    @BindView(R.id.back_view)
    LinearLayout back_view;
    private IWXAPI api;


    private static final int SDK_PAY_FLAG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {


                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(mContext, "支付结果确认中", Toast.LENGTH_SHORT).show();
                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(mContext, "支付失败", Toast.LENGTH_SHORT).show();
                            Log.d("TAG", "resultStatus-->" + resultStatus);

                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

    };
    private String ordersn, price;
    private String flag;
    private String pay_type;
    private String vipId;
    private String paykey;
    private CustomDialog dialog;
    private PayActivity mContext;
    private String ukey, tid, money;
    private int status;
    private String WX_APPID;
    private String id;
    private List<PayModel.PayBean> payBean;
    private String payId;
    private String current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        mContext = this;
        setTitle("收银台");
        WX_APPID = "wx53ba9da9956a74aa";
        api = WXAPIFactory.createWXAPI(this, WX_APPID, false);
        api.registerApp(WX_APPID);
        tid = getIntent().getExtras().getString("tid");
        id = getIntent().getExtras().getString("id");
        money = getIntent().getExtras().getString("money");
        XLog.e("tid-->" + id);
        tv_indent_number.setText(tid);
        tvPrice.setText("¥ " + money);
        findView(R.id.back_view).setVisibility(View.VISIBLE);
        findView(R.id.back_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdialog();
            }
        });
        initData();
    }

    private void showdialog() {
        CustomDialog customDialog = new CustomDialog(mContext).builder();
        customDialog.setCancelable(true);
        customDialog.setTitle("确定要放弃付款吗？");
        customDialog.setSubTitle("喜欢的商品可能随时会被抢空哦");
        customDialog.setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        customDialog.setPositiveButton("确定", Color.parseColor(theme_bg_tex), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("status", 0);
                bundle.putString("flag", "1");
                toActivity(GoodsIndentActivity.class, bundle);
                finish();
                AppManager.getAppManager().finishAllActivity();
            }
        });
        customDialog.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showdialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        showdialog();
//    }

    private void initData() {
        LoaddingShow();
        RetrofitUtil.getInstance().PayInto(openid, id, new Subscriber<BaseResponse<PayModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<PayModel> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.getCode() == 200) {
                    payBean = baseResponse.getData().getPay();
                    payId = baseResponse.getData().getId();
                    initUI();
                }
            }
        });
    }

    private void initUI() {
        for (int i = 0; i < payBean.size(); i++) {
            String name = payBean.get(i).getName();
            Boolean success = payBean.get(i).isSuccess();
            current = payBean.get(i).getCurrent();
            if ("wechat".equals(name)) {
                if (success) {
                    rlweixin.setVisibility(View.VISIBLE);
                } else {
                    rlweixin.setVisibility(View.GONE);
                }
            } else if ("alipay".equals(name)) {
                if (success) {
                    rlZfb.setVisibility(View.VISIBLE);
                } else {
                    rlZfb.setVisibility(View.GONE);
                }
            } else if ("credit".equals(name)) {
                if (success) {
                    rlBalance.setVisibility(View.VISIBLE);
                    tv_balance.setText("¥ " + current);
                } else {
                    rlBalance.setVisibility(View.GONE);
                }
            }
        }
    }


    @OnClick({R.id.rl_pay_weixin, R.id.rl_pay_zhifubao, R.id.rl_pay_balance})
    public void onClick(View v) {
        switch (v.getId()) {
            //微信支付
            case R.id.rl_pay_weixin:
                pay_type = "wxpay";
                //  wechatPay();
                break;
//            //支付宝支付
            case R.id.rl_pay_zhifubao:
                pay_type = "alipay";
                //  alipayPay();
                break;
            case R.id.rl_pay_balance:
                showDialog(id, money);
                break;

        }
    }

    private void showDialog(final String id, String money) {
        CustomDialog customDialog = new CustomDialog(mContext).builder();
        customDialog.setCancelable(true);
        customDialog.setTitle("提醒");
        customDialog.setSubTitle("确定要支付吗？");
        customDialog.setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        customDialog.setPositiveButton("确定", Color.parseColor(theme_bg_tex), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                balancePaid(id);//余额支付
                LoaddingShow();
                RetrofitUtil.getInstance().BalancePay(openid,id, "credit", new Subscriber<BaseResponse<BalacePayModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseResponse<BalacePayModel> baseResponse) {
                        XLog.e("code-->"+baseResponse.getCode());
                        XLog.e("code-->"+baseResponse.getData());
                        LoaddingDismiss();
                        if(baseResponse.getCode()==200){
                            BalacePayModel balacePayModel=baseResponse.getData();
                            Intent intent=new Intent(mContext,IndentSuccessActivity.class);
                          // intent.putExtra("balacePayModel",balacePayModel);

                            intent.putExtra("balacePayModel",new Gson().toJson(balacePayModel));
                            startActivity(intent);
                            finish();
                        }else{
                            showToast(baseResponse.getMsg());
                        }
                    }
                });
            }
        });
        customDialog.show();
    }

    private void balancePaid(String id) {

    }

//    /**
//     * 微信支付
//     */
//    private void wechatPay() {
//        loaddingDialog.show();
//        String random = signs[2];
//        RetrofitUtil.getInstance().appWechat(token, signature, newtime, random, tid, money, new Subscriber<BaseResponse<WechatPayModel>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                loaddingDialog.dismiss();
//            }
//
//            @Override
//            public void onNext(BaseResponse<WechatPayModel> baseResponse) {
//                loaddingDialog.dismiss();
//                if (baseResponse.code == 200) {
//                    String data = baseResponse.getData().getAppwechat();
//                    try {
//                        JSONObject object = new JSONObject(data);
//                        String appId = object.optString("appid");
//                        String partnerId = object.optString("mch_id");
//                        String prepayId = object.optString("prepay_id");
//                        String nonceStr = object.optString("nonce_str");
//                        String packageValue = "Sign=Wxpay";
//                        long timeMills = System.currentTimeMillis() / 1000;
//                        String timeStamp = String.valueOf(timeMills);
//                        String stringA =
//                                "appid=" + appId
//                                        + "&noncestr=" + nonceStr
//                                        + "&package=" + packageValue
//                                        + "&partnerid=" + partnerId
//                                        + "&prepayid=" + prepayId
//                                        + "&timestamp=" + timeStamp;
//                        String key = "dahgdrh678fdh4sdhtui527gjsdtasaa";
//                        String stringSignTemp = stringA + "&key=" + key;
//                        String sign = MD5.getMessageDigest(stringSignTemp.getBytes()).toUpperCase();
//                        LogUtils.d("TAG" + "WX_APPID-->" + WX_APPID + "appId-->" + appId + "partnerId-->" + partnerId + "prepayId-->" + prepayId + "nonceStr-->" + nonceStr + "packageValue-->" + packageValue);
//                        sendPayred(appId, partnerId, prepayId, nonceStr, packageValue, sign, timeStamp);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    showProgress(baseResponse.getMsg());
//                }
//            }
//        });
//    }
//
//    /**
//     * 支付宝
//     */
//    private void alipayPay() {
//        loaddingDialog.show();
//        final String sign = SignUtils.getSign(mContext);
//        String signs[] = sign.split("##");
//        String signature = signs[0];
//        String newtime = signs[1];
//        String random = signs[2];
//        RetrofitUtil.getInstance().appAlipay(token, signature, newtime, random, tid, money, new Subscriber<BaseResponse<AlipayPayAModel>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                loaddingDialog.dismiss();
//            }
//
//            @Override
//            public void onNext(BaseResponse<AlipayPayAModel> baseResponse) {
//                loaddingDialog.dismiss();
//                if (baseResponse.code == 200) {
//                    String data = baseResponse.getData().getAppalipay();
//                    alipay(data);
//                } else {
//                    showProgress(baseResponse.getMsg());
//                }
//            }
//        });
//    }


    private void alipay(String data) {

        final String payInfo = data;

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(PayActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(payInfo, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }


    private void sendPayred(String appId, String partnerId, String prepayId, String nonceStr, String packageValue, String sign, String timeStamp) {
        PayReq request = new PayReq();
        request.appId = appId;
        request.partnerId = partnerId;
        request.prepayId = prepayId;
        request.nonceStr = nonceStr;
        request.packageValue = packageValue;
        request.sign = sign;
        request.timeStamp = timeStamp;
        api.sendReq(request);
    }


}