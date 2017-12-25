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
import com.jiyun.huanpet.presenter.updata.UpdataWeinPresenter;
import com.jiyun.huanpet.ui.activity.home.bean.ForgetPassWordBean;
import com.jiyun.huanpet.view.UpdataWeiXinView;

/**
 * Created by lh on 2017/12/19.
 */

public class UpdateWeiXinActivity extends AppCompatActivity implements View.OnClickListener,UpdataWeiXinView{

    private ImageView person_name_back;
    private TextView Submit;
    private EditText person_name_edi;
    private TextView person_title_text;
    private Context mCon;
    private SharedPreferences.Editor edit;
    private SharedPreferences preferences;
    private UpdataWeinPresenter updataWeinPresenter;
    private String userId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_name);
        mCon = UpdateWeiXinActivity.this;
        preferences = mCon.getSharedPreferences("Login",MODE_PRIVATE);
        edit = preferences.edit();
        userId = preferences.getString("userId", "");
        initView();
    }

    private void initView() {
        updataWeinPresenter = new UpdataWeinPresenter(this);
        person_title_text = (TextView) findViewById(R.id.person_title_text);
        person_title_text.setText("微信");
        person_name_back = (ImageView) findViewById(R.id.Go_back);
        person_name_back.setOnClickListener(this);
        Submit = (TextView) findViewById(R.id.Submit);
        Submit.setOnClickListener(this);
        person_name_edi = (EditText) findViewById(R.id.Name);
        person_name_edi.setHint("请输入你的微信号");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Go_back:
                finish();
                break;

            case R.id.Submit:
                finish();
                String string = person_name_edi.getText().toString().trim();
                updataWeinPresenter.updataweiin(userId,string);

                break;
        }
    }

    @Override
    public void updata(ForgetPassWordBean bean) {
        if(bean.isRet() == true){
            Toast.makeText(mCon, "修改微信成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(mCon, "修改微信失败", Toast.LENGTH_SHORT).show();
        }
    }
}
