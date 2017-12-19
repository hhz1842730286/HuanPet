package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanpet.R;
import com.zaaach.citypicker.CityPickerActivity;

public class UpdateAddressActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView person_name_back;
    private TextView Submit,enter_text;
    private RelativeLayout City;
    private EditText person_name_edi;
    private static final int REQUEST_CODE_PICK_CITY = 0;
    private Context mCon;
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);
        mCon = UpdateAddressActivity.this;
        preferences = mCon.getSharedPreferences("Login",MODE_PRIVATE);
        edit = preferences.edit();
        initView();
    }

    private void initView() {
        person_name_back = (ImageView) findViewById(R.id.person_name_back);
        person_name_back.setOnClickListener(this);
        Submit = (TextView) findViewById(R.id.Submit);
        Submit.setOnClickListener(this);
        City = (RelativeLayout) findViewById(R.id.City);
        City.setOnClickListener(this);
        person_name_edi = (EditText) findViewById(R.id.person_name_edi);
        enter_text = (TextView) findViewById(R.id.enter_textCity);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.person_name_back:
                finish();
                break;
                case R.id.Submit:
                    String string = person_name_edi.getText().toString();
                    Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
                    break;

                    case R.id.City:
                        startActivityForResult(new Intent(UpdateAddressActivity.this, CityPickerActivity.class),
                                REQUEST_CODE_PICK_CITY);
                        break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                edit.putString("state",city);
                edit.commit();
                enter_text.setText("当前选择：" + city);
            }
        }
    }
}
