package com.likeit.aqe365.activity.find;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import android.widget.TextView;
import android.app.Activity;

import com.bumptech.glide.Glide;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.find.ConcernsListModel;
import com.likeit.aqe365.utils.photo.PhotoUtils;
import com.likeit.aqe365.view.IconfontTextView;
import com.likeit.aqe365.view.RoundImageView;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutAdapter;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutScrollView;
import com.zhaoshuang.weixinrecorded.RecordedActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * 话题
 */
public class SendMoodActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {
    @BindView(R.id.ed_content)
    EditText edContent;
    @BindView(R.id.tv_num01)
    TextView tvNum01;
    @BindView(R.id.mGridView)
    GridView mGridView;
    @BindView(R.id.iv_up_pic)
    IconfontTextView iv_up_pic;
    @BindView(R.id.iv_takephoto)
    IconfontTextView iv_takephoto;
    private List<Map<String, Object>> datas;
    private GridViewAddImgesAdpter01 gridViewAddImgesAdpter;
    private List<String> list;
    private FlowLayoutAdapter<String> flowLayoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mood);
        datas = new ArrayList<>();
        list = new ArrayList<>();
        list.add("+自定义话题");
        list.add("#牙科");
        list.add("#牙科");
        list.add("#牙科");
        list.add("#牙科");
        list.add("#牙科");
        initUI();
        PhotoUtils.getInstance().init(this, true, new PhotoUtils.OnSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
                photoPath(outputFile.getAbsolutePath());
            }
        });
    }

    public void photoPath(String path) {
        //  list.add(path);
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        datas.add(map);

        XLog.e("data.size:" + datas.size());

        gridViewAddImgesAdpter.notifyDataSetChanged();
    }

    private void initUI() {
        setBackView();
        setTitle("写心情");
        setRightText("发布", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        flowLayoutAdapter = new FlowLayoutAdapter<String>(list) {
            @Override
            public void bindDataToView(ViewHolder holder, int position, String bean) {

                holder.setText(R.id.tv, bean);


            }

            @Override
            public void onItemClick(int position, String bean) {
                XLog.e("size1" + list.size());
                if (position == 0) {
                    Intent intent = new Intent(mContext, MoreTopicActivity.class);
                    list.remove(0);
                    intent.putStringArrayListExtra("list", (ArrayList<String>) list);
                    startActivityForResult(intent, 101);
                    //toActivity(MoreTopicActivity.class);
                    return;
                } else {
                    //remove(position);
                    list.remove(position);
                    flowLayoutAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public int getItemLayoutID(int position, String bean) {
                if (position == 0) {
                    return R.layout.item_layout2;
                }
                return R.layout.item_layout;
            }
        };
        ((FlowLayoutScrollView) findViewById(R.id.flsv)).setAdapter(flowLayoutAdapter);
    }


    String[] takePhotoPerms = {READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE, CAMERA};
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
                Intent intent = new Intent(this, RecordedActivity.class);
                startActivityForResult(intent, 0);
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
        if (resultCode == 103) {
            String imagePath = data.getStringExtra("imagePath");
            String videoPath = data.getStringExtra("videoPath");
            XLog.e("videoPath:" + videoPath);
            if (!TextUtils.isEmpty(videoPath)) {

//                vv_play.setVideoPath(videoPath);
//                vv_play.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                    @Override
//                    public void onPrepared(MediaPlayer mp) {
//                        vv_play.setLooping(true);
//                        vv_play.start();
//
//                        float widthF = vv_play.getVideoWidth() * 1f / MediaRecorderBase.VIDEO_HEIGHT;
//                        float heightF = vv_play.getVideoHeight() * 1f / MediaRecorderBase.VIDEO_WIDTH;
//                        ViewGroup.LayoutParams layoutParams = vv_play.getLayoutParams();
//                        layoutParams.width = (int) (rl_show.getWidth() * widthF);
//                        layoutParams.height = (int) (rl_show.getHeight() * heightF);
//                        vv_play.setLayoutParams(layoutParams);
//                    }
//                });
            }

        } else if (resultCode == 101) {
            list.clear();
            flowLayoutAdapter.clear();
            List<String> list1 = data.getStringArrayListExtra("list");
            list = list1;
            XLog.e("size2" + list.size());
            flowLayoutAdapter.addAll(list);
            flowLayoutAdapter.notifyDataSetChanged();
        } else if (resultCode == 102) {

            List<ConcernsListModel.ListBean> dataUser = (List<ConcernsListModel.ListBean>) data.getExtras().getSerializable("data");
            XLog.e("dataUser" + dataUser);
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
//        else {
//           // Glide.with(context).load(R.mipmap.add_photo).into(viewHolder.ivimage);
//            Glide.with(context)
//                    .load(R.mipmap.icon_people_uploadpicture)
//                    .priority(Priority.HIGH)
//                    .centerCrop()
//                    .into(viewHolder.ivimage);
//            viewHolder.ivimage.setScaleType(ImageView.ScaleType.FIT_XY);
//            viewHolder.btdel.setVisibility(View.GONE);
//        }

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

}
