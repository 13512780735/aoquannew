package com.likeit.aqe365.fragment.find;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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

public class JournalCommentFragment extends DialogFragment {
    EditText edContent;
    private ImageView iv_colse;
    private TextView tv_post;
    private String diaryid, cid, rcid, mcid;
    private String content;

    private MyDialogFragment_Listener myDialogFragment_Listener;
    private String nickName;
    private String flag;

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
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }


    // 回调接口，用于传递数据给Activity -------
    public interface MyDialogFragment_Listener {
        void getDataFrom_DialogFragment(String Data01);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().setWindowAnimations(R.style.bran_online_supervise_animation);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().setCancelable(true);
        View view = inflater.inflate(R.layout.fragment_comment_dialog, container, false);
        Bundle bundle = getArguments();
        diaryid = bundle.getString("bid");
        cid = bundle.getString("rpid");
        rcid = bundle.getString("mpid");
        mcid = bundle.getString("pid");
        flag = bundle.getString("flag"); //0是最外层评论 1是里面的回复
        nickName = getArguments().getString("nickName");
        initUI(view);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return view;
    }

    private void initUI(View view) {
        edContent = view.findViewById(R.id.ed_content);
        iv_colse = view.findViewById(R.id.iv_colse);
        tv_post = view.findViewById(R.id.tv_post);
        if ("0".equals(flag)) {
            edContent.setHint("评论：");
        } else {
            edContent.setHint("回复：" + nickName);
        }
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
                post();
                dismiss();
            }
        });
    }

    private void post() {
        String openid = SharedPreferencesUtils.getString(getActivity(), "openid");
        XLog.e("openid:" + openid);
        XLog.e("content:" + content);
        XLog.e("pid:" + diaryid);
        XLog.e("bid:" + cid);
        XLog.e("rpid:" + rcid);
        XLog.e("mpid:" + mcid);
        if (StringUtil.isBlank(content)) {
            ToastUtils.showToast(getActivity(), "内容不能为空");
            return;
        }
        RetrofitUtil.getInstance().replyJournal(openid, diaryid, cid, rcid, mcid, content, new Subscriber<BaseResponse<EmptyEntity>>() {
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
                    dismiss();
                } else {
                    ToastUtils.showToast(getActivity(), baseResponse.getMsg());
                }
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

}
