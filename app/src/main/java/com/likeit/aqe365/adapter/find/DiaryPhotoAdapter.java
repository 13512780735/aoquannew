package com.likeit.aqe365.adapter.find;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.DiaryphotoModel;
import com.likeit.aqe365.utils.GlideRoundTransform;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.RoundImageView;
import com.likeit.aqe365.view.photoview.ViewPagerActivity;

import java.util.ArrayList;
import java.util.List;

public class DiaryPhotoAdapter extends BaseQuickAdapter<DiaryphotoModel.ListBean, BaseViewHolder> {
    private RecyclerView mRecyclerView;
    private RelativeLayout.LayoutParams linearParams;
    private int w_screen;
    private int h_screen;

    public DiaryPhotoAdapter(int layoutResId, @Nullable List<DiaryphotoModel.ListBean> data) {
        super(R.layout.diary_photo_items, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DiaryphotoModel.ListBean item) {
        mRecyclerView = helper.getView(R.id.mRecyclerView);
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_days, item.getDay());
        final List<String> data = item.getImages();
        DiaryPhotoItemAdapter mAdapter = new DiaryPhotoItemAdapter(R.layout.diary_photo_items_img, data);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, ViewPagerActivity.class);
                intent.putStringArrayListExtra("items", (ArrayList<String>) data);
                intent.putExtra("currentPosition", position);
                mContext.startActivity(intent);
            }
        });
    }

    public class DiaryPhotoItemAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public DiaryPhotoItemAdapter(int layoutResId, @Nullable List<String> data) {
            super(R.layout.diary_photo_items_img, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            ImageLoaderUtils mImageLoader = ImageLoaderUtils.getInstance(mContext);

            RoundImageView iv_Img = helper.getView(R.id.iv_img);
//            linearParams = (RelativeLayout.LayoutParams) iv_Img.getLayoutParams();
//            DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
//            w_screen = (dm.widthPixels - 60) / 4;
//            h_screen = w_screen;
//            iv_Img.setLayoutParams(linearParams);
         //   mImageLoader.displayImage(item, iv_Img);

            Glide.with(mContext)
                    .load(item)
                    .override(600, 600)
                    .animate(R.anim.item_alpha_in)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)

                    .transform(new CenterCrop(mContext), new GlideRoundTransform(mContext,10))
                    .skipMemoryCache(true)
                    .priority(Priority.HIGH)
                    .placeholder(R.mipmap.default_pic).error(R.mipmap.default_pic).into(iv_Img);
        }
    }
}
