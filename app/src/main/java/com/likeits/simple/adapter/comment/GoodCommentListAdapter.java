package com.likeits.simple.adapter.comment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.network.GoodCommentmodel;
import com.likeits.simple.utils.StringUtil;
import com.likeits.simple.view.RatingBar;
import com.likeits.simple.view.custom_scrollview.HorizontalPageLayoutManager;
import com.likeits.simple.view.custom_scrollview.MyRecyclerView;
import com.likeits.simple.view.custom_scrollview.PagingScrollHelper;
import com.likeits.simple.view.photoview.ViewPagerActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class GoodCommentListAdapter extends BaseQuickAdapter<GoodCommentmodel.ListBean, BaseViewHolder> {

    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private GoodCommentList01Adapter mAdapter;
//    private GoodCommentList02Adapter mAdapter02;
//    private GoodCommentList03Adapter mAdapter03;
//    private GoodCommentList04Adapter mAdapter04;

    public GoodCommentListAdapter(int layoutResId, List<GoodCommentmodel.ListBean> data) {
        super(R.layout.comment_list01, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodCommentmodel.ListBean item) {
        final ArrayList<String> images = (ArrayList<String>) item.getImages();//用户评价
        final ArrayList<String> reply_images =(ArrayList<String>) item.getReply_images();//店铺评价
        final ArrayList<String>append_images =(ArrayList<String>)item.getAppend_images();//用户第二次
        final ArrayList<String> append_reply_images = (ArrayList<String>)item.getAppend_reply_images();//店铺第二次
        ImageLoader.getInstance().displayImage(item.getHeadimgurl(), (ImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_name, item.getNickname());
        helper.setText(R.id.tv_time, item.getCreatetime());
        RatingBar mRatingBar = helper.getView(R.id.ratingbar);
        mRatingBar.setStarEmptyDrawable(mContext.getResources().getDrawable(R.mipmap.star_empty));
        mRatingBar.setStarFillDrawable(mContext.getResources().getDrawable(R.mipmap.star_full));
        mRatingBar.setStarCount(5);
        mRatingBar.setStar(Integer.valueOf(item.getLevel()));
        mRatingBar.halfStar(false);
        mRatingBar.setmClickable(false);
        mRatingBar.setStarImageWidth(30f);
        mRatingBar.setStarImageHeight(30f);
        mRatingBar.setImagePadding(5);
        helper.setText(R.id.tv_content, item.getContent());
        MyRecyclerView mRecyclerView01 = helper.getView(R.id.mRecyclerView01);
        if (images != null) {
            mAdapter = new GoodCommentList01Adapter(R.layout.coment_list_image_items, images);
            mRecyclerView01.setHasFixedSize(true);
            horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 5);
            //滚动adapter
            mRecyclerView01.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            scrollHelper.setUpRecycleView(mRecyclerView01);
            RecyclerView.LayoutManager layoutManager = null;
            layoutManager = horizontalPageLayoutManager;
            if (layoutManager != null) {
                mRecyclerView01.setLayoutManager(layoutManager);
                scrollHelper.updateLayoutManger();
            }
            mAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                  //  Bundle bundle=new Bundle();
                  //  bundle.putParcelableArrayList("items",images);
                    Intent intent=new Intent(mContext, ViewPagerActivity.class);
                    intent.putStringArrayListExtra("items",images);
                    intent.putExtra("currentPosition",position);
                    mContext.startActivity(intent);
                }
            });
        } else {
            mRecyclerView01.setVisibility(View.GONE);
        }
        LinearLayout ll_reply_content = helper.getView(R.id.ll_reply_content);//店铺评论
        TextView tv_reply_content = helper.getView(R.id.tv_reply_content);
        MyRecyclerView mRecyclerView02 = helper.getView(R.id.mRecyclerView02);
        LinearLayout ll_append_content = helper.getView(R.id.ll_append_content);//用户追加评论
        TextView tv_append_content = helper.getView(R.id.tv_append_content);
        MyRecyclerView mRecyclerView03 = helper.getView(R.id.mRecyclerView03);
        LinearLayout ll_append_reply_content = helper.getView(R.id.ll_append_reply_content);//店铺追加评论
        TextView tv_append_reply_content = helper.getView(R.id.tv_append_reply_content);
        MyRecyclerView mRecyclerView04 = helper.getView(R.id.mRecyclerView04);
        if (!StringUtil.isBlank(item.getReply_content())) {
            ll_reply_content.setVisibility(View.VISIBLE);
            tv_reply_content.setText("掌柜回复：" + item.getReply_content());
            if (reply_images != null) {
                mAdapter = new GoodCommentList01Adapter(R.layout.coment_list_image_items, reply_images);
                mRecyclerView02.setHasFixedSize(true);
                horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 5);
                //滚动adapter
                mRecyclerView02.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                scrollHelper.setUpRecycleView(mRecyclerView02);
                RecyclerView.LayoutManager layoutManager = null;
                layoutManager = horizontalPageLayoutManager;
                if (layoutManager != null) {
                    mRecyclerView02.setLayoutManager(layoutManager);
                    scrollHelper.updateLayoutManger();
                }
                mAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        //  Bundle bundle=new Bundle();
                        //  bundle.putParcelableArrayList("items",images);
                        Intent intent=new Intent(mContext, ViewPagerActivity.class);
                        intent.putStringArrayListExtra("items",reply_images);
                        intent.putExtra("currentPosition",position);
                        mContext.startActivity(intent);
                    }
                });
            } else {
                mRecyclerView02.setVisibility(View.GONE);
            }
        } else {
            ll_reply_content.setVisibility(View.GONE);
        }
        if (!StringUtil.isBlank(item.getAppend_content())) {
            ll_append_content.setVisibility(View.VISIBLE);
            tv_append_content.setText(item.getAppend_content());
            if (append_images != null) {
                mAdapter = new GoodCommentList01Adapter(R.layout.coment_list_image_items, append_images);
                mRecyclerView03.setHasFixedSize(true);
                horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 5);
                //滚动adapter
                mRecyclerView03.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                scrollHelper.setUpRecycleView(mRecyclerView03);
                RecyclerView.LayoutManager layoutManager = null;
                layoutManager = horizontalPageLayoutManager;
                if (layoutManager != null) {
                    mRecyclerView03.setLayoutManager(layoutManager);
                    scrollHelper.updateLayoutManger();
                }
                mAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        //  Bundle bundle=new Bundle();
                        //  bundle.putParcelableArrayList("items",images);
                        Intent intent=new Intent(mContext, ViewPagerActivity.class);
                        intent.putStringArrayListExtra("items",append_images);
                        intent.putExtra("currentPosition",position);
                        mContext.startActivity(intent);
                    }
                });
            } else {
                mRecyclerView03.setVisibility(View.GONE);
            }
        } else {
            ll_append_content.setVisibility(View.GONE);
        }
        if (!StringUtil.isBlank(item.getAppend_reply_content())) {
            ll_append_reply_content.setVisibility(View.VISIBLE);
            tv_append_reply_content.setText("掌柜追加回复：" + item.getAppend_reply_content());
            if (append_reply_images != null) {
                mAdapter = new GoodCommentList01Adapter(R.layout.coment_list_image_items, append_reply_images);
                mRecyclerView04.setHasFixedSize(true);
                horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 5);
                //滚动adapter
                mRecyclerView04.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                scrollHelper.setUpRecycleView(mRecyclerView04);
                RecyclerView.LayoutManager layoutManager = null;
                layoutManager = horizontalPageLayoutManager;
                if (layoutManager != null) {
                    mRecyclerView04.setLayoutManager(layoutManager);
                    scrollHelper.updateLayoutManger();
                }
                mAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        //  Bundle bundle=new Bundle();
                        //  bundle.putParcelableArrayList("items",images);
                        Intent intent=new Intent(mContext, ViewPagerActivity.class);
                        intent.putStringArrayListExtra("items",append_reply_images);
                        intent.putExtra("currentPosition",position);
                        mContext.startActivity(intent);
                    }
                });
            } else {
                mRecyclerView04.setVisibility(View.GONE);
            }
        } else {
            ll_append_reply_content.setVisibility(View.GONE);
        }
    }

    public class GoodCommentList01Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public GoodCommentList01Adapter(int layoutResId, List<String> data) {
            super(R.layout.coment_list_image_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            ImageLoader.getInstance().displayImage(item, (ImageView) helper.getView(R.id.iv_pic));
        }
    }

//    public class GoodCommentList02Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
//        public GoodCommentList02Adapter(int layoutResId, List<String> data) {
//            super(R.layout.coment_list_image_items, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, String item) {
//            ImageLoader.getInstance().displayImage(item, (ImageView) helper.getView(R.id.iv_pic));
//        }
//    }
//
//    public class GoodCommentList03Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
//        public GoodCommentList03Adapter(int layoutResId, List<String> data) {
//            super(R.layout.coment_list_image_items, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, String item) {
//            ImageLoader.getInstance().displayImage(item, (ImageView) helper.getView(R.id.iv_pic));
//        }
//    }
//
//    public class GoodCommentList04Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
//        public GoodCommentList04Adapter(int layoutResId, List<String> data) {
//            super(R.layout.coment_list_image_items, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, String item) {
//            ImageLoader.getInstance().displayImage(item, (ImageView) helper.getView(R.id.iv_pic));
//        }
//    }
}
