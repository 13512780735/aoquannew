package com.likeit.aqe365.activity.find;

import android.os.Bundle;
import android.view.View;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.CaseEntity;
import com.likeit.aqe365.network.model.CaseIdEntity;
import com.likeit.aqe365.network.util.RetrofitUtil;

import butterknife.OnClick;
import rx.Subscriber;

public class DiaryTypeActivity extends BaseActivity {
    String title, hospital, service, category, addtime;
    private Bundle bundle;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diray_type);

        title = getIntent().getExtras().getString("title");
        hospital = getIntent().getExtras().getString("hospital");
        service = getIntent().getExtras().getString("service");
        category = getIntent().getExtras().getString("category");
        addtime = getIntent().getExtras().getString("addtime");
        initUI();
    }

    private void initUI() {
        setBackView();
    }

    @OnClick({R.id.ll_kangfuqi, R.id.ll_tuwenriji})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_kangfuqi:
                type = "0";
                nextTo();

                break;
            case R.id.ll_tuwenriji:
                type = "1";
                nextTo();
                break;
        }
    }

    private void nextTo() {
        XLog.e("title"+title);
        XLog.e("hospital"+hospital);
        XLog.e("category"+category);
        XLog.e("service"+service);
        XLog.e("addtime"+addtime);
        XLog.e("type"+type);
        RetrofitUtil.getInstance().Createbook(openid, title, hospital, category, service, addtime, type, new Subscriber<BaseResponse<CaseIdEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<CaseIdEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    String diaryid = baseResponse.getData().getId();
                    XLog.e("diaryid"+diaryid);
                    bundle = new Bundle();
                    bundle.putString("type", type);
                    bundle.putString("diaryid", diaryid);
                    toActivity(EditDiary01Activity.class, bundle);
                    showToast(baseResponse.getMsg());
                } else showToast(baseResponse.getMsg());
            }
        });
    }
}
