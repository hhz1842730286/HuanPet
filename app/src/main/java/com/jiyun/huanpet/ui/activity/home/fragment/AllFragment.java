package com.jiyun.huanpet.ui.activity.home.fragment;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.config.Urls;
import com.jiyun.huanpet.httputils.CJSON;
import com.jiyun.huanpet.presenter.indentpresenter.IIndentpresenter;
import com.jiyun.huanpet.presenter.indentpresenter.Indentpresenter;
import com.jiyun.huanpet.ui.activity.home.adapter.petadpter.AdapterListview;
import com.jiyun.huanpet.ui.base.BaseFragment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Lenovo on 2017/12/14.
 */

public class AllFragment extends BaseFragment<Indentpresenter> implements IIndentpresenter.View {
    private ListView List_view;
    private AdapterListview adapterListview;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_all;
    }

    @Override
    protected void findViewById(View view) {
        List_view=view.findViewById(R.id.List_view);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
        preferences =getContext().getSharedPreferences("Login", MODE_PRIVATE);
        editor = preferences.edit();
        String userId = preferences.getString("userId", "");
        editor.commit();
//        mPresenters.indent(userId,0);
        Request.Builder builder = new Request.Builder();
        OkHttpClient build = new OkHttpClient.Builder().build();
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
       map.put("orderState","0");
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        bodyBuilder.add("data", CJSON.toJSONMap(map));
        Request request = builder.url(Urls.INDENT).post(bodyBuilder.build()).build();
        Call call = build.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("-----------",e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("tttttttttttt",string);
            }
        });
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
