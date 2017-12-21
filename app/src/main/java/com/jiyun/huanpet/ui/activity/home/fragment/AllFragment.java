package com.jiyun.huanpet.ui.activity.home.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.indentpresenter.IIndentpresenter;
import com.jiyun.huanpet.presenter.indentpresenter.Indentpresenter;
import com.jiyun.huanpet.ui.activity.home.adapter.petadpter.AdapterListview;
import com.jiyun.huanpet.ui.activity.home.bean.AllAtiity;
import com.jiyun.huanpet.ui.activity.userparticularsactivity.ConfirmedActivity;
import com.jiyun.huanpet.ui.base.BaseFragment;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Lenovo on 2017/12/14.
 */

public class AllFragment extends BaseFragment<Indentpresenter> implements IIndentpresenter.View{
    private ListView List_view;
    private AdapterListview adapterListview;
    private ArrayList<AllAtiity> mArr=new ArrayList<>();
    private SharedPreferences preferences;
    private AllAtiity allAtiity;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_all;
    }

    @Override
    protected void findViewById(View view) {
        List_view=view.findViewById(R.id.List_view);
        List_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getContext(), ConfirmedActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void init() {
        Bundle arguments = getArguments();
        String mTilte = arguments.getString("mTilte");
        preferences =getContext().getSharedPreferences("Login", MODE_PRIVATE);
        String userId = preferences.getString("userId", "");
        switch (mTilte){
            case "全部":
                if(mArr.size()==0){
                    for (int i = 1; i <6 ; i++) {
                       AllAtiity allAtiity = new AllAtiity();
                        allAtiity.setNameImage(R.mipmap.ic_launcher);
                        allAtiity.setPetImage(R.mipmap.ic_launcher);
                        allAtiity.setPinjieImage(R.mipmap.relate);
                        allAtiity.setWangeng("全部");
                        mArr.add(allAtiity);
                    }
                }
//              mPresenter.indent(userId,null);
                break;
            case "待确认":
                if(mArr.size()==0){
                    for (int i = 1; i <6 ; i++) {
                        allAtiity = new AllAtiity();
                        allAtiity.setNameImage(R.mipmap.ic_launcher);
                        allAtiity.setPetImage(R.mipmap.ic_launcher);
                        allAtiity.setPinjieImage(R.mipmap.relate);
                        allAtiity.setWangeng("待确认");
                        mArr.add(allAtiity);
                    }
                }
//                mPresenter.indent(userId,"25");

                break;
            case "寄养中":
                if(mArr.size()==0){
                    for (int i = 1; i <6 ; i++) {
                        allAtiity = new AllAtiity();
                        allAtiity.setNameImage(R.mipmap.ic_launcher);
                        allAtiity.setPetImage(R.mipmap.ic_launcher);
                        allAtiity.setPinjieImage(R.mipmap.relate);
                        allAtiity.setWangeng("寄养中");
                        mArr.add(allAtiity);
                    }
                }
//                mPresenter.indent(userId,"45");
                break;
            case "待评价":
                if(mArr.size()==0){
                    for (int i = 1; i <6 ; i++) {
                        allAtiity = new AllAtiity();
                        allAtiity.setNameImage(R.mipmap.ic_launcher);
                        allAtiity.setPetImage(R.mipmap.ic_launcher);
                        allAtiity.setPinjieImage(R.mipmap.relate);
                        allAtiity.setWangeng("待评价");
                        mArr.add(allAtiity);
                    }
                }

//                mPresenter.indent(userId,"35");
                break;
        }
        adapterListview=new AdapterListview(mArr,getContext());
        List_view.setAdapter(adapterListview);
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

}
