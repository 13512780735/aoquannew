package com.likeit.aqe365.adapter.div_provider.home;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.home.MainHomeGoodModel;
import com.likeit.aqe365.utils.ImageLoaderUtils;
import com.likeit.aqe365.utils.IntentUtils;
import com.likeit.aqe365.utils.StringUtil;
import com.likeit.aqe365.view.BorderTextView;
import com.likeit.aqe365.view.RatioImageView;
import com.likeit.aqe365.view.custom_scrollview.HorizontalPageLayoutManager;
import com.likeit.aqe365.view.custom_scrollview.PagingScrollHelper;

import java.util.List;

public class MainGoodsItemProvider extends BaseItemProvider<MainHomeGoodModel, BaseViewHolder> {
    private RecyclerView mRecycleView;
    private HorizontalPageLayoutManager horizontalPageLayoutManager;
    List<MainHomeGoodModel.DataBean> dataBean;
    private MainGoodsAdapter mAdapter;
    PagingScrollHelper scrollHelper = new PagingScrollHelper();
    MainHomeGoodModel.ParamsBean paramsBean;
    MainHomeGoodModel.StyleBean styleBean;
    private int columns;
    LinearLayout.LayoutParams linearParams;
    private String showprice;
    private String showproductprice;
    private String showsales;
    private MainGoodsAdapter2 mAdapter2;
    private int w_screen;
    private List<MainHomeGoodModel.DataBean> dataBean1;
    private ImageLoaderUtils mImageLoader;

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_GOODS;
    }

    @Override
    public int layout() {
        return R.layout.main_home_goods;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomeGoodModel data, int position) {
        mRecycleView = helper.getView(R.id.mRecyclerView);
        linearParams = (LinearLayout.LayoutParams) mRecycleView.getLayoutParams();
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        w_screen = dm.widthPixels;

        paramsBean = data.getParams();
        styleBean = data.getStyle();
        mRecycleView.setBackgroundColor(Color.parseColor(styleBean.getBackground()));
        String goodsscroll = paramsBean.getGoodsscroll();    //  0-普通模式；1-单行滑动模式
        String liststy = styleBean.getListstyle();
        showprice = paramsBean.getShowprice(); //价格是否显示 0-不显示；1-显示
        showproductprice = paramsBean.getShowproductprice(); //原价是否显示 0-不显示；1-显示
        showsales = paramsBean.getShowsales(); //销量是否显示 0-不显示；1-显示


        if ("0".equals(goodsscroll)) {
            if ("".equals(liststy)) {
                columns = 1;
                dataBean1 = data.getData();
                mRecycleView.setLayoutManager(new GridLayoutManager(mContext, columns));
                mAdapter2 = new MainGoodsAdapter2(R.layout.main_home_goods_item2, dataBean1);
                mRecycleView.setAdapter(mAdapter2);
                linearParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
                mRecycleView.setLayoutParams(linearParams);
                mRecycleView.setHasFixedSize(true);
                mAdapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        String cid = dataBean1.get(position).getGid();
                        String linkUrl = dataBean1.get(position).getLinkurl();
                        String webUrl = dataBean1.get(position).getWeburl();
                        if (!StringUtil.isBlank(cid)) {
                            IntentUtils.intentTo(mContext, linkUrl, cid, webUrl);

                        }
                    }
                });
            } else if ("block one".equals(liststy)) {
                columns = 1;
                dataBean = data.getData();
                mRecycleView.setLayoutManager(new GridLayoutManager(mContext, columns));
                mAdapter = new MainGoodsAdapter(R.layout.main_home_goods_item, dataBean);
                mRecycleView.setAdapter(mAdapter);
                linearParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
                mRecycleView.setLayoutParams(linearParams);
                mRecycleView.setHasFixedSize(true);
                mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                        String cid = dataBean.get(position).getGid();
                        String linkUrl=dataBean.get(position).getLinkurl();
                        String webUrl=dataBean.get(position).getWeburl();
                        if(!StringUtil.isBlank(cid)){
                            IntentUtils.intentTo(mContext,linkUrl,cid,webUrl);

                        }
                    }
                });
            } else if ("block".equals(liststy)) {
                columns = 2;
                dataBean = data.getData();
                mRecycleView.setLayoutManager(new GridLayoutManager(mContext, columns));
                mAdapter = new MainGoodsAdapter(R.layout.main_home_goods_item, dataBean);
                mRecycleView.setAdapter(mAdapter);
                linearParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
                mRecycleView.setLayoutParams(linearParams);
                mRecycleView.setHasFixedSize(true);
                mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                        String cid = dataBean.get(position).getGid();
                        String linkUrl=dataBean.get(position).getLinkurl();
                        String webUrl=dataBean.get(position).getWeburl();
                        if(!StringUtil.isBlank(cid)){
                            IntentUtils.intentTo(mContext,linkUrl,cid,webUrl);

                        }
                    }
                });
            } else if ("block three".equals(liststy)) {
                columns = 3;
                dataBean = data.getData();
                mRecycleView.setLayoutManager(new GridLayoutManager(mContext, columns));
                mAdapter = new MainGoodsAdapter(R.layout.main_home_goods_item, dataBean);
                mRecycleView.setAdapter(mAdapter);
                linearParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
                mRecycleView.setLayoutParams(linearParams);
                mRecycleView.setHasFixedSize(true);
                mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        String cid = dataBean.get(position).getGid();
                        String linkUrl=dataBean.get(position).getLinkurl();
                        String webUrl=dataBean.get(position).getWeburl();
                        if(!StringUtil.isBlank(cid)){
                            IntentUtils.intentTo(mContext,linkUrl,cid,webUrl);

                        }
                    }
                });
            }

        } else {
            dataBean = data.getData();
            if ("block one".equals(liststy)) {
                columns = 1;
            } else if ("block".equals(liststy)) {
                columns = 2;
            } else if ("block three".equals(liststy)) {
                columns = 3;
            }
            mRecycleView.setBackgroundColor(Color.parseColor(styleBean.getBackground()));
            mAdapter = new MainGoodsAdapter(R.layout.main_home_goods_item, dataBean);
            mRecycleView.setHasFixedSize(true);
            if (columns == 2) {
                if ("0".equals(showprice)) {
                    linearParams.height = (w_screen / 2) + 80 * 2;
                    mRecycleView.setLayoutParams(linearParams);
                } else {
                    if ("0".equals(showproductprice) && "0".equals(showsales)) {
                        linearParams.height = (w_screen / 2) + 120 * 2;
                        mRecycleView.setLayoutParams(linearParams);
                    } else {

                        linearParams.height = (w_screen / 2) + 150 * 2;
                        mRecycleView.setLayoutParams(linearParams);
                    }
                }
            } else if (columns == 3) {
                if ("0".equals(showprice)) {
                    linearParams.height = (w_screen / 3) + 80 * 2;
                    mRecycleView.setLayoutParams(linearParams);
                } else if ("0".equals(showproductprice) && "0".equals(showsales)) {
                    linearParams.height = (w_screen / 3) + 120 * 2;
                    mRecycleView.setLayoutParams(linearParams);
                } else {
                    linearParams.height = (w_screen / 3) + 150 * 2;
                    mRecycleView.setLayoutParams(linearParams);
                }
            }
            horizontalPageLayoutManager = new HorizontalPageLayoutManager(1, columns);
            //滚动adapter
            mRecycleView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            scrollHelper.setUpRecycleView(mRecycleView);
            RecyclerView.LayoutManager layoutManager = null;
            layoutManager = horizontalPageLayoutManager;
            if (layoutManager != null) {
                mRecycleView.setLayoutManager(layoutManager);
                scrollHelper.updateLayoutManger();
            }
            mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                    String cid = dataBean.get(position).getGid();
                    String linkUrl=dataBean.get(position).getLinkurl();
                    String webUrl=dataBean.get(position).getWeburl();
                    if(!StringUtil.isBlank(cid)){
                        IntentUtils.intentTo(mContext,linkUrl,cid,webUrl);

                    }
                }
            });
        }



    }

    public class MainGoodsAdapter extends BaseQuickAdapter<MainHomeGoodModel.DataBean, BaseViewHolder> {
        public MainGoodsAdapter(int layoutResId, List<MainHomeGoodModel.DataBean> data) {
            super(R.layout.main_home_goods_item, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, MainHomeGoodModel.DataBean item) {
          mImageLoader = ImageLoaderUtils.getInstance(mContext);
            RatioImageView ivPicture = helper.getView(R.id.iv_goods);//图片
            LinearLayout ll_ordprice = helper.getView(R.id.ll_ordprice);
            LinearLayout ll_ordPrice = helper.getView(R.id.ll_ordPrice);
            RelativeLayout rl_buy = helper.getView(R.id.rl_buy);
            TextView tvTitle = helper.getView(R.id.tv_title);//标题
            TextView tv_price01 = helper.getView(R.id.tv_price01);//原价名称
            TextView tv_price02 = helper.getView(R.id.tv_price02);//原价价格
            TextView tv_sales = helper.getView(R.id.tv_sales);//销量
            TextView tv_price = helper.getView(R.id.tv_price);//新价格
            BorderTextView tv_buy = helper.getView(R.id.tv_buy);//购买按钮
            if (columns == 1 || columns == 2) {
                tvTitle.setTextSize(13);
                tv_price01.setTextSize(12);
                tv_price02.setTextSize(12);
                tv_sales.setTextSize(12);
                tv_price.setTextSize(12);
                tv_buy.setTextSize(12);
            } else if (columns == 3) {
                tvTitle.setTextSize(12);
                tv_price01.setTextSize(11);
                tv_price02.setTextSize(11);
                tv_sales.setTextSize(11);
                tv_price.setTextSize(11);
                tv_buy.setTextSize(11);
            }
            if ("0".equals(showprice)) {
                ll_ordprice.setVisibility(View.GONE);
                rl_buy.setVisibility(View.GONE);
            } else {
                if ("0".equals(showproductprice) && "0".equals(showsales)) {
                    ll_ordprice.setVisibility(View.GONE);
                }
                if ("0".equals(showproductprice)) {
                    ll_ordPrice.setVisibility(View.GONE);
                }
                if ("0".equals(showsales)) {
                    tv_sales.setVisibility(View.INVISIBLE);
                }
            }
           // ImageLoader.getInstance().displayImage(item.getThumb(), ivPicture);
//            Glide.with(mContext).load(item.getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090*3/4)
//                    .crossFade().into(ivPicture);

            mImageLoader.displayImage(item.getThumb(),ivPicture);
            tvTitle.setText(item.getTitle());
            tv_price01.setText(paramsBean.getProductpricetext() + ":");
            tv_price02.setText(item.getProductprice());
            tv_price02.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tv_sales.setText(paramsBean.getSalestext() + ": " + item.getSales());
            tv_price.setText("¥ " + item.getPrice());
            tv_buy.setText(styleBean.getBuytext());
            String buystyle = styleBean.getBuystyle();
            if ("buybtn-1".equals(buystyle)) {
                tv_buy.setStrokeColor01(Color.parseColor(styleBean.getBuybtncolor()));
                tv_buy.setTextColor(Color.parseColor(styleBean.getBuybtncolor()));
                tv_buy.setContentColorResource01(Color.parseColor("#FFFFFF"));
            } else if ("buybtn-2".equals(buystyle)) {
                tv_buy.setStrokeColor01(Color.parseColor("#00000000"));
                tv_buy.setTextColor(Color.parseColor("#FFFFFF"));
                tv_buy.setContentColorResource01(Color.parseColor(styleBean.getBuybtncolor()));
            }
            tv_price.setTextColor(Color.parseColor(styleBean.getPricecolor()));
            tv_price01.setTextColor(Color.parseColor(styleBean.getProductpricecolor()));
            tv_price01.setTextColor(Color.parseColor(styleBean.getProductpricecolor()));
            tv_sales.setTextColor(Color.parseColor(styleBean.getSalescolor()));
        }
    }


    public class MainGoodsAdapter2 extends BaseQuickAdapter<MainHomeGoodModel.DataBean, BaseViewHolder> {
        public MainGoodsAdapter2(int layoutResId, List<MainHomeGoodModel.DataBean> data) {
            super(R.layout.main_home_goods_item2, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, MainHomeGoodModel.DataBean item) {
            RatioImageView ivPicture = helper.getView(R.id.iv_goods);//图片
            linearParams = (LinearLayout.LayoutParams) ivPicture.getLayoutParams();
            linearParams.width = w_screen / 3;
            ivPicture.setLayoutParams(linearParams);
            LinearLayout ll_ordprice = helper.getView(R.id.ll_ordprice);
            LinearLayout ll_ordPrice = helper.getView(R.id.ll_ordPrice);
            RelativeLayout rl_buy = helper.getView(R.id.rl_buy);
            TextView tvTitle = helper.getView(R.id.tv_title);//标题
            TextView tv_price01 = helper.getView(R.id.tv_price01);//原价名称
            TextView tv_price02 = helper.getView(R.id.tv_price02);//原价价格
            TextView tv_sales = helper.getView(R.id.tv_sales);//销量
            TextView tv_price = helper.getView(R.id.tv_price);//新价格
            BorderTextView tv_buy = helper.getView(R.id.tv_buy);//购买按钮
            if (columns == 1 || columns == 2) {
                tvTitle.setTextSize(13);
                tv_price01.setTextSize(12);
                tv_price02.setTextSize(12);
                tv_sales.setTextSize(12);
                tv_price.setTextSize(12);
                tv_buy.setTextSize(12);
            } else if (columns == 3) {
                tvTitle.setTextSize(12);
                tv_price01.setTextSize(11);
                tv_price02.setTextSize(11);
                tv_sales.setTextSize(11);
                tv_price.setTextSize(11);
                tv_buy.setTextSize(11);
            }
            if ("0".equals(showprice)) {
                ll_ordprice.setVisibility(View.GONE);
                rl_buy.setVisibility(View.GONE);
            } else {
                if ("0".equals(showproductprice) && "0".equals(showsales)) {
                    ll_ordprice.setVisibility(View.GONE);
                }
                if ("0".equals(showproductprice)) {
                    ll_ordPrice.setVisibility(View.GONE);
                }
                if ("0".equals(showsales)) {
                    tv_sales.setVisibility(View.INVISIBLE);
                }
            }
           // ImageLoader.getInstance().displayImage(item.getThumb(), ivPicture);
//            Glide.with(mContext).load(item.getThumb())
//                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                    .placeholder(R.mipmap.default_pic)
//                    .error(R.mipmap.default_pic)
//                    .centerCrop().override(1090, 1090*3/4)
//                    .crossFade().into(ivPicture);
            mImageLoader.displayImage(item.getThumb(),ivPicture);
            tvTitle.setText(item.getTitle());
            tv_price01.setText(paramsBean.getProductpricetext() + ":");
            tv_price02.setText(item.getProductprice());
            tv_price02.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            tv_sales.setText(paramsBean.getSalestext() + ": " + item.getSales());
            tv_price.setText("¥ " + item.getPrice());
            tv_buy.setText(styleBean.getBuytext());
            tvTitle.setTextColor(Color.parseColor(styleBean.getTitlecolor()));
            String buystyle = styleBean.getBuystyle();
            if ("buybtn-1".equals(buystyle)) {
                tv_buy.setStrokeColor01(Color.parseColor(styleBean.getBuybtncolor()));
                tv_buy.setTextColor(Color.parseColor(styleBean.getBuybtncolor()));
                tv_buy.setContentColorResource01(Color.parseColor("#FFFFFF"));
            } else if ("buybtn-2".equals(buystyle)) {
                tv_buy.setStrokeColor01(Color.parseColor("#00000000"));
                tv_buy.setTextColor(Color.parseColor("#FFFFFF"));
                tv_buy.setContentColorResource01(Color.parseColor(styleBean.getBuybtncolor()));
            }
            tv_price.setTextColor(Color.parseColor(styleBean.getPricecolor()));
            tv_price01.setTextColor(Color.parseColor(styleBean.getProductpricecolor()));
            tv_price01.setTextColor(Color.parseColor(styleBean.getProductpricecolor()));
            tv_sales.setTextColor(Color.parseColor(styleBean.getSalescolor()));
        }
    }
}
