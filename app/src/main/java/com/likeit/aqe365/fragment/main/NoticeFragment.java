package com.likeit.aqe365.fragment.main;


import android.support.v4.app.Fragment;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseFragment;

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
