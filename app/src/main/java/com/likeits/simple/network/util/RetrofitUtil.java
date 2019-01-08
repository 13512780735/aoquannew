package com.likeits.simple.network.util;


import com.likeits.simple.adapter.sort.bean.CartDeleteModel;
import com.likeits.simple.adapter.sort.bean.CategoryListItemsModel;
import com.likeits.simple.network.ApiService;
import com.likeits.simple.network.GoodCommentmodel;
import com.likeits.simple.network.consts.Consts;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.EmptyEntity;
import com.likeits.simple.network.model.GoodCategory.GoodsCategoryModel;
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

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
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
     * 商品列表
     *
     * @param openid
     * @param signature
     * @param newtime
     * @param random
     * @param subscriber
     */

//    public void CategoryList(String openid, String cid, String signature, String newtime, String random, String page, String isnew, String ishot, String isrecommand, String isdiscount, String istime, String issendfree, String keyword,
//                             Subscriber<BaseResponse<CategoryListItemsModel>> subscriber) {
//        mApiService.CategoryList(openid, cid, signature, newtime, random, page, isnew, ishot, isrecommand, isdiscount, istime, issendfree, keyword)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
//    }


    /**
     * 我的订单
     *
     * @param openid
     * @param status
     * @param page
     * @param subscriber
     */
    public void Orderform(String openid, String status, String page,
                          Subscriber<BaseResponse<IndentListModel>> subscriber) {
        mApiService.orderform(openid, status, page)
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
    public void OrderCreate(String openid, String id, String optionid, String total,
                            Subscriber<BaseResponse<OrderCreateModel>> subscriber) {
        mApiService.OrderCreate(openid, id, optionid, total)
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
    public void submitorder(String openid, String goodsid, String optionid, String total, String addressid,
                            Subscriber<BaseResponse<PayIndentModel>> subscriber) {
        mApiService.submitorder(openid, goodsid, optionid, total, addressid)
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
    public void CreateCartOrder(String openid, String cartids, String cartnum,
                                Subscriber<BaseResponse<OrderCreateModel>> subscriber) {
        mApiService.CreateCartOrder(openid, cartids, cartnum)
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
    public void CreateCartSubmitorder(String openid, String cartids, String cartoption, String carttotal, String addressid,
                                      Subscriber<BaseResponse<PayIndentModel>> subscriber) {
        mApiService.CreateCartSubmitorder(openid, cartids, cartoption, carttotal, addressid)
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
    public void GetCommentList(String id,String level,
                               Subscriber<BaseResponse<GoodCommentmodel>> subscriber) {
        mApiService.GetCommentList(id,level)
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
