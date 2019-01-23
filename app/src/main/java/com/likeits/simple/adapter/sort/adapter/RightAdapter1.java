package com.likeits.simple.adapter.sort.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.activity.good.GoodListActivity;
import com.likeits.simple.network.model.GoodCategory.GoodsCategoryModel;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * User: Liumj(liumengjie@365tang.cn)
 * Date: 2016-10-11
 * Time: 15:51
 * describe:  右边适配器
 */
public class RightAdapter1 extends BaseQuickAdapter<GoodsCategoryModel.ListBean, BaseViewHolder> {

    public RightAdapter1(int layoutResId, List<GoodsCategoryModel.ListBean> data) {
        super(R.layout.item_medical_tv, data);
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, final GoodsCategoryModel.ListBean item) {
        LinearLayout ll_shopPic=baseViewHolder.getView(R.id.ll_shopPic);
        baseViewHolder.setText(R.id.tv_name, item.getName());
        ImageLoader.getInstance().displayImage(item.getThumb(), (ImageView) baseViewHolder.getView(R.id.iv_avatar));

        ll_shopPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cid = item.getId();
                Intent intent = new Intent(mContext, GoodListActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("cid",cid);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }
}
