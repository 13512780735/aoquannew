package com.likeits.simple.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.likeits.simple.activity.cart.SelectAddressActivity;
import com.likeits.simple.activity.detail.GoodDetailActivity;
import com.likeits.simple.activity.indent.AfterSaleActivity;
import com.likeits.simple.activity.indent.GoodsIndentActivity;
import com.likeits.simple.activity.user.FootprintActivity;
import com.likeits.simple.activity.user.GoodsAttentionActivity;
import com.likeits.simple.adapter.div_provider.Custom.CustomActivity;

public class IntentUtils {
    public static void intentTo(Context mContext, String linkUrl, String id) {
        //自定義DIY
        if ("diypage".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            Intent intent = new Intent(mContext, CustomActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }  //自定義DIY
        else if ("goods.detail".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            Intent intent = new Intent(mContext, GoodDetailActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //全部订单
        else if ("order".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 0);
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //待付款
        else if ("orderstatus0".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 1);
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //待发货
        else if ("orderstatus1".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 2);
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //待收货
        else if ("orderstatus2".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 3);
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //退换货
        else if ("orderstatus4".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, AfterSaleActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //收货地址
        else if ("member.address".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, SelectAddressActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //我的关注
        else if ("member.favorite".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, GoodsAttentionActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //我的足迹
        else if ("member.history".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, FootprintActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
    }
}
