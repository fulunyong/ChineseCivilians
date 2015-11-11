package com.gxuwz.android.configure;

import cn.bmob.v3.BmobObject;

/**
 * Created by fulunyong on 2015/11/713:33.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class Functions extends BmobObject{
    //advertisement type
    private int advertisementType;
    //weather derail
    private int weatherDerail;
    //news derail
    private int newsDerail;
    //


    public Functions(){
    }

    public Functions(int advertisementType){
        this.advertisementType = advertisementType;
    }

    public Functions(int advertisementType, int weatherDerail, int newsDerail) {
        this.advertisementType = advertisementType;
        this.weatherDerail = weatherDerail;
        this.newsDerail = newsDerail;
    }

    public int getAdvertisementType() {
        return advertisementType;
    }

    public void setAdvertisementType(int advertisementType) {
        this.advertisementType = advertisementType;
    }

    public int getWeatherDerail() {
        return weatherDerail;
    }

    public void setWeatherDerail(int weatherDerail) {
        this.weatherDerail = weatherDerail;
    }

    public int getNewsDerail() {
        return newsDerail;
    }

    public void setNewsDerail(int newsDerail) {
        this.newsDerail = newsDerail;
    }
}
