package com.likeit.aqe365.adapter.find;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.HospitalListModel;
import com.likeit.aqe365.network.model.find.UserListModel;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.RoundImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class AllFind06Adapter extends BaseQuickAdapter<HospitalListModel.ListBean, BaseViewHolder> {
    public AllFind06Adapter(int layoutResId, List<HospitalListModel.ListBean> data) {
        super(R.layout.find_hospital_listitem, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HospitalListModel.ListBean item) {
        ImageLoaderUtils mImageLoader = ImageLoaderUtils.getInstance(mContext);
        //mImageLoader.displayImage(item.getLogo(), (CircleImageView) helper.getView(R.id.iv_avatar));
        Glide.with(mContext)
                .load(item.getLogo())
                .override(600, 600)
                .animate(R.anim.item_alpha_in)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(true)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.default_pic).error(R.mipmap.default_pic).into( (CircleImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_title, item.getName());
        helper.setText(R.id.tv_address, item.getAddress());
        helper.addOnClickListener(R.id.tv_location);
    }
}
