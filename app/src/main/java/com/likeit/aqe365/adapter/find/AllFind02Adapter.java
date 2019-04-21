package com.likeit.aqe365.adapter.find;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.find.FollowlistModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.utils.PopupWindowUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.ToastUtils;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.NineGridTestLayout;
import com.likeit.aqe365.view.RoundImageView;

import java.util.List;

import rx.Subscriber;

public class AllFind02Adapter extends BaseQuickAdapter<FollowlistModel.ListBean, BaseViewHolder> {
    private NineGridTestLayout layout;
    private String iscollect;
    private String id;
    private FrameLayout fr_video;
    private RoundImageView iv_video_img;
    private ImageLoaderUtils mImageLoader;

    public AllFind02Adapter(int layoutResId, List<FollowlistModel.ListBean> data) {
        super(R.layout.moodlist_item, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final FollowlistModel.ListBean item) {
        mImageLoader= ImageLoaderUtils.getInstance(mContext);
        mImageLoader.displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_img));
        helper.setText(R.id.tv_title, item.getNickname());
        helper.setText(R.id.tv_content, item.getContent());
        helper.setText(R.id.tv_time, item.getCreatetime());
        helper.setText(R.id.tv_huati, item.getHuati());
        iscollect = item.getIscollect();
        if ("1".equals(iscollect)) {
            helper.setText(R.id.tv_iscollect, mContext.getResources().getString(R.string.ic_collect));
            helper.setTextColor(R.id.tv_iscollect, Color.parseColor("#FFCC00"));
        } else if ("0".equals(iscollect)) {
            helper.setText(R.id.tv_iscollect, mContext.getResources().getString(R.string.ic_iscollect));
            helper.setTextColor(R.id.tv_iscollect, Color.parseColor("#656565"));
        }


        if ("0".equals(item.getIslike())) {
            helper.setText(R.id.tv_likes, mContext.getResources().getString(R.string.ic_isgood) + item.getLikenum());
            helper.setTextColor(R.id.tv_likes, Color.parseColor("#dbdbdb"));
            helper.getView(R.id.tv_likes).setClickable(true);
        } else {
            helper.setText(R.id.tv_likes, mContext.getResources().getString(R.string.ic_good) + item.getLikenum());
            helper.setTextColor(R.id.tv_likes, Color.parseColor("#ff424d"));
            helper.getView(R.id.tv_likes).setClickable(false);
        }

        helper.setText(R.id.tv_views, mContext.getResources().getString(R.string.ic_eyes) + item.getViews());
        helper.setTextColor(R.id.tv_views, Color.parseColor("#dbdbdb"));
        layout = (NineGridTestLayout) helper.getView(R.id.layout_nine_grid);
        fr_video = (FrameLayout) helper.getView(R.id.fr_video);
        iv_video_img = (RoundImageView) helper.getView(R.id.iv_video_img);
        if ("0".equals(item.getType())) {
            layout.setVisibility(View.VISIBLE);
            fr_video.setVisibility(View.GONE);

            layout.setIsShowAll(item.isShowAll);
            layout.setUrlList(item.images);
        } else {
            layout.setVisibility(View.GONE);
            fr_video.setVisibility(View.VISIBLE);
            mImageLoader.displayImage(item.getVideoimage(), iv_video_img);
        }
        helper.addOnClickListener(R.id.tv_iscollect);

        helper.getView(R.id.tv_likes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.setText(R.id.tv_likes, mContext.getResources().getString(R.string.ic_good) + "  " + (Integer.valueOf(item.getLikenum()) + 1));
                helper.setTextColor(R.id.tv_likes, Color.parseColor("#ff424d"));
                String bid = item.getId();
                String pid = "";
                toLike(pid, bid);
            }
        });
        // helper.addOnClickListener(R.id.tv_report);
        helper.getView(R.id.tv_report).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(helper.getView(R.id.tv_report));
            }
        });


    }

    private PopupWindow mPopupWindow;

    //
    private View getPopupWindowContentView() {
        // 一个自定义的布局，作为显示的内容
        int layoutId = R.layout.popup_content_layout;   // 布局ID
        View contentView = LayoutInflater.from(mContext).inflate(layoutId, null);
        View.OnClickListener menuItemOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "Click " + ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                // showProgress("已举报成功！");
                ToastUtils.showToast(mContext, "已举报成功！");
                if (mPopupWindow != null) {
                    mPopupWindow.dismiss();
                }
            }
        };
        contentView.findViewById(R.id.menu_item1).setOnClickListener(menuItemOnClickListener);
        return contentView;
    }

    private void showPopupWindow(View anchorView) {
        View contentView = getPopupWindowContentView();
        mPopupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        // 如果不设置PopupWindow的背景，有些版本就会出现一个问题：无论是点击外部区域还是Back键都无法dismiss弹框
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        // 设置好参数之后再show
        int windowPos[] = PopupWindowUtil.calculatePopWindowPos(anchorView, contentView);
        int xOff = 20; // 可以自己调整偏移
        windowPos[0] -= xOff;
        mPopupWindow.showAtLocation(anchorView, Gravity.TOP | Gravity.START, windowPos[0], windowPos[1]);
    }

    /**
     * 点赞
     *
     * @param pid
     * @param bid
     */
    private void toLike(String pid, String bid) {
        String openid = SharedPreferencesUtils.getString(mContext, "openid");
        RetrofitUtil.getInstance().postlike(openid, bid, pid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    ToastUtils.showToast(mContext, baseResponse.getMsg());
                }
            }
        });
    }


}
