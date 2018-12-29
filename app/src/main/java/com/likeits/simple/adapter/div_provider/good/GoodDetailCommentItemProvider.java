package com.likeits.simple.adapter.div_provider.good;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.network.model.gooddetails.GoodDetailCommentItemModel;
import com.likeits.simple.view.RatingBar;
import com.likeits.simple.view.custom_scrollview.MyRecyclerView;

import java.util.List;

public class GoodDetailCommentItemProvider extends BaseItemProvider<GoodDetailCommentItemModel, BaseViewHolder> {
    private List<GoodDetailCommentItemModel.DataBean.CommentBean.ListBean> listBean;

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
        }
    }
}
