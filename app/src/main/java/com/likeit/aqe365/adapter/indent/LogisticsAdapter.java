package com.likeit.aqe365.adapter.indent;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.Indent.ExpressModel;

import java.util.List;

public class LogisticsAdapter extends RecyclerView.Adapter<LogisticsAdapter.TraceViewHolder> {

    private static final int TYPE_CURR = 0; //当前
    private static final int TYPE_NORMAL = 1; //历史记录
    private Context mContext;
    private List<ExpressModel.ExpresslistBean> mList;
    private LayoutInflater inflater;

    public LogisticsAdapter(Context mContext, List<ExpressModel.ExpresslistBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public TraceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TraceViewHolder(inflater.inflate(R.layout.item_trace, parent, false));
    }

    @Override
    public void onBindViewHolder(TraceViewHolder holder, int position) {
        //设置相关数据
        ExpressModel.ExpresslistBean trace = mList.get(position);
        int type = Integer.valueOf(trace.getDefined());
        if (type == TYPE_CURR) {
            holder.acceptStationTv.setTextColor(mContext.getResources().getColor(R.color.theme_bg_tex));

            holder.acceptTimeTv.setTextColor(mContext.getResources().getColor(R.color.theme_bg_tex));
            holder.dotIv.setImageResource(R.mipmap.dot_red);
            holder.dotIv.setPadding(0,10,0,0);
        } else if (type == TYPE_NORMAL) {
            holder.acceptStationTv.setTextColor(Color.parseColor("#999999"));
            holder.acceptTimeTv.setTextColor(Color.parseColor("#999999"));
            holder.dotIv.setImageResource(R.mipmap.dot_black);
        }
        holder.acceptTimeTv.setText(trace.getTime());
        holder.acceptStationTv.setText(trace.getStep());
        if (position == mList.size() - 1) {
            //最后一条数据，隐藏时间轴的竖线和水平的分割线
            holder.timeLineView.setVisibility(View.INVISIBLE);
            holder.dividerLineView.setVisibility(View.INVISIBLE);
        }
    }


    public class TraceViewHolder extends RecyclerView.ViewHolder {

        private TextView acceptTimeTv;  //接收时间
        private TextView acceptStationTv;  //接收地点
        private ImageView dotIv; //当前位置
        private View dividerLineView; //时间轴的竖线
        private View timeLineView; //水平的分割线


        public TraceViewHolder(View itemView) {
            super(itemView);
            acceptTimeTv = (TextView) itemView.findViewById(R.id.accept_time_tv);
            acceptStationTv = (TextView) itemView.findViewById(R.id.accept_station_tv);
            dotIv = (ImageView) itemView.findViewById(R.id.dot_iv);
            dividerLineView = itemView.findViewById(R.id.divider_line_view);
            timeLineView = itemView.findViewById(R.id.time_line_view);
        }
    }
}
