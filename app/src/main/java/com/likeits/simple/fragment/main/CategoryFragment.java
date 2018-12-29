package com.likeits.simple.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.base.BaseFragment;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends BaseFragment {


    @Override
    protected int setContentView() {
        return R.layout.fragment_category;
    }

    @Override
    protected void lazyLoad() {

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        XLog.e("Fragment02");
    }
}
