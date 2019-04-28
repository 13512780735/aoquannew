package com.likeit.aqe365.fragment.home;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.main.MainNavigationModel;
import com.likeit.aqe365.utils.ImageLoaderUtil;
import com.likeit.aqe365.utils.IntentUtils;
import com.likeit.aqe365.utils.SharedPreferencesUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeAdvFragment extends DialogFragment implements OnItemClickListener {
    private ConvenientBanner mBanner;
    List<MainNavigationModel.StartadvBean.DataBean> adList;
    private List<MainNavigationModel.StartadvBean.DataBean> networkImage = new ArrayList<>();
    private Handler handler;
    private Runnable runnable;
    private ImageView ivClose;
    private String startAdv;

    public HomeAdvFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().setWindowAnimations(R.style.bran_online_supervise_animation);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().setCancelable(true);
        View view = inflater.inflate(R.layout.fragment_home_adv, container, false);
        startAdv = SharedPreferencesUtils.getString(getActivity(), "startAdv");
        initData();
        initUI(view);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }

    private void initData() {

        if (startAdv != null) {
            Type type = new TypeToken<MainNavigationModel.StartadvBean>() {
            }.getType();
            MainNavigationModel.StartadvBean items = new Gson().fromJson(startAdv, type);
            XLog.e("items" + items);
            MainNavigationModel.StartadvBean.ParamsBean paramsBean = items.getParams();
            List<MainNavigationModel.StartadvBean.DataBean> item = items.getData();
            Gson gson = new Gson();
            String json = gson.toJson(item);

            adList = items.getData();
        }
    }

    private void initUI(View view) {
        mBanner = view.findViewById(R.id.banner);
        ivClose = view.findViewById(R.id.iv_close);
//        mBanner.setLayoutParams(new LinearLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, h_screen / 6*2));
        mBanner.startTurning(4000);


        if (adList != null && adList.size() > 0) {
            networkImage = adList;

        }
        initBanner();

        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从闪屏界面跳转到首界面
                dismiss();
            }
        }, 6 * 1000);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    private void initBanner() {
        mBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, adList).setPageIndicator(new int[]{R.drawable.indicator_gray, R.drawable.indicator_red}).setOnItemClickListener(this).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL).setScrollDuration(1500);
    }

    @Override
    public void onItemClick(int position) {
        String id = adList.get(position).getParams().getId();
        String linkUrl = adList.get(position).getLinkurl();
        String webUrl = adList.get(position).getWeburl();
        IntentUtils.intentTo(getActivity(), linkUrl, id, webUrl);


    }

    public class NetworkImageHolderView implements Holder<MainNavigationModel.StartadvBean.DataBean> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, MainNavigationModel.StartadvBean.DataBean data) {
            //  Glide.with(getActivity()).load(data.getImgurl()).into(imageView);

            ImageLoaderUtil.getImageLoader(getActivity()).displayImage(data.getImgurl(), imageView, ImageLoaderUtil.getPhotoImageOption());
        }
    }

}
