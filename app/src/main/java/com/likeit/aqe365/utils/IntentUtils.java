package com.likeit.aqe365.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.likeit.aqe365.activity.detail.GoodDetailActivity;
import com.likeit.aqe365.activity.indent.GoodsIndentActivity;
import com.likeit.aqe365.activity.indent.IndentReturnsActivity;
import com.likeit.aqe365.activity.user.CouponActivity;
import com.likeit.aqe365.activity.user.FootprintActivity;
import com.likeit.aqe365.activity.user.GoodsAttentionActivity;
import com.likeit.aqe365.activity.user.MyCouponActivity;
import com.likeit.aqe365.activity.user.SelectAddress01Activity;
import com.likeit.aqe365.adapter.div_provider.Custom.CustomActivity;
import com.likeit.aqe365.activity.user.UserInfoActivity;

public class IntentUtils {
    public static void intentTo(Context mContext, String linkUrl, String id) {
        //自定義DIY
        if ("diypage".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            Intent intent = new Intent(mContext, CustomActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }  //商品详情
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
            bundle.putString("flag","0");
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //待付款
        else if ("orderstatus0".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 1);
            bundle.putString("flag","0");
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //待发货
        else if ("orderstatus1".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 2);
            bundle.putString("flag","0");
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //待收货
        else if ("orderstatus2".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 3);
            bundle.putString("flag","0");
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //退换货
        else if ("orderstatus4".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, IndentReturnsActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //收货地址
        else if ("member.address".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, SelectAddress01Activity.class);
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
        //我的优惠券
        else if ("sale.coupon.my".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, MyCouponActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //优惠券中心
        else if ("sale.coupon".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, CouponActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //我的资料
        else if ("member.info".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, UserInfoActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //会员充值
        else if ("member.recharge".equals(linkUrl)) {
        }
        //账户提现
        else if ("member.withdraw".equals(linkUrl)) {
        }
        //余额明细
        else if ("member.log".equals(linkUrl)) {
        }
    }
}
