package com.example.ui_practise;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

public class MainActivity extends Activity {
   ListView listView;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file);/////////////////
        listView = (ListView) findViewById(R.id.list);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,getData(),R.layout.list_item,new String[]{"picture1","text1","text2"},new int[]{R.id.picture1,R.id.text,R.id.zhan});
        listView.setAdapter(simpleAdapter);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
       // initPager();
    }

   /* private void initPager() {
        List<View> mList = new ArrayList<View>();
        View item1 = View.inflate(this,R.layout.file,null);
        View item2 = View.inflate(this,R.layout.file,null);
        mList.add(item1);
        mList.add(item2);
        MViewPagerAdapter adapter = new MViewPagerAdapter(mList);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(adapter);
        viewPager.setCurrentItem(1);
    }*/

    private List<Map<String,Object>> getData() {
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("picture1",R.drawable.neibucunchu);
        map.put("text1","内部存储");
        map.put("text2","16GB/32GB");
        data.add(map);

       map = new HashMap<String,Object>();
        map.put("picture1",R.drawable.sd);
        map.put("text1","SD");
        map.put("text2","16GB/32GB");
        data.add(map);

         map = new HashMap<String,Object>();
        map.put("picture1",R.drawable.usb);
        map.put("text1","USB1");
        map.put("text2","16GB/32GB");
        data.add(map);

        map = new HashMap<String,Object>();
        map.put("picture1",R.drawable.usb);
        map.put("text1","USB2");
        map.put("text2","16GB/32GB");
        data.add(map);

        return data;
    }

    /*private class MViewPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener{
        private List<View> mList;
        public MViewPagerAdapter(List<View> mList) {
            this.mList = mList;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }*/
}
