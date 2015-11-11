package com.gxuwz.android.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fulunyong on 2015/11/921:44.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class JokeRouteImageBean implements Parcelable{
    private String height;
    private String sourceurl;
    private String title;
    private String url;
    private String width;

    public JokeRouteImageBean() {
    }

    public JokeRouteImageBean(String height, String sourceurl, String title, String url, String width) {
        this.height = height;
        this.sourceurl = sourceurl;
        this.title = title;
        this.url = url;
        this.width = width;
    }

    protected JokeRouteImageBean(Parcel in) {
        height = in.readString();
        sourceurl = in.readString();
        title = in.readString();
        url = in.readString();
        width = in.readString();
    }

    public static final Creator<JokeRouteImageBean> CREATOR = new Creator<JokeRouteImageBean>() {
        @Override
        public JokeRouteImageBean createFromParcel(Parcel in) {
            return new JokeRouteImageBean(in);
        }

        @Override
        public JokeRouteImageBean[] newArray(int size) {
            return new JokeRouteImageBean[size];
        }
    };

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
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

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(height);
        dest.writeString(sourceurl);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(width);
    }
}
