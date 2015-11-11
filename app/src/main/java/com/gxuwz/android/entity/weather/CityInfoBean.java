package com.gxuwz.android.entity.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fulunyong on 2015/11/1017:31.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 *  对应易源的天气预报返回的城市信息
 *  https://www.showapi.com/api/lookPoint/9
 *
 */
public class CityInfoBean implements Parcelable{

    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private String c5;
    private String c6;
    private String c7;
    private String c8;
    private String c9;
    private String c10;
    private String c11;
    private String c12;
    private String c15;
    private String c16;
    private String c17;
    private String latitude;
    private String longitude;

    public CityInfoBean() {
    }


    protected CityInfoBean(Parcel in) {
        c1 = in.readString();
        c2 = in.readString();
        c3 = in.readString();
        c4 = in.readString();
        c5 = in.readString();
        c6 = in.readString();
        c7 = in.readString();
        c8 = in.readString();
        c9 = in.readString();
        c10 = in.readString();
        c11 = in.readString();
        c12 = in.readString();
        c15 = in.readString();
        c16 = in.readString();
        c17 = in.readString();
        latitude = in.readString();
        longitude = in.readString();
    }

    public static final Creator<CityInfoBean> CREATOR = new Creator<CityInfoBean>() {
        @Override
        public CityInfoBean createFromParcel(Parcel in) {
            return new CityInfoBean(in);
        }

        @Override
        public CityInfoBean[] newArray(int size) {
            return new CityInfoBean[size];
        }
    };

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5;
    }

    public String getC6() {
        return c6;
    }

    public void setC6(String c6) {
        this.c6 = c6;
    }

    public String getC7() {
        return c7;
    }

    public void setC7(String c7) {
        this.c7 = c7;
    }

    public String getC8() {
        return c8;
    }

    public void setC8(String c8) {
        this.c8 = c8;
    }

    public String getC9() {
        return c9;
    }

    public void setC9(String c9) {
        this.c9 = c9;
    }

    public String getC10() {
        return c10;
    }

    public void setC10(String c10) {
        this.c10 = c10;
    }

    public String getC11() {
        return c11;
    }

    public void setC11(String c11) {
        this.c11 = c11;
    }

    public String getC12() {
        return c12;
    }

    public void setC12(String c12) {
        this.c12 = c12;
    }


    public String getC15() {
        return c15;
    }

    public void setC15(String c15) {
        this.c15 = c15;
    }

    public String getC16() {
        return c16;
    }

    public void setC16(String c16) {
        this.c16 = c16;
    }

    public String getC17() {
        return c17;
    }

    public void setC17(String c17) {
        this.c17 = c17;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(c1);
        dest.writeString(c2);
        dest.writeString(c3);
        dest.writeString(c4);
        dest.writeString(c5);
        dest.writeString(c6);
        dest.writeString(c7);
        dest.writeString(c8);
        dest.writeString(c9);
        dest.writeString(c10);
        dest.writeString(c11);
        dest.writeString(c12);
        dest.writeString(c15);
        dest.writeString(c16);
        dest.writeString(c17);
        dest.writeString(latitude);
        dest.writeString(longitude);
    }
}
