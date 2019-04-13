package com.likeit.aqe365.adapter.message;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.member.MessageListModel;
import com.likeit.aqe365.view.CircleImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MessageListAdapter extends BaseQuickAdapter<MessageListModel.ListBean, BaseViewHolder> {
    public MessageListAdapter(int layoutResId, List<MessageListModel.ListBean> data) {
        super(R.layout.message_list_items, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageListModel.ListBean item) {
        ImageLoader.getInstance().displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_name, item.getNickname());
        helper.setText(R.id.tv_time, item.getCreatetime());
        helper.setText(R.id.tv_content, item.getContent());
        helper.setText(R.id.tv_at, item.getAt());
        ImageLoader.getInstance().displayImage(item.getArticle().getImage(), (ImageView) helper.getView(R.id.iv_avatar01));
        helper.setText(R.id.tv_title, item.getArticle().getNickname());
        helper.setText(R.id.tv_content01, item.getArticle().getContent());
    }
}
