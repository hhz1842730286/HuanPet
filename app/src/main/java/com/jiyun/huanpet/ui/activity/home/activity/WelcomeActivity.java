package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.jiyun.huanpet.R;

/**
 * Created by lh on 2017/12/25.
 */

public class WelcomeActivity extends AppCompatActivity {
    private ImageView imageView;
    private Handler han = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        imageView = (ImageView) findViewById(R.id.welcome_image);
        han.postDelayed(runnable,3000);
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent in = new Intent(WelcomeActivity.this,HomeActivity.class);
            startActivity(in);
            finish();
        }
    };
}
