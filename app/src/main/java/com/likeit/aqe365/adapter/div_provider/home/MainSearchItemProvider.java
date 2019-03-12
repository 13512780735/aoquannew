package com.likeit.aqe365.adapter.div_provider.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.SearchLayoutActivity;
import com.likeit.aqe365.network.model.home.MainHomeSearchModel;
import com.likeit.aqe365.utils.StringUtil;


public class MainSearchItemProvider extends BaseItemProvider<MainHomeSearchModel, BaseViewHolder> {

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_SEARCH;
    }

    @Override
    public int layout() {
        return R.layout.main_home_search;
    }

    @SuppressLint("NewApi")
    @Override
    public void convert(BaseViewHolder helper, MainHomeSearchModel data, int position) {
        Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
        LinearLayout llSearchbg = helper.getView(R.id.ll_search_bg);//背景
        LinearLayout llSearch = helper.getView(R.id.search_layout);//搜索框
        TextView tvContent = helper.getView(R.id.search_content_et);//搜索框内容
        TextView tvLeft = helper.getView(R.id.tv_left);//左按钮
        TextView tvRight = helper.getView(R.id.tv_right);//右按钮
        llSearchbg.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        if ("".equals(data.getParams().getSearchstyle())) {
            llSearch.setBackground(mContext.getResources().getDrawable(R.drawable.shape_search_round_0));
        } else if ("round".equals(data.getParams().getSearchstyle())) {
            llSearch.setBackground(mContext.getResources().getDrawable(R.drawable.shape_search_round_20));
        } else if ("circle".equals(data.getParams().getSearchstyle())) {
            llSearch.setBackground(mContext.getResources().getDrawable(R.drawable.shape_search_round_10));
        }

        llSearch.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(data.getStyle().getSearchbackground())));
        tvContent.setHintTextColor(Color.parseColor(data.getStyle().getSearchtextcolor()));
        tvContent.setText(data.getParams().getPlaceholder());
        tvLeft.setTypeface(iconTypeface);
        tvRight.setTypeface(iconTypeface);
        if ("0".equals(data.getParams().getLeftnav())) {
            tvLeft.setVisibility(View.GONE);
        } else {
            tvLeft.setVisibility(View.VISIBLE);
        }
        if ("0".equals(data.getParams().getRightnav())) {
            tvRight.setVisibility(View.GONE);
        } else {
            tvRight.setVisibility(View.VISIBLE);
        }
        tvLeft.setTextColor(Color.parseColor(data.getStyle().getLeftnavcolor()));
        tvRight.setTextColor(Color.parseColor(data.getStyle().getRightnavcolor()));
        tvLeft.setText(StringUtil.decode("\\u" + data.getParams().getLeftnaviconcode()));
        tvRight.setText(StringUtil.decode("\\u" + data.getParams().getRightnaviconcode()));
        llSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, SearchLayoutActivity.class);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(BaseViewHolder helper, MainHomeSearchModel data, int position) {
        //单击事件
        //Toast.makeText(mContext, "Click: " + data.imgUrl, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, MainHomeSearchModel data, int position) {
        //长按事件
        // Toast.makeText(mContext, "longClick: " + data.imgUrl, Toast.LENGTH_SHORT).show();
        return true;
    }
}
