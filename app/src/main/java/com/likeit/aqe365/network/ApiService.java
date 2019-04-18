package com.likeit.aqe365.network;

import com.likeit.aqe365.adapter.sort.bean.CartDeleteModel;
import com.likeit.aqe365.network.consts.Consts;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.CaseEntity;
import com.likeit.aqe365.network.model.DiyTabModel;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.GoodCategory.CategoryListItemsModel;
import com.likeit.aqe365.network.model.GoodCategory.GoodsCategoryModel;
import com.likeit.aqe365.network.model.GoodCommentmodel;
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

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
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
    @POST("nativeapp.shop.get_tabbar")
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
                                                       @Field("cycelid") String cycelid,
                                                       @Field("express") String express,
                                                       @Field("expresssn") String expresssn,
                                                       @Field("expresscom") String expresscom
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
                                                           @Field("orderid") String id,
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
    Observable<BaseResponse<EmptyEntity>> goodsRefundSubmit(@Field("openid") String openid,
                                                            @Field("orderid") String orderid,
                                                            @Field("goodsid") String goodsid,
                                                            @Field("rtype") String rtype,
                                                            @Field("optionid") String optionid,
                                                            @Field("merchid") String merchid,
                                                            @Field("applyprice") String applyprice,
                                                            @Field("reason") String reason,
                                                            @Field("goods_status") String goods_status,
                                                            @Field("images") String images,
                                                            @Field("content") String content

    );

    /**
     * 确认收到售后物品
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.goods_refund.receive")
    Observable<BaseResponse<EmptyEntity>> goodsRefundReceive(@Field("openid") String openid,
                                                             @Field("goodsid") String goodsid,
                                                             @Field("orderid") String id,
                                                             @Field("optionid") String optionid,
                                                             @Field("rtype") String rtype,
                                                             @Field("grefundid") String grefundid

    );

    /**
     * 取消售后申请接口
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.goods_refund.cancel")
    Observable<BaseResponse<EmptyEntity>> goodsRefundCancel(@Field("openid") String openid,
                                                            @Field("goodsid") String goodsid,
                                                            @Field("orderid") String id,
                                                            @Field("grefundid") String grefundid

    );

    /**
     * 填写快递单号提交接口
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.order.goods_refund.express")
    Observable<BaseResponse<EmptyEntity>> goodsRefundExpress(@Field("openid") String openid,
                                                             @Field("goodsid") String goodsid,
                                                             @Field("orderid") String id,
                                                             @Field("optionid") String optionid,
                                                             @Field("rtype") String rtype,
                                                             @Field("grefundid") String grefundid,
                                                             @Field("express") String express,
                                                             @Field("expresssn") String expresssn,
                                                             @Field("expresscom") String expresscom

    );

    /**
     * 自定义选项卡接口
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.shop.get_diytab")
    Observable<BaseResponse<DiyTabModel>> getDiyTab(@Field("openid") String openid

    );

    /**
     * 推荐列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.postlist")
    Observable<BaseResponse<PostListModel>> Postlist(@Field("openid") String openid,
                                                     @Field("pageNum") String pageNum,
                                                     @Field("keyword") String keyword,
                                                     @Field("lat") String lat,
                                                     @Field("lng") String lng,
                                                     @Field("type") String type,
                                                     @Field("bid") String bid,
                                                     @Field("memberid") String memberid
    );

    /**
     * 话题列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.get_boardlist")
    Observable<BaseResponse<BoardListModel>> GetBoardlist(@Field("openid") String openid,
                                                          @Field("keyword") String keyword,
                                                          @Field("type") String type,
                                                          @Field("pageNum") String pageNum
    );

    /**
     * 关注话题列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.followlist")
    Observable<BaseResponse<FollowlistModel>> GetFollowlist(@Field("openid") String openid,
                                                            @Field("keyword") String keyword,
                                                            @Field("pageNum") String pageNum
    );

    /**
     * 关注话题
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.follow")
    Observable<BaseResponse<EmptyEntity>> GetFollow(@Field("openid") String openid,
                                                    @Field("bid") String bid
    );

    /**
     * 用户
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.user")
    Observable<BaseResponse<UserListModel>> GetUser(@Field("openid") String openid,
                                                    @Field("keyword") String keyword,
                                                    @Field("lat") String lat,
                                                    @Field("lng") String lng,
                                                    @Field("pageNum") String pageNum
    );

    /**
     * 关注用户
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.followmember")
    Observable<BaseResponse<EmptyEntity>> Followmember(@Field("openid") String openid,
                                                       @Field("memberid") String memberid
    );

    /**
     * 日记列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.journallist")
    Observable<BaseResponse<DiaryListModel>> Journallist(@Field("openid") String openid,
                                                         @Field("memberid") String memberid,
                                                         @Field("type") String type,
                                                         @Field("pageNum") String pageNum
    );

    /**
     * 用户日记列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.diarylist")
    Observable<BaseResponse<DiaryListModel>> diarylist(@Field("openid") String openid,
                                                       @Field("memberid") String memberid,
                                                       @Field("type") String type,
                                                       @Field("pageNum") String pageNum
    );

    /**
     * 用户帖子列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.postuser")
    Observable<BaseResponse<FollowlistModel>> PostserList(@Field("openid") String openid,
                                                          @Field("memberid") String memberid,
                                                          @Field("pageNum") String pageNum
    );

    /**
     * 我的日记本
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.mydiary")
    Observable<BaseResponse<MyDiaryListModel>> MyDiary(@Field("openid") String openid,
                                                       @Field("pageNum") String pageNum
    );

    /**
     * 创建日记本
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.createbook")
    Observable<BaseResponse<CaseEntity>> Createbook(@Field("openid") String openid,
                                                    @Field("title") String title,
                                                    @Field("hospital") String hospital,
                                                    @Field("category") String category,
                                                    @Field("service") String service,
                                                    @Field("lat") String lat,
                                                    @Field("lng") String lng,
                                                    @Field("addtime") String addtime,
                                                    @Field("type") String type
    );

    /**
     * 日记编辑
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.editdiary")
    Observable<BaseResponse<HospitalandServeModel>> Editdiary(@Field("openid") String openid,
                                                              @Field("type") String type,
                                                              @Field("keyword") String keyword,
                                                              @Field("city") String city,
                                                              @Field("pageNum") String pageNum
    );

    /**
     * 帖子详情
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.postdetails")
    Observable<BaseResponse<PostDetailsModel>> postDetails(@Field("openid") String openid,
                                                           @Field("id") String id,
                                                           @Field("pageNum") String pageNum
    );

    /**
     * 帖子点赞
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.postlike")
    Observable<BaseResponse<EmptyEntity>> postlike(@Field("openid") String openid,
                                                   @Field("bid") String bid,
                                                   @Field("pid") String pid
    );

    /**
     * 帖子收藏
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.collectpost")
    Observable<BaseResponse<EmptyEntity>> collectpost(@Field("openid") String openid,
                                                      @Field("id") String id
    );

    /**
     * 帖子回复
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.reply")
    Observable<BaseResponse<EmptyEntity>> postReply(@Field("openid") String openid,
                                                    @Field("pid") String id,
                                                    @Field("bid") String bid,
                                                    @Field("rpid") String rpid,
                                                    @Field("mpid") String mpid,
                                                    @Field("content") String content
    );

    /**
     * 日記本详情
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.diarydetails")
    Observable<BaseResponse<DiarydetailsModel>> diarydetails(@Field("openid") String openid,
                                                             @Field("memberid") String memberid,
                                                             @Field("diaryid") String diaryid,
                                                             @Field("pageNum") String pageNum
    );

    /**
     * 日記本收藏
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.collect")
    Observable<BaseResponse<EmptyEntity>> diaryCollect(@Field("openid") String openid,
                                                       @Field("diaryid") String diaryid
    );

    /**
     * 关注日记
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.follow")
    Observable<BaseResponse<EmptyEntity>> diaryFollow(@Field("openid") String openid,
                                                      @Field("id") String id
    );

    /**
     * 日记/日记本更多评论
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.diaryComment")
    Observable<BaseResponse<MoreDiaryModel>> diaryComment(@Field("openid") String openid,
                                                          @Field("type") String type,
                                                          @Field("diaryid") String diaryid,
                                                          @Field("id") String id,
                                                          @Field("pageNum") String pageNum
    );

    /**
     * 日记本回复
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.reply")
    Observable<BaseResponse<EmptyEntity>> diaryReply(@Field("openid") String openid,
                                                     @Field("diaryid") String diaryid,
                                                     @Field("rdid") String rdid,
                                                     @Field("mdid") String mdid,
                                                     @Field("content") String content
    );

    /**
     * 日记本点赞
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.diarylike")
    Observable<BaseResponse<EmptyEntity>> diarylike(@Field("openid") String openid,
                                                    @Field("diaryid") String diaryid,
                                                    @Field("commentid") String commentid
    );

    /**
     * 日记点赞
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.journallike")
    Observable<BaseResponse<EmptyEntity>> journallike(@Field("openid") String openid,
                                                      @Field("diaryid") String diaryid,
                                                      @Field("cid") String cid

    );

    /**
     * 日记本详情日记列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.detailjournallist")
    Observable<BaseResponse<JournalModel>> detailjournallist(@Field("openid") String openid,
                                                             @Field("memberid") String memberid,
                                                             @Field("diaryid") String diaryid,
                                                             @Field("pageNum") String pageNum
    );

    /**
     * 日记详情
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.journaldetails")
    Observable<BaseResponse<JournalDetailsModel>> journalDetails(@Field("openid") String openid,
                                                                 @Field("id") String id,
                                                                 @Field("pageNum") String pageNum
    );

    /**
     * 日记回复
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.replyjournal")
    Observable<BaseResponse<EmptyEntity>> replyJournal(@Field("openid") String openid,
                                                       @Field("diaryid") String diaryid,
                                                       @Field("cid") String cid,
                                                       @Field("rcid") String rcid,
                                                       @Field("mcid") String mcid,
                                                       @Field("content") String content
    );

    /**
     * 关注日记
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.journal.follow")
    Observable<BaseResponse<EmptyEntity>> follow(@Field("openid") String openid,
                                                 @Field("id") String id
    );


    /**
     * 发布日记
     *
     * @param openid
     * @param diaryid
     * @param lat
     * @param lng
     * @param title
     * @param content
     * @param recoverytime
     * @param type
     * @param image
     * @param file
     * @return
     */
    @Multipart
    @POST("nativeapp.discover.journal.submit")
    Observable<BaseResponse<EmptyEntity>> submit(
            @Part("openid") RequestBody openid,
            @Part("diaryid") RequestBody diaryid,
            @Part("lat") RequestBody lat,
            @Part("lng") RequestBody lng,
            @Part("title") RequestBody title,
            @Part("content") RequestBody content,
            @Part("recoverytime") RequestBody recoverytime,
            @Part("type") RequestBody type,
            @Part List<MultipartBody.Part> image,
            @Part List<MultipartBody.Part> file
    );

    /**
     * 发布心情和帖子用户列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.mood.concernslist")
    Observable<BaseResponse<ConcernsListModel>> concernslist(@Field("openid") String openid
    );

    /**
     * 关注话题列表(安卓)
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.mood.follow")
    Observable<BaseResponse<FoolowMoodListModel>> follow(@Field("openid") String openid
    );
    /**
     * 心情列表
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.mood.moodlist")
    Observable<BaseResponse<MoodListModel>> moodlist(@Field("openid") String openid,
                                                     @Field("type") String type,
                                                     @Field("keyword") String keyword,
                                                     @Field("pageNum") String pageNum
    );

    /**
     * 心情详情
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.mood.mooddetails")
    Observable<BaseResponse<MoodDetailsModel>> mooddetails(@Field("openid") String openid,
                                                           @Field("id") String id,
                                                           @Field("pageNum") String pageNum
    );

    /**
     * 心情收藏
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.mood.collectmood")
    Observable<BaseResponse<EmptyEntity>> collectmood(@Field("openid") String openid,
                                                      @Field("id") String id
    );

    /**
     * 心情点赞
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.mood.moodlike")
    Observable<BaseResponse<EmptyEntity>> moodlike(@Field("openid") String openid,
                                                   @Field("bid") String bid,
                                                   @Field("pid") String pid
    );

    /**
     * 心情回复
     *
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.mood.moodreply")
    Observable<BaseResponse<EmptyEntity>> moodreply(@Field("openid") String openid,
                                                    @Field("pid") String pid,
                                                    @Field("bid") String bid,
                                                    @Field("rpid") String rpid,
                                                    @Field("mpid") String mpid,
                                                    @Field("content") String content
    );

    /**
     * 发布心情
     *
     * @return
     */
    @Multipart
    @POST("nativeapp.discover.mood.moodsubmit")
    Observable<BaseResponse<EmptyEntity>> moodsubmit(@Part("openid") RequestBody openid,
                                                     @Part("lat") RequestBody lat,
                                                     @Part("lng") RequestBody lng,
                                                     @Part("bids") RequestBody bids,
                                                     @Part("content") RequestBody content,
                                                     @Part List<MultipartBody.Part> images,
                                                     @Part MultipartBody.Part videos,
                                                     @Part MultipartBody.Part videoimage,
                                                     @Part("userid") RequestBody userid
    );

    /**
     * 发布帖子
     *
     * @return
     */
    @Multipart
    @POST("nativeapp.discover.diary.submit")
    Observable<BaseResponse<EmptyEntity>> postSumit(@Part("openid") RequestBody openid,
                                                    @Part("lat") RequestBody lat,
                                                    @Part("lng") RequestBody lng,
                                                    @Part("title") RequestBody title,
                                                    @Part("bids") RequestBody bids,
                                                    @Part("content") RequestBody content,
                                                    @Part List<MultipartBody.Part> images,
                                                    @Part MultipartBody.Part videos,
                                                    @Part MultipartBody.Part videoimage,
                                                    @Part("hospitalid") RequestBody hospitalid,
                                                    @Part("userid") RequestBody userid
    );

    /**
     * 医生提问
     *
     * @return
     */
    @Multipart
    @POST("nativeapp.discover.ask.quiz")
    Observable<BaseResponse<EmptyEntity>> quiz(@Part("openid") RequestBody openid,
                                               @Part("title") RequestBody title,
                                               @Part("content") RequestBody content,
                                               @Part List<MultipartBody.Part> images
    );

    /**
     * 医院列表
     *
     * @param openid
     * @param keyword
     * @param pageNum
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.hospital.hospitalList")
    Observable<BaseResponse<HospitalListModel>> hospitalList(@Field("openid") String openid,
                                                             @Field("keyword") String keyword,
                                                             @Field("pageNum") String pageNum
    );

    /**
     * 我的消息
     *
     * @param openid
     * @param type
     * @param pageNum
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.my.lists")
    Observable<BaseResponse<MessageListModel>> myMessageList(@Field("openid") String openid,
                                                             @Field("type") String type,
                                                             @Field("pageNum") String pageNum
    );

    /**
     * 公告列表
     *
     * @param openid
     * @param pageNum
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.shop.notice.get_list")
    Observable<BaseResponse<NoticeListModel>> getNoticelist(@Field("openid") String openid,
                                                            @Field("pageNum") String pageNum
    );

    /**
     * 添加与搜索话题(心情和帖子)
     *
     * @param openid
     * @param pageNum
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.postTopiclist")
    Observable<BaseResponse<BoardListModel>> postTopiclist(@Field("openid") String openid,
                                                           @Field("keywords") String keywords,
                                                           @Field("pageNum") String pageNum
    );

    /**
     * 根据memberid获取个人信息
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.member.my.getUserInfo")
    Observable<BaseResponse<GetUserInfoModel>> getUserInfo(@Field("openid") String openid,
                                                           @Field("memberid") String memberid
    );

    /**
     * 用户列表(粉丝)
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.user")
    Observable<BaseResponse<MyUserModel>> getMyUser(@Field("openid") String openid,
                                                  @Field("keywords") String keywords,
                                                  @Field("type") String type,
                                                  @Field("lat") String lat,
                                                  @Field("lng") String lng,
                                                  @Field("pageNum") String pageNum
    );

    /**
     * 用户帖子和心情列表
     *
     * @param openid
     * @return
     */
    @FormUrlEncoded
    @POST("nativeapp.discover.diary.postuser")
    Observable<BaseResponse<PostUserModel>> postuser(@Field("openid") String openid,
                                                     @Field("memberid") String memberid,
                                                     @Field("type") String type,
                                                     @Field("pageNum") String pageNum
    );

}
