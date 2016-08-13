package com.example.viewpager;

import android.content.Intent;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager page;
    List<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        page = (ViewPager) findViewById(R.id.viewpager);
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        final ImageView[] dd = {imageView1,imageView2,imageView3};
        final View view1 = getLayoutInflater().from(this).inflate(R.layout.view1,null);
        View view2 = getLayoutInflater().from(this).inflate(R.layout.view2,null);
        View view3 = getLayoutInflater().from(this).inflate(R.layout.view3,null);
        final List<String> title = new ArrayList<String>();
        title.add("one1");
        title.add("two1");
        title.add("third1");
        list = new ArrayList<View>();
        list.add(view1);
        list.add(view2);
        list.add(view3);
        Button button = (Button) view3.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        final PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(list.get(position),0);

                return list.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));

            }

            @Override
            public int getItemPosition(Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        };
        page.setAdapter(pagerAdapter);
        page.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<dd.length;i++) {
                    if (position == i) {
                        dd[i].setImageResource(R.mipmap.shi);
                    }else {
                        dd[i].setImageResource(R.mipmap.kong);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });
    }
}
