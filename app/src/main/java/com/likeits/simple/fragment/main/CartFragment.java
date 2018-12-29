package com.likeits.simple.fragment.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likeits.simple.R;
import com.likeits.simple.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends BaseFragment {


    @Override
    protected int setContentView() {
        return R.layout.fragment_cart;
    }

    @Override
    protected void lazyLoad() {

    }

}
