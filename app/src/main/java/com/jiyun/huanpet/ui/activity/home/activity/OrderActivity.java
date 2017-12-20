package com.jiyun.huanpet.ui.activity.home.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.indentpresenter.IIndentpresenter;
import com.jiyun.huanpet.presenter.indentpresenter.Indentpresenter;
import com.jiyun.huanpet.ui.activity.home.adapter.petadpter.AdapterViewpager;
import com.jiyun.huanpet.ui.activity.home.fragment.AffirmFragment;
import com.jiyun.huanpet.ui.activity.home.fragment.AllFragment;
import com.jiyun.huanpet.ui.activity.home.fragment.BoardFragment;
import com.jiyun.huanpet.ui.activity.home.fragment.Evaluatefragment;
import com.jiyun.huanpet.ui.base.BaseActivity;

import java.util.ArrayList;
//订单
public class OrderActivity extends BaseActivity<Indentpresenter> implements IIndentpresenter.View {
    private TabLayout Tavlayout_order;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPager Viewpager;
    private AdapterViewpager viewpager;
    private ImageView Back_go;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void findViewById() {
        Tavlayout_order = (TabLayout) findViewById(R.id.Tavlayout_order);
        Viewpager = (ViewPager) findViewById(R.id.Viewpager);
        Back_go= (ImageView) findViewById(R.id.Back_go);
        Back_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Tavlayout_order.addTab(Tavlayout_order.newTab().setText("全部"));
        Tavlayout_order.addTab(Tavlayout_order.newTab().setText("待确认"));
        Tavlayout_order.addTab(Tavlayout_order.newTab().setText("寄养中"));
        Tavlayout_order.addTab(Tavlayout_order.newTab().setText("待评价"));
        fragments.add(new AllFragment());
        fragments.add(new AffirmFragment());
        fragments.add(new BoardFragment());
        fragments.add(new Evaluatefragment());
        viewpager=new AdapterViewpager(getSupportFragmentManager(),fragments);
        Viewpager.setAdapter(viewpager);
        Tavlayout_order.getTabAt(0).setTag("全部");
        Tavlayout_order.getTabAt(1).setTag("待确认");
        Tavlayout_order.getTabAt(2).setTag("寄养中");
        Tavlayout_order.getTabAt(3).setTag("待评价");
    }


    @Override
    protected void init() {

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

