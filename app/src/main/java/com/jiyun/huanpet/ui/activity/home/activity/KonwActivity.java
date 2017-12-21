package com.jiyun.huanpet.ui.activity.home.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.huanpet.R;

public class KonwActivity extends AppCompatActivity {
    private ImageView konwback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konw);
        initView();
    }

    private void initView() {
        konwback = (ImageView) findViewById(R.id.konwback);
        konwback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
