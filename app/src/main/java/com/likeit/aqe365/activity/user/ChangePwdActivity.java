package com.likeit.aqe365.activity.user;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.login_register.ForgetPwdFragment;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.listener.IEditTextChangeListener;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.EditTextSizeCheckUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.utils.ToastUtils;
import com.likeit.aqe365.view.BorderTextView;

import rx.Subscriber;

public class ChangePwdActivity extends BaseActivity implements View.OnClickListener {
    ToggleButton tb_re_pwd;
    EditText et_pwd;
    EditText et_pwd_confirm, et_code;
    ToggleButton tb_re_pwd_confirm;
    private BorderTextView tv_confirm;
    private BorderTextView tvSendCode;
    private String mobile;
    TimeCount time = new TimeCount(60000, 1000);
    private String pwd;
    private String pwd_confirm;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        mobile = SharedPreferencesUtils.getString(mContext, "phone");
        XLog.e("mobile"+mobile);
        initView();
        addListeners();
    }

    private void initView() {
        setBackView();
        setTitle("修改密码");
        tb_re_pwd = findView(R.id.tb_re_pwd);
        et_code = findView(R.id.forget_pwd_et_code);
        et_pwd = findView(R.id.forget_pwd_et_pwd);
        tvSendCode = findView(R.id.send_code_btn);
        et_pwd_confirm = findView(R.id.forget_pwd_et_pwd_confirm);
        tb_re_pwd_confirm = findView(R.id.tb_re_pwd_confirm);
        tv_confirm = findView(R.id.tv_confirm);
        tvSendCode.setOnClickListener(this);
        tvSendCode.setContentColorResource01(Color.parseColor("#FFFFFF"));
        tvSendCode.setStrokeColor01(Color.parseColor(theme_bg_tex));
        tvSendCode.setTextColor(Color.parseColor(theme_bg_tex));
        EditTextSizeCheckUtil.textChangeListener textChangeListener = new EditTextSizeCheckUtil.textChangeListener(tv_confirm);
        textChangeListener.addAllEditText(et_pwd, et_pwd_confirm, et_code);
        EditTextSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if (isHasContent) {
                    //   tv_confirm.setBackgroundResource(R.drawable.shape_round_blue_bg_5);
                    tv_confirm.setContentColorResource01(Color.parseColor(theme_bg_tex));
                    tv_confirm.setStrokeColor01(Color.parseColor(theme_bg_tex));
                    tv_confirm.setOnClickListener(ChangePwdActivity.this);
                } else {
                    tv_confirm.setContentColorResource01(Color.parseColor("#999999"));

                }
            }
        });
    }

    public void addListeners() {
        tb_re_pwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
        });
        tb_re_pwd_confirm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //普通文本框
                    et_pwd_confirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //密码框
                    et_pwd_confirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                et_pwd_confirm.postInvalidate();//刷新View
                //将光标置于文字末尾
                CharSequence charSequence = et_pwd_confirm.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_confirm:
                pwd = et_pwd.getText().toString().trim();
                pwd_confirm = et_pwd_confirm.getText().toString().trim();
                code = et_code.getText().toString().trim();
                // SMSSDK.submitVerificationCode("86", mobile, code);
                if (StringUtil.isBlank(pwd)) {
                    showProgress("密码不能为空");
                    return;
                }
                if (!pwd_confirm.equals(pwd)) {
                    showProgress("两次密码不一样，请重新输入");
                    return;
                }
                if (StringUtil.isBlank(code)) {
                    showProgress("验证码不能为空");
                    return;
                }
                ChangePwd(pwd);
                LoaddingShow();
                break;
            case R.id.send_code_btn:
                sendCode();
                break;
        }
    }

    private void ChangePwd(final String pwd) {
        RetrofitUtil.getInstance().UserChangePwd(mobile, pwd, code, new Subscriber<BaseResponse<EmptyEntity>>() {
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
                    SharedPreferencesUtils.put(mContext, "phone", mobile);
                    SharedPreferencesUtils.put(mContext, "pwd", pwd);
                    finish();
                } else {
                    baseResponse.getMsg();
                }
            }
        });
    }

    private void sendCode() {
        VerificationCode();
        time.start();
        LoaddingShow();
    }

    private void VerificationCode() {
        RetrofitUtil.getInstance().getVerifycode(mobile, "sms_forget",
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
            tvSendCode.setText("获取验证码");
            tvSendCode.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程
            tvSendCode.setClickable(false);//防止重复点击
            tvSendCode.setText(millisUntilFinished / 1000 + "s");
        }
    }
}
