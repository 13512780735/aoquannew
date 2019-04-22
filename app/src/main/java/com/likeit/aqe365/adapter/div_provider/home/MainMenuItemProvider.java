package com.likeit.aqe365.adapter.div_provider.home;


import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.adapter.BaseItemProvider;
import com.likeit.aqe365.R;
import com.likeit.aqe365.adapter.menu.MyGridViewAdapter;
import com.likeit.aqe365.adapter.menu.MyViewPagerAdapter;
import com.likeit.aqe365.network.model.home.MainHomeMenuModel;
import com.likeit.aqe365.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;


public class MainMenuItemProvider extends BaseItemProvider<MainHomeMenuModel, BaseViewHolder> {
    MainHomeMenuModel.StyleBean styleBean;
    private List<View> viewPagerList;//GridView作为一个View对象添加到ViewPager集合中
    private ImageView[] ivPoints;//圆点图片集合
    private LinearLayout group;//圆点指示
    private ViewPager viewPager;//轮播
    List<MainHomeMenuModel.DataBean> dataBeans;
    private int totalPage;
    private int mPageSize, row, rownum;

    @Override
    public int viewType() {
        return MainHomeAdapter.TYPE_MENU;
    }

    @Override
    public int layout() {
        return R.layout.main_home_menu;
    }

    @Override
    public void convert(BaseViewHolder helper, MainHomeMenuModel data, int position) {
        viewPager = helper.getView(R.id.viewpager);
        group = helper.getView(R.id.points);
        RelativeLayout rlMenuBg = helper.getView(R.id.rl_menu_bg);
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) rlMenuBg.getLayoutParams();
        styleBean = data.getStyle();
        dataBeans = data.getData();
        row = Integer.valueOf(styleBean.getRow());
        rownum = Integer.valueOf(styleBean.getRownum());
        if ("1".equals(styleBean.getShowtype())) {
            if (row == 1) {
                if (rownum == 3) {
                    mPageSize = 3;
                    if (dataBeans.size() == 3) {
                        //group.setVisibility(View.GONE);
                    }
                } else if (rownum == 4) {
                    mPageSize = 4;
                    if (dataBeans.size() == 4) {
                        // group.setVisibility(View.GONE);
                    }
                } else if (rownum == 5) {
                    mPageSize = 5;
                    if (dataBeans.size() == 5) {
                        //group.setVisibility(View.GONE);
                    }
                }
                linearParams.height = (120 * 1 + 20) * 2;
                rlMenuBg.setLayoutParams(linearParams);
            } else {
                mPageSize = row * rownum;
                linearParams.height = (120 * 2 + 20) * 2;
                rlMenuBg.setLayoutParams(linearParams);
            }
        } else {
            mPageSize = data.getData().size();
            if (rownum == 3) {
                if (mPageSize % 3 > 0) {
                    // linearParams.height = 60*(Integer.valueOf(mPageSize/3)+1)+14;
                    linearParams.height = (120 * (Integer.valueOf(mPageSize / 3 + 1)) + 20) * 2;
                    rlMenuBg.setLayoutParams(linearParams);
                } else {
                    linearParams.height = (120 * (Integer.valueOf(mPageSize / 3)) + 20) * 2;
                    rlMenuBg.setLayoutParams(linearParams);
                }
            } else if (rownum == 4) {
                if (mPageSize % 4 > 0) {
                    // linearParams.height = 60*(Integer.valueOf(mPageSize/3)+1)+14;
                    linearParams.height = (120 * (Integer.valueOf(mPageSize / 4 + 1)) + 20) * 2;
                    rlMenuBg.setLayoutParams(linearParams);
                } else {
                    linearParams.height = (120 * (Integer.valueOf(mPageSize / 4)) + 20) * 2;
                    rlMenuBg.setLayoutParams(linearParams);
                }
            } else if (rownum == 5) {
                if (mPageSize % 5 > 0) {
                    // linearParams.height = 60*(Integer.valueOf(mPageSize/3)+1)+14;
                    linearParams.height = (120 * (Integer.valueOf(mPageSize / 5 + 1)) + 20) * 2;
                    rlMenuBg.setLayoutParams(linearParams);
                } else {
                    linearParams.height = (120 * (Integer.valueOf(mPageSize / 5)) + 20) * 2;
                    rlMenuBg.setLayoutParams(linearParams);
                }
            }

        }

        rlMenuBg.setBackgroundColor(Color.parseColor(styleBean.getBackground()));

        initData();
    }

    private void initData() {

        totalPage = (int) Math.ceil(dataBeans.size() * 1.0 / mPageSize);
        viewPagerList = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            //每个页面都是inflate出一个新实例
            final GridView gridView = (GridView) View.inflate(mContext, R.layout.menu_viewpager_page, null);
            gridView.setNumColumns(rownum);
            gridView.setAdapter(new MyGridViewAdapter(mContext, dataBeans, i, mPageSize));
            //添加item点击监听
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Object obj = gridView.getItemAtPosition(position);
                    if (obj != null && obj instanceof MainHomeMenuModel.DataBean) {
                        System.out.println(obj);
                        String id = ((MainHomeMenuModel.DataBean) obj).getParams().getId();
                        String linkUrl = ((MainHomeMenuModel.DataBean) obj).getLinkurl();
                        String webUrl = ((MainHomeMenuModel.DataBean) obj).getWeburl();
                        IntentUtils.intentTo(mContext, linkUrl, id, webUrl);
                        //Toast.makeText(mContext, ((MainHomeMenuModel.DataBean) obj).getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            //每一个GridView作为一个View对象添加到ViewPager集合中
            viewPagerList.add(gridView);
        }
        //设置ViewPager适配器


        //添加小圆点
        //  ivPoints = new ImageView[totalPage];

        // ivPoints.

        if (group != null) {
            group.removeAllViews();
        }
        ivPoints = new ImageView[totalPage];
        for (int i = 0; i < totalPage; i++) {
            //循坏加入点点图片组
            if (totalPage == 1) {
                group.setVisibility(View.GONE);
            }
            ivPoints[i] = new ImageView(mContext);
            if (i == 0) {
                ivPoints[i].setImageResource(R.drawable.indicator_red);
            } else {
                ivPoints[i].setImageResource(R.drawable.indicator_gray);
            }
            ivPoints[i].setPadding(8, 8, 8, 8);

            group.addView(ivPoints[i]);
        }

        viewPager.setAdapter(new MyViewPagerAdapter(viewPagerList));
        //设置ViewPager的滑动监听，主要是设置点点的背景颜色的改变
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < totalPage; i++) {
                    if (i == position) {
                        ivPoints[i].setImageResource(R.drawable.indicator_red);
                    } else {
                        ivPoints[i].setImageResource(R.drawable.indicator_gray);
                    }
                }
            }
        });
    }


    @Override
    public void onClick(BaseViewHolder helper, MainHomeMenuModel data, int position) {
        //单击事件
        //Toast.makeText(mContext, "Click: " + data.imgUrl, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, MainHomeMenuModel data, int position) {
        //长按事件
        // Toast.makeText(mContext, "longClick: " + data.imgUrl, Toast.LENGTH_SHORT).show();
        return true;
    }

}
