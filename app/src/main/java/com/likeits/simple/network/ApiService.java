package com.likeits.simple.network;

import com.likeits.simple.adapter.sort.bean.CartDeleteModel;
import com.likeits.simple.network.consts.Consts;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.EmptyEntity;
import com.likeits.simple.network.model.GoodCategory.CategoryListItemsModel;
import com.likeits.simple.network.model.GoodCategory.GoodsCategoryModel;
import com.likeits.simple.network.model.GoodCommentmodel;
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

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;


/**
 * Created by admin on 2018/5/11.
 */

public interface ApiService {
    /**
     * 首页数据
     *
     * @param ukey
     * @return
     */
    String Main_Home = Consts.APP_HOST + "nativeapp.shop.get_shopindex";
    /**
     * 商品詳情
     *
     * @param ukey
     * @return
     */
    String Good_Detial = Consts.APP_HOST + "nativeapp.goods.get_detail";
    /**
     * 个人中心
     *
     * @param ukey
     * @return
     */
    String Main_member = Consts.APP_HOST + "nativeapp.member";
    /**
     * 自定义页面
     *
     * @param ukey
     * @return
     */
    String Custom_diyPage = Consts.APP_HOST + "nativeapp.diypage";
    /**
     * 列表筛选
     *
     * @param ukey
     * @return
     */
    String GoodsFiltrate = Consts.APP_HOST + "nativeapp.goods.category.filtrate";

    /**
     * 首页导航
     *
     * @param ukey
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.shop.get_tabtar")
    Observable<BaseResponse<MainNavigationModel>> Mian_Navigation(@Field("ukey") String ukey

    );


    /**
     * 首页数据
     *
     * @param ukey
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.shop.get_shopindex")
    Observable<BaseResponse<MainHomePagerModel>> Mian_Home(@Field("ukey") String ukey

    );

    /**
     * 用户登录接口
     *
     * @param mobile
     * @param pwd
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.account.login")
    Observable<BaseResponse<LoginRegisterModel>> UserLogin(@Field("mobile") String mobile,
                                                           @Field("pwd") String pwd
    );

    /**
     * 用户注册接口
     *
     * @param mobile
     * @param pwd
     * @param verifycode
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.account.register")
    Observable<BaseResponse<EmptyEntity>> UserRegister(@Field("mobile") String mobile,
                                                       @Field("pwd") String pwd,
                                                       @Field("verifycode") int verifycode
    );

    /**
     * 短信接口
     * (sms_forget:找回密码) (sms_reg:注册用户)
     *
     * @param mobile
     * @param temp
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.account.verifycode")
    Observable<BaseResponse<EmptyEntity>> GetVerifycode(@Field("mobile") String mobile,
                                                        @Field("temp") String temp
    );

    /**
     * 用户修改密码与找回密码
     *
     * @param mobile
     * @param pwd
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.account.forget")
    Observable<BaseResponse<EmptyEntity>> UserChangePwd(@Field("mobile") String mobile,
                                                        @Field("pwd") String pwd,
                                                        @Field("verifycode") String verifycode
    );

    /**
     * 商品分類
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.goods.category.category")
    Observable<BaseResponse<GoodsCategoryModel>> GoodsCategory(@Field("ukey") String ukey
    );

//    /**
//     * 列表筛选
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("nativeapp.goods.category.filtrate")
//    Observable<BaseResponse<GoodsCategoryModel>> GoodsFiltrate(@Field("ukey") String ukey
//    );

    /**
     * 商品列表
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.goods.category.categorylist")
    Observable<BaseResponse<CategoryListItemsModel>> CategoryList(@Field("openid") String openid,
                                                                  @Field("keywords") String keywords,
                                                                  @Field("attribute") String attribute,
                                                                  @Field("merchid") String merchid,
                                                                  @Field("order") String order,
                                                                  @Field("by") String by,
                                                                  @Field("pricemin") String pricemin,
                                                                  @Field("pricemax") String pricemax,
                                                                  @Field("pageNum") String pageNum,
                                                                  @Field("cid") String cid
    );

    /**
     * 我的订单
     *
     * @param openid
     * @param status
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.orderList")
    Observable<BaseResponse<IndentListModel>> orderform(@Field("openid") String openid,
                                                        @Field("status") String status,
                                                        @Field("pageNum") String pageNum);

    /**
     * 订单详情
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.detail")
    Observable<BaseResponse<IndentDetailModel>> orderDetail(@Field("openid") String openid,
                                                            @Field("id") String id
    );

    /**
     * 取消订单
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.op.cancel")
    Observable<BaseResponse<EmptyEntity>> orderCancel(@Field("openid") String openid,
                                                      @Field("id") String id,
                                                      @Field("closereason") String closereason

    );

    /**
     * 删除或恢复订单	0(恢复订单);1(删除订单)
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.op.delete")
    Observable<BaseResponse<EmptyEntity>> orderDelete(@Field("openid") String openid,
                                                      @Field("id") String id,
                                                      @Field("userdeleted") String userdeleted
    );

    /**
     * 确认收货
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.op.finish")
    Observable<BaseResponse<EmptyEntity>> orderFinish(@Field("openid") String openid,
                                                      @Field("id") String id
    );

    /**
     * 物流信息
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.express")
    Observable<BaseResponse<ExpressModel>> expressInfo(@Field("openid") String openid,
                                                       @Field("id") String id,
                                                       @Field("sendtype") String sendtype,
                                                       @Field("bundle") String bundle,
                                                       @Field("cycelid") String cycelid
    );

    /**
     * 订单评价商品
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.comment.comment")
    Observable<BaseResponse<CommentShopModel>> commentContent(@Field("openid") String openid,
                                                              @Field("orderid") String orderid,
                                                              @Field("goodsid") String goodsid
    );

    /**
     * 提交评价
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.comment.commentSubmit")
    Observable<BaseResponse<EmptyEntity>> commentSubmit(@Field("openid") String openid,
                                                        @Field("orderid") String orderid,
                                                        @Field("goodsid") String goodsid,
                                                        @Field("level") String level,
                                                        @Field("content") String content,
                                                        @Field("images") String images
    );

    /**
     * 获取地址列表
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.address.get_list")
    Observable<BaseResponse<AddressModel>> getAddressList(@Field("openid") String openid
    );

    /**
     * 设置默认地址
     *
     * @param openid
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.address.set_default")
    Observable<BaseResponse<EmptyEntity>> setDefaultAddress(@Field("openid") String openid,
                                                            @Field("id") String id
    );

    /**
     * 获取省市区
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.address.getprovinces")
    Observable<BaseResponse<ProvincesModel>> getProvinces(@Field("openid") String openid
    );

    /**
     * 删除地址
     *
     * @param openid
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.address.delete")
    Observable<BaseResponse<EmptyEntity>> deleteAddress(@Field("openid") String openid,
                                                        @Field("id") String id
    );

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
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.address.submit")
    Observable<BaseResponse<EmptyEntity>> setAddress(@Field("openid") String openid,
                                                     @Field("id") String id,
                                                     @Field("address") String address,
                                                     @Field("realname") String realname,
                                                     @Field("mobile") String mobile,
                                                     @Field("province") String province,
                                                     @Field("city") String city,
                                                     @Field("area") String area);

    /**
     * 商品详情确认订单
     *
     * @param openid
     * @param id
     * @param optionid
     * @param total
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.create.orderTrue")
    Observable<BaseResponse<OrderCreateModel>> OrderCreate(@Field("openid") String openid,
                                                           @Field("id") String id,
                                                           @Field("optionid") String optionid,
                                                           @Field("total") String total,
                                                           @Field("giftid") String giftid,
                                                           @Field("packageid") String packageid,
                                                           @Field("liveid") String liveid
    );

    /**
     * 确认订单数量选择
     *
     * @param openid
     * @param goodsid
     * @param optionid
     * @param total
     * @param addressid
     * @return
     */


    @FormUrlEncoded
    @POST("nativeapp.order.create.getcaculate")
    Observable<BaseResponse<CaculateModel>> getCaculate(@Field("openid") String openid,
                                                        @Field("goodsid") String goodsid,
                                                        @Field("optionid") String optionid,
                                                        @Field("total") String total,
                                                        @Field("addressid") String addressid
    );

    /**
     * 生成订单（商品详情）
     *
     * @param openid
     * @param goodsid
     * @param optionid
     * @param total
     * @param addressid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.create.submitorder")
    Observable<BaseResponse<PayIndentModel>> submitorder(@Field("openid") String openid,
                                                         @Field("goodsid") String goodsid,
                                                         @Field("optionid") String optionid,
                                                         @Field("total") String total,
                                                         @Field("addressid") String addressid,
                                                         @Field("giftid") String giftid
    );

    /**
     * 添加购物车
     *
     * @param openid
     * @param id
     * @param total
     * @param optionid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.cart.add")
    Observable<BaseResponse<EmptyEntity>> addcart(@Field("openid") String openid,
                                                  @Field("id") String id,
                                                  @Field("total") String total,
                                                  @Field("optionid") String optionid

    );

    /**
     * 商品收藏
     *
     * @param openid
     * @param id
     * @param isfavorite
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.favorite.toggle")
    Observable<BaseResponse<EmptyEntity>> shopFavorite(@Field("openid") String openid,
                                                       @Field("id") String id,
                                                       @Field("isfavorite") String isfavorite

    );

    /**
     * 购物车列表
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.cart.get_cart")
    Observable<BaseResponse<CartListModel>> getCartList(@Field("openid") String openid

    );

    /**
     * 删除购物车
     *
     * @param openid
     * @param ids
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.cart.remove")
    Observable<BaseResponse<CartDeleteModel>> removeCart(@Field("openid") String openid,
                                                         @Field("ids") String ids

    );

    /**
     * 购物车确认订单
     *
     * @param openid
     * @param cartids
     * @param cartnum
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.create.orderTrue")
    Observable<BaseResponse<OrderCreateModel>> CreateCartOrder(@Field("openid") String openid,
                                                               @Field("cartids") String cartids,
                                                               @Field("cartnum") String cartnum,
                                                               @Field("giftid") String giftid,
                                                               @Field("packageid") String packageid,
                                                               @Field("liveid") String liveid

    );

    /**
     * 购物车生成订单
     *
     * @param openid
     * @param cartids
     * @param cartoption
     * @param carttotal
     * @param addressid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.create.submitorder")
    Observable<BaseResponse<PayIndentModel>> CreateCartSubmitorder(@Field("openid") String openid,
                                                                   @Field("cartid") String cartids,
                                                                   @Field("cartoption") String cartoption,
                                                                   @Field("carttotal") String carttotal,
                                                                   @Field("addressid") String addressid,
                                                                   @Field("fromcart") String fromcart,
                                                                   @Field("giftid") String giftid

    );

    /**
     * 评价列表
     *
     * @param id
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.goods.get_comment_list")
    Observable<BaseResponse<GoodCommentmodel>> GetCommentList(@Field("id") String id, @Field("level") String level

    );

    /**
     * 我的优惠券列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.sale.coupon.my.getlist")
    Observable<BaseResponse<CouponListModel>> GetCouponList(@Field("openid") String openid, @Field("cate") String cate, @Field("page") String page

    );

    /**
     * 优惠券列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.sale.coupon.getlist")
    Observable<BaseResponse<CouponCenterModel>> GetCouponCenterList(@Field("openid") String openid, @Field("cateid") String cateid, @Field("page") String page

    );

    /**
     * 会员资料
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.info")
    Observable<BaseResponse<UserInfoModel>> GetUserInfo(@Field("openid") String openid

    );

    /**
     * 上传头像
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.info.upimage")
    Observable<BaseResponse<AvatarModel>> UpAvatar(@Field("openid") String openid, @Field("imga") String imga

    );

    /**
     * 编辑会员资料
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.info.submit")
    Observable<BaseResponse<EmptyEntity>> UpUserInfo(@Field("openid") String openid,
                                                     @Field("nickname") String nickname,
                                                     @Field("avatar") String avatar,
                                                     @Field("username") String username,
                                                     @Field("gender") String gender,
                                                     @Field("datetime") String datetime,
                                                     @Field("province") String province,
                                                     @Field("city") String city,
                                                     @Field("area") String area

    );

    /**
     * 修改手机
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.bind.submit")
    Observable<BaseResponse<EmptyEntity>> EditPhone(@Field("openid") String openid,
                                                    @Field("mobile") String mobile,
                                                    @Field("password") String password

    );

    /**
     * 收银台接口
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.pay")
    Observable<BaseResponse<PayModel>> PayInto(@Field("openid") String openid,
                                               @Field("id") String id

    );

    /**
     * 余额支付接口
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.pay.complete")
    Observable<BaseResponse<BalacePayModel>> BalancePay(@Field("openid") String openid,
                                                        @Field("id") String id,
                                                        @Field("type") String type

    );

    /**
     * 商品售后申请接口
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.goods_refund")
    Observable<BaseResponse<GoodsRefundmodel>> goodsRefund(@Field("openid") String openid,
                                                           @Field("goodsid") String goodsid,
                                                           @Field("id") String id,
                                                           @Field("optionid") String optionid,
                                                           @Field("rtype") String rtype,
                                                           @Field("grefundid") String grefundid

    );

    /**
     * 商品售后申请提交接口
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.goods_refund.submit")
    Observable<BaseResponse<BalacePayModel>> goodsRefundSubmit(@Field("openid") String openid,
                                                               @Field("orderid") String orderid,
                                                               @Field("goodsid") String goodsid,
                                                               @Field("rtype") String rtype,
                                                               @Field("optionid") String optionid,
                                                               @Field("merchid") String merchid,
                                                               @Field("applyprice") String applyprice,
                                                               @Field("reason") String reason,
                                                               @Field("goods_status") String goods_status,
                                                               @Field("images") String images

    );

}
