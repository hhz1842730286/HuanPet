package com.jiyun.huanpet.ui.activity.home.activity;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.HomeContract;
import com.jiyun.huanpet.presenter.presenter.HomePresenterImpl;
import com.jiyun.huanpet.ui.activity.home.bean.ForgetPassWordBean;
import com.jiyun.huanpet.ui.activity.home.bean.FuJinBean;
import com.jiyun.huanpet.ui.activity.home.bean.PetTypeBean;
import com.jiyun.huanpet.ui.base.BaseActivity;

import java.util.List;

public class PetTypeActivity extends BaseActivity<HomePresenterImpl>implements HomeContract.HomeView{


    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet_type;
    }

    @Override
    protected void findViewById() {

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


    @Override
    public void fujinview(List<FuJinBean.DescBean> fuJinBean) {

    }

    @Override
    public void petType(List<PetTypeBean.DescBean> descBeans) {

    }

    @Override
    public void updataname(ForgetPassWordBean bean) {

    }
}
