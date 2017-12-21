package com.jiyun.huanpet.presenter.indentpresenter;

import android.util.Log;

import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.Indent.IIndentModle;
import com.jiyun.huanpet.model.biz.Indent.IndentModle;

/**
 * Created by Lenovo on 2017/12/18.
 */

public class Indentpresenter implements IIndentpresenter.Presenter {
   private IIndentModle iIndentModle;
   private IIndentpresenter.View indentview;
    public Indentpresenter() {
        this.iIndentModle = new IndentModle();

    }

    @Override
    public void attchTo(IIndentpresenter.View view) {
        indentview=view;
    }

    @Override
    public void detach() {

    }

    @Override
    public void indent(String userId, String orderState) {
         iIndentModle.indent(userId, orderState, new HttpCallback<String>() {
             @Override
             public void success(String s) {

             }

             @Override
             public void error(String error) {

             }
         });
    }

    @Override
    public void particulars() {
        iIndentModle.particulars( new HttpCallback<Object>() {
            @Override
            public void success(Object o) {
                Log.e("33333333333333",o.toString());
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
