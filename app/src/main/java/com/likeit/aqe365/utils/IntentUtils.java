package com.likeit.aqe365.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.likeit.aqe365.activity.Custom.CustomActivity;
import com.likeit.aqe365.activity.MainActivity;
import com.likeit.aqe365.activity.cart.MemberCartActivity;
import com.likeit.aqe365.activity.detail.GoodDetailActivity;
import com.likeit.aqe365.activity.find.ChoicenessDiaryActivity;
import com.likeit.aqe365.activity.find.ChooseActivity;
import com.likeit.aqe365.activity.find.DiaryDetailsActivity;
import com.likeit.aqe365.activity.find.DiscussTopicActivity;
import com.likeit.aqe365.activity.find.JournalDetailsActivity;
import com.likeit.aqe365.activity.find.MoodDetailActivity;
import com.likeit.aqe365.activity.find.MoodVideoDetailsActivity;
import com.likeit.aqe365.activity.find.PostActivity;
import com.likeit.aqe365.activity.find.PostDetailsActivity;
import com.likeit.aqe365.activity.find.QuestionDoctorActivity;
import com.likeit.aqe365.activity.find.SendMoodActivity;
import com.likeit.aqe365.activity.find.SendPostActivity;
import com.likeit.aqe365.activity.find.VideoDetailsActivity;
import com.likeit.aqe365.activity.home.CategoryActivity;
import com.likeit.aqe365.activity.indent.GoodsIndentActivity;
import com.likeit.aqe365.activity.indent.IndentReturnsActivity;
import com.likeit.aqe365.activity.user.CouponActivity;
import com.likeit.aqe365.activity.user.FootprintActivity;
import com.likeit.aqe365.activity.user.GoodsAttentionActivity;
import com.likeit.aqe365.activity.user.MyCouponActivity;
import com.likeit.aqe365.activity.user.MyDirayActivity;
import com.likeit.aqe365.activity.user.MyFensiActivity;
import com.likeit.aqe365.activity.user.MyHuaTiActivity;
import com.likeit.aqe365.activity.user.MyPostMoodActivity;
import com.likeit.aqe365.activity.user.SelectAddress01Activity;
import com.likeit.aqe365.activity.web.jsinterface.JsInterfaceActivity;
import com.likeit.aqe365.activity.user.UserInfoActivity;
import com.likeit.aqe365.network.model.main.MainNavigationModel;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class IntentUtils {
    //   private static String webUrl;


    public static void intentTo(Context mContext, String linkUrl, String id, String webUrl) {
        //自定義DIY
        if ("diypage".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            Intent intent = new Intent(mContext, CustomActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //发布
        if ("discover.post".equals(linkUrl)) {
            Intent intent = new Intent(mContext, PostActivity.class);
            mContext.startActivity(intent);
        }

        //商品详情
        else if ("goods.detail".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            Intent intent = new Intent(mContext, GoodDetailActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //全部订单
        else if ("order".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 0);
            bundle.putString("flag", "0");
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //待付款
        else if ("orderstatus0".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 1);
            bundle.putString("flag", "0");
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //待发货
        else if ("orderstatus1".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 2);
            bundle.putString("flag", "0");
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //待收货
        else if ("orderstatus2".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 3);
            bundle.putString("flag", "0");
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }  //待评价
        else if ("orderstatus3".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putInt("status", 4);
            bundle.putString("flag", "0");
            Intent intent = new Intent(mContext, GoodsIndentActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //退换货
        else if ("orderstatus4".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, IndentReturnsActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //收货地址
        else if ("member.address".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, SelectAddress01Activity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //我的关注
        else if ("member.favorite".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, GoodsAttentionActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
            //分类
        } else if ("category".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, CategoryActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);

        }
        //我的足迹
        else if ("member.history".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, FootprintActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //我的优惠券
        else if ("sale.coupon.my".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, MyCouponActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //优惠券中心
        else if ("sale.coupon".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, CouponActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //我的资料
        else if ("member.info".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(mContext, UserInfoActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //会员充值
        else if ("member.recharge".equals(linkUrl)) {
        }
        //账户提现
        else if ("member.withdraw".equals(linkUrl)) {
        }
        //余额明细
        else if ("member.log".equals(linkUrl)) {
        }
        //跳转到发布页
        else if ("discover.post".equals(linkUrl)) {
            Intent intent = new Intent(mContext, PostActivity.class);
            mContext.startActivity(intent);
        }
        //发布帖子
        else if ("discover.post.diary".equals(linkUrl)) {
            Intent intent = new Intent(mContext, SendPostActivity.class);
            mContext.startActivity(intent);
        }
        //日记本列表入口
        else if ("discover.post.journal".equals(linkUrl)) {
            Intent intent = new Intent(mContext, ChooseActivity.class);
            mContext.startActivity(intent);
        }
        //发布心情
        else if ("discover.post.mood".equals(linkUrl)) {
            Intent intent = new Intent(mContext, SendMoodActivity.class);
            mContext.startActivity(intent);
        }
        //发布医生提问
        else if ("discover.post.ask".equals(linkUrl)) {
            Intent intent = new Intent(mContext, QuestionDoctorActivity.class);
            mContext.startActivity(intent);
        }

//        //话题详情+id
//        else if ("discover.diary.postlist".equals(linkUrl)) {
//            Bundle bundle = new Bundle();
//            bundle.putString("id", id);
//            Intent intent = new Intent(mContext, CustomActivity.class);
//            intent.putExtras(bundle);
//            mContext.startActivity(intent);
//        }

        //日记详情+id
        else if ("discover.journal.journaldetails".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            Intent intent = new Intent(mContext, JournalDetailsActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //我的日记本
        else if ("member.diarylist".equals(linkUrl)) {
            Intent intent = new Intent(mContext, MyDirayActivity.class);
            mContext.startActivity(intent);
        }
        //我的发布
        else if ("member.postlist".equals(linkUrl)) {
            Intent intent = new Intent(mContext, MyPostMoodActivity.class);
            mContext.startActivity(intent);
        }
        //我的话题
        else if ("member.boardlist".equals(linkUrl)) {
            Intent intent = new Intent(mContext, MyHuaTiActivity.class);
            mContext.startActivity(intent);
        }
        //我的粉丝
        else if ("member.myfans".equals(linkUrl)) {
            Intent intent = new Intent(mContext, MyFensiActivity.class);
            mContext.startActivity(intent);
        }
        //话题讨论
        else if ("goodboard".equals(linkUrl)) {
            Intent intent = new Intent(mContext, DiscussTopicActivity.class);
            mContext.startActivity(intent);
        }
        //精选日记
        else if ("gooddiary".equals(linkUrl)) {
            Intent intent = new Intent(mContext, ChoicenessDiaryActivity.class);
            mContext.startActivity(intent);
        }
        //购物车
        else if ("member_cart".equals(linkUrl)) {
            Intent intent = new Intent(mContext, MemberCartActivity.class);
            mContext.startActivity(intent);

        }

        //网页
        else if ("".equals(linkUrl)) {
            //webUrl = "http://aoquan.maimaitoo.com/app/index.php?i=1&c=entry&m=ewei_shopv2&do=mobile&r=goods.detail&id=440";
            SharedPreferencesUtils.put(mContext, "webUrl", webUrl);
            mContext.startActivity(new Intent(mContext, JsInterfaceActivity.class));
        }

    }

    /**
     * 底部导航数据
     */
    private static String[] mIconSelectIds;//标题
    private static String[] mTitles;//未选中

    private static String[] mLinkurl;
    private static String linkurl;
    private int index;

    static ArrayList<String> stringArrayList = new ArrayList<String>();
    static ArrayList<String> stringArrayList1 = new ArrayList<String>();
    static ArrayList<String> stringArrayList2 = new ArrayList<String>();

    private static void initTab(Context mContext) {
        String navtab = SharedPreferencesUtils.getString(mContext, "navtab");
        Type type = new TypeToken<List<MainNavigationModel.ItemsBean>>() {
        }.getType();
        List<MainNavigationModel.ItemsBean> items = new Gson().fromJson(navtab, type);
        for (int i = 0; i < items.size(); i++) {
            stringArrayList.add(items.get(i).getText());
            stringArrayList1.add(StringUtil.decode("\\u" + items.get(i).getIconclasscode()));
            stringArrayList2.add(items.get(i).getLinkurl());
        }
        mTitles = stringArrayList.toArray(new String[stringArrayList.size()]);
        mLinkurl = stringArrayList2.toArray(new String[stringArrayList2.size()]);
        mIconSelectIds = stringArrayList1.toArray(new String[stringArrayList1.size()]);
    }

    public static void intentTos(Context mContext, String linkUrl, String id, String webUrl, String type) {
        //帖子详情+id
        if ("discover.diary.postdetails".equals(linkUrl)) {
            if ("0".equals(type)) {
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                Intent intent = new Intent(mContext, PostDetailsActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                Intent intent = new Intent(mContext, VideoDetailsActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        }
        //心情详情+id
        else if ("discover.mood.mooddetails".equals(linkUrl)) {
            if ("0".equals(type)) {
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                Intent intent = new Intent(mContext, MoodDetailActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("id", id);
                Intent intent = new Intent(mContext, MoodVideoDetailsActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        }
    }

    public static void intentTos02(Context mContext, String linkUrl, String id, String webUrl, String memberid) {
        //日记本详情+id
        if ("discover.journal.diarydetails".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString("memberid", memberid);
            Intent intent = new Intent(mContext, DiaryDetailsActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
        //        //用户详情+id
        else if ("discover.diary.userdetails".equals(linkUrl)) {
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            Intent intent = new Intent(mContext, UserInfoActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
    }
}
