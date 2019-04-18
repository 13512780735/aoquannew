package com.likeit.aqe365.activity.login_register;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.MainActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.main.MainNavigationModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.unistrong.yang.zb_permission.ZbPermission;


import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class WelcomeActivity extends BaseActivity {
    private View view;


    private Animation animation;
    private MainNavigationModel mainNavigationModel;
    private String[] mIconSelectIds;//标题
    private String[] mTitles;//未选中

    private String[] mLinkurl;


    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayList<String> stringArrayList1 = new ArrayList<String>();
    ArrayList<String> stringArrayList2 = new ArrayList<String>();
    List<MainNavigationModel.AdvBean> adList;
    private String isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        view = View.inflate(this, R.layout.activity_welcome, null);
        setContentView(view);
        /**
         * 获取权限问题
         */
        openPermission();
        initData();
        animation = AnimationUtils.loadAnimation(this, R.anim.splash_alpha);
        isLogin = "0";
        SharedPreferencesUtils.put(this, "isLogin", isLogin);
    }

    private final int REQUEST_CONTACT = 50;

    private void openPermission() {
        ZbPermission.with(WelcomeActivity.this)
                .addRequestCode(REQUEST_CONTACT)
                .permissions(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
                .request(new ZbPermission.ZbPermissionCallback() {

                    @Override
                    public void permissionSuccess(int requestCode) {

                        Toast.makeText(WelcomeActivity.this, "授予權限成功: " + requestCode, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void permissionFail(int requestCode) {

                        Toast.makeText(WelcomeActivity.this, "授予權限失敗: " + requestCode, Toast.LENGTH_SHORT).show();

                    }

                });
    }


    private void initData() {
        RetrofitUtil.getInstance().getMainNavigation("1", new Subscriber<BaseResponse<MainNavigationModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<MainNavigationModel> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    mainNavigationModel = baseResponse.getData();
                    List<MainNavigationModel.ItemsBean> items = mainNavigationModel.getItems();
                    Gson gson = new Gson();
                    String json = gson.toJson(items);
                    SharedPreferencesUtils.put(mContext, "navtab", json);
                    SharedPreferencesUtils.put(mContext, "iconcolor", baseResponse.getData().getStyle().getIconcolor());
                    SharedPreferencesUtils.put(mContext, "iconcoloron", baseResponse.getData().getStyle().getIconcoloron());
                    SharedPreferencesUtils.put(mContext, "theme_bg_tex", baseResponse.getData().getApp_basic().getApp_shopcolor());
                    for (int i = 0; i < items.size(); i++) {
                        stringArrayList.add(items.get(i).getText());
                        stringArrayList1.add(StringUtil.decode("\\u" + items.get(i).getIconclasscode()));
                        stringArrayList2.add(items.get(i).getLinkurl());
                    }
                    mTitles = stringArrayList.toArray(new String[stringArrayList.size()]);
                    mLinkurl = stringArrayList2.toArray(new String[stringArrayList2.size()]);
                    mIconSelectIds = stringArrayList1.toArray(new String[stringArrayList1.size()]);
                    initUI();
                }
            }
        });
    }

    private void initUI() {
        view.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation arg0) {
            }   //在动画开始时使用

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }  //在动画重复时使用

            @Override
            public void onAnimationEnd(Animation arg0) {
                // toActivityFinish(LoginActivity.class);//
                Boolean isFirst = SharedPreferencesUtils.getBoolean(getApplicationContext(), "isFirst", true);
                XLog.e("isFirst" + isFirst);
                XLog.e("isLogin" + isLogin);
                if (isFirst) {
                    SharedPreferencesUtils.put(getApplicationContext(), "isFirst", false);
                    if ("0".equals(isLogin)) {
                        if (mainNavigationModel.getAdv().getData() == null) {
                            Bundle bundle = new Bundle();
                            bundle.putStringArray("mTitles", mTitles);
                            bundle.putStringArray("mLinkurl", mLinkurl);
                            bundle.putStringArray("mIconSelectIds", mIconSelectIds);
                            bundle.putString("flag", "0");
                            bundle.putInt("index", 0);
                            toActivity(MainActivity.class, bundle);
                            finish();
                        } else {
                            List<String> items = mainNavigationModel.getAdv().getData();
                            Gson gson = new Gson();
                            String json = gson.toJson(items);
                            Bundle bundle = new Bundle();
                            bundle.putStringArray("mTitles", mTitles);
                            bundle.putStringArray("mLinkurl", mLinkurl);
                            bundle.putStringArray("mIconSelectIds", mIconSelectIds);
                            bundle.putString("recLen", mainNavigationModel.getAdv().getParams().getAutoclose());
                            bundle.putString("adList", json);
                            toActivity(GuideActivity.class, bundle);
                            finish();
                        }
                    } else {
                        if (mainNavigationModel.getAdv().getData() == null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("linkurl", "");
                            toActivity(LoginActivity.class, bundle);
                            finish();
                        } else {
                            List<String> items = mainNavigationModel.getAdv().getData();
                            Gson gson = new Gson();
                            String json = gson.toJson(items);
                            Bundle bundle = new Bundle();
                            bundle.putStringArray("mTitles", mTitles);
                            bundle.putStringArray("mLinkurl", mLinkurl);
                            bundle.putStringArray("mIconSelectIds", mIconSelectIds);
                            bundle.putString("recLen", mainNavigationModel.getAdv().getParams().getAutoclose());
                            bundle.putString("adList", json);
                            toActivity(GuideActivity.class, bundle);
                            finish();
                        }
                    }

                } else {
                    if ("0".equals(isLogin)) {
                        Bundle bundle = new Bundle();
                        bundle.putStringArray("mTitles", mTitles);
                        bundle.putStringArray("mLinkurl", mLinkurl);
                        bundle.putStringArray("mIconSelectIds", mIconSelectIds);
                        bundle.putString("flag", "0");
                        bundle.putInt("index", 0);
                        toActivity(MainActivity.class, bundle);
                        finish();
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("linkurl", "");
                        toActivity(LoginActivity.class, bundle);
                        finish();
                    }
                }


//                if ("1".equals(isWeb)) {
//
//                }

//                else {
//                    SharedPreferencesUtils.put(WelcomeActivity.this, "login", "1");
//                    toActivityFinish(JsInterfaceActivity.class);//半原生
//                }


            }
        });
    }

}
