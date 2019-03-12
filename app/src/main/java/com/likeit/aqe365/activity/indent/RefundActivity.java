package com.likeit.aqe365.activity.indent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.guoqi.actionsheet.ActionSheet;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.indent.RefundGoodAdapter;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.EmptyEntity;
import com.likeit.aqe365.network.model.Indent.GoodsRefundmodel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.utils.photo.PhotoUtils;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.CustomPopWindow;
import com.likeit.aqe365.view.custom.GridViewAddImgesAdpter;
import com.likeit.aqe365.view.custom_scrollview.HorizontalPageLayoutManager;
import com.likeit.aqe365.view.custom_scrollview.MyRecyclerView;
import com.likeit.aqe365.view.custom_scrollview.PagingScrollHelper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import rx.Subscriber;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class RefundActivity extends BaseActivity implements ActionSheet.OnActionSheetSelected, EasyPermissions.PermissionCallbacks {
    @BindView(R.id.tv_add)
    BorderTextView tv_add;
    @BindView(R.id.tv_apply)
    BorderTextView tv_apply;
    @BindView(R.id.tv_type)//售后方式
            TextView tv_type;
    @BindView(R.id.tv_number)//商品数量
            TextView tv_number;
    @BindView(R.id.mRecyclerView)
    MyRecyclerView mRecyclerView;
    @BindView(R.id.tv_after_sale_mode)//处理方式
            TextView tv_after_sale_mode;
    @BindView(R.id.tv_after_sale_cause01)//退款原因标题
            TextView tv_after_sale_cause01;
    @BindView(R.id.tv_after_sale_cause)//退款原因
            TextView tv_after_sale_cause;
    @BindView(R.id.tv_after_sale_price01)//金额标题
            TextView tv_after_sale_price01;
    @BindView(R.id.tv_after_sale_price)//金额
            TextView tv_after_sale_price;
    @BindView(R.id.ed_after_sale_explain01)//说明标题
            TextView ed_after_sale_explain01;
    @BindView(R.id.ed_after_sale_explain)//说明
            EditText ed_after_sale_explain;
    @BindView(R.id.mGridView)//凭证
            GridView mGridView;
    @BindView(R.id.ll_after_sale_price)//
            LinearLayout ll_after_sale_price;

    String type, goodsid, optionid, grefundid, ordId;
    private GoodsRefundmodel goodsRefundmodel;
    private GridViewAddImgesAdpter gridViewAddImgesAdpter;
    private List<Map<String, Object>> datas;

    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    private List<GoodsRefundmodel.GoodsBean> data;
    private RefundGoodAdapter mAdapter;
    private String goods_status;
    private CustomPopWindow mCustomPopWindow;
    private String reason;
    private String payrefundtext;
    private String afterrefundtext;
    private boolean afterrefund;
    private boolean payrefund;
    private String imageUrl;
    private String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund);
        goodsid = getIntent().getExtras().getString("goodsid");
        optionid = getIntent().getExtras().getString("optionid");
        grefundid = getIntent().getExtras().getString("grefundid");
        ordId = getIntent().getExtras().getString("orderid");
        type = getIntent().getExtras().getString("type");
        payrefundtext = getIntent().getExtras().getString("payrefundtext");
        afterrefundtext = getIntent().getExtras().getString("afterrefundtext");
        afterrefund = getIntent().getExtras().getBoolean("afterrefund");
        payrefund = getIntent().getExtras().getBoolean("payrefund");
        flag = getIntent().getExtras().getString("flag");
        // setBackView();
        setTitle("售后申请");
        datas = new ArrayList<>();//图片
        initData();
        PhotoUtils.getInstance().init(this, true, new PhotoUtils.OnSelectListener() {
            @Override
            public void onFinish(File outputFile, Uri outputUri) {
                photoPath(outputFile.getAbsolutePath());
            }
        });
        findView(R.id.back_view).setVisibility(View.VISIBLE);
        findView(R.id.back_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("payrefundtext", payrefundtext);
                bundle.putString("afterrefundtext", afterrefundtext);
                bundle.putBoolean("afterrefund", afterrefund);
                bundle.putBoolean("payrefund", payrefund);
                bundle.putString("goodsid", goodsid);
                bundle.putString("optionid", optionid);
                bundle.putString("grefundid", grefundid);
                bundle.putString("orderid", ordId);
                if ("0".equals(flag)) {
                    toActivity(AfterSaleTypeActivity.class, bundle);
                } else if ("1".equals(flag)) {
                    bundle.putString("type", type);
                    toActivity(Refund01Activity.class, bundle);
                } else if ("2".equals(flag)) {
                    bundle.putString("type", type);
                    toActivity(Refund02Activity.class, bundle);
                }
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Bundle bundle = new Bundle();
            bundle.putString("payrefundtext", payrefundtext);
            bundle.putString("afterrefundtext", afterrefundtext);
            bundle.putBoolean("afterrefund", afterrefund);
            bundle.putBoolean("payrefund", payrefund);
            bundle.putString("goodsid", goodsid);
            bundle.putString("optionid", optionid);
            bundle.putString("grefundid", grefundid);
            bundle.putString("orderid", ordId);
            if ("0".equals(flag)) {
                toActivity(AfterSaleTypeActivity.class, bundle);
            } else if ("1".equals(flag)) {
                bundle.putString("type", type);
                toActivity(Refund01Activity.class, bundle);
            } else if ("2".equals(flag)) {
                bundle.putString("type", type);
                toActivity(Refund02Activity.class, bundle);
            }
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initData() {
        LoaddingShow();
//        XLog.e("openid-->"+openid);
//        XLog.e("goodsid-->"+goodsid);
//        XLog.e("ordId-->"+ordId);
//        XLog.e("optionid-->"+optionid);
//        XLog.e("type-->"+type);
//        XLog.e("grefundid-->"+grefundid);
        RetrofitUtil.getInstance().goodsRefund(openid, goodsid, ordId, optionid, type, grefundid, new Subscriber<BaseResponse<GoodsRefundmodel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LoaddingDismiss();
            }

            @Override
            public void onNext(BaseResponse<GoodsRefundmodel> baseResponse) {
                LoaddingDismiss();
                XLog.e("code-->" + baseResponse.getCode());
                if (baseResponse.getCode() == 200) {
                    goodsRefundmodel = baseResponse.getData();
                    initUI();
                }
            }
        });
    }

    String imgId = "";

    private void initUI() {

        XLog.e("type-->" + type);
        XLog.e("goodsRefundmodel-->" + goodsRefundmodel.getHandletype());
        if (goodsRefundmodel.getGoodslist().size() > 1) {
            tv_add.setVisibility(View.VISIBLE);
        } else {
            tv_add.setVisibility(View.GONE);
        }
        if ("1".equals(type)) {
            tv_type.setText("退款商品");
            tv_number.setText("共" + goodsRefundmodel.getGoods().size() + "件");
            tv_after_sale_mode.setText(goodsRefundmodel.getHandletype());
            tv_after_sale_cause01.setText("退款原因");
            if (goodsRefundmodel.getGoods_refund() == null) {
                tv_after_sale_cause.setHint("请选择退款原因");
            } else {
                tv_after_sale_cause.setText(goodsRefundmodel.getGoods_refund().getReason());
            }
            tv_after_sale_price01.setText("退款金额");
            tv_after_sale_price.setText("¥ " + goodsRefundmodel.getGoods().get(0).getRealprice());
            ed_after_sale_explain01.setText("退款说明");
        } else if ("2".equals(type)) {
            tv_type.setText("商品售后");
            tv_number.setText("共" + goodsRefundmodel.getGoods().size() + "件");
            tv_after_sale_mode.setText(goodsRefundmodel.getHandletype());
            tv_after_sale_cause01.setText("售后原因");
            if (goodsRefundmodel.getGoods_refund() == null) {
                tv_after_sale_cause.setHint("请选择售后原因");
            } else {
                reason = goodsRefundmodel.getGoods_refund().getReason();
                tv_after_sale_cause.setText(goodsRefundmodel.getGoods_refund().getReason());
            }
            tv_after_sale_price01.setText("货物状态");
            if ("3".equals(goodsRefundmodel.getOrder().getStatus())) {
                goods_status = "已收到货";
                tv_after_sale_price.setText(goods_status);
                ll_after_sale_price.setClickable(false);
            } else {
                tv_after_sale_price.setHint("请选择状态");
                goods_status = "未收到货";
                ll_after_sale_price.setClickable(true);
            }

            ed_after_sale_explain01.setText("售后说明");
        }
        /**
         * 商品显示
         */
        data = goodsRefundmodel.getGoods();
        initGood();


        /**
         * 凭证
         */
        gridViewAddImgesAdpter = new GridViewAddImgesAdpter(datas, this);
        gridViewAddImgesAdpter.setMaxImages(3);
        mGridView.setAdapter(gridViewAddImgesAdpter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ActionSheet.showSheet(RefundActivity.this, RefundActivity.this, null);
            }
        });
        tv_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XLog.e("dianji");
                toApply();
            }
        });
        /**
         *
         */
        goodsBeans = new ArrayList<>();
        goodsBeans = goodsRefundmodel.getGoods();
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AddOrEditGoodActivity.class);
                Bundle bundle = new Bundle();
                List<GoodsRefundmodel.GoodslistBean> data1 = new ArrayList<>();
                data1 = goodsRefundmodel.getGoodslist();
                for (int i = 0; i < goodsBeans.size(); i++) {
                    XLog.e("data22:" + goodsBeans.get(i).getGoodsid());
                }
                bundle.putParcelableArrayList("goodslist", (ArrayList<? extends Parcelable>) data1);
                bundle.putParcelableArrayList("goodsBeans", (ArrayList<? extends Parcelable>) goodsBeans);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
                //  toActivity(AddOrEditGoodActivity.class, bundle);
            }
        });
    }

    private void initGood() {
        mAdapter = new RefundGoodAdapter(R.layout.refund_good_view, data);
        horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, 3);
        //滚动adapter
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        scrollHelper.setUpRecycleView(mRecyclerView);
        RecyclerView.LayoutManager layoutManager = null;
        layoutManager = horizontalPageLayoutManager;
        if (layoutManager != null) {
            mRecyclerView.setLayoutManager(layoutManager);
            scrollHelper.updateLayoutManger();
        }
    }

    List<GoodsRefundmodel.GoodslistBean> data1;
    List<GoodsRefundmodel.GoodsBean> goodsBeans;

    private void getdata1() {
        data1 = new ArrayList<>();
        for (int i = 0; i < goodsRefundmodel.getGoodslist().size(); i++) {
            GoodsRefundmodel.GoodslistBean goodslistBean = new GoodsRefundmodel.GoodslistBean();
            for (int j = 0; j < goodsRefundmodel.getGoods().size(); j++) {
                if (goodsRefundmodel.getGoods().get(j).getGoodsid().equals(goodsRefundmodel.getGoodslist().get(i).getGoodsid())) {
                    //goodsRefundmodel.getGoodslist().get(i).setChecked(true);
                    goodslistBean.setChecked(true);
                } else {
                    // goodsRefundmodel.getGoodslist().get(i).setChecked(false);
                    goodslistBean.setChecked(false);
                }
                goodslistBean.setGoodsid(goodsRefundmodel.getGoodslist().get(i).getGoodsid());
                goodslistBean.setRealprice(goodsRefundmodel.getGoodslist().get(i).getRealprice());
                goodslistBean.setOptionid(goodsRefundmodel.getGoodslist().get(i).getOptionid());
                goodslistBean.setOptiontitle(goodsRefundmodel.getGoodslist().get(i).getOptiontitle());
                goodslistBean.setThumb(goodsRefundmodel.getGoodslist().get(i).getThumb());
                goodslistBean.setTitle(goodsRefundmodel.getGoodslist().get(i).getTitle());
                data1.add(goodslistBean);
            }
        }

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


    @OnClick({R.id.ll_after_sale_causes, R.id.ll_after_sale_price, R.id.tv_cancel})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_after_sale_causes:
                if ("1".equals(type)) {
                    showPopMenu();
                } else if ("2".equals(type)) {
                    showPopMenu1();
                }
                break;
            case R.id.ll_after_sale_price:
                showPopMenu2();
                break;

            case R.id.tv_cancel:
                finish();
                break;
        }

    }

    String goodsid01 = "";
    String applyprice = "";
    String optionid01 = "";

    //提交申请
    private void toApply() {

        if (StringUtil.isBlank(reason)) {
            showToast("请选择退款/退货原因");
            return;
        }
        if (data.size() == 1) {
            goodsid = data.get(0).getGoodsid();
            optionid = data.get(0).getOptionid();
        } else {
            for (int i = 0; i < data.size(); i++) {
                goodsid01 += data.get(i).getGoodsid() + ",";
                optionid01 += data.get(i).getOptionid() + ",";
            }
            goodsid = goodsid01.substring(0, goodsid01.length() - 1);
            optionid = optionid01.substring(0, optionid01.length() - 1);
        }

        if ("1".equals(type)) {
            goods_status = "";
            double res = 0;
            if (data.size() == 1) {
                applyprice = data.get(0).getRealprice();
            } else {
                for (int i = 0; i < data.size(); i++) {
                    // String.valueOf(applyprice += Integer.valueOf(data.get(i).getRealprice()));
                    res += Double.valueOf(data.get(i).getRealprice());
                    XLog.e("price:" + data.get(i).getRealprice());
                    XLog.e("1:" + res);
                }
                applyprice=String.valueOf(res);
            }
        } else {
            applyprice = "";
        }
        for (int i = 0; i < datas.size(); i++) {
            String fileName = datas.get(i).get("path").toString();
            Bitmap bm = BitmapFactory.decodeFile(fileName);
            // XLog.e("bitmap-->" + bm);
            if (bm != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] bytes = baos.toByteArray();
                String base64Token = Base64.encodeToString(bytes, Base64.DEFAULT);//  编码后
                imgId += base64Token + ",";
            }
        }
        if (StringUtil.isBlank(imgId)) {
            showToast("请至少上传一张图片");
            return;
        } else {
            imageUrl = imgId.substring(0, imgId.length() - 1);
        }
        String content = ed_after_sale_explain.getText().toString();

        XLog.e("applyprice:" + applyprice);
        // XLog.e("imageUrl:" + imageUrl);
        XLog.e("goods_status:" + goods_status);
        XLog.e("reason:" + reason);
        XLog.e("optionid:" + optionid);
        XLog.e("type:" + type);
        XLog.e("goodsid:" + goodsid);
        XLog.e("ordId:" + ordId);
        XLog.e("getMerchid:" + goodsRefundmodel.getOrder().getMerchid());
        LoaddingShow();
        RetrofitUtil.getInstance().goodsRefundSubmit(openid, ordId, goodsid, type, optionid, goodsRefundmodel.getOrder().getMerchid(), String.valueOf(applyprice), reason, goods_status, imageUrl, content, new Subscriber<BaseResponse<EmptyEntity>>() {
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
//                XLog.e("msg:" + baseResponse.getMsg());
//                XLog.e("msg:" + baseResponse.getCode());
//                XLog.e("data：" + baseResponse.getData());
                if (baseResponse.getCode() == 200) {
                    showToast(baseResponse.getMsg());
                    finish();
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    private void showPopMenu2() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_menu4, null);
        //处理popWindow 显示内容
        handleLogic2(contentView);
        //创建并显示popWindow
        mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(tv_after_sale_price, 0, 20);
    }

    private void handleLogic2(View contentView) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomPopWindow != null) {
                    mCustomPopWindow.dissmiss();
                }
                switch (v.getId()) {
                    case R.id.menu1:
                        goods_status = "已收到货";
                        tv_after_sale_price.setText("已收到货");
                        break;
                    case R.id.menu2:
                        goods_status = "未收到货";
                        tv_after_sale_price.setText("未收到货");
                        break;
                }
            }
        };
        contentView.findViewById(R.id.menu1).setOnClickListener(listener);
        contentView.findViewById(R.id.menu2).setOnClickListener(listener);
    }

    private void showPopMenu1() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_menu3, null);
        //处理popWindow 显示内容
        handleLogic1(contentView);
        //创建并显示popWindow
        mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(tv_after_sale_cause, 0, 20);
    }

    private void showPopMenu() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_menu, null);
        //处理popWindow 显示内容
        handleLogic(contentView);
        //创建并显示popWindow
        mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(tv_after_sale_cause, 0, 20);
    }

    private void handleLogic1(View contentView) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomPopWindow != null) {
                    mCustomPopWindow.dissmiss();
                }
                switch (v.getId()) {
                    case R.id.menu1:
                        reason = "商品质量问题";
                        tv_after_sale_cause.setText("商品质量问题");
                        break;
                    case R.id.menu2:
                        reason = "到货物流损、缺件";
                        tv_after_sale_cause.setText("到货物流损、缺件");
                        break;
                    case R.id.menu3:
                        reason = "商品描述与网站不符";
                        tv_after_sale_cause.setText("商品描述与网站不符");
                        break;
                    case R.id.menu4:
                        reason = "其他原因";
                        tv_after_sale_cause.setText("其他原因");
                        break;
                }
            }
        };
        contentView.findViewById(R.id.menu1).setOnClickListener(listener);
        contentView.findViewById(R.id.menu2).setOnClickListener(listener);
        contentView.findViewById(R.id.menu3).setOnClickListener(listener);
        contentView.findViewById(R.id.menu4).setOnClickListener(listener);
    }

    private void handleLogic(View contentView) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomPopWindow != null) {
                    mCustomPopWindow.dissmiss();
                }
                switch (v.getId()) {
                    case R.id.menu1:
                        reason = "不想要了";
                        tv_after_sale_cause.setText("不想要了");
                        break;
                    case R.id.menu2:
                        reason = "卖家缺货";
                        tv_after_sale_cause.setText("卖家缺货");
                        break;
                    case R.id.menu3:
                        reason = "拍错了/订单信息错误";
                        tv_after_sale_cause.setText("拍错了/订单信息错误");
                        break;
                    case R.id.menu4:
                        reason = "其他";
                        tv_after_sale_cause.setText("其他");
                        break;
                }
            }
        };
        contentView.findViewById(R.id.menu1).setOnClickListener(listener);
        contentView.findViewById(R.id.menu2).setOnClickListener(listener);
        contentView.findViewById(R.id.menu3).setOnClickListener(listener);
        contentView.findViewById(R.id.menu4).setOnClickListener(listener);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data1) {
        super.onActivityResult(requestCode, resultCode, data1);
        PhotoUtils.getInstance().bindForResult(requestCode, resultCode, data1);

        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = data1.getExtras();
            goodsBeans = bundle.getParcelableArrayList("goodBeans");
            if (data != null) {
                data.clear();
                data = goodsBeans;
                initGood();
            }
        }
    }
}
