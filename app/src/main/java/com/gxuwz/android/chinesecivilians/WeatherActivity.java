package com.gxuwz.android.chinesecivilians;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_weather)
public class WeatherActivity extends AppCompatActivity {
    @ViewInject(R.id.vp_weather)
    private ViewPager mViewPager;
    @ViewInject(R.id.tv_weather_city)
    private TextView mTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

       mTextView.setText(getSharedPreferences("civilian",MODE_PRIVATE).getString("city","广州"));

    }

    public void onClick(View view){
//        Toast.makeText(this, "被点击了", Toast.LENGTH_SHORT).show();

        PopupWindow popupWindow=new PopupWindow(WeatherActivity.this);

        ImageView imageView=new ImageView(WeatherActivity.this);

        imageView.setImageResource(R.mipmap.ic_launcher);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        popupWindow.setContentView(imageView);
        popupWindow.showAsDropDown(view);


    }
}
