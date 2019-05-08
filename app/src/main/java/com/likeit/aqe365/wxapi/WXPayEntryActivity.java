package com.likeit.aqe365.wxapi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.event.PayEventMessage;
import com.likeit.aqe365.utils.CustomDialog;
import com.likeit.aqe365.utils.IntentUtils;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.ToastUtils;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {
    private IWXAPI api;
    private WXPayEntryActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxpay_entry);
        mContext = this;
        String WX_APPID = "wx53ba9da9956a74aa";
        api = WXAPIFactory.createWXAPI(this, WX_APPID);
        api.handleIntent(getIntent(), this);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }


    @Override
    public void onReq(BaseReq resp) {

    }

    @Override
    public void onResp(BaseResp resp) {
        XLog.i("微信支付回调..", "ansen onResp");
        final String succurl = SharedPreferencesUtils.getString(mContext, "succurl");
        final String faildurl = SharedPreferencesUtils.getString(mContext, "faildurl");
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            int code = resp.errCode;
            Log.d("TAg", code + "");
            Log.d("TAG", +resp.getType() + "");
            SharedPreferencesUtils.put(mContext, "type", "WXPay");
            SharedPreferencesUtils.put(mContext, "code", code);
            if (code == 0) {
                new AlertDialog.Builder(this).setMessage("支付订单成功！").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // EventBus.getDefault().post(new PayEventMessage("1"));
                        dialog.dismiss();
                        IntentUtils.intentTo(mContext, "", "", succurl);
                        onBackPressed();
                    }
                }).setTitle("微信支付结果").setCancelable(false).show();

            } else if (code == -2) {
                new AlertDialog.Builder(this).setMessage("取消支付").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //EventBus.getDefault().post(new PayEventMessage("2"));
                        dialog.dismiss();
                        IntentUtils.intentTo(mContext, "", "", faildurl);
                        onBackPressed();
                    }
                }).setTitle("微信支付结果").setCancelable(false).show();

            } else {
                new AlertDialog.Builder(this).setMessage("交易出错").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // EventBus.getDefault().post(new PayEventMessage("2"));
                        dialog.dismiss();
                        IntentUtils.intentTo(mContext, "", "", faildurl);
                        onBackPressed();
                    }
                }).setTitle("微信支付结果").setCancelable(false).show();
            }

        }
    }

    private CustomDialog dialog;

    /**
     * 显示字符串消息
     *
     * @param message
     */
    public void showProgress(String message) {
        // dialog = new CustomDialog(getActivity());
        dialog = new CustomDialog(this).builder()
                .setGravity(Gravity.CENTER).setTitle("提示", getResources().getColor(R.color.sd_color_black))//可以不设置标题颜色，默认系统颜色
                .setSubTitle(message);
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1000);
    }
}
