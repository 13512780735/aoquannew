package com.likeit.aqe365.adapter.find;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.DiaryListModel;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.NineGridTestLayout;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class DiaryListAdapter extends BaseQuickAdapter<DiaryListModel.ListBean, BaseViewHolder> {
    private NineGridTestLayout layout;

    public DiaryListAdapter(int layoutResId, List<DiaryListModel.ListBean> data) {
        super(R.layout.diary_list_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiaryListModel.ListBean item) {
        layout = (NineGridTestLayout) helper.getView(R.id.layout_nine_grid);
        layout.setIsShowAll(item.isShowAll);
        layout.setUrlList(item.images);
        ImageLoader.getInstance().displayImage(SharedPreferencesUtils.getString(mContext, "avatar"), (CircleImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_name, SharedPreferencesUtils.getString(mContext, "name"));
        helper.setText(R.id.tv_time, item.getEdittime());
        helper.setText(R.id.tv_content, item.getContent());
        helper.setText(R.id.tv_title, "浏览：" + item.getViews());


    }
}
