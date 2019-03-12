package com.likeit.aqe365.adapter.div_provider.good;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.detail.product.ProductSkuDialog;
import com.likeit.aqe365.activity.detail.product.bean.Product;
import com.likeit.aqe365.network.model.gooddetails.GoodDetailSpecItemModel;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.wuhenzhizao.sku.bean.Sku;

public class GoodDetailsSpecItemProvider extends BaseItemProvider<GoodDetailSpecItemModel, BaseViewHolder> {
    private ProductSkuDialog dialog;
    private TextView mTvSales;
    private Product product;

    @Override
    public int viewType() {
        return GoodDetailAdapter.TYPE_DETAILS_SPEC;
    }

    @Override
    public int layout() {
        return R.layout.good_details_spec;
    }

    @Override
    public void convert(BaseViewHolder helper, GoodDetailSpecItemModel data, int position) {
        String product1 = SharedPreferencesUtils.getString(mContext, "product");
        LinearLayout ll_sales = helper.getView(R.id.ll_sales);
        mTvSales = helper.getView(R.id.tv_sales);
        //  String json = data.getData().getSpec().toString();
        product = new Gson().fromJson(product1, new TypeToken<Product>() {
        }.getType());
        ll_sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesUtils.put(mContext, "keys", "0");
                showSkuDialog();
            }
        });
        //   product = new Gson().fromJson(data.getData().getSpec().toString(), new TypeToken<Product>() {
        //    }.getType());

    }


    private void showSkuDialog() {
        if (dialog == null) {
            dialog = new ProductSkuDialog(mContext);
            dialog.setData(product, new ProductSkuDialog.Callback() {
                @Override
                public void onAdded(Sku sku, int quantity) {
                    if (sku == null) {
                        mTvSales.setText("数量：" + quantity);
                    } else {
                        String title = "";
                        for (int i = 0; i < sku.getAttributes().size(); i++) {
                            String temp = sku.getAttributes().get(i).getValue();
                            title += temp + " ,";
                        }
                        String titles = title.substring(0, title.length() - 1);
                        mTvSales.setText("规格：" + titles + "数量：" + quantity);
                    }
                }
            });
        }
        dialog.show();
    }

}
