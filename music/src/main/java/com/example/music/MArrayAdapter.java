package com.example.music;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by skysoft on 2016/7/7.
 */
public class MArrayAdapter extends BaseAdapter {
    List<HashMap<String, String>> data;
    Context context;
    public MArrayAdapter(Context context, List<HashMap<String, String>> data, int list_view) {
        this.data = data;
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (null == convertView) {
            view = View.inflate(context, R.layout.list_view, null);
            holder = new ViewHolder();
            holder.image = (ImageView) view.findViewById(R.id.album);
            holder.song_name = (TextView) view.findViewById(R.id.song_name);
            holder.singer = (TextView) view.findViewById(R.id.singer);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        // 直接操作holder中的成员变量即可，不需要每次都findViewById
         holder.image.setImageBitmap(MediaUtil.getArtwork(context,
                 Long.valueOf(data.get(position).get("id")),
                 Long.valueOf(data.get(position).get("albumid")),true));
        holder.song_name.setText((String) data.get(position).get("title"));
        holder.singer.setText((String) data.get(position).get("Artist"));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PlayerMusic.class);
                intent.putExtra("path",data.get(position).get("path"));
                context.startActivity(intent);
            }
        });
        return view;
    }
    class ViewHolder {
        ImageView image;
        //ProgressBar picture2;
        TextView song_name,singer;
    }


}
