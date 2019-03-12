package com.likeit.aqe365.adapter.div_provider.home;


import android.graphics.Color;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.home.MainHomeBlankModel;


public class MainBlankItemProvider extends BaseItemProvider<MainHomeBlankModel, BaseViewHolder> {

    private LinearLayout llBlank;

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_BLANK;
    }

    @Override
    public int layout() {
        return R.layout.main_home_blank;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomeBlankModel data, int position) {
        llBlank = helper.getView(R.id.ll_blank);
        llBlank.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) llBlank.getLayoutParams();
        linearParams.height = Integer.valueOf(data.getStyle().getHeight());
        llBlank.setLayoutParams(linearParams);
    }


    @Override
    public void onClick(BaseViewHolder helper, MainHomeBlankModel data, int position) {
        //单击事件
        //Toast.makeText(mContext, "Click: " + data.imgUrl, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, MainHomeBlankModel data, int position) {
        //长按事件
        // Toast.makeText(mContext, "longClick: " + data.imgUrl, Toast.LENGTH_SHORT).show();
        return true;
    }
}
