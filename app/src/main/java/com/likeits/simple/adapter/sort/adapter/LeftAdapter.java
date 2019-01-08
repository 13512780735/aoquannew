package com.likeits.simple.adapter.sort.adapter;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.network.model.GoodCategory.GoodsCategoryModel;

import java.util.List;


/**
 * User: Liumj(liumengjie@365tang.cn)
 * Date: 2016-10-11
 * Time: 15:19
 * describe:  左侧适配器
 */
public class LeftAdapter extends BaseQuickAdapter<GoodsCategoryModel.ListBean,BaseViewHolder> {
	private int selectPos=0;
//	public LeftAdapter( List<ShopSortBean> data) {
//		super(R.layout.item_main_left, data);
//	}
	public LeftAdapter(int layoutResId, List<GoodsCategoryModel.ListBean> data) {
		super(R.layout.item_main_left, data);
	}
	@Override
	protected void convert(BaseViewHolder helper, GoodsCategoryModel.ListBean bean) {
		if(selectPos==helper.getAdapterPosition()){
			helper.setVisible(R.id.item_main_left_bg,true);
			helper.convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
			helper.setTextColor(R.id.item_main_left_type, Color.parseColor("#FF4081"));
		}else{
			helper.convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
			helper.setTextColor(R.id.item_main_left_type, Color.parseColor("#333333"));
			helper.setVisible(R.id.item_main_left_bg,false);
		}

		helper.setText(R.id.item_main_left_type,bean.getName());

	}


	public int getSelectPos() {
		return selectPos;
	}

	public void setSelectPos(int selectPos) {
		this.selectPos = selectPos;
	}
}
