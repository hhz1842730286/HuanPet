package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanpet.R;

/**
 * Created by lh on 2017/12/19.
 */

public class UpdateQQActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView person_name_back;
    private TextView person_title_text;
    private TextView Submit;
    private EditText person_name_edi;
    private Context mCon;
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_name);
        mCon = UpdateQQActivity.this;
        preferences = mCon.getSharedPreferences("Login",MODE_PRIVATE);
        edit = preferences.edit();
        initView();
    }

    private void initView() {
        person_name_back = (ImageView) findViewById(R.id.person_name_back);
        person_name_back.setOnClickListener(this);
        person_title_text = (TextView) findViewById(R.id.person_title_text);
        person_title_text.setText("QQ");
        Submit = (TextView) findViewById(R.id.Submit);
        Submit.setOnClickListener(this);
        person_name_edi = (EditText) findViewById(R.id.person_name_edi);
        person_name_edi.setHint("请输入你的QQ号");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.person_name_back:
                finish();
                break;

            case R.id.Submit:
                finish();
                String string = person_name_edi.getText().toString().trim();
                edit.putString("QQ",string);
                edit.commit();
                Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
