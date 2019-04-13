package com.likeit.aqe365.adapter.find;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.view.RoundImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class AllFind03Adapter extends BaseQuickAdapter<BoardListModel.ListBean, BaseViewHolder> {
    public AllFind03Adapter(int layoutResId, List<BoardListModel.ListBean> data) {
        super(R.layout.boradlist_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BoardListModel.ListBean item) {
        helper.setText(R.id.tv_title,"#"+item.getTitle());
        helper.setText(R.id.tv_desc,item.getDesc());
        helper.setText(R.id.tv_participant,item.getParticipant()+"人");
        helper.setText(R.id.postcount,item.getPostcount()+"帖子");
        ImageLoader.getInstance().displayImage(item.getLogo(), (RoundImageView) helper.getView(R.id.iv_img));
    }
}
