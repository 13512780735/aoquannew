package com.likeits.simple.activity.good.filter.view;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.activity.good.filter.adapter.GoodsAttrListAdapter;
import com.likeits.simple.activity.good.filter.adapter.GoodsAttrsAdapter;
import com.likeits.simple.activity.good.filter.vo.SaleAttributeNameVo;
import com.likeits.simple.activity.good.filter.vo.SaleAttributeVo;
import com.likeits.simple.network.ApiService;
import com.likeits.simple.network.model.home.MainHomePagerModel;
import com.likeits.simple.utils.HttpUtil;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * 筛选商品属性选择的popupwindow
 */
public class FilterPopupWindow extends PopupWindow {
    private View contentView;
    private Context context;
    private View goodsNoView;

    private GridView serviceGrid;
    private ListView selectionList;
    private TextView filterReset;
    private TextView filterSure;
    private GoodsAttrListAdapter adapter;
    private GoodsAttrsAdapter serviceAdapter;
    private List<SaleAttributeNameVo> itemData;
    private List<SaleAttributeVo> serviceList;
    private String[] serviceStr = new String[]{"推荐商品", "新品上市", "热卖商品", "促销商品", "卖家包邮", "限时抢购"};

    /**
     * 商品属性选择的popupwindow
     */
    public FilterPopupWindow(final Activity context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.popup_goods_details, null);
        goodsNoView = contentView.findViewById(R.id.popup_goods_noview);
        selectionList = (ListView) contentView.findViewById(R.id.selection_list);
        View headerView = LayoutInflater.from(context).inflate(R.layout.filter_header_view, selectionList, false);
        selectionList.addHeaderView(headerView);
        serviceGrid = (GridView) headerView.findViewById(R.id.yuguo_service);
        filterReset = (TextView) contentView.findViewById(R.id.filter_reset);
        filterSure = (TextView) contentView.findViewById(R.id.filter_sure);
        goodsNoView.setOnClickListener(new CancelOnClickListener());
        contentView.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
                    dismiss();
                }
                return true;
            }
        });
        serviceList = new ArrayList<SaleAttributeVo>();
        for (int i = 0; i < serviceStr.length; i++) {
            SaleAttributeVo vo = new SaleAttributeVo();
            vo.setValue(serviceStr[i]);
            serviceList.add(vo);
        }
        serviceAdapter = new GoodsAttrsAdapter(context);
        serviceGrid.setAdapter(serviceAdapter);
        serviceAdapter.notifyDataSetChanged(true, serviceList);
        serviceGrid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //设置当前选中的位置的状态为非。
                serviceList.get(arg2).setChecked(!serviceList.get(arg2).isChecked());
                for (int i = 0; i < serviceList.size(); i++) {
                    //跳过已设置的选中的位置的状态
                    if (i == arg2) {
                        continue;
                    }
                    serviceList.get(i).setChecked(false);
                }
                serviceAdapter.notifyDataSetChanged(true, serviceList);
            }
        });

        itemData = new ArrayList<>();
        adapter = new GoodsAttrListAdapter(context, itemData);
        selectionList.setAdapter(adapter);
        initData();
        // 重置的点击监听，将所有选项全设为false
        filterReset.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i < itemData.size(); i++) {
                    for (int j = 0; j < itemData.get(i).getSaleVo().size(); j++) {
                        itemData.get(i).getSaleVo().get(j).setChecked(false);
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
        // 确定的点击监听，将所有已选中项列出
        filterSure.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String str = "";
                for (int i = 0; i < itemData.size(); i++) {
                    for (int j = 0; j < itemData.get(i).getSaleVo().size(); j++) {
                        if (itemData.get(i).getSaleVo().get(j).isChecked()) {
                            str = str + itemData.get(i).getSaleVo().get(j).getValue();
                        }
                    }
                }
                Toast.makeText(FilterPopupWindow.this.context, str, Toast.LENGTH_SHORT).show();
            }
        });

        this.setContentView(contentView);
        this.setWidth(LayoutParams.MATCH_PARENT);
        this.setHeight(LayoutParams.MATCH_PARENT);
        ColorDrawable dw = new ColorDrawable(00000000);
        this.setBackgroundDrawable(dw);
        this.setFocusable(true);
        this.setOutsideTouchable(false);
        this.update();

    }

    private void initData() {
        String url = ApiService.GoodsFiltrate;
        String openid = SharedPreferencesUtils.getString(context, "openid");
        RequestParams params = new RequestParams();
        params.put("openid", openid);
        HttpUtil.post(url, params, new HttpUtil.RequestListener() {
            @Override
            public void success(String response) {
                XLog.json(response);
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.optInt("code");
                    String msg = object.optString("msg");
                    if (code == 200) {
                        JSONArray json = object.getJSONArray("data");
                        refreshAttrs(json);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable e) {

            }

            @Override
            public void onFinish() {
                super.onFinish();
            }
        });
    }

    /**
     * 刷新商品属性
     *
     * @param json
     * @throws JSONException
     */
    public void refreshAttrs(JSONArray json) throws JSONException {
        itemData.clear();
        for (int i = 0; i < json.length(); i++) {
            SaleAttributeNameVo saleName = new SaleAttributeNameVo();
            JSONObject obj = (JSONObject) json.opt(i);
            saleName.setName(obj.getString("title"));
            List<SaleAttributeVo> list = new ArrayList<SaleAttributeVo>();
            JSONArray array = new JSONArray();
            array = obj.optJSONArray("list");
            for (int j = 0; j < array.length(); j++) {
                JSONObject object = array.getJSONObject(j);
                SaleAttributeVo vo = new SaleAttributeVo();
                vo.setValue(object.getString("name"));
                vo.setGoodsAndValId(object.getString("id"));
                vo.setChecked(false);
//                if ("1".equals(object.getString("checkStatus"))) {
//                    vo.setChecked(true);
//                } else {
//                    vo.setChecked(false);
//                }
                list.add(vo);
            }
            saleName.setSaleVo(list);
            // 是否展开
            saleName.setNameIsChecked(false);
            itemData.add(saleName);
        }
        adapter.notifyDataSetChanged();
    }

    public class CancelOnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            dismiss();
        }
    }

    public boolean onKeyDown(Context context, int keyCode, KeyEvent event) {
        this.context = context;
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            dismiss();
        }
        return true;
    }

    public void showFilterPopup(View parent) {
        if (!this.isShowing()) {
            this.showAsDropDown(parent);
        } else {
            this.dismiss();
        }
    }

}
