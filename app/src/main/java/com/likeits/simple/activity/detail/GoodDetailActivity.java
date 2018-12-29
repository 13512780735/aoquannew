package com.likeits.simple.activity.detail;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.likeits.simple.R;
import com.likeits.simple.activity.detail.product.ProductSkuDialog;
import com.likeits.simple.activity.detail.product.bean.Product;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.fragment.goods.GoodDetail01Fragment;
import com.likeits.simple.fragment.goods.GoodDetail02Fragment;
import com.likeits.simple.fragment.goods.GoodDetail03Fragment;
import com.likeits.simple.fragment.goods.GoodDetail04Fragment;
import com.likeits.simple.fragment.goods.GoodDetailTabAdapter;
import com.likeits.simple.network.ApiService;
import com.likeits.simple.network.model.gooddetails.GoodDetailNavbarItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailSpecItemModel;
import com.likeits.simple.network.model.home.MainHomePagerModel;
import com.likeits.simple.utils.HttpUtil;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.utils.StringUtil;
import com.likeits.simple.view.NoScrollViewPager;
import com.loopj.android.http.RequestParams;
import com.wuhenzhizao.sku.bean.Sku;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GoodDetailActivity extends BaseActivity {
    @BindView(R.id.back_view)
    LinearLayout backView;
    @BindView(R.id.right_view)
    LinearLayout llRight;
    @BindView(R.id.indent_TabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    NoScrollViewPager mViewpager;

    //底部按鈕
    @BindView(R.id.ll_attention)
    LinearLayout ll_attention;
    @BindView(R.id.ll_shop)
    LinearLayout ll_shop;
    @BindView(R.id.ll_cart)
    LinearLayout ll_cart;
    @BindView(R.id.tv_attention01)
    TextView tvAttention01;
    @BindView(R.id.tv_attention)
    TextView tvAttention;
    @BindView(R.id.tv_shop01)
    TextView tvShop01;
    @BindView(R.id.tv_shop)
    TextView tvShop;
    @BindView(R.id.tv_cart01)
    TextView tvCart01;
    @BindView(R.id.tv_cart)
    TextView tvCart;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    private String id;
    private JSONArray items;
    private JSONObject goods;
    private GoodDetailNavbarItemModel goodDetailNavbarItemModel;
    private ArrayList<String> mTitles;
    private String goodData;
    private ProductSkuDialog dialog;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);
        id = "716";

        initData();
    }

    @OnClick({R.id.back_view, R.id.tv_add, R.id.tv_buy})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back_view:
                this.finish();
                break;
            case R.id.tv_add://添加购物车
                // XLog.json("product1-->"+items.optString(i));
                SharedPreferencesUtils.put(this, "keys", "1");
                showSkuDialog();
                break;
            case R.id.tv_buy://立即购买
                // XLog.json("product1-->"+items.optString(i));
                SharedPreferencesUtils.put(this, "keys", "2");
                showSkuDialog();
                break;
        }
    }

    private void showSkuDialog() {
        if (dialog == null) {
            dialog = new ProductSkuDialog(GoodDetailActivity.this);
            dialog.setData(product, new ProductSkuDialog.Callback() {
                @Override
                public void onAdded(Sku sku, int quantity) {

                }
            });
        }
        dialog.show();
    }

    private void initData() {
        LoaddingShow();
        String url = ApiService.Good_Detial;
        RequestParams params = new RequestParams();
        params.put("id", id);
        HttpUtil.post(url, params, new HttpUtil.RequestListener() {
            @Override
            public void success(String response) {
                LoaddingDismiss();
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.optInt("code");
                    String msg = object.optString("msg");
                    if (code == 200) {
                        goodData = response;
                        JSONObject object1 = object.optJSONObject("data");
                        JSONObject object2 = object1.optJSONObject("page");//page数据
                        items = object1.optJSONArray("items"); //items数据
                        goods = object1.optJSONObject("goods");
                        MainHomePagerModel pagerModel = JSON.parseObject(object2.toString(), MainHomePagerModel.class);
                        XLog.e(pagerModel);
                        XLog.e(items);
                        for (int i = 0; i < items.length(); i++) {
                            String id = items.optJSONObject(i).optString("id");
                            if ("detail_navbar".equals(id)) {
                                goodDetailNavbarItemModel = JSON.parseObject(items.optString(i), GoodDetailNavbarItemModel.class);
                                initNavTab();
                            }
                        }
                        initUI();
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
                LoaddingDismiss();
            }
        });
    }

    private void initUI() {

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setupWithViewPager(mViewpager);
        List<Fragment> mfragments = new ArrayList<>();
        GoodDetail01Fragment goodsDetails01Fragment = new GoodDetail01Fragment();
        GoodDetail02Fragment goodsDetails02Fragment = new GoodDetail02Fragment();
        GoodDetail03Fragment goodsDetails03Fragment = new GoodDetail03Fragment();
        GoodDetail04Fragment goodsDetails04Fragment = new GoodDetail04Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("goodData", goodData);
        bundle.putString("id", id);
        goodsDetails01Fragment.setArguments(bundle);
        goodsDetails02Fragment.setArguments(bundle);
//
        if (goods.optString("params") == null && !goods.optBoolean("showcomments")) {
            mTitles = new ArrayList<>(Arrays.asList("商品", "详情"));
            mfragments.add(goodsDetails01Fragment);
            mfragments.add(goodsDetails02Fragment);
        } else if (goods.optString("params") == null && goods.optBoolean("showcomments")) {
            mTitles = new ArrayList<>(Arrays.asList("商品", "详情", "评价"));
            mfragments.add(goodsDetails01Fragment);
            mfragments.add(goodsDetails02Fragment);
            mfragments.add(goodsDetails04Fragment);
        } else if (goods.optString("params") != null && !goods.optBoolean("showcomments")) {
            mTitles = new ArrayList<>(Arrays.asList("商品", "详情", "参数"));
            mfragments.add(goodsDetails01Fragment);
            mfragments.add(goodsDetails02Fragment);
            mfragments.add(goodsDetails03Fragment);
        } else {
            mTitles = new ArrayList<>(Arrays.asList("商品", "详情", "参数", "评价"));
            mfragments.add(goodsDetails01Fragment);
            mfragments.add(goodsDetails02Fragment);
            mfragments.add(goodsDetails03Fragment);
            mfragments.add(goodsDetails04Fragment);
        }

        mViewpager.setAdapter(new GoodDetailTabAdapter(getSupportFragmentManager(), mfragments, mTitles));
        mViewpager.setCurrentItem(0);
        for (int i = 0; i < items.length(); i++) {
            String id = items.optJSONObject(i).optString("id");
            if ("detail_spec".equals(id)) {
                try {
                    JSONObject object = new JSONObject(items.optString(i));
                    JSONObject object1 = object.optJSONObject("data");
                    String object2 = object1.optString("spec");
                    SharedPreferencesUtils.put(GoodDetailActivity.this, "product", object2);
                    product = new Gson().fromJson(object2, new TypeToken<Product>() {
                    }.getType());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                XLog.json("product1-->" + product);
            }
        }


    }

    /**
     * 底部初始化
     */
    private void initNavTab() {
        Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        tvAttention.setText(goodDetailNavbarItemModel.getParams().getLiketext());
        tvAttention.setTextColor(Color.parseColor(goodDetailNavbarItemModel.getStyle().getTextcolor()));
        tvAttention01.setTypeface(iconTypeface);
        tvAttention01.setText(StringUtil.decode("\\u" + goodDetailNavbarItemModel.getParams().getLikeiconclass()));
        tvAttention01.setTextColor(Color.parseColor(goodDetailNavbarItemModel.getStyle().getIconcolor()));
        tvShop.setText(goodDetailNavbarItemModel.getParams().getShoptext());
        tvShop.setTextColor(Color.parseColor(goodDetailNavbarItemModel.getStyle().getTextcolor()));
        tvShop01.setTypeface(iconTypeface);
        tvShop01.setText(StringUtil.decode("\\u" + goodDetailNavbarItemModel.getParams().getShopiconclass()));
        tvShop01.setTextColor(Color.parseColor(goodDetailNavbarItemModel.getStyle().getIconcolor()));
        tvCart.setText(goodDetailNavbarItemModel.getParams().getCarttext());
        tvCart.setTextColor(Color.parseColor(goodDetailNavbarItemModel.getStyle().getTextcolor()));
        tvCart01.setTypeface(iconTypeface);
        tvCart01.setText(StringUtil.decode("\\u" + goodDetailNavbarItemModel.getParams().getCarticonclass()));
        tvCart01.setTextColor(Color.parseColor(goodDetailNavbarItemModel.getStyle().getIconcolor()));
        tvAdd.setText("加入购物车");
        tvBuy.setText(goodDetailNavbarItemModel.getParams().getTextbuy());
        tvAdd.setBackgroundColor(Color.parseColor(goodDetailNavbarItemModel.getStyle().getCartcolor()));
        tvBuy.setBackgroundColor(Color.parseColor(goodDetailNavbarItemModel.getStyle().getBuycolor()));
        if ("1".equals(goodDetailNavbarItemModel.getParams().getHidelike())) {
            ll_attention.setVisibility(View.GONE);
        } else {
            ll_attention.setVisibility(View.VISIBLE);
        }
        if ("1".equals(goodDetailNavbarItemModel.getParams().getHideshop())) {
            ll_shop.setVisibility(View.GONE);
        } else {
            ll_shop.setVisibility(View.VISIBLE);
        }
        if ("1".equals(goodDetailNavbarItemModel.getParams().getHidecart())) {
            ll_cart.setVisibility(View.GONE);
        } else {
            ll_cart.setVisibility(View.VISIBLE);
        }
        if ("1".equals(goodDetailNavbarItemModel.getParams().getHidecartbtn())) {
            tvAdd.setVisibility(View.GONE);
        } else {
            tvAdd.setVisibility(View.VISIBLE);
        }
        if (!goods.optBoolean("canbuy")) {
            tvBuy.setVisibility(View.VISIBLE);
            tvBuy.setClickable(false);
            String color1 =  goodDetailNavbarItemModel.getParams().getNobuybgcolor();
            String color = color1.substring(1, color1.length());
            tvBuy.setBackgroundColor(Color.parseColor("#" + "4D" + color));
        //    tvBuy.setBackgroundColor(Color.parseColor("#00000000"));
            ll_cart.setVisibility(View.GONE);
            ll_shop.setVisibility(View.GONE);
            ll_attention.setVisibility(View.GONE);
            tvAdd.setVisibility(View.GONE);
        }

    }
}
