package com.gxuwz.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.gxuwz.android.configure.ShowAPI;
import com.gxuwz.android.entity.AnecdoteBean;
import com.gxuwz.android.entity.EntertainmentBean;
import com.gxuwz.android.entity.JokeImageBean;
import com.gxuwz.android.entity.JokeRouteImageBean;
import com.gxuwz.android.entity.JokeRouteTextBean;
import com.gxuwz.android.entity.JokeTextBean;
import com.gxuwz.android.utils.DateUtils;
import com.gxuwz.android.utils.JSONUtils;

import org.json.JSONObject;

import java.util.ArrayList;

public class BackstageService extends Service {

    public static final String SERVICE_ACTION = "com.gxuwz.android.service.BackstageService";

    public static final int RESULT_OK = 200;
    public static final int MESSAGE_WHAT_ENTERTAINMENT = 1;
    public static final int MESSAGE_WHAT_SPORTS = 2;
    public static final int MESSAGE_WHAT_ANECDOTE = 3;
    public static final int MESSAGE_WHAT_BELLE = 4;
    public static final int MESSAGE_WHAT_JOKE_TEXT = 5;
    public static final int MESSAGE_WHAT_JOKE_IMAGE = 6;
    public static final int MESSAGE_WHAT_ROUTE_JOKE_TEXT = 7;
    public static final int MESSAGE_WHAT_ROUTE_JOKE_IMAGE = 8;

    private Messenger serviceMessenger = new Messenger(new BackgroundHandler());

    private Messenger clientEntertainment;
    private Messenger clientSports;
    private Messenger clientAnecdote;
    private Messenger clientBelle;
    private Messenger clientJokeText;
    private Messenger clientJokeImage;
    private Messenger clientJokeRouteText;
    private Messenger clientJokeRouteImage;

    private RequestQueue mRequestQueue;


    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = Volley.newRequestQueue(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return serviceMessenger.getBinder();
    }


    class BackgroundHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_WHAT_ENTERTAINMENT:
                    clientEntertainment = msg.replyTo;
                    requestEntertainment(msg);
                    break;
                case MESSAGE_WHAT_SPORTS:
                    clientSports = msg.replyTo;
                    requestSports(msg);
                    break;
                case MESSAGE_WHAT_ANECDOTE:
                    clientAnecdote = msg.replyTo;
                    requestAnecdote(msg);
                    break;
                case MESSAGE_WHAT_BELLE:
                    clientBelle = msg.replyTo;
                    requestBelle(msg);
                    break;
                case MESSAGE_WHAT_JOKE_TEXT:
                    clientJokeText = msg.replyTo;
                    requestJokeText(msg);
                    break;
                case MESSAGE_WHAT_JOKE_IMAGE:
                    clientJokeImage = msg.replyTo;
                    requestJokeImage(msg);
                    break;
                case MESSAGE_WHAT_ROUTE_JOKE_TEXT:
                    clientJokeRouteText= msg.replyTo;
                    requestJokeRouteText(msg);
                    break;
                case MESSAGE_WHAT_ROUTE_JOKE_IMAGE:
                    clientJokeRouteImage = msg.replyTo;
                    requestJokeRouteImage(msg);
                    break;

            }
            super.handleMessage(msg);
        }


        /**
         * @param msg
         */
        private void requestSports(Message msg) {
            final String page = msg.getData().getString("page", "1");
            StringBuffer url = new StringBuffer();

            url.append(ShowAPI.SPORTS_URL);
            url.append("&page=");
            url.append(page);
            url.append("&showapi_appid=");
            url.append(ShowAPI.APPID);
            url.append("&showapi_sign=");
            url.append(ShowAPI.SIGN);
            url.append("&showapi_timestamp=");
            url.append(DateUtils.getNowTimeToString());

            JsonObjectRequest request = new JsonObjectRequest(url.toString(),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            if (response != null) {
                                ArrayList<EntertainmentBean> dataList = JSONUtils.parseNewsFromJSONObject(response);
                                if (dataList != null && dataList.size() > 0) {
                                    Message msg = Message.obtain();
                                    msg.what = RESULT_OK;
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelableArrayList("dataList", dataList);
                                    msg.setData(bundle);
                                    try {
                                        clientSports.send(msg);
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            mRequestQueue.add(request);
        }

        /**
         * @param msg
         */
        private void requestEntertainment(Message msg) {
            final String page = msg.getData().getString("page", "1");

            StringBuffer url = new StringBuffer();

            url.append(ShowAPI.ENTERTAINMENT_URL);
            url.append("&page=");
            url.append(page);
            url.append("&showapi_appid=");
            url.append(ShowAPI.APPID);
            url.append("&showapi_sign=");
            url.append(ShowAPI.SIGN);
            url.append("&showapi_timestamp=");
            url.append(DateUtils.getNowTimeToString());


            JsonObjectRequest request = new JsonObjectRequest(url.toString(),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            if (response != null) {
                                ArrayList<EntertainmentBean> dataList = JSONUtils.parseNewsFromJSONObject(response);
                                if (dataList != null && dataList.size() > 0) {
                                    Message msg = Message.obtain();
                                    msg.what = RESULT_OK;
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelableArrayList("dataList", dataList);
                                    msg.setData(bundle);
                                    try {
                                        clientEntertainment.send(msg);
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            mRequestQueue.add(request);
        }
    }

    /**
     *
     * @param msg
     */
    private void requestJokeRouteImage(Message msg) {

        StringBuffer url = new StringBuffer();

        url.append(ShowAPI.JOKE_ROUTE_IMG_URL);
        url.append("&showapi_appid=");
        url.append(ShowAPI.APPID);
        url.append("&showapi_sign=");
        url.append(ShowAPI.SIGN);
        url.append("&showapi_timestamp=");
        url.append(DateUtils.getNowTimeToString());


        JsonObjectRequest request = new JsonObjectRequest(url.toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            ArrayList<JokeRouteImageBean> dataList =
                                    JSONUtils.parseJokeRouteImgFromJSONObject(response);
                            if (dataList != null && dataList.size() > 0) {
                                Message msg = Message.obtain();
                                msg.what = RESULT_OK;
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("dataList", dataList);
                                msg.setData(bundle);
                                try {
                                    clientJokeRouteImage.send(msg);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(request);

    }

    /**
     *
     * @param msg
     */
    private void requestJokeRouteText(Message msg) {

        StringBuffer url = new StringBuffer();

        url.append(ShowAPI.JOKE_ROUTE_TEXT_URL);
        url.append("&showapi_appid=");
        url.append(ShowAPI.APPID);
        url.append("&showapi_sign=");
        url.append(ShowAPI.SIGN);
        url.append("&showapi_timestamp=");
        url.append(DateUtils.getNowTimeToString());

        JsonObjectRequest request = new JsonObjectRequest(url.toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            ArrayList<JokeRouteTextBean> dataList =
                                    JSONUtils.parseJokeRouteTextFromJSONObject(response);
                            if (dataList != null && dataList.size() > 0) {
                                Message msg = Message.obtain();
                                msg.what = RESULT_OK;
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("dataList", dataList);
                                msg.setData(bundle);
                                try {
                                    clientJokeRouteText.send(msg);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(request);

    }

    /**
     * @param msg
     */
    private void requestJokeImage(Message msg) {
        final String page = msg.getData().getString("page", "1");

        StringBuffer url = new StringBuffer();

        url.append(ShowAPI.JOKE_IMG_URL);
        url.append("&page=");
        url.append(page);
        url.append("&showapi_appid=");
        url.append(ShowAPI.APPID);
        url.append("&showapi_sign=");
        url.append(ShowAPI.SIGN);
        url.append("&showapi_timestamp=");
        url.append(DateUtils.getNowTimeToString());
        url.append("&time=1970-11-11");

        JsonObjectRequest request = new JsonObjectRequest(url.toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            ArrayList<JokeImageBean> dataList =
                                    JSONUtils.parseJokeImagesFromJSONObject(response);
                            if (dataList != null && dataList.size() > 0) {
                                Message msg = Message.obtain();
                                msg.what = RESULT_OK;
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("dataList", dataList);
                                msg.setData(bundle);
                                try {
                                    clientJokeImage.send(msg);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(request);

    }


    /**
     * @param msg
     */
    private void requestJokeText(Message msg) {

        final String page = msg.getData().getString("page", "1");

        StringBuffer url = new StringBuffer();

        url.append(ShowAPI.JOKE_TEXT_URL);
        url.append("&page=");
        url.append(page);
        url.append("&showapi_appid=");
        url.append(ShowAPI.APPID);
        url.append("&showapi_sign=");
        url.append(ShowAPI.SIGN);
        url.append("&showapi_timestamp=");
        url.append(DateUtils.getNowTimeToString());
        url.append("&time=1970-11-11");

        JsonObjectRequest request = new JsonObjectRequest(url.toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            ArrayList<JokeTextBean> dataList =
                                    JSONUtils.parseJokeTextsFromJSONObject(response);
                            if (dataList != null && dataList.size() > 0) {
                                Message msg = Message.obtain();
                                msg.what = RESULT_OK;
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("dataList", dataList);
                                msg.setData(bundle);
                                try {
                                    clientJokeText.send(msg);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(request);


    }


    /**
     * @param msg
     */
    private void requestBelle(Message msg) {

        final String page = msg.getData().getString("page", "1");

        StringBuffer url = new StringBuffer();

        url.append(ShowAPI.BELLE_URL);
        url.append("&page=");
        url.append(page);
        url.append("&showapi_appid=");
        url.append(ShowAPI.APPID);
        url.append("&showapi_sign=");
        url.append(ShowAPI.SIGN);
        url.append("&showapi_timestamp=");
        url.append(DateUtils.getNowTimeToString());

        JsonObjectRequest request = new JsonObjectRequest(url.toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            ArrayList<AnecdoteBean> dataList = JSONUtils.parseAnecdoteFromJSONObject(response);
                            if (dataList != null && dataList.size() > 0) {
                                Message msg = Message.obtain();
                                msg.what = RESULT_OK;
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("dataList", dataList);
                                msg.setData(bundle);
                                try {
                                    clientBelle.send(msg);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(request);

    }

    /**
     * @param msg
     */
    private void requestAnecdote(Message msg) {
        final String page = msg.getData().getString("page", "1");

        StringBuffer url = new StringBuffer();

        url.append(ShowAPI.ANECDOTE_URL);
        url.append("&page=");
        url.append(page);
        url.append("&showapi_appid=");
        url.append(ShowAPI.APPID);
        url.append("&showapi_sign=");
        url.append(ShowAPI.SIGN);
        url.append("&showapi_timestamp=");
        url.append(DateUtils.getNowTimeToString());

        JsonObjectRequest request = new JsonObjectRequest(url.toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (response != null) {
                            ArrayList<AnecdoteBean> dataList = JSONUtils.parseAnecdoteFromJSONObject(response);
                            if (dataList != null && dataList.size() > 0) {
                                Message msg = Message.obtain();
                                msg.what = RESULT_OK;
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("dataList", dataList);
                                msg.setData(bundle);
                                try {
                                    clientAnecdote.send(msg);
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(request);
    }

}
