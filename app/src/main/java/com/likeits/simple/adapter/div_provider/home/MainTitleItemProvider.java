package com.likeits.simple.adapter.div_provider.home;

import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.network.model.home.MainHomeTitleModel;


public class MainTitleItemProvider extends BaseItemProvider<MainHomeTitleModel, BaseViewHolder> {

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_TITLE;
    }

    @Override
    public int layout() {
        return R.layout.main_home_title;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomeTitleModel data, int position) {
        TextView tvTitle = helper.getView(R.id.tv_title);
        tvTitle.setTextSize(data.getStyle().getFontsize() / 2);
        if ("center".equals(data.getStyle().getTextalign())) {
            tvTitle.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL);
        } else if ("left".equals(data.getStyle().getTextalign())) {
            tvTitle.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        } else if ("right".equals(data.getStyle().getTextalign())) {
            tvTitle.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        }
        tvTitle.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        tvTitle.setText(data.getParams().getTitle());
        tvTitle.setTextColor(Color.parseColor(data.getStyle().getColor()));
        tvTitle.setPadding(data.getStyle().getPaddingleft(), data.getStyle().getPaddingtop(), data.getStyle().getPaddingleft(), data.getStyle().getPaddingtop());
    }


    @Override
    public void onClick(BaseViewHolder helper, MainHomeTitleModel data, int position) {
        //单击事件
        //Toast.makeText(mContext, "Click: " + data.imgUrl, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, MainHomeTitleModel data, int position) {
        //长按事件
        // Toast.makeText(mContext, "longClick: " + data.imgUrl, Toast.LENGTH_SHORT).show();
        return true;
    }
}
