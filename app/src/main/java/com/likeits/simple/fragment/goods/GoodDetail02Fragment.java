package com.likeits.simple.fragment.goods;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.widget.TextView;

import com.likeits.simple.R;
import com.likeits.simple.base.BaseFragment;

import butterknife.BindView;
import cn.iwgang.countdownview.CountdownView;
import cn.iwgang.countdownview.DynamicConfig;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoodDetail02Fragment extends BaseFragment {
    @BindView(R.id.tv01)
    TextView tv;
    @BindView(R.id.cv_countdownView)
    CountdownView cv_countdownView;

    @Override
    protected int setContentView() {
        return R.layout.fragment_good_detail02;
    }

    @Override
    protected void lazyLoad() {
        //   String test = "前面的部分<font color='#ff0000'>关键字</font>后面的部分";
       ; String test = String.format("<font color='#8000ff'>全场满<font color='#ff0080'>¥200</font>立减<font color='#8000ff'>¥10</font></font>");
    //   ColorPicker picker = new ColorPicker(getActivity());
        DynamicConfig dynamicConfig = new DynamicConfig.Builder().setBackgroundInfo(new DynamicConfig.BackgroundInfo().setColor(Color.parseColor("#000000"))).build();
        cv_countdownView.dynamicShow(dynamicConfig);
        cv_countdownView.start(600000);


        // cv_countdownView.app.s

//        SpannableString spannableString = new SpannableString(test.toString());
//
////        for (int i = 0; i < indexList.size(); i++) {
////            WelcomeIndex index = indexList.get(i);
////
////            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#f5863e")), index.getBeforeIndex(), index.getAfterIndex(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
////        }
////        tvWelcome.setText(spannableString);
//        spannableString.setSpan(new BulletSpan(android.text.style.BulletSpan.STANDARD_GAP_WIDTH, Color.GREEN), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tv.setText(spannableString);
        tv.setText(Html.fromHtml(test));
    }

}
