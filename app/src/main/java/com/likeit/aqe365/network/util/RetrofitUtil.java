package com.likeit.aqe365.network.util;


import com.likeit.aqe365.adapter.sort.bean.CartDeleteModel;
import com.likeit.aqe365.network.ApiService;
import com.likeit.aqe365.network.model.CaseEntity;
import com.likeit.aqe365.network.model.CaseIdEntity;
import com.likeit.aqe365.network.model.DiyTabModel;
import com.likeit.aqe365.network.model.GoodCategory.CategoryListItemsModel;
import com.likeit.aqe365.network.model.GoodCommentmodel;
import com.likeit.aqe365.network.consts.Consts;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.GoodCategory.GoodsCategoryModel;
import com.likeit.aqe365.network.model.Indent.CommentShopModel;
import com.likeit.aqe365.network.model.Indent.ExpressModel;
import com.likeit.aqe365.network.model.Indent.GoodsRefundmodel;
import com.likeit.aqe365.network.model.Indent.IndentDetailModel;
import com.likeit.aqe365.network.model.Indent.IndentListModel;
import com.likeit.aqe365.network.model.Indent.OrderCreateModel;
import com.likeit.aqe365.network.model.LoginRegisterModel;
import com.likeit.aqe365.network.model.cart01.CartListModel;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.network.model.find.ConcernsListModel;
import com.likeit.aqe365.network.model.find.DiaryListModel;
import com.likeit.aqe365.network.model.find.DiarydetailsModel;
import com.likeit.aqe365.network.model.find.FollowlistModel;
import com.likeit.aqe365.network.model.find.FoolowMoodListModel;
import com.likeit.aqe365.network.model.find.HospitalListModel;
import com.likeit.aqe365.network.model.find.HospitalandServeModel;
import com.likeit.aqe365.network.model.find.JournalDetailsModel;
import com.likeit.aqe365.network.model.find.JournalModel;
import com.likeit.aqe365.network.model.find.MoodDetailsModel;
import com.likeit.aqe365.network.model.find.MoodListModel;
import com.likeit.aqe365.network.model.find.MoreDiaryModel;
import com.likeit.aqe365.network.model.find.MyDiaryListModel;
import com.likeit.aqe365.network.model.find.PostDetailsModel;
import com.likeit.aqe365.network.model.find.PostListModel;
import com.likeit.aqe365.network.model.find.UserListModel;
import com.likeit.aqe365.network.model.gooddetails.AddressModel;
import com.likeit.aqe365.network.model.gooddetails.CaculateModel;
import com.likeit.aqe365.network.model.gooddetails.PayIndentModel;
import com.likeit.aqe365.network.model.gooddetails.ProvincesModel;
import com.likeit.aqe365.network.model.home.MainHomePagerModel;
import com.likeit.aqe365.network.model.main.MainNavigationModel;
import com.likeit.aqe365.network.model.member.AvatarModel;
import com.likeit.aqe365.network.model.member.CouponCenterModel;
import com.likeit.aqe365.network.model.member.CouponListModel;
import com.likeit.aqe365.network.model.member.GetUserInfoModel;
import com.likeit.aqe365.network.model.member.MessageListModel;
import com.likeit.aqe365.network.model.member.MyUserModel;
import com.likeit.aqe365.network.model.member.NoticeListModel;
import com.likeit.aqe365.network.model.member.PostUserModel;
import com.likeit.aqe365.network.model.member.UserInfoModel;
import com.likeit.aqe365.network.model.pay.BalacePayModel;
import com.likeit.aqe365.network.model.pay.PayModel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
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

//    /**
//     * 商品分類
//     *
//     * @param subscriber
//     */
//    public void GoodsFiltrate(String openid, Subscriber<BaseResponse<GoodsCategoryModel>> subscriber) {
//        mApiService.GoodsFiltrate(openid)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
//    }


    /**
     * 商品列表
     *
     * @param openid
     * @param subscriber
     */

    public void CategoryList(String openid, String keyword, String attribute, String merchid, String order, String by, String pricemin, String pricemax, String pageNum, String cid,
                             Subscriber<BaseResponse<CategoryListItemsModel>> subscriber) {
        mApiService.CategoryList(openid, keyword, attribute, merchid, order, by, pricemin, pricemax, pageNum, cid)
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
    public void expressInfo(String openid, String id, String sendtype, String bundle, String cycelid, String express, String expresssn, String expresscom,
                            Subscriber<BaseResponse<ExpressModel>> subscriber) {
        mApiService.expressInfo(openid, id, sendtype, bundle, cycelid, express, expresssn, expresscom)
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
     * 商品售后申请提交接口
     *
     * @return
     */
    public void goodsRefundSubmit(String openid, String orderid, String goodsid, String rtype, String optionid, String merchid, String applyprice, String reason, String goods_status, String images, String content,
                                  Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.goodsRefundSubmit(openid, orderid, goodsid, rtype, optionid, merchid, applyprice, reason, goods_status, images, content)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 确认收到售后物品
     */
    public void goodsRefundReceive(String openid, String goodsid, String id, String optionid, String type, String grefundid,
                                   Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.goodsRefundReceive(openid, goodsid, id, optionid, type, grefundid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 取消售后申请接口
     */
    public void goodsRefundCancel(String openid, String goodsid, String id, String grefundid,
                                  Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.goodsRefundCancel(openid, goodsid, id, grefundid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 填写快递单号提交接口
     */
    public void goodsRefundExpress(String openid, String goodsid, String id, String optionid, String type, String grefundid, String express, String expresssn, String expresscom,
                                   Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.goodsRefundExpress(openid, goodsid, id, optionid, type, grefundid, express, expresssn, expresscom)
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

    /**
     * 自定义选项卡接口
     */
    public void getDiyTab(String openid,
                          Subscriber<BaseResponse<DiyTabModel>> subscriber) {
        mApiService.getDiyTab(openid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 推荐列表
     */
    public void Postlist(String openid, String pageNum, String keyword, String lat, String lng, String type, String bid, String memberid,
                         Subscriber<BaseResponse<PostListModel>> subscriber) {
        mApiService.Postlist(openid, pageNum, keyword, lat, lng, type, bid, memberid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 话题列表
     *
     * @return
     */
    public void GetBoardlist(String openid, String keyword, String type, String pageNum,
                             Subscriber<BaseResponse<BoardListModel>> subscriber) {
        mApiService.GetBoardlist(openid, keyword, type, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 关注话题列表
     *
     * @return
     */
    public void GetFollowlist(String openid, String keyword, String pageNum,
                              Subscriber<BaseResponse<FollowlistModel>> subscriber) {
        mApiService.GetFollowlist(openid, keyword, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 关注话题
     *
     * @return
     */
    public void GetFollow(String openid, String bid,
                          Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.GetFollow(openid, bid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用户
     *
     * @return
     */
    public void GetUser(String openid, String keyword, String lat, String lng, String pageNum,
                        Subscriber<BaseResponse<UserListModel>> subscriber) {
        mApiService.GetUser(openid, keyword, lat, lng, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 关注用户
     *
     * @return
     */
    public void Followmember(String openid, String memberid,
                             Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.Followmember(openid, memberid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记列表
     *
     * @return
     */
    public void Journallist(String openid, String memberid, String type, String pageNum,
                            Subscriber<BaseResponse<DiaryListModel>> subscriber) {
        mApiService.Journallist(openid, memberid, type, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用户日记列表
     *
     * @return
     */
    public void diarylist(String openid, String memberid, String type, String pageNum,
                          Subscriber<BaseResponse<DiaryListModel>> subscriber) {
        mApiService.diarylist(openid, memberid, type, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用户帖子列表
     *
     * @return
     */
    public void PostserList(String openid, String memberid, String pageNum,
                            Subscriber<BaseResponse<PostUserModel>> subscriber) {
        mApiService.PostserList(openid, memberid, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 我的日记本
     *
     * @return
     */
    public void MyDiary(String openid, String pageNum,
                        Subscriber<BaseResponse<MyDiaryListModel>> subscriber) {
        mApiService.MyDiary(openid, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 创建日记本
     *
     * @return
     */
    public void Createbook(String openid, String title, String hospital, String category, String service, String addtime, String type,
                           Subscriber<BaseResponse<CaseIdEntity>> subscriber) {
        mApiService.Createbook(openid, title, hospital, category, service, addtime, type)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记编辑
     *
     * @return
     */
    public void Editdiary(String openid, String type, String keyword, String city, String pageNum,
                          Subscriber<BaseResponse<HospitalandServeModel>> subscriber) {
        mApiService.Editdiary(openid, type, keyword, city, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 帖子详情
     *
     * @return
     */
    public void postDetails(String openid, String id, String pageNum,
                            Subscriber<BaseResponse<PostDetailsModel>> subscriber) {
        mApiService.postDetails(openid, id, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 帖子点赞
     *
     * @return
     */
    public void postlike(String openid, String bid, String pid,
                         Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.postlike(openid, bid, pid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 帖子点赞
     *
     * @return
     */
    public void collectpost(String openid, String id,
                            Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.collectpost(openid, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 帖子回复
     *
     * @return
     */
    public void postReply(String openid, String pid, String bid, String rpid, String mpid, String content,
                          Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.postReply(openid, pid, bid, rpid, mpid, content)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记本详情
     *
     * @return
     */
    public void diarydetails(String openid, String memberid, String diaryid, String pageNum,
                             Subscriber<BaseResponse<DiarydetailsModel>> subscriber) {
        mApiService.diarydetails(openid, memberid, diaryid, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记本收藏
     *
     * @return
     */
    public void diaryCollect(String openid, String diaryid,
                             Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.diaryCollect(openid, diaryid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 关注日记
     *
     * @return
     */
    public void diaryFollow(String openid, String id,
                            Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.diaryFollow(openid, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记/日记本更多评论
     *
     * @return
     */
    public void diaryComment(String openid, String type, String diaryid, String id, String pageNum,
                             Subscriber<BaseResponse<MoreDiaryModel>> subscriber) {
        mApiService.diaryComment(openid, type, diaryid, id, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记本回复
     *
     * @return
     */
    public void diaryReply(String openid, String diaryid, String rdid, String mdid, String content,
                           Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.diaryReply(openid, diaryid, rdid, mdid, content)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记本点赞
     *
     * @return
     */
    public void diarylike(String openid, String diaryid, String commentid,
                          Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.diarylike(openid, diaryid, commentid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记点赞
     *
     * @return
     */
    public void journallike(String openid, String diaryid, String cid,
                            Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.journallike(openid, diaryid, cid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记本详情日记列表
     *
     * @return
     */
    public void detailjournallist(String openid, String memberid, String diaryid, String pageNum,
                                  Subscriber<BaseResponse<JournalModel>> subscriber) {
        mApiService.detailjournallist(openid, memberid, diaryid, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记详情
     *
     * @return
     */
    public void journalDetails(String openid, String id, String pageNum,
                               Subscriber<BaseResponse<JournalDetailsModel>> subscriber) {
        mApiService.journalDetails(openid, id, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 日记回复
     *
     * @return
     */
    public void replyJournal(String openid, String diaryid, String cid, String rcid, String mcid, String content,
                             Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.replyJournal(openid, diaryid, cid, rcid, mcid, content)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 关注日记
     *
     * @return
     */
    public void follow(String openid, String id,
                       Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.follow(openid, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 发布日记
     *
     * @param subscriber
     */
    public void submit(RequestBody openid, RequestBody diaryid, RequestBody lat, RequestBody lng, RequestBody title, RequestBody content, RequestBody recoverytime, RequestBody type, List<MultipartBody.Part> image, List<MultipartBody.Part> file, Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.submit(openid, diaryid, lat, lng, title, content, recoverytime, type, image, file)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 发布心情和帖子用户列表
     *
     * @return
     */
    public void concernslist(String openid,
                             Subscriber<BaseResponse<ConcernsListModel>> subscriber) {
        mApiService.concernslist(openid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     *  images, videos, videoimage,
     *   MultipartBody.Part videos, MultipartBody.Part videoimage,
     */

    /**
     * 发布帖子
     *
     * @param subscriber
     */
    public void postSumit(RequestBody openid, RequestBody lat, RequestBody lng, RequestBody title, RequestBody bids, RequestBody content, List<MultipartBody.Part> images, MultipartBody.Part videos, MultipartBody.Part videoimage, RequestBody hospitalid, RequestBody userid, Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.postSumit(openid, lat, lng, title, bids, content, images, videos, videoimage, hospitalid, userid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 发布心情
     *
     * @param subscriber
     */
    public void moodsubmit(RequestBody openid, RequestBody lat, RequestBody lng, RequestBody bids, RequestBody content, List<MultipartBody.Part> images, MultipartBody.Part videos, MultipartBody.Part videoimage, RequestBody userid, Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.moodsubmit(openid, lat, lng, bids, content, images, videos, videoimage, userid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 心情列表
     *
     * @return
     */
    public void follow(String openid,
                       Subscriber<BaseResponse<FoolowMoodListModel>> subscriber) {
        mApiService.follow(openid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 心情列表
     *
     * @return
     */
    public void moodlist(String openid, String type, String keyword, String pageNum,
                         Subscriber<BaseResponse<MoodListModel>> subscriber) {
        mApiService.moodlist(openid, type, keyword, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 心情详情
     *
     * @return
     */
    public void mooddetails(String openid, String id, String pageNum,
                            Subscriber<BaseResponse<MoodDetailsModel>> subscriber) {
        mApiService.mooddetails(openid, id, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 心情收藏
     *
     * @return
     */
    public void collectmood(String openid, String id,
                            Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.collectmood(openid, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 心情点赞
     *
     * @return
     */
    public void moodlike(String openid, String bid, String pid,
                         Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.moodlike(openid, bid, pid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 心情回复
     *
     * @return
     */
    public void moodreply(String openid, String pid, String bid, String rpid, String mpid, String content,
                          Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.moodreply(openid, pid, bid, rpid, mpid, content)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 医生提问
     *
     * @param subscriber
     */
    public void quiz(RequestBody openid, RequestBody title, RequestBody content, List<MultipartBody.Part> images, Subscriber<BaseResponse<EmptyEntity>> subscriber) {
        mApiService.quiz(openid, title, content, images)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 医院列表
     *
     * @return
     */
    public void hospitalList(String openid, String keyword, String pageNum,
                             Subscriber<BaseResponse<HospitalListModel>> subscriber) {
        mApiService.hospitalList(openid, keyword, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 我的消息
     *
     * @param openid
     * @param type
     * @param pageNum
     * @param subscriber
     */
    public void myMessageList(String openid, String type, String pageNum,
                              Subscriber<BaseResponse<MessageListModel>> subscriber) {
        mApiService.myMessageList(openid, type, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 公告列表
     *
     * @param openid
     * @param pageNum
     * @param subscriber
     */
    public void getNoticelist(String openid, String pageNum,
                              Subscriber<BaseResponse<NoticeListModel>> subscriber) {
        mApiService.getNoticelist(openid, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 添加与搜索话题(心情和帖子)
     *
     * @param openid
     * @param pageNum
     * @param subscriber
     */
    public void postTopiclist(String openid, String keywords, String pageNum,
                              Subscriber<BaseResponse<BoardListModel>> subscriber) {
        mApiService.postTopiclist(openid, keywords, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 根据memberid获取个人信息
     *
     * @param openid
     * @param subscriber
     */
    public void getUserInfo(String openid, String memberid,
                            Subscriber<BaseResponse<GetUserInfoModel>> subscriber) {
        mApiService.getUserInfo(openid, memberid)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用户列表(粉丝)
     *
     * @param openid
     * @param subscriber
     */
    public void getMyUser(String openid, String keywords, String type, String lat, String lng, String pageNum,
                          Subscriber<BaseResponse<MyUserModel>> subscriber) {
        mApiService.getMyUser(openid, keywords, type, lat, lng, pageNum)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 用户帖子和心情列表
     *
     * @param openid
     * @param subscriber
     */
    public void postuser(String openid, String memberid, String type, String pageNum,
                         Subscriber<BaseResponse<PostUserModel>> subscriber) {
        mApiService.postuser(openid, memberid, type, pageNum)
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
