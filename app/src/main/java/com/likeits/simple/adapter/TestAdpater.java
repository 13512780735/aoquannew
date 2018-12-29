package com.likeits.simple.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeits.simple.network.model.EmptyEntity;

import java.util.List;

public class TestAdpater extends BaseQuickAdapter<EmptyEntity,BaseViewHolder>{
    public TestAdpater(int layoutResId, List<EmptyEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, EmptyEntity item) {

    }
}
