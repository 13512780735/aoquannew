package com.likeits.simple.adapter.div_provider.home;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeits.simple.R;
import com.likeits.simple.adapter.notice.MarqueeViewAdapter;
import com.likeits.simple.fragment.main.NoticeDetailDialog;
import com.likeits.simple.network.model.home.MainHomeNoticeModel;
import com.likeits.simple.view.HorizontalTextview;
import com.likeits.simple.view.xmarqueeview.XMarqueeView;

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
        TextView tvTitle = helper.getView(R.id.tv_title);
        LinearLayout rlTitle = helper.getView(R.id.rl_title);
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
        llNotice.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        rlTitle.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(data.getStyle().getIconcolor())));
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
