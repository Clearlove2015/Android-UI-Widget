package com.aron.android_ui_widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.lv)
    ListView lv;

    List<PersonBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initListView(lv);
    }

    private void initListView(ListView lv) {
        mData = new ArrayList<>();
        PersonBean bean = new PersonBean("Jack", "25", "shanghai.china");
        for (int i = 0; i < 20; i++) {
            mData.add(bean);
        }

        lv.setAdapter(new MyListViewAdapter(this, mData));
        //item点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "item " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
