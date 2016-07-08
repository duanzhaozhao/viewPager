package com.example.ui_practise;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by skysoft on 2016/7/6.
 */
class MyAdapter extends BaseAdapter {
    List<Map<String,Object>> data;
    Context context;
    public MyAdapter(Context context, List<Map<String,Object>> data) {
     this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (null == convertView) {
            view = View.inflate(context, R.layout.list_item, null);
            holder = new ViewHolder();
            holder.picture1 = (ImageView) view.findViewById(R.id.picture1);
           // holder.picture2 = (ProgressBar) view.findViewById(R.id.picture2);
            holder.text1 = (TextView) view.findViewById(R.id.text);
           // holder.text2 = (TextView) view.findViewById(R.id.zhan);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        // 直接操作holder中的成员变量即可，不需要每次都findViewById
       // holder.picture1.setImageResource((Integer) data.get(position).get("picture1"));
        holder.text1.setText((String) data.get(position).get("text1"));
        return view;
    }
    class ViewHolder {
        ImageView picture1;
        //ProgressBar picture2;
        TextView text1,text2;
    }
}
