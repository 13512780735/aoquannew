package com.likeit.aqe365.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.BuildConfig;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.main.MainNavigationModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.image.GImageLoader;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import okhttp3.OkHttpClient;
import rx.Subscriber;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";
    public static MyApplication mContext;
    private static MyApplication instance;
    public static Context applicationContext;
    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationOption;

    public static MyApplication getInstance() {
        if (mContext == null) {
            return new MyApplication();
        } else {
            return mContext;
        }
    }

    @Override
    public void onCreate() {
        // MultiDex.install(this);
        super.onCreate();
        initImageLoad();
        instance = this;
        applicationContext = this;
        // initBugly();
        GImageLoader.init(this, new OkHttpClient.Builder().build());  //图片加载初始化
        initLogger();//日志打印初始化
        initData1();
        addGeoFence();//获取高德定位坐标
        // ZXingLibrary.initDisplayOpinion(this);
        // initX5WebView();
        //MobSDK.init(this);//shareSDk初始化
        // DemoHelper.getInstance().init(mContext);
        //                                                           initX5WebView();
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


    private void initData1() {
        RetrofitUtil.getInstance().getMainNavigation("1", new Subscriber<BaseResponse<MainNavigationModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<MainNavigationModel> baseResponse) {
                XLog.d(baseResponse.getCode());
                if (baseResponse.getCode() == 200) {
                    MainNavigationModel mainNavigationModel = baseResponse.getData();
                    SharedPreferencesUtils.put(mContext, "iconcolor", baseResponse.getData().getStyle().getIconcolor());
                    SharedPreferencesUtils.put(mContext, "iconcoloron", baseResponse.getData().getStyle().getIconcoloron());
//                    List<MainNavigationModel.ItemsBean> items = mainNavigationModel.getItems();
//                    for (int i = 0; i < items.size(); i++) {
//                        mTitles[i] = items.get(i).getText();
//                        mIconSelectIds[i] = items.get(i).getIconclasscode();
//                    }
//                    XLog.e(mTitles);
//                    XLog.e(mIconSelectIds);
                }
            }
        });
    }

    private void initLogger() {
        XLog.init(BuildConfig.DEBUG ? LogLevel.ALL : LogLevel.NONE,
                config);
    }

    LogConfiguration config = new LogConfiguration.Builder()
            .tag("HL").build();

    /**
     * Bugly更新
     */
    private void initBugly() {
        Bugly.init(getApplicationContext(), "54573e34e3", false);
        Beta.autoCheckUpgrade = true;//设置自动检查
        Beta.upgradeCheckPeriod = 60 * 60 * 1000;
        Beta.largeIconId = R.mipmap.ic_launcher;

    }

    public static MyApplication getInstance(Context mContext) {
        return instance;
    }


//    private void initX5WebView() {
//        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
//        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
//            @Override
//            public void onViewInitFinished(boolean arg0) {
//                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
//                Log.d("app", " onViewInitFinished is " + arg0);
//            }
//
//            @Override
//            public void onCoreInitFinished() {
//            }
//        };
//        //x5内核初始化接口
//        QbSdk.initX5Environment(getApplicationContext(), cb);
//    }

    private void initImageLoad() {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.mipmap.icon_default)
                .showImageOnFail(R.mipmap.icon_default)
                .cacheInMemory(true).cacheOnDisc(true).build();
        // 图片加载工具配置
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .discCacheSize(50 * 1024 * 1024)//
                .discCacheFileCount(100)// 缓存一百张图片
                .writeDebugLogs().build();
        ImageLoader.getInstance().init(config);
    }

}
