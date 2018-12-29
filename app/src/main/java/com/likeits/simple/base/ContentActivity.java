package com.likeits.simple.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.likeits.simple.R;
import com.likeits.simple.utils.AppManager;
import com.likeits.simple.utils.StatusBarUtil;

/**
 * Created by admin on 2018/5/10.
 */

public abstract  class ContentActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        AppManager.getAppManager().addActivity(this);
        int color = getResources().getColor(R.color.white);
        StatusBarUtil.setColor(this, color, 0);
        StatusBarUtil.setLightMode(this);
        switchFragment(getIntent());
    }

    public <T extends View> T findView(@IdRes int id) {
        return (T) findViewById(id);
    }

    protected void replaceFragment(Fragment fragmnet) {
        replaceFragment(R.id.fragmentContent, fragmnet);
    }

    protected void replaceFragment(@IdRes int id, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(id, fragment).commit();
    }

    protected abstract void switchFragment(Intent intent);
}
