package com.jiyun.huanpet.ui.activity.home.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.indentpresenter.IIndentpresenter;
import com.jiyun.huanpet.presenter.indentpresenter.Indentpresenter;
import com.jiyun.huanpet.ui.activity.home.adapter.petadpter.AdapterViewpager;
import com.jiyun.huanpet.ui.activity.home.fragment.AllFragment;
import com.jiyun.huanpet.ui.base.BaseActivity;

import java.util.ArrayList;
//订单
public class OrderActivity extends BaseActivity<Indentpresenter> implements IIndentpresenter.View {
    private TabLayout Tavlayout_order;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPager Viewpager;
    private AdapterViewpager viewpager;
    private ImageView Back_go;
    private ArrayList<String> mTilte;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void findViewById() {
        Tavlayout_order = (TabLayout) findViewById(R.id.Tavlayout_order);
        Viewpager = (ViewPager) findViewById(R.id.Viewpager);
        Back_go= (ImageView) findViewById(R.id.Back_go);
        mTilte=new ArrayList<>();
        mTilte.add("全部");
        mTilte.add("待确认");
        mTilte.add("寄养中");
        mTilte.add("待评价");
        for (int i = 0; i <mTilte.size() ; i++) {
            AllFragment allFragment=new AllFragment();
            Bundle bundle=new Bundle();
            bundle.putString("mTilte",mTilte.get(i));
            fragments.add(allFragment);
            allFragment.setArguments(bundle);
        }
        Tavlayout_order.setupWithViewPager(Viewpager);
        viewpager=new AdapterViewpager(getSupportFragmentManager(),fragments,mTilte);
        Viewpager.setAdapter(viewpager);
    }


    @Override
    protected void init() {
        Back_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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

