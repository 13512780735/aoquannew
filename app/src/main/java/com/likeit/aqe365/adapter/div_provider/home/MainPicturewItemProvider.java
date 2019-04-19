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
import com.likeit.aqe365.network.model.home.MainHomePicturewModel;
import com.likeit.aqe365.view.RatioImageView;

import java.util.List;


public class MainPicturewItemProvider extends BaseItemProvider<MainHomePicturewModel, BaseViewHolder> {

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_PICTUREW;
    }

    @Override
    public int layout() {
        return R.layout.main_home_picture;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomePicturewModel data, int position) {
        LinearLayout llPicture = helper.getView(R.id.ll_picture);
        RecyclerView mRecyclerView = helper.getView(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,Integer.valueOf(data.getParams().getRow())));
        PictureAdapter adapter = new PictureAdapter(R.layout.main_home_picturew_item, data.getData());
        llPicture.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        mRecyclerView.setPadding(data.getStyle().getPaddingleft(), data.getStyle().getPaddingtop(), data.getStyle().getPaddingleft(), data.getStyle().getPaddingtop());
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(BaseViewHolder helper, MainHomePicturewModel data, int position) {
        //单击事件
        //Toast.makeText(mContext, "Click: " + data.imgUrl, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, MainHomePicturewModel data, int position) {
        //长按事件
        // Toast.makeText(mContext, "longClick: " + data.imgUrl, Toast.LENGTH_SHORT).show();
        return true;
    }

    public class PictureAdapter extends BaseQuickAdapter<MainHomePicturewModel.DataBean, BaseViewHolder> {
        public PictureAdapter(int layoutResId, List<MainHomePicturewModel.DataBean> data) {
            super(R.layout.main_home_picturew_item, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, MainHomePicturewModel.DataBean item) {
            RatioImageView ivPicture = helper.getView(R.id.iv_picture);
            //GImageLoader.displayUrl(mContext, ivPicture, item.getImgurl());
            Glide.with(mContext).load(item.getImgurl())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(R.mipmap.default_pic)
                    .error(R.mipmap.default_pic)
                    .centerCrop().override(1090, 1090*3/4)
                    .crossFade().into(ivPicture);
        }
    }
}
