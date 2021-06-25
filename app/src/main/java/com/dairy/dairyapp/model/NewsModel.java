package com.dairy.dairyapp.model;

public class NewsModel {
    String mTitle;
    int mImage;

    public NewsModel(String mTitle, int mImage) {
        this.mTitle = mTitle;
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
}
