package com.gxuwz.android.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fulunyong on 2015/11/811:30.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class DateUtils{

    /**
     *
     * @return
     */
    public static String getNowTimeToString(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    /**
     *
     * @return
     */
    public static String getDayToString() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
}
