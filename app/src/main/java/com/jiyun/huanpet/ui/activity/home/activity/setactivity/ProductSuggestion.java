package com.jiyun.huanpet.ui.activity.home.activity.setactivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.config.Urls;
import com.jiyun.huanpet.httputils.CJSON;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.net.OkHttpUtils;
import com.jiyun.huanpet.presenter.presenter.HomePresenterImpl;
import com.jiyun.huanpet.ui.activity.home.bean.Productbane;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.jiyun.huanpet.utils.AppUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2017/12/17.
 */

public class ProductSuggestion extends BaseActivity<HomePresenterImpl> implements View.OnClickListener {
    private ImageView Back;
    private Button Send;
    private EditText Edit_Text;

    @Override
    protected int getLayoutId() {
        return R.layout.productsuggestion;
    }

    @Override
    protected void findViewById() {
        Edit_Text = (EditText) findViewById(R.id.Edit_Text);
        Back= (ImageView) findViewById(R.id.Back);
        Send= (Button) findViewById(R.id.Send);
    }

    @Override
    protected void init() {
        Back.setOnClickListener(this);
        Send.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Back:
                finish();
                break;
            case R.id.Send:
                String userid = AppUtils.userInfo.getUserId();
                String username = AppUtils.userInfo.getUserName();
                String trim = Edit_Text.getText().toString().trim();
                updatedata(userid,username,trim);
                break;

        }
    }
    private void updatedata(String userid, String username, String suggest){
        Productbane productbane=new Productbane();
        productbane.setUserId(userid);
        productbane.setUserName(username);
        productbane.setSuggest(suggest);
        final String json = CJSON.toJSONEntity(suggest);
        Map<String, Object> map=new HashMap<>();
        map.put(CJSON.DATA, json);
        OkHttpUtils.getInstance().post(Urls.REQUESTURL+"user/suggest/saveUserSuggest.jhtml",map, new HttpCallback<Productbane>() {
            @Override
            public void success(Productbane productbane) {
                if (CJSON.getRET(json)) {
                    Toast.makeText(ProductSuggestion.this, "修改成功!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            @Override
            public void error(String error) {
                Toast.makeText(ProductSuggestion.this, "修改失败!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
