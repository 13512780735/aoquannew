package com.likeits.simple.adapter.div_provider.home;

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

import java.util.List;


public class MainHomeAdapter extends MultipleItemRvAdapter<HomeMessage, BaseViewHolder> {
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


    public MainHomeAdapter(@Nullable List<HomeMessage> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(HomeMessage homeMessage) {
        //返回对应的viewType
        if (homeMessage instanceof MainHomeBannerModel) {
            return TYPE_BANNER;
        } else if (homeMessage instanceof MainHomeBlankModel) {
            return TYPE_BLANK;
        } else if (homeMessage instanceof MainHomeCouponModel) {
            return TYPE_COUPON;
        } else if (homeMessage instanceof MainHomeGoodModel) {
            return TYPE_GOODS;
        } else if (homeMessage instanceof MainHomekitchenwindowModel) {
            return TYPE_KITCHENWINDOW;
        } else if (homeMessage instanceof MainHomeListmenuModel) {
            return TYPE_LISTMENU;
        } else if (homeMessage instanceof MainHomeNoticeModel) {
            return TYPE_NOTICE;
        } else if (homeMessage instanceof MainHomePicturewModel) {
            return TYPE_PICTUREW;
        } else if (homeMessage instanceof MainHomeSearchModel) {
            return TYPE_SEARCH;
        } else if (homeMessage instanceof MainHomeTitleModel) {
            return TYPE_TITLE;
        } else if (homeMessage instanceof MainHomeVideoModel) {
            return TYPE_VIDEO;
        } else if (homeMessage instanceof MainHomeMenuModel) {
            return TYPE_MENU;
        } else if (homeMessage instanceof MainHomeSearch01Model) {
            return TYPE_SEARCHS;
        } else if (homeMessage instanceof MainHomePictureModel) {
            return TYPE_PICTURE;
        } else if (homeMessage instanceof MainHomeSeckillgroupModel) {
            return TYPE_SECKILLGROUP;
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
    }
}
