package com.likeit.aqe365.adapter.find;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.network.model.find.FollowlistModel;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.NineGridTestLayout;
import com.likeit.aqe365.view.RoundImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class AllFind02Adapter extends BaseQuickAdapter<FollowlistModel.ListBean, BaseViewHolder> {
    private NineGridTestLayout layout;

    public AllFind02Adapter(int layoutResId, List<FollowlistModel.ListBean> data) {
        super(R.layout.followlist_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FollowlistModel.ListBean item) {
        ImageLoader.getInstance().displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_title, item.getNickname());
        helper.setText(R.id.tv_content, item.getContent());
        helper.setText(R.id.tv_time, item.getCreatetime());
        helper.setText(R.id.tv_number, item.getViews());
        helper.setText(R.id.tv_huati, item.getHuati());
        layout = (NineGridTestLayout) helper.getView(R.id.layout_nine_grid);
        layout.setIsShowAll(item.isShowAll);
        layout.setUrlList(item.images);


    }
}
