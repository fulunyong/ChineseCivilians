package com.gxuwz.android.utils;

import android.util.Log;

import com.gxuwz.android.entity.AnecdoteBean;
import com.gxuwz.android.entity.EntertainmentBean;
import com.gxuwz.android.entity.JokeImageBean;
import com.gxuwz.android.entity.JokeRouteImageBean;
import com.gxuwz.android.entity.JokeRouteTextBean;
import com.gxuwz.android.entity.JokeTextBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by fulunyong on 2015/11/815:33.
 * EMAIL:fulunyong@qq.com
 * VERSION:1.0
 */
public class JSONUtils {

    public static ArrayList<EntertainmentBean> parseNewsFromJSONObject(JSONObject response){
        ArrayList<EntertainmentBean> dataList=new ArrayList<EntertainmentBean>();
        try{
            String showapi_res_code=response.getString("showapi_res_code");
            if (showapi_res_code!=null&&"0".equals(showapi_res_code)){
                JSONObject body=response.getJSONObject("showapi_res_body");
                if (body!=null){
                    for (int index=0;index<9;index++){
                        JSONObject bean=body.getJSONObject(""+index);
                        if (bean==null){
                            break;
                        }else{
                            EntertainmentBean entertainmentBean=new EntertainmentBean();
                            entertainmentBean.setDescription(bean.getString("description"));
                            entertainmentBean.setPicUrl(bean.getString("picUrl"));
                            entertainmentBean.setTitle(bean.getString("title"));
                            entertainmentBean.setUrl(bean.getString("url"));
                            String time=bean.getString("time");
                            if (time!=null){
                                entertainmentBean.setTime(time);
                            }
                            dataList.add(entertainmentBean);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return dataList;
        }
    }

    /**
     *
     * @param response
     * @return
     */
    public static ArrayList<AnecdoteBean> parseAnecdoteFromJSONObject(JSONObject response) {
        ArrayList<AnecdoteBean> dataList=new ArrayList<AnecdoteBean>();

        try{
            String showapi_res_code=response.getString("showapi_res_code");
            if (showapi_res_code!=null&&"0".equals(showapi_res_code)){
                JSONObject body=response.getJSONObject("showapi_res_body");
                if (body!=null){
                    for (int index=0;index<9;index++){
                        JSONObject bean=body.getJSONObject(""+index);
                        if (bean==null){
                            break;
                        }else{
                            AnecdoteBean anecdoteBean=new AnecdoteBean();
                            anecdoteBean.setDescription(bean.getString("description"));
                            anecdoteBean.setPicUrl(bean.getString("picUrl"));
                            anecdoteBean.setTitle(bean.getString("title"));
                            anecdoteBean.setUrl(bean.getString("url"));
                            dataList.add(anecdoteBean);
                        }
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return dataList;
        }
    }


    /**
     *
     * @param response
     * @return
     */
    public static ArrayList<JokeTextBean> parseJokeTextsFromJSONObject(JSONObject response) {

        ArrayList<JokeTextBean> dataList = new ArrayList<JokeTextBean>();
        try {
            String showapi_res_code = response.getString("showapi_res_code");
            if (showapi_res_code != null && "0".equals(showapi_res_code)) {
                JSONObject body = response.getJSONObject("showapi_res_body");
                if (body != null) {
                    JSONArray contentlist = body.getJSONArray("contentlist");
                    for (int index = 0; contentlist != null && index < contentlist.length(); index++) {
                        JSONObject json = contentlist.getJSONObject(index);
                        JokeTextBean joke = new JokeTextBean();
                        joke.setTitle(json.getString("title"));
                        joke.setCt(json.getString("ct"));
                        joke.setText(json.getString("text"));
                        joke.setType(json.getString("type"));
                        dataList.add(joke);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dataList;
        }
    }

    public static ArrayList<JokeImageBean> parseJokeImagesFromJSONObject(JSONObject response) {
        ArrayList<JokeImageBean> dataList = new ArrayList<JokeImageBean>();
        try {
            String showapi_res_code = response.getString("showapi_res_code");
            if (showapi_res_code != null && "0".equals(showapi_res_code)) {
                JSONObject body = response.getJSONObject("showapi_res_body");
                if (body != null) {
                    JSONArray contentlist = body.getJSONArray("contentlist");
                    for (int index = 0; contentlist != null && index < contentlist.length(); index++) {
                        JSONObject json = contentlist.getJSONObject(index);
                        JokeImageBean joke = new JokeImageBean();
                        joke.setTitle(json.getString("title"));
                        joke.setCt(json.getString("ct"));
                        joke.setImg(json.getString("img"));
                        joke.setType(json.getString("type"));
                        dataList.add(joke);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dataList;
        }
    }

    /**
     *
     * @param response
     * @return
     */
    public static ArrayList<JokeRouteImageBean> parseJokeRouteImgFromJSONObject(JSONObject response) {
        ArrayList<JokeRouteImageBean> dataList=new ArrayList<JokeRouteImageBean>();

        try {
            String showapi_res_code = response.getString("showapi_res_code");
            if (showapi_res_code != null && "0".equals(showapi_res_code)) {
                JSONObject body = response.getJSONObject("showapi_res_body");
                if (body != null) {
                    JSONArray list = body.getJSONArray("list");
                    for (int index = 0; list != null && index < list.length(); index++) {
                        JSONObject json = list.getJSONObject(index);
                        JokeRouteImageBean joke = new JokeRouteImageBean();
                        joke.setTitle(json.getString("title"));
                        joke.setUrl(json.getString("url"));
                        joke.setHeight(json.getString("height"));
                        joke.setSourceurl(json.getString("sourceurl"));
                        joke.setWidth(json.getString("width"));
                        dataList.add(joke);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dataList;
        }
    }

    /**
     *
     * @param response
     * @return
     */
    public static ArrayList<JokeRouteTextBean> parseJokeRouteTextFromJSONObject(JSONObject response) {
        ArrayList<JokeRouteTextBean> dataList=new ArrayList<JokeRouteTextBean>();

        try {
            String showapi_res_code = response.getString("showapi_res_code");
            if (showapi_res_code != null && "0".equals(showapi_res_code)) {
                JSONObject body = response.getJSONObject("showapi_res_body");
                if (body != null) {
                    JSONArray contentlist = body.getJSONArray("list");
                    for (int index = 0; contentlist != null && index < contentlist.length(); index++) {
                        JSONObject json = contentlist.getJSONObject(index);
                        JokeRouteTextBean joke = new JokeRouteTextBean();
                        joke.setTitle(json.getString("title"));
                        joke.setUrl(json.getString("url"));
                        joke.setContent(json.getString("content"));
                        joke.setPoster(json.getString("poster"));
                        dataList.add(joke);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return dataList;
        }
    }


}
