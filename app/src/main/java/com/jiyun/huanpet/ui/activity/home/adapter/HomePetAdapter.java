package com.jiyun.huanpet.ui.activity.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.ui.activity.home.bean.PetTypeBean;

import java.util.List;

/**
 * Created by lh on 2017/12/20.
 */

public class HomePetAdapter extends RecyclerView.Adapter<HomePetAdapter.ViewHolder> {
    private List<PetTypeBean.DescBean> petList;
    private Context mCon;

    public HomePetAdapter(List<PetTypeBean.DescBean> petList, Context mCon) {
        this.petList = petList;
        this.mCon = mCon;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCon).inflate(R.layout.homerecyclerview_item,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String petPrice = petList.get(position).getPetPrice();
        String typeName = petList.get(position).getTypeName();
        holder.name_text.setText(petPrice);
        holder.jiage_text.setText(typeName);

    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
         private TextView name_text,jiage_text,distance;
         private ImageView dingwei;
        public ViewHolder(View itemView) {
            super(itemView);
            name_text = itemView.findViewById(R.id.name_text);
            jiage_text = itemView.findViewById(R.id.jiage_text);
            distance = itemView.findViewById(R.id.distance);
            distance.setVisibility(View.GONE);
            dingwei = itemView.findViewById(R.id.dingwei);
            dingwei.setVisibility(View.GONE);
        }
    }
}
