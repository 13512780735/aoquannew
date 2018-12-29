package com.likeits.simple.adapter.div_provider.member;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.MultipleItemRvAdapter;
import com.likeits.simple.adapter.div_provider.good.GoodBannerItemProvider;
import com.likeits.simple.adapter.div_provider.home.MainListMenuItemProvider;
import com.likeits.simple.network.model.home.HomeMessage;
import com.likeits.simple.network.model.home.MainHomeBannerModel;
import com.likeits.simple.network.model.home.MainHomeBlankModel;
import com.likeits.simple.network.model.home.MainHomeListmenuModel;
import com.likeits.simple.network.model.home.MainHomeTitleModel;
import com.likeits.simple.network.model.member.MemberIconGroupItemModel;
import com.likeits.simple.network.model.member.MemberItemModel;
import com.likeits.simple.network.model.member.MemberLogoutItemModel;

import java.util.List;

public class MemberAdapter extends MultipleItemRvAdapter<HomeMessage, BaseViewHolder> {

    public static final int TYPE_TITLE = 0; //标题
 //   public static final int TYPE_LISTMENU = 1;      //列表菜单
    public static final int TYPE_MEMBER = 2;      //頂部信息
    public static final int TYPE_ICONGROUP = 3;      //列表菜单
    public static final int TYPE_LOGOUT = 4;      //退出

    public static final int TYPE_LISTMENU = 5;      //列表菜单
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
        }
        return 0;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new MainListMenuItemProvider());
        mProviderDelegate.registerProvider(new MemberItemProvider());
    }
}
