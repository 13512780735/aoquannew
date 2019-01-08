package com.likeits.simple.adapter.div_provider.good;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.adapter.comment.GoodCommentListAdapter;
import com.likeits.simple.network.model.gooddetails.GoodDetailCommentItemModel;
import com.likeits.simple.view.RatingBar;
import com.likeits.simple.view.custom_scrollview.HorizontalPageLayoutManager;
import com.likeits.simple.view.custom_scrollview.MyRecyclerView;
import com.likeits.simple.view.custom_scrollview.PagingScrollHelper;
import com.likeits.simple.view.photoview.ViewPagerActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class GoodDetailCommentItemProvider extends BaseItemProvider<GoodDetailCommentItemModel, BaseViewHolder> {
    private List<GoodDetailCommentItemModel.DataBean.CommentBean.ListBean> listBean;
    private GoodCommentList01Adapter mAdapter;
    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();

    @Override
    public int viewType() {
        return GoodDetailAdapter.TYPE_DETAILS_COMMENT;
    }

    @Override
    public int layout() {
        return R.layout.good_details_comment_items;
    }

    @Override
    public void convert(BaseViewHolder helper, GoodDetailCommentItemModel data, int position) {
        listBean = data.getData().getComment().getList();
        TextView tv_number = helper.getView(R.id.tv_number);
        TextView tv_percent = helper.getView(R.id.tv_percent);
        TextView tv_all = helper.getView(R.id.tv_all);
        MyRecyclerView mRecyclerView = helper.getView(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setHasFixedSize(true);
        tv_number.setText("评价 (" + data.getParams().getNum() + ")");
        tv_percent.setText(data.getData().getComment().getPercent() + "%");
        GoodCommentAdapter mAdapter = new GoodCommentAdapter(R.layout.good_details_comment_items_view, listBean);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


    }

    public class GoodCommentAdapter extends BaseQuickAdapter<GoodDetailCommentItemModel.DataBean.CommentBean.ListBean, BaseViewHolder> {
        public GoodCommentAdapter(int layoutResId, List<GoodDetailCommentItemModel.DataBean.CommentBean.ListBean> data) {
            super(R.layout.good_details_comment_items_view, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, GoodDetailCommentItemModel.DataBean.CommentBean.ListBean item) {
            final ArrayList<String> images = (ArrayList<String>) item.getImages();
            TextView tv_content = helper.getView(R.id.tv_content);
            TextView tv_time = helper.getView(R.id.tv_time);
            RatingBar mRatingBar = helper.getView(R.id.ratingbar);
            tv_content.setText(item.getContent());
            tv_time.setText("用户 " + item.getNickname() + "  " + item.getCreatetime());
            mRatingBar.setStarEmptyDrawable(mContext.getResources().getDrawable(R.mipmap.star_empty));
            //  mRatingBar.setStarHalfDrawable(mContext.getResources().getDrawable(R.mipmap.star_half));
            mRatingBar.setStarFillDrawable(mContext.getResources().getDrawable(R.mipmap.star_full));
            mRatingBar.setStarCount(5);
            mRatingBar.setStar(Integer.valueOf(item.getLevel()));
            mRatingBar.halfStar(false);
            mRatingBar.setmClickable(false);
            mRatingBar.setStarImageWidth(30f);
            mRatingBar.setStarImageHeight(30f);
            mRatingBar.setImagePadding(5);
            mRatingBar.setOnRatingChangeListener(
                    new RatingBar.OnRatingChangeListener() {
                        @Override
                        public void onRatingChange(float RatingCount) {
                        }
                    }
            );

            MyRecyclerView mRecyclerView01 = helper.getView(R.id.mRecyclerView);
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
            } else {
                mRecyclerView01.setVisibility(View.GONE);
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
}
