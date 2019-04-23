package com.likeit.aqe365.activity.login_register;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.FrameActivity;
import com.likeit.aqe365.activity.MainActivity;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.constants.Constants;
import com.likeit.aqe365.listener.IEditTextChangeListener;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.LoginRegisterModel;
import com.likeit.aqe365.network.model.main.MainNavigationModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.AppManager;
import com.likeit.aqe365.utils.EditTextSizeCheckUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.view.BorderTextView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

import static com.likeit.aqe365.Interface.BaseInterface.KEY_FRAGMENT;

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


    /**
     * 底部导航数据
     */
    private static String[] mIconSelectIds;//标题
    private static String[] mTitles;//未选中

    private static String[] mLinkurl;
    private static String linkurl;
    private int index;

    static ArrayList<String> stringArrayList = new ArrayList<String>();
    static ArrayList<String> stringArrayList1 = new ArrayList<String>();
    static ArrayList<String> stringArrayList2 = new ArrayList<String>();

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
        isWeb = SharedPreferencesUtils.getString(getActivity(), "isWeb");
        initUI();
        initTab(getActivity());
        addListeners();
    }

    private void initTab(FragmentActivity activity) {
        String navtab = SharedPreferencesUtils.getString(getActivity(), "navtab");
        Type type = new TypeToken<List<MainNavigationModel.ItemsBean>>() {
        }.getType();
        List<MainNavigationModel.ItemsBean> items = new Gson().fromJson(navtab, type);
        for (int i = 0; i < items.size(); i++) {
            stringArrayList.add(items.get(i).getText());
            stringArrayList1.add(StringUtil.decode("\\u" + items.get(i).getIconclasscode()));
            stringArrayList2.add(items.get(i).getLinkurl());
        }
        mTitles = stringArrayList.toArray(new String[stringArrayList.size()]);
        mLinkurl = stringArrayList2.toArray(new String[stringArrayList2.size()]);
        mIconSelectIds = stringArrayList1.toArray(new String[stringArrayList1.size()]);
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
        XLog.e("openid" + openid);
        XLog.e("openid" + type);
        RetrofitUtil.getInstance().snsBind(openid, type, mobile, pwd, new Subscriber<BaseResponse<LoginRegisterModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(BaseResponse<LoginRegisterModel> baseResponse) {
                XLog.e("msg" + baseResponse.getMsg());
                if (baseResponse.code == 200) {
                    SharedPreferencesUtils.put(getActivity(), "phone", mobile);
                    SharedPreferencesUtils.put(getActivity(), "pwd", pwd);
                    SharedPreferencesUtils.put(getActivity(), "openid", baseResponse.getData().getOpenid());
                    // XLog.d(baseResponse.getData().getMember().getNickname());
                     startMainActivity();
                    //toActivity(LoginActivity.class);
                } else {
                    showProgress(baseResponse.getMsg());
                }

            }
        });
    }





    //    private void startWebActivity() {
//        /**
//         * 跳转网页
//         */
//        SharedPreferencesUtils.put(getActivity(), "login", "2");
//        Intent intent = new Intent(getActivity(), JsInterfaceActivity.class);
//        startActivity(intent);
//    }
    private void startMainActivity() {
//        Bundle bundle = new Bundle();
//        bundle.putString("flag", "0");
//        Intent intent = new Intent(getActivity(), MainActivity.class);
//        intent.putExtras(bundle);
//        startActivity(intent);
//        AppManager.getAppManager().finishAllActivity();

//        for (int i = 0; i < mLinkurl.length; i++) {
//            if (linkurl.equals(mLinkurl[i])) {
//                index = i;
//            } else {
//                index = 0;
//            }
//        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("mTitles", mTitles);
        bundle.putStringArray("mLinkurl", mLinkurl);
        bundle.putStringArray("mIconSelectIds", mIconSelectIds);
        bundle.putString("flag", "0");
        bundle.putInt("index", 0);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);


        AppManager.getAppManager().finishAllActivity();
    }

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