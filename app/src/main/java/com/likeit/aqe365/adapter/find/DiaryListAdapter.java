package com.likeit.aqe365.adapter.find;


import android.graphics.Color;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.DiaryListModel;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.RatioImageView;

import java.util.List;

public class DiaryListAdapter extends BaseQuickAdapter<DiaryListModel.ListBean, BaseViewHolder> {
    private String isuser;
    private String theme_bg_tex;
    private String memberid;
    private RatioImageView iv01;
    private RatioImageView iv02;

    public DiaryListAdapter(int layoutResId, List<DiaryListModel.ListBean> data) {
        super(R.layout.diary_list_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiaryListModel.ListBean item) {
        ImageLoaderUtils mImageLoader = ImageLoaderUtils.getInstance(mContext);
        iv01 = helper.getView(R.id.iv01);
        iv02 = helper.getView(R.id.iv02);
        mImageLoader.displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_name, item.getNickname());
        helper.setText(R.id.tv_time, item.getEdittime());
        helper.setText(R.id.tv_content, item.getContent());
        helper.setText(R.id.tv_title, "浏览：" + item.getViews());
        final BorderTextView tvAttention = helper.getView(R.id.tv_attention);
        tvAttention.setVisibility(View.VISIBLE);
        isuser = item.getIsuser();
        theme_bg_tex = SharedPreferencesUtils.getString(mContext, "theme_bg_tex");
        if ("0".equals(isuser)) {
            tvAttention.setContentColorResource01(Color.parseColor(theme_bg_tex));
            tvAttention.setStrokeColor01(Color.parseColor(theme_bg_tex));
            tvAttention.setTextColor(Color.parseColor("#ffffff"));
            tvAttention.setText("+ 关注");
        } else {
            tvAttention.setContentColorResource01(Color.parseColor("#FFFFFF"));
            tvAttention.setStrokeColor01(Color.parseColor("#DBDBDB"));
            tvAttention.setTextColor(Color.parseColor("#DBDBDB"));
            tvAttention.setText("已关注");
        }
        helper.addOnClickListener(R.id.tv_attention);
        if (item.getImages() == null) {
            iv01.setVisibility(View.GONE);
            iv02.setVisibility(View.GONE);
        } else {
            if (item.getImages().size() == 1) {
                iv01.setVisibility(View.VISIBLE);
                mImageLoader.displayImage(item.getImages().get(0), iv01);
                iv02.setVisibility(View.INVISIBLE);
            } else {
                iv01.setVisibility(View.VISIBLE);
                iv02.setVisibility(View.VISIBLE);
                mImageLoader.displayImage(item.getImages().get(0), iv01);
                mImageLoader.displayImage(item.getImages().get(1), iv02);
            }
        }


    }
}
