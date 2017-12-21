package com.jiyun.huanpet.ui.activity.home.adapter.petadpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.huanpet.R;
import com.jiyun.huanpet.ui.activity.home.bean.AllAtiity;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/12/18.
 */

public class AdapterListview extends BaseAdapter {
 private  ArrayList<AllAtiity> mArr;
 private Context mContext;

    public AdapterListview(ArrayList<AllAtiity> mArr, Context mContext) {
        this.mArr = mArr;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mArr.size();
    }

    @Override
    public Object getItem(int i) {
        return mArr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HolderView holderView=null;
        if(view==null){
            holderView=new HolderView();
            view=LayoutInflater.from(mContext).inflate(R.layout.all_adapterlistview,null);
            holderView.CircleImage=view.findViewById(R.id.CircleImage);
            holderView.CircleImageview=view.findViewById(R.id.CircleImageview);
            holderView.Relate=view.findViewById(R.id.Relate);
            holderView.Achieve=view.findViewById(R.id.Achieve);
            view.setTag(holderView);
        }else {
            holderView= (HolderView) view.getTag();
        }
        Glide.with(mContext).load(mArr.get(i).getNameImage()).into(holderView.CircleImage);
        holderView.Relate.setImageResource(mArr.get(i).getPinjieImage());
        Glide.with(mContext).load(mArr.get(i).getPetImage()).into(holderView.CircleImageview);
        holderView.Achieve.setText(mArr.get(i).getWangeng());
        return view;
    }
     class HolderView{
        private ImageView Relate, CircleImage,CircleImageview;
        private TextView Achieve;
     }
}
