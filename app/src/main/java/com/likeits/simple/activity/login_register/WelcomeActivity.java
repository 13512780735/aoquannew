package com.likeits.simple.activity.login_register;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.elvishew.xlog.XLog;
import com.likeits.simple.R;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.main.MainNavigationModel;
import com.likeits.simple.network.util.RetrofitUtil;
import com.likeits.simple.utils.SharedPreferencesUtils;
import com.likeits.simple.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class WelcomeActivity extends BaseActivity {
    private View view;


    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        view = View.inflate(this, R.layout.activity_welcome, null);
        setContentView(view);

        animation = AnimationUtils.loadAnimation(this, R.anim.splash_alpha);
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
                // toActivityFinish(LoginActivity.class);//原生

                toActivity(LoginActivity.class);
                finish();

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
