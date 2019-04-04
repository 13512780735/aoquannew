package com.likeit.aqe365.fragment.find;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.utils.ToastUtils;

import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryCommentFragment extends DialogFragment {

    EditText edContent;
    private ImageView iv_colse;
    private TextView tv_post;
    private String diaryid, rdid, mdid;
    private String content;

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    private MyDialogFragment_Listener myDialogFragment_Listener;

    // 回调接口，用于传递数据给Activity -------
    public interface MyDialogFragment_Listener {
        void getDataFrom_DialogFragment(String Data01);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            myDialogFragment_Listener = (MyDialogFragment_Listener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implementon MyDialogFragment_Listener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().setWindowAnimations(R.style.bran_online_supervise_animation);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().setCancelable(true);
        View view = inflater.inflate(R.layout.fragment_comment_dialog, container, false);
        diaryid = getArguments().getString("diaryid");
        rdid = getArguments().getString("rdid");
        mdid = getArguments().getString("mdid");
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        edContent = view.findViewById(R.id.ed_content);
        iv_colse = view.findViewById(R.id.iv_colse);
        tv_post = view.findViewById(R.id.tv_post);
        iv_colse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        tv_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content = edContent.getText().toString().trim();
                post(content);

                dismiss();
            }
        });
    }

    // DialogFragment关闭时回传数据给Activity
    @Override
    public void onDestroy() {
        // 通过接口回传数据给activity
        if (myDialogFragment_Listener != null) {
            myDialogFragment_Listener.getDataFrom_DialogFragment(content);
        }
        super.onDestroy();
    }

    private void post(String content) {
        String openid = SharedPreferencesUtils.getString(getActivity(), "openid");
        XLog.e("openid:" + openid);
        XLog.e("content:" + content);
        XLog.e("diaryid:" + diaryid);
        XLog.e("rdid:" + rdid);
        XLog.e("mdid:" + mdid);
        if (StringUtil.isBlank(this.content)) {
            ToastUtils.showToast(getActivity(), "内容不能为空");
            return;
        }
        RetrofitUtil.getInstance().diaryReply(openid, diaryid, rdid, mdid, content, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    ToastUtils.showToast(getActivity(), baseResponse.getMsg());
                    //   mCommentCompleted.inputCommentCompleted("1");
                    dismiss();

                } else {
                    ToastUtils.showToast(getActivity(), baseResponse.getMsg());
                }
            }
        });
    }

}
