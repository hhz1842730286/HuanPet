package com.jiyun.huanpet.ui.activity.home.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.forget.ForgetPresenter;
import com.jiyun.huanpet.ui.activity.home.bean.ForgetPassWordBean;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.jiyun.huanpet.view.ForgetView;

/**
 * Created by lh on 2017/12/21.
 */

public class ForgetPassWordActivity extends BaseActivity<ForgetPresenter> implements View.OnClickListener,ForgetView{
    private ImageView forget_back;
    private TextView forget_Submit;
    private EditText forget_phone;
    private EditText forget_word;
    private EditText forget_password;
    private ForgetPresenter forgetPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgetpassword;
    }

    @Override
    protected void findViewById() {
        forgetPresenter = new ForgetPresenter(this);
        forget_back = (ImageView) findViewById(R.id.forget_back);
        forget_Submit = (TextView) findViewById(R.id.forget_Submit);
        forget_phone = (EditText) findViewById(R.id.forget_phone);
        forget_word = (EditText) findViewById(R.id.forget_word);
        forget_password = (EditText) findViewById(R.id.forget_password);
    }

    @Override
    protected void init() {
        forget_back.setOnClickListener(this);
        forget_Submit.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forget_back:
                finish();
                break;

                case R.id.forget_Submit:
                    String phone = forget_phone.getText().toString().trim();
                    String word = forget_password.getText().toString().trim();
                    if(phone!=null&word!=null){
                      forgetPresenter.forgetWord(phone,word);
                    }else{
                        Toast.makeText(this, "账号或者密码不能为空", Toast.LENGTH_SHORT).show();
                    }
                    break;
        }
    }

    @Override
    public void forgetPassWord(ForgetPassWordBean bean) {
        if(bean.isRet() == true){
            Toast.makeText(this, "修改密码成功", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "修改密码失败", Toast.LENGTH_SHORT).show();
        }
    }
}
