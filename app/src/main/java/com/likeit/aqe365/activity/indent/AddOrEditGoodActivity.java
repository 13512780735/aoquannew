package com.likeit.aqe365.activity.indent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.Indent.GoodsRefundmodel;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddOrEditGoodActivity extends BaseActivity {
    @BindView(R.id.lv_data)
    ListView lv_data;
    @BindView(R.id.che_all)
    CheckBox che_all;
    @BindView(R.id.btn_delete)
    Button btn_delete;
    @BindView(R.id.rl_bottom)
    RelativeLayout mRlBottom;
    // private GoodsRefundmodel goodsRefundmodel;

    //定义控件
    //声明一个集合（数据源）
    private List<GoodsRefundmodel.GoodslistBean> goodslist;
    //定义自定义适配器
    private EditGoodAdapter mAdapter;
    boolean flag;
    private ArrayList<CheckBox> checkBoxList;
    private List<GoodsRefundmodel.GoodsBean> goodsBeans;


    //返回数据给MyAdapter使用
    public List<GoodsRefundmodel.GoodslistBean> getData() {
        return this.data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_good);
        setTitle("添加和编辑售后商品");
        setBackView();
        goodslist = getIntent().getExtras().getParcelableArrayList("goodslist");
        goodsBeans = getIntent().getExtras().getParcelableArrayList("goodsBeans");
        getdata1();
        for (int i = 0; i < goodsBeans.size(); i++) {
            XLog.e("data33:" + goodsBeans.get(i).getGoodsid());
        }
        for (int i = 0; i < goodslist.size(); i++) {
            XLog.e("data44:" + goodslist.get(i).getGoodsid());
        }
        //  initdata();
        //实例化自定义适配器，把listview传到自定义适配器中
        mAdapter = new EditGoodAdapter(this, lv_data);
        checkBoxList = new ArrayList<CheckBox>();
        //绑定适配器
        lv_data.setAdapter(mAdapter);
        //初始化事件监听
        initUI();
        initlistener();
    }

    List<GoodsRefundmodel.GoodslistBean> data;

    private void getdata1() {
        data = new ArrayList<>();
        for (int j = 0; j < goodsBeans.size(); j++) {
            for (int i = 0; i < goodslist.size(); i++) {
                if (goodsBeans.get(j).getGoodsid().equals(goodslist.get(i).getGoodsid())) {
                    goodslist.get(i).setChecked(true);
                }

            }

        }
        data = goodslist;
        for (int i = 0; i < data.size(); i++) {
            XLog.e("data55:" + data.get(i).getChecked());
        }
    }

    private void initUI() {
        if(goodslist.size()==goodsBeans.size()){
            che_all.setChecked(true);
        }
        //  mRlBottom.setVisibility(View.GONE);
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
        //確定按钮点击事件
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建一个要删除内容的集合，不能直接在数据源data集合中直接进行操作，否则会报异常
                List<GoodsRefundmodel.GoodslistBean> deleSelect = new ArrayList<GoodsRefundmodel.GoodslistBean>();

                //把选中的条目要删除的条目放在deleSelect这个集合中
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getChecked()) {
                        deleSelect.add(data.get(i));
                    }
                }
                //判断用户是否选中要删除的数据及是否有数据
                if (deleSelect.size() != 0 && data.size() != 0) {

                    List<GoodsRefundmodel.GoodsBean> goodsBeans = new ArrayList<>();
                    GoodsRefundmodel.GoodsBean goodsBean;
                    for (int i = 0; i < deleSelect.size(); i++) {
                        goodsBean = new GoodsRefundmodel.GoodsBean();
                        goodsBean.setGoodsid(deleSelect.get(i).getGoodsid());
                        goodsBean.setOptionid(deleSelect.get(i).getOptionid());
                        goodsBean.setOptiontitle(deleSelect.get(i).getOptiontitle());
                        goodsBean.setRealprice(deleSelect.get(i).getRealprice());
                        goodsBean.setThumb(deleSelect.get(i).getThumb());
                        goodsBean.setTitle(deleSelect.get(i).getTitle());
                        goodsBeans.add(goodsBean);
                    }
                    XLog.e("check01:" + deleSelect.get(0).getGoodsid());
                    XLog.e("check02:" + deleSelect.size());
                    XLog.e("check02:" + data.size());


                    Intent intent = getIntent();
                    Bundle bundle = intent.getExtras();
                    bundle.putParcelableArrayList("goodBeans", (ArrayList<? extends Parcelable>) goodsBeans);//添加要返回给页面1的数据
                    intent.putExtras(bundle);
                    setResult(Activity.RESULT_OK, intent);//返回页面1
                    finish();
                    //从数据源data中删除数据
                    // data.removeAll(deleSelect);
                    //把deleSelect集合中的数据清空
                    //    deleSelect.clear();
                    //把全选复选框设置为false
                    //  che_all.setChecked(false);
                    //通知适配器更新UI
                    //    mAdapter.notifyDataSetChanged();
                } else if (data.size() == 0) {
                    Toast.makeText(mContext, "没有选中商品", Toast.LENGTH_SHORT).show();
                } else if (deleSelect.size() == 0) {
                    Toast.makeText(mContext, "请选中要选中的商品", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    class EditGoodAdapter extends BaseAdapter {
        private ListView lv_data;
        //定义一个数据源的引用
        private List<GoodsRefundmodel.GoodslistBean> data;
        private Context context;

        public EditGoodAdapter(Context context, ListView lv_data) {
            if (context instanceof AddOrEditGoodActivity) {
                this.context = context;
                this.lv_data = lv_data;
                data = ((AddOrEditGoodActivity) this.context).getData();
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
            TextView tv_type;
            TextView tvNewPrice;
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
                convertView = layoutInflater.inflate(R.layout.layout_editgood_items, parent, false);
                //产生缓存
                viewHodler = new ViewHodler();
                viewHodler.ivPicture = (ImageView) convertView.findViewById(R.id.tv_goods_picture);
                viewHodler.tvName = (TextView) convertView.findViewById(R.id.tv_name);
                viewHodler.tv_type = (TextView) convertView.findViewById(R.id.tv_type);
                viewHodler.tvNewPrice = (TextView) convertView.findViewById(R.id.tv_goods_new_price);
                viewHodler.ch_delete = (CheckBox) convertView.findViewById(R.id.ch_delete);
                //把缓存的布局放在converview中，避免重复获取布局，提升效率
                //  checkBoxList.add(viewHodler.ch_delete);
                convertView.setTag(viewHodler);
            } else {
                //使用缓存的中的布局
                viewHodler = (ViewHodler) convertView.getTag();
            }
            //为缓存的布局ViewHodler控件设置新的数据
            final GoodsRefundmodel.GoodslistBean currItem = data.get(position);
            ImageLoader.getInstance().displayImage(currItem.getThumb(), viewHodler.ivPicture);
            viewHodler.tvName.setText(currItem.getTitle());
            viewHodler.tv_type.setText(currItem.getOptiontitle());
            viewHodler.tvNewPrice.setText("¥ " + currItem.getRealprice());
            XLog.e("check:" + currItem.getChecked());
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
