package com.likeit.aqe365.activity.indent;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.Indent.GoodsRefundmodel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.StringUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

public class EditExpressActivity extends BaseActivity {
    @BindView(R.id.ll_after_sale_causes)
    LinearLayout ll_after_sale_causes;
    @BindView(R.id.tv_after_sale_cause)
    TextView tv_after_sale_cause;
    @BindView(R.id.tv_after_sale_price)
    EditText tv_after_sale_price;
    private String grefundid;
    private String rtype;
    private PopupWindow popupWindow;
    private AdapterPopupWindow adapterPopupwindow;
    private List<GoodsRefundmodel.Express_list> data;
    String express;
    String expresscom;
    private String expresssn,goodsid,optionid,ordId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_express);
        setBackView();
        setTitle("寄回商品");
        //goodsRefundmodel = (GoodsRefundmodel) getIntent().getExtras().getSerializable("goodsRefundmodel");
        grefundid = getIntent().getExtras().getString("grefundid");
        rtype = getIntent().getExtras().getString("rtype");
        goodsid = getIntent().getExtras().getString("goodsid");
        optionid = getIntent().getExtras().getString("optionid");
        ordId = getIntent().getExtras().getString("ordId");
        data = getIntent().getExtras().getParcelableArrayList("goodsRefundmodel");
    }

    @OnClick({R.id.ll_after_sale_causes, R.id.tv_apply, R.id.tv_cancel})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_after_sale_causes:
                initPopupWindow();
                break;
            case R.id.tv_apply:
                expresssn = tv_after_sale_price.getText().toString();
                if (StringUtil.isBlank(expresscom)) {
                    showToast("请选择快递公司");
                    return;
                } else if (StringUtil.isBlank(expresssn)) {
                    showToast("请填写快递单号");
                    return;
                } else {
                    toApply();
                }
                break;

            case R.id.tv_cancel:
                finish();
                break;
        }

    }

    private void initPopupWindow() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View contentView = inflater.inflate(R.layout.pop_menu5, null);
        ListView listView = (ListView) contentView.findViewById(R.id.listview);
        adapterPopupwindow = new AdapterPopupWindow(mContext, R.layout.popwindow05_tv, data);
        listView.setAdapter(adapterPopupwindow);
        //item 的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //IOCOutMakeMaterialSubmit.Data data = dataListPopupWindow.get(i);
                // dataList.add(data);
                //adapterListView.notifyDataSetChanged();
                tv_after_sale_cause.setText(data.get(i).getName());
                express = data.get(i).getExpress();
                expresscom = data.get(i).getName();
                closePopupWindow();
                //reset();
            }
        });
        // PopupWindow实例化
        popupWindow = new PopupWindow(contentView, tv_after_sale_cause.getWidth(),
                LinearLayout.LayoutParams.MATCH_PARENT, true);
        // popupWindow.setAnimationStyle(R.style.MenuAnimationFade);
        // 弹出窗口显示内容视图,默认以锚定视图的左下角为起点，这里为点击按钮
        popupWindow.showAsDropDown(tv_after_sale_cause, 0, 20);
        //  popupWindow.showAtLocation(tv_after_sale_cause, Gravity.CENTER, 0, 0);
        //获取最底层窗口的参数，背景变灰色效果
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.alpha = 0.5f;
//        getWindow().setAttributes(params);
    }

    /**
     * 关闭窗口
     */
    private void closePopupWindow() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            popupWindow = null;
//            WindowManager.LayoutParams params = getWindow().getAttributes();
//            params.alpha = 1f;
//            getWindow().setAttributes(params);
        }
    }

    /**
     * popupWindow 设置适配器
     */
    private class AdapterPopupWindow extends ArrayAdapter<GoodsRefundmodel.Express_list> {
        private int resourceId;

        public AdapterPopupWindow(Context context, int resource, List<GoodsRefundmodel.Express_list> data) {
            super(context, resource, data);
            resourceId = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GoodsRefundmodel.Express_list data1 = data.get(position);
            convertView = LayoutInflater.from(mContext).inflate(resourceId,
                    null);
            ((TextView) convertView.findViewById(R.id.tv_pop)).setText(data1.getName());
            return convertView;
        }
    }

    private void toApply() {

        LoaddingShow();
        RetrofitUtil.getInstance().goodsRefundExpress(openid, goodsid, ordId
                , optionid, rtype, grefundid, express, expresssn, expresscom, new Subscriber<BaseResponse<EmptyEntity>>() {
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
                            finish();
                        } else {
                            showToast(baseResponse.getMsg());
                        }

                    }
                });
    }
}
