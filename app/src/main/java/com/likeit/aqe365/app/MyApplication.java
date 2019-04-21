package com.likeit.aqe365.app;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.mob.MobSDK;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
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
       initBugly();
        GImageLoader.init(this, new OkHttpClient.Builder().build());  //图片加载初始化
        initLogger();//日志打印初始化
        initData1();

        MobSDK.init(this);//shareSDk初始化
        // ZXingLibrary.initDisplayOpinion(this);
        // initX5WebView();
        // DemoHelper.getInstance().init(mContext);
        //
        //                                             initX5WebView();
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
                .showImageForEmptyUri(R.mipmap.default_pic)
                .showImageOnFail(R.mipmap.default_pic)
                .cacheInMemory(true).cacheOnDisc(false).build();
        // 图片加载工具配置
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .defaultDisplayImageOptions(defaultOptions)
                .discCacheSize(500 * 1024 * 1024)//
                .discCacheFileCount(300)// 缓存一百张图片
                .writeDebugLogs().build();
        ImageLoader.getInstance().init(config);
    }

}
