package com.gxuwz.android.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fulunyong on 2015/11/917:37.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class JokeTextBean implements Parcelable{
    private String ct;
    private String text;
    private String title;
    private String type;

    public JokeTextBean() {
    }

    public JokeTextBean(String ct, String text, String title, String type) {
        this.ct = ct;
        this.text = text;
        this.title = title;
        this.type = type;
    }



    public static final Creator<JokeTextBean> CREATOR = new Creator<JokeTextBean>() {
        @Override
        public JokeTextBean createFromParcel(Parcel in) {
            return new JokeTextBean(in);
        }

        @Override
        public JokeTextBean[] newArray(int size) {
            return new JokeTextBean[size];
        }
    };

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
    public int describeContents() {
        return 0;
    }

    protected JokeTextBean(Parcel in) {
        ct = in.readString();
        text = in.readString();
        title = in.readString();
        type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ct);
        dest.writeString(text);
        dest.writeString(title);
        dest.writeString(type);
    }
}
