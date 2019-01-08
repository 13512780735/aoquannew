package com.likeits.simple.adapter.div_provider.member;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.adapter.div_provider.home.MainGoodsItemProvider;
import com.likeits.simple.network.model.member.MemberIconGroupItemModel;
import com.likeits.simple.utils.IntentUtils;
import com.likeits.simple.utils.StringUtil;
import com.likeits.simple.utils.ToastUtils;
import com.likeits.simple.view.custom_scrollview.HorizontalPageLayoutManager;
import com.likeits.simple.view.custom_scrollview.MyRecyclerView;
import com.likeits.simple.view.custom_scrollview.PagingScrollHelper;
import com.likeits.simple.view.tablayout.bean.CustomTabEntity;
import com.likeits.simple.view.tablayout.bean.TabEntity;
import com.likeits.simple.view.tablayout.listener.OnTabSelectListener;
import com.likeits.simple.view.tablayout.utils.SoundPlayUtils;
import com.likeits.simple.view.tablayout.utils.UnreadMsgUtils;
import com.likeits.simple.view.tablayout.widget.CommonTabLayout;
import com.likeits.simple.view.tablayout.widget.MsgView;

import java.util.ArrayList;
import java.util.List;

public class MemberIconGroupItemProvider extends BaseItemProvider<MemberIconGroupItemModel, BaseViewHolder> {
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    private MemberIconGroupAdapter mAdapter;
    private MemberIconGroupItemModel.StyleBean styleBean;

    @Override
    public int viewType() {
        return MemberAdapter.TYPE_ICONGROUP;
    }

    @Override
    public int layout() {
        return R.layout.member_icongroup_item;
    }

    @Override
    public void convert(BaseViewHolder helper, final MemberIconGroupItemModel data, int position) {
        styleBean = data.getStyle();
        int columns = data.getData().size();
        MyRecyclerView mRecycleView = helper.getView(R.id.mRecyclerView);
        mRecycleView.setBackgroundColor(Color.parseColor(data.getStyle().getBackground()));
        mAdapter = new MemberIconGroupAdapter(R.layout.member_icongroup_item_item, data.getData());
        horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, columns);
        //滚动adapter
        mRecycleView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        scrollHelper.setUpRecycleView(mRecycleView);
        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = horizontalPageLayoutManager;
        if (layoutManager != null) {
            mRecycleView.setLayoutManager(layoutManager);
            scrollHelper.updateLayoutManger();
        }
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String linkurl = data.getData().get(position).getLinkurl();
                String id = data.getData().get(position).getParams().getId();
                IntentUtils.intentTo(mContext, linkurl, id);
            }
        });

    }

    public class MemberIconGroupAdapter extends BaseQuickAdapter<MemberIconGroupItemModel.DataBean, BaseViewHolder> {
        public MemberIconGroupAdapter(int layoutResId, List<MemberIconGroupItemModel.DataBean> data) {
            super(R.layout.member_icongroup_item_item, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, MemberIconGroupItemModel.DataBean item) {
            Typeface iconTypeface = Typeface.createFromAsset(mContext.getAssets(), "iconfont.ttf");
            TextView iv_tab_icon = helper.getView(R.id.iv_tab_icon);
            MsgView rtv_msg_tip = helper.getView(R.id.rtv_msg_tip);
            TextView tv_tab_title = helper.getView(R.id.tv_tab_title);
            tv_tab_title.setTextColor(Color.parseColor(styleBean.getTextcolor()));
            iv_tab_icon.setTextColor(Color.parseColor(styleBean.getIconcolor()));
            rtv_msg_tip.setBackgroundColor(Color.parseColor(styleBean.getDotcolor()));
            rtv_msg_tip.setTextColor(Color.parseColor("#FFFFFF"));
            tv_tab_title.setText(item.getText());
            iv_tab_icon.setTypeface(iconTypeface);
            iv_tab_icon.setText(StringUtil.decode("\\u" + item.getIconclasscode()));
            int num = Integer.valueOf(item.getDotnum());
            if (num == 0) {
                rtv_msg_tip.setVisibility(View.GONE);
            } else {
                rtv_msg_tip.setVisibility(View.VISIBLE);
                rtv_msg_tip.setText(num);
            }
//            rtv_msg_tip.setVisibility(View.VISIBLE);
//            rtv_msg_tip.setText(num + "");

        }
    }
}
