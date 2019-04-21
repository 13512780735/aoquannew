package com.likeit.aqe365.adapter.find;


import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.PostListModel;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.RatioImageView;

import java.util.List;

public class AllFind01Adapter extends BaseQuickAdapter<PostListModel.ListBean, BaseViewHolder> {
    private LinearLayout.LayoutParams linearParams;
    private int w_screen;
    private FrameLayout.LayoutParams linearParams01;

    public AllFind01Adapter(int layoutResId, List<PostListModel.ListBean> data) {
        super(R.layout.layout_recomment_items, data);
    }
    ImageLoaderUtils mImageLoader;
    @Override
    protected void convert(BaseViewHolder helper, PostListModel.ListBean item) {
        mImageLoader= ImageLoaderUtils.getInstance(mContext);
        RatioImageView ivPicture = helper.getView(R.id.iv_img);//图片
        RatioImageView iv_video_img = helper.getView(R.id.iv_video_img);//視頻圖片
        FrameLayout fr_video = helper.getView(R.id.fr_video);//图片
        linearParams = (LinearLayout.LayoutParams) ivPicture.getLayoutParams();
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        w_screen = dm.widthPixels;
        linearParams.height = (w_screen / 2) - 10;
        linearParams.width = (w_screen / 2) - 10;
        ivPicture.setLayoutParams(linearParams);


        linearParams01 = (FrameLayout.LayoutParams) iv_video_img.getLayoutParams();
        linearParams01.height = (w_screen / 2) - 10;
        linearParams01.width = (w_screen / 2) - 10;
        iv_video_img.setLayoutParams(linearParams01);

        CircleImageView ivAvatar = helper.getView(R.id.iv_avatar);//图片
        helper.setText(R.id.tv_detail, item.getTitle());
        helper.setText(R.id.tv_name, item.getNickname());
        helper.setText(R.id.tv_dis, item.getCoordinate());
        mImageLoader.displayImage(item.getAvatar(), ivAvatar);
        if ("0".equals(item.getTypes())) {
            ivPicture.setVisibility(View.VISIBLE);
            fr_video.setVisibility(View.GONE);
            mImageLoader.displayImage(item.getThumb(), ivPicture);
        } else {
            ivPicture.setVisibility(View.GONE);
            fr_video.setVisibility(View.VISIBLE);
            mImageLoader.displayImage(item.getThumb(), iv_video_img);
        }

    }
}
