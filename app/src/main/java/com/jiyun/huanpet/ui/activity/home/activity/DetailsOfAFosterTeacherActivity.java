package com.jiyun.huanpet.ui.activity.home.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.DetailsOfAFosterTeacherContract;
import com.jiyun.huanpet.presenter.presenter.DetailsOfAFosterTeacherPresenter;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.youth.banner.Banner;

public class DetailsOfAFosterTeacherActivity extends BaseActivity<DetailsOfAFosterTeacherPresenter> implements View.OnClickListener,
        DetailsOfAFosterTeacherContract.DetailsOfAFosterTeacherView{

    private ImageView ign_out;
    private Banner banner;
    private ImageView headPortrait;
    private TextView name;
    private CheckBox imageView2;
    private CheckBox imageView5;
    private CheckBox imageView4;
    private CheckBox imageView3;
    private ImageView imageView6;
    private TextView textView16;
    private TextView textView17;
    private TextView number;
    private TextView textView19;
    private ImageView enter_a_review;
    private ImageView imageView;
    private TextView daPrice;
    private ImageView zhongimageView;
    private TextView zhongPrice;
    private ImageView catimageView;
    private TextView catPrice;
    private ImageView showerImg;
    private TextView daTake_a_showerPrice;
    private ImageView zhongbathe;
    private TextView zhong_Take_a_showerPrice;
    private ImageView xiaoBathe;
    private TextView xiao_Take_a_showerPrice;
    private ImageView shuttle;
    private TextView Shuttle_cat_Price;
    private ImageView xiaoShuttle;
    private TextView Study;
    private ImageView jiaAddress;
    private TextView address;
    private TextView briefIntroduction;
    private LinearLayout Contact_him;
    private Button makeAnAappointment;
    private CheckBox imageView7;
    private View inflate;
    private PopupWindow pop;
    private RelativeLayout dial;
    private RelativeLayout send_message;
    private String phone;
    private TextView pop_cancel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_of_afoster_teacher;
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void findViewById() {
        ign_out = (ImageView) findViewById(R.id.ign_out);
        ign_out.setOnClickListener(this);
        banner = (Banner) findViewById(R.id.banner);
        headPortrait = (ImageView) findViewById(R.id.headPortrait);
        name = (TextView) findViewById(R.id.name);
        imageView2 = (CheckBox) findViewById(R.id.imageView2);
        imageView5 = (CheckBox) findViewById(R.id.imageView5);
        imageView4 = (CheckBox) findViewById(R.id.imageView4);
        imageView3 = (CheckBox) findViewById(R.id.imageView3);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 = (TextView) findViewById(R.id.textView17);
        number = (TextView) findViewById(R.id.number);
        textView19 = (TextView) findViewById(R.id.textView19);
        enter_a_review = (ImageView) findViewById(R.id.enter_a_review);
        imageView = (ImageView) findViewById(R.id.imageView);
        daPrice = (TextView) findViewById(R.id.daPrice);
        zhongimageView = (ImageView) findViewById(R.id.zhongimageView);
        zhongPrice = (TextView) findViewById(R.id.zhongPrice);
        catimageView = (ImageView) findViewById(R.id.catimageView);
        catPrice = (TextView) findViewById(R.id.catPrice);
        showerImg = (ImageView) findViewById(R.id.showerImg);
        daTake_a_showerPrice = (TextView) findViewById(R.id.daTake_a_showerPrice);
        zhongbathe = (ImageView) findViewById(R.id.zhongbathe);
        zhong_Take_a_showerPrice = (TextView) findViewById(R.id.zhong_Take_a_showerPrice);
        xiaoBathe = (ImageView) findViewById(R.id.xiaoBathe);
        xiao_Take_a_showerPrice = (TextView) findViewById(R.id.xiao_Take_a_showerPrice);
        shuttle = (ImageView) findViewById(R.id.shuttle);
        Shuttle_cat_Price = (TextView) findViewById(R.id.Shuttle_cat_Price);
        xiaoShuttle = (ImageView) findViewById(R.id.xiaoShuttle);
        Study = (TextView) findViewById(R.id.Study);
        jiaAddress = (ImageView) findViewById(R.id.jiaAddress);
        address = (TextView) findViewById(R.id.address);
        briefIntroduction = (TextView) findViewById(R.id.briefIntroduction);
        Contact_him = (LinearLayout) findViewById(R.id.Contact_him);
        Contact_him.setOnClickListener(this);
        makeAnAappointment = (Button) findViewById(R.id.makeAnAappointment);
        imageView7 = (CheckBox) findViewById(R.id.imageView7);
        inflate = getLayoutInflater().inflate(R.layout.contact, null);
        dial = inflate.findViewById(R.id.dial);
        dial.setOnClickListener(this);
        send_message = inflate.findViewById(R.id.send_message);
        send_message.setOnClickListener(this);
        pop_cancel = inflate.findViewById(R.id.pop_cancel);
        pop_cancel.setOnClickListener(this);
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ign_out:
                finish();
                break;
            case R.id.banner:
                break;
            case R.id.headPortrait:
                break;
            case R.id.imageView2:
                break;
            case R.id.imageView3:
                break;
            case R.id.imageView4:
                break;
            case R.id.imageView5:
                break;
            case R.id.imageView6:
                break;
            case R.id.imageView7:
                break;
            case R.id.Contact_him:
                pop = new PopupWindow(inflate,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        true);
                pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                pop.showAtLocation(findViewById(R.id.Contact_him), Gravity.NO_GRAVITY, 0, 0);
                startAlphAnimotion();

                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });
                break;
            case R.id.makeAnAappointment:
                break;
            case R.id.dial:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
            case R.id.send_message:

                break;
            case R.id.pop_cancel:
                pop.dismiss();
                break;
        }
    }
    //改变屏幕透明度
    public void startAlphAnimotion() {
        WindowManager.LayoutParams ll = getWindow().getAttributes();
        ll.alpha = 0.7f;
        getWindow().setAttributes(ll);
    }


    //恢复屏幕透明度
    public void endAlphAnimotion() {
        WindowManager.LayoutParams ll = getWindow().getAttributes();
        ll.alpha = 1;
        getWindow().setAttributes(ll);
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
