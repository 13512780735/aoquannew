package com.likeits.simple.activity.login_register;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.activity.FrameActivity;
import com.likeits.simple.activity.MainActivity;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.constants.Constants;
import com.likeits.simple.listener.IEditTextChangeListener;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.LoginRegisterModel;
import com.likeits.simple.network.model.main.MainNavigationModel;
import com.likeits.simple.network.util.RetrofitUtil;
import com.likeits.simple.utils.AppManager;
import com.likeits.simple.utils.EditTextSizeCheckUtil;
import com.likeits.simple.utils.LoaddingDialog;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.utils.StatusBarUtil;
import com.likeits.simple.utils.StringUtil;
import com.likeits.simple.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

import static com.likeits.simple.Interface.BaseInterface.KEY_FRAGMENT;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ToggleButton tb_password;
    EditText et_password;
    private TextView tv_login;
    private EditText et_phone, et_pwd;
    private String phone, pwd;
    private LoaddingDialog mDialog;
    private Handler handler;
    private String third_type;
    private String uid;
    private String isWeb;
    private String openid;
    private String avatarUrl;
    private String[] mIconSelectIds;//标题
    private String[] mTitles;//未选中

    private LoginActivity mContext;
    private String[] mLinkurl;


    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayList<String> stringArrayList1 = new ArrayList<String>();
    ArrayList<String> stringArrayList2 = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AppManager.getAppManager().addActivity(this);
        mContext = this;
        int color = getResources().getColor(R.color.theme_bg);
        //isWeb = SharedPreferencesUtils.getString(this, "isWeb");
//        mTitles = getIntent().getStringArrayExtra("mTitles");
//        mLinkurl = getIntent().getStringArrayExtra("mLinkurl");
//        mIconSelectIds = getIntent().getStringArrayExtra("mIconSelectIds");


        mDialog = new LoaddingDialog(this);
        StatusBarUtil.setColor(this, color, 0);
        StatusBarUtil.setLightMode(this);
        ButterKnife.bind(this);

        initData();
        initUI();
        initView();
        addListeners();

    }


    public void initUI() {
        tb_password = findViewById(R.id.tb_re_pwd);
        et_password = findViewById(R.id.login_et_pwd);
        et_phone = findViewById(R.id.login_et_phone);
        et_pwd = findViewById(R.id.login_et_pwd);
        tv_login = findViewById(R.id.tv_login);
        phone = SharedPreferencesUtils.getString(this, "phone");
        pwd = SharedPreferencesUtils.getString(this, "pwd");
        if (!StringUtil.isBlank(phone) && !StringUtil.isBlank(pwd)) {
            tv_login.setBackgroundResource(R.drawable.shape_round_blue_bg_5);
            tv_login.setOnClickListener(LoginActivity.this);
        }

    }

    private void initView() {
        et_phone.setText(phone);
        et_pwd.setText(pwd);
        EditTextSizeCheckUtil.textChangeListener textChangeListener = new EditTextSizeCheckUtil.textChangeListener(tv_login);
        textChangeListener.addAllEditText(et_phone, et_pwd);
        EditTextSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if (isHasContent) {
                    tv_login.setBackgroundResource(R.drawable.shape_round_blue_bg_5);
                    tv_login.setOnClickListener(LoginActivity.this);
                } else {
                    tv_login.setBackgroundResource(R.drawable.shape_round_grey_bg_5);
                }
            }
        });
    }

    public void initData() {
        RetrofitUtil.getInstance().getMainNavigation("1", new Subscriber<BaseResponse<MainNavigationModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<MainNavigationModel> baseResponse) {
                XLog.d(baseResponse.getCode());
                if (baseResponse.getCode() == 200) {
                    MainNavigationModel mainNavigationModel = baseResponse.getData();
                    SharedPreferencesUtils.put(mContext, "iconcolor", baseResponse.getData().getStyle().getIconcolor());
                    SharedPreferencesUtils.put(mContext, "iconcoloron", baseResponse.getData().getStyle().getIconcoloron());
                    List<MainNavigationModel.ItemsBean> items = mainNavigationModel.getItems();
                    XLog.e(items);
                    for (int i = 0; i < items.size(); i++) {
                        stringArrayList.add(items.get(i).getText());
                        stringArrayList1.add(StringUtil.decode("\\u" + items.get(i).getIconclasscode()));
                        stringArrayList2.add(items.get(i).getLinkurl());
                    }
                    mTitles = stringArrayList.toArray(new String[stringArrayList.size()]);
                    mLinkurl = stringArrayList2.toArray(new String[stringArrayList2.size()]);
                    mIconSelectIds = stringArrayList1.toArray(new String[stringArrayList1.size()]);
                    XLog.e(mTitles);
                    XLog.e(mLinkurl);
                    XLog.e(mIconSelectIds);

                }
            }
        });
    }

    public void addListeners() {
        tb_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //普通文本框
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //密码框
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                et_password.postInvalidate();//刷新View
                //将光标置于文字末尾
                CharSequence charSequence = et_password.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
            }
        });
    }

    @OnClick({R.id.tv_phone_login, R.id.tv_forget_pwd, R.id.tv_register, R.id.login_qq, R.id.login_wechat})
    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.tv_phone_login:
                startFrameActivity(Constants.FRAGMENT_PHONE_LOGIN);
                break;
            case R.id.tv_forget_pwd:
                startFrameActivity(Constants.FRAGMENT_FORGET_PWD);
                break;

            case R.id.tv_register:
                startFrameActivity(Constants.FRAGMENT_REGISTER);
                break;
            case R.id.login_qq:
                //ToastUtils.showToast(this, "暂未开通");
                // startFrameActivity(Constants.FRAGMENT_Third_LOGIN);
                third_type = "qq";
                mDialog.show();
//                qzone = ShareSDK.getPlatform(QQ.NAME);
//                // getQQUnionid(qzone);
//                authorize(qzone);
                break;
            case R.id.login_wechat:
                // startFrameActivity(Constants.FRAGMENT_Third_LOGIN);
                third_type = "wx";
                mDialog.show();
//                Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
//                authorize(wechat);
                break;
        }
    }

    private void startMainActivity() {
        Bundle bundle = new Bundle();
        //  bundle.putString("flag", "0");
        bundle.putStringArray("mTitles", mTitles);
        bundle.putStringArray("mLinkurl", mLinkurl);
        bundle.putStringArray("mIconSelectIds", mIconSelectIds);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);


        AppManager.getAppManager().finishAllActivity();
    }

    private void startFrameActivity(int keyFragment) {
        Intent intent = new Intent(this, FrameActivity.class);
        intent.putExtra(KEY_FRAGMENT, keyFragment);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                phone = et_phone.getText().toString().trim();
                pwd = et_pwd.getText().toString().trim();
                Login(phone, pwd);
                break;
        }

    }

    private void Login(final String phone, final String pwd) {
        mDialog.show();
        RetrofitUtil.getInstance().getUsersLogin(phone, pwd, new Subscriber<BaseResponse<LoginRegisterModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mDialog.dismiss();
            }

            @Override
            public void onNext(BaseResponse<LoginRegisterModel> baseResponse) {
                mDialog.dismiss();
                if (baseResponse.code == 200) {
                    SharedPreferencesUtils.put(LoginActivity.this, "phone", phone);
                    SharedPreferencesUtils.put(LoginActivity.this, "pwd", pwd);
                    SharedPreferencesUtils.put(LoginActivity.this, "openid", baseResponse.getData().getOpenid());
                    SharedPreferencesUtils.put(LoginActivity.this, "avatar", baseResponse.getData().getAvatar());
                    SharedPreferencesUtils.put(LoginActivity.this, "nickname", baseResponse.getData().getNickname());
                    startMainActivity();

                } else {
                    Log.d("TAG", baseResponse.getMsg());
                    ToastUtils.showToast(LoginActivity.this, baseResponse.getMsg());
                }

            }
        });
    }
//    @OnClick({R.id.bt_login})
//    public void onclick(View v) {
//        switch (v.getId()) {
//            case R.id.bt_login:
//                Bundle bundle = new Bundle();
//                bundle.putStringArray("mTitles", mTitles);
//                bundle.putStringArray("mLinkurl", mLinkurl);
//                bundle.putStringArray("mIconSelectIds", mIconSelectIds);
//                toActivity(MainActivity.class, bundle);
//                finish();
//                break;
//        }
//    }
}
