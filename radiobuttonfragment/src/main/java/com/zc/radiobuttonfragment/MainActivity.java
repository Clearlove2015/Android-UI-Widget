package com.zc.radiobuttonfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zc.radiobuttonfragment.fragment.FindeFragment;
import com.zc.radiobuttonfragment.fragment.IndexFragment;
import com.zc.radiobuttonfragment.fragment.MsgFragment;
import com.zc.radiobuttonfragment.fragment.MyFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.frame)
    FrameLayout frame;
    @Bind(R.id.rb_index)
    RadioButton rbIndex;
    @Bind(R.id.rb_msg)
    RadioButton rbMsg;
    @Bind(R.id.rb_find)
    RadioButton rbFind;
    @Bind(R.id.rb_my)
    RadioButton rbMy;
    @Bind(R.id.group)
    RadioGroup group;

    IndexFragment indexFragment;
    MsgFragment msgFragment;
    FindeFragment findeFragment;
    MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        initFragment();
        initListener();
    }

    public void initFragment() {
        indexFragment = new IndexFragment();
        msgFragment = new MsgFragment();
        findeFragment = new FindeFragment();
        myFragment = new MyFragment();

        //默认显示页面，倒序添加fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, myFragment)
                .add(R.id.frame, findeFragment)
                .add(R.id.frame, msgFragment)
                .add(R.id.frame, indexFragment)
                .commit();

    }

    public void initListener() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_index:
                        getSupportFragmentManager().beginTransaction()
                                .show(indexFragment)
                                .hide(msgFragment)
                                .hide(findeFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.rb_msg:
                        getSupportFragmentManager().beginTransaction()
                                .hide(indexFragment)
                                .show(msgFragment)
                                .hide(findeFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.rb_find:
                        getSupportFragmentManager().beginTransaction()
                                .hide(indexFragment)
                                .hide(msgFragment)
                                .show(findeFragment)
                                .hide(myFragment)
                                .commit();
                        break;
                    case R.id.rb_my:
                        getSupportFragmentManager().beginTransaction()
                                .hide(indexFragment)
                                .hide(msgFragment)
                                .hide(findeFragment)
                                .show(myFragment)
                                .commit();
                        break;
                }
            }
        });

        //默认选中页面
        group.check(R.id.rb_index);
    }

}
