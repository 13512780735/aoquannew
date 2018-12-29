package com.likeits.simple.network;

import com.likeits.simple.network.consts.Consts;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.EmptyEntity;
import com.likeits.simple.network.model.LoginRegisterModel;
import com.likeits.simple.network.model.home.MainHomePagerModel;
import com.likeits.simple.network.model.main.MainNavigationModel;

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


}
