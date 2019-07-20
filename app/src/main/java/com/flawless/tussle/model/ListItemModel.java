package com.flawless.tussle.model;

public class ListItemModel {

    private String title;
    private String subTitle;

    public ListItemModel(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public ListItemModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
