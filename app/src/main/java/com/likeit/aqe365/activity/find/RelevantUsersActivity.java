package com.likeit.aqe365.activity.find;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.elvishew.xlog.XLog;
import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.user.FootprintActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.network.model.BaseResponse;
import com.likeit.aqe365.network.model.find.ConcernsListModel;
import com.likeit.aqe365.network.model.member.FootprintBean;
import com.likeit.aqe365.network.util.RetrofitUtil;
import com.likeit.aqe365.utils.LoaddingDialog;
import com.likeit.aqe365.view.CircleImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Subscriber;

/**
 * 关联用户
 */
public class RelevantUsersActivity extends BaseActivity {
    @BindView(R.id.lv_data)
    ListView lv_data;
    private List<ConcernsListModel.ListBean> data;
    private ArrayList<CheckBox> checkBoxList;
    private RelevantUsersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relevant_users);
        data = new ArrayList<>();
        checkBoxList = new ArrayList<>();
        initData();
        //绑定适配器
//        mAdapter = new RelevantUsersAdapter(RelevantUsersActivity.this, lv_data, data);
//        lv_data.setAdapter(mAdapter);
//        mAdapter.notifyDataSetChanged();
        initUI();

    }

    private void initData() {
        LoaddingShow();

        RetrofitUtil.getInstance().concernslist(openid, new Subscriber<BaseResponse<ConcernsListModel>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse<ConcernsListModel> baseResponse) {
                LoaddingDismiss();
                XLog.e("data:" + baseResponse.getData().getList());
                if (baseResponse.getCode() == 200) {
                    ConcernsListModel concernsListModel = baseResponse.getData();
                    data = concernsListModel.getList();
                    mAdapter = new RelevantUsersAdapter(RelevantUsersActivity.this, lv_data, data);
                    lv_data.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    XLog.e("data4:" + data);
                } else {
                    showToast(baseResponse.getMsg());
                }
            }
        });
    }

    private void initUI() {

        setBackView();
        setTitle("提醒谁看");
        setRightText("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<ConcernsListModel.ListBean> deleSelect = new ArrayList<ConcernsListModel.ListBean>();

                //把选中的条目要删除的条目放在deleSelect这个集合中
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getChecked()) {
                        deleSelect.add(data.get(i));
                    }
                }
                if (deleSelect.size() != 0 && data.size() != 0) {
                    //从数据源data中删除数据
                    //把deleSelect集合中的数据清空
                    //把全选复选框设置为false
                    //通知适配器更新UI
                    XLog.e("dataSS"+deleSelect);
//                    Intent intent = new Intent();
//                    Bundle bundle = new Bundle();
//                    bundle.putSerializable("data", databaseList());
//                    intent.putExtras(bundle);
//                    setResult(102, intent);
//                    finish();
                }
            }
        });

    }

    public class RelevantUsersAdapter extends BaseAdapter {
        private ListView lv_data;
        //定义一个数据源的引用
        private List<ConcernsListModel.ListBean> data;
        private Context context;

        public RelevantUsersAdapter(Context context, ListView lv_data, List<ConcernsListModel.ListBean> data) {
            if (context instanceof RelevantUsersActivity) {
                this.context = context;
                this.lv_data = lv_data;
                this.data = data;
            }
            XLog.e("data2" + this.data);
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
            CircleImageView ivPicture;
            TextView tvName;
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
                convertView = layoutInflater.inflate(R.layout.relevant_user_items, parent, false);
                //产生缓存
                viewHodler = new ViewHodler();
                viewHodler.ivPicture = convertView.findViewById(R.id.tv_goods_picture);
                viewHodler.tvName = convertView.findViewById(R.id.tv_name);
                viewHodler.ch_delete = convertView.findViewById(R.id.ch_delete);
                //把缓存的布局放在converview中，避免重复获取布局，提升效率
                checkBoxList.add(viewHodler.ch_delete);
                convertView.setTag(viewHodler);
            } else {
                //使用缓存的中的布局
                viewHodler = (ViewHodler) convertView.getTag();
            }
            //为缓存的布局ViewHodler控件设置新的数据
            final ConcernsListModel.ListBean currItem = data.get(position);
            ImageLoader.getInstance().displayImage(currItem.getAvatar(), viewHodler.ivPicture);
            viewHodler.tvName.setText(currItem.getNickname());
         //   viewHodler.ch_delete.setChecked(currItem.getChecked());
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
