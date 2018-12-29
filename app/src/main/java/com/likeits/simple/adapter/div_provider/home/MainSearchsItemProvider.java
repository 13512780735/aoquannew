package com.likeits.simple.adapter.div_provider.home;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.network.model.home.MainHomeSearch01Model;
import com.likeits.simple.utils.StringUtil;

public class MainSearchsItemProvider extends BaseItemProvider<MainHomeSearch01Model, BaseViewHolder> {
    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_SEARCHS;
    }

    @Override
    public int layout() {
        return R.layout.main_home_search01;
    }

    @SuppressLint("NewApi")
    @Override
    public void convert(BaseViewHolder helper, MainHomeSearch01Model data, int position) {
        Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        LinearLayout llSearchbg = helper.getView(R.id.ll_search_bg);//背景
        LinearLayout llSearch = helper.getView(R.id.search_layout);//搜索框
        TextView tvContent = helper.getView(R.id.search_content_et);//搜索框内容
        TextView tvPic = helper.getView(R.id.tv_search_pic);//搜索框内容
        tvContent.setText(data.getParams().getPlaceholder());
        tvContent.setHintTextColor(Color.parseColor(data.getStyle().getColor()));
        tvPic.setTypeface(iconTypeface);
        tvPic.setText(StringUtil.decode("\\u" + "e6ac"));
        tvPic.setTextColor(Color.parseColor(data.getStyle().getIconcolor()));
        llSearchbg.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        if ("".equals(data.getStyle().getSearchstyle())) {
            llSearch.setBackground(mContext.getResources().getDrawable(R.drawable.shape_search_round_0));
        } else if ("round".equals(data.getStyle().getSearchstyle())) {
            llSearch.setBackground(mContext.getResources().getDrawable(R.drawable.shape_search_round_20));
        } else if ("circle".equals(data.getStyle().getSearchstyle())) {
            llSearch.setBackground(mContext.getResources().getDrawable(R.drawable.shape_search_round_10));
        }
        llSearch.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(data.getStyle().getInputbackground())));
        llSearch.setPadding(data.getStyle().getPaddingleft(),data.getStyle().getPaddingtop(),data.getStyle().getPaddingleft(),data.getStyle().getPaddingtop());
    }
}
