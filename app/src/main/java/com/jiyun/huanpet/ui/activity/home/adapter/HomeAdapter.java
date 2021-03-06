package com.jiyun.huanpet.ui.activity.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.jiyun.huanpet.R;
import com.jiyun.huanpet.ui.activity.home.bean.FuJinBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by lh on 2017/12/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> implements View.OnClickListener{
    private List<FuJinBean.DescBean> list;
    private Context mCon;

    public HomeAdapter(List<FuJinBean.DescBean> list, Context mCon) {
        this.list = list;
        this.mCon = mCon;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCon).inflate(R.layout.homerecyclerview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String family = list.get(position).getFamily();
        String address = list.get(position).getAddress();
        String userImage = list.get(position).getUserImage();
        int distance = list.get(position).getDistance();
        double price = list.get(position).getPrice();
        holder.name.setText(family);
        holder.jianjie.setText(address);
        holder.distance.setText("距"+distance+"米");
        holder.jiage.setText("¥"+price+"起");
        Glide.with(mCon).load(userImage).into(holder.circleImageView);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, jianjie, jiage,distance;
        private CircleImageView circleImageView;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_text);
            jianjie = itemView.findViewById(R.id.jianjie_text);
            circleImageView = itemView.findViewById(R.id.home_item_image);
            jiage = itemView.findViewById(R.id.jiage_text);
            distance = itemView.findViewById(R.id.distance);

        }
    }
    public interface Onclick{
        void oncli(View view,int position);
    }

    public Onclick onclicklenter;
    @Override
    public void onClick(View v) {
        if(onclicklenter!=null){
            onclicklenter.oncli(v, (int) v.getTag());
        }
    }
    public void setOnclicklenter(Onclick onclicklenter){
        this.onclicklenter = onclicklenter;
    }
}
