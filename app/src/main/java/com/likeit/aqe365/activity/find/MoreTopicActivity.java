package com.likeit.aqe365.activity.find;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.likeit.aqe365.R;
import com.likeit.aqe365.base.BaseActivity;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutAdapter;
import com.likeit.aqe365.view.cyflowlayoutlibrary.FlowLayoutScrollView;

import java.util.ArrayList;
import java.util.List;

public class MoreTopicActivity extends BaseActivity {

    private List<String> list;
    private FlowLayoutAdapter<String> flowLayoutAdapter;
    private List<String> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_topic);
        list = new ArrayList<>();
        list1 = getIntent().getStringArrayListExtra("list");
        list = list1;
        initUI();
    }

    private void initUI() {
        setBackView();
        setTitle("话题");
        setRightText("确认", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                list.add(0, "+自定义话题");
                intent.putStringArrayListExtra("list", (ArrayList<String>) list);
                setResult(101,intent);
                finish();
            }
        });
        /**
         * 话题数据
         */
        flowLayoutAdapter = new FlowLayoutAdapter<String>(list) {
            @Override
            public void bindDataToView(ViewHolder holder, int position, String bean) {

                holder.setText(R.id.tv, bean);


            }

            @Override
            public void onItemClick(int position, String bean) {
                remove(position);
            }

            @Override
            public int getItemLayoutID(int position, String bean) {
                return R.layout.item_layout;
            }
        };
        ((FlowLayoutScrollView) findViewById(R.id.flsv)).setAdapter(flowLayoutAdapter);
    }
}
