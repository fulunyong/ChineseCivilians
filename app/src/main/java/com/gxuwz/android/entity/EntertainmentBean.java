package com.gxuwz.android.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fulunyong on 2015/11/721:24.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class EntertainmentBean implements Parcelable {
    private String description;
    private String picUrl;
    private String time;
    private String title;
    private String url;

    public EntertainmentBean() {
    }

    public EntertainmentBean(String description, String picUrl, String time, String title,
                             String url) {
        this.description = description;
        this.picUrl = picUrl;
        this.time = time;
        this.title = title;
        this.url = url;
    }


    protected EntertainmentBean(Parcel in) {
        description = in.readString();
        picUrl = in.readString();
        time = in.readString();
        title = in.readString();
         url = in.readString();
    }



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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
        return "EntertainmentBean{" +
                "description='" + description + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }



    public static final Creator<EntertainmentBean> CREATOR = new Creator<EntertainmentBean>() {
        @Override
        public EntertainmentBean createFromParcel(Parcel in) {
            return new EntertainmentBean(in);
        }

        @Override
        public EntertainmentBean[] newArray(int size) {
            return new EntertainmentBean[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(picUrl);
        dest.writeString(time);
        dest.writeString(title);
        dest.writeString(url);
    }
}
