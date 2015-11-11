package com.gxuwz.android.chinesecivilians;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gxuwz.android.net.HttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_show)
public class ShowActivity extends AppCompatActivity {

    @ViewInject(R.id.web_view_show)
    private WebView mWebView;
    @ViewInject(R.id.activity_show_progressBar)
    private ProgressBar mProgressBar;
    private Resources mResources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        mResources = getResources();
        initWebView();
        String url=getIntent().getStringExtra("url");
        if (url!=null&&url.length()>0){
            mWebView.loadUrl(url);
        }else{
            Toast.makeText(this,mResources.getString(R.string.url_useless), Toast.LENGTH_SHORT).show();
            finish();
        }

        if (!HttpUtils.isNetworkConnected(getApplicationContext())){
            Toast.makeText(getApplicationContext(),mResources.getString(R.string.toast_network_useless),
                    Toast.LENGTH_SHORT).show();
        }


    }


    private void initWebView(){
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressBar.setVisibility(View.GONE);
            }
        });

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setBuiltInZoomControls(true);//support zoom
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        if (keyCode==KeyEvent.KEYCODE_BACK||keyCode==KeyEvent.KEYCODE_BREAK){
            if (mWebView!=null&&mWebView.canGoBack()){
                mWebView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
