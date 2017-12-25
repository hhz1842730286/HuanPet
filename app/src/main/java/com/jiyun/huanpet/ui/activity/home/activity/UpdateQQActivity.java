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
import com.jiyun.huanpet.presenter.updata.UpdataQQ;
import com.jiyun.huanpet.presenter.updata.UpdataQQPresenter;
import com.jiyun.huanpet.ui.activity.home.bean.ForgetPassWordBean;
import com.jiyun.huanpet.view.UpdataWeiXinView;

/**
 * Created by lh on 2017/12/19.
 */

public class UpdateQQActivity extends AppCompatActivity implements View.OnClickListener,UpdataWeiXinView{
    private ImageView person_name_back;
    private TextView person_title_text;
    private TextView Submit;
    private EditText person_name_edi;
    private Context mCon;
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;
    private UpdataQQPresenter updataQQPresenter;
    private String userId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_name);
        mCon = UpdateQQActivity.this;
        preferences = mCon.getSharedPreferences("Login",MODE_PRIVATE);
        edit = preferences.edit();
        userId = preferences.getString("userId", "");
        initView();
    }

    private void initView() {
        updataQQPresenter = new UpdataQQPresenter(this);
        person_name_back = (ImageView) findViewById(R.id.Go_back);
        person_name_back.setOnClickListener(this);
        person_title_text = (TextView) findViewById(R.id.person_title_text);
        person_title_text.setText("QQ");
        Submit = (TextView) findViewById(R.id.Submit);
        Submit.setOnClickListener(this);
        person_name_edi = (EditText) findViewById(R.id.Name);
        person_name_edi.setHint("请输入你的QQ号");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Go_back:
                finish();
                break;

            case R.id.Submit:

                String string = person_name_edi.getText().toString().trim();
                updataQQPresenter.updataQQ(userId,string);
//                edit.putString("QQ",string);
//                edit.commit();

                break;
        }
    }

    @Override
    public void updata(ForgetPassWordBean bean) {
        if(bean.isRet() == true){
            Toast.makeText(mCon, "修改QQ成功", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(mCon, "修改QQ失败", Toast.LENGTH_SHORT).show();
        }
    }
}
