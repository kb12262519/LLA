package com.example.lla.mode.model;

/**
 *  selectFragment에서 리사이클러뷰에 보여질 프래그먼트의 모델
 * */
public class SelectItem{
    private String title;
    private String description;

    public SelectItem(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
