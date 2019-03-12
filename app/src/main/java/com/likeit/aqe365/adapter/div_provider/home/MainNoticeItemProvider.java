package com.likeit.aqe365.adapter.div_provider.home;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.notice.MarqueeViewAdapter;
import com.likeit.aqe365.fragment.main.NoticeDetailDialog;
import com.likeit.aqe365.network.model.home.MainHomeNoticeModel;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.HorizontalTextview;
import com.likeit.aqe365.view.xmarqueeview.XMarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainNoticeItemProvider extends BaseItemProvider<MainHomeNoticeModel, BaseViewHolder> {
    List<MainHomeNoticeModel.DataBean> data1 = new ArrayList<>();
    MainHomeNoticeModel.StyleBean styleBean;
    private XMarqueeView marqueeviewone;
    final List<String> texts = new ArrayList<>();
    MarqueeViewAdapter marqueeViewAdapter;

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_NOTICE;
    }

    @Override
    public int layout() {
        return R.layout.main_home_notice;
    }

    @Override
    public void convert(BaseViewHolder helper, final MainHomeNoticeModel data, int position) {
        data1 = data.getData();
        styleBean = data.getStyle();
        marqueeviewone = helper.getView(R.id.marquee1);
        marqueeViewAdapter = new MarqueeViewAdapter(data1, mContext);


        // marqueeviewone.setAdapter(marqueeViewAdapter);}
        // marqueeviewone.setAdapter(new MarqueeViewAdapter(data1, mContext));
        marqueeviewone.stopFlipping();
        BorderTextView tvTitle = helper.getView(R.id.tv_title);
        LinearLayout llNotice = helper.getView(R.id.ll_notice);
        RelativeLayout rlNotice = helper.getView(R.id.rlNotice);
        HorizontalTextview tvNotice = helper.getView(R.id.tv_notice);
//        rlNotice.setVisibility(View.GONE);
//        tvNotice.setVisibility(View.VISIBLE);
        if ("1".equals(data.getParams().getDirection())) {
            rlNotice.setVisibility(View.VISIBLE);
            tvNotice.setVisibility(View.GONE);
            //  initUI();
            if (marqueeViewAdapter != null) {
                marqueeviewone.setAdapter(marqueeViewAdapter);
            }
        } else {
            rlNotice.setVisibility(View.GONE);
            tvNotice.setVisibility(View.VISIBLE);
        }
        tvNotice.setSelected(true);
        tvNotice.setText(data1.get(0).getTitle());
        tvNotice.setTextColor(Color.parseColor(data.getStyle().getColor()));
        String color1 = data.getStyle().getIconcolor();
        String color = color1.substring(1, color1.length());
      tvTitle.setContentColorResource01(Color.parseColor("#" + "80" + color));
        tvTitle.setTextColor(Color.parseColor(color1));
        llNotice.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        //  rlTitle.setBackgroundTintList(ColorStateList.valueOf(Color.p(0)));
        tvTitle.setText(data.getParams().getDesc());


        tvNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoticeDetailDialog dialog = new NoticeDetailDialog(mContext, data1.get(0).getTitle(), data1.get(0).getContent());
                dialog.show();
            }
        });
    }

    private void initUI() {
        marqueeViewAdapter.setData(data1);

    }

}
