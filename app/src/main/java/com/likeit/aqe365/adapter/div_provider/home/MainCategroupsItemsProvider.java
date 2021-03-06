package com.likeit.aqe365.adapter.div_provider.home;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.home.MainHomeCategroupsModel;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.utils.IntentUtils;
import com.likeit.aqe365.view.RatioImageView;

import java.util.List;


public class MainCategroupsItemsProvider extends BaseItemProvider<MainHomeCategroupsModel, BaseViewHolder> {
    private MainHomeCategroupsModel.StyleBean styleBean;

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_CATEGROUPS;
    }

    @Override
    public int layout() {
        return R.layout.main_home_categroup;
    }

    @Override
    public void convert(BaseViewHolder helper, final MainHomeCategroupsModel data, int position) {
        styleBean = data.getStyle();
        RecyclerView mRecyclerView = helper.getView(R.id.mRecyclerView);
        mRecyclerView.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        MainCateGroupAdapter mAdapter = new MainCateGroupAdapter(R.layout.main_home_categroup_items, data.getData());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String id = data.getData().get(position).getParams().getId();
                String linkurl = data.getData().get(position).getLinkurl();
                String webUrl = data.getData().get(position).getWeburl();
                IntentUtils.intentTo(mContext, linkurl, id, webUrl);
            }
        });

    }

    public class MainCateGroupAdapter extends BaseQuickAdapter<MainHomeCategroupsModel.DataBean, BaseViewHolder> {

        public MainCateGroupAdapter(int layoutResId, List<MainHomeCategroupsModel.DataBean> data) {
            super(R.layout.main_home_categroup_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, MainHomeCategroupsModel.DataBean item) {
            ImageLoaderUtils mImageLoader = ImageLoaderUtils.getInstance(mContext);
            TextView tvName = helper.getView(R.id.tv_name);
            LinearLayout llbg = helper.getView(R.id.ll_categroup_bg);
            llbg.setBackgroundColor(Color.parseColor(styleBean.getBg()));
            tvName.setTextColor(Color.parseColor(styleBean.getColor()));
            tvName.setText(item.getTitle());
            if (item.getData().size() == 1) {
//                Glide.with(mContext).load(item.getData().get(0))
//                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                        .placeholder(R.mipmap.default_pic)
//                        .error(R.mipmap.default_pic)
//                        .centerCrop().override(1090, 1090*3/4)
//                        .crossFade().into( (RatioImageView) helper.getView(R.id.iv01));
              //  mImageLoader.displayImage(item.getData().get(0),(RatioImageView) helper.getView(R.id.iv01));
                Glide.with(mContext)
                        .load(item.getData().get(0))
                        .override(600, 600)
                        .animate(R.anim.item_alpha_in)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .skipMemoryCache(true)
                        .priority(Priority.HIGH)
                        .placeholder(R.mipmap.default_pic).error(R.mipmap.default_pic).into( (RatioImageView) helper.getView(R.id.iv01));
            } else if (item.getData().size() == 2) {
//                Glide.with(mContext).load(item.getData().get(0))
//                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                        .placeholder(R.mipmap.default_pic)
//                        .error(R.mipmap.default_pic)
//                        .centerCrop().override(1090, 1090*3/4)
//                        .crossFade().into( (RatioImageView) helper.getView(R.id.iv01));
               // mImageLoader.displayImage(item.getData().get(0),(RatioImageView) helper.getView(R.id.iv01));
                Glide.with(mContext)
                        .load(item.getData().get(0))
                        .override(600, 600)
                        .animate(R.anim.item_alpha_in)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .skipMemoryCache(true)
                        .priority(Priority.HIGH)
                        .placeholder(R.mipmap.default_pic).error(R.mipmap.default_pic).into( (RatioImageView) helper.getView(R.id.iv01));
                Glide.with(mContext)
                        .load(item.getData().get(1))
                        .override(600, 600)
                        .animate(R.anim.item_alpha_in)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .skipMemoryCache(true)
                        .priority(Priority.HIGH)
                        .placeholder(R.mipmap.default_pic).error(R.mipmap.default_pic).into( (RatioImageView) helper.getView(R.id.iv02));
              //  mImageLoader.displayImage(item.getData().get(1),(RatioImageView) helper.getView(R.id.iv02));
//                Glide.with(mContext).load(item.getData().get(1))
//                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                        .placeholder(R.mipmap.default_pic)
//                        .error(R.mipmap.default_pic)
//                        .centerCrop().override(1090, 1090*3/4)
//                        .crossFade().into( (RatioImageView) helper.getView(R.id.iv02));
            } else {
                helper.getView(R.id.iv01).setVisibility(View.GONE);
                helper.getView(R.id.iv02).setVisibility(View.GONE);
            }
        }
    }
}
