package com.likeit.aqe365.activity.find;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.guoqi.actionsheet.ActionSheet;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.utils.photo.PhotoUtils;
import com.likeit.aqe365.view.custom.GridViewAddImgesAdpter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * 向医生提问
 */
public class QuestionDoctorActivity extends BaseActivity implements ActionSheet.OnActionSheetSelected, EasyPermissions.PermissionCallbacks {
    @BindView(R.id.ed_title)
    EditText edTitle;
    @BindView(R.id.ed_content)
    EditText edContent;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_num01)
    TextView tvNum01;
    @BindView(R.id.mGridView)
    GridView mGridView;
    private List<Map<String, Object>> datas;
    private GridViewAddImgesAdpter gridViewAddImgesAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_doctor);
        setTitle("向医生提问");
        setBackView();

        datas = new ArrayList<>();
        initUI();
        PhotoUtils.getInstance().init(this, true, new PhotoUtils.OnSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
                photoPath(outputFile.getAbsolutePath());
            }
        });

    }

    private void initUI() {
        setRightText("发布", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvNum.setText("0/25");
        tvNum01.setText("0/500字");
        edTitle.addTextChangedListener(mTextWatcher);
        edContent.addTextChangedListener(mTextWatcher01);
        /**
         * 术前图片
         */
        gridViewAddImgesAdpter = new GridViewAddImgesAdpter(datas, this);
        gridViewAddImgesAdpter.setMaxImages(4);
        mGridView.setAdapter(gridViewAddImgesAdpter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ActionSheet.showSheet(QuestionDoctorActivity.this, QuestionDoctorActivity.this, null);
            }
        });
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
    TextWatcher mTextWatcher01 = new TextWatcher() {
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
            editStart = edContent.getSelectionStart();
            editEnd = edContent.getSelectionEnd();
            tvNum01.setText("" + temp.length() + "/500字");
            if (temp.length() > 500) {
                showToast("你输入的字数已经超过了限制！");
                s.delete(editStart - 1, editEnd);
                int tempSelection = editStart;
                edContent.setText(s);
                edContent.setSelection(tempSelection);
            }
        }
    };
    /**
     * 术前
     */
    List<String> list;

    public void photoPath(String path) {
        //  list.add(path);
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        //upAvatar(base64);
        datas.add(map);
        gridViewAddImgesAdpter.notifyDataSetChanged();
    }

    String[] takePhotoPerms = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, CAMERA};
    String[] selectPhotoPerms = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE};

    @Override
    public void onClick(int whichButton) {
        switch (whichButton) {
            case ActionSheet.CHOOSE_PICTURE:
                //相册
                checkPermission(selectPhotoPerms, 2);
                break;
            case ActionSheet.TAKE_PICTURE:
                //拍照
                checkPermission(takePhotoPerms, 1);
                break;
            case ActionSheet.CANCEL:
                //取消
                break;
        }
    }

    private void checkPermission(String[] perms, int requestCode) {
        if (EasyPermissions.hasPermissions(this, perms)) {//已经有权限了
            switch (requestCode) {
                case 1:
                    PhotoUtils.getInstance().takePhoto();
                    break;
                case 2:
                    PhotoUtils.getInstance().selectPhoto();
                    break;
            }
        } else {//没有权限去请求
            EasyPermissions.requestPermissions(this, "权限", requestCode, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {//设置成功
        switch (requestCode) {
            case 1:
                PhotoUtils.getInstance().takePhoto();
                break;
            case 2:
                PhotoUtils.getInstance().selectPhoto();
                break;
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this)
                    .setTitle("权限设置")
                    .setPositiveButton("设置")
                    .setRationale("当前应用缺少必要权限,可能会造成部分功能受影响！请点击\"设置\"-\"权限\"-打开所需权限。最后点击两次后退按钮，即可返回")
                    .build()
                    .show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PhotoUtils.getInstance().bindForResult(requestCode, resultCode, data);
    }
}
