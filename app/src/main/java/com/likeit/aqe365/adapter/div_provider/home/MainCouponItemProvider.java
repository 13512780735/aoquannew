package com.likeit.aqe365.adapter.div_provider.home;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.home.MainHomeCouponModel;
import com.likeit.aqe365.view.RatioImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


public class MainCouponItemProvider extends BaseItemProvider<MainHomeCouponModel, BaseViewHolder> {
    MainHomeCouponModel.StyleBean styleBean;

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_COUPON;
    }

    @Override
    public int layout() {
        return R.layout.main_home_picture;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomeCouponModel data, int position) {
        styleBean = data.getStyle();
        LinearLayout llPicture = helper.getView(R.id.ll_picture);
        RecyclerView mRecyclerView = helper.getView(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, Integer.valueOf(data.getParams().getCouponstyle())));
        PictureAdapter adapter = new PictureAdapter(R.layout.main_home_picture_item, data.getData());
        llPicture.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        // mRecyclerView.setPadding(data.getStyle().getPaddingleft(), data.getStyle().getPaddingtop(), data.getStyle().getPaddingleft(), data.getStyle().getPaddingtop());
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(BaseViewHolder helper, MainHomeCouponModel data, int position) {
        //单击事件
        //Toast.makeText(mContext, "Click: " + data.imgUrl, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, MainHomeCouponModel data, int position) {
        //长按事件
        // Toast.makeText(mContext, "longClick: " + data.imgUrl, Toast.LENGTH_SHORT).show();
        return true;
    }

    public class PictureAdapter extends BaseQuickAdapter<MainHomeCouponModel.DataBean, BaseViewHolder> {
        public PictureAdapter(int layoutResId, List<MainHomeCouponModel.DataBean> data) {
            super(R.layout.main_home_picture_item, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, MainHomeCouponModel.DataBean item) {
            RatioImageView ivPicture = helper.getView(R.id.iv_picture);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(styleBean.getMarginleft(), styleBean.getMarginleft(), styleBean.getMarginleft(), styleBean.getMarginleft());
            ivPicture.setLayoutParams(lp);
            //GImageLoader.displayUrl(mContext, ivPicture, item.getImgurl());
            //ImageLoader.getInstance().displayImage(item.getImgurl(), ivPicture);
//            Glide.with(mContext).load(item.getImgurl())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090*3/4)
//                    .crossFade().into(ivPicture);
            ImageLoader.getInstance().displayImage(item.getImgurl(),ivPicture);
        }
    }
}
