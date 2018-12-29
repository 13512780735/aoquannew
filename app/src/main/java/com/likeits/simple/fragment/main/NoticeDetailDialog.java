package com.likeits.simple.fragment.main;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.likeits.simple.R;
import com.zzhoujay.richtext.RichText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeDetailDialog extends Dialog {

    private final String title;
    private final Context context;
    private final String content;

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;


    public NoticeDetailDialog(@NonNull Context context, String title, String content) {
        super(context, R.style.dialogStyle);
        this.context = context;
        this.title = title;
        this.content = content;
        setContentView(R.layout.fragment_notice_detail);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        tvTitle.setText(title);
        //tvContent.setText(Html.fromHtml(content),);
        RichText.from(content).into(tvContent);
    }

    @OnClick({R.id.iv_delete, R.id.tv_confirm})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_delete:
            case R.id.tv_confirm:
                dismiss();
        }
    }
}
