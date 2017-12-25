package com.jiyun.huanpet.presenter.comment;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.login.HomeLogin;
import com.jiyun.huanpet.model.biz.login.IHomeLogin;
import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.activity.home.bean.CommentBean;
import com.jiyun.huanpet.ui.base.BaseView;
import com.jiyun.huanpet.view.CommentView;

/**
 * Created by lh on 2017/12/22.
 */

public class CommentPresenter implements ICommentPresenter,BasePresenter {
    private IHomeLogin iHomeLogin;
    private CommentView commentView;

    public CommentPresenter(CommentView commentView) {
        this.commentView = commentView;
        this.iHomeLogin = new HomeLogin();
    }

    @Override
    public void comment(String usersId) {
        iHomeLogin.comment(usersId, new HttpCallback() {
            @Override
            public void success(Object o) {
                String string = o.toString();
                Gson gson = new Gson();
                CommentBean commentBean = gson.fromJson(string, CommentBean.class);
                commentView.comment(commentBean);
            }

            @Override
            public void error(String error) {

            }
        });
    }

    @Override
    public void attchTo(BaseView baseView) {

    }

    @Override
    public void detach() {

    }
}
