package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.HomeContract;
import com.jiyun.huanpet.presenter.presenter.HomePresenterImpl;
import com.jiyun.huanpet.ui.activity.home.adapter.HomeAdapter;
import com.jiyun.huanpet.ui.activity.home.adapter.HomePetAdapter;
import com.jiyun.huanpet.ui.activity.home.adapter.NearbyAdapter;
import com.jiyun.huanpet.ui.activity.home.bean.FuJinBean;
import com.jiyun.huanpet.ui.activity.home.bean.Person;
import com.jiyun.huanpet.ui.activity.home.bean.PetTypeBean;
import com.jiyun.huanpet.ui.activity.login.LoginActivity;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mengYao on 2017/12/8.
 */

public class HomeActivity extends BaseActivity<HomePresenterImpl> implements HomeContract.HomeView, View.OnClickListener,CompoundButton.OnCheckedChangeListener {
    private static final int REQUEST_CODE_PICK_CITY = 0;
    private RecyclerView home_recyclerview;
    private DrawerLayout drawer_layout;
    private CircleImageView mMenuHead;
    private ImageView mPersonalCenter;
    private TextView nearbytext;
    private RelativeLayout mMessageContainer;
    private RelativeLayout mPetContainer;
    private RelativeLayout mOrderContainer;
    private RelativeLayout mWalletContainer;
    private RelativeLayout mKonwContainer;
    private RelativeLayout mSettingContainer;
    private Button mBtnSwitchUser;
    private RelativeLayout mInfomation;
    private TextView mMenuName;
    private TextView mMenuPhone;
    private RelativeLayout mNoLoginContainer;
    private RelativeLayout nearby;
    private RelativeLayout pettype;
    private RelativeLayout screen;
    private Context mCon;
    private PopupWindow nearbyWindow;
    private ListView listView;
    private LinearLayout home_line;
    private View petView;
    private PopupWindow pettypeWindow;
    private PopupWindow screenWindow;

    private TextView Choosecity;
    private TextView Location;
    private CheckBox shower;
    private CheckBox Shuttle;
    private CheckBox NewDan;
    private CheckBox SpringFestival;
    private CheckBox QingmingFestival;
    private CheckBox LaborDay;
    private CheckBox DragonBoatFestival;
    private CheckBox AutumnFestival;
    private CheckBox NationalDay;
    private TextView Reset;
    private TextView Determine;
    private Boolean che = false;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private HomePresenterImpl homePresenter;
    private List<FuJinBean.DescBean> beans;
    private HomeAdapter adapter;
    private List<PetTypeBean.DescBean> petList;
    private HomePetAdapter petAdapter;
    private RecyclerView home_petrecyclerview;

    @Override
    protected int getLayoutId() {
        return R.layout.menu_layout;
    }

    @Override
    protected void findViewById() {
        mCon = HomeActivity.this;
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mPersonalCenter = (ImageView) findViewById(R.id.mPersonalCenter);
        mInfomation = (RelativeLayout) findViewById(R.id.mInfomation);
        mMenuHead = (CircleImageView) findViewById(R.id.mMenuHead);
        mMenuName = (TextView) findViewById(R.id.mMenuName);
        mMenuPhone = (TextView) findViewById(R.id.mMenuPhone);
        mMessageContainer = (RelativeLayout) findViewById(R.id.mMessageContainer);
        mPetContainer = (RelativeLayout) findViewById(R.id.mPetContainer);
        mOrderContainer = (RelativeLayout) findViewById(R.id.mOrderContainer);
        mWalletContainer = (RelativeLayout) findViewById(R.id.mWalletContainer);
        mKonwContainer = (RelativeLayout) findViewById(R.id.mKonwContainer);
        mSettingContainer = (RelativeLayout) findViewById(R.id.mSettingContainer);
        mBtnSwitchUser = (Button) findViewById(R.id.mBtnSwitchUser);
        mNoLoginContainer = (RelativeLayout) findViewById(R.id.mNoLoginContainer);
        nearbytext = (TextView) findViewById(R.id.nearbytext);
        nearby = (RelativeLayout) findViewById(R.id.nearby);
        pettype = (RelativeLayout) findViewById(R.id.pettype);
        screen = (RelativeLayout) findViewById(R.id.screen);

        home_line = (LinearLayout) findViewById(R.id.home_line);
        home_petrecyclerview = (RecyclerView) findViewById(R.id.home_petrecyclerview);


        homePresenter = new HomePresenterImpl(this);
        home_recyclerview = (RecyclerView) findViewById(R.id.home_recyclerview);

        beans = new ArrayList<>();
        adapter = new HomeAdapter(beans,mCon);
        home_recyclerview.addItemDecoration(new DividerItemDecoration(mCon,DividerItemDecoration.VERTICAL));
        home_recyclerview.setLayoutManager(new LinearLayoutManager(mCon));
        home_recyclerview.setAdapter(adapter);
        adapter.setOnclicklenter(new HomeAdapter.Onclick() {
            @Override
            public void oncli(View view, int position) {
                String usersId = beans.get(position).getUsersId();
                String userName = preferences.getString("userName","");
                if(userName!=null){
                    Intent in = new Intent(mCon,HomeDetailsActivity.class);
                    in.putExtra("usersId", usersId);
                    startActivity(in);
                }else{
                    Toast.makeText(mCon, "请先登陆", Toast.LENGTH_SHORT).show();
                }

            }
        });

        petList = new ArrayList<>();
        petAdapter = new HomePetAdapter(petList,mCon);
        home_petrecyclerview.addItemDecoration(new DividerItemDecoration(mCon,DividerItemDecoration.VERTICAL));
        home_petrecyclerview.setLayoutManager(new LinearLayoutManager(mCon));
        home_petrecyclerview.setAdapter(adapter);
        home_petrecyclerview.setAdapter(petAdapter);


        preferences = mCon.getSharedPreferences("Login",MODE_PRIVATE);
        editor = preferences.edit();
        long userPhone = preferences.getLong("userPhone", 0);
        String userName = preferences.getString("userName", "");
        if(userPhone!=0&userName!=null){
           mNoLoginContainer.setVisibility(View.GONE);
//            mInfomation.setVisibility(View.VISIBLE);
            mMenuHead.setImageResource(R.mipmap.ic_launcher_round);
            mMenuName.setText(userName);
            mMenuPhone.setText(userPhone+"");
        }else{
//            mNoLoginContainer.setVisibility(View.VISIBLE);
            mInfomation.setVisibility(View.GONE);
        }

        View nearbyview = LayoutInflater.from(mCon).inflate(R.layout.nearbywindow, null);
        nearbyWindow = new PopupWindow(nearbyview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nearbyWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        nearbyWindow.setOutsideTouchable(true);
        listView = nearbyview.findViewById(R.id.nearbylistview);
        final List<Person> list = new ArrayList<>();
        list.add(new Person("附近优先"));
        list.add(new Person("好评优先"));
        list.add(new Person("订单优先"));
        list.add(new Person("价格从高到低"));
        list.add(new Person("价格从低到高"));
        final NearbyAdapter adapter = new NearbyAdapter(mCon, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            int currentNum = -1;

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                beans.clear();
                String title = list.get(position).getTitle();
                nearbytext.setText(title);
                if(title.equals("附近优先")){
                    homePresenter.fujinurl("0","40.116384","116.250374","10","distance asc");
                }else if (title.equals("好评优先")){
                    homePresenter.fujinurl("0","40.116384","116.250374","10","score desc");
                }else if(title.equals("订单优先")){
                    homePresenter.fujinurl("0","40.116384","116.250374","10","orderCount desc");
                }else if (title.equals("价格从高到低")){
                    homePresenter.fujinurl("0","40.116384","116.250374","10","price asc");
                }else if(title.equals("价格从低到高")){
                    homePresenter.fujinurl("0","40.116384","116.250374","10","price desc");
                }
                for (Person person : list) { //遍历list集合中的数据
                    person.setChecked(false);//全部设为未选中
                }
                if (currentNum == -1) { //选中
                    list.get(position).setChecked(true);
                    currentNum = position;
                } else if (currentNum == position) { //同一个item选中变未选中
                    for (Person person : list) {
                        person.setChecked(false);
                    }
                    currentNum = -1;
                } else if (currentNum != position) { //不是同一个item选中当前的，去除上一个选中的
                    for (Person person : list) {
                        person.setChecked(false);
                    }
                    list.get(position).setChecked(true);
                    currentNum = position;
                }
                adapter.notifyDataSetChanged();
            }
        });
        View petView = LayoutInflater.from(mCon).inflate(R.layout.nearbywindow, null);
        pettypeWindow = new PopupWindow(petView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pettypeWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        pettypeWindow.setOutsideTouchable(true);
        final ListView petlistview = petView.findViewById(R.id.nearbylistview);
        final List<Person> pet = new ArrayList<>();
        pet.add(new Person("小型犬"));
        pet.add(new Person("中型犬"));
        pet.add(new Person("大型犬"));
        pet.add(new Person("猫"));
        pet.add(new Person("小宠"));
        pet.add(new Person("幼犬"));
        final NearbyAdapter petadapter = new NearbyAdapter(mCon, pet);
        petlistview.setAdapter(petadapter);
        petlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            int currentNum = -1;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                petList.clear();
                homePresenter.petType("0","10","");

                for (Person person : pet) { //遍历list集合中的数据
                    person.setChecked(false);//全部设为未选中
                }
                if (currentNum == -1) { //选中
                    pet.get(position).setChecked(true);
                    currentNum = position;
                } else if (currentNum == position) { //同一个item选中变未选中
                    for (Person person : pet) {
                        person.setChecked(false);
                    }
                    currentNum = -1;
                } else if (currentNum != position) { //不是同一个item选中当前的，去除上一个选中的
                    for (Person person : pet) {
                        person.setChecked(false);
                    }
                    pet.get(position).setChecked(true);
                    currentNum = position;
                }
                petadapter.notifyDataSetChanged();
            }
        });
        View screenView = LayoutInflater.from(mCon).inflate(R.layout.screenwindow, null);
        screenWindow = new PopupWindow(screenView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        screenWindow.setOutsideTouchable(true);
        screenWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        Choosecity = screenView.findViewById(R.id.Choosecity);
        Location = screenView.findViewById(R.id.Location);

        shower = screenView.findViewById(R.id.shower);
        Shuttle = screenView.findViewById(R.id.Shuttle);
        NewDan = screenView.findViewById(R.id.NewDan);
        SpringFestival = screenView.findViewById(R.id.SpringFestival);
        QingmingFestival = screenView.findViewById(R.id.QingmingFestival);
        LaborDay = screenView.findViewById(R.id.LaborDay);
        DragonBoatFestival = screenView.findViewById(R.id.DragonBoatFestival);
        AutumnFestival = screenView.findViewById(R.id.AutumnFestival);
        NationalDay = screenView.findViewById(R.id.NationalDay);

        Reset = screenView.findViewById(R.id.Reset);
        Determine = screenView.findViewById(R.id.Determine);


    }

    @Override
    protected void init() {
        Choosecity.setOnClickListener(this);
        Determine.setOnClickListener(this);
        Reset.setOnClickListener(this);
        NationalDay.setOnCheckedChangeListener(this);
        AutumnFestival.setOnCheckedChangeListener(this);
        DragonBoatFestival.setOnCheckedChangeListener(this);
        LaborDay.setOnCheckedChangeListener(this);
        QingmingFestival.setOnCheckedChangeListener(this);
        SpringFestival.setOnCheckedChangeListener(this);
        NewDan.setOnCheckedChangeListener(this);
        shower.setOnCheckedChangeListener(this);
        Shuttle.setOnCheckedChangeListener(this);
        nearby.setOnClickListener(this);
        pettype.setOnClickListener(this);
        screen.setOnClickListener(this);
        mPersonalCenter.setOnClickListener(this);
        mInfomation.setOnClickListener(this);
        mMessageContainer.setOnClickListener(this);
        mPetContainer.setOnClickListener(this);
        mOrderContainer.setOnClickListener(this);
        mWalletContainer.setOnClickListener(this);
        mKonwContainer.setOnClickListener(this);
        mSettingContainer.setOnClickListener(this);
        mBtnSwitchUser.setOnClickListener(this);
        mNoLoginContainer.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        homePresenter.fujinurl("0","40.116384","116.250374","10","distance asc");
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
            case R.id.mPersonalCenter:
                if(drawer_layout.isDrawerOpen(Gravity.LEFT)){
                    drawer_layout.closeDrawer(Gravity.LEFT);

                }else {
                    drawer_layout.openDrawer(Gravity.LEFT);
                }

                break;
            case R.id.Choosecity:
                startActivityForResult(new Intent(mCon, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            case R.id.Determine:
                screenWindow.dismiss();
                break;
            case R.id.Reset:
                shower.setChecked(false);
                Shuttle.setChecked(false);
                NewDan.setChecked(false);
                SpringFestival.setChecked(false);
                QingmingFestival.setChecked(false);
                LaborDay.setChecked(false);
                DragonBoatFestival.setChecked(false);
                AutumnFestival.setChecked(false);
                NationalDay.setChecked(false);
                break;
            case R.id.nearby:
                home_recyclerview.setVisibility(View.VISIBLE);
                home_petrecyclerview.setVisibility(View.GONE);
                nearbyWindow.showAsDropDown(home_line);
                break;

            case R.id.pettype:
                home_petrecyclerview.setVisibility(View.VISIBLE);
                home_recyclerview.setVisibility(View.GONE);

                pettypeWindow.showAsDropDown(home_line);
                break;

            case R.id.screen:

                screenWindow.showAsDropDown(home_line);
                break;
            case R.id.mInfomation:
                startActivity(new Intent(this, PersonalInfomationActivity.class));
                break;
            case R.id.mMessageContainer:
                startActivity(new Intent(this, NewsActivity.class));
                break;
            case R.id.mPetContainer:
//                startActivity(new Intent(this, PetActivity.class));
                startActivity(new Intent(this,AddPetActivity.class));
                break;
            case R.id.mOrderContainer:
                startActivity(new Intent(this, OrderActivity.class));

                break;
            case R.id.mWalletContainer:
                startActivity(new Intent(this, WalletActivity.class));

                break;
            case R.id.mKonwContainer:
                startActivity(new Intent(this, KonwActivity.class));
                break;
            case R.id.mSettingContainer:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.mBtnSwitchUser:
                startActivity(new Intent(this, FosterteacherActivity.class));
                break;
            case R.id.mNoLoginContainer:
               Intent in = new Intent(this,LoginActivity.class);
               startActivity(in);
                break;
        }
    }




    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.shower:

                if (shower.isChecked()) {
                    shower.setBackgroundResource(R.drawable.login_btn_shape);
                } else {
                    shower.setBackgroundResource(R.drawable.login_item_shap);
                }
                break;
            case R.id.Shuttle:
                if (Shuttle.isChecked()) {
                    Shuttle.setBackgroundResource(R.drawable.login_btn_shape);
                } else {
                    Shuttle.setBackgroundResource(R.drawable.login_item_shap);
                }
                break;
            case R.id.NewDan:
                if (NewDan.isChecked()) {
                    NewDan.setBackgroundResource(R.drawable.login_btn_shape);
                } else {
                    NewDan.setBackgroundResource(R.drawable.login_item_shap);
                }
                break;
            case R.id.SpringFestival:
                if (SpringFestival.isChecked()) {
                    SpringFestival.setBackgroundResource(R.drawable.login_btn_shape);
                } else {
                    SpringFestival.setBackgroundResource(R.drawable.login_item_shap);
                }
                break;
            case R.id.QingmingFestival:
                if (QingmingFestival.isChecked()) {
                    QingmingFestival.setBackgroundResource(R.drawable.login_btn_shape);
                } else {
                    QingmingFestival.setBackgroundResource(R.drawable.login_item_shap);
                }
                break;
            case R.id.LaborDay:
                if (LaborDay.isChecked()) {
                    LaborDay.setBackgroundResource(R.drawable.login_btn_shape);
                } else {
                    LaborDay.setBackgroundResource(R.drawable.login_item_shap);
                }
                break;
            case R.id.DragonBoatFestival:
                if (DragonBoatFestival.isChecked()) {
                    DragonBoatFestival.setBackgroundResource(R.drawable.login_btn_shape);
                } else {
                    DragonBoatFestival.setBackgroundResource(R.drawable.login_item_shap);
                }
                break;

            case R.id.AutumnFestival:
                if (AutumnFestival.isChecked()) {
                    AutumnFestival.setBackgroundResource(R.drawable.login_btn_shape);
                } else {
                    AutumnFestival.setBackgroundResource(R.drawable.login_item_shap);
                }
                break;

            case R.id.NationalDay:

                if (NationalDay.isChecked()) {
                    NationalDay.setBackgroundResource(R.drawable.login_btn_shape);
                } else {
                    NationalDay.setBackgroundResource(R.drawable.login_item_shap);
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        long userPhone = preferences.getLong("userPhone", 0);
        String userName = preferences.getString("userName", "");
        String userImage = preferences.getString("userImage","");
        if(userPhone!=0&userName!=null){
            if(userImage!=null){
                Glide.with(mCon).load(userImage).into(mMenuHead);
            }else{
                mMenuHead.setImageResource(R.mipmap.ic_launcher_round);
            }
            mNoLoginContainer.setVisibility(View.GONE);
            mInfomation.setVisibility(View.VISIBLE);

            mMenuName.setText(userName);
            mMenuPhone.setText(userPhone+"");
        }else{
            mNoLoginContainer.setVisibility(View.VISIBLE);
            mInfomation.setVisibility(View.GONE);
        }
    }

    @Override
    public void fujinview(List<FuJinBean.DescBean> fuJinBean) {
        beans.clear();
        beans.addAll(fuJinBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void petType(List<PetTypeBean.DescBean> descBeans) {
        beans.clear();
        petList.addAll(descBeans);
        petAdapter.notifyDataSetChanged();
    }
}

