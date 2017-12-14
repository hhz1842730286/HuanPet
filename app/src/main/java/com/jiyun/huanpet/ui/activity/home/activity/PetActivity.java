package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanpet.R;

import static com.jiyun.huanpet.constants.Constants.REQUESTCODE;

public class PetActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mAddPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        initView();
    }

    private void initView() {
        mAddPet = (Button) findViewById(R.id.mAddPet);

        mAddPet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mAddPet:
                startActivityForResult(new Intent(this,AddPetActivity.class),REQUESTCODE);
                break;
        }
    }
}
