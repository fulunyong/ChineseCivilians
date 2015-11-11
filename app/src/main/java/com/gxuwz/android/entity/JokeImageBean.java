package com.gxuwz.android.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fulunyong on 2015/11/919:41.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class JokeImageBean implements Parcelable{

    private String ct;
    private String img;
    private String title;
    private String type;

    public JokeImageBean() {
    }

    public JokeImageBean(String ct, String img, String title, String type) {
        this.ct = ct;
        this.img = img;
        this.title = title;
        this.type = type;
    }



    public static final Creator<JokeImageBean> CREATOR = new Creator<JokeImageBean>() {
        @Override
        public JokeImageBean createFromParcel(Parcel in) {
            return new JokeImageBean(in);
        }

        @Override
        public JokeImageBean[] newArray(int size) {
            return new JokeImageBean[size];
        }
    };

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "JokeImageBean{" +
                "ct='" + ct + '\'' +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    protected JokeImageBean(Parcel in) {
        ct = in.readString();
        img = in.readString();
        title = in.readString();
        type = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ct);
        dest.writeString(img);
        dest.writeString(title);
        dest.writeString(type);
    }
}
