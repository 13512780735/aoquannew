//package com.likeit.aqe365.base;
//
//import android.content.Intent;
//import android.content.res.Resources;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.annotation.IdRes;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.text.TextUtils;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//
//import com.elvishew.xlog.XLog;
//import com.likeit.aqe365.R;
//import com.likeit.aqe365.utils.CustomDialog;
//import com.likeit.aqe365.utils.LoaddingDialog;
//import com.likeit.aqe365.utils.SharedPreferencesUtils;
//import com.shuyu.gsyvideoplayer.GSYVideoManager;
//
//import butterknife.ButterKnife;
//import butterknife.Unbinder;
//import onekeyshare.OnekeyShare;
//
///**
// * Created by admin on 2018/5/10.
// */
//
//public abstract class BaseFragment extends Fragment {
//    /**
//     * 视图是否已经初初始化
//     */
//    protected boolean isInit = false;
//    protected boolean isLoad = false;
//    protected final String TAG = "LazyLoadFragment";
//    private View view;
//    private CustomDialog dialog;
//    private Unbinder unbinder;
//    public LoaddingDialog loaddingDialog;
//    public String openid;
//    public String theme_bg_tex;
//    public String lat,lng;
//
//
//    //是否是第一次开启网络加载
//    public boolean isFirst;
//    //当前Fragment是否处于可见状态标志，防止因ViewPager的缓存机制而导致回调函数的触发
//    private boolean isFragmentVisible;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        // view = inflater.inflate(setContentView(), container, false);
//
//        if (view == null)
//            view = inflater.inflate(setContentView(), container, false);
//        isInit = true;
//        /**初始化的时候去加载数据**/
//        unbinder = ButterKnife.bind(this, view);
//        openid = SharedPreferencesUtils.getString(getActivity(), "openid");
//        theme_bg_tex = SharedPreferencesUtils.getString(getActivity(), "theme_bg_tex");
//        lat = SharedPreferencesUtils.getString(getContext(), "lat");
//        lng = SharedPreferencesUtils.getString(getContext(), "lng");
//        loaddingDialog = new LoaddingDialog(getActivity());
//        //isCanLoadData();
//        lazyLoad();
//        //可见，但是并没有加载过
//        if (isFragmentVisible && !isFirst) {
//            onFragmentVisibleChange(true);
//        }
//        return view;
//    }
//    /**
//     * 当前fragment可见状态发生变化时会回调该方法
//     * 如果当前fragment是第一次加载，等待onCreateView后才会回调该方法，其它情况回调时机跟 {@link #setUserVisibleHint(boolean)}一致
//     * 在该回调方法中你可以做一些加载数据操作，甚至是控件的操作.
//     *
//     * @param isVisible true  不可见 -> 可见
//     *                  false 可见  -> 不可见
//     */
//    protected void onFragmentVisibleChange(boolean isVisible) {
//
//    }
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        LoaddingDismiss();
//        XLog.e("TAG999" + "fragmnet");
//    }
//    public void showShare(String url){
//        Resources res = getActivity().getResources();
//        Bitmap bmp = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//
//        // title标题，微信、QQ和QQ空间等平台使用
//        oks.setTitle("测试分享");
//        // titleUrl QQ和QQ空间跳转链接
//        oks.setTitleUrl("http://sharesdk.cn");
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText("我是分享文本");
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        // oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        oks.setImageData(bmp);
//        // url在微信、微博，Facebook等平台中使用
//        oks.setUrl("http://sharesdk.cn");
//        // comment是我对这条分享的评论，仅在人人网使用
//        oks.setComment("我是测试评论文本");
//        // 启动分享GUI
//        oks.show(getActivity());
//    }
//    /**
//     * 视图是否已经对用户可见，系统的方法
//     */
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        // isCanLoadData();
//        if (isVisibleToUser) {
//            isFragmentVisible = true;
//        }
//        if (view == null) {
//            return;
//        }
//        //可见，并且没有加载过
//        if (!isFirst&&isFragmentVisible) {
//            onFragmentVisibleChange(true);
//            return;
//        }
//        //由可见——>不可见 已经加载过
//        if (isFragmentVisible) {
//            onFragmentVisibleChange(false);
//            isFragmentVisible = false;
//        }
//    }
//
//    /**
//     * 设置显示右侧返回按钮
//     */
//    public void setBackView() {
//        View backView = findViewById(R.id.back_view);
//        if (backView == null) {
//            return;
//        }
//        backView.setVisibility(View.VISIBLE);
//        backView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().finish();
//            }
//        });
//    }
//
//    /**
//     * 设置显示标题
//     *
//     * @param txt
//     */
//    public void setTitle(String txt) {
//        TextView title = (TextView) findViewById(R.id.title);
//        if (title == null) {
//            return;
//        }
//        title.setVisibility(View.VISIBLE);
//        title.setText(txt);
//    }
//
//    /**
//     * 只显示右侧文字以及点击事件
//     *
//     * @param txt
//     * @param onClickListener
//     */
//    public void setRightText(String txt, View.OnClickListener onClickListener) {
//        TextView toolbar_righ_tv = (TextView) findViewById(R.id.toolbar_righ_tv);
//        if (toolbar_righ_tv == null) {
//            return;
//        }
//        ImageView toolbar_righ_iv = (ImageView) findViewById(R.id.toolbar_righ_iv);
//        if (toolbar_righ_iv == null) {
//            return;
//        }
//        toolbar_righ_iv.setVisibility(View.GONE);
//        toolbar_righ_tv.setVisibility(View.VISIBLE);
//        toolbar_righ_tv.setText(txt);
//        toolbar_righ_tv.setOnClickListener(onClickListener);
//    }
//
//    /**
//     * 右侧只显示一个图片
//     *
//     * @param resId
//     * @param onClickListener
//     */
//    public void setRightImage(int resId, View.OnClickListener onClickListener) {
//        TextView toolbar_righ_tv = (TextView) findViewById(R.id.toolbar_righ_tv);
//        if (toolbar_righ_tv == null) {
//            return;
//        }
//        toolbar_righ_tv.setVisibility(View.GONE);
//        ImageView toolbar_righ_iv = (ImageView) findViewById(R.id.toolbar_righ_iv);
//        if (toolbar_righ_iv == null) {
//            return;
//        }
//        toolbar_righ_iv.setVisibility(View.VISIBLE);
//        toolbar_righ_iv.setImageResource(resId);
//        toolbar_righ_iv.setOnClickListener(onClickListener);
//    }
//
//    public <T extends View> T findView(@IdRes int id) {
//        return (T) findViewById(id);
//    }
//
//    /**
//     * 文本View
//     */
//    public TextView textView(int textview) {
//        return (TextView) findViewById(textview);
//    }
//
//    /**
//     * 文本button
//     */
//    public Button button(int id) {
//        return (Button) findViewById(id);
//    }
//
//    /**
//     * 文本button
//     */
//    public ImageView imageView(int id) {
//        return (ImageView) findViewById(id);
//    }
//
//    /**
//     * 文本editText
//     */
//    public EditText editText(int id) {
//        return (EditText) findViewById(id);
//    }
//
//
//    /**
//     * 显示字符串消息
//     *
//     * @param message
//     */
//    public void showProgress(String message) {
//        // dialog = new CustomDialog(getActivity());
//        dialog = new CustomDialog(getActivity()).builder()
//                .setGravity(Gravity.CENTER).setTitle01("提示", getResources().getColor(R.color.sd_color_black))//可以不设置标题颜色，默认系统颜色
//                .setSubTitle(message);
//        dialog.show();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                dialog.dismiss();
//            }
//        }, 1000);
//    }
//
//    /**
//     * 是否可以加载数据
//     * 可以加载数据的条件：
//     * 1.视图已经初始化
//     * 2.视图对用户可见
//     */
//    private void isCanLoadData() {
//        if (!isInit) {
//            return;
//        }
//
//        if (getUserVisibleHint()) {
//            lazyLoad();
//            isLoad = true;
//        } else {
//            if (isLoad) {
//                stopLoad();
//                GSYVideoManager.releaseAllVideos();
//            }
//        }
//    }
//
//    /**
//     * 视图销毁的时候讲Fragment是否初始化的状态变为false
//     */
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        isInit = false;
//        isLoad = false;
//        //   unbinder.unbind();
//    }
//
//    protected void showToast(String message) {
//        if (!TextUtils.isEmpty(message)) {
//            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//    public void LoaddingDismiss() {
//        if (loaddingDialog != null && loaddingDialog.isShowing()) {
//            loaddingDialog.dismiss();
//        }
//    }
//
//    public void LoaddingShow() {
//        if (loaddingDialog == null) {
//            loaddingDialog = new LoaddingDialog(getActivity());
//        }
//
//        if (!loaddingDialog.isShowing()) {
//            loaddingDialog.show();
//        }
//    }
//
//    /**
//     * 设置Fragment要显示的布局
//     *
//     * @return 布局的layoutId
//     */
//    protected abstract int setContentView();
//
//    /**
//     * 获取设置的布局
//     *
//     * @return
//     */
//    protected View getContentView() {
//        return view;
//    }
//
//    /**
//     * 找出对应的控件
//     *
//     * @param id
//     * @param <T>
//     * @return
//     */
//    protected <T extends View> T findViewById(int id) {
//
//        return (T) getContentView().findViewById(id);
//    }
//
//    /**
//     * 当视图初始化并且对用户可见的时候去真正的加载数据
//     */
//    protected abstract void lazyLoad();
//
//    /**
//     * 当视图已经对用户不可见并且加载过数据，如果需要在切换到其他页面时停止加载数据，可以调用此方法
//     */
//    protected void stopLoad() {
//    }
//
//    protected void toFinish() {
//        getActivity().finish();
//    }
//
//    public void toActivityFinish(Class activity) {
//        Intent intent = new Intent(getActivity(), activity);
//        startActivity(intent);
//        toFinish();
//    }
//
//    public void toActivity(Class activity) {
//        Intent intent = new Intent(getActivity(), activity);
//        startActivity(intent);
//    }
//
//    public void toActivity(Class activity, Bundle bundle) {
//        Intent intent = new Intent(getActivity(), activity);
//        intent.putExtras(bundle);
//        startActivity(intent);
//    }
//}
