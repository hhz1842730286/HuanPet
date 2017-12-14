package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanpet.R;

public class NewsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button dialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        dialogue = (Button) findViewById(R.id.dialogue);
        dialogue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialogue:
                  startActivity(new Intent(this,ChatInterfaceActivity.class));
                break;
        }
    }
}
