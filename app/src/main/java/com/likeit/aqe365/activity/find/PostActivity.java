package com.likeit.aqe365.activity.find;

import android.os.Bundle;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;

import android.view.View;

import butterknife.OnClick;

public class PostActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        setBackView();
    }

    @OnClick({R.id.ll_riji, R.id.ll_xinqing, R.id.ll_post_tiezi, R.id.ll_ask})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_riji:
                toActivity(ChooseActivity.class);
                break;
            case R.id.ll_xinqing:
                toActivity(SendMoodActivity.class);
                break;
            case R.id.ll_post_tiezi:
                toActivity(SendMoodActivity.class);
                break;
            case R.id.ll_ask:
                toActivity(QuestionDoctorActivity.class);
                break;
        }
    }
}
