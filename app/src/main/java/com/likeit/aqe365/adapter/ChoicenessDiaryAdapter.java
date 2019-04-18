package com.likeit.aqe365.adapter;

import android.graphics.Color;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.find.DiaryListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.ToastUtils;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.NineGridTestLayout;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import rx.Subscriber;

public class ChoicenessDiaryAdapter extends BaseQuickAdapter<DiaryListModel.ListBean, BaseViewHolder> {
    private NineGridTestLayout layout;
    private String isuser;
    private String theme_bg_tex;
    private String memberid;

    public ChoicenessDiaryAdapter(int layoutResId, List<DiaryListModel.ListBean> data) {
        super(R.layout.diary_list_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiaryListModel.ListBean item) {
        layout = (NineGridTestLayout) helper.getView(R.id.layout_nine_grid);
        memberid = item.getMemberid();
        layout.setIsShowAll(item.isShowAll);
        layout.setUrlList(item.images);
        ImageLoader.getInstance().displayImage(SharedPreferencesUtils.getString(mContext, "avatar"), (CircleImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_name, SharedPreferencesUtils.getString(mContext, "name"));
        helper.setText(R.id.tv_time, item.getEdittime());
        helper.setText(R.id.tv_content, item.getContent());
        helper.setText(R.id.tv_title, "浏览：" + item.getViews());
        final BorderTextView tvAttention = helper.getView(R.id.tv_attention);
        tvAttention.setVisibility(View.VISIBLE);
        isuser = SharedPreferencesUtils.getString(mContext, "isuser");
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
        tvAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("0".equals(isuser)) {
                    isuser = "1";
                    tvAttention.setContentColorResource01(Color.parseColor("#FFFFFF"));
                    tvAttention.setStrokeColor01(Color.parseColor("#DBDBDB"));
                    tvAttention.setTextColor(Color.parseColor("#DBDBDB"));
                    tvAttention.setText("已关注");
                } else {
                    isuser = "0";
                    tvAttention.setContentColorResource01(Color.parseColor(theme_bg_tex));
                    tvAttention.setStrokeColor01(Color.parseColor(theme_bg_tex));
                    tvAttention.setTextColor(Color.parseColor("#ffffff"));
                    tvAttention.setText("+ 关注");
                }
                attention();
            }
        });
    }

    /**
     * 关注
     */
    private void attention() {
        String openid = SharedPreferencesUtils.getString(mContext, "openid");
        RetrofitUtil.getInstance().Followmember(openid, memberid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    ToastUtils.showToast(mContext, baseResponse.getMsg());
                } else {
                    ToastUtils.showToast(mContext, baseResponse.getMsg());
                }
            }
        });
    }
}
