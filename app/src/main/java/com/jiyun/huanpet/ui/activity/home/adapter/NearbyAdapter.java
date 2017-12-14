package com.jiyun.huanpet.ui.activity.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.ui.activity.home.bean.Person;

import java.util.List;

/**
 * Created by lh on 2017/12/12.
 */

public class NearbyAdapter extends BaseAdapter {
    private Context mCon;
    private List<Person> list;

    public NearbyAdapter(Context mCon, List<Person> list) {
        this.mCon = mCon;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mCon).inflate(R.layout.nearbylist_item,null);
             holder.mtext = convertView.findViewById(R.id.list_item);
             holder.mChe = convertView.findViewById(R.id.list_chebox);
             convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }       //判断CheckBox的状态

        if(list.get(position).isChecked()){
            holder.mChe.setChecked(true);//选中
               if(holder.mtext.getText().toString().equals(list.get(position).getTitle())){
                  holder.mtext.setTextColor(Color.parseColor("#FFFFA822"));
//                   TextView item = (TextView) getItem(position);
//                   item.setTextColor(Color.parseColor("#FFFFA822"));
               }
        }else {
            holder.mChe.setChecked(false);//未选中
            holder.mtext.setTextColor(Color.parseColor("#FF979797"));
        }


        holder.mtext.setText(list.get(position).getTitle());

        return convertView;
    }
    class ViewHolder{
        private CheckBox mChe;
        private TextView mtext;

    }
}
