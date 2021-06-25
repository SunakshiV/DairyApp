package com.dairy.dairyapp.activities;

import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.dairy.dairyapp.R;
import com.dairy.dairyapp.databinding.ActivityMainBinding;

public class SplashActivity extends BaseActivity {
    ActivityMainBinding binding;
    private int progressStatus = 0;
    Handler handler=new Handler();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        fullScreen();
        setProgress();
    }

    private void setProgress() {
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        public void run() {
                            binding.progress.setProgress(progressStatus);
                                if(progressStatus==100){
                                    startActivity(new Intent(SplashActivity.this,OnBordingActivity.class));
                                    finish();
                                } }
                    });
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } } }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}