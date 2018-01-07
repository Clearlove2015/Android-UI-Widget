package com.zc.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.zc.viewpager.adapter.MyFragmentPagerAdapter;
import com.zc.viewpager.fragment.FirstFragment;
import com.zc.viewpager.fragment.SecondFragment;
import com.zc.viewpager.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        //viewpager.setAdapter(new MyPagerAdapter(getViews()));
        viewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),getFragments()));
    }

    public List<View> getViews(){
        List<View> views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        View view1 = inflater.inflate(R.layout.vp_item1, null);
        View view2 = inflater.inflate(R.layout.vp_item2, null);
        View view3 = inflater.inflate(R.layout.vp_item3, null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        return views;
    }

    public List<Fragment> getFragments(){
        List<Fragment> fragments = new ArrayList<>();
        Fragment first = new FirstFragment();
        Fragment second = new SecondFragment();
        Fragment third = new ThirdFragment();
        fragments.add(first);
        fragments.add(second);
        fragments.add(third);
        return fragments;
    }

}
