package com.likeits.simple.activity.login_register;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elvishew.xlog.LogUtils;
import com.likeits.simple.R;
import com.likeits.simple.activity.FrameActivity;
import com.likeits.simple.base.BaseFragment;
import com.likeits.simple.constants.Constants;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.view.CircleImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import static com.likeits.simple.Interface.BaseInterface.KEY_FRAGMENT;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdLoginFragment extends BaseFragment implements View.OnClickListener {


    private TextView tv_relevance;
    private TextView tv_register_quick;
    private CircleImageView iv_avatar;
    private String avatarUrl;

    public static ThirdLoginFragment newInstance() {
        // Required empty public constructor
        Bundle bundle = new Bundle();
        ThirdLoginFragment fragment = new ThirdLoginFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//    }

    public void initUI() {
        setBackView();
        setTitle("联合登录");
        tv_register_quick = findView(R.id.tv_register_quick);
        tv_relevance = findView(R.id.tv_relevance);
        iv_avatar = findView(R.id.iv_avatar);
      //  LogUtils.d("avatarUrl-->"+avatarUrl);
        ImageLoader.getInstance().displayImage(avatarUrl, iv_avatar);
    }

    public void initData() {

    }

    public void addListeners() {
        tv_relevance.setOnClickListener(this);
        tv_register_quick.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_register_quick:
                startFrameActivity(Constants.FRAGMENT_REGISTER);
                break;
            case R.id.tv_relevance:
                startFrameActivity(Constants.FRAGMENT_RELEVANCE_USER);
                break;
        }
    }

    private void startFrameActivity(int keyFragment) {
        Intent intent = new Intent(getActivity(), FrameActivity.class);
        intent.putExtra(KEY_FRAGMENT, keyFragment);
        startActivity(intent);
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_third_login;
    }

    @Override
    protected void lazyLoad() {
        avatarUrl = SharedPreferencesUtils.getString(getActivity(), "avatarUrl");
        initUI();
        addListeners();
        initData();
    }
}
