package com.likeit.aqe365.activity.find;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.OnSureLisener;
import com.codbking.widget.bean.DateType;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Headers;
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
 * 编辑日记
 */
public class EditDiary01Activity extends BaseActivity implements ActionSheet.OnActionSheetSelected, EasyPermissions.PermissionCallbacks {
    String title, hospital, service, category, addtime, type;
    private String diaryid;

    @BindView(R.id.ed_title)
    EditText edTitle;
    @BindView(R.id.ed_content)
    EditText edContent;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_num01)
    TextView tvNum01;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.mGridView)//术前
            GridView mGridView;
    @BindView(R.id.mGridView01)//术后
            GridView mGridView01;
    @BindView(R.id.ll_shuhou)
    LinearLayout ll_shuhou;
    private String time;
    private List<Map<String, Object>> datas;
    private List<Map<String, Object>> datas01;

    private GridViewAddImgesAdpter gridViewAddImgesAdpter;
    private GridViewAddImgesAdpter gridViewAddImgesAdpter01;
    private String tag;
    private String postFlag;
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
        setContentView(R.layout.activity_edit_diary01);
        title = getIntent().getExtras().getString("title");
        hospital = getIntent().getExtras().getString("hospital");
        service = getIntent().getExtras().getString("service");
        category = getIntent().getExtras().getString("category");
        addtime = getIntent().getExtras().getString("addtime");
        diaryid = getIntent().getExtras().getString("diaryid");
        type = getIntent().getExtras().getString("type");  // 0:康复期日记 1:图文日记
        postFlag = SharedPreferencesUtils.getString(mContext, "postFlag");//0新建 1编辑
        datas = new ArrayList<>();//术前图片
        datas01 = new ArrayList<>();//术后图片
        list = new ArrayList<>();
        list01 = new ArrayList<>();
        initTab();
        initUI();
        PhotoUtils.getInstance().init(this, true, new PhotoUtils.OnSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
                if ("0".equals(tag)) {
                    photoPath(outputFile.getAbsolutePath());
                } else {
                    photoPath1(outputFile.getAbsolutePath());
                }
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

    /**
     * 术后
     */
    List<String> list01;

    public void photoPath1(String path) {
        list01.add(path);
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        //upAvatar(base64);
        datas01.add(map);
        gridViewAddImgesAdpter01.notifyDataSetChanged();
    }

    private void initUI() {
        setBackView();
        if ("0".equals(type)) {
            setTitle("康复期日记");
        } else {
            setTitle("图文日记");

        }
        if ("0".equals(postFlag)) {
            if ("0".equals(type)) {
                ll_shuhou.setVisibility(View.VISIBLE);
            } else {
                ll_shuhou.setVisibility(View.GONE);
            }
        } else {
            ll_shuhou.setVisibility(View.GONE);
        }
        tvNum.setText("0/25");
        tvNum01.setText("0/500字");
        setRightText("发布", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                if (StringUtil.isBlank(time)) {
                    showToast("时间不能为空");
                    return;
                }
                post();
            }
        });

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
                tag = "0";
                ActionSheet.showSheet(EditDiary01Activity.this, EditDiary01Activity.this, null);
            }
        });
        /**
         * 术后图片
         */
        gridViewAddImgesAdpter01 = new GridViewAddImgesAdpter(datas01, this);
        gridViewAddImgesAdpter01.setMaxImages(4);
        mGridView01.setAdapter(gridViewAddImgesAdpter01);
        mGridView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                tag = "1";
                ActionSheet.showSheet(EditDiary01Activity.this, EditDiary01Activity.this, null);
            }
        });
    }

    /**
     * 发布
     */
    private void post() {
        String title = edTitle.getText().toString();
        String content = edContent.getText().toString();
        RequestBody requestApiKey = RequestBody.create(MediaType.parse("multipart/form-data"), openid);
        RequestBody requestApiDiaryid = RequestBody.create(MediaType.parse("multipart/form-data"), diaryid);
        RequestBody requestApiLat = RequestBody.create(MediaType.parse("multipart/form-data"), lat);
        RequestBody requestApiLng = RequestBody.create(MediaType.parse("multipart/form-data"), lng);
        RequestBody requestApiTitle = RequestBody.create(MediaType.parse("multipart/form-data"), title);
        RequestBody requestApiContent = RequestBody.create(MediaType.parse("multipart/form-data"), content);
        RequestBody requestApiTime = RequestBody.create(MediaType.parse("multipart/form-data"), time);
        RequestBody requestApiType = RequestBody.create(MediaType.parse("multipart/form-data"), type);
        List<MultipartBody.Part> list1 = new ArrayList<>();
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
                }
            }
        }
        /**
         * 术后
         */
        List<MultipartBody.Part> list2 = new ArrayList<>();
        if (list01 != null) {
            for (String pathItem : list01) {
                if (!TextUtils.isEmpty(pathItem)) {
                    File file = new File(pathItem);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
                    MultipartBody.Part body = MultipartBody.Part.createFormData("file[]", file.getName(), requestFile);// pictures 是参数名
                    list2.add(body);
                }
            }
        }
        RetrofitUtil.getInstance().submit(requestApiKey, requestApiDiaryid, requestApiLat, requestApiLng, requestApiTitle, requestApiContent, requestApiTime, requestApiType, list1, list2, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                XLog.e("data" + baseResponse.getMsg());
                XLog.e("data" + baseResponse.getCode());
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

    @OnClick({R.id.ll_time})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_time:
                showDatePickDialog(DateType.TYPE_YMD);
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
