package com.likeits.simple.activity.user;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codbking.widget.DatePickDialog;
import com.codbking.widget.OnSureLisener;
import com.codbking.widget.bean.DateType;
import com.elvishew.xlog.XLog;
import com.github.iron.library.linkage.LinkageDialog;
import com.github.iron.library.linkage.LinkageItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guoqi.actionsheet.ActionSheet;
import com.likeits.simple.R;
import com.likeits.simple.activity.good.filter.view.FilterPopupWindow;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.listener.IEditTextChangeListener;
import com.likeits.simple.network.model.BaseResponse;
import com.likeits.simple.network.model.EmptyEntity;
import com.likeits.simple.network.model.gooddetails.ProvincesModel;
import com.likeits.simple.network.model.member.AvatarModel;
import com.likeits.simple.network.model.member.UserInfoModel;
import com.likeits.simple.network.util.RetrofitUtil;
import com.likeits.simple.utils.EditTextSizeCheckUtil;
import com.likeits.simple.utils.StringUtil;
import com.likeits.simple.utils.photo.PhotoUtils;
import com.likeits.simple.view.BorderTextView;
import com.likeits.simple.view.CircleImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import rx.Subscriber;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class UserInfoActivity extends BaseActivity implements ActionSheet.OnActionSheetSelected, EasyPermissions.PermissionCallbacks, View.OnClickListener {
    @BindView(R.id.iv_avatar)//头像
            CircleImageView mIvAvatar;
    @BindView(R.id.tv_bind01)//绑定手机号
            TextView mTvBind;
    @BindView(R.id.ed_nickName) //昵称
            EditText ed_nickName;
    @BindView(R.id.ed_name) //姓名
            EditText ed_name;
    @BindView(R.id.radioGroup) //x性别
            RadioGroup radioGroup;
    @BindView(R.id.radioButton) //
            RadioButton radioButton;
    @BindView(R.id.radioButton1) //
            RadioButton radioButton1;
    @BindView(R.id.tv_birthday) //出生日期
            TextView tv_birthday;
    @BindView(R.id.tv_address) //地址
            TextView tv_address;
    @BindView(R.id.tv_edit) //修改
            BorderTextView tv_edit;
    private String sex="0";
    private UserInfoModel userInfoModel;
    private String province;
    private String city;
    private String area;
    private String time;
    private String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        setBackView();
        setTitle("会员资料");
        initCityBtn();
        initData();
        PhotoUtils.getInstance().init(this, true, new PhotoUtils.OnSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
               // Bitmap bitmap = PhotoUtils.getBitmapFromUri(outputUri, UserInfoActivity.this);

                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), outputUri);
                    XLog.e("bitmap-->"+bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (bitmap != null) {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                    byte[] bytes = baos.toByteArray();
                    String base64Token = Base64.encodeToString(bytes, Base64.DEFAULT);//  编码后
                    upAvatar(base64Token);
                    //  mIvAvatar.setImageBitmap(bitmap);
                }
               Glide.with(UserInfoActivity.this).load(outputUri).into(mIvAvatar);
            }
        });
    }

    private void upAvatar(final String base64Token) {
        XLog.e("base64Token-->"+base64Token);
        LoaddingShow();
        RetrofitUtil.getInstance().UpAvatar(openid, base64Token, new Subscriber<BaseResponse<AvatarModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<AvatarModel> baseResponse) {
                LoaddingDismiss();
                if(baseResponse.getCode()==200){
                    imageUrl=baseResponse.getData().getImage();
                }
            }
        });
    }


    private void initUI() {
        EditTextSizeCheckUtil.textChangeListener textChangeListener = new EditTextSizeCheckUtil.textChangeListener(tv_edit);
        textChangeListener.addAllEditText(ed_nickName);
        EditTextSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if (isHasContent) {
                    tv_edit.setContentColorResource01(Color.parseColor(theme_bg_tex));
                    tv_edit.setStrokeColor01(Color.parseColor(theme_bg_tex));
                    tv_edit.setOnClickListener(UserInfoActivity.this);
                } else {
                    tv_edit.setContentColorResource01(Color.parseColor("#999999"));
                    tv_edit.setStrokeColor01(Color.parseColor("#999999"));
                    // tv_register.setClickable(false);
                }
            }
        });
        tv_edit.setStrokeColor01(Color.parseColor(theme_bg_tex));
        tv_edit.setContentColorResource01(Color.parseColor(theme_bg_tex));
        ImageLoader.getInstance().displayImage(userInfoModel.getAvatar(), mIvAvatar);
        ed_nickName.setText(userInfoModel.getNickname());
        ed_name.setText(userInfoModel.getRealname());
        mTvBind.setText(userInfoModel.getMobile() + "(已绑定)");
        tv_address.setText(userInfoModel.getProvince() + userInfoModel.getCity() + userInfoModel.getArea());
        String gender = userInfoModel.getGender();
        if (!StringUtil.isBlank(userInfoModel.getBirthday())) {
          //  String time = StringUtil.getTime(String.valueOf(Long.valueOf(userInfoModel.getBirthday())*1000));
            String time=StringUtil.getDateToString(Long.valueOf(userInfoModel.getBirthday())*1000,"yyyy-MM-dd");
            XLog.e("time-->"+time);
            tv_birthday.setText(time);
        } else {
            tv_birthday.setHint("请选择出生日期");
        }
        if ("0".equals(gender)) {
            radioButton.setChecked(true);

        } else {
            radioButton1.setChecked(true);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        sex = "0";
                        break;
                    case R.id.radioButton1:
                        sex = "1";
                        break;
                }
            }
        });

    }

    private void initData() {
        LoaddingShow();
        RetrofitUtil.getInstance().GetUserInfo(openid, new Subscriber<BaseResponse<UserInfoModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<UserInfoModel> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.getCode() == 200) {
                    userInfoModel = baseResponse.getData();
                    initUI();
                }
            }
        });
    }

    @OnClick({R.id.rl_bind_phone, R.id.iv_avatar, R.id.ll_birthday})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_bind_phone:
                toActivity(BindPhoneActivity.class);
                break;
            case R.id.iv_avatar:
                ActionSheet.showSheet(UserInfoActivity.this, UserInfoActivity.this, null);
                break;
            case R.id.ll_birthday:
                showDatePickDialog(DateType.TYPE_YMD);
                break;
            case R.id.tv_edit:
             editUserInfo();

                break;
        }
    }

    /**
     * 修改用户
     */
    private void editUserInfo() {
        LoaddingShow();
       String mNickname=ed_nickName.getText().toString().trim();
       String username=ed_name.getText().toString().trim();
        RetrofitUtil.getInstance().UpUserInfo(openid, mNickname, imageUrl, username, sex, time, province, city, area, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                LoaddingDismiss();
                if(baseResponse.getCode()==200){
                    showToast("修改成功");
                    finish();
                }else{
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

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
                tv_birthday.setText(StringUtil.getDate(date, "yyyy-MM-dd"));
                time=String.valueOf((StringUtil.getStringToDate(StringUtil.getDate(date, "yyyy-MM-dd"),"yyyy-MM-dd"))/1000);
                XLog.e("time-->"+time);
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

    private void initCityBtn() {
        //创建对话框
        final LinkageDialog dialog = new LinkageDialog.Builder(UserInfoActivity.this, 3).setLinkageData(getCityList())
                .setOnLinkageSelectListener(new LinkageDialog.IOnLinkageSelectListener() {
                    @Override
                    public void onLinkageSelect(LinkageItem... items) {
                        toastLinkageItem(items);
                    }
                }).build();

        //按钮点击
        findViewById(R.id.ll_address).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    public List<LinkageItem> getCityList() {
        String json = getJson("city.json");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ProvincesModel>>() {
        }.getType();
        List<ProvincesModel> citys = gson.fromJson(json, type);
        List<LinkageItem> cityList = new ArrayList<>();
        cityList.addAll(citys);
        return cityList;
    }

    public String getJson(String fileName) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private void toastLinkageItem(LinkageItem... items) {
        StringBuilder str = new StringBuilder(" ");
        for (int i = 0; i < items.length && items[i] != null; i++) {
            str.append(items[i].getLinkageName());
            province = items[0].getLinkageName();
            city = items[1].getLinkageName();
            area = items[2].getLinkageName();
            //str.append(" ");
        }
        tv_address.setText(province + city + area);
    }


}
