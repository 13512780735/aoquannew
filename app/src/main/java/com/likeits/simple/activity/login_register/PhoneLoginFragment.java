package com.likeits.simple.activity.login_register;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.likeits.simple.R;
import com.likeits.simple.activity.FrameActivity;
import com.likeits.simple.activity.MainActivity;
import com.likeits.simple.base.BaseFragment;
import com.likeits.simple.constants.Constants;
import com.likeits.simple.listener.IEditTextChangeListener;
import com.likeits.simple.utils.AppManager;
import com.likeits.simple.utils.EditTextSizeCheckUtil;

import static com.likeits.simple.Interface.BaseInterface.KEY_FRAGMENT;

public class PhoneLoginFragment extends BaseFragment implements View.OnClickListener {


    private TextView tvLogin;
    private TextView tvLoginWechat, tvLoginQQ;
    private EditText et_phone, et_code;

    public static PhoneLoginFragment newInstance() {
        Bundle bundle = new Bundle();
        PhoneLoginFragment fragment = new PhoneLoginFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    public void initUI() {
        setBackView();
        setTitle("手机验证登录");
        et_phone = findView(R.id.phone_login_et_phone);
        et_code = findView(R.id.phone_login_et_code);
        tvLogin = findView(R.id.tv_login);
        tvLoginQQ = findView(R.id.login_qq);
        tvLoginWechat = findView(R.id.login_wechat);
        EditTextSizeCheckUtil.textChangeListener textChangeListener = new EditTextSizeCheckUtil.textChangeListener(tvLogin);
        textChangeListener.addAllEditText(et_phone, et_code);
        EditTextSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if (isHasContent) {
                    tvLogin.setBackgroundResource(R.drawable.shape_round_blue_bg_5);
                    tvLogin.setOnClickListener(PhoneLoginFragment.this);
                } else {
                    tvLogin.setBackgroundResource(R.drawable.shape_round_grey_bg_5);
                }
            }
        });
    }


    public void addListeners() {

        tvLoginQQ.setOnClickListener(this);
        tvLoginWechat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                startMainActivity();
                break;
            case R.id.login_qq:
                startFrameActivity(Constants.FRAGMENT_Third_LOGIN);
                break;
            case R.id.login_wechat:
                startFrameActivity(Constants.FRAGMENT_Third_LOGIN);
                break;
        }
    }

    private void startMainActivity() {
        Bundle bundle = new Bundle();
        bundle.putString("flag", "0");
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtras(bundle);
        AppManager.getAppManager().finishAllActivity();
    }

    private void startFrameActivity(int keyFragment) {
        Intent intent = new Intent(getActivity(), FrameActivity.class);
        intent.putExtra(KEY_FRAGMENT, keyFragment);
        startActivity(intent);
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_phone_login;
    }

    @Override
    protected void lazyLoad() {
        initUI();
        addListeners();
    }
}