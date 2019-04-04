package com.likeit.aqe365.activity.find;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.find.DiaryDetailsAdapter;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.fragment.find.DiaryCommentFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.find.DiarydetailsModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.ToastUtils;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.CircleImageView;
import com.likeit.aqe365.view.IconfontTextView;
import com.likeit.aqe365.view.RatioImageView;
import com.likeit.aqe365.view.RoundImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Subscriber;

/**
 * 日记本详情
 */
public class DiaryDetailsActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener<ScrollView> {

    private String title, diaryid, memberid;
    private int w_screen;
    private int h_screen;


    @BindView(R.id.ll_photos)
    LinearLayout ll_photos;
    @BindView(R.id.mScrollview)
    PullToRefreshScrollView mScrollview;

    @BindView(R.id.iv_avatar)
    CircleImageView ivAvatar;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_attention)
    BorderTextView tvAttention;
    @BindView(R.id.iv_shuqian)
    RoundImageView ivShuqian;
    @BindView(R.id.iv_shuhou)
    RoundImageView ivShuhou;
    @BindView(R.id.tv_shuqian)
    TextView tvShuqian;
    @BindView(R.id.tv_shuhou)
    TextView tvShuhou;
    @BindView(R.id.tv_hospitalName)
    TextView tvHospitalName;
    @BindView(R.id.tv_hospital_title)
    TextView tvHospital_title;
    @BindView(R.id.tv_hospital_content)
    TextView tvHospital_content;
    @BindView(R.id.iv_hospital_pic)
    RatioImageView ivHospitalPic;

    /**
     * 日记列表
     *
     * @param savedInstanceState
     */

    @BindView(R.id.mRecyclerView_diray)
    RecyclerView mRecyclerViewDiray;
    @BindView(R.id.tv_diray_num)
    BorderTextView tvDirayNum;
    /**
     * 评论列表
     *
     * @param savedInstanceState
     */
    @BindView(R.id.mRecyclerView_comment)
    RecyclerView mRecyclerViewComment;
    @BindView(R.id.tv_comment_num)
    BorderTextView tvCommentNum;
    @BindView(R.id.tv_comment_num01)
    TextView tvCommentNum01;

    /**
     * 底部
     *
     * @param savedInstanceState
     */
    @BindView(R.id.tv_isgood)
    IconfontTextView tv_isgood;
    @BindView(R.id.tv_views)
    IconfontTextView tv_views;
    @BindView(R.id.tv_iscollect)
    IconfontTextView tv_iscollect;
    private DiarydetailsModel.DiaryBean diaryBean;
    private List<DiarydetailsModel.JournalBean> diaryData;
    private List<DiarydetailsModel.CommentBean> commentData;
    private DiarydetailsModel diarydetailsModel;
    private String iscollect;
    private String isuser;
    private String isLike;
    private Bundle bundle;
    private String commentid;
    private DiaryCommentFragment dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diray_details);
        title = getIntent().getExtras().getString("title");
        diaryid = getIntent().getExtras().getString("diaryid");
        SharedPreferencesUtils.put(this, "diaryId", diaryid);
        memberid = getIntent().getExtras().getString("memberid");
        setBackView();
        setRightText02(getResources().getString(R.string.ic_share), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare("");
            }
        });
        setTitle(title);
        //initUI();
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        w_screen = dm.widthPixels;
        h_screen = (w_screen / 2) - 15;
        ll_photos.setLayoutParams(new LinearLayout.LayoutParams(w_screen, h_screen));
        initData();
    }

    private void initData() {
        //  LoaddingShow();
        RetrofitUtil.getInstance().diarydetails(openid, memberid, diaryid, "1", new Subscriber<BaseResponse<DiarydetailsModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<DiarydetailsModel> baseResponse) {
                //LoaddingDismiss();
                if (baseResponse.getCode() == 200) {
                    diarydetailsModel = baseResponse.getData();
                    diaryBean = diarydetailsModel.getDiary();
                    diaryData = diarydetailsModel.getJournal();
                    commentData = diarydetailsModel.getComment();

                    initUI();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    private void initUI() {
        if ("0".equals(diaryBean.getType())) {
            ll_photos.setVisibility(View.VISIBLE);
        } else {
            ll_photos.setVisibility(View.GONE);
        }
        //  mScrollview.setMode(PullToRefreshBase.Mode.DISABLED);
        mScrollview.setOnRefreshListener(this);
        mScrollview.setBackgroundColor(this.getResources().getColor(R.color.white));
        ImageLoader.getInstance().displayImage(diaryBean.getAvatar(), ivAvatar);
        tvName.setText(diaryBean.getNickname());
        tvContent.setText(diaryBean.getCity() + diaryBean.getAddtime());
        tvHospitalName.setText("测试医院");
        tvHospital_title.setText("服务标题");
        tvHospital_content.setText("¥ " + 65.00);
        iscollect = diaryBean.getIscollect();
        isuser = diaryBean.getIsuser();
        isLike = diaryBean.getIslike();
        ImageLoader.getInstance().displayImage(diaryBean.getRecovery_image(), ivShuqian);
        ImageLoader.getInstance().displayImage(diaryBean.getImage_text(), ivShuhou);
        tvShuqian.setText(diaryBean.getRecovery_num() + "");
        tvShuhou.setText(diaryBean.getImage_text_num() + "");
        tv_views.setText(getResources().getString(R.string.ic_comment) + " " + commentData.size());
        tv_views.setTextColor(Color.parseColor("#656565"));
        tvCommentNum01.setText(commentData.size() + "条");
        tvCommentNum.setText("查看更多评论");
        tvDirayNum.setVisibility(View.VISIBLE);
      //  tvDirayNum.setText("查看全部" + diarydetailsModel.getJournaltotal() + "个日记");
        if ((Integer.valueOf(diarydetailsModel.getJournaltotal()) > 5)) {
            tvDirayNum.setVisibility(View.VISIBLE);
            tvDirayNum.setText("查看全部" + diarydetailsModel.getJournaltotal() + "个日记");
        } else {
            tvDirayNum.setVisibility(View.GONE);
        }

        if ((Integer.valueOf(diaryBean.getReplycount()) > 3)) {
            tvCommentNum.setVisibility(View.VISIBLE);
            tvCommentNum.setText("查看更多评论");
        } else {
            tvCommentNum.setVisibility(View.GONE);
        }
        /**
         * 评论
         */
        PostDeatilAdapter mAdapter = new PostDeatilAdapter(R.layout.postdetails_comment02_items, commentData);
        mRecyclerViewComment.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerViewComment.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        /**
         * 日记
         */
        DiaryDetailsAdapter mAdapter01 = new DiaryDetailsAdapter(R.layout.diary_deatils_items, diaryData);
        mRecyclerViewDiray.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerViewDiray.setAdapter(mAdapter01);
        mAdapter01.notifyDataSetChanged();
        if ("1".equals(iscollect)) {
            tv_iscollect.setText(getResources().getString(R.string.ic_collect));
            tv_iscollect.setTextColor(Color.parseColor("#FFCC00"));
        } else if ("0".equals(iscollect)) {
            tv_iscollect.setText(getResources().getString(R.string.ic_iscollect));
            tv_iscollect.setTextColor(Color.parseColor("#656565"));
        }

        if ("0".equals(isuser)) {
            tvAttention.setContentColorResource01(Color.parseColor(theme_bg_tex));
            tvAttention.setStrokeColor01(Color.parseColor(theme_bg_tex));
            tvAttention.setTextColor(Color.parseColor("#ffffff"));
            tvAttention.setText("+ 关注");
        } else {
            tvAttention.setContentColorResource01(Color.parseColor("#FFFFFF"));
            tvAttention.setStrokeColor01(Color.parseColor("#DBDBDB"));
            tvAttention.setTextColor(Color.parseColor("#DBDBDB"));
            tvAttention.setText("已关注");
        }

        if ("1".equals(diaryBean.getIslike())) {
            tv_isgood.setText(getResources().getString(R.string.ic_good) + " " + diaryBean.getLikenum());
            tv_isgood.setTextColor(Color.parseColor("#ff424d"));
            tv_isgood.setClickable(false);
        } else {
            tv_isgood.setText(getResources().getString(R.string.ic_isgood) + " " + diaryBean.getLikenum());
            tv_isgood.setTextColor(Color.parseColor("#656565"));
            tv_isgood.setClickable(true);
        }
        mAdapter01.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String id = diaryData.get(position).getId();
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                toActivity(JournalDetailsActivity.class, bundle);
            }
        });
        mAdapter01.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String cid = "";
                String diaryid = diaryData.get(position).getId();
                toLike01(diaryid, cid);
            }
        });
    }

    @OnClick({R.id.tv_iscollect, R.id.tv_comment_num, R.id.tv_isgood, R.id.tv_views, R.id.tv_attention, R.id.tv_diray_num, R.id.ll_userInfo})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_iscollect://收藏
                if ("0".equals(iscollect)) {
                    tv_iscollect.setText(getResources().getString(R.string.ic_collect));
                    tv_iscollect.setTextColor(Color.parseColor("#FFCC00"));
                    iscollect = "1";
                } else {
                    tv_iscollect.setText(getResources().getString(R.string.ic_iscollect));
                    tv_iscollect.setTextColor(Color.parseColor("#656565"));
                    iscollect = "0";
                }
                collectpost();
                break;
            case R.id.tv_comment_num://更多评论
                bundle = new Bundle();
                bundle.putString("type", "diary");
                bundle.putString("diaryid", diaryid);
                bundle.putString("id", "");
                toActivity(MoreCommentActivity.class, bundle);
                break;
            case R.id.tv_diray_num://更多日记
                bundle = new Bundle();
                bundle.putString("memberid", diaryBean.getMemberid());
                bundle.putString("diaryid", diaryid);
                toActivity(MoreDiaryActivity.class, bundle);
                break;
            case R.id.tv_isgood://点赞
                tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + (Integer.valueOf(diaryBean.getLikenum()) + 1));
                tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                /**
                 * 点赞
                 */
                String commentid = "";//帖子id
                toLike(diaryid, commentid);
                break;
            case R.id.tv_views://回复
                String rdid = "";
                String mdid = "";
                dialog = new DiaryCommentFragment();
                Bundle bundle = new Bundle();
                bundle.putString("diaryid", diaryid);
                bundle.putString("rdid", rdid);
                bundle.putString("mdid", mdid);
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "tag");

                break;
            case R.id.tv_attention://关注
                if ("0".equals(isuser)) {
                    isuser = "1";
                    tvAttention.setContentColorResource01(Color.parseColor("#FFFFFF"));
                    tvAttention.setStrokeColor01(Color.parseColor("#DBDBDB"));
                    tvAttention.setTextColor(Color.parseColor("#DBDBDB"));
                    tvAttention.setText("已关注");
                } else {
                    isuser = "0";
                    tvAttention.setContentColorResource01(Color.parseColor(theme_bg_tex));
                    tvAttention.setStrokeColor01(Color.parseColor(theme_bg_tex));
                    tvAttention.setTextColor(Color.parseColor("#ffffff"));
                    tvAttention.setText("+ 关注");
                }
                attention();
                break;
            case R.id.ll_userInfo://用户中心
                bundle = new Bundle();
                bundle.putString("id", diaryBean.getMemberid());
                bundle.putString("isuser", diaryBean.getIsuser());
                bundle.putString("avatar", diaryBean.getAvatar());
                bundle.putString("name", diaryBean.getNickname());

                SharedPreferencesUtils.put(mContext, "avatar", diaryBean.getAvatar());
                SharedPreferencesUtils.put(mContext, "name", diaryBean.getNickname());
                toActivity(UserInfoActivity.class, bundle);
                break;
        }
    }

    @Override
    public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
        initData();
        mScrollview.onRefreshComplete();
    }

    public class PostDeatilAdapter extends BaseQuickAdapter<DiarydetailsModel.CommentBean, BaseViewHolder> {

        public PostDeatilAdapter(int layoutResId, List<DiarydetailsModel.CommentBean> data) {
            super(R.layout.postdetails_comment_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final DiarydetailsModel.CommentBean item) {
            ImageLoader.getInstance().displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_avatar));
            final IconfontTextView tv_isgood = helper.getView(R.id.tv_isgood);
            helper.setText(R.id.tv_title, item.getNickname());
            helper.setText(R.id.tv_content, item.getReplycontent());
            helper.setText(R.id.tv_time, item.getReplytime());
            if ("1".equals(item.getIsgood())) {
                tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                tv_isgood.setClickable(false);
            } else {
                tv_isgood.setText(getResources().getString(R.string.ic_isgood) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#cccccc"));
                tv_isgood.setClickable(true);
            }
            IconfontTextView tv_views = helper.getView(R.id.tv_views);
            tv_views.setText("回复");

            RecyclerView mRecycleView = helper.getView(R.id.mRecyclerView);
            final PostDetailCommentAdapter mAdapter = new PostDetailCommentAdapter(R.layout.postdetails_comment02_items, item.getParent());
            mRecycleView.setLayoutManager(new LinearLayoutManager(mContext));
            mRecycleView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            tv_isgood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + (Integer.valueOf(item.getLikenum()) + 1));
                    tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                    /**
                     * 点赞
                     */
                    commentid = item.getId();//帖子id
                    toLike(diaryid, commentid);
                    mAdapter.notifyDataSetChanged();
                }
            });
            tv_views.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String rdid = item.getId();
                    String mdid = "";
                    dialog = new DiaryCommentFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("diaryid", diaryid);
                    bundle.putString("rdid", rdid);
                    bundle.putString("mdid", mdid);
                    dialog.setArguments(bundle);
                    dialog.show(getSupportFragmentManager(), "");
                }
            });

        }
    }


    public class PostDetailCommentAdapter extends BaseQuickAdapter<DiarydetailsModel.CommentBean.ParentBean, BaseViewHolder> {
        public PostDetailCommentAdapter(int layoutResId, List<DiarydetailsModel.CommentBean.ParentBean> data) {
            super(R.layout.postdetails_comment02_items, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final DiarydetailsModel.CommentBean.ParentBean item) {
            ImageLoader.getInstance().displayImage(item.getAvatar(), (CircleImageView) helper.getView(R.id.iv_avatar));
            final IconfontTextView tv_isgood = helper.getView(R.id.tv_isgood);
            helper.setText(R.id.tv_title, item.getNickname());
            helper.setText(R.id.tv_content, item.getReplycontent());
            helper.setText(R.id.tv_time, item.getReplytime());

            if ("1".equals(item.getIsgood())) {
                tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                tv_isgood.setClickable(false);
            } else {
                tv_isgood.setText(getResources().getString(R.string.ic_isgood) + "  " + item.getLikenum());
                tv_isgood.setTextColor(Color.parseColor("#cccccc"));
                tv_isgood.setClickable(true);
            }
            IconfontTextView tv_views = helper.getView(R.id.tv_views);
            tv_views.setText("回复");
            tv_isgood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_isgood.setText(getResources().getString(R.string.ic_good) + "  " + (Integer.valueOf(item.getLikenum()) + 1));
                    tv_isgood.setTextColor(Color.parseColor("#ff424d"));
                    /**
                     * 点赞
                     */
                    commentid = item.getId();//帖子id
                    toLike(diaryid, commentid);
                }
            });
            tv_views.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String rdid = item.getRcid();
                    String mdid = item.getId();
                    dialog = new DiaryCommentFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("diaryid", diaryid);
                    bundle.putString("rdid", rdid);
                    bundle.putString("mdid", mdid);
                    dialog.setArguments(bundle);
                    dialog.show(getSupportFragmentManager(), "tag");
                }
            });
        }
    }

    /**
     * 收藏
     */
    private void collectpost() {
        RetrofitUtil.getInstance().diaryCollect(openid, diaryid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    showToast(baseResponse.getMsg());
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 关注
     */
    private void attention() {
        RetrofitUtil.getInstance().Followmember(openid, diaryBean.getMemberid(), new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    showToast(baseResponse.getMsg());
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 评论点赞
     *
     * @param diaryid
     * @param commentid
     */
    private void toLike(String diaryid, String commentid) {
        RetrofitUtil.getInstance().diarylike(openid, diaryid, commentid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    showToast(baseResponse.getMsg());
                } else showToast(baseResponse.getMsg());
            }
        });
    }

    /**
     * 日记点赞
     *
     * @param diaryid
     * @param cid
     */
    private void toLike01(String diaryid, String cid) {
        RetrofitUtil.getInstance().journallike(openid, diaryid, cid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                if (baseResponse.getCode() == 200) {
                    showToast(baseResponse.getMsg());
                    initData();
                } else showToast(baseResponse.getMsg());
            }
        });
    }
}
