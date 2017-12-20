package com.jiyun.huanpet.ui.activity.home.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.presenter.HomePresenterImpl;
import com.jiyun.huanpet.ui.activity.home.activity.setactivity.ProductSuggestion;
import com.jiyun.huanpet.ui.activity.login.LoginActivity;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.jiyun.huanpet.utils.utilspet.HttpCacheUtils;

public class SettingActivity extends BaseActivity<HomePresenterImpl> implements View.OnClickListener {
    private ImageView Back_return;
    private RelativeLayout Product;
    private RelativeLayout New_function;
    private RelativeLayout Praise;
    private RelativeLayout Know;
    private CheckBox Wifi;
    private RelativeLayout Cache;
    private RelativeLayout Clear;
    private Button Quit;
    private TextView File;
    private Context context=this;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void findViewById() {
        Back_return = (ImageView) findViewById(R.id.Back_return);
        Product = (RelativeLayout) findViewById(R.id.Product);
        New_function = (RelativeLayout) findViewById(R.id.New_function);
        Praise = (RelativeLayout) findViewById(R.id.Praise);
        Know = (RelativeLayout) findViewById(R.id.Know);
        Wifi= (CheckBox) findViewById(R.id.Wifi);
        Cache= (RelativeLayout) findViewById(R.id.Cache);
        Clear= (RelativeLayout) findViewById(R.id.Clear);
        Quit= (Button) findViewById(R.id.Quit);
        File= (TextView) findViewById(R.id.File);
    }

    @Override
    protected void init() {
        Back_return.setOnClickListener(this);
        Product.setOnClickListener(this);
        New_function.setOnClickListener(this);
        Praise.setOnClickListener(this);
        Know.setOnClickListener(this);
        Cache.setOnClickListener(this);
        Clear.setOnClickListener(this);
        Quit.setOnClickListener(this);

        Wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(SettingActivity.this, "仅在wifi情况下显示图片", Toast.LENGTH_SHORT).show();
                    SharedPreferences spf = context.getSharedPreferences(
                            "Image_load", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = spf.edit();
                    edit.putBoolean("lv", true).commit();
                } else {

                    Toast.makeText(context, "无wifi的情况下也可以显示图片", Toast.LENGTH_SHORT).show();
                    SharedPreferences spf = context.getSharedPreferences(
                            "Image_load", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = spf.edit();
                    edit.putBoolean("lv", false).commit();
                }
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Back_return:
                finish();
                break;
            case R.id.Product:
                startActivity(new Intent(SettingActivity.this, ProductSuggestion.class));
                break;
            case R.id.New_function:
                Toast.makeText(this, "没有效果图", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Praise:
                Toast.makeText(this, "没有效果图", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Know:
                Toast.makeText(this, "没有效果图", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Cache:
                try {
                    HttpCacheUtils.getTotalCacheSize(SettingActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.Clear:
                new AlertDialog.Builder(SettingActivity.this)
                        .setTitle("系统提示")
                        .setMessage("确定要清除吗?")
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {// 添加确定按钮
                                    public void onClick(DialogInterface dialog,
                                                        int which) {// 确定按钮的响应事件
                                        HttpCacheUtils.clearAllCache(SettingActivity.this);// 清楚缓存
                                        Toast.makeText(context, "清除成功", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("再想想",
                                new DialogInterface.OnClickListener() {// 添加返回按钮
                                    public void onClick(DialogInterface dialog,
                                                        int which) {// 响应事件
                                        dialog.dismiss();
                                    }
                                }).show();
                break;
            case R.id.Quit:
                Intent intent=new Intent(SettingActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

}
