package com.likeits.simple.network.model.member;

public class GoodAttentionBean {
    private String url;
    private String name;
    private String newPicture;
    private String oldPicture;
    private Boolean checked;
    public boolean isChoosed;
    public GoodAttentionBean(String name, String url, String newPicture, String oldPicture, Boolean checked) {
        this.name = name;
        this.url = url;
        this.newPicture = newPicture;
        this.oldPicture = oldPicture;
        this.checked = checked;
    }
    public boolean isChoosed() {
        return isChoosed;
    }

    public void setChoosed(boolean choosed) {
        isChoosed = choosed;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewPicture() {
        return newPicture;
    }

    public void setNewPicture(String newPicture) {
        this.newPicture = newPicture;
    }

    public String getOldPicture() {
        return oldPicture;
    }

    public void setOldPicture(String oldPicture) {
        this.oldPicture = oldPicture;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }


}
