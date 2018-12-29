package com.likeits.simple.activity;

import android.content.Intent;

import com.likeits.simple.Interface.BaseInterface;
import com.likeits.simple.activity.login_register.ForgetPwdFragment;
import com.likeits.simple.activity.login_register.PhoneLoginFragment;
import com.likeits.simple.activity.login_register.RegisterFragment;
import com.likeits.simple.activity.login_register.RegisterProtocolFragment;
import com.likeits.simple.activity.login_register.RelevanceUserFragment;
import com.likeits.simple.activity.login_register.ThirdLoginFragment;
import com.likeits.simple.base.ContentActivity;
import com.likeits.simple.constants.Constants;

/**
 * Created by admin on 2018/4/19.
 */

public class FrameActivity extends ContentActivity {
    @Override
    protected void switchFragment(Intent intent) {
        int keyFragment = intent.getIntExtra(BaseInterface.KEY_FRAGMENT, 0);
        switch (keyFragment) {
            case Constants.FRAGMENT_PHONE_LOGIN://手机验证登录
                replaceFragment(PhoneLoginFragment.newInstance());
                break;
            case Constants.FRAGMENT_FORGET_PWD://忘记密码
                replaceFragment(ForgetPwdFragment.newInstance());
                break;
            case Constants.FRAGMENT_LOGIN://
                //replaceFragment(RecyclerFragment.newInstance());
                break;
            case Constants.FRAGMENT_REGISTER://注册
                replaceFragment(RegisterFragment.newInstance());
                break;
            case Constants.FRAGMENT_Third_LOGIN://第三方的登录
                replaceFragment(ThirdLoginFragment.newInstance());
                break;
            case Constants.FRAGMENT_RELEVANCE_USER://关联用户
                replaceFragment(RelevanceUserFragment.newInstance());
                break;
            case Constants.FRAGMENT_REGISTER_PROTOCOL://注册协议
                replaceFragment(RegisterProtocolFragment.newInstance());
                break;
//            case Constants.FRAGMENT_PEOPLE_STATISTICS://报表统计
//                replaceFragment(PeopleStatisticsFragment.newInstance());
//                break;
//            case Constants.FRAGMENT_PEOPLE_GOODS_ATTENTION://商品关注
//                replaceFragment(GoodsAttentionFragment.newInstance());
//                break;
//            case Constants.FRAGMENT_PEOPLE_SHOP_ATTENTION://店铺关注
//                replaceFragment(ShopAttentionFragment.newInstance());
//                break;
//            case Constants.FRAGMENT_PEOPLE_BRAND_ATTENTION://品牌关注
//                replaceFragment(BrandAttentionFragment.newInstance());
//                break;
//            case Constants.FRAGMENT_PEOPLE_FOOTPRINT://我的足迹
//                replaceFragment(FootprintFragment.newInstance());
//                break;
//            case Constants.FRAGMENT_PEOPLE_CHANGE://我的零钱
//                replaceFragment(ChangeFragment.newInstance());
//                break;
////            case Constants.FRAGMENT_PEOPLE_COUPON://我的优惠卷
////                replaceFragment(MyCouponActivity.newInstance());
////                break;
//            case Constants.FRAGMENT_PEOPLE_INTEGRAL://我的积分
//                replaceFragment(IntegralFragment.newInstance());
//                break;
//            case Constants.FRAGMENT_HOME_DENTISTRY://牙科商城
//                replaceFragment(DentistryShopFragment.newInstance());
//                break;
//            case Constants.FRAGMENT_HOME_Medical://医用耗材
//                replaceFragment(MedicalShopFragment.newInstance());
//                break;
//            case Constants.FRAGMENT_HOME_INFECTION_CONTROL://感控产品
//                replaceFragment(InfectionControlFragment.newInstance());
//                break;
        }
    }
}