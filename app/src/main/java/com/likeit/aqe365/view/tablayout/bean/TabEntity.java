package com.likeit.aqe365.view.tablayout.bean;

/**
 * 描述：定义TAB 实体类
 * 作者：zhuangzeqin
 * 时间: 2016/12/30-13:51
 * 邮箱：zhuangzeqin@szxys.cn
 */
public class TabEntity implements CustomTabEntity {
    private String title;//标题
    private String selectedIcon;//选择的图片资源

    /**
     * 构造函数
     * @param title
     * @param selectedIcon
     */
    public TabEntity(String title, String selectedIcon ) {
        this.title = title;
        this.selectedIcon = selectedIcon;
    }
    //get 方法
    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public String getTabSelectedIcon() {
        return selectedIcon;
    }

}
