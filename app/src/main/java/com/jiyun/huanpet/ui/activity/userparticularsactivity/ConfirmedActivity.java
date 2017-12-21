package com.jiyun.huanpet.ui.activity.userparticularsactivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.indentpresenter.IIndentpresenter;
import com.jiyun.huanpet.presenter.indentpresenter.Indentpresenter;
import com.jiyun.huanpet.ui.base.BaseActivity;

/**
 * Created by Lenovo on 2017/12/19.
 */

public class ConfirmedActivity extends BaseActivity<Indentpresenter> implements IIndentpresenter.View, View.OnClickListener {
    private ImageView Graybak;
    private TextView Number;
    private ImageView Pet_head_portrait;
    private TextView Pet_Name;
    private ImageView Pet_sex;
    private TextView Pet_condition;
    private TextView Time;
    private ImageView User_head_portrait;
    private TextView User_tilte;
    private TextView User_Content;
    private TextView Indent_time;
    private TextView Indent_money;
    private TextView Handle_money;
    private TextView Agree;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_confirmed;
    }

    @Override
    protected void findViewById() {
        Graybak = (ImageView) findViewById(R.id.Graybak);
        Graybak.setOnClickListener(this);
        Number= (TextView) findViewById(R.id.Number);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
       mPresenter.particulars();
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
        switch (v.getId()) {
            case R.id.Graybak:
                finish();
                break;
        }
    }


}
