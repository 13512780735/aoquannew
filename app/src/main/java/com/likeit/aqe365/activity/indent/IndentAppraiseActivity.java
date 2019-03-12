package com.likeit.aqe365.activity.indent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.guoqi.actionsheet.ActionSheet;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.Indent.CommentShopModel;
import com.likeit.aqe365.network.model.member.AvatarModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.utils.photo.PhotoUtils;
import com.likeit.aqe365.view.RatingBar;
import com.likeit.aqe365.view.custom.GridViewAddImgesAdpter;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import rx.Subscriber;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class IndentAppraiseActivity extends BaseActivity implements ActionSheet.OnActionSheetSelected, EasyPermissions.PermissionCallbacks {

    private static final String TAG = "IndentAppraiseActivity";
    @BindView(R.id.iv_shop_avatar)
    ImageView mIvShopAvatar;
    @BindView(R.id.tv_shop_name)
    TextView mTvShopName;
    @BindView(R.id.tv_shop_price)
    TextView mTvShopPrice;
    @BindView(R.id.tv_shop_size)
    TextView mTvShopSize;
    @BindView(R.id.tv_shop_number)
    TextView mTvShopNumber;
    @BindView(R.id.tv_Submit)
    TextView tv_Submit;
    @BindView(R.id.tv_indent_name)
    TextView tv_indent_name;
    @BindView(R.id.mGridView)
    GridView mGridView;
    @BindView(R.id.ed_tell_some)
    EditText mEdTellSome;
    @BindView(R.id.ratingbar)
    RatingBar mRatingBar;

    private GridViewAddImgesAdpter gridViewAddImgesAdpter;
    /**
     * 图片
     */
    private ArrayList<String> mPicList = new ArrayList<>(); //上传的图片凭证的数据源
    private List<Map<String, Object>> datas;
    private String goodsId;
    private String ordId;
    private CommentShopModel commentShopModel;
    private String level;
    private String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indent_appraise);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN |
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        goodsId = getIntent().getExtras().getString("goodsId");
        ordId = getIntent().getExtras().getString("ordId");
        setBackView();
        setTitle("评价");
        datas = new ArrayList<>();//图片
        initData();

        PhotoUtils.getInstance().init(this, true, new PhotoUtils.OnSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
                photoPath(outputFile.getAbsolutePath());
            }
        });
    }

    private void initData() {
        LoaddingShow();
        RetrofitUtil.getInstance().commentContent(openid, ordId, goodsId, new Subscriber<BaseResponse<CommentShopModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<CommentShopModel> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.getCode() == 200) {
                    commentShopModel = baseResponse.getData();

                    initUI();
                }
            }
        });
    }

    String imgId = "";

    private void initUI() {
        tv_Submit.setBackgroundColor(Color.parseColor(theme_bg_tex));
        ImageLoader.getInstance().displayImage(commentShopModel.getGoods().getThumb(), mIvShopAvatar);
        tv_indent_name.setText(commentShopModel.getShopname());
        mTvShopName.setText(commentShopModel.getGoods().getTitle());
        mTvShopPrice.setText("¥ " + commentShopModel.getGoods().getPrice());

        String title = commentShopModel.getGoods().getOptiontitle();
        if (StringUtil.isBlank(title)) {
            mTvShopSize.setVisibility(View.INVISIBLE);
        } else {
            mTvShopSize.setText("规格：" + commentShopModel.getGoods().getOptiontitle());
        }
        mTvShopNumber.setText("X" + commentShopModel.getGoods().getTotal());
        /**
         * 图片
         */
        gridViewAddImgesAdpter = new GridViewAddImgesAdpter(datas, this);
        gridViewAddImgesAdpter.setMaxImages(5);
        mGridView.setAdapter(gridViewAddImgesAdpter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ActionSheet.showSheet(IndentAppraiseActivity.this, IndentAppraiseActivity.this, null);
            }
        });
        //  mRating.setRatingDrawable(Drawable, Drawable);
        //mRating.setDrawablePadding(int);
        mRatingBar.setStarEmptyDrawable(mContext.getResources().getDrawable(R.mipmap.star_empty));
        //  mRatingBar.setStarHalfDrawable(mContext.getResources().getDrawable(R.mipmap.star_half));
        mRatingBar.setStarFillDrawable(mContext.getResources().getDrawable(R.mipmap.star_full));
        mRatingBar.setStarCount(5);
        mRatingBar.setStar(5);
        mRatingBar.halfStar(false);
        mRatingBar.setmClickable(true);
        mRatingBar.setStarImageWidth(30f);
        mRatingBar.setStarImageHeight(30f);
        mRatingBar.setImagePadding(5);
        level = String.valueOf(5);
        mRatingBar.setOnRatingChangeListener(
                new RatingBar.OnRatingChangeListener() {
                    @Override
                    public void onRatingChange(float RatingCount) {
                        XLog.e("RatingCount-->" + RatingCount);
                        int i = (int) RatingCount;
                        level = String.valueOf(i);

                    }
                }
        );
        tv_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < datas.size(); i++) {
                    String fileName = datas.get(i).get("path").toString();
                    Bitmap bm = BitmapFactory.decodeFile(fileName);
                    XLog.e("bitmap-->" + bm);
                    if (bm != null) {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
                        byte[] bytes = baos.toByteArray();
                        String base64Token = Base64.encodeToString(bytes, Base64.DEFAULT);//  编码后
                        imgId += base64Token + ",";
                    }
                }
                submit();
            }
        });
    }


    private void submit() {

        if (StringUtil.isBlank(imgId)) {
            imageUrl = imgId;
        } else {
            imageUrl = imgId.substring(0, imgId.length() - 1);
        }
        String content = mEdTellSome.getText().toString();

//        XLog.e("imageUrl-->" + imageUrl);
//        XLog.e("level-->" + level);
//        XLog.e("content-->" + content);
//        XLog.e("goodsId-->" + goodsId);
//        XLog.e("ordId-->" + ordId);
//        XLog.e("openid-->" + openid);
        LoaddingShow();
        RetrofitUtil.getInstance().commentSubmit(openid, ordId, goodsId, level, content, imageUrl, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                LoaddingDismiss();
//
//                XLog.e("code-->" + baseResponse.getCode());
//                XLog.e("msg-->" + baseResponse.getMsg());
//                XLog.e("data-->" + baseResponse.getData());
                if (baseResponse.getCode() == 200) {
                    finish();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    public void photoPath(String path) {
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        //upAvatar(base64);
        datas.add(map);
        gridViewAddImgesAdpter.notifyDataSetChanged();
    }

    String[] takePhotoPerms = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, CAMERA};
    String[] selectPhotoPerms = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE};

    @Override
    public void onClick(int whichButton) {
        switch (whichButton) {
            case ActionSheet.CHOOSE_PICTURE:
                //相册
                checkPermission(selectPhotoPerms, 2);
                break;
            case ActionSheet.TAKE_PICTURE:
                //拍照
                checkPermission(takePhotoPerms, 1);
                break;
            case ActionSheet.CANCEL:
                //取消
                break;
        }
    }

    private void checkPermission(String[] perms, int requestCode) {
        if (EasyPermissions.hasPermissions(this, perms)) {//已经有权限了
            switch (requestCode) {
                case 1:
                    PhotoUtils.getInstance().takePhoto();
                    break;
                case 2:
                    PhotoUtils.getInstance().selectPhoto();
                    break;
            }
        } else {//没有权限去请求
            EasyPermissions.requestPermissions(this, "权限", requestCode, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {//设置成功
        switch (requestCode) {
            case 1:
                PhotoUtils.getInstance().takePhoto();
                break;
            case 2:
                PhotoUtils.getInstance().selectPhoto();
                break;
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this)
                    .setTitle("权限设置")
                    .setPositiveButton("设置")
                    .setRationale("当前应用缺少必要权限,可能会造成部分功能受影响！请点击\"设置\"-\"权限\"-打开所需权限。最后点击两次后退按钮，即可返回")
                    .build()
                    .show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PhotoUtils.getInstance().bindForResult(requestCode, resultCode, data);
    }

    private void upAvatar(final String base64Token) {
        XLog.e("base64Token-->" + base64Token);
        LoaddingShow();
        RetrofitUtil.getInstance().UpAvatar(openid, base64Token, new Subscriber<BaseResponse<AvatarModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<AvatarModel> baseResponse) {
                LoaddingDismiss();
                if (baseResponse.getCode() == 200) {
                    imageUrl = baseResponse.getData().getImage();
                }
            }
        });
    }
}
