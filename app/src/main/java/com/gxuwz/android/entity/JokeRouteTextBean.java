package com.gxuwz.android.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fulunyong on 2015/11/921:44.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class JokeRouteTextBean implements Parcelable{

    private String content;
    private String poster;
    private String title;
    private String url;

    public JokeRouteTextBean() {
    }

    public JokeRouteTextBean(String content, String poster, String title, String url) {
        this.content = content;
        this.poster = poster;
        this.title = title;
        this.url = url;
    }

    protected JokeRouteTextBean(Parcel in) {
        content = in.readString();
        poster = in.readString();
        title = in.readString();
        url = in.readString();
    }

    public static final Creator<JokeRouteTextBean> CREATOR = new Creator<JokeRouteTextBean>() {
        @Override
        public JokeRouteTextBean createFromParcel(Parcel in) {
            return new JokeRouteTextBean(in);
        }

        @Override
        public JokeRouteTextBean[] newArray(int size) {
            return new JokeRouteTextBean[size];
        }
    };

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(content);
        dest.writeString(poster);
        dest.writeString(title);
        dest.writeString(url);
    }
}
