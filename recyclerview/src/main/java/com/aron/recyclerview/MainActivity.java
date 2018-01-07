package com.aron.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    List<PersonBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRecyclerView(recyclerview);
    }

    private void initRecyclerView(RecyclerView recyclerview) {
        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            PersonBean bean = new PersonBean("Jack", "25", "shanghai.china");
            mData.add(bean);
        }

        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //设置item间距
        recyclerview.addItemDecoration(new SpaceItemDecoration(10));
        recyclerview.setAdapter(new MyRecyclerViewAdapter(this, mData));
    }
}
