package com.likeit.aqe365.fragment.main;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.elvishew.xlog.XLog;
import com.google.gson.Gson;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.MainActivity;
import com.likeit.aqe365.activity.detail.GoodDetailActivity;
import com.likeit.aqe365.activity.login_register.LoginActivity;
import com.likeit.aqe365.adapter.cart.CartRecom01Adapter;
import com.likeit.aqe365.adapter.cart.ShopcartExpandableListViewAdapter;
import com.likeit.aqe365.adapter.sort.bean.CartDeleteModel;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.Indent.OrderCreateModel;
import com.likeit.aqe365.network.model.cart.CartListModel01;
import com.likeit.aqe365.network.model.cart.JsonCartBean;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.AppManager;
import com.likeit.aqe365.utils.ChooseGoodsSales.BigDecimalUtils;
import com.likeit.aqe365.utils.IntentUtils;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.utils.ToastUtils;
import com.likeit.aqe365.view.SuperExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends BaseFragment implements ShopcartExpandableListViewAdapter.CheckInterface, View.OnClickListener, ShopcartExpandableListViewAdapter.ModifyCountInterface, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.mSwipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.exListView)
    SuperExpandableListView mExListView;
    @BindView(R.id.all_chekbox)
    CheckBox mAllChekbox;
    @BindView(R.id.tv_total01)
    TextView mTvTotal01;
    @BindView(R.id.tv_total_price)
    TextView mTvTotalPrice;
    @BindView(R.id.tv_delete)
    TextView mTvDelete;
    @BindView(R.id.tv_go_to_pay)
    TextView mTvGoToPay;
    @BindView(R.id.toolbar_righ_tv)
    TextView mToolbarRighTv;
    @BindView(R.id.tv_yunfei)
    TextView tv_yunfei;
    @BindView(R.id.ll_cart_bottom)
    LinearLayout ll_cart_bottom;
    RecyclerView mRecyclerView;
    private Context context;
    private String[] mIconSelectIds;//标题

    private String[] mTitles;//未选中

    private String[] mLinkurl;
    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量
    private boolean flag = false;//判断是编辑还是完成按钮
    private ShopcartExpandableListViewAdapter selva;
    private List<CartListModel01.ListBeanXX> groups = new ArrayList<>();// 组元素数据列表
    private Map<String, List<CartListModel01.ListBeanXX.ListBeanX>> children = new HashMap<>();// 子元素数据列表
    private View view;
    private List<CartListModel01.RecomsBean.ListBean> recomsBean = new ArrayList<>();
    private CartRecom01Adapter mAdapter;
    private TextView mTvGoHome;
    private CartListModel01 cartListModel;
    private View header;
    List<CartListModel01.ListBeanXX.ListBeanX> products = new ArrayList<>();
    private View footer;
    private String isheader;

    @Override
    protected int setContentView() {
        return R.layout.fragment_cart;
    }

    @Override
    protected void lazyLoad() {
        mToolbarRighTv.setVisibility(View.VISIBLE);
        mToolbarRighTv.setText("编辑");
        mTitles = getActivity().getIntent().getStringArrayExtra("mTitles");
        mLinkurl = getActivity().getIntent().getStringArrayExtra("mLinkurl");
        mIconSelectIds = getActivity().getIntent().getStringArrayExtra("mIconSelectIds");
        setTitle("购物车");
        XLog.e("openid-->" + openid);
        if (!StringUtil.isBlank(openid)) {
            initUI();
            virtualData();
            //   initEvents();
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("linkurl", "cart");
            toActivity(LoginActivity.class, bundle);
            getActivity().finish();
        }
//
    }


    public void initUI() {
        context = getActivity();
        mTvDelete.setBackgroundColor(Color.parseColor("#FF2150"));
        mTvGoToPay.setBackgroundColor(Color.parseColor("#FF2150"));

    }

    @Override
    public void onRefresh() {
        recomsBean.clear();
        groups.clear();
        mExListView.collapseGroup(0);
//        children.clear();
        mExListView.removeFooterView(footer);
        selva.notifyDataSetChanged();
        if("1".equals(isheader)){
            mExListView.removeHeaderView(header);
        }
        virtualData();
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }, 1000);
    }


    @Override
    public void onResume() {
        super.onResume();
        // virtualData();

    }


    private void initEvents() {
        footer = LayoutInflater.from(getActivity()).inflate(R.layout.home_cart_footview, null);
        header = LayoutInflater.from(getActivity()).inflate(R.layout.empty_shopcart, null);
        mTvGoHome = header.findViewById(R.id.tv_go_home);
        mRecyclerView = footer.findViewById(R.id.RecyclerView);
        mTvGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("flag", "0");
                bundle.putStringArray("mTitles", mTitles);
                bundle.putStringArray("mLinkurl", mLinkurl);
                bundle.putStringArray("mIconSelectIds", mIconSelectIds);
                bundle.putInt("index", 0);
                toActivity(MainActivity.class, bundle);
                AppManager.getAppManager().finishAllActivity();
            }
        });
        selva = new ShopcartExpandableListViewAdapter(groups, children, getActivity());
        selva.setCheckInterface(this);// 关键步骤1,设置复选框接口
        selva.setModifyCountInterface(this);// 关键步骤2,设置数量增减接口
        mExListView.setAdapter(selva);
        for (int i = 0; i < selva.getGroupCount(); i++) {
            mExListView.expandGroup(i);// 关键步骤3,初始化时，将ExpandableListView以展开的方式呈现
        }
        initRecom();
        mExListView.addFooterView(footer);

        XLog.e("cartListModel.getList()"+cartListModel.getList());
        if (cartListModel.getList() == null) {
            isheader="1";
            mExListView.addHeaderView(header);
            mToolbarRighTv.setVisibility(View.GONE);
            ll_cart_bottom.setVisibility(View.GONE);
        }else{
            mToolbarRighTv.setVisibility(View.VISIBLE);
            ll_cart_bottom.setVisibility(View.VISIBLE);
        }
        mAllChekbox.setOnClickListener(this);
        mTvDelete.setOnClickListener(this);
        mTvGoToPay.setOnClickListener(this);
        mToolbarRighTv.setOnClickListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mExListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String linkUrl = products.get(childPosition).getLinkurl();
                String webUrl = products.get(childPosition).getWeburl();
                IntentUtils.intentTo(getActivity(), linkUrl, "", webUrl);
                return true;
            }
        });
    }

    /**
     * 模拟数据<br>
     * 遵循适配器的数据列表填充原则，组元素被放在一个List中，对应的组元素下辖的子元素被放在Map中，<br>
     * 其键是组元素的Id(通常是一个唯一指定组元素身份的值)
     */
    private void virtualData() {
        RetrofitUtil.getInstance().getCartList01(openid, new Subscriber<BaseResponse<CartListModel01>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(BaseResponse<CartListModel01> baseResponse) {
                XLog.e("base:" + baseResponse.getCode());
                if (baseResponse.code == 200) {
                    cartListModel = baseResponse.getData();
                    recomsBean = cartListModel.getRecoms().getList();
                    if (cartListModel.getList() != null) {
                        for (int i = 0; i < cartListModel.getList().size(); i++) {
                            groups.add(new CartListModel01.ListBeanXX(i + "", cartListModel.getList().get(i).getMerchname(), cartListModel.getList().get(i).getMerchid(), cartListModel.getList().get(i).getList()));
                            products = new ArrayList<>();
                            for (int j = 0; j <= i; j++) {
                                products = groups.get(i).getList();
                            }
                            children.put(groups.get(i).getId(), products);
                        }
                    }
                    refresh();
                }
            }
        });
    }

    private void refresh() {
        initEvents();
    }

    private void initRecom() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new CartRecom01Adapter(R.layout.cart_recom_items, recomsBean);
        mAdapter.setNewData(recomsBean);
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                String cid = recomsBean.get(position).getId();
//                Intent intent = new Intent(getActivity(), GoodDetailActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("id", cid);
//                intent.putExtras(bundle);
//                startActivity(intent);
                String linkUrl = recomsBean.get(position).getLinkurl();
                String webUrl = recomsBean.get(position).getWeburl();
                IntentUtils.intentTo(getActivity(), linkUrl, "", webUrl);
            }
        });
    }

    @Override
    public void checkGroup(int groupPosition, boolean isChecked) {
        CartListModel01.ListBeanXX group = groups.get(groupPosition);
        List<CartListModel01.ListBeanXX.ListBeanX> childs = children.get(group.getId());
        for (int i = 0; i < childs.size(); i++) {
            childs.get(i).setChoosed(isChecked);
        }
        if (isAllCheck())
            mAllChekbox.setChecked(true);
        else
            mAllChekbox.setChecked(false);
        selva.notifyDataSetChanged();
        calculate();
    }

    @Override
    public void checkChild(int groupPosition, int childPosition, boolean isChecked) {
        boolean allChildSameState = true;// 判断改组下面的所有子元素是否是同一种状态
        CartListModel01.ListBeanXX group = groups.get(groupPosition);
        List<CartListModel01.ListBeanXX.ListBeanX> childs = children.get(group.getId());
        for (int i = 0; i < childs.size(); i++) {
            if (childs.get(i).isChoosed() != isChecked) {
                allChildSameState = false;
                break;
            }
        }
        if (allChildSameState) {
            group.setChoosed(isChecked);// 如果所有子元素状态相同，那么对应的组元素被设为这种统一状态
        } else {
            group.setChoosed(false);// 否则，组元素一律设置为未选中状态
        }

        if (isAllCheck())
            mAllChekbox.setChecked(true);
        else
            mAllChekbox.setChecked(false);
        selva.notifyDataSetChanged();
        calculate();
    }

    @Override
    public void doIncrease(int groupPosition, int childPosition, View showCountView,
                           boolean isChecked) {
        CartListModel01.ListBeanXX.ListBeanX product = (CartListModel01.ListBeanXX.ListBeanX) selva.getChild(groupPosition, childPosition);
        int currentCount = Integer.valueOf(product.getTotal());
        currentCount++;
        product.setTotal(String.valueOf(currentCount));
        ((TextView) showCountView).setText(currentCount + "");

        selva.notifyDataSetChanged();
        calculate();
    }

    @Override
    public void doDecrease(int groupPosition, int childPosition, View showCountView,
                           boolean isChecked) {
        CartListModel01.ListBeanXX.ListBeanX product = (CartListModel01.ListBeanXX.ListBeanX) selva.getChild(groupPosition, childPosition);
        int currentCount = Integer.valueOf(product.getTotal());
        if (currentCount == 1)
            return;
        currentCount--;

        product.setTotal(String.valueOf(currentCount));
        ((TextView) showCountView).setText(currentCount + "");

        selva.notifyDataSetChanged();
        calculate();
    }

    @Override
    public void onClick(View v) {
        AlertDialog alert;
        switch (v.getId()) {
            case R.id.all_chekbox:
                doCheckAll();
                break;
            case R.id.tv_go_to_pay:
                if (totalCount == 0) {
                    Toast.makeText(context, "请选择要支付的商品", Toast.LENGTH_LONG).show();
                    return;
                }
                alert = new AlertDialog.Builder(context).create();
                alert.setTitle("操作提示");
                alert.setMessage("总计:\n" + totalCount + "种商品\n" + totalPrice + "元");
                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //                                       Intent intent = new Intent(getActivity(), ConfirmOrderActivity.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putString("id", "");
//                        bundle.putString("optionid", optionids);
//                        bundle.putString("total", "");
//                        bundle.putString("cartids", cartIds);
//                        bundle.putString("cartnum", cartNums);
//                        bundle.putString("goodsIds", goodsIds);
//                        bundle.putString("indentFlag", "2");
                        XLog.e("optionid-->" + optionids + "<--cartIds-->" + cartIds + "<--cartNums-->" + cartNums + "<--goodsIds-->" + goodsIds);
//                        toActivity(ConfirmOrderActivity.class, bundle);
                        String url = "http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=order.create";
                        String webUrl = url + "&id=" + "" + "&optionid=" + optionids + "&total=" + "" + "&cartids=" + cartIds + "&cartnum=" + cartNums + "&goodsIds=" + goodsIds + "&indentFlag=" + "2";
                        XLog.e("webUrl:" + webUrl);
                        JsonCartBean jsonCartBean = new JsonCartBean();
                        jsonCartBean.setCartids(cartIds);
                        jsonCartBean.setCartnum(cartNums);
                        jsonCartBean.setOpenid(openid);
                        Gson gson = new Gson();
                        String json = gson.toJson(jsonCartBean);
                        SharedPreferencesUtils.put(getActivity(), "JsonCartBean", json);
                        XLog.e("jsonCartBean" + jsonCartBean);
                        XLog.e("json" + json);
                        // IntentUtils.intentTo(getActivity(), "", "", webUrl);

                        orderTrue(cartIds, cartNums);

                    }
                });
                alert.show();
                break;
            case R.id.tv_delete:
                if (totalCount == 0) {
                    Toast.makeText(context, "请选择要移除的商品", Toast.LENGTH_LONG).show();
                    return;
                }
                alert = new AlertDialog.Builder(context).create();
                alert.setTitle("操作提示");
                alert.setMessage("您确定要将这些商品从购物车中移除吗？");
                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        doDelete();
                    }
                });
                alert.show();
                break;
            case R.id.toolbar_righ_tv:
                flag = !flag;
                if (flag) {
                    selva.notifyDataSetChanged();
                    mToolbarRighTv.setText("完成");
                    //shoppingCartAdapter.isShow(false);
                    mTvTotal01.setVisibility(View.GONE);
                    mTvTotalPrice.setVisibility(View.GONE);
                    mTvGoToPay.setVisibility(View.GONE);
                    mTvDelete.setVisibility(View.VISIBLE);
                    mAllChekbox.setVisibility(View.VISIBLE);
                    tv_yunfei.setVisibility(View.GONE);
                } else {
                    selva.notifyDataSetChanged();
                    mToolbarRighTv.setText("编辑");
                    mTvTotal01.setVisibility(View.VISIBLE);
                    mTvTotalPrice.setVisibility(View.VISIBLE);
                    mTvGoToPay.setVisibility(View.VISIBLE);
                    mTvDelete.setVisibility(View.GONE);
                    tv_yunfei.setVisibility(View.VISIBLE);
                    mAllChekbox.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    private void orderTrue(String cartIds, String cartNums) {
        RetrofitUtil.getInstance().CreateCartOrder(openid, cartIds, cartNums, "", "", "", new Subscriber<BaseResponse<OrderCreateModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<OrderCreateModel> baseResponse) {
                XLog.e("code" + baseResponse.getCode());
                if (baseResponse.getCode() == 200) {
                    String url = "http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=order.create";
                    String webUrl = url + "&openid=" + openid;
                    IntentUtils.intentTo(getActivity(), "", "", webUrl);
                } else {
                    showProgress(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 删除操作<br>
     * 1.不要边遍历边删除，容易出现数组越界的情况<br>
     * 2.现将要删除的对象放进相应的列表容器中，待遍历完后，以removeAll的方式进行删除
     */
    public void doDelete() {
        List<CartListModel01.ListBeanXX> toBeDeleteGroups = new ArrayList<>();// 待删除的组元素列表
        String goodsId = null;
        String ids = "";
        String temp = "";
        for (int i = 0; i < groups.size(); i++) {
            CartListModel01.ListBeanXX group = groups.get(i);
            if (group.isChoosed()) {

                toBeDeleteGroups.add(group);
            }
            List<CartListModel01.ListBeanXX.ListBeanX> toBeDeleteProducts = new ArrayList<>();// 待删除的子元素列表

            List<CartListModel01.ListBeanXX.ListBeanX> childs = children.get(group.getId());
            for (int j = 0; j < childs.size(); j++) {
                if (childs.get(j).isChoosed()) {
                    toBeDeleteProducts.add(childs.get(j));
                    temp = childs.get(j).getId();
                    ids += temp + ",";

                }
            }
            childs.removeAll(toBeDeleteProducts);
        }
        groups.removeAll(toBeDeleteGroups);
        if (ids.length() > 0) {
            goodsId = ids.substring(0, ids.length() - 1);
        }
        delectCart(goodsId);//删除购物车数据接口
        selva.notifyDataSetChanged();
        calculate();
    }

    private void delectCart(String goodsId) {
        RetrofitUtil.getInstance().removeCart(openid, goodsId, new Subscriber<BaseResponse<CartDeleteModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<CartDeleteModel> baseResponse) {
                if (baseResponse.code == 200) {
                    String number = baseResponse.getData().getNum();
                    ToastUtils.showToast(getActivity(), "删除成功！");
                    // virtualData();
//                    if ("0".equals(number)) {
//                     //   mExListView.addHeaderView(header);
//                        mToolbarRighTv.setVisibility(View.GONE);
//                        ll_cart_bottom.setVisibility(View.GONE);
//
//                    }
                    onRefresh();
                } else {
                    showProgress(baseResponse.getMsg());
                }
            }
        });
    }

    /**
     * 全选与反选
     */
    private void doCheckAll() {
        for (int i = 0; i < groups.size(); i++) {
            groups.get(i).setChoosed(mAllChekbox.isChecked());
            CartListModel01.ListBeanXX group = groups.get(i);
            List<CartListModel01.ListBeanXX.ListBeanX> childs = children.get(group.getId());
            for (int j = 0; j < childs.size(); j++) {
                childs.get(j).setChoosed(mAllChekbox.isChecked());
            }
        }
        selva.notifyDataSetChanged();
        calculate();
    }

    /**
     * 统计操作<br>
     * 1.先清空全局计数器<br>
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作<br>
     * 3.给底部的textView进行数据填充
     */


    String cartIds = "";
    String cartNums = "";
    String optionids = "";
    String goodsIds = "";

    private void calculate() {

        totalCount = 0;
        totalPrice = 0.00;
        String cartId = "";
        String cartNum = "";
        String optionid = "";
        String goodsId = "";

        for (int i = 0; i < groups.size(); i++) {
            CartListModel01.ListBeanXX group = groups.get(i);
            List<CartListModel01.ListBeanXX.ListBeanX> childs = children.get(group.getId());
            for (int j = 0; j < childs.size(); j++) {
                CartListModel01.ListBeanXX.ListBeanX product = childs.get(j);
                if (product.isChoosed()) {
                    totalCount++;
                    totalPrice += product.getMarketprice() * Integer.valueOf(product.getTotal());
                    String temp01 = product.getId();
                    String temp02 = product.getTotal();
                    String temp03 = product.getOptionid();
                    String temp04 = product.getGoodsid();

                    cartId += temp01 + ",";
                    cartNum += temp02 + ",";
                    optionid += temp03 + ",";
                    goodsId += temp04 + ",";
                }
            }
        }

        if (cartId.length() > 0) {
            cartIds = cartId.substring(0, cartId.length() - 1);
        }
        if (cartNum.length() > 0) {
            cartNums = cartNum.substring(0, cartNum.length() - 1);
        }
        if (optionid.length() > 0) {
            optionids = optionid.substring(0, optionid.length() - 1);
        }
        if (goodsId.length() > 0) {
            goodsIds = goodsId.substring(0, goodsId.length() - 1);
        }
//        if (ids.length() > 0) {
//            goodsId = ids.substring(0, ids.length() - 1);
//            LogUtils.d("goodsId-->" + goodsId);
//        }
//
        mTvTotalPrice.setText("￥" + BigDecimalUtils.toDecimal(totalPrice, 2));
        mTvGoToPay.setText("去支付(" + totalCount + ")");
        mTvDelete.setText("删除（" + totalCount + ")");
    }

    private boolean isAllCheck() {
        for (CartListModel01.ListBeanXX group : groups) {
            if (!group.isChoosed())
                return false;
        }
        return true;
    }

}
