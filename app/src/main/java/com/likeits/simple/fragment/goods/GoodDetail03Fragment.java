package com.likeits.simple.fragment.goods;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.R;
import com.likeits.simple.base.BaseFragment;
import com.likeits.simple.network.model.gooddetails.GoodDetailNavbarItemModel;
import com.likeits.simple.network.model.gooddetails.GoodParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodDetail03Fragment extends BaseFragment {


    private String goodData;
    private GoodParams goods;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    private GoodDetailsArgumentsAdapter mAdapter;
    private List<GoodParams.ParamsBean> data;

    @Override
    protected int setContentView() {
        return R.layout.fragment_good_detail03;
    }

    @Override
    protected void lazyLoad() {
        goodData = getArguments().getString("goodData");
        try {
            JSONObject object = new JSONObject(goodData);
            int code = object.optInt("code");
            String msg = object.optString("msg");
            if (code == 200) {
                //goodData = response;
                JSONObject object1 = object.optJSONObject("data");
                goods = JSON.parseObject(object1.optString("goods"), GoodParams.class);
                data = goods.getParams();
                initAdapter();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new GoodDetailsArgumentsAdapter(R.layout.good_details_argument_items, data);
        // mAdapter.setOnLoadMoreListener(getActivity(), mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    public class GoodDetailsArgumentsAdapter extends BaseQuickAdapter<GoodParams.ParamsBean, BaseViewHolder> {
        public GoodDetailsArgumentsAdapter(int layoutResId, List<GoodParams.ParamsBean> data) {
            super(R.layout.good_details_argument_items, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, GoodParams.ParamsBean item) {
            baseViewHolder.setText(R.id.tv_name, item.getTitle());
            baseViewHolder.setText(R.id.tv_value, item.getValue());

        }
    }
}
