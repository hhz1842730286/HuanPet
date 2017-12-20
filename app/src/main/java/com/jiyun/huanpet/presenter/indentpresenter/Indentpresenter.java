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
   private IIndentpresenter.View view;
    public Indentpresenter( IIndentpresenter.View view) {
        this.iIndentModle = new IndentModle();
        this.view = view;
    }

    @Override
    public void attchTo(IIndentpresenter.View view) {

    }

    @Override
    public void detach() {

    }

    @Override
    public void indent(String userId, int orderState) {
         iIndentModle.indent(userId, orderState, new HttpCallback<String>() {
             @Override
             public void success(String s) {
                 Log.e("EEEEEEEEEEEEEE",s);
             }

             @Override
             public void error(String error) {

             }
         });
    }
}
