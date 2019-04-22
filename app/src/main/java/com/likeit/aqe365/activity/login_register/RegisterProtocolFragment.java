package com.likeit.aqe365.activity.login_register;


import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.view.BorderTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterProtocolFragment extends BaseFragment {


    private BorderTextView tv_confirm;
    private WebView mWebView;

    public static RegisterProtocolFragment newInstance() {
        Bundle bundle = new Bundle();
        RegisterProtocolFragment fragment = new RegisterProtocolFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        initUI();
        addListeners();
    }

    public void initUI() {
        setBackView();
        setTitle("注册协议");
        tv_confirm = findView(R.id.tv_confirm);
        tv_confirm.setContentColorResource01(Color.parseColor(theme_bg_tex));
        tv_confirm.setStrokeColor01(Color.parseColor(theme_bg_tex));
        mWebView = findView(R.id.webView);
        mWebView.loadUrl("file:///android_asset/Registeragreement.html");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                LoaddingShow();
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                LoaddingDismiss();
                super.onPageFinished(view, url);
            }
        });
    }

    public void addListeners() {
        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_register_protocol;
    }

    @Override
    protected void lazyLoad() {
        initUI();
        addListeners();
    }
}

