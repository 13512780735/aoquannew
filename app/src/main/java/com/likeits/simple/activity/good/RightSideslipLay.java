package com.likeits.simple.activity.good;

import android.content.Context;
import android.widget.RelativeLayout;

public class RightSideslipLay extends RelativeLayout{
    private final Context mContext;

    public RightSideslipLay(Context context) {
        super(context);
        mContext = context;
        inflateView();
    }

    private void inflateView() {

    }

    // 外部接口暴露
    /**
     * 创建CloseMenuCallBack接口
     */
    private CloseMenuCallBack menuCallBack;

    public interface CloseMenuCallBack {
        void setupCloseMean();
    }

    public void setCloseMenuCallBack(CloseMenuCallBack menuCallBack) {
        this.menuCallBack = menuCallBack;
    }

}
