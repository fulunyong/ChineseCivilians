package com.gxuwz.android.entity.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fulunyong on 2015/11/1018:39.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class WeatherInfoBean implements Parcelable{
    private String air_press;
    private String day;
    private String day_air_temperature;
    private String day_weather;
    private String day_weather_pic;
    private String day_wind_direction;
    private String day_wind_power;
    private String jiangshui;
    private String night_air_temperature;
    private String night_weather;
    private String night_weather_pic;
    private String night_wind_direction;
    private String night_wind_power;
    private String sun_begin_end;
    private String weather_code;
    private String weekday;
    private String ziwaixian;

    public WeatherInfoBean() {
    }

    protected WeatherInfoBean(Parcel in) {
        air_press = in.readString();
        day = in.readString();
        day_air_temperature = in.readString();
        day_weather = in.readString();
        day_weather_pic = in.readString();
        day_wind_direction = in.readString();
        day_wind_power = in.readString();
        jiangshui = in.readString();
        night_air_temperature = in.readString();
        night_weather = in.readString();
        night_weather_pic = in.readString();
        night_wind_direction = in.readString();
        night_wind_power = in.readString();
        sun_begin_end = in.readString();
        weather_code = in.readString();
        weekday = in.readString();
        ziwaixian = in.readString();
    }

    public static final Creator<WeatherInfoBean> CREATOR = new Creator<WeatherInfoBean>() {
        @Override
        public WeatherInfoBean createFromParcel(Parcel in) {
            return new WeatherInfoBean(in);
        }

        @Override
        public WeatherInfoBean[] newArray(int size) {
            return new WeatherInfoBean[size];
        }
    };

    public String getAir_press() {
        return air_press;
    }

    public void setAir_press(String air_press) {
        this.air_press = air_press;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay_air_temperature() {
        return day_air_temperature;
    }

    public void setDay_air_temperature(String day_air_temperature) {
        this.day_air_temperature = day_air_temperature;
    }

    public String getDay_weather() {
        return day_weather;
    }

    public void setDay_weather(String day_weather) {
        this.day_weather = day_weather;
    }

    public String getDay_weather_pic() {
        return day_weather_pic;
    }

    public void setDay_weather_pic(String day_weather_pic) {
        this.day_weather_pic = day_weather_pic;
    }

    public String getDay_wind_direction() {
        return day_wind_direction;
    }

    public void setDay_wind_direction(String day_wind_direction) {
        this.day_wind_direction = day_wind_direction;
    }

    public String getDay_wind_power() {
        return day_wind_power;
    }

    public void setDay_wind_power(String day_wind_power) {
        this.day_wind_power = day_wind_power;
    }

    public String getJiangshui() {
        return jiangshui;
    }

    public void setJiangshui(String jiangshui) {
        this.jiangshui = jiangshui;
    }

    public String getNight_air_temperature() {
        return night_air_temperature;
    }

    public void setNight_air_temperature(String night_air_temperature) {
        this.night_air_temperature = night_air_temperature;
    }

    public String getNight_weather() {
        return night_weather;
    }

    public void setNight_weather(String night_weather) {
        this.night_weather = night_weather;
    }

    public String getNight_weather_pic() {
        return night_weather_pic;
    }

    public void setNight_weather_pic(String night_weather_pic) {
        this.night_weather_pic = night_weather_pic;
    }

    public String getNight_wind_direction() {
        return night_wind_direction;
    }

    public void setNight_wind_direction(String night_wind_direction) {
        this.night_wind_direction = night_wind_direction;
    }

    public String getNight_wind_power() {
        return night_wind_power;
    }

    public void setNight_wind_power(String night_wind_power) {
        this.night_wind_power = night_wind_power;
    }

    public String getSun_begin_end() {
        return sun_begin_end;
    }

    public void setSun_begin_end(String sun_begin_end) {
        this.sun_begin_end = sun_begin_end;
    }

    public String getWeather_code() {
        return weather_code;
    }

    public void setWeather_code(String weather_code) {
        this.weather_code = weather_code;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getZiwaixian() {
        return ziwaixian;
    }

    public void setZiwaixian(String ziwaixian) {
        this.ziwaixian = ziwaixian;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(air_press);
        dest.writeString(day);
        dest.writeString(day_air_temperature);
        dest.writeString(day_weather);
        dest.writeString(day_weather_pic);
        dest.writeString(day_wind_direction);
        dest.writeString(day_wind_power);
        dest.writeString(jiangshui);
        dest.writeString(night_air_temperature);
        dest.writeString(night_weather);
        dest.writeString(night_weather_pic);
        dest.writeString(night_wind_direction);
        dest.writeString(night_wind_power);
        dest.writeString(sun_begin_end);
        dest.writeString(weather_code);
        dest.writeString(weekday);
        dest.writeString(ziwaixian);
    }
}
