package com.likeit.aqe365.activity.find;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.OnSureLisener;
import com.codbking.widget.bean.DateType;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.utils.StringUtil;

import android.view.View;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 编辑日记本
 */
public class EditDiaryActivity extends BaseActivity {
    @BindView(R.id.ed_title)
    EditText edTitle;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_hospital)
    TextView tvHospital;//医院
    @BindView(R.id.tv_subject)
    TextView tvSubject;//科目
    @BindView(R.id.tv_serve)
    TextView tvServe;//服务
    @BindView(R.id.tv_time)
    TextView tvTime;//时间


    String title;
    String time;
    private String hospitalId, categoryId, serviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_diary);
        setBackView();
        setTitle("编辑日记本");
        initUI();
    }

    private void initUI() {
        tvNum.setText("0/25");
        edTitle.addTextChangedListener(mTextWatcher);
    }

    TextWatcher mTextWatcher = new TextWatcher() {
        private CharSequence temp;
        private int editStart;
        private int editEnd;

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // TODO Auto-generated method stub
            temp = s;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
//          mTextView.setText(s);//将输入的内容实时显示
        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            editStart = edTitle.getSelectionStart();
            editEnd = edTitle.getSelectionEnd();
            tvNum.setText("" + temp.length() + "/25");
            if (temp.length() > 25) {
                showToast("你输入的字数已经超过了限制！");
                s.delete(editStart - 1, editEnd);
                int tempSelection = editStart;
                edTitle.setText(s);
                edTitle.setSelection(tempSelection);
            }
        }
    };


    @OnClick({R.id.ll_hospital, R.id.ll_subject, R.id.ll_serve, R.id.ll_time, R.id.tv_next})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_hospital:
                Intent intent = new Intent(EditDiaryActivity.this, ChooseSevreActivity.class);
                intent.putExtra("flag", "0");
                intent.putExtra("id", "");
                startActivityForResult(intent, 101);
                break;
            case R.id.ll_subject:
                if(StringUtil.isBlank(hospitalId)){
                    showProgress("请选择医院");
                    return;
                }
                Intent intent1 = new Intent(EditDiaryActivity.this, ChooseSevreActivity.class);
                intent1.putExtra("flag", "1");
                intent1.putExtra("id", hospitalId);
                startActivityForResult(intent1, 102);
                break;
            case R.id.ll_serve:
                if(StringUtil.isBlank(hospitalId)||StringUtil.isBlank(categoryId)){
                    showProgress("请选择医院和科目");
                    return;
                }
                Intent intent2 = new Intent(EditDiaryActivity.this, ChooseSevreActivity.class);
                intent2.putExtra("flag", "2");
                intent2.putExtra("id", hospitalId);
                startActivityForResult(intent2, 103);
                break;
            case R.id.ll_time:
                showDatePickDialog(DateType.TYPE_YMD);
                break;
            case R.id.tv_next:
                title = edTitle.getText().toString().trim();
                if (StringUtil.isBlank(title)) {
                    showProgress("标题不能为空");
                    return;
                }
                if (title.length() < 4) {
                    showProgress("标题不能少于4位");
                    return;
                }
                if (StringUtil.isBlank(time)) {
                    showProgress("标题不能为空");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("hospital", hospitalId);
                bundle.putString("service", serviceId);
                bundle.putString("category", categoryId);
                bundle.putString("addtime", time);
                toActivity(DiaryTypeActivity.class, bundle);
                break;
        }
    }

    /**
     * 选择日期
     *
     * @param type
     */
    private void showDatePickDialog(DateType type) {
        DatePickDialog dialog = new DatePickDialog(this);
        //设置上下年分限制
        dialog.setYearLimt(5);
        //设置标题
        dialog.setTitle("选择时间");
        //设置类型
        dialog.setType(type);
        //设置消息体的显示格式，日期格式
        dialog.setMessageFormat("yyyy-MM-dd");
        //设置选择回调
        dialog.setOnChangeLisener(null);
        //设置点击确定按钮回调
        dialog.setOnSureLisener(new OnSureLisener() {
            @Override
            public void onSure(Date date) {
                tvTime.setText(StringUtil.getDate(date, "yyyy-MM-dd"));
                time = String.valueOf((StringUtil.getStringToDate(StringUtil.getDate(date, "yyyy-MM-dd"), "yyyy-MM-dd")) / 1000);
                XLog.e("time-->" + time);
            }
        });
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 110) {
            if (requestCode == 101) {
                tvHospital.setText(data.getStringExtra("name"));
                hospitalId = data.getStringExtra("id");
            } else if (requestCode == 102) {
                tvSubject.setText(data.getStringExtra("name"));
                categoryId = data.getStringExtra("id");
            } else if (requestCode == 103) {
                tvServe.setText(data.getStringExtra("name"));
                serviceId = data.getStringExtra("id");
            }
        }
    }
}
