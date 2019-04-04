package com.likeit.aqe365.adapter.find;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.UserListModel;
import com.likeit.aqe365.view.CircleImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class AllFind05Adapter extends BaseQuickAdapter<UserListModel.ListBean, BaseViewHolder> {
    public AllFind05Adapter(int layoutResId, List<UserListModel.ListBean> data) {
        super(R.layout.find_user_listitem, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserListModel.ListBean item) {
        ImageLoader.getInstance().displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_title, item.getNickname());
        helper.setText(R.id.tv_content, item.getJournal_num() + " 日记" + item.getPost_num() + " 帖子");
        helper.setText(R.id.tv_distance, item.getCoordinate());
    }
}
