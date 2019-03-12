package com.likeit.aqe365.adapter.notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.likeit.aqe365.R;
import com.likeit.aqe365.fragment.main.NoticeDetailDialog;
import com.likeit.aqe365.network.model.home.MainHomeNoticeModel;
import com.likeit.aqe365.view.xmarqueeview.XMarqueeView;
import com.likeit.aqe365.view.xmarqueeview.XMarqueeViewAdapter;

import java.util.List;

/**
 * @author: xiaohaibin.
 * @time: 2018/6/6
 * @mail:xhb_199409@163.com
 * @github:https://github.com/xiaohaibin
 * @describe: 创建MarqueeView适配器
 */
public class MarqueeViewAdapter extends XMarqueeViewAdapter<MainHomeNoticeModel.DataBean> {

    private Context mContext;

    public MarqueeViewAdapter(List<MainHomeNoticeModel.DataBean> datas, Context context) {
        super(datas);
        mContext = context;
    }

    @Override
    public View onCreateView(XMarqueeView parent) {
        //跑马灯单个显示条目布局，自定义
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.marqueeview_item, null);
    }

    @Override
    public void onBindView(View parent, View view, final int position) {
        //布局内容填充
        TextView tvOne = (TextView) view.findViewById(R.id.marquee_tv_one);
        tvOne.setText(mDatas.get(position).getTitle());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(mContext, "点击了第" + (index + 1) + "个TextView", Toast.LENGTH_SHORT).show();
                NoticeDetailDialog dialog = new NoticeDetailDialog(mContext, mDatas.get(position).getTitle(), mDatas.get(position).getContent());
                dialog.show();
            }
        });
    }
}
