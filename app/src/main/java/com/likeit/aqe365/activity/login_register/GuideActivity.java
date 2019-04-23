package com.likeit.aqe365.activity.login_register;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.MainActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.view.guide.BGABanner;
import com.likeit.aqe365.view.guide.BGALocalImageSize;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class GuideActivity extends BaseActivity {
    /**
     * 首頁底部按鈕數據
     */
    private String[] mIconSelectIds;//标题
    private String[] mTitles;//未选中
    private ArrayList<Fragment> mFragments = new ArrayList<>();//Fragment 集合
    private String[] mLinkurl;

    private GuideActivity mContext;
    private static final String TAG = GuideActivity.class.getSimpleName();
    private BGABanner mBackgroundBanner;
    private Handler handler;
    private Runnable runnable;
    Timer timer = new Timer();

    private int recLen;//跳过倒计时提示5秒
    private String adList;
    private String isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mContext = this;
        //状态栏透明
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        mTitles = getIntent().getStringArrayExtra("mTitles");
        mLinkurl = getIntent().getStringArrayExtra("mLinkurl");
        mIconSelectIds = getIntent().getStringArrayExtra("mIconSelectIds");
        //
        recLen = Integer.valueOf(getIntent().getStringExtra("recLen"));
        isLogin = SharedPreferencesUtils.getString(mContext, "isLogin");
        //recLen = 20;
        adList = getIntent().getStringExtra("adList");
        XLog.e("adList"+adList);
        initView();
        setListener();
        processLogic();
        //  timer.schedule(task, 1000, 1000);
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() { // UI thread
                @Override
                public void run() {
                    recLen--;
                    //  tv.setText("跳过 " + recLen);
                    if (recLen < 0) {
                        timer.cancel();
                        // tv.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };

    private void initView() {
        setContentView(R.layout.activity_guide);
        mBackgroundBanner = findViewById(R.id.banner_guide_background);
      //  Button btn_guide_enter = findView(R.id.btn_guide_enter);
        //  btn_guide_enter.setBackgroundColor(Color.parseColor("#000000"));
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到首界面

                if ("0".equals(isLogin)) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("mTitles", mTitles);
                    bundle.putStringArray("mLinkurl", mLinkurl);
                    bundle.putStringArray("mIconSelectIds", mIconSelectIds);
                    bundle.putString("flag", "0");
                    bundle.putInt("index", 0);
                    Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("linkurl", "");
                    toActivity(LoginActivity.class, bundle);
                    finish();
                }
            }
        }, recLen * 1000);//延迟5S后发送handler信息
    }

    private void setListener() {


        /**
         * 设置进入按钮和跳过按钮控件资源 id 及其点击事件
         * 如果进入按钮和跳过按钮有一个不存在的话就传 0
         * 在 BGABanner 里已经帮开发者处理了防止重复点击事件
         * 在 BGABanner 里已经帮开发者处理了「跳过按钮」和「进入按钮」的显示与隐藏
         */
        mBackgroundBanner.setEnterSkipViewIdAndDelegate(0,R.id.tv_guide_skip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                if ("0".equals(isLogin)) {
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("mTitles", mTitles);
                    bundle.putStringArray("mLinkurl", mLinkurl);
                    bundle.putString("flag", "0");
                    bundle.putInt("index", 0);
                    bundle.putStringArray("mIconSelectIds", mIconSelectIds);
                    Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("linkurl", "");
                    toActivity(LoginActivity.class, bundle);
                    finish();
                }
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
            }
        });
    }

    private void processLogic() {
        // Bitmap 的宽高在 maxWidth maxHeight 和 minWidth minHeight 之间
        BGALocalImageSize localImageSize = new BGALocalImageSize(720, 1280, 320, 640);
//        // 设置数据源
//        mBackgroundBanner.setData(localImageSize, ImageView.ScaleType.CENTER_CROP,
//                R.drawable.uoko_guide_background_1,
//                R.drawable.uoko_guide_background_2,
//                R.drawable.uoko_guide_background_3);

//        //设置图片宽高比
//        float scale = (float) 16 / (float) 9;
//        //获取屏幕的宽度
//        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
//        Point size = new Point();
//        wm.getDefaultDisplay().getSize(size);
//        int screenWidth = size.x;
//        //计算BGABanner的应有高度
//        int viewHeight = Math.round(screenWidth / scale);
//        //设置BGABanner的宽高属性
//        final ViewGroup.LayoutParams banner_params = mBackgroundBanner.getLayoutParams();
//        banner_params.width = screenWidth;
//        banner_params.height = viewHeight;
//        mBackgroundBanner.setLayoutParams(banner_params);
        Type type = new TypeToken<List<String>>() {
        }.getType();
        final List<String> items = new Gson().fromJson(adList, type);
        // mBackgroundBanner.setData(localImageSize, ImageView.ScaleType.CENTER_CROP, items.size());
        mBackgroundBanner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {

                Glide.with(GuideActivity.this)
                        .load(model)
                        .centerCrop()
                        .dontAnimate()
                        .into(itemView);
            }
        });

        mBackgroundBanner.setData(items, null);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // 如果开发者的引导页主题是透明的，需要在界面可见时给背景 Banner 设置一个白色背景，避免滑动过程中两个 Banner 都设置透明度后能看到 Launcher
        mBackgroundBanner.setBackgroundResource(android.R.color.white);
    }
}
