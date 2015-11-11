package com.gxuwz.android.net;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by fulunyong on 2015/10/2614:43.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class HttpUtils{

    private static final String TAG ="HttpUtils";

    public static boolean isNetworkConnected(Context context){
        try{
            ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            return manager.getActiveNetworkInfo().isConnected();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
