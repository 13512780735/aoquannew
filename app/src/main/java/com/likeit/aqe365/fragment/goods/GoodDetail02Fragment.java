package com.likeit.aqe365.fragment.goods;


import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseFragment;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodDetail02Fragment extends BaseFragment {
    @BindView(R.id.web)
    WebView mWebView;
    private WebSettings mWebSettings;
    private String goodData;
    private JSONObject goods;

    @Override
    protected int setContentView() {
        return R.layout.fragment_good_detail02;
    }

    @Override
    protected void lazyLoad() {
        goodData = getArguments().getString("goodData");
        try {
            JSONObject object = new JSONObject(goodData);
            int code = object.optInt("code");
            String msg = object.optString("msg");
            if (code == 200) {
                //goodData = response;
                JSONObject object1 = object.optJSONObject("data");
                goods = object1.optJSONObject("goods");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mWebView.loadUrl(goods.optString("content"));
        setupUI();
    }

    private void setupUI() {
        mWebView.getSettings().setJavaScriptEnabled(true);
        //   mWebView.addJavascriptInterface(new JsInterfaceLogic(this), "app");
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);    //允许加载javascript
        mWebSettings.setSupportZoom(false);          //允许缩放
        mWebSettings.setBuiltInZoomControls(false);  //原网页基础上缩放
        mWebSettings.setUseWideViewPort(false);      //任意比例缩放
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loaddingDialog.show();

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // mWebView.setVisibility(View.VISIBLE);
                loaddingDialog.dismiss();
                //hideErrorPage();
                //super.onPageFinished(view, url);
//                if (!isError) {
//                    isSuccess = true;
//                    //回调成功后的相关操作
//                  //  ll_control_error.setVisibility(View.GONE);
//                    mWebView.setVisibility(View.VISIBLE);
//                } else {
//                    isError = false;
//                    ll_control_error.setVisibility(View.VISIBLE);
//                }
                mWebView.setVisibility(View.VISIBLE);
            }


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                //6.0以上执行
                mWebView.setVisibility(View.GONE);
                //   ll_control_error.setVisibility(View.VISIBLE);
            }
        });
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
                return false;

            }
        });
    }
}
