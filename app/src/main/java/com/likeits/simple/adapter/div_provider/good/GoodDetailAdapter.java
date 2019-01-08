package com.likeits.simple.adapter.div_provider.good;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.MultipleItemRvAdapter;
import com.likeits.simple.adapter.div_provider.home.MainBannerItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainBlankItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainCouponItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainGoodsItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainListMenuItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainMenuItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainNoticeItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainPictureItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainPicturewItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainSearchItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainSearchsItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainSeckillgroupItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainTitleItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainVideoItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainkitchenwindowItemProvider;
import com.likeits.simple.adapter.div_provider.member.MemberIconGroupItemProvider;
import com.likeits.simple.network.model.gooddetails.GoodDetailBannerItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailCommentItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailInfoItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailSaleItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailSeckillItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailShopItemModel;
import com.likeits.simple.network.model.gooddetails.GoodDetailSpecItemModel;
import com.likeits.simple.network.model.home.HomeMessage;
import com.likeits.simple.network.model.home.MainHomeBannerModel;
import com.likeits.simple.network.model.home.MainHomeBlankModel;
import com.likeits.simple.network.model.home.MainHomeCouponModel;
import com.likeits.simple.network.model.home.MainHomeGoodModel;
import com.likeits.simple.network.model.home.MainHomeListmenuModel;
import com.likeits.simple.network.model.home.MainHomeMenuModel;
import com.likeits.simple.network.model.home.MainHomeNoticeModel;
import com.likeits.simple.network.model.home.MainHomePictureModel;
import com.likeits.simple.network.model.home.MainHomePicturewModel;
import com.likeits.simple.network.model.home.MainHomeSearch01Model;
import com.likeits.simple.network.model.home.MainHomeSearchModel;
import com.likeits.simple.network.model.home.MainHomeSeckillgroupModel;
import com.likeits.simple.network.model.home.MainHomeTitleModel;
import com.likeits.simple.network.model.home.MainHomeVideoModel;
import com.likeits.simple.network.model.home.MainHomekitchenwindowModel;
import com.likeits.simple.network.model.member.MemberIconGroupItemModel;

import java.util.List;

public class GoodDetailAdapter extends MultipleItemRvAdapter<HomeMessage, BaseViewHolder> {


    public static final int TYPE_BANNER = 0;                 //轮播
    public static final int TYPE_BLANK = 1;             //空白位置
    public static final int TYPE_COUPON = 2;             //优惠卷
    public static final int TYPE_GOODS = 3;             //商品组
    public static final int TYPE_KITCHENWINDOW = 4;      //橱窗
    public static final int TYPE_LISTMENU = 5;      //列表菜单
    public static final int TYPE_NOTICE = 6;        //公告
    public static final int TYPE_PICTUREW = 7;   //图片组
    public static final int TYPE_SEARCH = 8;    //顶部搜索
    public static final int TYPE_SEARCHS = 9; //搜索
    public static final int TYPE_TITLE = 10; //标题
    public static final int TYPE_VIDEO = 11; //视频
    public static final int TYPE_MENU = 12; //菜单
    public static final int TYPE_PICTURE = 13; //图片
    public static final int TYPE_SECKILLGROUP = 14; //秒杀

    public static final int TYPE_SALES = 15;             //商品营销
    public static final int TYPE_BANNER01 = 16;             //商品banner
    public static final int TYPE_SECHILL = 17;             //商品秒杀
    public static final int TYPE_DETAILS_INFO = 18;             //商品信息
    public static final int TYPE_DETAILS_SHOP = 19;             //店铺
    public static final int TYPE_DETAILS_COMMENT = 20;             //评价
    public static final int TYPE_DETAILS_SPEC = 21;             //规格
    public static final int TYPE_ICONGROUP =22;      //列表菜单

    public GoodDetailAdapter(@Nullable List<HomeMessage> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(HomeMessage goodMessage) {
        //返回对应的viewType
        if (goodMessage instanceof MainHomeBannerModel) {
            return TYPE_BANNER;
        } else if (goodMessage instanceof MainHomeBlankModel) {
            return TYPE_BLANK;
        } else if (goodMessage instanceof MainHomeCouponModel) {
            return TYPE_COUPON;
        } else if (goodMessage instanceof MainHomeGoodModel) {
            return TYPE_GOODS;
        } else if (goodMessage instanceof MainHomekitchenwindowModel) {
            return TYPE_KITCHENWINDOW;
        } else if (goodMessage instanceof MainHomeListmenuModel) {
            return TYPE_LISTMENU;
        } else if (goodMessage instanceof MainHomeNoticeModel) {
            return TYPE_NOTICE;
        } else if (goodMessage instanceof MainHomePicturewModel) {
            return TYPE_PICTUREW;
        } else if (goodMessage instanceof MainHomeSearchModel) {
            return TYPE_SEARCH;
        } else if (goodMessage instanceof MainHomeTitleModel) {
            return TYPE_TITLE;
        } else if (goodMessage instanceof MainHomeVideoModel) {
            return TYPE_VIDEO;
        } else if (goodMessage instanceof MainHomeMenuModel) {
            return TYPE_MENU;
        } else if (goodMessage instanceof MainHomeSearch01Model) {
            return TYPE_SEARCHS;
        } else if (goodMessage instanceof MainHomePictureModel) {
            return TYPE_PICTURE;
        } else if (goodMessage instanceof MainHomeSeckillgroupModel) {
            return TYPE_SECKILLGROUP;
        } else if (goodMessage instanceof GoodDetailSaleItemModel) {
            return TYPE_SALES;
        } else if (goodMessage instanceof GoodDetailBannerItemModel) {
            return TYPE_BANNER01;
        } else if (goodMessage instanceof GoodDetailSeckillItemModel) {
            return TYPE_SECHILL;
        } else if (goodMessage instanceof GoodDetailInfoItemModel) {
            return TYPE_DETAILS_INFO;
        } else if (goodMessage instanceof GoodDetailShopItemModel) {
            return TYPE_DETAILS_SHOP;
        } else if (goodMessage instanceof GoodDetailCommentItemModel) {
            return TYPE_DETAILS_COMMENT;
        } else if (goodMessage instanceof GoodDetailSpecItemModel) {
            return TYPE_DETAILS_SPEC;
        } else if (goodMessage instanceof MemberIconGroupItemModel) {
            return TYPE_ICONGROUP;
        }
        return 0;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new MainBannerItemProvider());
        mProviderDelegate.registerProvider(new MainSearchItemProvider());
        mProviderDelegate.registerProvider(new MainTitleItemProvider());
        mProviderDelegate.registerProvider(new MainSearchsItemProvider());
        mProviderDelegate.registerProvider(new MainListMenuItemProvider());
        mProviderDelegate.registerProvider(new MainkitchenwindowItemProvider());
        mProviderDelegate.registerProvider(new MainNoticeItemProvider());
        mProviderDelegate.registerProvider(new MainMenuItemProvider());
        mProviderDelegate.registerProvider(new MainPictureItemProvider());
        mProviderDelegate.registerProvider(new MainPicturewItemProvider());
        mProviderDelegate.registerProvider(new MainCouponItemProvider());
        mProviderDelegate.registerProvider(new MainBlankItemProvider());
        mProviderDelegate.registerProvider(new MainGoodsItemProvider());
        mProviderDelegate.registerProvider(new MainVideoItemProvider());
        mProviderDelegate.registerProvider(new MainSeckillgroupItemProvider());


        mProviderDelegate.registerProvider(new GoodBannerItemProvider());
        mProviderDelegate.registerProvider(new GoodSeckillItemProvider());
        mProviderDelegate.registerProvider(new GoodDetailSaleItemProvider());
        mProviderDelegate.registerProvider(new GoodDetailInfoItemProvider());
        mProviderDelegate.registerProvider(new GoodDetailShopItemProvider());
        mProviderDelegate.registerProvider(new GoodDetailCommentItemProvider());
        mProviderDelegate.registerProvider(new GoodDetailsSpecItemProvider());
        mProviderDelegate.registerProvider(new MemberIconGroupItemProvider());
    }
}
