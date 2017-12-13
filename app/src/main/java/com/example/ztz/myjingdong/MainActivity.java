package com.example.ztz.myjingdong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.ztz.myjingdong.activity.HomeActivity;
import com.example.ztz.myjingdong.activity.ViewPagerActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉状态栏
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final Intent intent=new Intent(MainActivity.this,HomeActivity.class);
        Timer timer=new Timer();
        TimerTask task=new TimerTask(){
            @Override
            public void run(){
                //startActivity(intent);
                date();
                finish();
            }
        };
        timer.schedule(task,3*1000);//此处的Delay可以是3*1000，代表三秒
    }

    /**
     * 判断是否第一次启动app
     */
    private void date() {
        SharedPreferences shared=getSharedPreferences("is", MODE_PRIVATE);
        boolean isfer=shared.getBoolean("isfer", true);
        SharedPreferences.Editor editor=shared.edit();
        if(isfer){
            //第一次进入引导页面
            Intent in=new Intent(MainActivity.this,ViewPagerActivity.class);
            startActivity(in);
            finish();
            editor.putBoolean("isfer", false);
            editor.commit();
        }else{
            //第二次进入跳转
            Intent in=new Intent(MainActivity.this,HomeActivity.class);
            startActivity(in);
            finish();


        }
    }
}
