package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.HomeContract;
import com.jiyun.huanpet.presenter.presenter.HomePresenterImpl;
import com.jiyun.huanpet.ui.activity.home.bean.FuJinBean;
import com.jiyun.huanpet.ui.activity.home.bean.PetTypeBean;
import com.jiyun.huanpet.ui.base.BaseActivity;

import java.util.List;

public class UpdateUserNameActivity extends BaseActivity<HomePresenterImpl> implements View.OnClickListener,HomeContract.HomeView {
    private EditText Name;
    private ImageView Go_back;
    private TextView Submit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_user_name;
    }

    @Override
    protected void findViewById() {
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
                String name = Name.getText().toString().trim();
                String date=Name.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("date",date);
                setResult(2000, intent);
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
}
