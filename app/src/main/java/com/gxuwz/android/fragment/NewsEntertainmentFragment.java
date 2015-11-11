package com.gxuwz.android.fragment;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.gxuwz.android.adapter.NewsAdapter;
import com.gxuwz.android.chinesecivilians.NewsActivity;
import com.gxuwz.android.chinesecivilians.R;
import com.gxuwz.android.chinesecivilians.ShowActivity;
import com.gxuwz.android.entity.EntertainmentBean;

import com.gxuwz.android.net.HttpUtils;
import com.gxuwz.android.service.BackstageService;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
@ContentView(R.layout.fragment_news_entertainment)
public class NewsEntertainmentFragment extends Fragment {

    @ViewInject(R.id.lv_news_entertainment)
    private PullToRefreshListView mPullToRefreshListView;

    private Resources mResources;


    private ArrayList<EntertainmentBean> dataList;

    private NewsAdapter adapter;

    private boolean isEnd = false;
    private boolean isRefresh = false;
    private int pageSize=9;
    private int page=0;

    private Messenger messenger = null;
    private Messenger handlerMessenger =null;
    private boolean bound = false;
    private DataHandler mHandler;
    private MyServiceConnection serviceConnection = new MyServiceConnection();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mResources = getResources();
        initPullToRefresh();

        getSaveData(savedInstanceState);

        //init adapter
        initAdapter();

        //add Listener
        addListener();


        if (!HttpUtils.isNetworkConnected(getContext())){
            Toast.makeText(getContext(),mResources.getString(R.string.toast_network_useless),
                    Toast.LENGTH_SHORT).show();
        }

      }

    /**
     * get data
     */
    private void getSaveData(Bundle savedInstanceState) {

        if (savedInstanceState!=null){
            page=savedInstanceState.getInt("page",1);
            isEnd=savedInstanceState.getBoolean("isEnd");
            isRefresh=savedInstanceState.getBoolean("isRefresh");
            dataList=savedInstanceState.getParcelableArrayList("dataList");
        }else if (bound){
            requestInternetData();
        }

    }

    /**
     *
     */
    private void addListener(){

        mPullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                isRefresh = true;
                isEnd = false;
                page = 1;
                if (bound){
                    requestInternetData();
                }
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase){

                if (!isEnd){
                    requestInternetData();
                }else{
                    ILoadingLayout endLayout = mPullToRefreshListView.getLoadingLayoutProxy(false, true);//获取下面的布局
                    endLayout.setPullLabel(mResources.getString(R.string.list_pull_load_end));//刚下拉时，显示的提示
                    endLayout.setRefreshingLabel(mResources.getString(R.string.list_pull_load_end));//刷新时
                    endLayout.setReleaseLabel(mResources.getString(R.string.list_pull_load_end));//下来达到一定的距离时，显示的提示
                }
            }
        });

        mPullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getActivity(), ShowActivity.class);
                intent.putExtra("url",dataList.get(position-1).getUrl());
                startActivity(intent);

            }
        });

    }

    /**
     * init adapter
     */
    private void initAdapter() {
        if (dataList == null) {
            dataList = new ArrayList<EntertainmentBean>();
        }
        if (adapter == null) {
            adapter = new NewsAdapter(dataList, getActivity());
        }
        mPullToRefreshListView.setAdapter(adapter);
    }

    /**
     *
     */
    private void initPullToRefresh() {
        mPullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        //设置刷新时显示的文本(true,false)变改上面的字
        ILoadingLayout startLayout = mPullToRefreshListView.getLoadingLayoutProxy(true, false);//获取上面的布局
        startLayout.setPullLabel(mResources.getString(R.string.list_start_pull_label));//刚下拉时，显示的提示
        startLayout.setRefreshingLabel(mResources.getString(R.string.list_pull_refreshing_label));//刷新时
        startLayout.setReleaseLabel(mResources.getString(R.string.list_pull_release_label));//下来达到一定距离时，显示的提示
        startLayout.setLoadingDrawable(getResources().getDrawable(R.mipmap.z_arrow_up));

        ILoadingLayout endLayout = mPullToRefreshListView.getLoadingLayoutProxy(false, true);//获取下面的布局
        endLayout.setPullLabel(mResources.getString(R.string.list_end_pull_label));//刚下拉时，显示的提示
        endLayout.setRefreshingLabel(mResources.getString(R.string.list_pull_refreshing_label));//刷新时
        endLayout.setReleaseLabel(mResources.getString(R.string.list_pull_release_label));//下来达到一定的距离时，显示的提示
        startLayout.setLoadingDrawable(getResources().getDrawable(R.mipmap.z_arrow_down));

    }


    class DataHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case BackstageService.RESULT_OK:
                    if (mPullToRefreshListView != null) {
                        mPullToRefreshListView.onRefreshComplete();
                    }
                    ArrayList<EntertainmentBean> list = msg.getData().getParcelableArrayList("dataList");

                    if (list != null && list.size() > 0) {

                        Log.d("DataHandler", "list="+list.size());

                        if (dataList == null) {
                            dataList = new ArrayList<EntertainmentBean>();
                        }
                        if (isRefresh) {
                            isRefresh = false;
                            dataList.clear();
                        }

                        dataList.addAll(list);
                        adapter.notifyDataSetChanged();
                        if (list.size() < pageSize) {
                            isEnd = true;
                        }

                    } else {
                        isEnd = true;
                    }
                    break;
            }
        }
    }

    /**
     * 实现Activity和Service链接成功后的处理
     */
    public class MyServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
            bound = true;
            handlerMessenger = new Messenger(mHandler);

            requestInternetData();

        }

        @Override
        public void onServiceDisconnected(ComponentName name){
            messenger = null;
            bound = false;
        }
    }

    /**
     *
     */
    private void requestInternetData() {
        Message msg = Message.obtain(null,BackstageService.MESSAGE_WHAT_ENTERTAINMENT, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putString("page", ++page+ "");
        msg.setData(bundle);
        msg.replyTo = handlerMessenger;
        try {
            messenger.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mHandler = new DataHandler();
        if (!bound) {
            Intent intent = new Intent(BackstageService.SERVICE_ACTION);
            getActivity().bindService(intent, serviceConnection, Activity.BIND_AUTO_CREATE);
        }

    }



    /**
     *  data save
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {

        if (dataList!=null&&dataList.size()>0){
            outState.putParcelableArrayList("dataList",dataList);
            outState.putBoolean("isEnd", isEnd);
            outState.putBoolean("isRefresh", isRefresh);
            outState.putInt("page",page);
        }
    }
}
