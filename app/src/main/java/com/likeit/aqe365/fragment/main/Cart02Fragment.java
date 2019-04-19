package com.likeit.aqe365.fragment.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.elvishew.xlog.XLog;
import com.likeit.aqe365.activity.detail.GoodDetailActivity;
import com.likeit.aqe365.adapter.cart.CartRecomAdapter;
import com.likeit.aqe365.adapter.cart01.CartShopAdapter;
import com.likeit.aqe365.adapter.cart01.bean.NormalBean;
import com.likeit.aqe365.base.BaseFragment;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.cart01.CartListModel;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.ocnyang.cartlayout.bean.CartItemBean;
import com.ocnyang.cartlayout.bean.ICartItem;
import com.ocnyang.cartlayout.listener.CartOnCheckChangeListener;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cart02Fragment extends BaseFragment implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private TextView mTvTitle;
    private TextView mTvEdit;
    private CheckBox mCheckBoxAll;
    private TextView mTvTotal;
    private Button mBtnSubmit;

    CartShopAdapter mAdapter;

    private boolean isEditing;//是否处于编辑状态
    private int totalCount;//购物车商品ChildItem的总数量，店铺条目不计算在内
    private int totalCheckedCount;//勾选的商品总数量，店铺条目不计算在内
    private double totalPrice;//勾选的商品总价格
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ArrayList<CartItemBean> cartItemBeans = new ArrayList<>();
    private LinearLayout order_info;
    private CartListModel cartListModel;
    private List<CartListModel.ListBeanXX> ShopData;
    private LinearLayout layout_empty_shopcart;
    private LinearLayout ll_bottom;
    private LinearLayout ll_cart;
    private RecyclerView mRecyclerView;
    private List<CartListModel.RecomsBean.ListBean> recomsBean=new ArrayList<>();
    private CartRecomAdapter mAdapter01;

    @Override
    protected int setContentView() {
        return R.layout.fragment_cart02;
    }

    @Override
    protected void lazyLoad() {
        initUI();

    }

    private void initUI() {
        //View footer = LayoutInflater.from(getActivity()).inflate(R.layout.home_cart_footview, null);
        mRecyclerView = findViewById(R.id.RecyclerView);
        recyclerView = ((RecyclerView) findViewById(R.id.recycler));
        ll_cart = ((LinearLayout) findViewById(R.id.ll_cart));//购物车布局
        layout_empty_shopcart = ((LinearLayout) findViewById(R.id.layout_empty_shopcart));//空布局
        ll_bottom = ((LinearLayout) findViewById(R.id.ll_bottom));//底部
        mSwipeRefreshLayout = ((SwipeRefreshLayout) findViewById(R.id.mSwipeRefreshLayout));
        mTvTitle = ((TextView) findViewById(R.id.tv_title));
        mTvEdit = ((TextView) findViewById(R.id.tv_edit));
        mCheckBoxAll = ((CheckBox) findViewById(R.id.checkbox_all));
        mTvTotal = ((TextView) findViewById(R.id.tv_total_price));
        mBtnSubmit = ((Button) findViewById(R.id.btn_go_to_pay));
        order_info = ((LinearLayout) findViewById(R.id.order_info));

        mTvEdit.setOnClickListener(this);
        mCheckBoxAll.setOnClickListener(this);
        mBtnSubmit.setOnClickListener(this);

        mTvTitle.setText(getString(R.string.cart));
        mBtnSubmit.setText(getString(R.string.go_settle_X, 0));
        mTvTotal.setText(getString(R.string.rmb_X, 0.00));
        mSwipeRefreshLayout.setOnRefreshListener(this);
        initRecom();

      //  initRecom();
//        recyclerView.addView(footer);
       // mSwipeRefreshLayout.setRefreshing(true);

        // 给列表注册 ContextMenu 事件。
        // 同时如果想让ItemView响应长按弹出菜单，需要在item xml布局中设置 android:longClickable="true"

    }

    private void initCart() {
        XLog.e("cartItemBeans"+cartItemBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new CartShopAdapter(getActivity(), cartItemBeans);
        mAdapter.setOnCheckChangeListener(new CartOnCheckChangeListener(recyclerView, mAdapter) {
            @Override
            public void onCalculateChanged(ICartItem cartItemBean) {
                calculate();
            }
        });
        recyclerView.setAdapter(mAdapter);
        registerForContextMenu(recyclerView);
    }

    private void initRecom() {
        XLog.e("recomsBean"+recomsBean);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mAdapter01 = new CartRecomAdapter(R.layout.cart_recom_items, recomsBean);
       // mAdapter01.setNewData(recomsBean);
        mRecyclerView.setAdapter(mAdapter01);
        mRecyclerView.setHasFixedSize(true);
        mAdapter01.notifyDataSetChanged();
        mAdapter01.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String cid = recomsBean.get(position).getId();
                Intent intent = new Intent(getActivity(), GoodDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", cid);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        onRefresh();

    }

    @Override
    public void onRefresh() {
        cartItemBeans.clear();
       // recomsBean.clear();
        initData();
       // mAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mSwipeRefreshLayout != null && mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            }
        }, 1000);
    }
//    /**
//     * 添加选项菜单
//     * @param menu
//     * @param v
//     * @param menuInfo
//     */
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.main_contextmenu, menu);
//    }

//    /**
//     * 选项菜单点击事件
//     * @param item
//     * @return
//     */
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        //获取到的是 listView 里的条目信息
//        RecyclerViewWithContextMenu.RecyclerViewContextInfo info = (RecyclerViewWithContextMenu.RecyclerViewContextInfo) item.getMenuInfo();
//        Log.d("ContentMenu", "onCreateContextMenu position = " + (info != null ? info.getPosition() : "-1"));
//        if (info != null && info.getPosition() != -1) {
//            switch (item.getItemId()) {
//                case R.id.action_remove:
//                    mAdapter.removeChild(info.getPosition());
//                    Toast.makeText(this, "成功移入收藏", Toast.LENGTH_SHORT).show();
//                    break;
//                case R.id.action_findmore:
//                    Toast.makeText(this, "查找与" + ((GoodsBean) mAdapter.getData().get(info.getPosition())).getGoods_name() + "相似的产品", Toast.LENGTH_SHORT).show();
//                    break;
//                case R.id.action_delete:
//                    mAdapter.removeChild(info.getPosition());
//                    break;
//                default:
//                    break;
//            }
//        }
//        return super.onContextItemSelected(item);
//    }

    /**
     * 统计操作<br>
     * 1.先清空全局计数器<br>
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作<br>
     * 3.给相关的 textView 进行数据填充
     */
    private void calculate() {
        totalCheckedCount = 0;
        totalCount = 0;
        totalPrice = 0.00;
        int notChildTotalCount = 0;
        if (mAdapter.getData() != null) {
            for (ICartItem iCartItem : mAdapter.getData()) {
                if (iCartItem.getItemType() == ICartItem.TYPE_CHILD) {
                    totalCount++;
                    if (iCartItem.isChecked()) {
                        totalCheckedCount++;
                        totalPrice += ((CartListModel.ListBeanXX.ListBeanX) iCartItem).getMarketprice() * Integer.valueOf(((CartListModel.ListBeanXX.ListBeanX) iCartItem).getTotal());
                    }
                } else {
                    notChildTotalCount++;
                }
            }
        }

        mTvTitle.setText(getString(R.string.cart));
        mBtnSubmit.setText(getString(isEditing ? R.string.delete_X : R.string.go_settle_X, totalCheckedCount));
        mTvTotal.setText(getString(R.string.rmb_X, totalPrice));
        if (mCheckBoxAll.isChecked() && (totalCheckedCount == 0 || (totalCheckedCount + notChildTotalCount) != mAdapter.getData().size())) {
            mCheckBoxAll.setChecked(false);
        }
        if (totalCheckedCount != 0 && (!mCheckBoxAll.isChecked()) && (totalCheckedCount + notChildTotalCount) == mAdapter.getData().size()) {
            mCheckBoxAll.setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //编辑按钮事件
            case R.id.tv_edit:
                isEditing = !isEditing;
                mTvEdit.setText(getString(isEditing ? R.string.edit_done : R.string.edit));
                mBtnSubmit.setText(getString(isEditing ? R.string.delete_X : R.string.go_settle_X, totalCheckedCount));
                order_info.setVisibility(isEditing ? View.INVISIBLE : View.VISIBLE);
//                if (isEditing) {
//                    order_info.setVisibility(View.INVISIBLE);
//                } else order_info.setVisibility(View.VISIBLE);
                break;
            //提交订单 & 删除选中（编辑状态）
            case R.id.btn_go_to_pay:
                submitEvent();
                break;
            case R.id.checkbox_all:
                mAdapter.checkedAll(((CheckBox) v).isChecked());
                break;
            default:
                break;
        }
    }

    private void submitEvent() {
        if (isEditing) {
            if (totalCheckedCount == 0) {
                Toast.makeText(getActivity(), "请勾选你要删除的商品", Toast.LENGTH_SHORT).show();
            } else {
                mAdapter.removeChecked();
               // onRefresh();
            }

        } else {
            if (totalCheckedCount == 0) {
                Toast.makeText(getActivity(), "你还没有选择任何商品", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(),
                        new StringBuilder().append("你选择了").append(totalCheckedCount).append("件商品")
                                .append("共计 ").append(totalPrice).append("元"),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 数据初始化尤其重要
     * 1. childItem 数据全部在 GroupItem 数据的下方，数据顺序严格按照对应关系；
     * 2. GroupItem 下的 ChildItem 数据不能为空；
     * 3. 初始化时如果不需要，所有类型的条目都可以不设置ID，GroupItem也不用设置setChilds()；
     * <p>
     * 列表操作时数据动态的变化设置：
     * 1. 通过 CartAdapter 的 addData、setNewData；
     * 2. 单个添加各个条目可以通过对应的 add 方法；
     * 3. 单独添加一个 GroupItem ,可以把它的 ChildItem 数据放到 setChilds 中。
     *
     * @return
     */
    private void initData() {
        RetrofitUtil.getInstance().getCartList(openid, new Subscriber<BaseResponse<CartListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<CartListModel> baseResponse) {
                XLog.e("size999" + baseResponse.getData().getRecoms());
                if (baseResponse.getCode() == 200) {
                    cartListModel = baseResponse.getData();
                    recomsBean = cartListModel.getRecoms().getList();
                    mAdapter01.setNewData(recomsBean);
                    mAdapter01.notifyDataSetChanged();
                    ShopData = cartListModel.getList();
                    if (ShopData == null) {
                        layout_empty_shopcart.setVisibility(View.VISIBLE);
                        ll_bottom.setVisibility(View.GONE);
                        mTvEdit.setVisibility(View.GONE);
                    } else {
                        initCart();
                        layout_empty_shopcart.setVisibility(View.GONE);
                        ll_bottom.setVisibility(View.VISIBLE);
                        mTvEdit.setVisibility(View.VISIBLE);
                       // mAdapter.notifyDataSetChanged();
                        for (int i = 0; i < ShopData.size(); i++) {
                            CartListModel.ListBeanXX shopBean = new CartListModel.ListBeanXX();
                            shopBean.setMerchid(ShopData.get(i).getMerchid());
                            shopBean.setMerchname(ShopData.get(i).getMerchname());
                            shopBean.setList(ShopData.get(i).getList());
                            shopBean.setItemType(CartItemBean.TYPE_GROUP);
                            cartItemBeans.add(shopBean);
                            for (int j = 0; j <= ShopData.get(i).getList().size(); j++) {
                                CartListModel.ListBeanXX.ListBeanX goodBean = new CartListModel.ListBeanXX.ListBeanX();
                                goodBean.setItemType(CartItemBean.TYPE_CHILD);
                                goodBean.setId(ShopData.get(i).getList().get(j).getId());
                                goodBean.setGoodsid(ShopData.get(i).getList().get(j).getGoodsid());
                                goodBean.setLinkurl(ShopData.get(i).getList().get(j).getLinkurl());
                                goodBean.setMarketprice(ShopData.get(i).getList().get(j).getMarketprice());
                                goodBean.setMerchid(ShopData.get(i).getList().get(j).getMerchid());
                                goodBean.setMinbuy(ShopData.get(i).getList().get(j).getMinbuy());
                                goodBean.setOptionid(ShopData.get(i).getList().get(j).getOptionid());
                                goodBean.setOptiontitle(ShopData.get(i).getList().get(j).getOptiontitle());
                                goodBean.setParams(ShopData.get(i).getList().get(j).getParams());
                                goodBean.setStock(ShopData.get(i).getList().get(j).getStock());
                                goodBean.setThumb(ShopData.get(i).getList().get(j).getThumb());
                                goodBean.setTitle(ShopData.get(i).getList().get(j).getTitle());
                                goodBean.setTotal(ShopData.get(i).getList().get(j).getTotal());
                                goodBean.setTotalmaxbuy(ShopData.get(i).getList().get(j).getTotalmaxbuy());
                                goodBean.setUnit(ShopData.get(i).getList().get(j).getUnit());
                                goodBean.setWeburl(ShopData.get(i).getList().get(j).getWeburl());
                                goodBean.setGroupId(i);
                                cartItemBeans.add(goodBean);
                            }
                        }
                    }
                }
            }
        });
    }


//
//    private void initData() {
//        NormalBean normalBean = new NormalBean();
//        normalBean.setMarkdownNumber(6);
//        cartItemBeans.add(normalBean);
//
//        for (int i = 0; i < 10; i++) {
//            ShopBean shopBean = new ShopBean();
//            shopBean.setShop_name("解忧杂货铺 第" + (i + 1) + "分店");
//            shopBean.setItemType(CartItemBean.TYPE_GROUP);
//            cartItemBeans.add(shopBean);
//
//            for (int j = 0; j < (i + 5); j++) {
//                GoodsBean goodsBean = new GoodsBean();
//                goodsBean.setGoods_name("忘忧水 " + (j + 1) + " 代");
//                goodsBean.setItemType(CartItemBean.TYPE_CHILD);
//                goodsBean.setItemId((j + 1) * 10 + j);
//                goodsBean.setGoods_price(j + 1);
//                goodsBean.setGroupId(i);
//                cartItemBeans.add(goodsBean);
//            }
//        }
//    }
}
