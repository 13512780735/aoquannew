package com.likeit.aqe365.adapter.message;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.member.NoticeListModel;
import com.zzhoujay.richtext.RichText;

import java.util.List;

public class Message05adapter extends BaseQuickAdapter<NoticeListModel.ListBean, BaseViewHolder> {
    public Message05adapter(int layoutResId, List<NoticeListModel.ListBean> data) {
        super(R.layout.message_05_itms, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NoticeListModel.ListBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_time, item.getCreatetime());
        RichText.from(item.getContent()).into((TextView) helper.getView(R.id.tv_content));
    }
}
