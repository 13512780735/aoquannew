package com.likeits.simple.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeFragment extends BaseFragment {


    @Override
    protected int setContentView() {
        return R.layout.fragment_notice;
    }

    @Override
    protected void lazyLoad() {

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        XLog.e("Fragment03");
    }
}
