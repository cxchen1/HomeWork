package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager mViewPager;
    private List<View> mViews = new ArrayList<View>();
    private MyPagerAdapter mAdapter = new MyPagerAdapter(mViews);

    // Tab
    private LinearLayout tab_bt1, tab_bt2, tab_bt3, tab_bt4;
    private Button tab_bt11, tab_bt22, tab_bt33, tab_bt44;
    private String s1;
    private String s2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题
        setContentView(R.layout.activity_main3);
        View chat = findViewById(R.id.llChat);
        chat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent2 = new Intent(Main3Activity.this, Main3Activity_Left.class);

                startActivity(intent2);
            }
        });




        Intent intent = getIntent();
         s1 = intent.getStringExtra("user");
         s2 = intent.getStringExtra("pwd");


        View home = findViewById(R.id.mas_top_left);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundleSimple1 = new Bundle();

                bundleSimple1.putString("user", s1);
                bundleSimple1.putString("pwd", s2);
                Intent intent1 = new Intent(Main3Activity.this, Main2Activity.class);
                intent1.putExtras(bundleSimple1);
                startActivity(intent1);
            }
        });
        initButton();
        initEvents();
    }
    //View的滑动事件
    private void initEvents() {

        tab_bt1.setOnClickListener(this);
        tab_bt2.setOnClickListener(this);
        tab_bt3.setOnClickListener(this);
        tab_bt4.setOnClickListener(this);
        //滑动切换页面
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                resetImg();
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    case 0:
                        tab_bt11.setBackgroundColor(Color.parseColor("#FF6EB4"));
                        break;
                    case 1:
                        tab_bt22.setBackgroundColor(Color.parseColor("#FF6EB4"));
                        break;
                    case 2:
                        tab_bt33.setBackgroundColor(Color.parseColor("#FF6EB4"));
                        break;
                    case 3:
                        tab_bt44.setBackgroundColor(Color.parseColor("#FF6EB4"));
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    //实例化控件
    private void initButton() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        // LinearLayout
        tab_bt1 = (LinearLayout) findViewById(R.id.tab_bt1);
        tab_bt2 = (LinearLayout) findViewById(R.id.tab_bt2);
        tab_bt3 = (LinearLayout) findViewById(R.id.tab_bt3);
        tab_bt4 = (LinearLayout) findViewById(R.id.tab_bt4);
        // Button
        tab_bt11 = (Button) findViewById(R.id.tab_bt11);
        tab_bt22 = (Button) findViewById(R.id.tab_bt22);
        tab_bt33 = (Button) findViewById(R.id.tab_bt33);
        tab_bt44 = (Button) findViewById(R.id.tab_bt44);

        LayoutInflater mInflater = LayoutInflater.from(this);
        View tab01 = mInflater.inflate(R.layout.activity_main3_friend, null);
        View tab02 = mInflater.inflate(R.layout.activity_main3_equipment, null);
        View tab03 = mInflater.inflate(R.layout.activity_main3_group, null);
        View tab04 = mInflater.inflate(R.layout.activity_main3_groupchat, null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        mViewPager.setAdapter(mAdapter);
    }

    //Button的点击事件
        @Override
        public void onClick (View view){
        resetImg();
        switch (view.getId()+1) {
            case R.id.tab_bt11:
                mViewPager.setCurrentItem(0);// 跳到第一个页面
                tab_bt11.setBackgroundColor(Color.parseColor("#FF6EB4"));
                break;
            case R.id.tab_bt22:
                mViewPager.setCurrentItem(1);
                tab_bt22.setBackgroundColor(Color.parseColor("#FF6EB4"));
                break;
            case R.id.tab_bt33:
                mViewPager.setCurrentItem(2);
                tab_bt33.setBackgroundColor(Color.parseColor("#FF6EB4"));
                break;
            case R.id.tab_bt44:
                mViewPager.setCurrentItem(3);
                tab_bt44.setBackgroundColor(Color.parseColor("#FF6EB4"));
                break;
            default:
                break;
        }
    }


        // 将所有的button背景色设为白色
        private void resetImg () {
        tab_bt11.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tab_bt22.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tab_bt33.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tab_bt44.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }
    }
