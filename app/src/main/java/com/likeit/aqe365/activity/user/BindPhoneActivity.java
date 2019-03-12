package com.likeit.aqe365.activity.user;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.listener.IEditTextChangeListener;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.EditTextSizeCheckUtil;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.utils.ToastUtils;
import com.likeit.aqe365.view.BorderTextView;

import butterknife.BindView;
import rx.Subscriber;

public class BindPhoneActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.bind_et_phone)
    EditText mBindEtPhone;
    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.bind_et_code)
    EditText mBindEtCode;
    @BindView(R.id.send_code_btn)
    BorderTextView mSendCodeBtn;
    @BindView(R.id.bind_et_pwd)
    EditText mBindEtPwd;
    @BindView(R.id.tb_re_pwd)
    ToggleButton mTbRePwd;
    @BindView(R.id.tv_bind)
    BorderTextView mTvBind;
    private String mobile;
    TimeCount time = new TimeCount(60000, 1000);
    private String pwd;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_phone);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initUI();
    }

    private void initUI() {
        setBackView();
        setTitle("更换绑定手机号");
        mSendCodeBtn.setStrokeColor01(Color.parseColor(theme_bg_tex));
        mSendCodeBtn.setTextColor(Color.parseColor(theme_bg_tex));
        mTbRePwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //普通文本框
                    mBindEtPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //密码框
                    mBindEtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                mBindEtPwd.postInvalidate();//刷新View
                //将光标置于文字末尾
                CharSequence charSequence = mBindEtPwd.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
            }
        });

        EditTextSizeCheckUtil.textChangeListener textChangeListener = new EditTextSizeCheckUtil.textChangeListener(mTvBind);
        textChangeListener.addAllEditText(mBindEtPhone, mBindEtCode, mBindEtPwd);
        EditTextSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if (isHasContent) {

                    mTvBind.setContentColorResource01(Color.parseColor(theme_bg_tex));
                    mTvBind.setStrokeColor01(Color.parseColor(theme_bg_tex));
                    mTvBind.setOnClickListener(BindPhoneActivity.this);
                } else {
                    mTvBind.setContentColorResource01(Color.parseColor("#999999"));
                    // tv_register.setClickable(false);
                }
            }
        });
    }

    private void sendCode() {
        mobile = mBindEtPhone.getText().toString().trim();
        if (StringUtil.isBlank(mobile)) {
            ToastUtils.showToast(mContext, "手机号不能为空");
            return;
        }
        if (!(StringUtil.isCellPhone(mobile))) {
            ToastUtils.showToast(mContext, "请输入正确的手机号码");
            return;
        } else {
            // SMSSDK.getVerificationCode("86", mobile);
            VerificationCode();
            time.start();
            LoaddingShow();
        }
    }

    private void VerificationCode() {
        RetrofitUtil.getInstance().getVerifycode(mobile, "sms_bind",
                new Subscriber<BaseResponse<EmptyEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LoaddingDismiss();
                    }

                    @Override
                    public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                        LoaddingDismiss();
                        if (baseResponse.code == 200) {
                            showProgress(baseResponse.getMsg());
                        } else {
                            showProgress(baseResponse.getMsg());
                        }
                    }
                });
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {// 计时完毕
            mSendCodeBtn.setText("获取验证码");
            mSendCodeBtn.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程
            mSendCodeBtn.setClickable(false);//防止重复点击
            mSendCodeBtn.setText(millisUntilFinished / 1000 + "s");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_confirm:
                mobile = mBindEtPhone.getText().toString().trim();
                pwd = mBindEtPwd.getText().toString().trim();
                code = mBindEtCode.getText().toString().trim();
                // SMSSDK.submitVerificationCode("86", mobile, code);
                if (StringUtil.isBlank(pwd)) {
                    showProgress("密码不能为空");
                    return;
                }
                if (StringUtil.isBlank(code)) {
                    showProgress("验证码不能为空");
                    return;
                }
                BindPhone(mobile, pwd);
                LoaddingShow();
                break;
            case R.id.send_code_btn:
                sendCode();
                break;
        }
    }

    private void BindPhone(String mobile, String pwd) {
        LoaddingShow();
        RetrofitUtil.getInstance().EditPhone(openid, mobile, pwd, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.getCode() == 200) {
                    showToast("绑定定成功");
                    finish();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }
}