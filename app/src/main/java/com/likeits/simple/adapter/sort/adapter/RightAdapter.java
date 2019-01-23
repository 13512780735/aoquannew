package com.likeits.simple.adapter.sort.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.activity.good.GoodListActivity;
import com.likeits.simple.network.model.GoodCategory.GoodsCategoryModel;
import com.likeits.simple.utils.SharedPreferencesUtils;

import java.util.List;

/**
 * User: Liumj(liumengjie@365tang.cn)
 * Date: 2016-10-11
 * Time: 15:51
 * describe:  右边适配器
 */
public class RightAdapter extends BaseQuickAdapter<GoodsCategoryModel.ListBean.TwotierBean, BaseViewHolder> {

    public RightAdapter(int layoutResId, List<GoodsCategoryModel.ListBean.TwotierBean> data) {
        super(R.layout.item_main_right, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final GoodsCategoryModel.ListBean.TwotierBean listBean) {
        String catlevel = SharedPreferencesUtils.getString(mContext, "catlevel");
        helper.setText(R.id.item_main_right_title, listBean.getName());
        RecyclerView mRecyclerView = helper.getView(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        final List<GoodsCategoryModel.ListBean.TwotierBean.GoodsBean> drugItemBeen = listBean.getGoods();
        final ShopSortTagAdapter drugAdapter = new ShopSortTagAdapter(R.layout.item_medical_tv, drugItemBeen);
        mRecyclerView.setAdapter(drugAdapter);
        drugAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                GoodsCategoryModel.ListBean.TwotierBean.GoodsBean goodsBean = drugItemBeen.get(position);
                String cid = goodsBean.getId();
                Intent intent = new Intent(mContext, GoodListActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("cid",cid);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });


    }
}
