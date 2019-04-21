package com.likeit.aqe365.adapter.div_provider.member;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.member.MemberMenu3Model;
import com.likeit.aqe365.utils.IntentUtils;

import java.util.List;

public class MemberMenu3Provider extends BaseItemProvider<MemberMenu3Model, BaseViewHolder> {
    @Override
    public int viewType() {
        return MemberAdapter.TYPE_MENU3;
    }

    @Override
    public int layout() {
        return R.layout.member_menu3_item;
    }

    @Override
    public void convert(BaseViewHolder helper, final MemberMenu3Model data, int position) {
        RecyclerView mRecyclerView = helper.getView(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 5));
        MemberMenu3Adapter mAdapter = new MemberMenu3Adapter(R.layout.member_menu3_item_view, data.getData());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String id = data.getData().get(position).getParams().getId();
                String linkUrl = data.getData().get(position).getLinkurl();
                String webUrl=data.getData().get(position).getWeburl();
//        Intent intent = new Intent(mContext, CustomActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("id", id);
//        intent.putExtras(bundle);
//        mContext.startActivity(intent);
                IntentUtils.intentTo(mContext, linkUrl, id,webUrl);
            }
        });
    }


    public class MemberMenu3Adapter extends BaseQuickAdapter<MemberMenu3Model.DataBean, BaseViewHolder> {
        public MemberMenu3Adapter(int layoutResId, List<MemberMenu3Model.DataBean> data) {
            super(R.layout.member_menu3_item_view, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, MemberMenu3Model.DataBean item) {
            helper.setText(R.id.tv_num, item.getDotnum()+"");
            helper.setText(R.id.tv_name, item.getText());
        }
    }
}
