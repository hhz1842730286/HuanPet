package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanpet.R;

/**
 * Created by mengYao on 2017/12/12.
 */

public class AppointmentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button foster;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        foster = (Button) findViewById(R.id.Foster);
        foster.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.Foster:
                startActivity(new Intent(this,SuccessActivity.class));
                break;
        }

    }
}
