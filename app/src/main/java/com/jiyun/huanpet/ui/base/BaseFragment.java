package com.jiyun.huanpet.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by mengYao on 2017/12/7.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView{
    private boolean isVisibility;
    private boolean isViewCreated;
    private Bundle params;
    private P mPresenter;
    public Bundle getParams() {
        return params;
    }

    public void setParams(Bundle params) {
        this.params = params;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        if (view!=null)
            isViewCreated=true;
        mPresenter=getPresenter();
        findViewById(view);
        init();
        lazyLoad();
        return view;
    }

    protected abstract  int getLayoutId();

    protected abstract void findViewById(View view);

    protected abstract void init();

    protected abstract void loadData();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            isVisibility=isVisibleToUser;
        }else{
            isVisibility=false;
        }
    }

    private void lazyLoad(){
        if (isViewCreated&&isVisibility){
            loadData();
            isViewCreated=false;
            isVisibility=false;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }
    private P getPresenter(){
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type[] arguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Class<P> pClass =(Class<P>) arguments[0];
        try {
            return pClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
