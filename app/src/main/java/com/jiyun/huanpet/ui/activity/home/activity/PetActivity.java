package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.petpresenter.IPetContract;
import com.jiyun.huanpet.presenter.petpresenter.Petpresenter;
import com.jiyun.huanpet.ui.activity.home.adapter.petadpter.PetListAdapter;
import com.jiyun.huanpet.ui.activity.home.bean.Petadd;
import com.jiyun.huanpet.ui.base.BaseActivity;

import java.util.ArrayList;

public class PetActivity extends BaseActivity<Petpresenter> implements View.OnClickListener,IPetContract.View {

    private ImageView Go_back;
    private ListView List_item;
    private RelativeLayout MyPet;
    private PetListAdapter listAdapter;
    private ArrayList<Petadd> mArr=new ArrayList<>();
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet;
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected void init() {
        Go_back = (ImageView) findViewById(R.id.Go_back);
        Go_back.setOnClickListener(this);
        List_item = (ListView) findViewById(R.id.List_item);
        MyPet= (RelativeLayout) findViewById(R.id.MyPet);
        MyPet.setOnClickListener(this);
        listAdapter=new PetListAdapter(PetActivity.this,mArr);
        List_item.setAdapter(listAdapter);
    }

    @Override
    protected void loadData() {
        preferences =PetActivity.this.getSharedPreferences("Login", MODE_PRIVATE);
        editor = preferences.edit();
        String userId = preferences.getString("userId", null);
        editor.commit();
        mPresenter.pet(userId);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Go_back:
                finish();
                break;
            case R.id.MyPet:
                startActivity(new Intent(PetActivity.this,AddPetActivity.class));
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
}
