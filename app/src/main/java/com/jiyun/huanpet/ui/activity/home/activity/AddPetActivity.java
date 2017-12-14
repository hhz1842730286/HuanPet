package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanpet.R;

import static com.jiyun.huanpet.constants.Constants.REQUESTCODE;

public class AddPetActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJump1;
    private Button btnJump2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);
        initView();
    }

    private void initView() {
        btnJump1 = (Button) findViewById(R.id.btnJump1);
        btnJump2 = (Button) findViewById(R.id.btnJump2);

        btnJump1.setOnClickListener(this);
        btnJump2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnJump1:
                startActivityForResult(new Intent(this,PetTypeActivity.class),REQUESTCODE);
                break;
            case R.id.btnJump2:
                startActivity(new Intent(this,PetMianYiActivity.class));
                break;
        }
    }
}
