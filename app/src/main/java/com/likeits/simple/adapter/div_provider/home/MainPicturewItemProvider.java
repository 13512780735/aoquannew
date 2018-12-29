package com.likeits.simple.adapter.div_provider.home;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.network.model.home.MainHomePicturewModel;
import com.likeits.simple.view.RatioImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

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
            ImageLoader.getInstance().displayImage(item.getImgurl(),ivPicture);
        }
    }
}
