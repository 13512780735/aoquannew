package com.likeit.aqe365.adapter.find;


import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.UserListModel;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.view.CircleImageView;

import java.util.List;

public class AllFind05Adapter extends BaseQuickAdapter<UserListModel.ListBean, BaseViewHolder> {
    private ImageLoaderUtils mImageLoader;

    public AllFind05Adapter(int layoutResId, List<UserListModel.ListBean> data) {
        super(R.layout.find_user_listitem, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserListModel.ListBean item) {
        mImageLoader= ImageLoaderUtils.getInstance(mContext);
        Glide.with(mContext)
                .load(item.getAvatar())
                .override(600, 600)
                .animate(R.anim.item_alpha_in)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.default_pic).error(R.mipmap.default_pic).into((CircleImageView) helper.getView(R.id.iv_avatar));

       // mImageLoader.displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_title, item.getNickname());
        helper.setText(R.id.tv_content, item.getJournal_num() + " 日记" + item.getPost_num() + " 帖子");
        helper.setText(R.id.tv_distance, item.getCoordinate());
    }
}
