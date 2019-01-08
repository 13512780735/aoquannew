package com.likeits.simple.activity.login_register;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.likeits.simple.R;
import com.likeits.simple.activity.FrameActivity;
import com.likeits.simple.base.BaseFragment;
import com.likeits.simple.constants.Constants;
import com.likeits.simple.listener.IEditTextChangeListener;
import com.likeits.simple.network.util.RetrofitUtil;
import com.likeits.simple.utils.EditTextSizeCheckUtil;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.view.BorderTextView;

import rx.Subscriber;

import static com.likeits.simple.Interface.BaseInterface.KEY_FRAGMENT;

/**
 * A simple {@link Fragment} subclass.
 */
public class RelevanceUserFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    private TextView tv_relevance_forget_pwd;
    private BorderTextView tv_relevance;
    private ToggleButton tb_re_pwd;
    private EditText et_pwd, et_phone;
    private String type;
    private String openid;
    private String isWeb;

    public static RelevanceUserFragment newInstance() {
        Bundle bundle = new Bundle();
        RelevanceUserFragment fragment = new RelevanceUserFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        type = SharedPreferencesUtils.getString(getActivity(), "type");
        openid = SharedPreferencesUtils.getString(getActivity(), "openid");
        isWeb=SharedPreferencesUtils.getString(getActivity(),"isWeb");
    }

    public void initUI() {
        setBackView();
        setTitle("关联帐号");
        tv_relevance_forget_pwd = findView(R.id.tv_relevance_forget_pwd);
        tv_relevance = findView(R.id.tv_relevance);
        tb_re_pwd = findView(R.id.tb_re_pwd);
        et_pwd = findView(R.id.RelevanceUser_et_pwd);
        et_phone = findView(R.id.RelevanceUser_et_phone);
        EditTextSizeCheckUtil.textChangeListener textChangeListener = new EditTextSizeCheckUtil.textChangeListener(tv_relevance);
        textChangeListener.addAllEditText(et_pwd, et_phone);
        EditTextSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if (isHasContent) {
                    tv_relevance.setContentColorResource01(Color.parseColor(theme_bg_tex));
                    tv_relevance.setStrokeColor01(Color.parseColor(theme_bg_tex));
                    tv_relevance.setOnClickListener(RelevanceUserFragment.this);
                } else {
                    tv_relevance.setContentColorResource01(Color.parseColor("#999999"));
                    tv_relevance.setStrokeColor01(Color.parseColor("#999999"));
                }
            }
        });
    }


    public void addListeners() {
        tv_relevance_forget_pwd.setOnClickListener(this);
        tb_re_pwd.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_relevance_forget_pwd:
                startFrameActivity(Constants.FRAGMENT_FORGET_PWD);
                break;
            case R.id.tv_relevance:
                //startMainActivity();
                snsBind();
                // startMainActivity();
                break;
        }
    }

    private void snsBind() {
        final String mobile = et_phone.getText().toString().trim();
        final String pwd = et_pwd.getText().toString().trim();
//        RetrofitUtil.getInstance().snsBind(openid, type, mobile, pwd, new Subscriber<BaseResponse<LoginRegisterModel>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                LogUtils.d("错误：" + e);
//            }
//
//            @Override
//            public void onNext(BaseResponse<LoginRegisterModel> baseResponse) {
//                if (baseResponse.code == 200) {
//                    SharedPreferencesUtils.put(getActivity(), "phone", mobile);
//                    SharedPreferencesUtils.put(getActivity(), "pwd", pwd);
//                    SharedPreferencesUtils.put(getActivity(), "token", baseResponse.getData().getToken());
//                    LogUtils.d(baseResponse.getData().getMember().getNickname());
//                    if ("1".equals(isWeb)) {
//                        startMainActivity();
//                    } else {
//                        startWebActivity();
//                    }
//                } else {
//                    showProgress(baseResponse.getMsg());
//                }
//
//            }
//        });
    }
//    private void startWebActivity() {
//        /**
//         * 跳转网页
//         */
//        SharedPreferencesUtils.put(getActivity(), "login", "2");
//        Intent intent = new Intent(getActivity(), JsInterfaceActivity.class);
//        startActivity(intent);
//    }
//    private void startMainActivity() {
//        Bundle bundle = new Bundle();
//        bundle.putString("flag", "0");
//        Intent intent = new Intent(getActivity(), MainActivity.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
//        AppManager.getAppManager().finishAllActivity();
//    }

    private void startFrameActivity(int keyFragment) {
        Intent intent = new Intent(getActivity(), FrameActivity.class);
        intent.putExtra(KEY_FRAGMENT, keyFragment);
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            //普通文本框
            et_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            //密码框
            et_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        et_pwd.postInvalidate();//刷新View
        //将光标置于文字末尾
        CharSequence charSequence = et_pwd.getText();
        if (charSequence instanceof Spannable) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_relevance_user;
    }

    @Override
    protected void lazyLoad() {
        initUI();
        addListeners();
    }
}