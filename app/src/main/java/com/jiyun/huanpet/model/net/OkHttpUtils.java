package com.jiyun.huanpet.model.net;

import android.os.Environment;
import android.os.Handler;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.api.HttpRequest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mengYao on 2017/12/8.
 */

public class OkHttpUtils implements HttpRequest{
    private static OkHttpUtils okHttpUtils;
    private OkHttpClient okHttpClient;
    private Handler handler=new Handler();
    private OkHttpUtils(){
        okHttpClient=new OkHttpClient
                .Builder()
                .cache(getCache())
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }
    public static OkHttpUtils getInstance(){
        if (okHttpUtils==null){
            synchronized (OkHttpUtils.class){
                if (okHttpUtils==null){
                    okHttpUtils=new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
    @Override
    public <T> void get(String url, Map<String, String> headers, Map<String, String> params, final HttpCallback<T> callback) {
        Request.Builder builder = new Request.Builder();
        if (headers==null||headers.size()==0){
            throw new NullPointerException("请求头不能为空");
        }
        if (params==null||params.size()==0){
            throw new NullPointerException("请求参数不能为空");
        }
        addHeader(builder,headers);
        url = mosicUrl(url, params);
        Request request = builder.url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(getGeneric(result,callback));
                    }
                });
            }
        });
    }

    @Override
    public <T> void get(String url, Map<String, String> headers, final HttpCallback<T> callback) {
        Request.Builder builder = new Request.Builder();
        if (headers==null||headers.size()==0){
            throw new NullPointerException("请求头不能为空");
        }
        addHeader(builder,headers);
        Request request = builder.url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(getGeneric(result,callback));
                    }
                });
            }
        });
    }

    @Override
    public <T> void get(String url, final HttpCallback<T> callback) {
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(getGeneric(result,callback));
                    }
                });
            }
        });
    }

    @Override
    public <T> void post(String url, Map<String, String> headers, Map<String, String> params, final HttpCallback<T> callback) {
        Request.Builder builder = new Request.Builder();
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if (headers==null||headers.size()==0){
            throw new NullPointerException("请求头不能为空");
        }
        if (params==null||params.size()==0){
            throw new NullPointerException("请求参数不能为空");
        }
        addHeader(builder,headers);
        addBody(bodyBuilder,params);
        Request request = builder.url(url).post(bodyBuilder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(getGeneric(result,callback));
                    }
                });
            }
        });
    }

    @Override
    public <T> void post(String url, Map<String, String> params, final HttpCallback<T> callback) {
        Request.Builder builder = new Request.Builder();
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if (params==null||params.size()==0){
            throw new NullPointerException("请求参数不能为空");
        }
        addBody(bodyBuilder,params);
        Request request = builder.url(url).post(bodyBuilder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.error(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.success(getGeneric(result,callback));
                    }
                });
            }
        });
    }
    private Cache getCache(){
        File file=new File(Environment.getExternalStorageDirectory()+"/Cache","responses");
        Cache cache = new Cache(file, 10 * 1024 * 1024);
        return cache;
    }
    public String mosicUrl(String url,Map<String,String> params){
        StringBuffer buffer=new StringBuffer(url);
        Set<String> keys = params.keySet();
        buffer.append("?");
        for (String key:keys) {
            String value = params.get(key);
            buffer.append(key).append("=").append(value).append("&");
        }
        url = buffer.substring(0, buffer.length() - 1);
        return url;
    }
    private void addHeader(Request.Builder builder,Map<String,String> headers){
        Set<String> keys = headers.keySet();
        for (String key:keys) {
            String value = headers.get(key);
            builder.addHeader(key,value);
        }
    }
    public <T>T getGeneric(String result,HttpCallback<T> callback){
        Gson gson = new Gson();
        Type[] types = callback.getClass().getGenericInterfaces();
        Type[] arguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = arguments[0];
        if (String.class.getName().equals(type)){
            return (T) result;
        }
        T t = gson.fromJson(result, type);
        return t;
    }
    private void addBody(FormBody.Builder builder, Map<String,String> params){
        Set<String> keys = params.keySet();
        for (String key:keys) {
            String value = params.get(key);
            builder.add(key,value);
        }
    }
}
