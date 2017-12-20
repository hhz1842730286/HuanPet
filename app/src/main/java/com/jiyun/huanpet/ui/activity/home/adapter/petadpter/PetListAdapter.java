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
import com.jiyun.huanpet.ui.activity.home.bean.Petadd;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/12/13.
 */

public class PetListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Petadd> mArr;
    public PetListAdapter(Context mContext, ArrayList<Petadd> mArr) {
        this.mContext = mContext;
        this.mArr = mArr;
    }

    @Override
    public int getCount() {
        return mArr.size();
    }

    @Override
    public Object getItem(int position) {
        return mArr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     HolderView holderView=null;
     if(convertView==null){
         holderView=new HolderView();
         convertView= LayoutInflater.from(mContext).inflate(R.layout.activty_petlistadpter,null);
         holderView.head_portrait=convertView.findViewById(R.id.head_portrait);
         holderView.Male=convertView.findViewById(R.id.Male);
         holderView.Name=convertView.findViewById(R.id.Name);
         holderView.Content=convertView.findViewById(R.id.Content);
         convertView.setTag(holderView);
     }else {
         holderView= (HolderView) convertView.getTag();
     }
     holderView.Name.setText(mArr.get(position).getPetName());
     holderView.Content.setText(mArr.get(position).getPetInfo());
        Glide.with(mContext).load(mArr.get(position).getPetImage()).into(holderView.head_portrait);
        Glide.with(mContext).load(mArr.get(position).getPetSex()).into(holderView.Male);
        return convertView;
    }
    class HolderView{
        private ImageView head_portrait,Male;
        private TextView Name,Content;
    }
}
