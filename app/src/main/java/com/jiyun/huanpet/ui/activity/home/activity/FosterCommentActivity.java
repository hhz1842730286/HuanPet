package com.jiyun.huanpet.ui.activity.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.comment.CommentPresenter;
import com.jiyun.huanpet.presenter.comment.ICommentPresenter;
import com.jiyun.huanpet.ui.activity.home.adapter.CommentAdapter;
import com.jiyun.huanpet.ui.activity.home.bean.CommentBean;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.jiyun.huanpet.view.CommentView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lh on 2017/12/22.
 */

public class FosterCommentActivity extends BaseActivity<CommentPresenter> implements CommentView {


    private TextView comment_text;
    private RecyclerView comment_recycleview;
    private CommentPresenter commentPresenter;
    private String id;
    private CommentAdapter commentAdapter;
    private List<CommentBean.DescBean> descBeans;
    private Context mCon;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fostercomment;
    }

    @Override
    protected void findViewById() {
        mCon = FosterCommentActivity.this;
        commentPresenter = new CommentPresenter(this);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        id = intent.getStringExtra("id");
        comment_text = (TextView) findViewById(R.id.comment_text);
        comment_text.setText(name);
        comment_recycleview = (RecyclerView) findViewById(R.id.comment_recycleview);
        descBeans = new ArrayList<>();

        comment_recycleview.setLayoutManager(new LinearLayoutManager(mCon));
        comment_recycleview.addItemDecoration(new DividerItemDecoration(mCon,DividerItemDecoration.VERTICAL));
        commentAdapter = new CommentAdapter(mCon,descBeans);
        comment_recycleview.setAdapter(commentAdapter);


    }

    @Override
    protected void init() {
        commentPresenter.comment(id);
    }

    @Override
    protected void loadData() {

    }


    @Override
    public void comment(CommentBean commentBean) {
        descBeans.addAll(commentBean.getDesc());
        commentAdapter.notifyDataSetChanged();
    }
}
