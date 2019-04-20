package com.likeit.aqe365.activity;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.login_register.WelcomeActivity;
import com.likeit.aqe365.fragment.main.Cart02Fragment;
import com.likeit.aqe365.fragment.main.CartFragment;
import com.likeit.aqe365.fragment.main.CategoryFragment;
import com.likeit.aqe365.fragment.main.CommissionFragment;
import com.likeit.aqe365.fragment.main.FindFragment;
import com.likeit.aqe365.fragment.main.GoodsFragment;
import com.likeit.aqe365.fragment.main.HomeFragment;
import com.likeit.aqe365.fragment.main.MemberFragment;
import com.likeit.aqe365.fragment.main.NoticeFragment;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.photo.PhotoUtils;
import com.likeit.aqe365.view.tablayout.widget.AbstractCommonTabLayout;
import com.unistrong.yang.zb_permission.ZbPermission;
import com.zhaoshuang.weixinrecorded.RecordedActivity;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


public class MainActivity extends AbstractCommonTabLayout implements EasyPermissions.PermissionCallbacks  {
    private String[] mIconSelectIds;//标题

    private String[] mTitles;//未选中

    private String[] mLinkurl;
    private ArrayList<Fragment> mFragments = new ArrayList<>();//Fragment 集合
    private String flag;
    private String linkurl;
    private int index;
    private String TAG;

    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationOption;
    private boolean isSuccess;

    /**
     * 设置布局文件
     */
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
        // initData1();//获取导航数据


    }

    String[] takeLocation= {ACCESS_FINE_LOCATION,ACCESS_COARSE_LOCATION};
    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        super.initData();
        //setSelectDefaultIndex(0);//设置默认的选项
        /**
         * 获取权限问题
         */
        checkPermission(takeLocation, 1);


        flag = getIntent().getExtras().getString("flag");
        index = getIntent().getExtras().getInt("index");
        if ("0".equals(flag)) {
            setSelectDefaultIndex(0);
        } else if ("1".equals(flag)) {
            setSelectDefaultIndex(index);
        } else if ("2".equals(flag)) {
            setSelectDefaultIndex(1);
        } else if ("3".equals(flag)) {
            setSelectDefaultIndex(2);
        } else if ("4".equals(flag)) {
            setSelectDefaultIndex(3);
        } else if ("5".equals(flag)) {
            setSelectDefaultIndex(4);
        }
        // setShowDot(3);
        // setUnReadMsg(2, 5, Color.parseColor("#FF0000"));
        //   setDivisionLine(Color.parseColor("#6D8FB0"),0.5F,20);
    }

    private void checkPermission(String[] perms, int requestCode) {
        if (EasyPermissions.hasPermissions(this, perms)) {//已经有权限了
            switch (requestCode) {
                case 1:
                    addGeoFence();//获取高德定位坐标
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
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        switch (requestCode) {
            case 1:
                addGeoFence();//获取高德定位坐标
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

    /**
     * 标题数组
     **/
    @Override
    protected String[] getTitles() {
        return mTitles;
    }

    /**
     * 选择图标数组
     **/
    @Override
    protected String[] getIconSelectIds() {
        return mIconSelectIds;
    }


    /**
     * Fragment 集合
     **/
    @Override
    protected ArrayList<Fragment> getFragmentList() {
        mTitles = getIntent().getStringArrayExtra("mTitles");
        mLinkurl = getIntent().getStringArrayExtra("mLinkurl");
        mIconSelectIds = getIntent().getStringArrayExtra("mIconSelectIds");

        for (String linkurl : mLinkurl) {
            if ("home".equals(linkurl)) {
                mFragments.add(new HomeFragment());
            } else if ("goods".equals(linkurl)) {
                mFragments.add(new GoodsFragment());
            } else if ("commission".equals(linkurl)) {
                mFragments.add(new CommissionFragment());
            } else if ("cart".equals(linkurl)) {
                mFragments.add(new CartFragment());
            } else if ("member".equals(linkurl)) {
                mFragments.add(new MemberFragment());
            } else if ("notice".equals(linkurl)) {
                mFragments.add(new NoticeFragment());
            } else if ("category".equals(linkurl)) {
                mFragments.add(new CategoryFragment());
            } else if ("discover".equals(linkurl)) {
                mFragments.add(new FindFragment());
            } else if ("mynotice".equals(linkurl)) {
                mFragments.add(new NoticeFragment());
            }
        }
        return mFragments;
    }

    /**
     * CommonTabLayout 资源id
     **/
    @Override
    protected int getCommonTabLayout() {
        return R.id.tl_2;
    }

    /**
     * ViewPager 资源id
     **/
    @Override
    protected int getCommonViewPager() {
        return R.id.vp_2;
    }

    private void addGeoFence() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        double latitude = aMapLocation.getLatitude();//获取纬度
                        double longitude = aMapLocation.getLongitude();//获取经度

                        String city = aMapLocation.getCity();
                        Log.d(TAG, city);
                        SharedPreferencesUtils.put(mContext, "lat", String.valueOf(latitude));
                        SharedPreferencesUtils.put(mContext, "lng", String.valueOf(longitude));
                        SharedPreferencesUtils.put(mContext, "city", city);
                        Log.d("TAG989", city + String.valueOf(longitude) + String.valueOf(latitude) + aMapLocation.getProvince());
                        // upLoadLocation(latitude, longitude);
                    } else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        SharedPreferencesUtils.put(mContext, "city", "定位失败");
                        Log.e("AmapError", "location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(100000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }


}
