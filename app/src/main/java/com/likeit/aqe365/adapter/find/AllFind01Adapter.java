package com.likeit.aqe365.adapter.find;


import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.PostListModel;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.RatioImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class AllFind01Adapter extends BaseQuickAdapter<PostListModel.ListBean, BaseViewHolder> {
    private LinearLayout.LayoutParams linearParams;
    private int w_screen;

    public AllFind01Adapter(int layoutResId, List<PostListModel.ListBean> data) {
        super(R.layout.layout_recomment_items, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PostListModel.ListBean item) {
        RatioImageView ivPicture = helper.getView(R.id.iv_img);//图片
        linearParams = (LinearLayout.LayoutParams) ivPicture.getLayoutParams();
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        w_screen = dm.widthPixels;
        linearParams.height = (w_screen / 2) - 10;
        linearParams.width = (w_screen / 2) - 10;
        ivPicture.setLayoutParams(linearParams);

        CircleImageView ivAvatar = helper.getView(R.id.iv_avatar);//图片
        helper.setText(R.id.tv_detail, item.getTitle());
        helper.setText(R.id.tv_name, item.getNickname());
        helper.setText(R.id.tv_dis, item.getCoordinate());
        ImageLoader.getInstance().displayImage(item.getThumb(), ivPicture);
        ImageLoader.getInstance().displayImage(item.getAvatar(), ivAvatar);
    }
}
