package com.likeit.aqe365.activity.find;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guoqi.actionsheet.ActionSheet;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.MainActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.main.MainNavigationModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.AppManager;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.utils.photo.PhotoUtils;
import com.likeit.aqe365.view.custom.GridViewAddImgesAdpter;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import rx.Subscriber;

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

    /**
     * 底部导航数据
     */
    private String[] mIconSelectIds;//标题
    private String[] mTitles;//未选中

    private String[] mLinkurl;
    private String linkurl;
    private int index;

    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayList<String> stringArrayList1 = new ArrayList<String>();
    ArrayList<String> stringArrayList2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_doctor);
        setTitle("向医生提问");
        setBackView();
        list = new ArrayList<>();
        datas = new ArrayList<>();
        initTab();
        initUI();
        PhotoUtils.getInstance().init(this, true, new PhotoUtils.OnSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
                photoPath(outputFile.getAbsolutePath());
            }
        });

    }

    public void initTab() {
        String navtab = SharedPreferencesUtils.getString(mContext, "navtab");
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

    private void initUI() {
        setRightText("发布", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                psot();
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

    private void psot() {
        String title = edTitle.getText().toString();
        String content = edContent.getText().toString();
        if (StringUtil.isBlank(title)) {
            showToast("标题不能为空");
            return;
        }
        if (title.length() < 4) {
            showToast("标题不能少于4字");
            return;
        }
        if (StringUtil.isBlank(content)) {
            showToast("内容不能为空");
            return;
        }
        if (content.length() < 20) {
            showToast("内容不能少于20字");
            return;
        }

        RequestBody requestApiKey = RequestBody.create(MediaType.parse("multipart/form-data"), openid);
        RequestBody requestApiTitle = RequestBody.create(MediaType.parse("multipart/form-data"), title);
        RequestBody requestApiContent = RequestBody.create(MediaType.parse("multipart/form-data"), content);
        List<MultipartBody.Part> list1 = new ArrayList<>();
        XLog.e("requestApiKey->"+requestApiKey);
        /**
         * 术前
         */
        if (list != null) {
            for (String pathItem : list) {
                if (!TextUtils.isEmpty(pathItem)) {
                    File file = new File(pathItem);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
                    MultipartBody.Part body = MultipartBody.Part.createFormData("image[]", file.getName(), requestFile);// pictures 是参数名
                    list1.add(body);

                    XLog.e("body->"+body);
                }
            }
        }

        RetrofitUtil.getInstance().quiz(requestApiKey, requestApiTitle, requestApiContent, list1, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    showToast(baseResponse.getMsg());
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("mTitles", mTitles);
                    bundle.putStringArray("mLinkurl", mLinkurl);
                    bundle.putStringArray("mIconSelectIds", mIconSelectIds);
                    bundle.putString("flag", "2");
                    bundle.putInt("index", 2);
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    AppManager.getAppManager().finishAllActivity();
                } else {
                    showToast(baseResponse.getMsg());

                }
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
        list.add(path);
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
