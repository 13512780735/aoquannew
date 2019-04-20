package com.likeit.aqe365.adapter.find;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.DiaryphotoModel;
import com.likeit.aqe365.view.RoundImageView;
import com.likeit.aqe365.view.photoview.ViewPagerActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

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
            RoundImageView iv_Img = helper.getView(R.id.iv_img);
//            linearParams = (RelativeLayout.LayoutParams) iv_Img.getLayoutParams();
//            DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
//            w_screen = (dm.widthPixels - 60) / 4;
//            h_screen = w_screen;
//            iv_Img.setLayoutParams(linearParams);
            ImageLoader.getInstance().displayImage(item, iv_Img);
        }
    }
}