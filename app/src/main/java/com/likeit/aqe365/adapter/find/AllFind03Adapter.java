package com.likeit.aqe365.adapter.find;


import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.view.RoundImageView;

import java.util.List;

public class AllFind03Adapter extends BaseQuickAdapter<BoardListModel.ListBean, BaseViewHolder> {
    private ImageLoaderUtils mImageLoader;

    public AllFind03Adapter(int layoutResId, List<BoardListModel.ListBean> data) {
        super(R.layout.boradlist_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BoardListModel.ListBean item) {
        mImageLoader= ImageLoaderUtils.getInstance(mContext);


        helper.setText(R.id.tv_title,"#"+item.getTitle());
        helper.setText(R.id.tv_desc,item.getDesc());
        helper.setText(R.id.tv_participant,item.getParticipant()+"人");
        helper.setText(R.id.postcount,item.getPostcount()+"帖子");
        //mImageLoader.displayImage(item.getLogo(), (RoundImageView) helper.getView(R.id.iv_img));
        Glide.with(mContext)
                .load(item.getLogo())
                .override(600, 600)
                .animate(R.anim.item_alpha_in)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.default_pic).error(R.mipmap.default_pic).into( (RoundImageView) helper.getView(R.id.iv_img));
    }
}
