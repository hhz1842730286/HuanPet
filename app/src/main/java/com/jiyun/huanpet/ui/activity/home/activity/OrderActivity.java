package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanpet.R;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    private Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        order = (Button) findViewById(R.id.order);
        order.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order:
                 startActivity(new Intent(this,OrderdetailsActivity.class));
                break;
        }
    }
}
