package com.likeit.aqe365.activity.web.jsinterface;

import android.os.Bundle;

import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.web.base.BaseActivity;
import com.likeit.aqe365.utils.AppManager;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

public class JsInterfaceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intercept);
        AppManager.getAppManager().addActivity(this);
        //EventBus.getDefault().register(this);\
        initBugly();
        JsInterfaceFragment fragment = (JsInterfaceFragment) getFragmentManager().findFragmentById(R.id.content_frame);
        if (fragment == null) {
            fragment = new JsInterfaceFragment();
            JsInterfacePresenter presenter = new JsInterfacePresenter(fragment);
            fragment.setPresenter(presenter);
            addFragment(fragment, R.id.content_frame);
        }
    }

    private void initBugly() {
        Bugly.init(getApplicationContext(), "54573e34e3", false);
        Beta.autoCheckUpgrade = true;//设置自动检查
        Beta.upgradeCheckPeriod = 60 * 60 * 1000;
        Beta.largeIconId = R.mipmap.ic_launcher;

    }

}