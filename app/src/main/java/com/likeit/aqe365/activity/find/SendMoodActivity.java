package com.likeit.aqe365.activity.find;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;

import com.bumptech.glide.Glide;
import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.MainActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.find.BoardListModel;
import com.likeit.aqe365.network.model.find.ConcernsListModel;
import com.likeit.aqe365.network.model.main.MainNavigationModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.AppManager;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.utils.photo.PhotoUtils;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.CustomTagLayout;
import com.likeit.aqe365.view.IconfontTextView;
import com.likeit.aqe365.view.RoundImageView;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutAdapter;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutScrollView;
import com.yixia.camera.MediaRecorderBase;
import com.zhaoshuang.weixinrecorded.RecordedActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import rx.Subscriber;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * 发布心情
 */
public class SendMoodActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {
    private static File filePic;
    @BindView(R.id.ed_content)
    EditText edContent;
    @BindView(R.id.tv_num01)
    TextView tvNum01;
    @BindView(R.id.tv_user)
    TextView tv_user;
    @BindView(R.id.mGridView)
    GridView mGridView;
    @BindView(R.id.video_img)
    RoundImageView video_img;
    @BindView(R.id.iv_up_pic)
    IconfontTextView iv_up_pic;
    @BindView(R.id.iv_takephoto)
    IconfontTextView iv_takephoto;
    @BindView(R.id.tagLayout)
    CustomTagLayout mTagLayout;
    private List<Map<String, Object>> datas;
    private GridViewAddImgesAdpter01 gridViewAddImgesAdpter;
    private List<BoardListModel.ListBean> list;
    private String videoPath = "";
    private String videoImg = "";
    private static String savePath;
    private String userName;
    private String userid = "";
    String userids = "";

    private String bids = "";
    private String bid = "";


    /**
     * 底部导航数据
     */
    private String[] mIconSelectIds;//标题
    private String[] mTitles;//未选中

    private String[] mLinkurl;
    private String linkurl;
    private int index;

    ArrayList<String> stringArrayList = new ArrayList<String>();
    ArrayList<String> stringArrayList1 = new ArrayList<String>();
    ArrayList<String> stringArrayList2 = new ArrayList<String>();
    List<BoardListModel.ListBean> dataT = new ArrayList<>();//话题
    private List<BoardListModel.ListBean> listHuati;
    List<BoardListModel.ListBean> data = new ArrayList<>();
    ArrayList<BoardListModel.ListBean> mList = new ArrayList<>();
    private LinearLayout mLlAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mood);
        datas = new ArrayList<>();
        list1 = new ArrayList<>();
        list = new ArrayList<>();
        listHuati = new ArrayList<>();
        BoardListModel.ListBean listBean = new BoardListModel.ListBean();
        listBean.setId("");
        listBean.setDesc("");
        listBean.setIsattention("");
        listBean.setLogo("");
        listBean.setParticipant("");
        listBean.setPostcount("");
        listBean.setTitle("+自定义话题");
        list.add(listBean);
        initTab();
        initUI();
        PhotoUtils.getInstance().init(this, true, new PhotoUtils.OnSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
                mGridView.setVisibility(View.VISIBLE);
                video_img.setVisibility(View.GONE);
                videoPath = "";
                photoPath(outputFile.getAbsolutePath());
            }
        });
    }

    public void initTab() {
        String navtab = SharedPreferencesUtils.getString(mContext, "navtab");
        Type type = new TypeToken<List<MainNavigationModel.ItemsBean>>() {
        }.getType();
        List<MainNavigationModel.ItemsBean> items = new Gson().fromJson(navtab, type);
        for (int i = 0; i < items.size(); i++) {
            stringArrayList.add(items.get(i).getText());
            stringArrayList1.add(StringUtil.decode("\\u" + items.get(i).getIconclasscode()));
            stringArrayList2.add(items.get(i).getLinkurl());
        }
        mTitles = stringArrayList.toArray(new String[stringArrayList.size()]);
        mLinkurl = stringArrayList2.toArray(new String[stringArrayList2.size()]);
        mIconSelectIds = stringArrayList1.toArray(new String[stringArrayList1.size()]);

    }

    List<String> list1;

    public void photoPath(String path) {
        list1.add(path);
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        datas.add(map);
        gridViewAddImgesAdpter.notifyDataSetChanged();
    }

    private void initUI() {
        setBackView();
        setTitle("写心情");
        setRightText("发布", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodPost();
            }
        });
        tvNum01.setText("0/500字");
        edContent.addTextChangedListener(mTextWatcher01);


        gridViewAddImgesAdpter = new GridViewAddImgesAdpter01(datas, this);
        gridViewAddImgesAdpter.setMaxImages(4);
        mGridView.setAdapter(gridViewAddImgesAdpter);
        /**
         * 话题数据
         */
        mLlAdd = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.item_layout2, null);
        mLlAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MoreTopic01Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", (Serializable) mList);
                intent.putExtras(bundle);
                startActivityForResult(intent, 101);
            }
        });
        initLayout(mList);
    }

    private void initLayout(ArrayList<BoardListModel.ListBean> list) {
        //移除所有自布局
        mTagLayout.removeAllViewsInLayout();


        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(SendMoodActivity.this).inflate(R.layout.item_layout01, mTagLayout, false);
            view.setTag(i);
            BorderTextView text = (BorderTextView) view.findViewById(R.id.tv_name);
            text.setText(mList.get(i).getTitle() + "  X");
            //点击移除标签
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i = (int) view.getTag();
                    mTagLayout.removeView(view);
                    mList.remove(i);
                    initLayout(mList);
                }
            });
            mTagLayout.addView(view);
        }
        //   mTagLayout.addView(mEtInput);
        mTagLayout.addView(mLlAdd);
    }
    private void moodPost() {
        if (listHuati.size() > 0) {
            for (int i = 0; i < listHuati.size(); i++) {
                bid += listHuati.get(i).getId() + ",";
            }
            bids = bid.substring(0, bid.length() - 1);
        } else {
            bids = bid;
        }


        if (StringUtil.isBlank(userids)) {
            userid = userids;
        } else {
            userid = userids.substring(0, userids.length() - 1);
        }
        XLog.e("bids" + bids);
        XLog.e("userid" + userid);
        String content = edContent.getText().toString();
        if (StringUtil.isBlank(content)) {
            showToast("内容不能为空");
            return;
        }
        if (content.length() < 20) {
            showToast("内容不能少于20字");
            return;
        }

        if (datas.size() == 0 && TextUtils.isEmpty(videoPath)) {
            showToast("请至少上传一张图片或者视频");
            return;
        }
        RequestBody requestApiKey = RequestBody.create(MediaType.parse("multipart/form-data"), openid);
        RequestBody requestApiLat = RequestBody.create(MediaType.parse("multipart/form-data"), lat);
        RequestBody requestApiLng = RequestBody.create(MediaType.parse("multipart/form-data"), lng);
        RequestBody requestApiBids = RequestBody.create(MediaType.parse("multipart/form-data"), bids);
        RequestBody requestApiContent = RequestBody.create(MediaType.parse("multipart/form-data"), content);
        RequestBody requestApiUserid = RequestBody.create(MediaType.parse("multipart/form-data"), userid);
        MultipartBody.Part requestVideo = null;
        if (!TextUtils.isEmpty(videoPath)) {
            File file01 = new File(videoPath);//视频文件
            RequestBody requestFile01 =               // 根据文件格式封装文件
                    RequestBody.create(MediaType.parse("video/mp4"), file01);
            requestVideo =
                    MultipartBody.Part.createFormData("videos", file01.getName(), requestFile01);
        }
        MultipartBody.Part requestvideoimage = null;
        if (!TextUtils.isEmpty(videoPath)) {
            RequestBody requestFile02 =               // 根据文件格式封装文件
                    RequestBody.create(MediaType.parse("image/jpg"), filePic);
            requestvideoimage =
                    MultipartBody.Part.createFormData("videoimage", filePic.getName(), requestFile02);
        }
        List<MultipartBody.Part> list2 = new ArrayList<>();
/**
 * 图片
 */
        if (list1 != null) {
            for (String pathItem : list1) {
                if (!TextUtils.isEmpty(pathItem)) {
                    File file = new File(pathItem);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
                    MultipartBody.Part body = MultipartBody.Part.createFormData("images[]", file.getName(), requestFile);// pictures 是参数名
                    list2.add(body);
                }
            }
        }
//        XLog.e("requestApiKey" + requestApiKey);
//        XLog.e("requestApiLat" + requestApiLat);
//        XLog.e("requestApiLng" + requestApiLng);
//        XLog.e("requestApiBids" + requestApiBids);
//        XLog.e("requestApiContent" + requestApiContent);
//        XLog.e("list2" + list2);
//        XLog.e("requestVideo" + requestVideo);
//        XLog.e("requestvideoimage" + requestvideoimage);
//        XLog.e("requestApiUserid" + requestApiUserid);

        RetrofitUtil.getInstance().moodsubmit(requestApiKey, requestApiLat, requestApiLng, requestApiBids, requestApiContent, list2, requestVideo, requestvideoimage, requestApiUserid, new Subscriber<BaseResponse<EmptyEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<EmptyEntity> baseResponse) {
                XLog.e("code" + baseResponse.getCode());
                if (baseResponse.getCode() == 200) {
                    showToast(baseResponse.getMsg());
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("mTitles", mTitles);
                    bundle.putStringArray("mLinkurl", mLinkurl);
                    bundle.putStringArray("mIconSelectIds", mIconSelectIds);
                    bundle.putString("flag", "2");
                    bundle.putInt("index", 2);
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    AppManager.getAppManager().finishAllActivity();
                } else {
                    bids = "";
                    userid = "";
                    showToast(baseResponse.getMsg());

                }
            }
        });
    }


    String[] takePhotoPerms = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, CAMERA, RECORD_AUDIO};
    String[] selectPhotoPerms = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE};

    @OnClick({R.id.iv_up_pic, R.id.iv_relevant_users, R.id.iv_takephoto, R.id.iv_video})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_up_pic://相册
                checkPermission(selectPhotoPerms, 2);
                break;
            case R.id.iv_relevant_users://关联用户
                Intent intent01 = new Intent(this, RelevantUsersActivity.class);
                startActivityForResult(intent01, 102);
                break;
            case R.id.iv_takephoto://拍照
                checkPermission(takePhotoPerms, 1);
                break;
            case R.id.iv_video://录制视频
                checkPermission(takePhotoPerms, 3);

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
                case 3:
                    Intent intent = new Intent(this, RecordedActivity.class);
                    startActivityForResult(intent, 0);
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
        if (resultCode == 103) {
            videoPath = data.getStringExtra("videoPath");

            MediaMetadataRetriever media = new MediaMetadataRetriever();
            media.setDataSource(videoPath);
            Bitmap bitmap = media.getFrameAtTime();
            XLog.e("videoPath:" + bitmap);
            saveBitmap(this, bitmap);
            if (!TextUtils.isEmpty(videoPath)) {
                datas.clear();
                mGridView.setVisibility(View.GONE);
                video_img.setVisibility(View.VISIBLE);
                video_img.setImageBitmap(bitmap);
            }
        } else if (resultCode == 101) {
            mList.clear();
            initLayout(mList);
            List<BoardListModel.ListBean> list1 = (List<BoardListModel.ListBean>) data.getExtras().getSerializable("data");
            XLog.e("list1--》" + list1);
            mList.addAll(list1);
            initLayout(mList);

            listHuati = mList;
        } else if (resultCode == 102) {
            userName = "";
            List<ConcernsListModel.ListBean> dataUser = (List<ConcernsListModel.ListBean>) data.getExtras().getSerializable("data");
            for (ConcernsListModel.ListBean item : dataUser) {
                userName += "@" + item.getNickname();
                userids += item.getId() + ",";
            }
            tv_user.setVisibility(View.VISIBLE);
            tv_user.setText(userName);
        }

    }

    TextWatcher mTextWatcher01 = new TextWatcher() {
        private CharSequence temp;
        private int editStart;
        private int editEnd;

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // TODO Auto-generated method stub
            temp = s;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
//          mTextView.setText(s);//将输入的内容实时显示
        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            editStart = edContent.getSelectionStart();
            editEnd = edContent.getSelectionEnd();
            tvNum01.setText("" + temp.length() + "/500字");
            if (temp.length() > 500) {
                showToast("你输入的字数已经超过了限制！");
                s.delete(editStart - 1, editEnd);
                int tempSelection = editStart;
                edContent.setText(s);
                edContent.setSelection(tempSelection);
            }
        }
    };


    /**
     * com.bm.falvzixun.adapter.GridViewAddImgAdpter
     *
     * @author yuandl on 2015/12/24.
     * 添加上传图片适配器
     */
    public class GridViewAddImgesAdpter01 extends BaseAdapter {
        private List<Map<String, Object>> datas;
        private Context context;
        private LayoutInflater inflater;
        /**
         * 可以动态设置最多上传几张，之后就不显示+号了，用户也无法上传了
         * 默认9张
         */
        private int maxImages = 9;

        public GridViewAddImgesAdpter01(List<Map<String, Object>> datas, Context context) {
            this.datas = datas;
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        /**
         * 获取最大上传张数
         *
         * @return
         */
        public int getMaxImages() {
            return maxImages;
        }

        /**
         * 设置最大上传张数
         *
         * @param maxImages
         */
        public void setMaxImages(int maxImages) {
            this.maxImages = maxImages;
        }

        /**
         * 让GridView中的数据数目加1最后一个显示+号
         *
         * @return 返回GridView中的数量
         */
        @Override
        public int getCount() {
            int count = datas == null ? 0 : datas.size() + 0;
            if (count >= maxImages) {
                return datas.size();
            } else {
                return count;
            }
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public void notifyDataSetChanged(List<Map<String, Object>> datas) {
            this.datas = datas;
            this.notifyDataSetChanged();

        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {


            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_published_grida, parent, false);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            if (datas != null && position < datas.size()) {
                if (datas.size() == 4) {
                    iv_up_pic.setClickable(false);
                    iv_takephoto.setClickable(false);
                } else {
                    iv_up_pic.setClickable(true);
                    iv_takephoto.setClickable(true);
                }
                final File file = new File(datas.get(position).get("path").toString());
                Glide.with(context).load(file).into(viewHolder.ivimage);
                viewHolder.btdel.setVisibility(View.VISIBLE);
                viewHolder.btdel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (file.exists()) {
                            file.delete();
                        }
                        datas.remove(position);
                        notifyDataSetChanged();
                    }
                });

            }

            return convertView;

        }

        public class ViewHolder {
            public final RoundImageView ivimage;
            public final Button btdel;
            public final View root;

            public ViewHolder(View root) {
                ivimage = (RoundImageView) root.findViewById(R.id.iv_image);
                btdel = (Button) root.findViewById(R.id.bt_del);
                this.root = root;
            }
        }
    }

    private static final String SD_PATH = "/sdcard/dskqxt/pic/";
    private static final String IN_PATH = "/dskqxt/pic/";

    private static String generateFileName() {
        return UUID.randomUUID().toString();
    }

    public static String saveBitmap(Context context, Bitmap mBitmap) {

        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            savePath = SD_PATH;
        } else {
            savePath = context.getApplicationContext().getFilesDir()
                    .getAbsolutePath()
                    + IN_PATH;
        }
        try {
            filePic = new File(savePath + generateFileName() + ".jpg");
            if (!filePic.exists()) {
                filePic.getParentFile().mkdirs();
                filePic.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(filePic);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return filePic.getAbsolutePath();
    }
}
