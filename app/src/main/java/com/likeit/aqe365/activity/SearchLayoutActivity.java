package com.likeit.aqe365.activity;

import android.os.Bundle;

import com.likeit.aqe365.R;
import com.likeit.aqe365.activity.good.GoodListActivity;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.utils.SharedPreferencesUtil;
import com.likeit.aqe365.view.searchview.EditText_Clear;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class SearchLayoutActivity extends BaseActivity {
    @BindView(R.id.et_search)
    EditText_Clear et_search;
    @BindView(R.id.rl_clear)
    RelativeLayout rl_clear;
    @BindView(R.id.flowlayout_history)
    TagFlowLayout flowlayoutHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_layout);
//        String testData = "";
//        SharedPreferencesUtil.putString(this, "search_history", testData);
        initUI();
        initHistory();
    }

    private void initUI() {
        /**
         * 监听输入键盘更换后的搜索按键
         * 调用时刻：点击键盘上的搜索键时
         */
        et_search.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {

                    String inputSearch = et_search.getText().toString().trim();
                    if (TextUtils.isEmpty(inputSearch)) {
                        showToast("请输入搜索的商品");
                        return true;
                    }
                    writeHistory(inputSearch);
                    initHistory();
                    Bundle bundle = new Bundle();
                    bundle.putString("keyword", inputSearch);
                    toActivity(GoodListActivity.class, bundle);
                }
                return false;
            }
        });

    }


    /**
     * 初始化历史记录
     */
    private void initHistory() {
        final List<String> readHistory = readHistory();
        if (readHistory != null && readHistory.size() > 0) {
            rl_clear.setVisibility(View.VISIBLE);
        } else {
            rl_clear.setVisibility(View.GONE);
        }

        //为FlowLayout填充数据
        flowlayoutHistory.setAdapter(new TagAdapter(readHistory) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {

                TextView view = (TextView) View.inflate(mContext, R.layout.flowlayout_textview, null);
                view.setText(readHistory.get(position));
                return view;
            }
        });

        //为FlowLayout的标签设置监听事件
        flowlayoutHistory.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                //  ToastUtil.makeText(mContext, readHistory.get(position));
                et_search.setText(readHistory.get(position));
                et_search.setSelection(readHistory.get(position).length());
                Bundle bundle = new Bundle();
                bundle.putString("keyword", readHistory.get(position));
                toActivity(GoodListActivity.class, bundle);
                return true;
            }
        });
    }

    /**
     * 从SP中读取历史记录
     */
    private List<String> readHistory() {
        List<String> readHistoryList = new ArrayList<>();
        String search_history = SharedPreferencesUtil.getString(mContext, "search_history", null);

        //将String转为List
        if (!TextUtils.isEmpty(search_history)) {
            String[] strs = search_history.split("wy");
            for (int i = 0; i < strs.length; i++) {
                readHistoryList.add(i, strs[i]);
            }
        }

        return readHistoryList;
    }


    /**
     * 将历史记录写入到SP中
     */
    private void writeHistory(String write) {
        if (TextUtils.isEmpty(write)) {
            return;
        }

        String writeHistory = "";
        //获取历史记录
        List<String> readHistoryList = readHistory();

        //如果不重复，则添加为第一个历史记录；
        //如果重复，则删除已有，再添加为第一个历史记录；
        for (int i = 0; i < readHistoryList.size(); i++) {
            boolean hasWrite = readHistoryList.get(i).equals(write);
            if (hasWrite) {
                readHistoryList.remove(i);
                break;
            }
        }
        readHistoryList.add(0, write);

        //历史记录最多为10个
        if (readHistoryList.size() > 10) {
            readHistoryList = readHistoryList.subList(0, 10);
        }

        //将ArrayList转为String
        for (int i = 0; i < readHistoryList.size(); i++) {
            writeHistory += readHistoryList.get(i) + "wy";
        }
        SharedPreferencesUtil.putString(mContext, "search_history", writeHistory);
    }

    @OnClick({R.id.tv_back, R.id.tv_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_clear:
                SharedPreferencesUtil.putString(mContext, "search_history", "");
                initHistory();
                break;
        }
    }
}
