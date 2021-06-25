package com.dairy.dairyapp.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
  public void fullScreen(){
      getWindow().getDecorView().setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                      View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
  }
}
