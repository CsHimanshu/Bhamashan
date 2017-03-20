package com.hackathon.bhamashah;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isFinishing()){
                Intent i=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);finish();
                }
            }
        }, 5000);
    }
}
