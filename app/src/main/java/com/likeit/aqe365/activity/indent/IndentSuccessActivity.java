package com.likeit.aqe365.activity.indent;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.MainActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.main.MainNavigationModel;
import com.likeit.aqe365.network.model.pay.BalacePayModel;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.view.BorderTextView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class IndentSuccessActivity extends BaseActivity {

    private BalacePayModel balacePayModel;


    @BindView(R.id.tv_status)
    TextView tv_status;//订单状态
    @BindView(R.id.tv_express)
    TextView tv_express;//发货状态
    @BindView(R.id.tv_address01)
    TextView tv_address01;//地址图标
    @BindView(R.id.tv_name)
    TextView tv_name;//收货人姓名
    @BindView(R.id.tv_phone)
    TextView tv_phone;//收货人电话
    @BindView(R.id.tv_address)
    TextView tv_address;//收货地址
    @BindView(R.id.tv_pay_money)
    TextView tv_pay_money;//实际金额
    @BindView(R.id.tv_toIndent_detail)
    BorderTextView tv_toIndent_detail;//跳转订单详情
    @BindView(R.id.tv_toMain)
    BorderTextView tv_toMain;//跳转主页


    private String[] mIconSelectIds;//标题
    private String[] mTitles01;//未选中

    private String[] mLinkurl;


    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayList<String> stringArrayList1 = new ArrayList<String>();
    ArrayList<String> stringArrayList2 = new ArrayList<String>();
    private Bundle bundle;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_success);
     // balacePayModel = (BalacePayModel) getIntent().getSerializableExtra("balacePayModel");

        String bookJson=getIntent().getStringExtra("balacePayModel");
        balacePayModel=new Gson().fromJson(bookJson,BalacePayModel.class);
        XLog.e("balacePayModel"+balacePayModel.getAddress().getProvince());
        initTab();
        initUI();
    }

    private void initUI() {
        setTitle("支付成功");
        Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        tv_status.setText(balacePayModel.getOrder().getStatus());
        tv_express.setText(balacePayModel.getOrder().getText());
        tv_pay_money.setText("¥ " + balacePayModel.getOrder().getPrice());
        tv_pay_money.setTextColor(Color.parseColor(theme_bg_tex));
        tv_address01.setTypeface(iconTypeface);
        tv_address01.setText(StringUtil.decode("\\u" + "e651"));
        tv_address01.setTextColor(Color.parseColor("#989898"));
        tv_name.setText("联系人  :" + balacePayModel.getAddress().getRealname());
        tv_phone.setText("联系电话:" + balacePayModel.getAddress().getMobile());
        tv_address.setText(balacePayModel.getAddress().getProvince() + balacePayModel.getAddress().getCity() + balacePayModel.getAddress().getArea());
        findView(R.id.back_view).setVisibility(View.VISIBLE);
        findView(R.id.back_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            startMainActivity();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void startMainActivity() {
        bundle = new Bundle();
        //  bundle.putString("flag", "0");
        bundle.putStringArray("mTitles", mTitles01);
        bundle.putStringArray("mLinkurl", mLinkurl);
        bundle.putStringArray("mIconSelectIds", mIconSelectIds);
        bundle.putString("flag", "1");
        bundle.putInt("index", 0);
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void initTab() {
        String navtab = SharedPreferencesUtils.getString(mContext, "navtab");
        Type type = new TypeToken<List<MainNavigationModel.ItemsBean>>() {
        }.getType();
        List<MainNavigationModel.ItemsBean> items = new Gson().fromJson(navtab, type);
        for (int i = 0; i < items.size(); i++) {
            stringArrayList.add(items.get(i).getText());
            stringArrayList1.add(StringUtil.decode("\\u" + items.get(i).getIconclasscode()));
            stringArrayList2.add(items.get(i).getLinkurl());
        }
        mTitles01 = stringArrayList.toArray(new String[stringArrayList.size()]);
        mLinkurl = stringArrayList2.toArray(new String[stringArrayList2.size()]);
        mIconSelectIds = stringArrayList1.toArray(new String[stringArrayList1.size()]);

    }

    @OnClick({R.id.tv_toIndent_detail, R.id.tv_toMain})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_toIndent_detail://跳订单详情
                id=String.valueOf(balacePayModel.getOrder().getId());
                SharedPreferencesUtils.put(mContext,"ordId",id);
                bundle = new Bundle();
                bundle.putInt("status", 1);
                bundle.putString("id", id);
                bundle.putString("flag", "1");
                toActivity(IndentDetailsActivity.class, bundle);

                break;
            case R.id.tv_toMain://跳主页
                    startMainActivity();
                break;
        }
    }
}
