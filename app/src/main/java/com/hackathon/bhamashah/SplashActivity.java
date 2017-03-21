package com.hackathon.bhamashah;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

import com.hackathon.bhamashah.activities.LoginActivity;
import com.hackathon.bhamashah.data.local.SharedPreferences;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isFinishing()){
                    if( SharedPreferences.getBoolean(SharedPreferences.KEY_IsLOGIN,false,SplashActivity.this)){
                        Intent i=new Intent(SplashActivity.this,HomeActivity.class);
                        startActivity(i);

                    }else{
                        Intent i=new Intent(SplashActivity.this,LoginActivity.class);
                        startActivity(i);
                    }
                    finish();

                }
            }
        }, 2000);
    }
}
