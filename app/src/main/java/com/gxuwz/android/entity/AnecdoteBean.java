package com.gxuwz.android.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fulunyong on 2015/11/815:59.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class AnecdoteBean implements Parcelable {

    private String description;
    private String picUrl;
    private String title;
    private String url;

    public AnecdoteBean(){
    }



    public static final Creator<AnecdoteBean> CREATOR = new Creator<AnecdoteBean>() {
        @Override
        public AnecdoteBean createFromParcel(Parcel in) {
            return new AnecdoteBean(in);
        }

        @Override
        public AnecdoteBean[] newArray(int size) {
            return new AnecdoteBean[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AnecdoteBean{" +
                "description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


    @Override
    public int describeContents(){
        return 0;
    }

    protected AnecdoteBean(Parcel in) {
        description = in.readString();
        picUrl = in.readString();
        title = in.readString();
        url = in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(picUrl);
        dest.writeString(title);
        dest.writeString(url);
    }
}
