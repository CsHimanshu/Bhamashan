package com.hackathon.bhamashah.bean;

import com.hackathon.bhamashah.utilities.Constants;

/**
 * Created by Lincoln on 18/05/16.
 */
public class Album {
    private String name;
    private int thumbnail;
    private Constants.PAGE_TYPE page_type;

    public Album() {
    }

    public Album(String name, int thumbnail,Constants.PAGE_TYPE page_type) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.page_type=page_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Constants.PAGE_TYPE getPage_type() {
        return page_type;
    }

    public void setPage_type(Constants.PAGE_TYPE page_type) {
        this.page_type = page_type;
    }
}
