package com.gxuwz.android.chinesecivilians;

import android.app.Application;
import android.content.res.Resources;

import org.xutils.x;

import cn.bmob.v3.Bmob;

/**
 * Created by fulunyong on 2015/11/713:10.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class ClientApplication extends Application{

    public static Resources mResources;

    @Override
    public void onCreate(){
        super.onCreate();
        //init Xutils 3.0
        x.Ext.init(this);
        // get resources
        mResources =getResources();
        //init Bmob
        Bmob.initialize(this,mResources.getString(R.string.bmob_application_id));


    }


}
