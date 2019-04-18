package com.likeit.aqe365.fragment.main;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.cart.ShopcatAdapter;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.cart01.CartListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import rx.Subscriber;

import static in.srain.cube.views.ptr.util.PtrLocalDisplay.dp2px;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cart01Fragment extends BaseFragment implements View.OnClickListener, ShopcatAdapter.CheckInterface, ShopcatAdapter.ModifyCountInterface, ShopcatAdapter.GroupEditorListener {
    @BindView(R.id.listView)
    ExpandableListView listView;
    @BindView(R.id.all_checkBox)
    CheckBox allCheckBox;
    @BindView(R.id.total_price)
    TextView totalPrice;
    @BindView(R.id.go_pay)
    TextView goPay;
    @BindView(R.id.order_info)
    LinearLayout orderInfo;
    @BindView(R.id.share_goods)
    TextView shareGoods;
    @BindView(R.id.collect_goods)
    TextView collectGoods;
    @BindView(R.id.del_goods)
    TextView delGoods;
    @BindView(R.id.share_info)
    LinearLayout shareInfo;
    @BindView(R.id.ll_cart)
    LinearLayout llCart;
    @BindView(R.id.mPtrframe)
    PtrFrameLayout mPtrFrame;

    TextView shoppingcatNum;
    Button actionBarEdit;
    LinearLayout empty_shopcart;
    private Context mcontext;
    private double mtotalPrice = 0.00;
    private int mtotalCount = 0;
    //false就是编辑，ture就是完成
    private boolean flag = false;
    private ShopcatAdapter adapter;
    private List<CartListModel.ListBeanXX> groups; //组元素的列表
    private Map<String, List<CartListModel.ListBeanXX.ListBeanX>> childs; //子元素的列表
    private CartListModel cartListModel;
    List<CartListModel.ListBeanXX.ListBeanX> goods;

    @Override
    protected int setContentView() {
        return R.layout.fragment_cart01;
    }

    @Override
    protected void lazyLoad() {

        //initActionBar();
        initPtrFrame();
        findView();
        initData();
        initEvents();
      //
    }

    private void initPtrFrame() {
//        final StoreHouseHeader header=new StoreHouseHeader(this);
//        header.setPadding(dp2px(20), dp2px(20), 0, 0);
//        header.initWithString("xiaoma is good");
        final PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getActivity());
        header.setPadding(dp2px(20), dp2px(20), 0, 0);
        mPtrFrame.setHeaderView(header);
        mPtrFrame.addPtrUIHandler(header);
        mPtrFrame.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
               // adapter.clear();
                mPtrFrame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //initData();
                        //initEvents();
                        //刷新完成隐藏刷新进度
                        mPtrFrame.refreshComplete();
                    }
                }, 2000);


//                mPtrFrame.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        // initData();
//                        mPtrFrame.refreshComplete();
//                    }
//                }, 2000);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });
    }


    private void initEvents() {
        actionBarEdit.setOnClickListener(this);
        adapter = new ShopcatAdapter(groups, childs, mcontext);
        adapter.setCheckInterface(this);//关键步骤1：设置复选框的接口
        adapter.setModifyCountInterface(this); //关键步骤2:设置增删减的接口
        adapter.setGroupEditorListener(this);//关键步骤3:监听组列表的编辑状态
        listView.setGroupIndicator(null); //设置属性 GroupIndicator 去掉向下箭头
        listView.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            listView.expandGroup(i); //关键步骤4:初始化，将ExpandableListView以展开的方式显示
        }
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int firstVisiablePostion = view.getFirstVisiblePosition();
                int top = -1;
                View firstView = view.getChildAt(firstVisibleItem);
                XLog.i("childCount=" + view.getChildCount());//返回的是显示层面上的所包含的子view的个数
                if (firstView != null) {
                    top = firstView.getTop();
                }
                XLog.i("firstVisiableItem=" + firstVisibleItem + ",fistVisiablePosition=" + firstVisiablePostion + ",firstView=" + firstView + ",top=" + top);
                if (firstVisibleItem == 0 && top == 0) {
                    mPtrFrame.setEnabled(true);
                } else {
                    mPtrFrame.setEnabled(false);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
//        initData();
        //setCartNum();
    }

    /**
     * 设置购物车的数量
     */
    private void setCartNum() {
        int count = 0;
        for (int i = 0; i < groups.size(); i++) {
            CartListModel.ListBeanXX group = groups.get(i);
            group.setChoosed(allCheckBox.isChecked());
            List<CartListModel.ListBeanXX.ListBeanX> Childs = childs.get(group.getId());

            for (CartListModel.ListBeanXX.ListBeanX childs : Childs) {
                count++;
            }
        }
        XLog.e("count" + count);
        //购物车已经清空
        if (count == 0) {
            clearCart();
        } else {
            shoppingcatNum.setText("购物车");
        }

    }

    private void clearCart() {
        shoppingcatNum.setText("购物车");
        actionBarEdit.setVisibility(View.GONE);
        llCart.setVisibility(View.GONE);
        empty_shopcart.setVisibility(View.VISIBLE);//这里发生过错误
    }


    private void initData() {
        mcontext = getActivity();
        groups = new ArrayList<>();
        childs = new HashMap<>();
        XLog.e("data99999" +"88888");
        RetrofitUtil.getInstance().getCartList(openid, new Subscriber<BaseResponse<CartListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(BaseResponse<CartListModel> baseResponse) {
                XLog.e("data99999" + baseResponse.getCode());
//                XLog.e("data" + baseResponse.getData().getList().size());
//                XLog.e("data" + baseResponse.getData().getList().get(0).getMerchname());
                if (baseResponse.code == 200) {
                    cartListModel = baseResponse.getData();
                    //recomsBean = cartListModel.getRecoms().getList();
                    if (cartListModel.getList() != null) {
//                        if (groups.size() > 0) {
//                            groups.clear();
//                        }
                        for (int i = 0; i < cartListModel.getList().size(); i++) {
                            // groups = cartListModel.getList();
                            groups.add(new CartListModel.ListBeanXX(i + "", cartListModel.getList().get(i).getMerchname(), cartListModel.getList().get(i).getMerchid(), cartListModel.getList().get(i).getList()));
                            //  groups.add(new CartListModel.ListBeanXX(cartListModel.getList().get(i).getMerchname(), cartListModel.getList().get(i).getMerchid(), cartListModel.getList().get(i).getList()));
                            goods = new ArrayList<>();
                            for (int j = 0; j <= i; j++) {
                                goods = groups.get(i).getList();
                                //goods.add(new CartListModel.ListBeanXX.ListBeanX());
                            }
                            XLog.e("goods" + goods);
                            childs.put(groups.get(i).getId(), goods);
                        }
                    }
                    //refresh();
                    // LogUtils.d("recomsBean" + recomsBean.get(0).getTitle());

                    //initRecom();
                }
                //adapter.notifyDataSetChanged();
                XLog.e("groups" + groups);
                XLog.e("childs" + childs);
            }
        });

    }


    /**
     * 删除操作
     * 1.不要边遍历边删除,容易出现数组越界的情况
     * 2.把将要删除的对象放进相应的容器中，待遍历完，用removeAll的方式进行删除
     */
    private void doDelete() {
        List<CartListModel.ListBeanXX> toBeDeleteGroups = new ArrayList<>(); //待删除的组元素
        for (int i = 0; i < groups.size(); i++) {
            CartListModel.ListBeanXX group = groups.get(i);
            if (group.isChoosed()) {
                toBeDeleteGroups.add(group);
            }
            List<CartListModel.ListBeanXX.ListBeanX> toBeDeleteChilds = new ArrayList<>();//待删除的子元素
            List<CartListModel.ListBeanXX.ListBeanX> child = childs.get(group.getId());
            for (int j = 0; j < child.size(); j++) {
                if (child.get(j).isChoosed()) {
                    toBeDeleteChilds.add(child.get(j));
                }
            }
            child.removeAll(toBeDeleteChilds);
        }
        groups.removeAll(toBeDeleteGroups);
        //重新设置购物车
        setCartNum();
        adapter.notifyDataSetChanged();

    }


    private void findView() {
        shoppingcatNum = findViewById(R.id.shoppingcat_num);
        actionBarEdit = findViewById(R.id.actionBar_edit);
        //不知道为什么，ButterKnife不知道BindView
        empty_shopcart = findViewById(R.id.layout_empty_shopcart);
    }


    /**
     * @param groupPosition 组元素的位置
     * @param isChecked     组元素的选中与否
     *                      思路:组元素被选中了，那么下辖全部的子元素也被选中
     */
    @Override
    public void checkGroup(int groupPosition, boolean isChecked) {
        CartListModel.ListBeanXX group = groups.get(groupPosition);
        List<CartListModel.ListBeanXX.ListBeanX> child = childs.get(group.getId());
        for (int i = 0; i < child.size(); i++) {
            child.get(i).setChoosed(isChecked);
        }
        if (isCheckAll()) {
            allCheckBox.setChecked(true);//全选
        } else {
            allCheckBox.setChecked(false);//反选
        }
        adapter.notifyDataSetChanged();
        calulate();
    }

    /**
     * @return 判断组元素是否全选
     */
    private boolean isCheckAll() {
        for (CartListModel.ListBeanXX group : groups) {
            if (!group.isChoosed()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param groupPosition 组元素的位置
     * @param childPosition 子元素的位置
     * @param isChecked     子元素的选中与否
     */
    @Override
    public void checkChild(int groupPosition, int childPosition, boolean isChecked) {
        boolean allChildSameState = true; //判断该组下面的所有子元素是否处于同一状态
        CartListModel.ListBeanXX group = groups.get(groupPosition);
        List<CartListModel.ListBeanXX.ListBeanX> child = childs.get(group.getId());
        for (int i = 0; i < child.size(); i++) {
            //不选全中
            if (child.get(i).isChoosed() != isChecked) {
                allChildSameState = false;
                break;
            }
        }

        if (allChildSameState) {
            group.setChoosed(isChecked);//如果子元素状态相同，那么对应的组元素也设置成这一种的同一状态
        } else {
            group.setChoosed(false);//否则一律视为未选中
        }

        if (isCheckAll()) {
            allCheckBox.setChecked(true);//全选
        } else {
            allCheckBox.setChecked(false);//反选
        }

        adapter.notifyDataSetChanged();
        calulate();

    }

    @Override
    public void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        CartListModel.ListBeanXX.ListBeanX good = (CartListModel.ListBeanXX.ListBeanX) adapter.getChild(groupPosition, childPosition);
        int count = Integer.valueOf(good.getTotal());
        count++;
        good.setTotal(String.valueOf(count));
        ((TextView) showCountView).setText(String.valueOf(count));
        adapter.notifyDataSetChanged();
        calulate();
    }

    /**
     * @param groupPosition
     * @param childPosition
     * @param showCountView
     * @param isChecked
     */
    @Override
    public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        CartListModel.ListBeanXX.ListBeanX good = (CartListModel.ListBeanXX.ListBeanX) adapter.getChild(groupPosition, childPosition);
        int count = Integer.valueOf(good.getTotal());
        if (count == 1) {
            return;
        }
        count--;
        good.setTotal(String.valueOf(count));
        ((TextView) showCountView).setText("" + count);
        adapter.notifyDataSetChanged();
        calulate();
    }

    /**
     * @param groupPosition
     * @param childPosition 思路:当子元素=0，那么组元素也要删除
     */
    @Override
    public void childDelete(int groupPosition, int childPosition) {
        CartListModel.ListBeanXX group = groups.get(groupPosition);
        List<CartListModel.ListBeanXX.ListBeanX> child = childs.get(group.getId());
        child.remove(childPosition);
        if (child.size() == 0) {
            groups.remove(groupPosition);
        }
        adapter.notifyDataSetChanged();
        calulate();


    }

    public void doUpdate(int groupPosition, int childPosition, View showCountView, boolean isChecked) {
        CartListModel.ListBeanXX.ListBeanX good = (CartListModel.ListBeanXX.ListBeanX) adapter.getChild(groupPosition, childPosition);
        int count = Integer.valueOf(good.getTotal());
        XLog.i("进行更新数据，数量" + count + "");
        ((TextView) showCountView).setText(String.valueOf(count));
        adapter.notifyDataSetChanged();
        calulate();


    }

    @Override
    public void groupEditor(int groupPosition) {

    }

    @OnClick({R.id.all_checkBox, R.id.go_pay, R.id.share_goods, R.id.collect_goods, R.id.del_goods})
    public void onClick(View view) {
        AlertDialog dialog;
        switch (view.getId()) {
            case R.id.all_checkBox:
                doCheckAll();
                break;
            case R.id.go_pay:
                if (mtotalCount == 0) {
                    ToastUtils.showToast(mcontext, "请选择要支付的商品");
                    return;
                }
                dialog = new AlertDialog.Builder(mcontext).create();
                dialog.setMessage("总计:" + mtotalCount + "种商品，" + mtotalPrice + "元");
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "支付", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                dialog.show();
                break;
            case R.id.del_goods:
                if (mtotalCount == 0) {
                    ToastUtils.showToast(mcontext, "请选择要删除的商品");
                    return;
                }
                dialog = new AlertDialog.Builder(mcontext).create();
                dialog.setMessage("确认要删除该商品吗?");
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doDelete();
                    }
                });
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                dialog.show();
                break;
            case R.id.actionBar_edit:
                flag = !flag;
                setActionBarEditor();
                setVisiable();
                break;
        }
    }

    /**
     * ActionBar标题上点编辑的时候，只显示每一个店铺的商品修改界面
     * ActionBar标题上点完成的时候，只显示每一个店铺的商品信息界面
     */
    private void setActionBarEditor() {
        for (int i = 0; i < groups.size(); i++) {
            CartListModel.ListBeanXX group = groups.get(i);
            if (group.isActionBarEditor()) {
                group.setActionBarEditor(false);
            } else {
                group.setActionBarEditor(true);
            }
        }
        adapter.notifyDataSetChanged();
    }


    /**
     * 全选和反选
     * 错误标记：在这里出现过错误
     */
    private void doCheckAll() {
        for (int i = 0; i < groups.size(); i++) {
            CartListModel.ListBeanXX group = groups.get(i);
            group.setChoosed(allCheckBox.isChecked());
            List<CartListModel.ListBeanXX.ListBeanX> child = childs.get(group.getId());
            for (int j = 0; j < child.size(); j++) {
                child.get(j).setChoosed(allCheckBox.isChecked());//这里出现过错误
            }
        }
        adapter.notifyDataSetChanged();
        calulate();
    }

    /**
     * 计算商品总价格，操作步骤
     * 1.先清空全局计价,计数
     * 2.遍历所有的子元素，只要是被选中的，就进行相关的计算操作
     * 3.给textView填充数据
     */
    private void calulate() {
        mtotalPrice = 0.00;
        mtotalCount = 0;
        for (int i = 0; i < groups.size(); i++) {
            CartListModel.ListBeanXX group = groups.get(i);
            List<CartListModel.ListBeanXX.ListBeanX> child = childs.get(group.getId());
            for (int j = 0; j < child.size(); j++) {
                CartListModel.ListBeanXX.ListBeanX good = child.get(j);
                if (good.isChoosed()) {
                    mtotalCount++;
                    mtotalPrice += Double.valueOf(good.getMarketprice()) * Integer.valueOf(good.getTotal());
                }
            }
        }
        totalPrice.setText("￥" + mtotalPrice + "");
        goPay.setText("去支付(" + mtotalCount + ")");
        if (mtotalCount == 0) {
            setCartNum();
        } else {
            shoppingcatNum.setText("购物车(" + mtotalCount + ")");
        }


    }

    private void setVisiable() {
        if (flag) {
            orderInfo.setVisibility(View.GONE);
            shareInfo.setVisibility(View.VISIBLE);
            actionBarEdit.setText("完成");
        } else {
            orderInfo.setVisibility(View.VISIBLE);
            shareInfo.setVisibility(View.GONE);
            actionBarEdit.setText("编辑");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter = null;
        childs.clear();
        groups.clear();
        mtotalPrice = 0.00;
        mtotalCount = 0;
    }
}
