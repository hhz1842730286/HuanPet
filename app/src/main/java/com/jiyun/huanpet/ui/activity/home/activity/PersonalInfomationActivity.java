package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.PersonalInfomationContract;
import com.jiyun.huanpet.presenter.presenter.PersonalInfomationPresenterImpl;
import com.jiyun.huanpet.ui.base.BaseActivity;

import static android.R.attr.x;
import static com.jiyun.huanpet.constants.Constants.REQUESTCODE;

/**
 * Created by mengYao on 2017/12/11.
 */

public class PersonalInfomationActivity extends BaseActivity<PersonalInfomationPresenterImpl> implements PersonalInfomationContract.PersonalInfomationView, View.OnClickListener {

    private ImageView personal_return;
    private RelativeLayout head_portrait;
    private RelativeLayout mPersonalUserName;
    private RelativeLayout mPersonalSex;
    private RelativeLayout mDataOfBirth;
    private RelativeLayout mPersonalPhone;
    private RelativeLayout mPersonalWx;
    private RelativeLayout mPersonalQq;
    private RelativeLayout mContractAddress;
    private final int requestCode=100;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_infomation;
    }

    @Override
    protected void findViewById() {
        personal_return = (ImageView) findViewById(R.id.personal_return);
        head_portrait = (RelativeLayout) findViewById(R.id.head_portrait);
        mPersonalUserName = (RelativeLayout) findViewById(R.id.mPersonalUserName);
        mPersonalSex = (RelativeLayout) findViewById(R.id.mPersonalSex);
        mDataOfBirth = (RelativeLayout) findViewById(R.id.mDataOfBirth);
        mPersonalPhone = (RelativeLayout) findViewById(R.id.mPersonalPhone);
        mPersonalWx = (RelativeLayout) findViewById(R.id.mPersonalWx);
        mPersonalQq = (RelativeLayout) findViewById(R.id.mPersonalQq);
        mContractAddress = (RelativeLayout) findViewById(R.id.mContractAddress);
    }

    @Override
    protected void init() {
        personal_return.setOnClickListener(this);
        head_portrait.setOnClickListener(this);
        mPersonalUserName.setOnClickListener(this);
        mPersonalSex.setOnClickListener(this);
        mDataOfBirth.setOnClickListener(this);
        mPersonalPhone.setOnClickListener(this);
        mPersonalWx.setOnClickListener(this);
        mPersonalQq.setOnClickListener(this);
        mContractAddress.setOnClickListener(this);
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
            case R.id.personal_return:
                finish();
                break;
            case R.id.head_portrait:

                break;
            case R.id.mPersonalUserName:
                startActivityForResult(new Intent(this,UpdateUserNameActivity.class),REQUESTCODE);
                break;
            case R.id.mPersonalSex:

                break;
            case R.id.mDataOfBirth:

                break;
            case R.id.mPersonalPhone:

                break;
            case R.id.mPersonalWx:

                break;
            case R.id.mPersonalQq:

                break;
            case R.id.mContractAddress:
                startActivityForResult(new Intent(this,UpdateAddressActivity.class),requestCode);
                break;
        }
    }
}
