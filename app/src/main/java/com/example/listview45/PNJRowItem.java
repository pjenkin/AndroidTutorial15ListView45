package com.example.listview45;

public class PNJRowItem {

    String text;
    int imageID;

    public PNJRowItem(String text, int imageID)
    {
        this.text = text;
        this.imageID = imageID;
    }

    // NB getter, setter and constructor can all be done via Alt+Insert
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
