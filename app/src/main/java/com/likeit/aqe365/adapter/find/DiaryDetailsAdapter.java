package com.likeit.aqe365.adapter.find;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.likeit.aqe365.R;
import com.likeit.aqe365.network.model.find.DiarydetailsModel;
import com.likeit.aqe365.utils.SharedPreferencesUtils;
import com.likeit.aqe365.view.IconfontTextView;
import com.likeit.aqe365.view.NineGridTestLayout;

import java.util.List;


public class DiaryDetailsAdapter extends BaseQuickAdapter<DiarydetailsModel.JournalBean, BaseViewHolder> {
    private NineGridTestLayout layout;
    private IconfontTextView tv_isgood;

    public DiaryDetailsAdapter(int layoutResId, List<DiarydetailsModel.JournalBean> data) {
        super(R.layout.diary_deatils_items, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final DiarydetailsModel.JournalBean item) {
        final String diaryid = SharedPreferencesUtils.getString(mContext, "diaryId");
        tv_isgood = helper.getView(R.id.iv_isgood);
        helper.setText(R.id.tv_time, item.getDay());
        helper.setText(R.id.tv_num, item.getNum());
        //helper.setText(R.id.tv_isgood, mContext.getResources().getString(R.string.ic_isgood) + item.getLikenum());

        if ("1".equals(item.getIslike())) {
            tv_isgood.setText(mContext.getResources().getString(R.string.ic_good) + "  " + item.getLikenum());
            tv_isgood.setTextColor(Color.parseColor("#ff424d"));
            tv_isgood.setClickable(false);
        } else {
            tv_isgood.setText(mContext.getResources().getString(R.string.ic_isgood) + "  " + item.getLikenum());
            tv_isgood.setTextColor(Color.parseColor("#cccccc"));
            tv_isgood.setClickable(true);
        }

        helper.setText(R.id.tv_content, item.getContent());
        layout = helper.getView(R.id.layout_nine_grid);
        layout.setIsShowAll(item.isShowAll);
        layout.setUrlList(item.images);
        helper.addOnClickListener(R.id.iv_isgood);
//        tv_isgood.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tv_isgood.setText(mContext.getResources().getString(R.string.ic_good) + "  " + (Integer.valueOf(item.getLikenum()) + 1));
//                tv_isgood.setTextColor(Color.parseColor("#ff424d"));
//                /**
//                 * 点赞
//                 */
//                String diaryid = item.getId();//帖子id
//                String cid = "";//
//                toLike(diaryid, cid);
//            }
//        });


    }


}
