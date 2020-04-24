package com.example.lla.mode.model;

import com.example.lla.common.List;

/**
 *  selectFragment에서 리사이클러뷰에 보여질 프래그먼트의 모델
 * */
public class SelectItem{
    private String title;
    private String description;
    private List.gameFragment fragmentType;

    public SelectItem(String title, List.gameFragment fragmentType, String description){
        this.title = title;
        this.description = description;
        this.fragmentType = fragmentType;
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

    public List.gameFragment getFragmentType() {
        return fragmentType;
    }

    public void setFragmentType(List.gameFragment fragmentType) {
        this.fragmentType = fragmentType;
    }
}
