package com.likeit.aqe365.activity.indent;

import android.view.View;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.view.BorderTextView;

import butterknife.BindView;
import butterknife.OnClick;

public class AfterSaleTypeActivity extends BaseActivity {
    @BindView(R.id.tv_next)
    BorderTextView tv_next;
    @BindView(R.id.tv_cancel)
    BorderTextView tv_cancel;
    @BindView(R.id.ll_check01)
    LinearLayout ll_check01;
    @BindView(R.id.ll_check02)
    LinearLayout ll_check02;
    @BindView(R.id.cb_selected01)//仅退款
            CheckBox cb_selected01;
    @BindView(R.id.tv_refund)//
            TextView tv_refund;
    @BindView(R.id.cb_selected02)//退换货
            CheckBox cb_selected02;
    @BindView(R.id.tv_refund01)//退换货
            TextView tv_refund01;


    private String payrefundtext, afterrefundtext, goodsid, optionid, grefundid, ordId;
    private boolean afterrefund, payrefund;
    private String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sale_type);
        setTitle("售后类型");
        setBackView();
        payrefundtext = getIntent().getExtras().getString("payrefundtext");
        afterrefundtext = getIntent().getExtras().getString("afterrefundtext");
        goodsid = getIntent().getExtras().getString("goodsid");
        optionid = getIntent().getExtras().getString("optionid");
        grefundid = getIntent().getExtras().getString("grefundid");
        ordId = getIntent().getExtras().getString("orderid");
        afterrefund = getIntent().getExtras().getBoolean("afterrefund");
        payrefund = getIntent().getExtras().getBoolean("payrefund");
        initUI();
    }

    private void initUI() {
        tv_refund.setText(payrefundtext);
        tv_refund01.setText(afterrefundtext);
        if (payrefund == true && afterrefund == true) {
            cb_selected01.setChecked(true);
            cb_selected02.setChecked(false);
            type = "1";
        } else if (payrefund == true && afterrefund == false) {
            type = "1";
            cb_selected01.setChecked(true);
            cb_selected02.setChecked(false);
            ll_check02.setVisibility(View.GONE);
            cb_selected01.setClickable(false);
            cb_selected02.setClickable(false);
        } else if (payrefund == false && afterrefund == true) {
            type = "2";
            cb_selected01.setChecked(false);
            cb_selected02.setChecked(true);
            ll_check01.setVisibility(View.GONE);
            cb_selected01.setClickable(false);
            cb_selected02.setClickable(false);
        } else {
            cb_selected01.setChecked(false);
            ll_check02.setVisibility(View.GONE);
            ll_check01.setVisibility(View.GONE);
            cb_selected02.setChecked(false);
            cb_selected01.setClickable(false);
            cb_selected02.setClickable(false);
        }

    }

    @OnClick({R.id.tv_next, R.id.tv_cancel, R.id.cb_selected01, R.id.cb_selected02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
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
                bundle.putString("flag","0");
                toActivity(RefundActivity.class, bundle);
                finish();
                break;
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.cb_selected01:
                cb_selected02.setChecked(false);
                cb_selected01.setChecked(true);
                type = "1";
                break;
            case R.id.cb_selected02:
                cb_selected02.setChecked(true);
                cb_selected01.setChecked(false);
                type = "2";
                break;
        }
    }
}
