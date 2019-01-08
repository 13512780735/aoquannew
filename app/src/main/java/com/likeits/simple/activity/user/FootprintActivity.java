package com.likeits.simple.activity.user;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.likeits.simple.R;
import com.likeits.simple.base.BaseActivity;
import com.likeits.simple.network.model.member.FootprintBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class FootprintActivity extends BaseActivity {

    @BindView(R.id.back_view)
    LinearLayout mBackView;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.toolbar_righ_tv)
    TextView mToolbarRighTv;
    @BindView(R.id.right_view)
    LinearLayout mRightView;
    @BindView(R.id.titleBar)
    RelativeLayout mTitleBar;
    @BindView(R.id.lv_data)
    ListView lv_data;
    @BindView(R.id.che_all)
    CheckBox che_all;
    @BindView(R.id.btn_delete)
    Button btn_delete;
    @BindView(R.id.rl_bottom)
    RelativeLayout mRlBottom;
    //定义控件
    //声明一个集合（数据源）
    private List<FootprintBean> data;
    //定义自定义适配器
    private FootprintAdapter mAdapter;
    boolean flag;
    private ArrayList<CheckBox> checkBoxList;

    //给数据源添加数据
    private void initdata() {
        data = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            data.add(new FootprintBean("氢氧化钙" + i, "http://hidsy.maimaitoo.com/attachment/images/1/2018/08/CK9x9YUFXeUf2eTO4KT48b4C5zaLt4.jpg", "2017-10-11 16:11" + i, "澳泉医销网" + i, "100" + i, "100" + i, false));
        }
    }

    //返回数据给MyAdapter使用
    public List<FootprintBean> getData() {
        return this.data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footprint);
        //初始化数据源
        initdata();
        //实例化自定义适配器，把listview传到自定义适配器中
        mAdapter = new FootprintAdapter(this, lv_data);
        checkBoxList = new ArrayList<CheckBox>();
        //绑定适配器
        lv_data.setAdapter(mAdapter);
        //初始化事件监听
        initUI();
        initlistener();
    }

    private void initUI() {
        mTitle.setText("我的足迹");
        mToolbarRighTv.setText("编辑");
        mRlBottom.setVisibility(View.GONE);
    }

    private void initlistener() {
        /**
         * 全选复选框设置事件监听
         */
        che_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (data.size() != 0) {//判断列表中是否有数据
                    if (isChecked) {
                        for (int i = 0; i < data.size(); i++) {
                            data.get(i).setChecked(true);
                        }
                        //通知适配器更新UI
                        mAdapter.notifyDataSetChanged();
                    } else {
                        for (int i = 0; i < data.size(); i++) {
                            data.get(i).setChecked(false);
                        }
                        //通知适配器更新UI
                        mAdapter.notifyDataSetChanged();
                    }
                } else {//若列表中没有数据则隐藏全选复选框
                    che_all.setVisibility(View.GONE);
                }
            }
        });
        //删除按钮点击事件
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建一个要删除内容的集合，不能直接在数据源data集合中直接进行操作，否则会报异常
                List<FootprintBean> deleSelect = new ArrayList<FootprintBean>();

                //把选中的条目要删除的条目放在deleSelect这个集合中
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getChecked()) {
                        deleSelect.add(data.get(i));
                    }
                }
                //判断用户是否选中要删除的数据及是否有数据
                if (deleSelect.size() != 0 && data.size() != 0) {
                    //从数据源data中删除数据
                    data.removeAll(deleSelect);
                    //把deleSelect集合中的数据清空
                    deleSelect.clear();
                    //把全选复选框设置为false
                    che_all.setChecked(false);
                    //通知适配器更新UI
                    mAdapter.notifyDataSetChanged();
                } else if (data.size() == 0) {
                    Toast.makeText(FootprintActivity.this, "没有要删除的数据", Toast.LENGTH_SHORT).show();
                } else if (deleSelect.size() == 0) {
                    Toast.makeText(FootprintActivity.this, "请选中要删除的数据", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick({R.id.back_view, R.id.right_view})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back_view:
                onBackPressed();
                break;
            case R.id.right_view:
                flag = !flag;
                if (flag) {
                    mToolbarRighTv.setText("完成");
                    mRlBottom.setVisibility(View.VISIBLE);
                    //shoppingCartAdapter.isShow(false);
                    for (int i = 0; i < checkBoxList.size(); i++) {
                        checkBoxList.get(i).setVisibility(View.VISIBLE);
                    }
                } else {
                    mToolbarRighTv.setText("编辑");
                    mRlBottom.setVisibility(View.GONE);
                    for (int i = 0; i < checkBoxList.size(); i++) {
                        checkBoxList.get(i).setVisibility(View.GONE);
                    }
                }

                break;
        }
    }

    class FootprintAdapter extends BaseAdapter {
        private ListView lv_data;
        //定义一个数据源的引用
        private List<FootprintBean> data;
        private Context context;

        public FootprintAdapter(Context context, ListView lv_data) {
            if (context instanceof FootprintActivity) {
                this.context = context;
                this.lv_data = lv_data;
                data = ((FootprintActivity) this.context).getData();
            }
        }

        /**
         * 获取当前子view的id（就是listview中的每一个条目的位置）
         *
         * @param position
         * @return 返回当前id
         */
        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * 获取当前子view对应的值
         *
         * @param position 当前子view（条目）的id（位置）
         * @return 返回当前对应的值 该值为object类型
         */
        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        /**
         * 定义coverView的Recyler(缓存)，该类名自定义的
         */
        class ViewHodler {
            ImageView ivPicture;
            TextView tvName;
            TextView tvTime;
            TextView tvCompany;
            TextView tvNewPrice;
            TextView tvOldPrice;
            CheckBox ch_delete;
        }

        /**
         * 核心代码
         *
         * @param position    当前子view的id
         * @param convertView 缓存布局（该view与子view保持一致）
         * @param parent      父容器（即当前listview）
         * @return 返回当前子view（包含布局及具体的数据）
         */
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            //布局生成器(抽象类)
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            //声明缓存
            ViewHodler viewHodler = null;
            //重新创建布局及缓存
            if (convertView == null) {
                //创建缓存布局
                convertView = layoutInflater.inflate(R.layout.layout_footprint_items, parent, false);
                //产生缓存
                viewHodler = new ViewHodler();
                viewHodler.ivPicture = (ImageView) convertView.findViewById(R.id.tv_goods_picture);
                viewHodler.tvName = (TextView) convertView.findViewById(R.id.tv_name);
                viewHodler.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
                viewHodler.tvCompany = (TextView) convertView.findViewById(R.id.tv_company);
                viewHodler.tvNewPrice = (TextView) convertView.findViewById(R.id.tv_goods_new_price);
                viewHodler.tvOldPrice = (TextView) convertView.findViewById(R.id.tv_goods_old_price);
                viewHodler.ch_delete = (CheckBox) convertView.findViewById(R.id.ch_delete);
                //把缓存的布局放在converview中，避免重复获取布局，提升效率
                checkBoxList.add(viewHodler.ch_delete);
                convertView.setTag(viewHodler);
            } else {
                //使用缓存的中的布局
                viewHodler = (ViewHodler) convertView.getTag();
            }
            //为缓存的布局ViewHodler控件设置新的数据
            final FootprintBean currItem = data.get(position);
            ImageLoader.getInstance().displayImage(currItem.getUrl(), viewHodler.ivPicture);
            viewHodler.tvName.setText(currItem.getName());
            viewHodler.tvTime.setText(currItem.getTime());
            viewHodler.tvCompany.setText(currItem.getCompany());
            viewHodler.tvNewPrice.setText("¥ " + currItem.getNewPicture());
            viewHodler.tvOldPrice.setText("¥ " + currItem.getOldPicture());
            viewHodler.tvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
            viewHodler.ch_delete.setChecked(currItem.getChecked());
            viewHodler.ch_delete.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //   currItem.setChoosed(((CheckBox) v).isChecked());
                            currItem.setChecked(((CheckBox) v).isChecked());
                        }
                    }
            );
            //listView单个条目事件监听
            lv_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    data.get(position).setChecked(true);
                    notifyDataSetChanged();
                }
            });
            //返回多次生成的子View给适配器
            return convertView;
        }

        /**
         * 获取数据中要在listview中显示的条目
         *
         * @return 返回数据的条目
         */
        @Override
        public int getCount() {
            return this.data != null ? this.data.size() : 0;
        }
    }
}