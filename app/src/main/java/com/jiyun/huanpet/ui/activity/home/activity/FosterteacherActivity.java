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

public class FosterteacherActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button comment;
    private Button appointment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fosterteacher);
        comment = (Button) findViewById(R.id.comment);
        comment.setOnClickListener(this);
        appointment = (Button) findViewById(R.id.appointment);
        appointment.setOnClickListener(this);
    }
      //jsgngkjdsklgndslkgdgdslkgjdgfdsf
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.comment :
                  startActivity(new Intent(this,CommentActivity.class));
                break;
            case R.id.appointment :
                 startActivity(new Intent(this,AppointmentActivity.class));
                break;
        }
    }
}
