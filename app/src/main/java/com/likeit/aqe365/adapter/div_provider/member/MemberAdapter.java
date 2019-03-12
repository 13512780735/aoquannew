package com.likeit.aqe365.adapter.div_provider.member;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.MultipleItemRvAdapter;
import com.likeit.aqe365.adapter.div_provider.home.MainBannerItemProvider;
import com.likeit.aqe365.adapter.div_provider.home.MainBlankItemProvider;
import com.likeit.aqe365.adapter.div_provider.home.MainListMenuItemProvider;
import com.likeit.aqe365.adapter.div_provider.home.MainMenuItemProvider;
import com.likeit.aqe365.adapter.div_provider.home.MainPictureItemProvider;
import com.likeit.aqe365.adapter.div_provider.home.MainPicturewItemProvider;
import com.likeit.aqe365.adapter.div_provider.home.MainTitleItemProvider;
import com.likeit.aqe365.adapter.div_provider.home.MainkitchenwindowItemProvider;
import com.likeit.aqe365.network.model.home.HomeMessage;
import com.likeit.aqe365.network.model.home.MainHomeBannerModel;
import com.likeit.aqe365.network.model.home.MainHomeBlankModel;
import com.likeit.aqe365.network.model.home.MainHomeListmenuModel;
import com.likeit.aqe365.network.model.home.MainHomeMenuModel;
import com.likeit.aqe365.network.model.home.MainHomePictureModel;
import com.likeit.aqe365.network.model.home.MainHomePicturewModel;
import com.likeit.aqe365.network.model.home.MainHomeTitleModel;
import com.likeit.aqe365.network.model.home.MainHomekitchenwindowModel;
import com.likeit.aqe365.network.model.member.MemberIconGroupItemModel;
import com.likeit.aqe365.network.model.member.MemberItemModel;
import com.likeit.aqe365.network.model.member.MemberLogoutItemModel;

import java.util.List;

public class MemberAdapter extends MultipleItemRvAdapter<HomeMessage, BaseViewHolder> {
    public static final int TYPE_BANNER = 0;                 //轮播
    public static final int TYPE_BLANK = 1;             //空白位置
    public static final int TYPE_MEMBER = 2;      //頂部信息
    public static final int TYPE_ICONGROUP = 22;      //列表菜单
    public static final int TYPE_TITLE = 10; //标题
    public static final int TYPE_LOGOUT = 21;      //退出
    public static final int TYPE_PICTURE = 13; //图片
    public static final int TYPE_PICTUREW = 7;   //图片组
    public static final int TYPE_LISTMENU = 5;      //列表菜单
    public static final int TYPE_KITCHENWINDOW = 4;      //橱窗
    public static final int TYPE_MENU = 12; //菜单
    public MemberAdapter(@Nullable List<HomeMessage> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(HomeMessage goodMessage) {
        if (goodMessage instanceof MainHomeTitleModel) {
            return TYPE_TITLE;
        } else if (goodMessage instanceof MainHomeListmenuModel) {
            return TYPE_LISTMENU;
        } else if (goodMessage instanceof MemberItemModel) {
            return TYPE_MEMBER;
        } else if (goodMessage instanceof MemberIconGroupItemModel) {
            return TYPE_ICONGROUP;
        } else if (goodMessage instanceof MemberLogoutItemModel) {
            return TYPE_LOGOUT;
        } else if (goodMessage instanceof MainHomeBannerModel) {
            return TYPE_BANNER;
        } else if (goodMessage instanceof MainHomeBlankModel) {
            return TYPE_BLANK;
        } else if (goodMessage instanceof MainHomePicturewModel) {
            return TYPE_PICTUREW;
        }else if (goodMessage instanceof MainHomePictureModel) {
            return TYPE_PICTURE;
        }else if (goodMessage instanceof MainHomekitchenwindowModel) {
            return TYPE_KITCHENWINDOW;
        } else if (goodMessage instanceof MainHomeMenuModel) {
            return TYPE_MENU;
        }
        return 0;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new MainListMenuItemProvider());
        mProviderDelegate.registerProvider(new MemberItemProvider());
        mProviderDelegate.registerProvider(new MemberLogoutItemProvider());
        mProviderDelegate.registerProvider(new MemberIconGroupItemProvider());
        mProviderDelegate.registerProvider(new MainBannerItemProvider());
        mProviderDelegate.registerProvider(new MainBlankItemProvider());
        mProviderDelegate.registerProvider(new MainPictureItemProvider());
        mProviderDelegate.registerProvider(new MainPicturewItemProvider());
        mProviderDelegate.registerProvider(new MainkitchenwindowItemProvider());
        mProviderDelegate.registerProvider(new MainMenuItemProvider());
        mProviderDelegate.registerProvider(new MainTitleItemProvider());
    }
}
