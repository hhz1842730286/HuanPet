package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.HomeContract;
import com.jiyun.huanpet.presenter.presenter.HomePresenterImpl;
import com.jiyun.huanpet.ui.activity.home.bean.ForgetPassWordBean;
import com.jiyun.huanpet.ui.activity.home.bean.FuJinBean;
import com.jiyun.huanpet.ui.activity.home.bean.PetTypeBean;
import com.jiyun.huanpet.ui.base.BaseActivity;

import java.util.List;

public class UpdateUserNameActivity extends BaseActivity<HomePresenterImpl> implements View.OnClickListener,HomeContract.HomeView {
    private EditText Name;
    private ImageView Go_back;
    private TextView Submit;
    private Context mCon;
    private SharedPreferences preferences;
    private HomePresenterImpl homePresenter;
    private SharedPreferences.Editor edit;
    private String name;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_user_name;
    }

    @Override
    protected void findViewById() {
        mCon = UpdateUserNameActivity.this;
        homePresenter = new HomePresenterImpl(this);
        preferences = mCon.getSharedPreferences("Login",MODE_PRIVATE);
        edit = preferences.edit();
        Name = (EditText) findViewById(R.id.Name);
        Go_back = (ImageView) findViewById(R.id.Go_back);
        Go_back.setOnClickListener(this);
        Submit= (TextView) findViewById(R.id.Submit);
        Submit.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Submit:
                String userId = preferences.getString("userId","");
                name = Name.getText().toString().trim();
                homePresenter.updatename(userId, name);

                finish();
                break;
            case R.id.Go_back:
                finish();
                break;

        }
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
    public void fujinview(List<FuJinBean.DescBean> fuJinBean) {

    }

    @Override
    public void petType(List<PetTypeBean.DescBean> descBeans) {

    }

    @Override
    public void updataname(ForgetPassWordBean bean) {
        if(bean.isRet() == true){
            edit.putString("userName",name);
            edit.commit();
            Toast.makeText(mCon, "修改名字成功", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(mCon, "修改名字失败", Toast.LENGTH_SHORT).show();
        }
    }
}
