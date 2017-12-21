package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Intent;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.homedetails.DetailsPresenter;
import com.jiyun.huanpet.ui.activity.home.bean.HomeDetailsBean;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.jiyun.huanpet.view.DetailsView;

import java.util.List;

/**
 * Created by lh on 2017/12/21.
 */

public class HomeDetailsActivity extends BaseActivity<DetailsPresenter> implements DetailsView{

    private String usersId;
    private DetailsPresenter detailsPresenter;
     private TextView number,name,daPrice,zhongPrice,catPrice,daTake_a_showerPrice,zhong_Take_a_showerPrice,Shuttle_cat_Price,Study,addresss,briefIntroduction;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_of_afoster_teacher;
    }

    @Override
    protected void findViewById() {
        detailsPresenter = new DetailsPresenter(this);
        Intent intent = getIntent();
        usersId = intent.getStringExtra("usersId");
        number = (TextView) findViewById(R.id.number);
        name = (TextView) findViewById(R.id.name);
        daPrice = (TextView) findViewById(R.id.daPrice);
        zhongPrice = (TextView) findViewById(R.id.zhongPrice);
        catPrice = (TextView) findViewById(R.id.catPrice);
        daTake_a_showerPrice = (TextView) findViewById(R.id.daTake_a_showerPrice);
        zhong_Take_a_showerPrice = (TextView) findViewById(R.id.zhong_Take_a_showerPrice);
        Shuttle_cat_Price = (TextView) findViewById(R.id.Shuttle_cat_Price);
        Study = (TextView) findViewById(R.id.Study);
        addresss = (TextView) findViewById(R.id.address);
        briefIntroduction = (TextView) findViewById(R.id.briefIntroduction);
    }

    @Override
    protected void init() {
        detailsPresenter.details(usersId);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void details(HomeDetailsBean homeDetailsBean) {
        HomeDetailsBean.DescBean desc = homeDetailsBean.getDesc();
        int fosterCommentCount = desc.getFosterCommentCount();
        number.setText(fosterCommentCount+"");
        List<HomeDetailsBean.DescBean.FosterServicesBean> fosterServices = desc.getFosterServices();
        for(int i = 0;i<fosterServices.size();i++){
            if(i == 0){
                String petPrice = fosterServices.get(i).getPetPrice();
                daPrice.setText(petPrice);
            }else if(i == 1){
                String petPrice = fosterServices.get(i).getPetPrice();
                zhongPrice.setText(petPrice);
            }else if(i == 2){
                String petPrice = fosterServices.get(i).getPetPrice();
                catPrice.setText(petPrice);
            }
        }

        List<HomeDetailsBean.DescBean.FosterOtherServicesBean> fosterOtherServices = desc.getFosterOtherServices();
        for(int j = 0;j<fosterOtherServices.size();j++){
             if(j == 0){
                 String servicePrice = fosterOtherServices.get(j).getServicePrice();
                 daTake_a_showerPrice.setText(servicePrice);
             }else if(j == 1){
                 String servicePrice = fosterOtherServices.get(j).getServicePrice();
                 zhong_Take_a_showerPrice.setText(servicePrice);
             }else if(j == 2){
                 String servicePrice = fosterOtherServices.get(j).getServicePrice();
                 Shuttle_cat_Price.setText(servicePrice);
             }else if(j == 3){
                 String servicePrice = fosterOtherServices.get(j).getServicePrice();
                 Study.setText(servicePrice);
             }
        }

        String address = desc.getFosterInfo().getAddress();
         addresss.setText(address);
        String intro = desc.getFosterInfo().getIntro();
        briefIntroduction.setText(intro);

        String userName = desc.getFosterInfo().getUserName();
        name.setText(userName);
    }
}