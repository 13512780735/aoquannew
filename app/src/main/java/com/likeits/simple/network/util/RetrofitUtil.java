package com.likeits.simple.network.util;


import com.likeits.simple.adapter.sort.bean.CartDeleteModel;
import com.likeits.simple.network.ApiService;
import com.likeits.simple.network.model.GoodCategory.CategoryListItemsModel;
import com.likeits.simple.network.model.GoodCommentmodel;
import com.likeits.simple.network.consts.Consts;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.EmptyEntity;
import com.likeits.simple.network.model.GoodCategory.GoodsCategoryModel;
import com.likeits.simple.network.model.Indent.CommentShopModel;
import com.likeits.simple.network.model.Indent.ExpressModel;
import com.likeits.simple.network.model.Indent.GoodsRefundmodel;
import com.likeits.simple.network.model.Indent.IndentDetailModel;
import com.likeits.simple.network.model.Indent.IndentListModel;
import com.likeits.simple.network.model.Indent.OrderCreateModel;
import com.likeits.simple.network.model.LoginRegisterModel;
import com.likeits.simple.network.model.cart.CartListModel;
import com.likeits.simple.network.model.gooddetails.AddressModel;
import com.likeits.simple.network.model.gooddetails.CaculateModel;
import com.likeits.simple.network.model.gooddetails.PayIndentModel;
import com.likeits.simple.network.model.gooddetails.ProvincesModel;
import com.likeits.simple.network.model.home.MainHomePagerModel;
import com.likeits.simple.network.model.main.MainNavigationModel;
import com.likeits.simple.network.model.member.AvatarModel;
import com.likeits.simple.network.model.member.CouponCenterModel;
import com.likeits.simple.network.model.member.CouponListModel;
import com.likeits.simple.network.model.member.UserInfoModel;
import com.likeits.simple.network.model.pay.BalacePayModel;
import com.likeits.simple.network.model.pay.PayModel;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author nanchen
 * @fileName RetrofitRxDemoo
 * @packageName com.nanchen.retrofitrxdemoo.util
 * @date 2016/12/12  10:38
 */

public class RetrofitUtil {

    public static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;
    private ApiService mApiService;

    private static RetrofitUtil mInstance;

    /**
     * 私有构造方法
     */
    private RetrofitUtil() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .baseUrl(Consts.APP_HOST)
                .build();
        mApiService = mRetrofit.create(ApiService.class);
    }

    public static RetrofitUtil getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                mInstance = new RetrofitUtil();
            }
        }
        return mInstance;
    }

    /**
     * 首页导航
     *
     * @param subscriber
     */
    public void getMainNavigation(String ukey, Subscriber<BaseResponse<MainNavigationModel>> subscriber) {
        mApiService.Mian_Navigation(ukey)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 首页Home
     *
     * @param subscriber
     */
    public void getMainHome(String ukey, Subscriber<BaseResponse<MainHomePagerModel>> subscriber) {
        mApiService.Mian_Home(ukey)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用于用户登录
     *
     * @param subscriber
     */
    public void getUsersLogin(String mobile, String pwd, Subscriber<BaseResponse<LoginRegisterModel>> subscriber) {
        mApiService.UserLogin(mobile, pwd)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用于用户注册
     *
     * @param subscriber
     */
    public void getUsersRegister(String mobile, String pwd, int verifycode, Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.UserRegister(mobile, pwd, verifycode)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 短信接口
     *
     * @param subscriber
     */
    public void getVerifycode(String mobile, String temp, Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.GetVerifycode(mobile, temp)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用户修改密码与找回密码
     *
     * @param subscriber
     */
    public void UserChangePwd(String mobile, String pwd, String verifycode, Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.UserChangePwd(mobile, pwd, verifycode)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 商品分類
     *
     * @param subscriber
     */
    public void GoodsCategory(String openid, Subscriber<BaseResponse<GoodsCategoryModel>> subscriber) {
        mApiService.GoodsCategory(openid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 商品分類
     *
     * @param subscriber
     */
    public void GoodsFiltrate(String openid, Subscriber<BaseResponse<GoodsCategoryModel>> subscriber) {
        mApiService.GoodsFiltrate(openid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /**
     * 商品列表
     *
     * @param openid
     * @param subscriber
     */

    public void CategoryList(String openid, String keyword, String attribute, String merchid, String order, String by, String pricemin, String pricemax, String pageNum, String cid,
                             Subscriber<BaseResponse<CategoryListItemsModel>> subscriber) {
        mApiService.CategoryList(openid, keyword, attribute, merchid, order, by, pricemin, pricemax, pageNum ,cid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    /**
     * 我的订单
     *
     * @param openid
     * @param status
     * @param subscriber
     */
    public void Orderform(String openid, String status, String pageNum,
                          Subscriber<BaseResponse<IndentListModel>> subscriber) {
        mApiService.orderform(openid, status, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 订单详情
     *
     * @param openid
     * @param subscriber
     */
    public void orderDetail(String openid, String id,
                            Subscriber<BaseResponse<IndentDetailModel>> subscriber) {
        mApiService.orderDetail(openid, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 取消订单
     *
     * @param openid
     * @param subscriber
     */
    public void orderCancel(String openid, String id, String closereason,
                            Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.orderCancel(openid, id, closereason)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 删除或恢复订单	0(恢复订单);1(删除订单)
     *
     * @param openid
     * @param subscriber
     */
    public void orderDelete(String openid, String id, String userdeleted,
                            Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.orderDelete(openid, id, userdeleted)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 确认收货
     *
     * @param openid
     * @param subscriber
     */
    public void orderFinish(String openid, String id,
                            Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.orderFinish(openid, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 物流信息
     *
     * @param openid
     * @param subscriber
     */
    public void expressInfo(String openid, String id, String sendtype, String bundle, String cycelid,
                            Subscriber<BaseResponse<ExpressModel>> subscriber) {
        mApiService.expressInfo(openid, id, sendtype, bundle, cycelid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 订单评价商品
     *
     * @param openid
     * @param subscriber
     */
    public void commentContent(String openid, String orderid, String goodsid,
                               Subscriber<BaseResponse<CommentShopModel>> subscriber) {
        mApiService.commentContent(openid, orderid, goodsid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 物流信息
     *
     * @param openid
     * @param subscriber
     */
    public void commentSubmit(String openid, String orderid, String goodsid, String level, String content, String images,
                              Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.commentSubmit(openid, orderid, goodsid, level, content, images)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 獲取地址列表
     *
     * @param openid
     * @param subscriber
     */
    public void getAddressList(String openid,
                               Subscriber<BaseResponse<AddressModel>> subscriber) {
        mApiService.getAddressList(openid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 设置默认地址
     *
     * @param openid
     * @param id
     * @param subscriber
     */
    public void setDefaultAddress(String openid, String id,
                                  Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.setDefaultAddress(openid, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取省市区
     *
     * @param openid
     * @param subscriber
     */
    public void getProvinces(String openid, Subscriber<BaseResponse<ProvincesModel>> subscriber) {
        mApiService.getProvinces(openid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 删除地址
     *
     * @param openid
     * @param id
     * @param subscriber
     */
    public void deleteAddress(String openid, String id,
                              Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.deleteAddress(openid, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 添加编辑地址
     *
     * @param openid
     * @param id
     * @param address
     * @param realname
     * @param mobile
     * @param province
     * @param city
     * @param area
     * @param subscriber
     */
    public void setAddress(String openid, String id, String address, String realname, String mobile, String province, String city, String area,
                           Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.setAddress(openid, id, address, realname, mobile, province, city, area)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 确认订单
     *
     * @param openid
     * @param id
     * @param optionid
     * @param total
     * @param subscriber
     */
    public void OrderCreate(String openid, String id, String optionid, String total, String giftid, String packageid, String liveid,
                            Subscriber<BaseResponse<OrderCreateModel>> subscriber) {
        mApiService.OrderCreate(openid, id, optionid, total, giftid, packageid, liveid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 确认订单数量选择
     *
     * @param openid
     * @param goodsid
     * @param optionid
     * @param total
     * @param addressid
     * @param subscriber
     */
    public void getCaculate(String openid, String goodsid, String optionid, String total, String addressid,
                            Subscriber<BaseResponse<CaculateModel>> subscriber) {
        mApiService.getCaculate(openid, goodsid, optionid, total, addressid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 生成订单（商品详情）
     *
     * @param openid
     * @param goodsid
     * @param optionid
     * @param total
     * @param addressid
     * @param subscriber
     */
    public void submitorder(String openid, String goodsid, String optionid, String total, String addressid, String giftid,
                            Subscriber<BaseResponse<PayIndentModel>> subscriber) {
        mApiService.submitorder(openid, goodsid, optionid, total, addressid, giftid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 购物车确认订单
     *
     * @param openid
     * @param cartids
     * @param cartnum
     * @param subscriber
     */
    public void CreateCartOrder(String openid, String cartids, String cartnum, String giftid, String packageid, String liveid,
                                Subscriber<BaseResponse<OrderCreateModel>> subscriber) {
        mApiService.CreateCartOrder(openid, cartids, cartnum, giftid, packageid, liveid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 添加购物车
     *
     * @param openid
     * @param id
     * @param total
     * @param optionid
     * @param subscriber
     */
    public void addcart(String openid, String id, String total, String optionid,
                        Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.addcart(openid, id, total, optionid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 商品收藏
     *
     * @param openid
     * @param id
     * @param isfavorite
     * @param subscriber
     */
    public void shopFavorite(String openid, String id, String isfavorite,
                             Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.shopFavorite(openid, id, isfavorite)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 购物车列表
     *
     * @param openid
     * @param subscriber
     */
    public void getCartList(String openid,
                            Subscriber<BaseResponse<CartListModel>> subscriber) {
        mApiService.getCartList(openid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 删除购物车
     *
     * @param openid
     * @param ids
     * @param subscriber
     */
    public void removeCart(String openid, String ids,
                           Subscriber<BaseResponse<CartDeleteModel>> subscriber) {
        mApiService.removeCart(openid, ids)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 购物车生成订单
     *
     * @param openid
     * @param cartids
     * @param cartoption
     * @param carttotal
     * @param addressid
     * @param subscriber
     */
    public void CreateCartSubmitorder(String openid, String cartids, String cartoption, String carttotal, String addressid, String fromcart, String giftid,
                                      Subscriber<BaseResponse<PayIndentModel>> subscriber) {
        mApiService.CreateCartSubmitorder(openid, cartids, cartoption, carttotal, addressid, fromcart, giftid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 评价列表
     *
     * @param id
     * @param subscriber
     */
    public void GetCommentList(String id, String level,
                               Subscriber<BaseResponse<GoodCommentmodel>> subscriber) {
        mApiService.GetCommentList(id, level)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 我的优惠券列表
     *
     * @param subscriber
     */
    public void GetCouponList(String openid, String cate, String page,
                              Subscriber<BaseResponse<CouponListModel>> subscriber) {
        mApiService.GetCouponList(openid, cate, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 优惠券列表
     *
     * @param subscriber
     */
    public void GetCouponCenterList(String openid, String cateid, String page,
                                    Subscriber<BaseResponse<CouponCenterModel>> subscriber) {
        mApiService.GetCouponCenterList(openid, cateid, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 会员资料
     *
     * @param subscriber
     */
    public void GetUserInfo(String openid,
                            Subscriber<BaseResponse<UserInfoModel>> subscriber) {
        mApiService.GetUserInfo(openid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 上传头像
     *
     * @param subscriber
     */
    public void UpAvatar(String openid, String imga,
                         Subscriber<BaseResponse<AvatarModel>> subscriber) {
        mApiService.UpAvatar(openid, imga)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 编辑会员资料
     */
    public void UpUserInfo(String openid, String nickname, String avatar, String username, String gender, String datetime, String province, String city, String area,
                           Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.UpUserInfo(openid, nickname, avatar, username, gender, datetime, province, city, area)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 修改手机
     */
    public void EditPhone(String openid, String mobile, String password,
                          Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.EditPhone(openid, mobile, password)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 收银台接口
     */
    public void PayInto(String openid, String id,
                        Subscriber<BaseResponse<PayModel>> subscriber) {
        mApiService.PayInto(openid, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 商品售后申请接口
     */
    public void goodsRefund(String openid, String goodsid, String id, String optionid, String type, String grefundid,
                            Subscriber<BaseResponse<GoodsRefundmodel>> subscriber) {
        mApiService.goodsRefund(openid, goodsid, id, optionid, type, grefundid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 余额支付
     */
    public void BalancePay(String openid, String id, String type,
                           Subscriber<BaseResponse<BalacePayModel>> subscriber) {
        mApiService.BalancePay(openid, id, type)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    private <T> void toSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
