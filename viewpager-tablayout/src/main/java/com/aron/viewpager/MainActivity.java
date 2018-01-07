package com.aron.viewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.aron.viewpager.adapter.MyPagerAdapter;
import com.aron.viewpager.fragment.IndexFragment;
import com.aron.viewpager.fragment.MeFragment;
import com.aron.viewpager.fragment.MsgFragment;
import com.aron.viewpager.fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabs;
    private ViewPager viewPager;

    public void init(){
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        init();
    }

    public void setupViewPager(ViewPager viewPager){
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new IndexFragment(),"首页");
        adapter.addFragment(new VideoFragment(),"视频");
        adapter.addFragment(new MsgFragment(),"消息");
        adapter.addFragment(new MeFragment(),"我的");
        viewPager.setAdapter(adapter);
    }

}
