package com.jiyun.huanpet.ui.activity.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.ui.activity.home.bean.CommentBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lh on 2017/12/22.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{
    private Context mCon;
    private List<CommentBean.DescBean> beans;

    public CommentAdapter(Context mCon, List<CommentBean.DescBean> beans) {
        this.mCon = mCon;
        this.beans = beans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCon).inflate(R.layout.fostercomment_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String userName = beans.get(position).getUserName();
        String description = beans.get(position).getDescription();
        String createTime = beans.get(position).getCreateTime();
        holder.comment_name.setText(userName);
        holder.comment_comment.setText(description);
        holder.comment_time.setText(createTime);
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView circleImageView;
        private TextView comment_name,comment_comment,comment_time;
        public ViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circleImageView);
            comment_name = itemView.findViewById(R.id.comment_name);
            comment_comment = itemView.findViewById(R.id.comment_comment);
            comment_time = itemView.findViewById(R.id.comment_time);
        }
    }
}
