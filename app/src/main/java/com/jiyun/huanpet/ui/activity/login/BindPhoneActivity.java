package com.jiyun.huanpet.ui.activity.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.BindPhoneContract;
import com.jiyun.huanpet.presenter.presenter.BindPhonePresenterImpl;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;
import com.jiyun.huanpet.ui.base.BaseActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mengYao on 2017/12/11.
 */

public class BindPhoneActivity extends BaseActivity<BindPhonePresenterImpl> implements BindPhoneContract.BindPhoneView, View.OnClickListener {

    private ImageView mBindPhoneBack;
    private Button mBindPhoneBtn;
    private CircleImageView mBindPhoneHeadImg;
    private TextView mBindPhoneName;
    private EditText mBindPhone,mInputUserName,mInputPassword;
    private BindPhonePresenterImpl bindPhonePresenter;
    private String uid;
    private String name;
    private String gender;
    private String iconurl;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_phone;
    }

    @Override
    protected void findViewById() {
        bindPhonePresenter = new BindPhonePresenterImpl(this);
        mBindPhone = (EditText) findViewById(R.id.mBindPhone);
        mInputUserName = (EditText) findViewById(R.id.mInputUserName);
        mBindPhoneName = (TextView) findViewById(R.id.mBindPhoneName);
        mInputPassword = (EditText) findViewById(R.id.mInputPassword);
        mBindPhoneHeadImg = (CircleImageView) findViewById(R.id.mBindPhoneHeadImg);
        mBindPhoneBack = (ImageView) findViewById(R.id.mBindPhoneBack);
        mBindPhoneBtn = (Button) findViewById(R.id.mBindPhoneBtn);
        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");
        name = intent.getStringExtra("name");
        gender = intent.getStringExtra("gender");
        iconurl = intent.getStringExtra("iconurl");
        mBindPhoneName.setText(name);
        Glide.with(BindPhoneActivity.this).load(iconurl).into(mBindPhoneHeadImg);
    }

    @Override
    protected void init() {

        mBindPhoneBack.setOnClickListener(this);
        mBindPhoneBtn.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void openProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBindPhoneBack:
                finish();
                break;
            case R.id.mBindPhoneBtn:
                String phone = mBindPhone.getText().toString().trim();
                String UserName = mInputUserName.getText().toString().trim();
                String Password = mInputPassword.getText().toString().trim();


                    bindPhonePresenter.thirdregister(phone,UserName,Password,iconurl,uid);

                break;
        }
    }

    @Override
    public void register(RegisterBean registerBean) {
        if(registerBean.isRet() == true){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
        }
    }
}
